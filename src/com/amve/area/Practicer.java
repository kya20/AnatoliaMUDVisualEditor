package com.amve.area;

import com.amve.globals.GlobalVariables.PracticeGroup;

public class Practicer {
	private String vNum;
	private PracticeGroup practiceGroup;
	
	public String getvNum() {
		return vNum;
	}
	public void setvNum(String vNum) {
		this.vNum = vNum;
	}
	public PracticeGroup getPracticeGroup() {
		return practiceGroup;
	}
	public void setPracticeGroup(PracticeGroup practiceGroup) {
		this.practiceGroup = practiceGroup;
	}
}