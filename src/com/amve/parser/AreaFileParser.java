package com.amve.parser;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amve.area.Area;
import com.amve.area.Mobile;
import com.amve.area.Object;
import com.amve.area.Room;
import com.amve.globals.GlobalVariables.Position;
import com.amve.globals.GlobalVariables.Sex;
import com.amve.globals.GlobalVariables.Size;
import com.amve.utils.Dice;
import com.amve.utils.Flag;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AreaFileParser {
	
	public Area area = new Area();
	
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
				break;
			case "ROOMS":
				break;
			case "SHOPS":
				break;
			case "SOCIALS":
				break;
			case "OMPROGS":
				break;
			case "OLIMITS":
				break;
			case "SPECIALS":
				break;
			case "PRACTICERS":
				break;
			case "RESETMESSAGE":
				break;
			case "FLAG":
				break;
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
		Pattern pattern = Pattern.compile("\\{\\d* \\d*\\}");
	    Matcher matcher = pattern.matcher(file);
	    matcher.find();
		String levRangeStr = matcher.group(0);
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
			mobile.vNum = file.substring(0, index);
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
			mobile.flags.add(new Flag("action", tmp[0]));
			mobile.flags.add(new Flag("affect", tmp[1]));
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
			mobile.flags.add(new Flag("offensive", tmp[0]));
			mobile.flags.add(new Flag("immunity", tmp[1]));
			mobile.flags.add(new Flag("resistance", tmp[2]));
			mobile.flags.add(new Flag("vulnerability", tmp[3]));
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
			mobile.flags.add(new Flag("form", tmp[0]));
			mobile.flags.add(new Flag("part", tmp[1]));
			mobile.size = Size.valueOfName(tmp[2]);
			mobile.material = tmp[3];
			file.delete(0, index);
			while(Character.isWhitespace(file.charAt(0)))
				file.deleteCharAt(0);
			index = file.indexOf("\n");
			
			this.area.mobiles.add(mobile);
			
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
			String [] tmp = file.substring(0, index).split(" ");
			
//			object.flags.add(new Flag("extra", tmp[1]))
		}
	}
}