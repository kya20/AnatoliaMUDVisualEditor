package com.amve.utils;

public class PutReset {
	
	public String containedVNum;
	public String containerVNum;
	public String containedNumber;

	public PutReset(String containedVNum, String containerVNum, String containedNumber) {
		this.containedVNum = containedVNum;
		this.containerVNum = containerVNum;
		this.containedNumber = containedNumber;
	}

	@Override
	public String toString() {
		return "P 0 " + this.containedVNum + " 0 " + this.containerVNum + " " + this.containedNumber + "\n";
	}
}
