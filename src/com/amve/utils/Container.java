package com.amve.utils;

import java.util.List;

public class Container extends Item {
	
	public int maxTotalWeight; // max capacity of the bag
	public List<String> flags;
	public int maxItemWeight; // max weight of a single item the bag can hold.
	public int weightMultiplier;

	public Container(
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
		this.maxTotalWeight = Integer.parseInt(v0);
		// TODO could not find any info on flags make sure to implement flag related code.
		this.maxItemWeight = Integer.parseInt(v3);
		this.weightMultiplier = Integer.parseInt(v4);
	}

}
