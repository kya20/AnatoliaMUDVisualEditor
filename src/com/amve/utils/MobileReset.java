package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

public class MobileReset {
	
	public String mobileVNum;
	public String roomVNum;
	public int globalMobileNumLimit;
	public int localMobileNumLimit;
	
	public List<GiveReset> giveResets;
	public List<EquipReset> equipResets;
	
	public MobileReset(String mobileVNum, String roomVNum, String globalMobileNumLimit, String localMobileNumLimit) {
		this.mobileVNum = mobileVNum;
		this.roomVNum = roomVNum;
		this.globalMobileNumLimit = Integer.parseInt(globalMobileNumLimit);
		this.localMobileNumLimit = Integer.parseInt(localMobileNumLimit);
	}
	
	public List<GiveReset> getGiveResets() {
		return giveResets;
	}
	
	public void addGiveReset(GiveReset giveReset) {
		if (giveResets == null)
			giveResets = new ArrayList<>();
		giveResets.add(giveReset);
	}
	
	public List<EquipReset> getEquipResets() {
		return equipResets;
	}
	
	public void addEquipReset(EquipReset equipReset) {
		if (equipResets == null)
			equipResets = new ArrayList<>();
		equipResets.add(equipReset);
	}
}
