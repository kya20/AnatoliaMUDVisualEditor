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
	public String level;
	public String weight;
	public String cost;
	public String cond;
	public List<List<String>> apply = new ArrayList<>();
	public List<List<String>> flags = new ArrayList<>();
	public List<ExtraDescription> extraDescriptions = new ArrayList<>();
	
	public Item(
			String itemType, 
			String extraFlags, 
			String wearFlags, 
			String level, 
			String weight, 
			String cost, 
			String cond, 
			String apply, 
			String flags, 
			String extraDescriptions
			) {
		this.itemType = ItemType.valueOfName(itemType);
		if (!"0".equals(extraFlags)) {
			for (int i = 0; i < extraFlags.length() ; i++) {
				if (Character.isUpperCase(extraFlags.charAt(i)))
					this.extraFlags.add(ItemExtra.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(extraFlags.substring(i, i+1))));
				else {
					this.extraFlags.add(ItemExtra.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(extraFlags.substring(i, i+2))));
					i++;
				}
			}
		}
		if (!"0".equals(wearFlags)) {
			for (int i = 0; i < wearFlags.length() ; i++) {
				if (Character.isUpperCase(wearFlags.charAt(i)))
					this.wearFlags.add(ItemWear.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(wearFlags.substring(i, i+1))));
				else {
					this.wearFlags.add(ItemWear.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(wearFlags.substring(i, i+2))));
					i++;
				}
			}
		}
		
		this.level = level;
		this.weight = weight;
		this.cost = cost;
		this.cond = cond;
		if (!"".equals(apply)) {
			for(String applyLine : apply.split("\n")) {
				String[] applySplitted = applyLine.split(" ");
				List<String> applySplittedList = new ArrayList<String>();
				applySplittedList.add(applySplitted[0]);
				applySplittedList.add(applySplitted[1]);
				this.apply.add(applySplittedList);
			}
		}
		if (!"".equals(flags)) {
			for(String flagLine : flags.split("\n")) {
				String[] flagSplitted = flagLine.split(" ");
				List<String> flagSplittedList = new ArrayList<String>();
				flagSplittedList.add(flagSplitted[1]);
				flagSplittedList.add(flagSplitted[2]);
				flagSplittedList.add(flagSplitted[3]);
				flagSplittedList.add(flagSplitted[4]);
				this.flags.add(flagSplittedList);
			}
		}
		if (!"".equals(extraDescriptions)) {
			int index = 0;
			while(extraDescriptions.length() > 1) {
				if(extraDescriptions.charAt(index) != 'E')
					System.out.println("format error");
				index = extraDescriptions.indexOf("\n");
				extraDescriptions = extraDescriptions.substring(index+1);
				index = extraDescriptions.indexOf("~");
				String[] extraKeywords = extraDescriptions.substring(0, index).split(" ");
				extraDescriptions = extraDescriptions.substring(index+1);
				while(Character.isWhitespace(extraDescriptions.charAt(index)))
					index++;
				index = extraDescriptions.indexOf("~");
				String extraDescText = extraDescriptions.substring(1, index);
				extraDescriptions = extraDescriptions.substring(index);
				this.extraDescriptions.add(new ExtraDescription(Arrays.asList(extraKeywords), extraDescText));
			}
		}
			
			
	}
	
	public String vParamsToString() {
		return "0 0 0 0 0\n";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.itemType.name + " ");
		String s = "";
		if(this.extraFlags.isEmpty())
			s = "0";
		else
			for(ItemExtra flag : this.extraFlags)
				s = s + GlobalVariables.LETTER_TRANSLATIONS_REVERSE.get(flag.num);
			
		sb.append(s + " ");
		s = "";
		if(this.wearFlags.isEmpty())
			s = "0";
		else
			for (ItemWear flag : this.wearFlags)
				s = s + GlobalVariables.LETTER_TRANSLATIONS_REVERSE.get(flag.num);
		
		sb.append(s + "\n");
		sb.append(vParamsToString());
		sb.append(this.level + " " + this.weight + " " + this.cost + " " + this.cond + "\n");
		
		for (List<String> applyList : this.apply) {
			sb.append("A\n" + applyList.get(0) + " " + applyList.get(1) + "\n");
		}
		
		for (List<String> flagLine : this.flags) {
			sb.append(
					"F " + flagLine.get(0) + " " + flagLine.get(1) + " " + 
					flagLine.get(2) + " " + flagLine.get(3) + " " + flagLine.get(4) + "\n");
		}
		
		this.extraDescriptions.forEach(ed -> sb.append(ed.toString()));
		
//		for (ExtraDescription extraDescription : this.extraDescriptions) {
//			sb.append("E\n");
//			for(int i=0; i < extraDescription.extraDesciptionKeyword.size() ; i++) {
//				sb.append(extraDescription.extraDesciptionKeyword.get(i) + " ");
//			}
//			sb.append(extraDescription.extraDesciptionKeyword.get(extraDescription.extraDesciptionKeyword.size()) + "~\n");
//			sb.append(extraDescription.extraDescriptionText + "~\n");
//		}
		
		return sb.toString();
	}
}
