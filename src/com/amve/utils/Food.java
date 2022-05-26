package com.amve.utils;

public class Food extends Item {
	
	public int hoursFull; // holds the number of game hours the food will keep the person who eats it full
	public int hoursNormal; // holds the number of hours it will keep the person from getting hungry
	public Boolean isPoisoned;

	public Food(
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
		this.hoursFull = Integer.parseInt(v0);
		this.hoursNormal = Integer.parseInt(v1);
		if ("1".equals(v3))
			this.isPoisoned = true;
		else
			this.isPoisoned = false;
	}

	public String vParamsToString() {
		return this.hoursFull + " " + this.hoursNormal + " 0 " + (this.isPoisoned?"1":"0") + " 0\n";
	}
}
