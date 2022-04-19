package com.amve.utils;
import java.util.*;

public class Dice {
	public int diceNo;
	public int diceFaces;
	public int diceBonus;
	
	public Dice() {
		this.diceNo = 0;
		this.diceFaces = 0;
		this.diceBonus = 0;
	}
	
	public Dice(int diceNo, int diceFaces, int diceBonus) {
		this.diceNo = diceNo;
		this.diceFaces = diceFaces;
		this.diceBonus = diceBonus;
	}
	
	public Dice(int diceNo, int diceFaces) {
		this.diceNo = diceNo;
		this.diceFaces = diceFaces;
		this.diceBonus = 0;
	}
	
	public Dice(String input) {
		this.diceNo = 0;
		this.diceFaces = 0;
		this.diceBonus = 0;
		StringTokenizer tokens = new StringTokenizer(input, "d+-");
		if(tokens.hasMoreTokens()) {
			this.diceNo = Integer.parseInt(tokens.nextToken());
		}
		if(tokens.hasMoreTokens()) {
			this.diceFaces = Integer.parseInt(tokens.nextToken());
		}
		if(tokens.hasMoreTokens()) {
			this.diceBonus = Integer.parseInt(tokens.nextToken());
		}
	}
	
	public String toString() {
		return diceNo + "d" + diceFaces + "+" + diceBonus;
	}
}