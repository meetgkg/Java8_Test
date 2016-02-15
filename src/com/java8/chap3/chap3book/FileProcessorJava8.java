package com.java8.chap3.chap3book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessorJava8 {

	public static void main(String[] args) throws IOException{
		String oneLine = processFile( (BufferedReader br) -> br.readLine() );
		System.out.println("Printing One Line");
		System.out.println(oneLine);
		
		
		String twoLine = processFile( (BufferedReader br) -> br.readLine() + "\n" + br.readLine() );
		System.out.println("Printing Two Line");
		System.out.println(twoLine);

	}
	
	public static String processFile(BuffererdReaderProcessor p) throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("File.txt"));
			return p.process(br);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			br.close();
		}
		return "";
	}

}
