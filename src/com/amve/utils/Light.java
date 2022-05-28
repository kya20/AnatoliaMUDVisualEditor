package com.amve.utils;

public class Light extends Item {
	
	public int lightDuration;

	public Light(
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
		this.lightDuration = Integer.parseInt(v2);
	}

	public Boolean isPermanent() {
		return this.lightDuration == -1;
	}
	
	public String vParamsToString() {
		return "0 0 " + this.lightDuration + " 0 0\n";
	}
}
