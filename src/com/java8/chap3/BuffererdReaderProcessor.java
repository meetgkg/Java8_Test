package com.java8.chap3;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BuffererdReaderProcessor {
	
	public String process(BufferedReader bf) throws IOException;
	
}
