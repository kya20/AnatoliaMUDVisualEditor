package com.amve.utils;

public class Drink extends Item {
	
	public int containerSize;
	public int currentAmount;
	public int liquidType;
	public Boolean isPoisoned;

	public Drink(
			String itemType, 
			String extraFlags, 
			String wearFlags, 
			int level, 
			int weight, 
			int cost,
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
		// TODO continue from here
	}

}
