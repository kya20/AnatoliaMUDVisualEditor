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
import com.amve.utils.MobileReset;
import com.amve.utils.ObjectReset;

public class Room {
	
	private String vNum = "";
	public String header = "";
	public String description = "";
	public List<RoomFlag> roomFlags = new ArrayList<>(); 
	public RoomSector roomSector;
	public Map<ExitDirection, Exit> exits = new HashMap<>();
	public List<ExtraDescription> extras = new ArrayList<>();
	public String manaAdjust = "100";
	public String healingAdjust = "100";
	public String clan = null;
	
	// Holds RESET info
	
	private Map<String, List<MobileReset>> mobileResets = new HashMap<>();
	private Map<String, List<ObjectReset>> objectResets = new HashMap<>();
		
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
		exits.put(exit.exitDirection, exit);
	}
	
	public Exit getExit(Integer direction) {
		return this.exits.get(ExitDirection.valueOfNum(direction));
	}
	
	public void addExtra (String keyword, String description) {
		List<String> keywords = List.of(keyword.split(" "));
		ExtraDescription extra = new ExtraDescription(keywords, description);
		extras.add(extra);
	}
	
	public Map<String, List<MobileReset>> getMobileResets() {
		return mobileResets;
	}
	
	public void addMobileReset(MobileReset mobileReset) {
		List<MobileReset> list = this.mobileResets.get(mobileReset.mobileVNum);
		if (list == null) 
			list = new ArrayList<MobileReset>();
		list.add(mobileReset);
		this.mobileResets.put(mobileReset.mobileVNum, list);
	}
	
	public Map<String, List<ObjectReset>> getObjectResets() {
		return objectResets;
	}
	
	public void addObjectReset(ObjectReset objectReset) {
		List<ObjectReset> list = this.objectResets.get(objectReset.objectVNum);
		if (list == null)
			list = new ArrayList<ObjectReset>();
		list.add(objectReset);
		this.objectResets.put(objectReset.objectVNum, list);
	}
	
	//function that returns a string output in normal area file format for the room
	public String toString() {
		//TODO: implement the function
		return("");
	}

	public String getHeader() {
		return header;
	}

	public String getvNum() {
		return vNum;
	}

	public void setvNum(String vNum) {
		this.vNum = vNum;
	}
}