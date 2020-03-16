package com.czq.Imooc.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
	String filepath;
	Properties properties;
	public ProUtil(String filepath) {
		this.filepath = filepath;
		RedProperties();
	}

	private Properties RedProperties() {
		properties = new Properties();
		BufferedInputStream buf = null;
			try {
				buf = new BufferedInputStream(new FileInputStream(filepath));
				properties.load(buf);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return properties;
	}
	
	public String GetPro(String key) {
		String name;
		if(properties.containsKey(key)) {
			return properties.getProperty(key);
		}else{
			return "";
		}
	}
	
	public int GetLines() {
		return properties.size();
	}
	

	public static void main(String[] args) {

	}
	
	public static void threadSleep(double d) {
		try {
			Thread.sleep((long) (d * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
