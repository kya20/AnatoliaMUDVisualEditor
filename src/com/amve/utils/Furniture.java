package com.amve.utils;

import java.util.List;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.FurnitureFlag;

public class Furniture extends Item {
	
	public int numUsers;
	public int maxWeight;
	public List<FurnitureFlag> furnitureFlags;
	public int healingBonus;
	public int manaBonus;

	public Furniture(
			String itemType, 
			String extraFlags, 
			String wearFlags, 
			String level, 
			String weight, 
			String cost,
			String cond, 
			String apply, 
			String flags, 
			String extraDescriptions,
			String v0, 
			String v1, 
			String v2, 
			String v3, 
			String v4
			) {
		super(itemType, extraFlags, wearFlags, level, weight, cost, cond, apply, flags, extraDescriptions);
		this.numUsers = Integer.parseInt(v0);
		this.maxWeight = Integer.parseInt(v1);
		for (int i = 0; i < v2.length() ; i++) {
			this.furnitureFlags.add(FurnitureFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(v2.substring(i, i+1))));
		}
		this.healingBonus = Integer.parseInt(v3);
		this.manaBonus = Integer.parseInt(v4);
		
	}

	public String vParamsToString() {
		String res = this.numUsers + " " + this.maxWeight + " ";
		if (this.furnitureFlags.isEmpty())
			res = res + "0 ";
		else {
			String s = "";
			for (FurnitureFlag flag : this.furnitureFlags)
				s = s + GlobalVariables.LETTER_TRANSLATIONS_REVERSE.get(flag.num);
			res = res + s + " ";
		}
		res = res + this.healingBonus + " " + this.manaBonus + "\n";
		return  res;
	}
}
