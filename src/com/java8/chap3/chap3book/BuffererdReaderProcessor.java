package com.java8.chap3.chap3book;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BuffererdReaderProcessor {
	
	public String process(BufferedReader bf) throws IOException;
	
}
