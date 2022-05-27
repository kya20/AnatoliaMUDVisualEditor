package com.amve.parser;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.amve.area.Area;
import com.amve.area.Mobile;
import com.amve.area.OLimit;
import com.amve.area.Object;
import com.amve.area.Omprog;
import com.amve.area.Practicer;
import com.amve.area.Room;
import com.amve.area.Shop;
import com.amve.area.Special;
import com.amve.globals.GlobalVariables.Position;
import com.amve.globals.GlobalVariables.PracticeGroup;
import com.amve.globals.GlobalVariables.Sex;
import com.amve.globals.GlobalVariables.Size;
import com.amve.globals.GlobalVariables.SpecialType;
import com.amve.utils.Armor;
import com.amve.utils.Container;
import com.amve.utils.Dice;
import com.amve.utils.Drink;
import com.amve.utils.EquipReset;
import com.amve.utils.Exit;
import com.amve.utils.Food;
import com.amve.utils.Fountain;
import com.amve.utils.Furniture;
import com.amve.utils.GiveReset;
import com.amve.utils.Item;
import com.amve.utils.Jewelry;
import com.amve.utils.Key;
import com.amve.utils.Light;
import com.amve.utils.MobileReset;
import com.amve.utils.Money;
import com.amve.utils.ObjectReset;
import com.amve.utils.Pill;
import com.amve.utils.Portal;
import com.amve.utils.Potion;
import com.amve.utils.PutReset;
import com.amve.utils.Scroll;
import com.amve.utils.Staff;
import com.amve.utils.Treasure;
import com.amve.utils.Wand;
import com.amve.utils.Weapon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;

public class AreaFileParser {
	
	private Area area = new Area();
	
	public AreaFileParser(String areaFilePath) {
		String rawFile = null;
		try {
			Path path = Paths.get(areaFilePath);

		    rawFile = Files.readString(path);
		    
		    } catch (IOException e) {
		      System.err.println("Error: Area file not found.");
		      e.printStackTrace();
		      System.exit(-1);
		    }
		
		// int charPos = 0;
		StringBuilder sbFile = new StringBuilder(rawFile);
		while(true) {
			if(sbFile.charAt(0) != '#')
				throw new IllegalArgumentException("Could not find # character.");
			sbFile.deleteCharAt(0);
			String word = sbFile.substring(0, sbFile.indexOf("\n")).strip();
			sbFile.delete(0, sbFile.indexOf("\n"));
			switch(word) {
			case "AREA":
				loadArea(sbFile);
				break;
			case "HELPS":
				break;
			case "MOBOLD":
				break;
			case "MOBILES":
				loadMobiles(sbFile);
				break;
			case "OBJOLD":
				break;
			case "OBJECTS":
				loadObjects(sbFile);
				break;
			case "RESETS":
				loadResets(sbFile);
				break;
			case "ROOMS":
				loadRooms(sbFile);
				break;
			case "SHOPS":
				loadShops(sbFile);
				break;
			case "SOCIALS":
				break;
			case "OMPROGS":
				loadOmprogs(sbFile);
				break;
			case "OLIMITS":
				loadOLimits(sbFile);
				break;
			case "SPECIALS":
				loadSpecials(sbFile);
				break;
			case "PRACTICERS":
				loadPracticers(sbFile);
				break;
			case "RESETMESSAGE":
				break;
			case "FLAG":
				break;
			case "$":
				return;
			default:
				throw new IllegalArgumentException("Bad section name.");
			}
		}
	}
	
	private void loadArea(StringBuilder file) {
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		int index = file.indexOf("~");
		area.setAreaFileName(file.substring(0, index));
		file.delete(0, index + 1);
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		index = file.indexOf("~");
		area.setName(file.substring(0, index));
		file.delete(0, index + 1);
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		Pattern pattern = Pattern.compile("\\{\\s?\\d* \\d*\\s?\\}");
	    Matcher matcher = pattern.matcher(file);
	    matcher.find();
		String levRangeStr = matcher.group(0);
		levRangeStr = levRangeStr.replace("{ ", "{");
		String[] levRangeSplit = levRangeStr.split(" ");
		area.setLevelRange(0, Integer.parseInt(levRangeSplit[0].substring(1)));
		area.setLevelRange(1, Integer.parseInt(levRangeSplit[1].substring(0, levRangeSplit[1].length()-1)));
		file.delete(0, matcher.end(0));
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		index = file.indexOf(" ");
		area.setBuilder(file.substring(0, index));
		file.delete(0, index);
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		index = file.indexOf("~");
		area.setLongName(file.substring(0, index));
		file.delete(0, index + 1);
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		pattern = Pattern.compile("\\d*");
		matcher = pattern.matcher(file);
		matcher.find();
		area.setvNumRange(0, Integer.parseInt(matcher.group(0)));
		file.delete(0, matcher.end());
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
		matcher = pattern.matcher(file);
		matcher.find();
		area.setvNumRange(1, Integer.parseInt(matcher.group(0)));
		file.delete(0, matcher.end());
		while(Character.isWhitespace(file.charAt(0)))
			file.deleteCharAt(0);
	}
	
	private void loadMobiles(StringBuilder file) {
		while(true) {
			Mobile mobile = new Mobile();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			if(file.charAt(0) != '#')
				throw new IllegalArgumentException("Could not find # character for mobile vNum.");
			file.deleteCharAt(0);
			int index = file.indexOf("\n");
			mobile.setvNum(file.substring(0, index));
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			mobile.nameList.addAll(Arrays.asList(file.substring(0, index).split(" ")));
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			mobile.shortDescription = file.substring(0, index);
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			mobile.longDescription = file.substring(0, index);
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			mobile.lookDescription = file.substring(0, index);
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			mobile.race = mobile.new Race(file.substring(0, index));
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			String [] tmp = file.substring(0, index).split(" ");
			
//			mobile.flags.add(new Flag("action", tmp[0]));
//			mobile.flags.add(new Flag("affect", tmp[1]));
			
			mobile.action = tmp[0];
			mobile.affect = tmp[1];
			
			mobile.alignment = Integer.parseInt(tmp[2]);
			mobile.mobileGroup = Integer.parseInt(tmp[3]);
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			tmp = file.substring(0, index).split(" ");
			mobile.level = Integer.parseInt(tmp[0]);
			mobile.hitBonus = Integer.parseInt(tmp[1]);
			mobile.hitDice = new Dice(tmp[2]);
			mobile.manaDice = new Dice(tmp[3]);
			mobile.damageDice = new Dice(tmp[4]); // It is actually damage attribute, but shares the same format, the int damage is not used.
			mobile.damageType = tmp[5];
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			tmp = file.substring(0, index).split(" ");
			mobile.armorClasses.put("pierce", Integer.parseInt(tmp[0]));
			mobile.armorClasses.put("bash", Integer.parseInt(tmp[1]));
			mobile.armorClasses.put("slash", Integer.parseInt(tmp[2]));
			mobile.armorClasses.put("magic", Integer.parseInt(tmp[3]));
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			tmp = file.substring(0, index).split(" ");
			
			mobile.offensive = tmp[0];
			mobile.immunity = tmp[1];
			mobile.resistance = tmp[2];
			mobile.vulnerability = tmp[3];
			
//			mobile.flags.add(new Flag("offensive", tmp[0]));
//			mobile.flags.add(new Flag("immunity", tmp[1]));
//			mobile.flags.add(new Flag("resistance", tmp[2]));
//			mobile.flags.add(new Flag("vulnerability", tmp[3]));
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			tmp = file.substring(0, index).split(" ");
			mobile.startPos = Position.valueOfName(tmp[0]);
			mobile.defaultPos = Position.valueOfName(tmp[1]);
			mobile.gender = Sex.valueOfName(tmp[2]);
			mobile.treasure = Integer.parseInt(tmp[3]);
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			tmp = file.substring(0, index).split(" ");
			
			mobile.form = tmp[0];
			mobile.part = tmp[1];
			
//			mobile.flags.add(new Flag("form", tmp[0]));
//			mobile.flags.add(new Flag("part", tmp[1]));
			mobile.size = Size.valueOfName(tmp[2]);
			mobile.material = tmp[3];
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			
			this.getArea().getMobiles().add(mobile);
			
			if ("#0".equals(file.substring(0, index))) {
				file.delete(0, index);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				return;
			}
				
		}	
	}
	
	private void loadObjects(StringBuilder file) {
		while(true) {
			Object object = new Object();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			if(file.charAt(0) != '#')
				throw new IllegalArgumentException("Could not find # character for object vNum.");
			file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if ("0".equals(file.substring(0, index))) {
				file.delete(0, index);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				return;
			}
			object.vNum = file.substring(0, index);
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			object.nameList.addAll(Arrays.asList(file.substring(0, index).split(" ")));
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			object.shortDescription = file.substring(0, index);
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			object.longDescription = file.substring(0, index);
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			object.material = file.substring(0, index);
			file.delete(0, index + 1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			String [] line6 = file.substring(0, index).split(" ");
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			String [] line7 =  {"", "", "", "", ""};
			if (file.substring(0, index).contains("'")) {
				int idx = 0;
				Boolean isInWord = false;
				for (char c : file.substring(0, index).toCharArray()) {
					if (isInWord) {
						if (c == '\'')
							isInWord = Boolean.logicalXor(isInWord, true);
						else
							line7[idx] += c;
					}
					else if (c == ' ') idx++;
					else if (c == '\'')
						isInWord = Boolean.logicalXor(isInWord, true);
					else 
						line7[idx] += c;
				}
			}
			else line7 = file.substring(0, index).split(" ");
			
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			String [] line8 = file.substring(0, index).split(" ");
			
			String line9 = "";
			String line11 = "";
			String line12 = "";
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			while(true) {
				index = file.indexOf("\n");
				String l = file.substring(0, index+1);
				l = removeWhiteSpace(l);
				if (l.startsWith("A")) { // doc says "apply", under2 has "A"
					file.delete(0, index+1);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					index = file.indexOf("\n");
					l = file.substring(0, index+1);
					line9 = line9.concat(l);
					file.delete(0, index+1);
				}
				else if (l.startsWith("F")) {
					line11.concat("\n" + l);
				}
				else if (l.startsWith("E")) {
					line12.concat("\n" + l);
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					index = file.indexOf("~");
					line12.concat("\n" + file.substring(0, index+1));
					file.delete(0, index+1);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					index = file.indexOf("~");
					line12.concat(file.substring(0, index+1));
					file.delete(0, index+1);
				}
				else
					break;
			}
			
			Item item = null;
			switch(line6[0]) {
			case "weapon":
				item = new Weapon(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "armor":
				item = new Armor(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "light":
				item = new Light(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "money":
				item = new Money(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "drink":
				item = new Drink(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "fountain":
				item = new Fountain(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "wand":
				item = new Wand(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "staff":
				item = new Staff(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "potion":
				item = new Potion(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "scroll":
				item = new Scroll(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "pill":
				item = new Pill(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "container":
				item = new Container(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "food":
				item = new Food(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "portal":
				item = new Portal(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "furniture":
				item = new Furniture(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2], line8[3], line9, line11, line12, 
						line7[0], line7[1], line7[2], line7[3], line7[4]);
				break;
			case "treasure":
				item = new Treasure(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2],line8[3], line9, line11, line12);
				break;
			case "key":
				item = new Key(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2],line8[3], line9, line11, line12);
				break;
			case "jewelry":
				item = new Jewelry(line6[0], line6[1], line6[2], line8[0], 
						line8[1], line8[2],line8[3], line9, line11, line12);
				break;
				
			}
			if (item != null)
				object.item = item;
			else
				throw new InvalidParameterException(line6[0] + " object type is invalid.");
			
			this.getArea().getObjects().add(object);
		}
	}
	
	private void loadRooms(StringBuilder file) {
		while (true) {
			Room room = new Room();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			if(file.charAt(0) != '#')
				throw new IllegalArgumentException("Could not find # character for mobile vNum.");
			file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if ("0".equals(file.substring(0, index))) {
				file.delete(0, index);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				return;
			}
			room.setvNum(file.substring(0, index));;
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			room.setHeader(file.substring(0, index));
			file.delete(0, index+1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("~");
			room.setDescription(file.substring(0, index));
			file.delete(0, index+1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			String [] line4 = file.substring(0, index).split(" ");
			room.addFlags(line4[1]);
			room.setRoomSector(line4[2]);
			file.delete(0, index+1);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			if (file.substring(0, index).startsWith("H") || file.substring(0, index).startsWith("M")) {
				// Mana recovery, healing recovery; in area files this may be here, 
				// according to Anatolia3.1.txt however it should be at the end.
				String [] splitted = file.substring(0, index).split(" ");
				for (int i = 0 ; i < splitted.length ; i+=2) {
					if ("H".equals(splitted[i]))
						room.healingAdjust = splitted[i+1];
					else if ("M".equals(splitted[i]))
						room.manaAdjust = splitted[i+1];
					else
						throw new InvalidParameterException("Invalid Mana/Healing adjust line");
				}
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("\n");
			}
			// exit
			for (int i = 0 ; i < 6 ; i++) { // max number of exits, may be less
				if (!file.substring(0, index).startsWith("D")) 
					break;
				Integer direction = Integer.parseInt(file.substring(1, index));
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("~");
				String exitDescription = file.substring(0, index);
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("~");
				String doorKeyword = file.substring(0, index);
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("\n");
				String[] lineSplitted = file.substring(0, index).split(" ");
				Integer doorState = Integer.parseInt(lineSplitted[0]);
				String roomVNum = lineSplitted[1];
				String keyVNum = lineSplitted[2];
				room.addExit(direction, exitDescription, doorKeyword, doorState, roomVNum, keyVNum);
//				room.exits.add(new Exit(direction, exitDescription, doorKeywords, doorState, roomVNum, keyVNum));
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("\n");
			}
			// extra
			while ("E".equals(file.substring(0, index))) {
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("~");
				String extendedRoomKeywords = file.substring(0, index);
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("~");
				String extendedRooomDesciptionText = file.substring(0, index);
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("\n");
				
				room.addExtra(extendedRoomKeywords, extendedRooomDesciptionText);
			}
			
			// according to Anatolia3.1.txt, this is where mana/health adjust should be.
			if (file.substring(0, index).startsWith("H") || file.substring(0, index).startsWith("M")) {
				String [] splitted = file.substring(0, index).split(" ");
				for (int i = 0 ; i < splitted.length ; i+=2) {
					if ("H".equals(splitted[i]))
						room.healingAdjust = splitted[i+1];
					else if ("M".equals(splitted[i]))
						room.manaAdjust = splitted[i+1];
					else
						throw new InvalidParameterException("Invalid Mana/Healing adjust line");
				}
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("\n");
			}
			
			// clan rooms
			if (file.substring(0, index).startsWith("clan")) {
				room.clan = file.substring(5, index-1); // excluding ~
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				index = file.indexOf("\n");
			}
			if ("S".equals(file.substring(0, index))) {
				file.delete(0, index+1);
				while(Character.isWhitespace(file.charAt(0)))
					file.deleteCharAt(0);
				this.getArea().getRooms().put(room.getvNum(), room);	
			}
			else throw new InvalidParameterException("Reached end of the room, could not find stop 'S' line.");
		}
	}
	
	private void loadResets(StringBuilder file) {
		
		MobileReset lastMobile = new MobileReset("", "", "0", "0");
		ObjectReset lastObject = new ObjectReset("", "");
		
		while (true) {
//			Reset reset = new Reset();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if (index <= 1) {
				if (file.charAt(0) =='S') {
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					return;
				}
				file.delete(0, index+1);
				continue;
			}
			String line = file.substring(0, index).split("\\*")[0];
			
			if ("".equals(line)) {
				file.delete(0, index+1);
				continue;
			}
			else if (line.startsWith("M")) {
				// load mobile into room
				String [] splitted = line.split("(\\s)+");
				Room room = this.getArea().getRooms().get(splitted[4]);
				lastMobile = new MobileReset(splitted[2], splitted[3], splitted[4], splitted[5]);
				room.addMobileReset(lastMobile);
			}
			else if (line.startsWith("O")) {
				// load object into room
				String [] splitted = line.split("(\\s)+");
				Room room = this.getArea().getRooms().get(splitted[4]);
				lastObject = new ObjectReset(splitted[2], splitted[4]);
				room.addObjectReset(lastObject);
			}
			else if (line.startsWith("P")) {
				// put object into another object
				// assuming that Object was loaded one line before, 
				// otherwise we cannot deduce which instance of that object we will put into, 
				// Ex: there may be multiple bags that has the vNum of 16000; when we put something inside 16000, 
				// do we put it in all of them? first one? second one?...
				// goofy format :)
				String [] splitted = line.split("(\\s)+");
				ObjectReset containerObject = lastObject;
				lastObject.addContainedObject(new PutReset(splitted[2], splitted[4], splitted[5]));
			}
			else if (line.startsWith("G")) {
				String [] splitted = line.split("(\\s)+");
				lastMobile.addGiveReset(new GiveReset(splitted[2], lastMobile.mobileVNum));
			}
			else if (line.startsWith("E")) {
				String [] splitted = line.split("(\\s)+");
				lastMobile.addEquipReset(new EquipReset(splitted[2], splitted[4], lastMobile.mobileVNum));
			}
			else if (line.startsWith("D")) {
				String [] splitted = line.split("(\\s)+");
				Exit exit = this.getArea().getRooms().get(splitted[2]).getExit(Integer.parseInt(splitted[3]));
				exit.setDoorFlags(splitted[4]);
			}
			else {
				throw new InvalidParameterException("RESETS: Could not find a valid character at: " + line);
			}
			file.delete(0, index+1);
		}
	}
	
	private void loadShops(StringBuilder file) {
		while(true) {
			Shop shop = new Shop();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if (index <= 1) {
				if (file.charAt(0) =='0') {
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					return;
				}
				file.delete(0, index+1);
				continue;
			}
			String line = file.substring(0, index).split("\\*")[0];
			if ("".equals(line)) {
				file.delete(0, index+1);
				continue;
			}
			else {
				Scanner scanner = new Scanner(line);
				shop.setMobileVNum(Integer.toString(scanner.nextInt()));
				for(int i=1; i<6 ; i++) {
					int num = scanner.nextInt();
					if (num != 0)
						shop.addBuyItemType(Integer.toString(num));
				}
					
				shop.setBuyMultiplier(scanner.nextInt());
				shop.setSellMultiplier(scanner.nextInt());
				shop.setOpenHour(scanner.nextInt());
				shop.setCloseHour(scanner.nextInt());
				scanner.close();
			}
			file.delete(0, index+1);
			this.area.shops.add(shop);
		}
	}
	
	private void loadSpecials(StringBuilder file) {
		while (true) {
			Special special = new Special();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if (index <= 1) {
				if (file.charAt(0) =='S') {
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					return;
				}
				file.delete(0, index+1);
				continue;
			}
			String line = file.substring(0, index).split("\\*")[0];
			if ("".equals(line)) {
				file.delete(0, index+1);
				continue;
			}
			else if (line.startsWith("M")) {
				Scanner scanner = new Scanner(line);
				scanner.next("\\w");
				special.setMobVNum(Integer.toString(scanner.nextInt()));
				special.setSpecial(SpecialType.valueOfName(scanner.next("\\w+")));
				scanner.close();
			}
			else throw new InvalidParameterException("SPECIALS: Could not find a valid character at: " + line);
			file.delete(0, index+1);
			this.area.specials.add(special);
		}
	}
	
	private void loadOmprogs(StringBuilder file) {
		while (true) {
			Omprog omprog = new Omprog();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if (index <= 1) {
				if (file.charAt(0) =='S') {
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					return;
				}
				file.delete(0, index+1);
				continue;
			}
			String line = file.substring(0, index).split("\\*")[0];
			if ("".equals(line)) {
				file.delete(0, index+1);
				continue;
			}
			else if (line.startsWith("M") || line.startsWith("O")) {
				Scanner scanner = new Scanner(line);
				omprog.setType(scanner.next("\\w"));
				omprog.setvNum(Integer.toString(scanner.nextInt()));
				omprog.setProgType(scanner.next("\\w+"));
				omprog.setFunctionName(scanner.next("\\w+"));
				scanner.close();
			}
			else throw new InvalidParameterException("OMPROG: Could not find a valid character at: " + line);
			file.delete(0, index+1);
			this.area.objMobProgs.add(omprog);
		}
	}
	
	private void loadOLimits(StringBuilder file) {
		while (true) {
			OLimit oLimit = new OLimit();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if (index <= 1) {
				if (file.charAt(0) =='S') {
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					return;
				}
				file.delete(0, index+1);
				continue;
			}
			String line = file.substring(0, index).split("\\*")[0];
			if ("".equals(line)) {
				file.delete(0, index+1);
				continue;
			}
			else if (line.startsWith("O")) {
				Scanner scanner = new Scanner(line);
				scanner.next("\\w");
				oLimit.setvNum(Integer.toString(scanner.nextInt()));
				oLimit.setLimit(scanner.nextInt());
				scanner.close();
			}
			else throw new InvalidParameterException("OLIMIT: Could not find a valid character at: " + line);
			file.delete(0, index+1);
			this.area.objLimits.add(oLimit);
		}
	}
	
	private void loadPracticers(StringBuilder file) {
		while (true) {
			Practicer practicer = new Practicer();
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			int index = file.indexOf("\n");
			if (index <= 1) {
				if (file.charAt(0) =='S') {
					file.delete(0, index);
					while(Character.isWhitespace(file.charAt(0)))
						file.deleteCharAt(0);
					return;
				}
				file.delete(0, index+1);
				continue;
			}
			String line = file.substring(0, index).split("\\*")[0];
			if ("".equals(line)) {
				file.delete(0, index+1);
				continue;
			}
			else if (line.startsWith("M")) {
				Scanner scanner = new Scanner(line);
				scanner.next("\\w");
				practicer.setvNum(Integer.toString(scanner.nextInt()));
				practicer.setPracticeGroup(PracticeGroup.valueOfName(scanner.next("\\w+")));
				scanner.close();
			}
			else throw new InvalidParameterException("PRACTICER: Could not find a valid character at: " + line);
			file.delete(0, index+1);
			this.area.practicers.add(practicer);
		}
	}
	
	private String removeWhiteSpace(String s) {
		Pattern pattern = Pattern.compile("\\S*", Pattern.CASE_INSENSITIVE);
		Matcher m = pattern.matcher(s);
		if (m.find( )) {
			return m.group(0);	
		}
		else
			throw new InvalidParameterException("Could not find the pattern.");
	}

	public Area getArea() {
		return area;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#AREA\n");
		sb.append(this.getArea().toString());
		sb.append("#MOBILES\n");
		this.getArea().getMobiles().forEach(mobile -> sb.append(mobile.toString()));
		sb.append("#0\n\n");
		sb.append("#OBJECTS\n");
		this.getArea().getObjects().forEach(object -> sb.append(object.toString()));
		sb.append("#0\n\n");
		sb.append("#ROOMS\n");
//		this.getArea().getRooms().forEach((s, room) -> sb.append(room.toString())); 
		Map<String, Room> rooms = this.getArea().getRooms();
		List<String> roomVNumSorted = rooms.keySet().stream().sorted().collect(Collectors.toList());
		roomVNumSorted.forEach(key -> sb.append(rooms.get(key).toString()));
		sb.append("#0\n\n");
		sb.append("#RESETS\n");
		roomVNumSorted.forEach(key -> sb.append(rooms.get(key).mobileResetToString()));
		roomVNumSorted.forEach(key -> sb.append(rooms.get(key).objectResetToString()));
		roomVNumSorted.forEach(key -> sb.append(rooms.get(key).doorResetToString()));
		sb.append("S\n\n");
		sb.append("#SHOPS\n");
		sb.append(this.getArea().shopsToString());
		sb.append("0\n\n");
		sb.append("#SPECIALS\n");
		sb.append(this.getArea().specialsToString());
		sb.append("S\n\n");
		sb.append("#OMPROGS\n");
		sb.append(this.getArea().omprogsToString());
		sb.append("S\n\n");
		sb.append("#OLIMITS\n");
		sb.append(this.getArea().oLimitsToString());
		sb.append("S\n\n");
		sb.append("#PRACTICERS\n");
		sb.append(this.getArea().practicersToString());
		sb.append("S\n\n#$\n");
		
		
		return sb.toString();
	}
	
	
}