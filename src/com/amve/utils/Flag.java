package com.amve.utils;

import com.amve.globals.GlobalVariables;

public class Flag {
	public String name = null;
	public String tooltip = null;
	public String code = null;
	
	public Flag(String name, String tooltip, String code) {
		this.name = name;
		this.tooltip = tooltip;
		this.code = code;
	}
	public Flag(String name, String code) {
		this.name = name;
		tooltip = null;
		this.code = code;
	}
	
	public Integer getNumericalCode() {
		int val = 0;
		for (int i = 0; i < this.code.length() ; i++) {
			if (Character.isUpperCase(code.charAt(i))) {
				val += GlobalVariables.LETTER_TRANSLATIONS.get(code.substring(i, i+1));
			}
			else {
				val += GlobalVariables.LETTER_TRANSLATIONS.get(code.substring(i, i+2));
				i++;
			}
		}
		return val;
	}
}
