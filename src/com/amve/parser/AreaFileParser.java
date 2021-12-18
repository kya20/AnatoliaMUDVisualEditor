package com.amve.parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amve.area.Area;
import com.amve.area.Mobile;
import com.amve.area.Room;

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
			String word = sbFile.substring(0, sbFile.indexOf(" "));
			sbFile.delete(0, sbFile.indexOf(" "));
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
		
	}
}