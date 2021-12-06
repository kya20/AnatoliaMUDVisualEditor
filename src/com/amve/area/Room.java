package com.amve.area;

import java.util.*;
import com.amve.globals.GlobalVariables;

public class Room extends Area {
	
	public String vNum = null;
	public String header = null;
	public String description = null;
	public HashMap<String, String> flags = new HashMap<>();
		
	//public ResetMessage resetMessage = null;
	
	public ArrayList<HashMap<String, String>> exits = new ArrayList<>();
	public ArrayList<HashMap<String, String>> extras = new ArrayList<>();
	
	public HashMap<String, Integer> exitDirs = new HashMap<String, Integer>();	
	
	public Room() {
		exitDirs.put("hasNorthExit",0);
		exitDirs.put("hasEastExit", 0);
		exitDirs.put("hasSouthExit",0);
		exitDirs.put("hasWestExit", 0);
		exitDirs.put("hasUpExit", 0);
		exitDirs.put("hasDownExit", 0);	
		flags.put("first", "0");
		flags.put("flag", "");
		flags.put("sector", "");
	}
	
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
	
	//for reading from file
	public void setFlags(String flagLine) {
		String[] splitted = flagLine.split("\\s+");
		flags.put("first", splitted[0]);
		flags.put("flag", splitted[1]);
		flags.put("sector", splitted[2]);
	}
	
	public void changeFlag(String flag) {
		flags.put("flag", flag);
	}
	
	public void changeSector(String sector) {
		flags.put("sector", sector);
	}
	
	public void addExit(Integer direction, String description, String keyword, Integer state, String connectedVNum, String keyVNum) {
		HashMap<String, String> exit = new HashMap<>();
		exit.put("direction", "D" + direction);
		exit.put("description", description);
		exit.put("keyword", keyword);
		exit.put("state", state.toString());
		exit.put("connectedVNum", connectedVNum);
		exit.put("keyVNum", keyVNum);
		exits.add(exit);
		
		try {
			if (Objects.equals(direction, GlobalVariables.NORTH_DIR)) {
				this.exitDirs.put("hasNorthExit", 1);
			}
			if (Objects.equals(direction, GlobalVariables.EAST_DIR)) {
				this.exitDirs.put("hasEastExit", 1);
			}
			if (Objects.equals(direction, GlobalVariables.SOUTH_DIR)) {
				this.exitDirs.put("hasSouthExit", 1);
			}
			if (Objects.equals(direction, GlobalVariables.WEST_DIR)) {
				this.exitDirs.put("hasWestExit", 1);
			}
			if (Objects.equals(direction, GlobalVariables.UP_DIR)) {
				this.exitDirs.put("hasUpExit", 1);
			}
			if (Objects.equals(direction, GlobalVariables.DOWN_DIR)) {
				this.exitDirs.put("hasDownExit", 1);
			}
			
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void addExtra (String keyword, String description) {
		HashMap<String, String> extra = new HashMap<>();
		extra.put("keyword", keyword);
		extra.put("description", description);
		extras.add(extra);
	}
	
	//function that returns a string output in normal area file format for the room
	public String toString() {
		//TODO: implement the goddamn function
		return("");
	}
	
}