package com.courage.ccu_monitor.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {
	
	public static boolean createFile(String crepath){
		File file = new File(crepath);
		boolean pd = false;
		if(!file.exists()){
			pd = file.mkdirs();
		}else{
			pd = true;
		}
		return pd;
	}
	
	public static boolean deleteFile(String delpath)
			throws FileNotFoundException, IOException {
		try {

			File file = new File(delpath);
			if (!file.isDirectory()) {
				System.out.println("1");
				file.delete();
			} else if (file.isDirectory()) {
				System.out.println("2");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delpath + "\\" + filelist[i]);
					if (!delfile.isDirectory()) {
						System.out.println("path=" + delfile.getPath());
						System.out.println("absolutepath="
								+ delfile.getAbsolutePath());
						System.out.println("name=" + delfile.getName());
						delfile.delete();
						System.out.println("删除文件成功");
					} else if (delfile.isDirectory()) {
						deleteFile(delpath + "\\" + filelist[i]);
					}
				}
				file.delete();
			}
		} catch (FileNotFoundException e) {
			System.out.println("deletefile()  Exception:" + e.getMessage());
		}
		return true;
	}

	public static void main(String[] args) {
		File file = new File("indexdir");
		if (!file.exists()) {
			file.mkdirs();
		}

		// try {
		// System.out.println(deletefile("indexdir"));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}
