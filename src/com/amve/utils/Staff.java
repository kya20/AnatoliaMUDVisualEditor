package com.amve.utils;

public class Staff extends Item {
	public int spellLevel;
	public int maxCharges;
	public int curCharges;
	public String spellName;
	
	public Staff(
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
		this.spellLevel = Integer.parseInt(v0);
		this.maxCharges = Integer.parseInt(v1);
		this.curCharges = Integer.parseInt(v2);
		this.spellName = v3;
	}

}
