package com.amve.utils;

public class Pair {
	private Integer key;
	private String value;
	
	public Pair(String value, int key) {
		this.key = key;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	public Integer getKey() {
		return key;
	}
}
