package com.amve;

import org.eclipse.swt.widgets.Display;

import com.amve.gui.VisualEditor;
import com.amve.parser.AreaFileParser;

public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		
		String areaFilePath = "under2.are";
		
		AreaFileParser parser = new AreaFileParser(areaFilePath);
		
		
		try {
			VisualEditor window = new VisualEditor();
//			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}