package com.amve.area;

import java.util.ArrayList;
import java.util.HashMap;
import com.amve.globals.GlobalVariables;

public class Area {
	
	private String areaFileName;
	private String name;
	private int[] levelRange = new int[2];
	private String builder;
	private String longName;
	private int[] vNumRange = new int[2];

	public ArrayList<Mobile> mobiles = new ArrayList<>();
	
	public ArrayList<Object> objects = new ArrayList<>();
	
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

}