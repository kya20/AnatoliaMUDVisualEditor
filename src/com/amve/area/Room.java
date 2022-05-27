package com.amve.area;

import java.util.*;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.DoorState;
import com.amve.globals.GlobalVariables.ExitDirection;
import com.amve.globals.GlobalVariables.RoomFlag;
import com.amve.globals.GlobalVariables.RoomSector;
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
		// Both "ABC" Letter Translations and "1|2|4" can be used.
		
		if(flags.matches("[A-Z]+")) {
			for (int i = 0; i < flags.length() ; i++) {
				this.roomFlags.add(RoomFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(flags.substring(i, i+1))));
			}
		}
		else if(flags.matches("\\d+(\\|\\d+)*")) {
			List<String> splitted = List.of(flags.split("\\|"));
			splitted.forEach(f -> {
				this.roomFlags.add(RoomFlag.valueOfNum(Integer.parseInt(f)));
			});
		}
		
		
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

	public String getHeader() {
		return header;
	}

	public String getvNum() {
		return vNum;
	}

	public void setvNum(String vNum) {
		this.vNum = vNum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#" + this.getvNum() + "\n");
		sb.append(this.header + "~\n");
		sb.append(this.description + "~\n");
		sb.append("0 ");
		String s = "";
//		if (roomFlags) CONTINUE
		for (RoomFlag flag : this.roomFlags)
			s = s + GlobalVariables.LETTER_TRANSLATIONS_REVERSE.get(flag.num);
		sb.append(s + " " + this.roomSector.num + "\n");
		this.exits.keySet().stream().sorted().forEach(key -> sb.append(this.exits.get(key).toString()));
//		this.exits.forEach((direction, exit) -> sb.append(exit.toString()));
		this.extras.forEach(ed -> sb.append(ed.toString()));
		sb.append("M " + this.manaAdjust + " H " + this.healingAdjust + "\n");
		if(this.clan != null)
			sb.append("clan " + this.clan + "~\n");
		sb.append("S\n");
		
		return sb.toString();
	}
	
	public String mobileResetToString() {
		StringBuilder sb = new StringBuilder();
		for(List<MobileReset> listMobileReset : this.mobileResets.values())
			for( MobileReset mobRes : listMobileReset)
				sb.append(mobRes.toString());
		return sb.toString();
	}
	
	public String objectResetToString() {
		StringBuilder sb = new StringBuilder();
		for(List<ObjectReset> listObjectReset : this.objectResets.values())
			for( ObjectReset objRes : listObjectReset)
				sb.append(objRes.toString());
		return sb.toString();
	}
	
	public String doorResetToString() {
		StringBuilder sb = new StringBuilder();
		this.exits.forEach((key, exit) -> sb.append(exit.doorResetToString(this.vNum)));
		return sb.toString();
	}
}