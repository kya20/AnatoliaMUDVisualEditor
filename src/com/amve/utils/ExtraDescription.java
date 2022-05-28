package com.amve.utils;

import java.util.ArrayList;
import java.util.List;

public class ExtraDescription {
	public List<String> extraDesciptionKeyword = new ArrayList<>();
	public String extraDescriptionText = "";
	
	public ExtraDescription(List<String> extraDesciptionKeyword, String extraDescriptionText) {
		this.extraDesciptionKeyword = extraDesciptionKeyword;
		this.extraDescriptionText = extraDescriptionText;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("E\n");
		for(int i=0; i < this.extraDesciptionKeyword.size()-1 ; i++) {
			sb.append(this.extraDesciptionKeyword.get(i) + " ");
		}
		sb.append(this.extraDesciptionKeyword.get(this.extraDesciptionKeyword.size()-1) + "~\n");
		sb.append(this.extraDescriptionText + "~\n");
		return sb.toString();
	}
}
