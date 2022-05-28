package com.amve.utils;

public class Money extends Item {
	
	public int silverValue;
	public int goldValue;

	public Money(
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
		this.silverValue = Integer.parseInt(v0);
		this.goldValue = Integer.parseInt(v1);
	}

	public String vParamsToString() {
		return this.silverValue + " " + this.goldValue + " 0 0 0\n";
	}
}
