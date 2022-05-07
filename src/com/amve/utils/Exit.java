package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.DoorFlag;
import com.amve.globals.GlobalVariables.DoorState;
import com.amve.globals.GlobalVariables.ExitDirection;
import com.amve.globals.GlobalVariables.ItemExtra;

public class Exit {
	
	public ExitDirection exitDirection;
	public String exitDescription = "";
	public List<String> keyWords = new ArrayList<>();
	public DoorState doorState;
	public String roomVNum;
	public String keyVNum;
	
	// adding doorflags from RESETS
	
	public List<DoorFlag> doorFlags;

	public Exit(ExitDirection exitDirection, String exitDescription, 
			List<String> keyWords, DoorState doorState, String roomVNum, String keyVNum) {
		this.exitDirection = exitDirection;
		this.exitDescription = exitDescription;
		this.keyWords = keyWords;
		this.doorState = doorState;
		this.roomVNum = roomVNum;
		this.keyVNum = keyVNum;
	}
	
	public Exit(ExitDirection exitDirection, String exitDescription, 
			DoorState doorState, String roomVNum, String keyVNum) {
		this.exitDirection = exitDirection;
		this.exitDescription = exitDescription;
		this.doorState = doorState;
		this.roomVNum = roomVNum;
		this.keyVNum = keyVNum;
	}
	
	public void setDoorFlags(String doorFlags) {
		if (this.doorFlags == null) 
			this.doorFlags = new ArrayList<>();
		this.doorFlags.add(DoorFlag.valueOfNum(Integer.parseInt(doorFlags)));
	}

}
