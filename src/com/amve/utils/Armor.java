package com.amve.utils;

public class Armor extends Item {
	
	public String pierce;
	public String bash;
	public String slash;
	public String exotic;
	public String bulk;

	public Armor(
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
		this.pierce = v0;
		this.bash = v1;
		this.slash = v2;
		this.exotic = v3;
		this.bulk = v4;
	}

	public String vParamsToString() {
		return this.pierce + " " + this.bash + " " + 
				this.slash + " " + this.exotic + " " + 
				this.bulk + "\n";
	}
}
