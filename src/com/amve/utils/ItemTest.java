package com.amve.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.amve.globals.GlobalVariables.ItemType;

class ItemTest {

	@Test
	void testItem() {
		Item item = new Weapon("weapon", "BI", "AN", "62", 
				"450", "5600", "P", "", "", 
				"E\n"
				+ "scimitar blade~\n"
				+ "It is quite heavy.  The blade is made of some metal that you can't even\n"
				+ "spell.  The edge of the blade looks as if it could cut through anything\n"
				+ "or anyone.\n"
				+ "~", 
				"sword", "10", "7", "cleave", "EF");
		
		assertFalse(item.itemType != ItemType.WEAPON);
		assertFalse(item.level != "62");
		assertFalse(item.weight != "450");
		assertFalse(item.cost != "5600");
		assertFalse(item.cond != "P");
	}

}
