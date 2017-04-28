package com.courage.ccu_monitor.util.lucene;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.IOUtils;

import java.io.Reader;
import java.io.StringReader;

public class IKAnalyzer6x extends Analyzer {
	private boolean useSmart;

	public boolean useSmart() {
		return useSmart;
	}

	public void setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
	}

	/**
	 * IK鍒嗚瘝鍣↙ucene Analyzer鎺ュ彛瀹炵幇绫�
	 * 
	 * 榛樿缁嗙矑搴﹀垏鍒嗙畻娉�
	 */
	public IKAnalyzer6x() {
		this(false);
	}

	/**
	 * IK鍒嗚瘝鍣↙ucene Analyzer鎺ュ彛瀹炵幇绫�
	 * 
	 * @param useSmart
	 *            褰撲负true鏃讹紝鍒嗚瘝鍣ㄨ繘琛屾櫤鑳藉垏鍒�
	 */
	public IKAnalyzer6x(boolean useSmart) {
		super();
		this.useSmart = useSmart;
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		Reader reader = null;
		try {
			reader = new StringReader(fieldName);
			IKTokenizer6x it = new IKTokenizer6x(reader);
			return new Analyzer.TokenStreamComponents(it);
		} finally {
			IOUtils.closeWhileHandlingException(reader);
		}
	}
}
