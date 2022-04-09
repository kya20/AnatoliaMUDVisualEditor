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
		int val = -1;
		for (int i = 0; i < GlobalVariables.LETTER_TRANSLATIONS.size(); i++) {
			if (GlobalVariables.LETTER_TRANSLATIONS.get(i).getValue() == code) {
				val = GlobalVariables.LETTER_TRANSLATIONS.get(i).getKey();
			}
		}
		return val;
	}
}
