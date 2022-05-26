package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

public class ObjectReset {
	
	public String objectVNum;
	public String roomVNum;
	
	public List<PutReset> listContains; // the objects that this object contains in it.
	
	public ObjectReset(String objectVNum, String roomVNum) {
		this.objectVNum = objectVNum;
		this.roomVNum = roomVNum;
	}
	
	public List<PutReset> getListContains() {
		return listContains;
	}
	
	public void addContainedObject(PutReset object) {
		if (this.listContains == null)
			this.listContains = new ArrayList<>();
		this.listContains.add(object);
	}
	
	@Override
	public String toString() {
		return "O 0 " + this.objectVNum + " 0 " + this.roomVNum + "\n";
	}
}
