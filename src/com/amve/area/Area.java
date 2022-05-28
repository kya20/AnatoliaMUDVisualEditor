package com.amve.area;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Area {
	
	private String areaFileName;
	private String name;
	private int[] levelRange = new int[2];
	private String builder;
	private String longName;
	private int[] vNumRange = new int[2];

	private ArrayList<Mobile> mobiles = new ArrayList<>();
	private ArrayList<Object> objects = new ArrayList<>();
	private Map<String, Room> rooms = new HashMap<>();
	
	public ArrayList<Shop> shops = new ArrayList<>();
	public ArrayList<Special> specials = new ArrayList<>();
	public ArrayList<Omprog> objMobProgs = new ArrayList<>();
	public ArrayList<OLimit> objLimits = new ArrayList<>();
	public ArrayList<Practicer> practicers = new ArrayList<>();
	
	public ArrayList<HashMap<String, String>> mobResets = new ArrayList<>();
	public ArrayList<HashMap<String, String>> objResets = new ArrayList<>();
	public ArrayList<HashMap<String,String>> putResets = new ArrayList<>();
	public ArrayList<HashMap<String,String>> giveResets = new ArrayList<>();
	public ArrayList<HashMap<String,String>> equipResets = new ArrayList<>();
	public ArrayList<HashMap<String,String>> doorResets = new ArrayList<>();
	
	public String getAreaFileName() {
		return areaFileName;
	}
	public void setAreaFileName(String areaFileName) {
		this.areaFileName = areaFileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getLevelRange() {
		return levelRange;
	}
	public int getLevelRange(int index) {
		return levelRange[index];
	}
	public void setLevelRange(int[] levelRange) {
		this.levelRange = levelRange;
	}
	public void setLevelRange(int index, int value) {
		this.levelRange[index] = value;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public int[] getvNumRange() {
		return vNumRange;
	}
	public int getvNumRange(int index) {
		return vNumRange[index];
	}
	public void setvNumRange(int[] vNumRange) {
		this.vNumRange = vNumRange;
	}
	public void setvNumRange(int index, int value) {
		this.vNumRange[index] = value;
	}
	public ArrayList<Mobile> getMobiles() {
		return mobiles;
	}
	public ArrayList<Object> getObjects() {
		return objects;
	}
	public Map<String, Room> getRooms() {
		return rooms;
	}
	
	public String shopsToString() {
		StringBuilder sb = new StringBuilder();
		this.shops.forEach(shop -> sb.append(shop.toString()));
		return sb.toString();
	}
	
	public String specialsToString() {
		StringBuilder sb = new StringBuilder();
		this.specials.forEach(special -> sb.append(special.toString()));
		return sb.toString();
	}
	
	public String omprogsToString() {
		StringBuilder sb = new StringBuilder();
		this.objMobProgs.forEach(omprog -> sb.append(omprog.toString()));
		return sb.toString();
	}
	
	public String oLimitsToString() {
		StringBuilder sb = new StringBuilder();
		this.objMobProgs.forEach(olimit -> sb.append(olimit.toString()));
		return sb.toString();
	}
	
	public String practicersToString() {
		StringBuilder sb = new StringBuilder();
		this.practicers.forEach(practicer -> sb.append(practicer.toString()));
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getAreaFileName() + "~\n");
		sb.append(this.getName() + "~\n");
		sb.append(
				"{" + this.getLevelRange(0) + " " + 
				this.getLevelRange(1) + "} " + 
				this.getBuilder() + " " + 
				this.getLongName() + "~\n");
		sb.append(this.getvNumRange(0) + " " + this.getvNumRange(1) + "\n\n");
		return sb.toString();
	}

}