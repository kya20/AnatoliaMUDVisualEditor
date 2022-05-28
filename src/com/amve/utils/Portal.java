package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.GateFlag;

public class Portal extends Item {

	public int maxCharges; // -1 for permanent
	public List<String> exitFlags = new ArrayList<>();
	public List<GateFlag> gateFlags = new ArrayList<>();
	public int destinationVNum; // the vnum of the room portal goes to.
	
	
	public Portal(
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
		this.maxCharges = Integer.parseInt(v0);
		// TODO add exitFlags? I am not sure what this is, maybe doorFlags used by RESETS?
		for (int i = 0; i < v2.length() ; i++) {
			this.gateFlags.add(GateFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(v2.substring(i, i+1))));
		}
		this.destinationVNum = Integer.parseInt(v3);		
	}

	public String vParamsToString() {
		String res = this.maxCharges + " 0 ";
		if (this.gateFlags.isEmpty())
			res = res + "0 ";
		else {
			String s = "";
			for (GateFlag flag : this.gateFlags)
				s = s + GlobalVariables.LETTER_TRANSLATIONS_REVERSE.get(flag.num);
			res = res + s + " ";
		}
		res = res + this.destinationVNum + " 0\n";
		return  res;
	}
}
