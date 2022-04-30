package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

public class Pill extends Item {
	
	public int spellLevel;
	public List<String> spellList = new ArrayList<>();
	
	public Pill(
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
		this.spellList.add(v1);
		if (!"".equals(v2))
			this.spellList.add(v2);
		if (!"".equals(v3))
			this.spellList.add(v3);
		if (!"".equals(v4))
			this.spellList.add(v4);
	}

}
