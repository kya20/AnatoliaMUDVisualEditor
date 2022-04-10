package com.amve.area;
import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.Position;
import com.amve.globals.GlobalVariables.Sex;
import com.amve.globals.GlobalVariables.Size;
import com.amve.utils.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Mobile {
	//TODO: implement globals for pos, sex, damage type, size and whatnot
	public String vNum = null;
	public ArrayList<String> nameList = new ArrayList<>();
	public String shortDescription = "";
	public String longDescription = "";
	public String lookDescription = "";
//	public int race = -1;
	public Race race;
	public List<Flag> flags = new ArrayList<>(); //action, affect, offensive, immunity, resistance, vulnerability, detection, corpse, form, parts
	public int alignment = 0;
	public int mobileGroup = 0;
	public int level = 1;
	public int hitBonus = 0;
	public Dice hitDice = new Dice();
	public Dice manaDice = new Dice();
	public Dice damageDice = new Dice();
	public String damageType = "";
	public int damage = 0;
	public Map <String, Integer> armorClasses = new HashMap<>(); //pierce, bash, slash, magic
	public Position startPos;
	public Position defaultPos;
	public Sex gender;
	public int treasure = 0;
	public Size size;
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
	
	//DONE: implement practicer here or in its own class
	public boolean practicer = false;
	public String practicerGroup = "";
	
	static private class RaceTable {
		Map<String, Integer> map = (Map<String, Integer>)IntStream.range(0, name.length).boxed().collect(Collectors.toMap(i->name[i],i->i));
		/*
		RaceTable() {
			IntStream.range(0, name.length).forEach(n -> hashMap.put(name[n], n));
			IntStream.range(0, name.length).boxed().collect(Collectors.toMap(i->name[i],i->i));
		}*/
		
		static String[] name = {
				"unknown",
				"human",		"elf",			"half-elf",		"dark-elf",		"rockseer",			"dwarf",			"svirfnebli",		"duergar",			"arial",		"gnome",
				"storm giant",	"cloud giant",	"fire giant",	"frost giant",	"felar",			"githyanki",		"satyr",			"troll",			"black dragon",	"blue dragon",
				"green dragon", "red dragon",	"white dragon",	"brass dragon",	"gold dragon",		"silver dragon",	"bronze dragon",	"copper dragon",	"bat",			"bear",
				"cat",			"centipede",	"dog",			"doll",			"fido",				"fox",				"goblin",			"hobgoblin",		"kobold",		"lizard",
				"modron",		"orc",			"pig",			"rabbit",		"school monster",	"snake",			"song bird",		"water fowl",		"wolf",			"wyvern",
				"dragon",		"giant",		"golem",		"undead",		"drow",				"draconian",		"sprite",			"aarakocra",		"beholder",		"tiger",
				"lion",			"centaur",		"death knight",	"dracolich",	"air elemental",	"earth elemental",	"fire elemental",	"water elemental",	"fish",			"gargoyle",
				"ghost",		"ghoul",		"gnoll",		"harpy",		"lamia",			"lich",				"minotaur",			"ogre",				"zombie",		"horse",
				"unique"
		};
		
//		static Boolean[] isPcRace = {
//				true,			true,			true,			true,			true,				true,				true,				true,				true,			true,
//				true,			true,			true,			true,			true,				true,				true,				true,				true,			false,
//				false,			false,			false,			false,			false,				false,				false,				false,				false,			false,
//				false,			false,			false,			false,			false,				false,				false,				false,				false,			false,
//				false,			false,			false,			false,			false,				false,				false,				false,				false,			false,
//				false,			false,			false,			false,			false,				false,				false,				false,				false,			false,
//				false,			false,			false,			false,			false,				false,				false,				false,				false,			false,
//				false,			false,			false,			false,			false,				false,				false,				false,				false,			false,
//				false
//		};
		
//		static int[] actBits = {
//				0,				0,				0,				0,				0,					0,					0,					0,					0,				0,
//				0,				0,				0,				0,				0,					0,					0,					0,					0,				0,
//				0,				0,				0,				0,				0,					0,					0,					0,					0,				0,
//				0,				0,				0,				0,				0,					0,					0,					0,					0,				0,
//				0,				0,				0,				0,				0,					0,					0,					0,					0,				GlobalVariables.DETECT_INVIS + GlobalVariables.DETECT_HIDDEN,
//				0,				0,				0,				GlobalVariables.DETECT_INVIS + GlobalVariables.DETECT_HIDDEN + GlobalVariables.DETECT_GOOD + GlobalVariables.DETECT_EVIL,	0,	0,	GlobalVariables.DETECT_EVIL,	0,	0,	0,
//				0,				0,				0,				0,				0,					0,					0,					0,					0,				0,
//				0,				0,				GlobalVariables.DETECT_IMP_INVIS + GlobalVariables.DETECT_HIDDEN,	GlobalVariables.DETECT_IMP_INVIS + GlobalVariables.DETECT_HIDDEN,	0,	0,	0,	0,	0,	0,
//				0
//				
//		};
		
//		static int[] affByBits = {
//				
//		};
	}
	
	public class Race {
		private int raceNumber;
		
		public Race(String raceName) {
			RaceTable rT = new RaceTable();
			this.raceNumber = rT.map.get(raceName);
		}
		
		public String getRaceName() {
			return RaceTable.name[this.raceNumber];
		}
	}
	
	//TODO: implement toString function or something similar for writing to .are files
}