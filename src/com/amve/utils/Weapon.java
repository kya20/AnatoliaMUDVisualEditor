package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.WeaponClass;
import com.amve.globals.GlobalVariables.WeaponFlag;

public class Weapon extends Item {
	
	public WeaponClass weaponClass;
	public Dice dice;
	public String damageMessage;
	public List<WeaponFlag> weaponFlags = new ArrayList<>();
	

	public Weapon(String itemType, String extraFlags, String wearFlags, int level, int weight, int cost, String cond, String v0, String v1, String v2, String v3, String v4) {
		super(itemType, extraFlags, wearFlags, level, weight, cost, cond);
		this.weaponClass = WeaponClass.valueOfName(v0);
		this.dice = new Dice(Integer.parseInt(v1),Integer.parseInt(v2));
		this.damageMessage = v3;
		for (int i = 0; i < v4.length() ; i++) {
			if (Character.isUpperCase(v4.charAt(i)))
				this.weaponFlags.add(WeaponFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(v4.substring(i, i+1))));
			else {
				this.weaponFlags.add(WeaponFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(v4.substring(i, i+2))));
				i++;
			}
		}
		
	}

}
