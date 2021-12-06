package com.amve.area;

import java.util.*;
//import com.amve.globals.*;

public class Reset extends Area {
	public HashMap<String, String> mobReset = new HashMap<>();
	public HashMap<String, String> objReset = new HashMap<>();
	public HashMap<String, String> putReset = new HashMap<>();
	public HashMap<String, String> giveReset = new HashMap<>();
	public HashMap<String, String> equipReset = new HashMap<>();
	public HashMap<String, String> doorReset = new HashMap<>();
	
	public static final Integer MOB_RESET = 0;
	public static final Integer OBJ_RESET = 1;
	public static final Integer PUT_RESET = 2;
	public static final Integer GIVE_RESET = 3;
	public static final Integer EQUIP_RESET = 4;
	public static final Integer DOOR_RESET = 5;
	
	public int resetType = -1;
	
	public Reset() {}
	
	public void setMobReset(String mobVNum, String roomVNum, Integer globalMobNumLimit, Integer localMobNumLimit) {
		HashMap<String, String> mobReset = new HashMap<>();
		mobReset.put("mobVNum", mobVNum);
		mobReset.put("roomVNum", roomVNum);
		mobReset.put("globalMobNumLimit", globalMobNumLimit.toString());
		mobReset.put("localMobNumLimit", localMobNumLimit.toString());
		this.mobReset = mobReset;
		this.resetType = MOB_RESET;
	}
	
	public void setObjReset(String objVNum, String roomVNum) {
		HashMap<String, String> objReset = new HashMap<>();
		objReset.put("objVNum", objVNum);
		objReset.put("roomVNum", roomVNum);
		this.objReset = objReset;
		this.resetType = OBJ_RESET;
	}
	
	public void setPutReset(String containedVNum, String containerVNum, Integer containedNumber) {
		HashMap<String, String> putReset = new HashMap<>();
		putReset.put("containedVNum", containedVNum);
		putReset.put("containerVNum", containedVNum);
		putReset.put("containedNumber", containedNumber.toString());
		this.putReset = putReset;
		this.resetType = PUT_RESET;
	}
	
	//IMPORTANT: give resets only contain one vnum value in area files, the items are given to the most recently declared mobile reset (directly above it)
	public void setGiveReset(String objVNum, String mobVNum) {
		HashMap<String, String> giveReset = new HashMap<>();
		giveReset.put("objVNum", objVNum);
		giveReset.put("mobVNum", mobVNum);
		this.giveReset = giveReset;
		this.resetType = GIVE_RESET;
	}
	
	//similar to above (or so I assume)
	public void setEquipReset(String objVNum, Integer equipSlot, String mobVNum) {
		HashMap<String, String> equipReset = new HashMap<>();
		equipReset.put("objVNum", objVNum);
		equipReset.put("equipSlot", equipSlot.toString());
		equipReset.put("mobVNum", mobVNum);
		this.equipReset = equipReset;
		this.resetType = EQUIP_RESET;
	}
	
	//will need to split and concatenate doorCondition later for visual editing
	public void setDoorReset(String roomVNum, Integer doorSide, String doorCondition) {
		HashMap<String, String> doorReset = new HashMap<>();
		doorReset.put("roomVNum", roomVNum);
		doorReset.put("doorSide", doorSide.toString());
		doorReset.put("doorCondition", doorCondition);
		this.doorReset = doorReset;
		this.resetType = DOOR_RESET;
	}
	
	
}