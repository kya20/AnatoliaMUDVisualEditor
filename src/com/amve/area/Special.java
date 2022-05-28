package com.amve.area;

import com.amve.globals.GlobalVariables.SpecialType;

public class Special {
	private String mobVNum;
	private SpecialType special;
	
	public String getMobVNum() {
		return mobVNum;
	}
	public void setMobVNum(String mobVNum) {
		this.mobVNum = mobVNum;
	}
	public SpecialType getSpecial() {
		return special;
	}
	public void setSpecial(SpecialType special) {
		this.special = special;
	}
	
	@Override
	public String toString() {
		return "M " + this.mobVNum + " " + this.special.name + "\n";
	}
}