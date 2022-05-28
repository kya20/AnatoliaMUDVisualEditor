package com.amve.utils;

public class Fountain extends Item {
	
	public int containerSize;
	public int currentAmount;
	public String liquidType;

	public Fountain(
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
		this.containerSize = Integer.parseInt(v0);
		this.currentAmount = Integer.parseInt(v1);
		this.liquidType = v2;
		
	}

	public String vParamsToString() {
		return this.containerSize + " " + this.currentAmount + " " + this.liquidType + " 0 0\n";
	}
}
