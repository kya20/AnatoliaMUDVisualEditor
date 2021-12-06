package com.amve.area;

import java.util.ArrayList;
import java.util.HashMap;
import com.amve.globals.GlobalVariables;

public class Area {

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

}