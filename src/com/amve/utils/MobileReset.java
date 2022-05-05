package com.amve.utils;

public class MobileReset {
	
	public String mobileVNum;
	public String roomVNum;
	public int globalMobileNumLimit;
	public int localMobileNumLimit;
	
	public MobileReset(String mobileVNum, String roomVNum, String globalMobileNumLimit, String localMobileNumLimit) {
		this.mobileVNum = mobileVNum;
		this.roomVNum = roomVNum;
		this.globalMobileNumLimit = Integer.parseInt(globalMobileNumLimit);
		this.localMobileNumLimit = Integer.parseInt(localMobileNumLimit);
	}

}
