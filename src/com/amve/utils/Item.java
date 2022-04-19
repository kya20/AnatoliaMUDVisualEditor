package com.amve.utils;

import java.util.ArrayList;
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
	
	public Item(String itemType, String extraFlags, String wearFlags, int level, int weight, int cost, String cond) {
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
	}
}
