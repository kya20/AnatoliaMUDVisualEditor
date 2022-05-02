package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

import com.amve.globals.GlobalVariables.DoorState;
import com.amve.globals.GlobalVariables.ExitDirection;

public class Exit {
	
	public ExitDirection exitDirection;
	public String exitDescription = "";
	public List<String> keyWords = new ArrayList<>();
	public DoorState doorState;
	public String roomVNum;
	public String keyVNum;

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

}
