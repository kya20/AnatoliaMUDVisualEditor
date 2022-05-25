package com.amve.area;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private String mobileVNum = "";
	private List<String> buyItemTypes = new ArrayList<>();
	private int buyMultiplier; // The markup percentage for the prices of the items in sale.
	private int sellMultiplier; // The markdown percentage for the prices of the items the seller will accept to buy from customer.
	private int openHour;
	private int closeHour;
	
	public String getMobileVNum() {
		return mobileVNum;
	}
	public void setMobileVNum(String mobileVNum) {
		this.mobileVNum = mobileVNum;
	}
	public List<String> getBuyItemTypes() {
		return buyItemTypes;
	}
	public void addBuyItemType(String type) {
		this.buyItemTypes.add(type);
	}
	public int getBuyMultiplier() {
		return buyMultiplier;
	}
	public void setBuyMultiplier(int buyMultiplier) {
		this.buyMultiplier = buyMultiplier;
	}
	public int getSellMultiplier() {
		return sellMultiplier;
	}
	public void setSellMultiplier(int sellMultiplier) {
		this.sellMultiplier = sellMultiplier;
	}
	public int getOpenHour() {
		return openHour;
	}
	public void setOpenHour(int openHour) {
		this.openHour = openHour;
	}
	public int getCloseHour() {
		return closeHour;
	}
	public void setCloseHour(int closeHour) {
		this.closeHour = closeHour;
	}
	
}