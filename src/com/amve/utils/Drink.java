package com.amve.utils;

public class Drink extends Item {
	
	public int containerSize;
	public int currentAmount;
	public String liquidType;
	public Boolean isPoisoned;

	public Drink(
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
		if ("1".equals(v3))
			this.isPoisoned = true;
		else
			this.isPoisoned = false;
	}

	public String vParamsToString() {
		return this.containerSize + " " + this.currentAmount + " " + 
				this.liquidType + " " + (this.isPoisoned?"1":"0") + " 0\n";
	}
}
