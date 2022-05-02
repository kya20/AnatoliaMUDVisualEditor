package com.amve.area;

import java.util.*;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.DoorState;
import com.amve.globals.GlobalVariables.ExitDirection;
import com.amve.globals.GlobalVariables.RoomFlag;
import com.amve.globals.GlobalVariables.RoomSector;
import com.amve.globals.GlobalVariables.WeaponFlag;
import com.amve.utils.Exit;
import com.amve.utils.ExtraDescription;

public class Room {
	
	public String vNum = "";
	public String header = "";
	public String description = "";
	public List<RoomFlag> roomFlags = new ArrayList<>(); 
	public RoomSector roomSector;
	public List<Exit> exits = new ArrayList<>();
	public List<ExtraDescription> extras = new ArrayList<>();
	public String manaAdjust = "100";
	public String healingAdjust = "100";
	public String clan = null;
		
	//public ResetMessage resetMessage = null;
	
	public Room() {}
	
	public boolean isEmpty() {
		return (vNum == null);
	}
	
	public boolean hasExits() {
		return (!exits.isEmpty());
	}
	
	public boolean hasExtras() {
		return (!extras.isEmpty());
	}
	
	public void setVNum(String vNum) {
		this.vNum = vNum;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setRoomSector(String str) {
		this.roomSector = RoomSector.valueOfNum(Integer.parseInt(str));
	}
	
	//for reading from file
	
	public void addFlags(String flags) {
		// Instead of using "ABC" Letter Translations, they preferred this notation "1|2|4"
		List<String> splitted = List.of(flags.split("\\|"));
		splitted.forEach(f -> {
			this.roomFlags.add(RoomFlag.valueOfNum(Integer.parseInt(f)));
		});
	}
	
	public void addExit(Integer direction, String description, String keyword, 
			Integer doorState, String connectedVNum, String keyVNum) {
		List<String> keyWords = List.of(keyword.split(" "));
		Exit exit = new Exit(ExitDirection.valueOfNum(direction), description, 
				keyWords, DoorState.valueOfNum(doorState), connectedVNum, keyVNum);
		exits.add(exit);
	}
	
	public void addExtra (String keyword, String description) {
		List<String> keywords = List.of(keyword.split(" "));
		ExtraDescription extra = new ExtraDescription(keywords, description);
		extras.add(extra);
	}
	
	//function that returns a string output in normal area file format for the room
	public String toString() {
		//TODO: implement the function
		return("");
	}
}