package com.courage.ccu_monitor.util.lucene;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class GetTopTerms {
	public static void main(String[] args)  {
			// 读取  分词结果
			Map<String, Integer> map = getTermByMap("indexdir");
			// 按value排序
			List<Entry<String, Integer>> sortedMap = sortTermsMap(map);
			// 获取前几个词汇
			getTopN(sortedMap, 10);
	}

	public static Map<String, Integer>  getTermByMap(String inexPath){
		Map<String, Integer> map = null;
		try {
			Directory directory = FSDirectory.open(Paths.get(inexPath));
			IndexReader reader = DirectoryReader.open(directory);
			// 因为只索引了一个文档，所以DocID为0，通过getTermVector获取content字段的词项
			Terms terms = reader.getTermVector(0, "content");
			// 遍历词项
			TermsEnum termsEnum = terms.iterator();
			BytesRef thisTerm = null;
			map = new HashMap<String, Integer>();
			while ((thisTerm = termsEnum.next()) != null) {
				// 词项
				String termText = thisTerm.utf8ToString();
				// 通过totalTermFreq()方法获取词项频率
				map.put(termText, (int) termsEnum.totalTermFreq());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static List<Entry<String, Integer>> sortTermsMap(Map<String, Integer> map) {
		List<Entry<String, Integer>> sortedMap = new ArrayList<Entry<String, Integer>>(
				map.entrySet());
		Collections.sort(sortedMap,
				new Comparator<Entry<String, Integer>>() {
					public int compare(Entry<String, Integer> o1,
							Entry<String, Integer> o2) {
						return (o2.getValue() - o1.getValue());
					}
				});
		return sortedMap;
	}

	// 获取top-n
	public static void getTopN(List<Entry<String, Integer>> sortedMap, int N) {
		for (int i = 0; i < N; i++) {
			System.out.println(sortedMap.get(i).getKey() + ":"
					+ sortedMap.get(i).getValue());
		}
	}
}
