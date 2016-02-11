package com.java8.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	public static void main(String[] args) throws IOException{
		String s = processFile();
		System.out.println(s);

	}
	
	//Not complete code, we shud put everything inside in while(br.readLine)
	public static String processFile() throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("File.txt"));
			return br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			br.close();
		}
		return "";
	}

}
