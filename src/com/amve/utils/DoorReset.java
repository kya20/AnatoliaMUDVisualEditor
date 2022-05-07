package com.amve.utils;

import com.amve.globals.GlobalVariables.ExitDirection;
import com.amve.globals.GlobalVariables.ItemExtra;
import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.DoorFlag;

import java.util.List;

public class DoorReset {
	
	public String roomVNum;
	public ExitDirection exitDirection;
	public List<DoorFlag> doorFlags;

	public DoorReset(String roomVNum, String exitDirection, String doorFlags) {
		this.roomVNum = roomVNum;
		this.exitDirection = ExitDirection.valueOfNum(Integer.parseInt(exitDirection));
		
		if (!"0".equals(doorFlags)) {
			for (int i = 0; i < doorFlags.length() ; i++) {
				if (Character.isUpperCase(doorFlags.charAt(i)))
					this.doorFlags.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(doorFlags.substring(i, i+1))));
				else {
					this.doorFlags.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(doorFlags.substring(i, i+2))));
					i++;
				}
			}
		}
	}

}
