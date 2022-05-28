package com.amve.utils;

import com.amve.globals.GlobalVariables.EquipSlot;

public class EquipReset {
	
	public String objectVNum;
	public EquipSlot equipSlot;
	public String mobileVNum;

	public EquipReset(String objectVNum, String equipSlot, String mobileVNum) {
		this.objectVNum = objectVNum;
		this.equipSlot = EquipSlot.valueOfNum(Integer.parseInt(equipSlot));
		this.mobileVNum = mobileVNum;
	}

	@Override
	public String toString() {
		return "E 0 " + this.objectVNum + " 0 " + this.equipSlot.num + "\n";
	}
}
