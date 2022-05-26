package com.amve.area;

import java.util.ArrayList;
import com.amve.utils.Item;

public class Object {
	public String vNum = null;
	public ArrayList<String> nameList = new ArrayList<>();
	public String shortDescription = "";
	public String longDescription = "";
	public String material = "";
	public Item item;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#" + this.vNum + "\n");
		for(int i=0; i < this.nameList.size()-1; i++) {
			sb.append(this.nameList.get(i) + " ");
		}
		sb.append(this.nameList.get(this.nameList.size()-1) + "~\n");
		sb.append(this.shortDescription + "~\n");
		sb.append(this.longDescription + "~\n");
		sb.append(this.material + "~\n");
		
		sb.append(this.item.toString());
		
		return sb.toString();
	}
}