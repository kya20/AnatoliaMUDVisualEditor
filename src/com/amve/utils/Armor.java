package com.amve.utils;

public class Armor extends Item {
	
	public int pierce;
	public int bash;
	public int slash;
	public int exotic;
	public int bulk;

	public Armor(String itemType, String extraFlags, String wearFlags, int level, int weight, int cost, String cond, String v0, String v1, String v2, String v3, String v4) {
		super(itemType, extraFlags, wearFlags, level, weight, cost, cond);
		this.pierce = Integer.parseInt(v0);
		this.bash = Integer.parseInt(v1);
		this.slash = Integer.parseInt(v2);
		this.exotic = Integer.parseInt(v3);
		this.bulk = Integer.parseInt(v4);
	}

}
