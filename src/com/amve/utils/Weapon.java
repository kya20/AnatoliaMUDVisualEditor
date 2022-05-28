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
	

	public Weapon(
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
		this.weaponClass = WeaponClass.valueOfName(v0);
		this.dice = new Dice(Integer.parseInt(v1),Integer.parseInt(v2));
		this.damageMessage = v3;
		if (!"0".equals(v4)) {
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
	
	public String vParamsToString() {
		String res = 
				this.weaponClass.name + " " + this.dice.diceNo + " " + 
				this.dice.diceFaces + " " + this.damageMessage + " ";
		if (this.weaponFlags.isEmpty())
			res = res + "0\n";
		else {
			String s = "";
			for (WeaponFlag flag : this.weaponFlags)
				s = s + GlobalVariables.LETTER_TRANSLATIONS_REVERSE.get(flag.num);
			res = res + s + "\n";
		}
		
		return  res;
	}

}
