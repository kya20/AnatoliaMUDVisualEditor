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
	
}
