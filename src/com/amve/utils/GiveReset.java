package com.amve.utils;

public class GiveReset {
	
	public String objectVNum;
	public String mobileVNum;

	public GiveReset(String objectVNum, String mobileVNum) {
		this.objectVNum = objectVNum;
		this.mobileVNum = mobileVNum;
	}

	@Override
	public String toString() {
		return "G 0 " + this.objectVNum + " 0\n";
	}
}
