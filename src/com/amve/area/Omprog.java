package com.amve.area;

import java.security.InvalidParameterException;

public class Omprog {
	private boolean type; // false for Mobile, true for Object
	private String vNum;
	private String progType;
	private String functionName;
	
	public void setType(String typeKeyWord) { // give "M" or "O"
		if ("M".equals(typeKeyWord))
			type = false;
		else if ("O".equals(typeKeyWord))
			type = true;
		else throw new InvalidParameterException("In function setType, String typeKeyWord should be \"M\" or \"O\".");
	}
	public boolean isObject() {
		return type;
	}
	public boolean isMobile() {
		return !type;
	}
	public String getvNum() {
		return vNum;
	}
	public void setvNum(String vNum) {
		this.vNum = vNum;
	}
	public String getProgType() {
		return progType;
	}
	public void setProgType(String progType) {
		this.progType = progType;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(type) sb.append("O ");  //Object
		else sb.append("M "); //Mobile
		sb.append(this.vNum + " " + this.progType + " " + this.functionName + "\n");
		return sb.toString();
	}
}