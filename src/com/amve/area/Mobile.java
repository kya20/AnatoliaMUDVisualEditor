package com.amve.area;
import com.amve.utils.*;
import java.util.*;
import java.io.*;

public class Mobile {
	//TODO: implement globals for pos, sex, damage type, size and whatnot
	public String vNum = null;
	public String nameList = "";
	public String shortDesc = "";
	public String longDesc = "";
	public String lookDesc = "";
	public int race = -1;
	public Map<String,String> flags = new HashMap<>(); //act, affect, offensive, immunity, resistance, vuln., detection, corpse, form, parts
	public int alignment = 0;
	public int mobileGroup = 0;
	public int level = 1;
	public int hitBonus = 0;
	Dice hitDice = new Dice();
	Dice manaDice = new Dice();
	Dice damageDice = new Dice();
	public int damageType = 0;
	public int damage = 0;
	public Map <String, Integer> armorClasses = new HashMap<>(); //pierce, bash, slash, magic
	public int startPos = 0;
	public int defaultPos = 0;
	public int gender = 0;
	public int treasure = 0;
	public int size = 0;
	public String material = "";
	public String special = "";
	
	//Shop stuff, might be moved later
	public boolean isShopkeeper = false;
	public int itemsSoldNum = 0;
	public ArrayList<Integer> itemSold = new ArrayList<Integer>();
	public int profitBuy = 100;
	public int profitSell = 100;
	public int hourOpen = 0;
	public int hourClose = 23;
	
	//TODO: implement practicer here or in its own class
	
	//TODO: implement toString function or something similar for writing to .are files
}