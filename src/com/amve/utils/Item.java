package com.amve.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.ItemExtra;
import com.amve.globals.GlobalVariables.ItemType;
import com.amve.globals.GlobalVariables.ItemWear;

public abstract class Item {
	public ItemType itemType;
	public List<ItemExtra> extraFlags = new ArrayList<>();
	public List<ItemWear> wearFlags = new ArrayList<>();
	public int level;
	public int weight;
	public int cost;
	public String cond;
	public List<List<String>> apply = new ArrayList<>();
	public List<List<String>> flags = new ArrayList<>();
	public List<ExtraDescription> extraDescriptions = new ArrayList<>();
	
	public Item(
			String itemType, 
			String extraFlags, 
			String wearFlags, 
			int level, 
			int weight, 
			int cost, 
			String cond, 
			String apply, 
			String flags, 
			String extraDescriptions
			) {
		this.itemType = ItemType.valueOfName(itemType);
		for (int i = 0; i < extraFlags.length() ; i++) {
			if (Character.isUpperCase(extraFlags.charAt(i)))
				this.extraFlags.add(ItemExtra.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(extraFlags.substring(i, i+1))));
			else {
				this.extraFlags.add(ItemExtra.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(extraFlags.substring(i, i+2))));
				i++;
			}
		}
		for (int i = 0; i < wearFlags.length() ; i++) {
			if (Character.isUpperCase(wearFlags.charAt(i)))
				this.wearFlags.add(ItemWear.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(wearFlags.substring(i, i+1))));
			else {
				this.wearFlags.add(ItemWear.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(wearFlags.substring(i, i+2))));
				i++;
			}
		}
		this.level = level;
		this.weight = weight;
		this.cost = cost;
		this.cond = cond;
		for(String applyLine : apply.split("\n")) {
			String[] applySplitted = applyLine.split(" ");
			List<String> applySplittedList = new ArrayList<String>();
			applySplittedList.add(applySplitted[1]);
			applySplittedList.add(applySplitted[2]);
			this.apply.add(applySplittedList);
		}
		for(String flagLine : flags.split("\n")) {
			String[] flagSplitted = flagLine.split(" ");
			List<String> flagSplittedList = new ArrayList<String>();
			flagSplittedList.add(flagSplitted[1]);
			flagSplittedList.add(flagSplitted[2]);
			flagSplittedList.add(flagSplitted[3]);
			flagSplittedList.add(flagSplitted[4]);
			this.flags.add(flagSplittedList);
		}
		int index = 0;
		while(extraDescriptions.length() > 1) {
			if(extraDescriptions.charAt(index) != 'E')
				System.out.println("format error");
			index = extraDescriptions.indexOf("\n");
			extraDescriptions = extraDescriptions.substring(index);
			index = extraDescriptions.indexOf("~");
			String[] extraKeywords = extraDescriptions.substring(0, index).split(" ");
			extraDescriptions = extraDescriptions.substring(index);
			index = extraDescriptions.indexOf("~");
			String extraDescText = extraDescriptions.substring(0, index);
			extraDescriptions = extraDescriptions.substring(index);
			this.extraDescriptions.add(new ExtraDescription(Arrays.asList(extraKeywords), extraDescriptions));
		}
			
	}

}
