package com.amve.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Tree;

import com.amve.area.Room;
import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.DoorFlag;
import com.amve.globals.GlobalVariables.ExitDirection;
import com.amve.globals.GlobalVariables.RoomFlag;
import com.amve.parser.AreaFileParser;
import com.amve.utils.Exit;
import com.amve.utils.ExtraDescription;
import com.amve.utils.MobileReset;
import com.amve.utils.ObjectReset;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import javax.swing.JPanel;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.core.resources.*;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Scale;

import org.eclipse.core.databinding.*;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;

public class VisualEditor {
	private DataBindingContext m_bindingContext;

	protected Display display;
	protected Shell shell;
	private String filePath;
	private AreaFileParser parser = new AreaFileParser("under2.are");
	private String deneme;
	private Text text;
	private Text roomNameText;
	private Text roomDescText;
	private Table roomExtrasTable;
	private Text northDescText;
	private Text northDoorKeywordText;
	private Text eastDescText;
	private Text eastDoorKeywordText;
	private Text southDescText;
	private Text southDoorKeywordText;
	private Text westDescText;
	private Text westDoorKeywordText;
	private Text upDescText;
	private Text upDoorKeywordText;
	private Text downDescText;
	private Text downDoorKeywordText;
	private Tree tree;
	private Spinner RoomVnumSpinner;
	private Group grpDoors;
	private TableViewerColumn tableViewerColumn;
	private TableViewerColumn tableViewerColumn_1;
	private Combo northDoorStateCombo;
	private Composite northComposite;
	private Combo northDoorKeyCombo;
	private Combo northDoorSizeCombo;
	private Button northDoorFlagJCheck;
	private Button northDoorFlagHCheck;
	private Button northDoorFlagKCheck;
	private Button northDoorFlagACheck;
	private Button northDoorFlagBCheck;
	private Button northDoorFlagICheck;
	private Button northDoorFlagFCheck;
	private Button northDoorFlagCCheck;
	private Button northDoorFlagLCheck;
	private Button northDoorFlagGCheck;
	private Combo eastDoorStateCombo;
	private Combo eastDoorKeyCombo;
	private Combo eastDoorSizeCombo;
	private Button eastDoorFlagJCheck;
	private Button eastDoorFlagACheck;
	private Button eastDoorFlagICheck;
	private Button eastDoorFlagCCheck;
	private Button eastDoorFlagFCheck;
	private Button eastDoorFlagGCheck;
	private Button eastDoorFlagHCheck;
	private Button eastDoorFlagKCheck;
	private Button eastDoorFlagLCheck;
	private Button eastDoorFlagBCheck;
	private Combo southDoorKeyCombo;
	private Combo southDoorStateCombo;
	private Combo southDoorSizeCombo;
	private Button southDoorFlagICheck;
	private Button southDoorFlagKCheck;
	private Button southDoorFlagCCheck;
	private Button southDoorFlagJCheck;
	private Button southDoorFlagLCheck;
	private Button southDoorFlagGCheck;
	private Button southDoorFlagACheck;
	private Button southDoorFlagBCheck;
	private Button southDoorFlagFCheck;
	private Button southDoorFlagHCheck;
	private Combo westDoorSizeCombo;
	private Combo westDoorKeyCombo;
	private Combo westDoorStateCombo;
	private Button westDoorFlagFCheck;
	private Button westDoorFlagGCheck;
	private Button westDoorFlagKCheck;
	private Button westDoorFlagACheck;
	private Button westDoorFlagICheck;
	private Button westDoorFlagLCheck;
	private Button westDoorFlagHCheck;
	private Button westDoorFlagJCheck;
	private Button westDoorFlagBCheck;
	private Button westDoorFlagCCheck;
	private Combo upDoorStateCombo;
	private Combo upDoorKeyCombo;
	private Combo upDoorSizeCombo;
	private Button upDoorFlagACheck;
	private Button upDoorFlagKCheck;
	private Button upDoorFlagBCheck;
	private Button upDoorFlagFCheck;
	private Button upDoorFlagLCheck;
	private Button upDoorFlagCCheck;
	private Button upDoorFlagJCheck;
	private Button upDoorFlagICheck;
	private Button upDoorFlagGCheck;
	private Button upDoorFlagHCheck;
	private Combo downDoorKeyCombo;
	private Combo downDoorStateCombo;
	private Combo downDoorSizeCombo;
	private Button downDoorFlagACheck;
	private Button downDoorFlagGCheck;
	private Button downDoorFlagHCheck;
	private Button downDoorFlagBCheck;
	private Button downDoorFlagJCheck;
	private Button downDoorFlagCCheck;
	private Button downDoorFlagFCheck;
	private Button downDoorFlagKCheck;
	private Button downDoorFlagICheck;
	private Button downDoorFlagLCheck;
	private Scale roomHPScale;
	private Spinner roomHPSpinner;
	private Scale roomMPScale;
	private Spinner roomMPSpinner;
	private Button roomSectorMountain;
	private Button roomSectorCity;
	private Button roomSectorForest;
	private Button roomSectorHill;
	private Button roomSectorDeepWater;
	private Button roomSectorWater;
	private Button roomSectorInside;
	private Button roomSectorDesert;
	private Button roomSectorAir;
	private Button roomSectorField;
	private Button roomSectorUnused;
	private Button btnRoomDark;
	private Button btnRoomNoMob;
	private Button btnRoomIndoors;
	private Button btnRoomPrivate;
	private Button btnRoomSafe;
	private Button btnRoomSolitary;
	private Button btnRoomPetShop;
	private Button btnRoomNoRecall;
	private Button btnRoomImpOnly;
	private Button btnRoomGodsOnly;
	private Button btnRoomHeroesOnly;
	private Button btnRoomNewbiesOnly;
	private Button btnRoomLaw;
	private Button btnRoomNowhere;
	private Button btnRoomBank;
	private Button btnRoomNoMagic;
	private Button btnRoomNoSummon;
	private Button btnRoomRegistry;
	private SashForm sashForm_1;
	private Group grpVisual;
	private Group grpValues;
	private Group grpActAffOffFlags;
	private Group grpShopspecial;
	private Group grpDescription_1;
	private Group grpAppearance;
	private Group grpFlags;
	private Text mobNameText;
	private Text mobShortDescText;
	private Text mobLongDescText;
	private Text mobLookDescText;
	private Text mobMaterialText;
	private Button btnMist;
	private Button btnIntangible;
	private Button btnBiped;
	private Button btnCentaur;
	private Button btnInsect;
	private Button btnSpider;
	private Button btnCrustacean;
	private Button btnWorm;
	private Button btnBlob;
	private Button btnMammal;
	private Button btnBird;
	private Button btnReptile;
	private Button btnSnake;
	private Button btnDragon;
	private Button btnAmphibian;
	private Button btnFish;
	private Button btnColdBlood;
	private Group grpPartsFlags;
	private Button btnHead;
	private Button btnArms;
	private Button btnLegs;
	private Button btnHeart;
	private Button btnBrains;
	private Button btnGuts;
	private Button btnHands;
	private Button btnFeet;
	private Button btnFingers;
	private Button btnEar;
	private Button btnEye;
	private Button btnTongue;
	private Button btnEyestalks;
	private Button btnTentacles;
	private Button btnFins;
	private Button btnWings;
	private Button btnTail;
	private Button btnClaws;
	private Button btnFangs;
	private Button btnHorns;
	private Button btnScales;
	private Button btnTusks;
	private Group grpCombatValues;
	private Group grpImmresvuln;
	private Label lblSummon;
	private Label lblCharm;
	private Label lblMagic;
	private Label lblWeapons;
	private Label lblBash;
	private Label lblPierce;
	private Label lblSlash;
	private Label lblFire;
	private Label lblCold;
	private Label lblLightning;
	private Label lblAcid;
	private Label lblPoison;
	private Label lblNegative;
	private Label lblHoly;
	private Label lblEnergy;
	private Label lblMental;
	private Label lblDisease;
	private Label lblDrowning;
	private Label lblLight;
	private Label lblSound;
	private Label lblWood;
	private Label lblSilver;
	private Label lblIron;
	private Label lblImmune;
	private Label lblResistant;
	private Label lblVuln;
	private Label label;
	private Button summonImm;
	private Button summonRes;
	private Button pierceRes;
	private Button pierceVuln;
	private Button slashImm;
	private Button slashRes;
	private Button slashVuln;
	private Button fireImm;
	private Button fireRes;
	private Button fireVuln;
	private Button coldImm;
	private Button coldRes;
	private Button coldVuln;
	private Button lightningImm;
	private Button lightningRes;
	private Button lightningVuln;
	private Button acidImm;
	private Button acidRes;
	private Button acidVuln;
	private Button poisonImm;
	private Button poisonRes;
	private Button poisonVuln;
	private Button negativeImm;
	private Button negativeRes;
	private Button negativeVuln;
	private Button holyImm;
	private Button holyRes;
	private Button holyVuln;
	private Button energyImm;
	private Button energyRes;
	private Button energyVuln;
	private Button mentalImm;
	private Button mentalRes;
	private Button mentalVuln;
	private Button diseaseImm;
	private Button diseaseRes;
	private Button diseaseVuln;
	private Button drowningImm;
	private Button drowningRes;
	private Button drowningVuln;
	private Button lightImm;
	private Button lightRes;
	private Button lightVuln;
	private Button soundImm;
	private Button soundRes;
	private Button soundVuln;
	private Button woodImm;
	private Button woodRes;
	private Button woodVuln;
	private Button silverImm;
	private Button silverRes;
	private Button silverVuln;
	private Button ironImm;
	private Button ironRes;
	private Button ironVuln;
	private Text mobTreasure;
	private Text mobGroup;
	private Text mobPierceAC;
	private Text mobBashAC;
	private Text mobSlashAC;
	private Text mobMagicAC;
	private Group grpDice;
	private Label lblHit;
	private Label lblMana;
	private Label lblDmg;
	private Text mobHitDice1;
	private Label lblD;
	private Text mobHitDice2;
	private Label label_1;
	private Text mobHitDice3;
	private Text mobManaDice1;
	private Text mobDamageDice1;
	private Text mobManaDice2;
	private Text mobManaDice3;
	private Text mobDamageDice2;
	private Text mobDamageDice3;
	private Text text_3;
	private Text text_4;
	private Text txtTxt;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					
					VisualEditor window = new VisualEditor();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/*
	 * Update contents of the window from parser.
	 * */
	private void updateContents() {
		
	}
	
	private void updateRoomPanel(String key) {
		RoomVnumSpinner.setSelection(Integer.parseInt(key));
		parser.getArea().getRooms().get(key);
		setRoomNameTextVal(parser.getArea().getRooms().get(key).getHeader());
		setRoomDescTextVal(parser.getArea().getRooms().get(key).description);
		roomExtrasTable.removeAll();
		for (ExtraDescription extra : parser.getArea().getRooms().get(key).extras) {
			TableItem extrasItem = new TableItem(roomExtrasTable, SWT.NONE);
			String ss = "";
			for (String s : extra.extraDesciptionKeyword) {
				ss += s + ", ";
				
			}
			if (ss.endsWith(", ")) {
				ss = ss.substring(0, ss.length() - 2);
			};
			extrasItem.setText(0, ss);
			extrasItem.setText(1, extra.extraDescriptionText);
		}
		getRoomHPSpinner().setSelection(Integer.parseInt(parser.getArea().getRooms().get(key).healingAdjust));
		getRoomMPSpinner().setSelection(Integer.parseInt(parser.getArea().getRooms().get(key).manaAdjust));
		
		//room flag buttons
		getBtnRoomDark().setSelection(false);
		getBtnRoomNoMob().setSelection(false);
		getBtnRoomIndoors().setSelection(false);
		getBtnRoomPrivate().setSelection(false);
		getBtnRoomSafe().setSelection(false);
		getBtnRoomSolitary().setSelection(false);
		getBtnRoomPetShop().setSelection(false);
		getBtnRoomNoRecall().setSelection(false);
		getBtnRoomImpOnly().setSelection(false);
		getBtnRoomGodsOnly().setSelection(false);
		getBtnRoomHeroesOnly().setSelection(false);
		getBtnRoomNewbiesOnly().setSelection(false);
		getBtnRoomLaw().setSelection(false);
		getBtnRoomNowhere().setSelection(false);
		getBtnRoomBank().setSelection(false);
		getBtnRoomNoMagic().setSelection(false);
		getBtnRoomNoSummon().setSelection(false);
		getBtnRoomRegistry().setSelection(false);
		
		if (parser.getArea().getRooms().get(key).roomFlags == null || parser.getArea().getRooms().get(key).roomFlags.isEmpty()) {
			System.out.println("null/empty flags: " + key);
			System.out.println(parser.getArea().getRooms().get(key).header);
		}
		for (RoomFlag flag : parser.getArea().getRooms().get(key).roomFlags) {
			if (flag == null) { //it's always room 16160 forgotten alley
				System.out.println("null flag: " + key);
				System.out.println(parser.getArea().getRooms().get(key).header);
			}
			switch (flag.name) {
			case "dark":
				getBtnRoomDark().setSelection(true);
				break;
			case "no mob":
				getBtnRoomNoMob().setSelection(true);
				break;
			case "indoors":
				getBtnRoomIndoors().setSelection(true);
				break;
			case "private":
				getBtnRoomPrivate().setSelection(true);
				break;
			case "safe":
				getBtnRoomSafe().setSelection(true);
				break;
			case "solitary":
				getBtnRoomSolitary().setSelection(true);
				break;
			case "pet shop":
				getBtnRoomPetShop().setSelection(true);
				break;
			case "no recall":
				getBtnRoomNoRecall().setSelection(true);
				break;
			case "imp only":
				getBtnRoomImpOnly().setSelection(true);
				break;
			case "gods only":
				getBtnRoomGodsOnly().setSelection(true);
				break;
			case "heroes only":
				getBtnRoomHeroesOnly().setSelection(true);
				break;
			case "newbies only":
				getBtnRoomNewbiesOnly().setSelection(true);
				break;
			case "law":
				getBtnRoomLaw().setSelection(true);
				break;
			case "nowhere":
				getBtnRoomNowhere().setSelection(true);
				break;
			case "bank":
				getBtnRoomBank().setSelection(true);
				break;
			case "no magic":
				getBtnRoomNoMagic().setSelection(true);
				break;
			case "no summon":
				getBtnRoomNoSummon().setSelection(true);
				break;
			case "registry":
				getBtnRoomRegistry().setSelection(true);
				break;
			}
		}
		
		//sector buttons
		if (parser.getArea().getRooms().get(key).roomSector == null) {
			System.out.println("null sectors: " + key);
			System.out.println(parser.getArea().getRooms().get(key).header);
		}
		switch (parser.getArea().getRooms().get(key).roomSector.name) {
		case "inside":
			getRoomSectorInside().setSelection(true);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "city":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(true);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "field":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(true);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "forest":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(true);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "hill":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(true);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "mountain":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(true);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "water":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(true);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "deep water":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(true);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "unused":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(true);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(false);
			break;
		case "air":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(true);
			getRoomSectorDesert().setSelection(false);
			break;
		case "desert":
			getRoomSectorInside().setSelection(false);
			getRoomSectorCity().setSelection(false);
			getRoomSectorField().setSelection(false);
			getRoomSectorForest().setSelection(false);
			getRoomSectorHill().setSelection(false);
			getRoomSectorMountain().setSelection(false);
			getRoomSectorWater().setSelection(false);
			getRoomSectorDeepWater().setSelection(false);
			getRoomSectorUnused().setSelection(false);
			getRoomSectorAir().setSelection(false);
			getRoomSectorDesert().setSelection(true);
			break;
		}
		
		//reset stuff
		getNorthDescText().setText("");
		getNorthDoorKeywordText().setText("");
		getNorthDoorStateCombo().select(-1);
		getNorthDoorFlagACheck().setSelection(false);
		getNorthDoorFlagBCheck().setSelection(false);
		getNorthDoorFlagCCheck().setSelection(false);
		//getNorthDoorFlagDCheck().setSelection(false);
		getNorthDoorFlagFCheck().setSelection(false);
		getNorthDoorFlagGCheck().setSelection(false);
		getNorthDoorFlagHCheck().setSelection(false);
		getNorthDoorFlagICheck().setSelection(false);
		getNorthDoorFlagJCheck().setSelection(false);
		getNorthDoorFlagKCheck().setSelection(false);
		getNorthDoorFlagLCheck().setSelection(false);
		
		getEastDescText().setText("");
		getEastDoorKeywordText().setText("");
		getEastDoorStateCombo().select(-1);
		getEastDoorFlagACheck().setSelection(false);
		getEastDoorFlagBCheck().setSelection(false);
		getEastDoorFlagCCheck().setSelection(false);
		//getEastDoorFlagDCheck().setSelection(false);
		getEastDoorFlagFCheck().setSelection(false);
		getEastDoorFlagGCheck().setSelection(false);
		getEastDoorFlagHCheck().setSelection(false);
		getEastDoorFlagICheck().setSelection(false);
		getEastDoorFlagJCheck().setSelection(false);
		getEastDoorFlagKCheck().setSelection(false);
		getEastDoorFlagLCheck().setSelection(false);
		
		getSouthDescText().setText("");
		getSouthDoorKeywordText().setText("");
		getSouthDoorStateCombo().select(-1);
		getSouthDoorFlagACheck().setSelection(false);
		getSouthDoorFlagBCheck().setSelection(false);
		getSouthDoorFlagCCheck().setSelection(false);
		//getSouthDoorFlagDCheck().setSelection(false);
		getSouthDoorFlagFCheck().setSelection(false);
		getSouthDoorFlagGCheck().setSelection(false);
		getSouthDoorFlagHCheck().setSelection(false);
		getSouthDoorFlagICheck().setSelection(false);
		getSouthDoorFlagJCheck().setSelection(false);
		getSouthDoorFlagKCheck().setSelection(false);
		getSouthDoorFlagLCheck().setSelection(false);
		
		getWestDescText().setText("");
		getWestDoorKeywordText().setText("");
		getWestDoorStateCombo().select(-1);
		getWestDoorFlagACheck().setSelection(false);
		getWestDoorFlagBCheck().setSelection(false);
		getWestDoorFlagCCheck().setSelection(false);
		//getWestDoorFlagDCheck().setSelection(false);
		getWestDoorFlagFCheck().setSelection(false);
		getWestDoorFlagGCheck().setSelection(false);
		getWestDoorFlagHCheck().setSelection(false);
		getWestDoorFlagICheck().setSelection(false);
		getWestDoorFlagJCheck().setSelection(false);
		getWestDoorFlagKCheck().setSelection(false);
		getWestDoorFlagLCheck().setSelection(false);
		
		getUpDescText().setText("");
		getUpDoorKeywordText().setText("");
		getUpDoorStateCombo().select(-1);
		getUpDoorFlagACheck().setSelection(false);
		getUpDoorFlagBCheck().setSelection(false);
		getUpDoorFlagCCheck().setSelection(false);
		//getUpDoorFlagDCheck().setSelection(false);
		getUpDoorFlagFCheck().setSelection(false);
		getUpDoorFlagGCheck().setSelection(false);
		getUpDoorFlagHCheck().setSelection(false);
		getUpDoorFlagICheck().setSelection(false);
		getUpDoorFlagJCheck().setSelection(false);
		getUpDoorFlagKCheck().setSelection(false);
		getUpDoorFlagLCheck().setSelection(false);
		
		getDownDescText().setText("");
		getDownDoorKeywordText().setText("");
		getDownDoorStateCombo().select(-1);
		getDownDoorFlagACheck().setSelection(false);
		getDownDoorFlagBCheck().setSelection(false);
		getDownDoorFlagCCheck().setSelection(false);
		//getDownDoorFlagDCheck().setSelection(false);
		getDownDoorFlagFCheck().setSelection(false);
		getDownDoorFlagGCheck().setSelection(false);
		getDownDoorFlagHCheck().setSelection(false);
		getDownDoorFlagICheck().setSelection(false);
		getDownDoorFlagJCheck().setSelection(false);
		getDownDoorFlagKCheck().setSelection(false);
		getDownDoorFlagLCheck().setSelection(false);
		for (Map.Entry<ExitDirection, Exit> ex : parser.getArea().getRooms().get(key).exits.entrySet()) {
			int i = ex.getKey().num;
			switch (i) {
			case 0: //north
				getNorthDescText().setText("");
				getNorthDescText().setText(ex.getValue().exitDescription);
				String kw = "";
				for(String j : ex.getValue().keyWords) {
					kw += j + ", ";
				}
				if (kw.endsWith(", ")) {
					kw = kw.substring(0, kw.length() - 2);
				}
				getNorthDoorKeywordText().setText(kw);
				switch(ex.getValue().doorState.num) {
				case 0:
					getNorthDoorStateCombo().select(0);
					break;
				case 1:
					getNorthDoorStateCombo().select(1);
					break;
				case 2:
					getNorthDoorStateCombo().select(2);
					break;
				}
				if (ex.getValue().doorFlags != null) {
					if (!ex.getValue().doorFlags.isEmpty()) {
						//TODO: Implement door size and its GUI connection
						for (DoorFlag f : ex.getValue().doorFlags) {
							switch ((f.num)) {
							case 1: //A
								getNorthDoorFlagACheck().setSelection(true);
								break;
							case 2: //B
								getNorthDoorFlagBCheck().setSelection(true);
								break;
							case 4: //C
								getNorthDoorFlagCCheck().setSelection(true);
								break;
							case 8: //D
								//TODO: implement new flag entry if required
								//getNorthDoorFlagDCheck().setSelection(true);
								break;
							case 16: //E not used?
								break;
							case 32: //F
								getNorthDoorFlagFCheck().setSelection(true);
								break;
							case 64: //G
								getNorthDoorFlagGCheck().setSelection(true);
								break;
							case 128: //H
								getNorthDoorFlagHCheck().setSelection(true);
								break;
							case 256: //I
								getNorthDoorFlagICheck().setSelection(true);
								break;
							case 512: //J
								getNorthDoorFlagJCheck().setSelection(true);
								break;
							case 1024: //K
								getNorthDoorFlagKCheck().setSelection(true);
								break;
							case 2048: //L
								getNorthDoorFlagLCheck().setSelection(true);
								break;
							}
						} 
					} 
				}
				break;
			case 1: //east
				getEastDescText().setText("");
				getEastDescText().setText(ex.getValue().exitDescription);
				String kw1 = "";
				for(String j : ex.getValue().keyWords) {
					kw1 += j + ", ";
				}
				if (kw1.endsWith(", ")) {
					kw1 = kw1.substring(0, kw1.length() - 2);
				}
				getEastDoorKeywordText().setText(kw1);
				switch(ex.getValue().doorState.num) {
				case 0:
					getEastDoorStateCombo().select(0);
					break;
				case 1:
					getEastDoorStateCombo().select(1);
					break;
				case 2:
					getEastDoorStateCombo().select(2);
					break;
				}
				if (ex.getValue().doorFlags != null) {
					if (!ex.getValue().doorFlags.isEmpty()) {
						//TODO: Implement door size and its GUI connection
						for (DoorFlag f : ex.getValue().doorFlags) {
							switch ((f.num)) {
							case 1: //A
								getEastDoorFlagACheck().setSelection(true);
								break;
							case 2: //B
								getEastDoorFlagBCheck().setSelection(true);
								break;
							case 4: //C
								getEastDoorFlagCCheck().setSelection(true);
								break;
							case 8: //D
								//TODO: implement new flag entry if required
								//getEastDoorFlagDCheck().setSelection(true);
								break;
							case 16: //E not used?
								break;
							case 32: //F
								getEastDoorFlagFCheck().setSelection(true);
								break;
							case 64: //G
								getEastDoorFlagGCheck().setSelection(true);
								break;
							case 128: //H
								getEastDoorFlagHCheck().setSelection(true);
								break;
							case 256: //I
								getEastDoorFlagICheck().setSelection(true);
								break;
							case 512: //J
								getEastDoorFlagJCheck().setSelection(true);
								break;
							case 1024: //K
								getEastDoorFlagKCheck().setSelection(true);
								break;
							case 2048: //L
								getEastDoorFlagLCheck().setSelection(true);
								break;
							}
						} 
					} 
				}
				break;
			case 2: //south
				getSouthDescText().setText("");
				getSouthDescText().setText(ex.getValue().exitDescription);
				String kw2 = "";
				for(String j : ex.getValue().keyWords) {
					kw2 += j + ", ";
				}
				if (kw2.endsWith(", ")) {
					kw2 = kw2.substring(0, kw2.length() - 2);
				}
				getSouthDoorKeywordText().setText(kw2);
				switch(ex.getValue().doorState.num) {
				case 0:
					getSouthDoorStateCombo().select(0);
					break;
				case 1:
					getSouthDoorStateCombo().select(1);
					break;
				case 2:
					getSouthDoorStateCombo().select(2);
					break;
				}
				if (ex.getValue().doorFlags != null) {
					if (!ex.getValue().doorFlags.isEmpty()) {
						//TODO: Implement door size and its GUI connection
						for (DoorFlag f : ex.getValue().doorFlags) {
							switch ((f.num)) {
							case 1: //A
								getSouthDoorFlagACheck().setSelection(true);
								break;
							case 2: //B
								getSouthDoorFlagBCheck().setSelection(true);
								break;
							case 4: //C
								getSouthDoorFlagCCheck().setSelection(true);
								break;
							case 8: //D
								//TODO: implement new flag entry if required
								//getSouthDoorFlagDCheck().setSelection(true);
								break;
							case 16: //E not used?
								break;
							case 32: //F
								getSouthDoorFlagFCheck().setSelection(true);
								break;
							case 64: //G
								getSouthDoorFlagGCheck().setSelection(true);
								break;
							case 128: //H
								getSouthDoorFlagHCheck().setSelection(true);
								break;
							case 256: //I
								getSouthDoorFlagICheck().setSelection(true);
								break;
							case 512: //J
								getSouthDoorFlagJCheck().setSelection(true);
								break;
							case 1024: //K
								getSouthDoorFlagKCheck().setSelection(true);
								break;
							case 2048: //L
								getSouthDoorFlagLCheck().setSelection(true);
								break;
							}
						} 
					} 
				}
				break;
			case 3: //west
				getWestDescText().setText("");
				getWestDescText().setText(ex.getValue().exitDescription);
				String kw3 = "";
				for(String j : ex.getValue().keyWords) {
					kw3 += j + ", ";
				}
				if (kw3.endsWith(", ")) {
					kw3 = kw3.substring(0, kw3.length() - 2);
				}
				getWestDoorKeywordText().setText(kw3);
				switch(ex.getValue().doorState.num) {
				case 0:
					getWestDoorStateCombo().select(0);
					break;
				case 1:
					getWestDoorStateCombo().select(1);
					break;
				case 2:
					getWestDoorStateCombo().select(2);
					break;
				}
				if (ex.getValue().doorFlags != null) {
					if (!ex.getValue().doorFlags.isEmpty()) {
						//TODO: Implement door size and its GUI connection
						for (DoorFlag f : ex.getValue().doorFlags) {
							switch ((f.num)) {
							case 1: //A
								getWestDoorFlagACheck().setSelection(true);
								break;
							case 2: //B
								getWestDoorFlagBCheck().setSelection(true);
								break;
							case 4: //C
								getWestDoorFlagCCheck().setSelection(true);
								break;
							case 8: //D
								//TODO: implement new flag entry if required
								//getWestDoorFlagDCheck().setSelection(true);
								break;
							case 16: //E not used?
								break;
							case 32: //F
								getWestDoorFlagFCheck().setSelection(true);
								break;
							case 64: //G
								getWestDoorFlagGCheck().setSelection(true);
								break;
							case 128: //H
								getWestDoorFlagHCheck().setSelection(true);
								break;
							case 256: //I
								getWestDoorFlagICheck().setSelection(true);
								break;
							case 512: //J
								getWestDoorFlagJCheck().setSelection(true);
								break;
							case 1024: //K
								getWestDoorFlagKCheck().setSelection(true);
								break;
							case 2048: //L
								getWestDoorFlagLCheck().setSelection(true);
								break;
							}
						} 
					} 
				}
				break;
			case 4: //up
				getUpDescText().setText("");
				getUpDescText().setText(ex.getValue().exitDescription);
				String kw4 = "";
				for(String j : ex.getValue().keyWords) {
					kw4 += j + ", ";
				}
				if (kw4.endsWith(", ")) {
					kw4 = kw4.substring(0, kw4.length() - 2);
				}
				getUpDoorKeywordText().setText(kw4);
				switch(ex.getValue().doorState.num) {
				case 0:
					getUpDoorStateCombo().select(0);
					break;
				case 1:
					getUpDoorStateCombo().select(1);
					break;
				case 2:
					getUpDoorStateCombo().select(2);
					break;
				}
				if (ex.getValue().doorFlags != null) {
					if (!ex.getValue().doorFlags.isEmpty()) {
						//TODO: Implement door size and its GUI connection
						for (DoorFlag f : ex.getValue().doorFlags) {
							switch ((f.num)) {
							case 1: //A
								getUpDoorFlagACheck().setSelection(true);
								break;
							case 2: //B
								getUpDoorFlagBCheck().setSelection(true);
								break;
							case 4: //C
								getUpDoorFlagCCheck().setSelection(true);
								break;
							case 8: //D
								//TODO: implement new flag entry if required
								//getUpDoorFlagDCheck().setSelection(true);
								break;
							case 16: //E not used?
								break;
							case 32: //F
								getUpDoorFlagFCheck().setSelection(true);
								break;
							case 64: //G
								getUpDoorFlagGCheck().setSelection(true);
								break;
							case 128: //H
								getUpDoorFlagHCheck().setSelection(true);
								break;
							case 256: //I
								getUpDoorFlagICheck().setSelection(true);
								break;
							case 512: //J
								getUpDoorFlagJCheck().setSelection(true);
								break;
							case 1024: //K
								getUpDoorFlagKCheck().setSelection(true);
								break;
							case 2048: //L
								getUpDoorFlagLCheck().setSelection(true);
								break;
							}
						} 
					} 
				}
				break;
			case 5: //down
				getDownDescText().setText("");
				getDownDescText().setText(ex.getValue().exitDescription);
				String kw5 = "";
				for(String j : ex.getValue().keyWords) {
					kw5 += j + ", ";
				}
				if (kw5.endsWith(", ")) {
					kw5 = kw5.substring(0, kw5.length() - 2);
				}
				getDownDoorKeywordText().setText(kw5);
				switch(ex.getValue().doorState.num) {
				case 0:
					getDownDoorStateCombo().select(0);
					break;
				case 1:
					getDownDoorStateCombo().select(1);
					break;
				case 2:
					getDownDoorStateCombo().select(2);
					break;
				}
				if (ex.getValue().doorFlags != null) {
					if (!ex.getValue().doorFlags.isEmpty()) {
						//TODO: Implement door size and its GUI connection
						for (DoorFlag f : ex.getValue().doorFlags) {
							switch ((f.num)) {
							case 1: //A
								getDownDoorFlagACheck().setSelection(true);
								break;
							case 2: //B
								getDownDoorFlagBCheck().setSelection(true);
								break;
							case 4: //C
								getDownDoorFlagCCheck().setSelection(true);
								break;
							case 8: //D
								//TODO: implement new flag entry if required
								//getDownDoorFlagDCheck().setSelection(true);
								break;
							case 16: //E not used?
								break;
							case 32: //F
								getDownDoorFlagFCheck().setSelection(true);
								break;
							case 64: //G
								getDownDoorFlagGCheck().setSelection(true);
								break;
							case 128: //H
								getDownDoorFlagHCheck().setSelection(true);
								break;
							case 256: //I
								getDownDoorFlagICheck().setSelection(true);
								break;
							case 512: //J
								getDownDoorFlagJCheck().setSelection(true);
								break;
							case 1024: //K
								getDownDoorFlagKCheck().setSelection(true);
								break;
							case 2048: //L
								getDownDoorFlagLCheck().setSelection(true);
								break;
							}
						} 
					} 
				}
				break;
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1809, 1320);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem fileMenuHeader = new MenuItem(menu, SWT.CASCADE);
		fileMenuHeader.setText("&File");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);
		
		MenuItem fileOpenItem = new MenuItem(fileMenu, SWT.PUSH);
		fileOpenItem.setText("&Open");
		
		MenuItem fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
		fileSaveItem.setText("&Save");
		
		MenuItem fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("E&xit");
		
		MenuItem mntmArea = new MenuItem(menu, SWT.CASCADE);
		mntmArea.setText("Area");
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.CASCADE);
		mntmEdit.setText("Edit");
		
		MenuItem mntmWindow = new MenuItem(menu, SWT.CASCADE);
		mntmWindow.setText("Window");
		
		fileOpenItem.addSelectionListener(new fileOpenItemListener());
		fileSaveItem.addSelectionListener(new fileSaveItemListener());
		fileExitItem.addSelectionListener(new fileExitItemListener());
		
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 226;
		composite.setLayoutData(gd_composite);
		
		Group grpWorldObjects = new Group(composite, SWT.NONE);
		grpWorldObjects.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpWorldObjects.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpWorldObjects.setText("World Objects");
		
		tree = new Tree(grpWorldObjects, SWT.BORDER);
	    parser.getArea().getRooms().forEach((key, value) -> {
	    	TreeItem roomItem = new TreeItem(tree,0);
	    	roomItem.setText("Room " + key + " - " + value.header);
	    });

	      tree.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          if (event.detail == SWT.CHECK) {
	            text.setText(event.item + " was checked.");
	          } 
	          else {
	            text.setText(event.item + " was selected");
	            String tmp = tree.getSelection()[0].getText();
	            tmp = tmp.replace("Room ", "");
	            tmp = tmp.replaceAll("\\s.*", "");
	            updateRoomPanel(tmp);
	          }
	        }
	      });
		
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 1004;
		composite_1.setLayoutData(gd_composite_1);
		
		TabFolder tabFolder = new TabFolder(composite_1, SWT.NONE);
		GridData gd_tabFolder = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_tabFolder.heightHint = 314;
		tabFolder.setLayoutData(gd_tabFolder);
		
		TabItem tbtmObjectEditor = new TabItem(tabFolder, SWT.NONE);
		tbtmObjectEditor.setText("Editor");
		
		TabFolder tabFolder_1 = new TabFolder(tabFolder, SWT.NONE);
		tbtmObjectEditor.setControl(tabFolder_1);
		
		TabItem tbtmRoomEditor = new TabItem(tabFolder_1, SWT.NONE);
		tbtmRoomEditor.setText("Room Editor");
		
		SashForm sashForm = new SashForm(tabFolder_1, SWT.NONE);
		tbtmRoomEditor.setControl(sashForm);
		
		Group grpRoomData = new Group(sashForm, SWT.NONE);
		grpRoomData.setText("Room Data");
		grpRoomData.setLayout(new GridLayout(1, false));
		
		Group grpVnum = new Group(grpRoomData, SWT.NONE);
		grpVnum.setLayout(new GridLayout(2, false));
		GridData gd_grpVnum = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpVnum.heightHint = 35;
		grpVnum.setLayoutData(gd_grpVnum);
		grpVnum.setText("Vnum");
		
		RoomVnumSpinner = new Spinner(grpVnum, SWT.BORDER);
		RoomVnumSpinner.setMaximum(10000000);
		GridData gd_RoomVnumSpinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_RoomVnumSpinner.widthHint = 70;
		RoomVnumSpinner.setLayoutData(gd_RoomVnumSpinner);
		RoomVnumSpinner.setToolTipText("Vnum value");
		
		Button RoomVnumAutoButton = new Button(grpVnum, SWT.RADIO);
		RoomVnumAutoButton.setSelection(true);
		RoomVnumAutoButton.setText("Automatic");
		
		Group grpDescription = new Group(grpRoomData, SWT.NONE);
		grpDescription.setLayout(new GridLayout(1, false));
		GridData gd_grpDescription = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpDescription.heightHint = 355;
		grpDescription.setLayoutData(gd_grpDescription);
		grpDescription.setText("Description");
		
		Label lblRoomName = new Label(grpDescription, SWT.NONE);
		lblRoomName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblRoomName.setText("Room Name");
		
		roomNameText = new Text(grpDescription, SWT.BORDER);
		roomNameText.setToolTipText("Room name (a few words)");
		roomNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblRoomDescription = new Label(grpDescription, SWT.NONE);
		lblRoomDescription.setText("Room Description");
		
		roomDescText = new Text(grpDescription, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		roomDescText.setToolTipText("Room description (a few lines)");
		GridData gd_roomDescText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_roomDescText.heightHint = 68;
		roomDescText.setLayoutData(gd_roomDescText);
		
		Label lblDetailsAndExtras = new Label(grpDescription, SWT.NONE);
		lblDetailsAndExtras.setText("Details and Extras");
		
		TableViewer tableViewer = new TableViewer(grpDescription, SWT.BORDER | SWT.FULL_SELECTION);
		roomExtrasTable = tableViewer.getTable();
		roomExtrasTable.setLinesVisible(true);
		roomExtrasTable.setHeaderVisible(true);
		roomExtrasTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnKeywords = tableViewerColumn.getColumn();
		tblclmnKeywords.setWidth(100);
		tblclmnKeywords.setText("keywords");
		
		tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn_1.getColumn();
		tblclmnDescription.setWidth(223);
		tblclmnDescription.setText("Description");
		
		Group grpRoomFlags = new Group(sashForm, SWT.NONE);
		grpRoomFlags.setText("Room Flags");
		grpRoomFlags.setLayout(new GridLayout(1, false));
		
		Group grpRoomFlagsInner = new Group(grpRoomFlags, SWT.NONE);
		RowLayout rl_grpRoomFlagsInner = new RowLayout(SWT.HORIZONTAL);
		rl_grpRoomFlagsInner.pack = false;
		grpRoomFlagsInner.setLayout(rl_grpRoomFlagsInner);
		GridData gd_grpRoomFlagsInner = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpRoomFlagsInner.heightHint = 157;
		grpRoomFlagsInner.setLayoutData(gd_grpRoomFlagsInner);
		grpRoomFlagsInner.setText("Flags");
		
		btnRoomDark = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomDark.setText("Dark");
		
		btnRoomNoMob = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomNoMob.setText("No mob");
		
		btnRoomIndoors = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomIndoors.setText("Indoors");
		
		btnRoomPrivate = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomPrivate.setText("Private");
		
		btnRoomSafe = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomSafe.setText("Safe");
		
		btnRoomSolitary = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomSolitary.setText("Solitary");
		
		btnRoomPetShop = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomPetShop.setText("Pet Shop");
		
		btnRoomNoRecall = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomNoRecall.setText("No recall");
		
		btnRoomImpOnly = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomImpOnly.setText("Imp only");
		
		btnRoomGodsOnly = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomGodsOnly.setText("Gods only");
		
		btnRoomHeroesOnly = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomHeroesOnly.setText("Heroes only");
		
		btnRoomNewbiesOnly = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomNewbiesOnly.setText("Newbies only");
		
		btnRoomLaw = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomLaw.setText("Law");
		
		btnRoomNowhere = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomNowhere.setText("Nowhere");
		
		btnRoomBank = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomBank.setText("Bank");
		
		btnRoomNoMagic = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomNoMagic.setText("No magic");
		
		btnRoomNoSummon = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomNoSummon.setText("No summon");
		
		btnRoomRegistry = new Button(grpRoomFlagsInner, SWT.CHECK);
		btnRoomRegistry.setText("Registry");
		
		Group grpSectorType = new Group(grpRoomFlags, SWT.NONE);
		RowLayout rl_grpSectorType = new RowLayout(SWT.HORIZONTAL);
		rl_grpSectorType.pack = false;
		grpSectorType.setLayout(rl_grpSectorType);
		GridData gd_grpSectorType = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpSectorType.heightHint = 78;
		grpSectorType.setLayoutData(gd_grpSectorType);
		grpSectorType.setText("Sector Type");
		
		roomSectorInside = new Button(grpSectorType, SWT.RADIO);
		roomSectorInside.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		roomSectorInside.setText("Inside");
		
		roomSectorCity = new Button(grpSectorType, SWT.RADIO);
		roomSectorCity.setText("City");
		
		roomSectorField = new Button(grpSectorType, SWT.RADIO);
		roomSectorField.setText("Field");
		
		roomSectorForest = new Button(grpSectorType, SWT.RADIO);
		roomSectorForest.setText("Forest");
		
		roomSectorHill = new Button(grpSectorType, SWT.RADIO);
		roomSectorHill.setText("Hill");
		
		roomSectorMountain = new Button(grpSectorType, SWT.RADIO);
		roomSectorMountain.setText("Mountain");
		
		roomSectorWater = new Button(grpSectorType, SWT.RADIO);
		roomSectorWater.setText("Water");
		
		roomSectorDeepWater = new Button(grpSectorType, SWT.RADIO);
		roomSectorDeepWater.setText("Deep Water");
		
		roomSectorUnused = new Button(grpSectorType, SWT.RADIO);
		roomSectorUnused.setText("Unused");
		
		roomSectorAir = new Button(grpSectorType, SWT.RADIO);
		roomSectorAir.setText("Air");
		
		roomSectorDesert = new Button(grpSectorType, SWT.RADIO);
		roomSectorDesert.setText("Desert");
		
		Group grpRecoveryRates = new Group(grpRoomFlags, SWT.NONE);
		grpRecoveryRates.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpRecoveryRates.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpRecoveryRates.setText("Recovery Rates");
		
		Composite composite_2 = new Composite(grpRecoveryRates, SWT.NONE);
		RowLayout rl_composite_2 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_2.marginBottom = 0;
		rl_composite_2.center = true;
		rl_composite_2.justify = true;
		composite_2.setLayout(rl_composite_2);
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setText("HP Recovery Rate");
		
		roomHPScale = new Scale(composite_2, SWT.NONE);
		roomHPScale.setPageIncrement(25);
		roomHPScale.setMaximum(200);
		roomHPScale.setSelection(100);
		
		roomHPSpinner = new Spinner(composite_2, SWT.BORDER);
		roomHPSpinner.setMaximum(200);
		roomHPSpinner.setSelection(100);
		roomHPSpinner.setLayoutData(new RowData(60, SWT.DEFAULT));
		
		Composite composite_3 = new Composite(grpRecoveryRates, SWT.NONE);
		RowLayout rl_composite_3 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_3.marginBottom = 0;
		rl_composite_3.justify = true;
		rl_composite_3.center = true;
		composite_3.setLayout(rl_composite_3);
		
		Label lblNewLabel_1 = new Label(composite_3, SWT.NONE);
		lblNewLabel_1.setText("MP Recovery Rate");
		
		roomMPScale = new Scale(composite_3, SWT.NONE);
		roomMPScale.setPageIncrement(25);
		roomMPScale.setMaximum(200);
		roomMPScale.setSelection(100);
		
		roomMPSpinner = new Spinner(composite_3, SWT.BORDER);
		roomMPSpinner.setMaximum(200);
		roomMPSpinner.setSelection(100);
		roomMPSpinner.setLayoutData(new RowData(60, -1));
		
		grpDoors = new Group(sashForm, SWT.NONE);
		grpDoors.setText("Doors");
		grpDoors.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TabFolder tabFolder_2 = new TabFolder(grpDoors, SWT.NONE);
		
		TabItem tbtmNorth = new TabItem(tabFolder_2, SWT.NONE);
		tbtmNorth.setText("North");
		
		northComposite = new Composite(tabFolder_2, SWT.NONE);
		tbtmNorth.setControl(northComposite);
		northComposite.setLayout(new GridLayout(1, false));
		
		Label lblDescriptionOfWhat = new Label(northComposite, SWT.NONE);
		lblDescriptionOfWhat.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDescriptionOfWhat.setText("Description of what is seen in that direction (optional)");
		
		northDescText = new Text(northComposite, SWT.BORDER);
		northDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button northDoorCheckbox = new Button(northComposite, SWT.CHECK);
		GridData gd_northDoorCheckbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_northDoorCheckbox.horizontalIndent = 1;
		northDoorCheckbox.setLayoutData(gd_northDoorCheckbox);
		northDoorCheckbox.setText("There's a door");
		
		
		Label lblDoorKeywordoptional = new Label(northComposite, SWT.NONE);
		lblDoorKeywordoptional.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKeywordoptional.setText("Door keyword (optional)");
		
		northDoorKeywordText = new Text(northComposite, SWT.BORDER);
		northDoorKeywordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorState = new Label(northComposite, SWT.NONE);
		lblDoorState.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorState.setText("Door State");
		
		northDoorStateCombo = new Combo(northComposite, SWT.READ_ONLY);
		northDoorStateCombo.setVisibleItemCount(3);
		northDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		northDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey = new Label(northComposite, SWT.NONE);
		lblDoorKey.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey.setText("Door Key");
		
		northDoorKeyCombo = new Combo(northComposite, SWT.READ_ONLY);
		northDoorKeyCombo.setItems(new String[] {"(None)"});
		northDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize = new Label(northComposite, SWT.NONE);
		lblDoorSize.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize.setText("Door Size");
		
		northDoorSizeCombo = new Combo(northComposite, SWT.READ_ONLY);
		northDoorSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		northDoorSizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets = new Group(northComposite, SWT.NONE);
		grpResets.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpResets.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResets.setText("Resets");
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(grpResets, SWT.V_SCROLL);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		scrolledComposite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_4 = new Composite(scrolledComposite_1, SWT.EMBEDDED);
		composite_4.setLayout(new RowLayout(SWT.VERTICAL));
		
		northDoorFlagACheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		northDoorFlagBCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagBCheck.setText("Door resets to closed");
		
		northDoorFlagCCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagCCheck.setText("Door resets to locked");
		
		northDoorFlagFCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		northDoorFlagGCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		northDoorFlagHCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagHCheck.setText("Lock easy to pick");
		
		northDoorFlagICheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagICheck.setText("Lock hard to pick");
		
		northDoorFlagJCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagJCheck.setText("Lock infuriating to pick");
		
		northDoorFlagKCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagKCheck.setText("Door cannot be closed");
		
		northDoorFlagLCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1.setContent(composite_4);
		scrolledComposite_1.setMinSize(composite_4.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		TabItem tbtmEast = new TabItem(tabFolder_2, SWT.NONE);
		tbtmEast.setText("East");
		
		Composite eastComposite = new Composite(tabFolder_2, SWT.NONE);
		tbtmEast.setControl(eastComposite);
		eastComposite.setLayout(new GridLayout(1, false));
		
		Label lblDescriptionOfWhat_1 = new Label(eastComposite, SWT.NONE);
		lblDescriptionOfWhat_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDescriptionOfWhat_1.setText("Description of what is seen in that direction (optional)");
		
		eastDescText = new Text(eastComposite, SWT.BORDER);
		eastDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button eastDoorCheckbox = new Button(eastComposite, SWT.CHECK);
		GridData gd_eastDoorCheckbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_eastDoorCheckbox.horizontalIndent = 1;
		eastDoorCheckbox.setLayoutData(gd_eastDoorCheckbox);
		eastDoorCheckbox.setText("There's a door");
		
		Label lblDoorKeywordoptional_1 = new Label(eastComposite, SWT.NONE);
		lblDoorKeywordoptional_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKeywordoptional_1.setText("Door keyword (optional)");
		
		eastDoorKeywordText = new Text(eastComposite, SWT.BORDER);
		eastDoorKeywordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorState_1 = new Label(eastComposite, SWT.NONE);
		lblDoorState_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorState_1.setText("Door State");
		
		eastDoorStateCombo = new Combo(eastComposite, SWT.READ_ONLY);
		eastDoorStateCombo.setVisibleItemCount(3);
		eastDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		eastDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_1 = new Label(eastComposite, SWT.NONE);
		lblDoorKey_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_1.setText("Door Key");
		
		eastDoorKeyCombo = new Combo(eastComposite, SWT.READ_ONLY);
		eastDoorKeyCombo.setItems(new String[] {"(None)"});
		eastDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_1 = new Label(eastComposite, SWT.NONE);
		lblDoorSize_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_1.setText("Door Size");
		
		eastDoorSizeCombo = new Combo(eastComposite, SWT.READ_ONLY);
		eastDoorSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		eastDoorSizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_1 = new Group(eastComposite, SWT.NONE);
		grpResets_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResets_1.setText("Resets");
		grpResets_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite_1_1 = new ScrolledComposite(grpResets_1, SWT.V_SCROLL);
		scrolledComposite_1_1.setExpandVertical(true);
		scrolledComposite_1_1.setExpandHorizontal(true);
		
		Composite composite_4_1 = new Composite(scrolledComposite_1_1, SWT.EMBEDDED);
		composite_4_1.setLayout(new RowLayout(SWT.VERTICAL));
		
		eastDoorFlagACheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		eastDoorFlagBCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagBCheck.setText("Door resets to closed");
		
		eastDoorFlagCCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagCCheck.setText("Door resets to locked");
		
		eastDoorFlagFCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		eastDoorFlagGCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		eastDoorFlagHCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagHCheck.setText("Lock easy to pick");
		
		eastDoorFlagICheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagICheck.setText("Lock hard to pick");
		
		eastDoorFlagJCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagJCheck.setText("Lock infuriating to pick");
		
		eastDoorFlagKCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagKCheck.setText("Door cannot be closed");
		
		eastDoorFlagLCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1_1.setContent(composite_4_1);
		scrolledComposite_1_1.setMinSize(composite_4_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite_1_1.setMinSize(new Point(323, 193));
		
		TabItem tbtmSouth = new TabItem(tabFolder_2, SWT.NONE);
		tbtmSouth.setText("South");
		
		Composite southComposite = new Composite(tabFolder_2, SWT.NONE);
		tbtmSouth.setControl(southComposite);
		southComposite.setLayout(new GridLayout(1, false));
		
		Label lblDescriptionOfWhat_2 = new Label(southComposite, SWT.NONE);
		lblDescriptionOfWhat_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDescriptionOfWhat_2.setText("Description of what is seen in that direction (optional)");
		
		southDescText = new Text(southComposite, SWT.BORDER);
		southDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button southDoorCheckbox = new Button(southComposite, SWT.CHECK);
		GridData gd_southDoorCheckbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_southDoorCheckbox.horizontalIndent = 1;
		southDoorCheckbox.setLayoutData(gd_southDoorCheckbox);
		southDoorCheckbox.setText("There's a door");
		
		Label lblDoorKeywordoptional_2 = new Label(southComposite, SWT.NONE);
		lblDoorKeywordoptional_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKeywordoptional_2.setText("Door keyword (optional)");
		
		southDoorKeywordText = new Text(southComposite, SWT.BORDER);
		southDoorKeywordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorState_2 = new Label(southComposite, SWT.NONE);
		lblDoorState_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorState_2.setText("Door State");
		
		southDoorStateCombo = new Combo(southComposite, SWT.READ_ONLY);
		southDoorStateCombo.setVisibleItemCount(3);
		southDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		southDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_2 = new Label(southComposite, SWT.NONE);
		lblDoorKey_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_2.setText("Door Key");
		
		southDoorKeyCombo = new Combo(southComposite, SWT.READ_ONLY);
		southDoorKeyCombo.setItems(new String[] {"(None)"});
		southDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_2 = new Label(southComposite, SWT.NONE);
		lblDoorSize_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_2.setText("Door Size");
		
		southDoorSizeCombo = new Combo(southComposite, SWT.READ_ONLY);
		southDoorSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		southDoorSizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_2 = new Group(southComposite, SWT.NONE);
		grpResets_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResets_2.setText("Resets");
		grpResets_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite_1_2 = new ScrolledComposite(grpResets_2, SWT.V_SCROLL);
		scrolledComposite_1_2.setExpandVertical(true);
		scrolledComposite_1_2.setExpandHorizontal(true);
		
		Composite composite_4_2 = new Composite(scrolledComposite_1_2, SWT.EMBEDDED);
		composite_4_2.setLayout(new RowLayout(SWT.VERTICAL));
		
		southDoorFlagACheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		southDoorFlagBCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagBCheck.setText("Door resets to closed");
		
		southDoorFlagCCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagCCheck.setText("Door resets to locked");
		
		southDoorFlagFCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		southDoorFlagGCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		southDoorFlagHCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagHCheck.setText("Lock easy to pick");
		
		southDoorFlagICheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagICheck.setText("Lock hard to pick");
		
		southDoorFlagJCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagJCheck.setText("Lock infuriating to pick");
		
		southDoorFlagKCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagKCheck.setText("Door cannot be closed");
		
		southDoorFlagLCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1_2.setContent(composite_4_2);
		scrolledComposite_1_2.setMinSize(composite_4_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite_1_2.setMinSize(new Point(323, 193));
		
		TabItem tbtmWest = new TabItem(tabFolder_2, SWT.NONE);
		tbtmWest.setText("West");
		
		Composite westComposite = new Composite(tabFolder_2, SWT.NONE);
		tbtmWest.setControl(westComposite);
		westComposite.setLayout(new GridLayout(1, false));
		
		Label lblDescriptionOfWhat_3 = new Label(westComposite, SWT.NONE);
		lblDescriptionOfWhat_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDescriptionOfWhat_3.setText("Description of what is seen in that direction (optional)");
		
		westDescText = new Text(westComposite, SWT.BORDER);
		westDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button westDoorCheckbox = new Button(westComposite, SWT.CHECK);
		GridData gd_westDoorCheckbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_westDoorCheckbox.horizontalIndent = 1;
		westDoorCheckbox.setLayoutData(gd_westDoorCheckbox);
		westDoorCheckbox.setText("There's a door");
		
		Label lblDoorKeywordoptional_3 = new Label(westComposite, SWT.NONE);
		lblDoorKeywordoptional_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKeywordoptional_3.setText("Door keyword (optional)");
		
		westDoorKeywordText = new Text(westComposite, SWT.BORDER);
		westDoorKeywordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorState_3 = new Label(westComposite, SWT.NONE);
		lblDoorState_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorState_3.setText("Door State");
		
		westDoorStateCombo = new Combo(westComposite, SWT.READ_ONLY);
		westDoorStateCombo.setVisibleItemCount(3);
		westDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		westDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_3 = new Label(westComposite, SWT.NONE);
		lblDoorKey_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_3.setText("Door Key");
		
		westDoorKeyCombo = new Combo(westComposite, SWT.READ_ONLY);
		westDoorKeyCombo.setItems(new String[] {"(None)"});
		westDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_3 = new Label(westComposite, SWT.NONE);
		lblDoorSize_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_3.setText("Door Size");
		
		westDoorSizeCombo = new Combo(westComposite, SWT.READ_ONLY);
		westDoorSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		westDoorSizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_3 = new Group(westComposite, SWT.NONE);
		grpResets_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResets_3.setText("Resets");
		grpResets_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite_1_3 = new ScrolledComposite(grpResets_3, SWT.V_SCROLL);
		scrolledComposite_1_3.setExpandVertical(true);
		scrolledComposite_1_3.setExpandHorizontal(true);
		
		Composite composite_4_3 = new Composite(scrolledComposite_1_3, SWT.EMBEDDED);
		composite_4_3.setLayout(new RowLayout(SWT.VERTICAL));
		
		westDoorFlagACheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		westDoorFlagBCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagBCheck.setText("Door resets to closed");
		
		westDoorFlagCCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagCCheck.setText("Door resets to locked");
		
		westDoorFlagFCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		westDoorFlagGCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		westDoorFlagHCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagHCheck.setText("Lock easy to pick");
		
		westDoorFlagICheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagICheck.setText("Lock hard to pick");
		
		westDoorFlagJCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagJCheck.setText("Lock infuriating to pick");
		
		westDoorFlagKCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagKCheck.setText("Door cannot be closed");
		
		westDoorFlagLCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1_3.setContent(composite_4_3);
		scrolledComposite_1_3.setMinSize(composite_4_3.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite_1_3.setMinSize(new Point(323, 193));
		
		TabItem tbtmUp = new TabItem(tabFolder_2, SWT.NONE);
		tbtmUp.setText("Up");
		
		Composite upComposite = new Composite(tabFolder_2, SWT.NONE);
		tbtmUp.setControl(upComposite);
		upComposite.setLayout(new GridLayout(1, false));
		
		Label lblDescriptionOfWhat_4 = new Label(upComposite, SWT.NONE);
		lblDescriptionOfWhat_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDescriptionOfWhat_4.setText("Description of what is seen in that direction (optional)");
		
		upDescText = new Text(upComposite, SWT.BORDER);
		upDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button upDoorCheckbox = new Button(upComposite, SWT.CHECK);
		GridData gd_upDoorCheckbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_upDoorCheckbox.horizontalIndent = 1;
		upDoorCheckbox.setLayoutData(gd_upDoorCheckbox);
		upDoorCheckbox.setText("There's a door");
		
		Label lblDoorKeywordoptional_4 = new Label(upComposite, SWT.NONE);
		lblDoorKeywordoptional_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKeywordoptional_4.setText("Door keyword (optional)");
		
		upDoorKeywordText = new Text(upComposite, SWT.BORDER);
		upDoorKeywordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorState_4 = new Label(upComposite, SWT.NONE);
		lblDoorState_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorState_4.setText("Door State");
		
		upDoorStateCombo = new Combo(upComposite, SWT.READ_ONLY);
		upDoorStateCombo.setVisibleItemCount(3);
		upDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		upDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_4 = new Label(upComposite, SWT.NONE);
		lblDoorKey_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_4.setText("Door Key");
		
		upDoorKeyCombo = new Combo(upComposite, SWT.READ_ONLY);
		upDoorKeyCombo.setItems(new String[] {"(None)"});
		upDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_4 = new Label(upComposite, SWT.NONE);
		lblDoorSize_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_4.setText("Door Size");
		
		upDoorSizeCombo = new Combo(upComposite, SWT.READ_ONLY);
		upDoorSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		upDoorSizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_4 = new Group(upComposite, SWT.NONE);
		grpResets_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResets_4.setText("Resets");
		grpResets_4.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite_1_4 = new ScrolledComposite(grpResets_4, SWT.V_SCROLL);
		scrolledComposite_1_4.setExpandVertical(true);
		scrolledComposite_1_4.setExpandHorizontal(true);
		
		Composite composite_4_4 = new Composite(scrolledComposite_1_4, SWT.EMBEDDED);
		composite_4_4.setLayout(new RowLayout(SWT.VERTICAL));
		
		upDoorFlagACheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		upDoorFlagBCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagBCheck.setText("Door resets to closed");
		
		upDoorFlagCCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagCCheck.setText("Door resets to locked");
		
		upDoorFlagFCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		upDoorFlagGCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		upDoorFlagHCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagHCheck.setText("Lock easy to pick");
		
		upDoorFlagICheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagICheck.setText("Lock hard to pick");
		
		upDoorFlagJCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagJCheck.setText("Lock infuriating to pick");
		
		upDoorFlagKCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagKCheck.setText("Door cannot be closed");
		
		upDoorFlagLCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1_4.setContent(composite_4_4);
		scrolledComposite_1_4.setMinSize(composite_4_4.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite_1_4.setMinSize(new Point(323, 193));
		
		TabItem tbtmDown = new TabItem(tabFolder_2, SWT.NONE);
		tbtmDown.setText("Down");
		
		Composite downComposite = new Composite(tabFolder_2, SWT.NONE);
		tbtmDown.setControl(downComposite);
		downComposite.setLayout(new GridLayout(1, false));
		
		Label lblDescriptionOfWhat_5 = new Label(downComposite, SWT.NONE);
		lblDescriptionOfWhat_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDescriptionOfWhat_5.setText("Description of what is seen in that direction (optional)");
		
		downDescText = new Text(downComposite, SWT.BORDER);
		downDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button downDoorCheckbox = new Button(downComposite, SWT.CHECK);
		GridData gd_downDoorCheckbox = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_downDoorCheckbox.horizontalIndent = 1;
		downDoorCheckbox.setLayoutData(gd_downDoorCheckbox);
		downDoorCheckbox.setText("There's a door");
		
		Label lblDoorKeywordoptional_5 = new Label(downComposite, SWT.NONE);
		lblDoorKeywordoptional_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKeywordoptional_5.setText("Door keyword (optional)");
		
		downDoorKeywordText = new Text(downComposite, SWT.BORDER);
		downDoorKeywordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorState_5 = new Label(downComposite, SWT.NONE);
		lblDoorState_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorState_5.setText("Door State");
		
		downDoorStateCombo = new Combo(downComposite, SWT.READ_ONLY);
		downDoorStateCombo.setVisibleItemCount(3);
		downDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		downDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_5 = new Label(downComposite, SWT.NONE);
		lblDoorKey_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_5.setText("Door Key");
		
		downDoorKeyCombo = new Combo(downComposite, SWT.READ_ONLY);
		downDoorKeyCombo.setItems(new String[] {"(None)"});
		downDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_5 = new Label(downComposite, SWT.NONE);
		lblDoorSize_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_5.setText("Door Size");
		
		downDoorSizeCombo = new Combo(downComposite, SWT.READ_ONLY);
		downDoorSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		downDoorSizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_5 = new Group(downComposite, SWT.NONE);
		grpResets_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResets_5.setText("Resets");
		grpResets_5.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite_1_5 = new ScrolledComposite(grpResets_5, SWT.V_SCROLL);
		scrolledComposite_1_5.setExpandVertical(true);
		scrolledComposite_1_5.setExpandHorizontal(true);
		
		Composite composite_4_5 = new Composite(scrolledComposite_1_5, SWT.EMBEDDED);
		composite_4_5.setLayout(new RowLayout(SWT.VERTICAL));
		
		downDoorFlagACheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		downDoorFlagBCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagBCheck.setText("Door resets to closed");
		
		downDoorFlagCCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagCCheck.setText("Door resets to locked");
		
		downDoorFlagFCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		downDoorFlagGCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		downDoorFlagHCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagHCheck.setText("Lock easy to pick");
		
		downDoorFlagICheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagICheck.setText("Lock hard to pick");
		
		downDoorFlagJCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagJCheck.setText("Lock infuriating to pick");
		
		downDoorFlagKCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagKCheck.setText("Door cannot be closed");
		
		downDoorFlagLCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1_5.setContent(composite_4_5);
		scrolledComposite_1_5.setMinSize(composite_4_5.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite_1_5.setMinSize(new Point(323, 193));
		sashForm.setWeights(new int[] {1, 1, 1});
		
		TabItem tbtmMobEditor = new TabItem(tabFolder_1, SWT.NONE);
		tbtmMobEditor.setText("Mob Editor");
		
		sashForm_1 = new SashForm(tabFolder_1, SWT.NONE);
		tbtmMobEditor.setControl(sashForm_1);
		
		grpVisual = new Group(sashForm_1, SWT.NONE);
		grpVisual.setText("Visual");
		grpVisual.setLayout(new GridLayout(1, false));
		
		grpDescription_1 = new Group(grpVisual, SWT.NONE);
		grpDescription_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpDescription_1.setText("Description");
		grpDescription_1.setLayout(new GridLayout(1, false));
		
		Label lblName = new Label(grpDescription_1, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblName.setText("Name");
		
		mobNameText = new Text(grpDescription_1, SWT.BORDER);
		mobNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblShortDescription = new Label(grpDescription_1, SWT.NONE);
		lblShortDescription.setText("Short Description");
		
		mobShortDescText = new Text(grpDescription_1, SWT.BORDER);
		mobShortDescText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblLongDescription = new Label(grpDescription_1, SWT.NONE);
		lblLongDescription.setText("Long Description");
		
		mobLongDescText = new Text(grpDescription_1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_mobLongDescText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_mobLongDescText.heightHint = 61;
		mobLongDescText.setLayoutData(gd_mobLongDescText);
		
		Label lblLookDescription = new Label(grpDescription_1, SWT.NONE);
		lblLookDescription.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblLookDescription.setText("Look Description");
		
		mobLookDescText = new Text(grpDescription_1, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_mobLookDescText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_mobLookDescText.heightHint = 119;
		mobLookDescText.setLayoutData(gd_mobLookDescText);
		
		grpAppearance = new Group(grpVisual, SWT.NONE);
		grpAppearance.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpAppearance.setText("Appearance");
		grpAppearance.setLayout(new GridLayout(3, false));
		
		Label lblRace = new Label(grpAppearance, SWT.NONE);
		lblRace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblRace.setText("Race");
		
		Label lblSize = new Label(grpAppearance, SWT.NONE);
		lblSize.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblSize.setText("Size");
		
		Label lblMaterial = new Label(grpAppearance, SWT.NONE);
		lblMaterial.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblMaterial.setText("Material");
		
		Combo mobRaceCombo = new Combo(grpAppearance, SWT.NONE);
		mobRaceCombo.setToolTipText("Race of the mobile");
		mobRaceCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		mobRaceCombo.setText("TODO: add race");
		
		Combo mobSizeCombo = new Combo(grpAppearance, SWT.NONE);
		mobSizeCombo.setToolTipText("Size of the mobile");
		mobSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		mobSizeCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		mobMaterialText = new Text(grpAppearance, SWT.BORDER);
		mobMaterialText.setToolTipText("The material of the mobile");
		mobMaterialText.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblStartPos = new Label(grpAppearance, SWT.NONE);
		lblStartPos.setText("Start Pos.");
		
		Label lblDefaultPos = new Label(grpAppearance, SWT.NONE);
		lblDefaultPos.setText("Default Pos.");
		
		Label lblSex = new Label(grpAppearance, SWT.NONE);
		lblSex.setText("Sex");
		
		Combo combo = new Combo(grpAppearance, SWT.NONE);
		combo.setToolTipText("Position the mobile will be loaded in");
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Combo combo_1 = new Combo(grpAppearance, SWT.NONE);
		combo_1.setToolTipText("Position the mobile will return after a fight. Cannot go back to sleep");
		combo_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Combo combo_2 = new Combo(grpAppearance, SWT.NONE);
		combo_2.setToolTipText("Gender of the mobile");
		combo_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		grpFlags = new Group(grpVisual, SWT.NONE);
		grpFlags.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		grpFlags.setLayout(new GridLayout(1, false));
		grpFlags.setText("Flags");
		
		Group grpCorpseFlags = new Group(grpFlags, SWT.NONE);
		grpCorpseFlags.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpCorpseFlags.setText("Corpse Flags");
		RowLayout rl_grpCorpseFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpCorpseFlags.pack = false;
		grpCorpseFlags.setLayout(rl_grpCorpseFlags);
		
		Button btnEdible = new Button(grpCorpseFlags, SWT.CHECK);
		btnEdible.setToolTipText("Mobile can be eaten");
		btnEdible.setText("Edible");
		
		Button btnPoison = new Button(grpCorpseFlags, SWT.CHECK);
		btnPoison.setToolTipText("Mobile is poisonous when eaten (should also be edible)");
		btnPoison.setText("Poison");
		
		Button btnMagical = new Button(grpCorpseFlags, SWT.CHECK);
		btnMagical.setToolTipText("Mobile's magic nature causes strange effects when eaten");
		btnMagical.setText("Magical");
		
		Button btnVanishes = new Button(grpCorpseFlags, SWT.CHECK);
		btnVanishes.setToolTipText("Mobile vanishes after death (i.e. a wraith)");
		btnVanishes.setText("Vanishes");
		
		Button btnOther = new Button(grpCorpseFlags, SWT.CHECK);
		btnOther.setToolTipText("Mobile is not flesh and blood (defined by material type)");
		btnOther.setText("Other");
		
		Group grpFormFlags = new Group(grpFlags, SWT.NONE);
		GridData gd_grpFormFlags = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpFormFlags.widthHint = 0;
		grpFormFlags.setLayoutData(gd_grpFormFlags);
		RowLayout rl_grpFormFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpFormFlags.pack = false;
		grpFormFlags.setLayout(rl_grpFormFlags);
		grpFormFlags.setText("Form Flags");
		
		Button btnAnimal = new Button(grpFormFlags, SWT.CHECK);
		btnAnimal.setText("Animal");
		
		Button btnSentient = new Button(grpFormFlags, SWT.CHECK);
		btnSentient.setText("Sentient");
		
		Button btnUndead = new Button(grpFormFlags, SWT.CHECK);
		btnUndead.setText("Undead");
		
		Button btnConstruct = new Button(grpFormFlags, SWT.CHECK);
		btnConstruct.setText("Construct");
		
		btnMist = new Button(grpFormFlags, SWT.CHECK);
		btnMist.setText("Mist");
		
		btnIntangible = new Button(grpFormFlags, SWT.CHECK);
		btnIntangible.setText("Intangible");
		
		btnBiped = new Button(grpFormFlags, SWT.CHECK);
		btnBiped.setText("Biped");
		
		btnCentaur = new Button(grpFormFlags, SWT.CHECK);
		btnCentaur.setText("Centaur");
		
		btnInsect = new Button(grpFormFlags, SWT.CHECK);
		btnInsect.setText("Insect");
		
		btnSpider = new Button(grpFormFlags, SWT.CHECK);
		btnSpider.setText("Spider");
		
		btnCrustacean = new Button(grpFormFlags, SWT.CHECK);
		btnCrustacean.setText("Crustacean");
		
		btnWorm = new Button(grpFormFlags, SWT.CHECK);
		btnWorm.setText("Worm");
		
		btnBlob = new Button(grpFormFlags, SWT.CHECK);
		btnBlob.setText("Blob");
		
		btnMammal = new Button(grpFormFlags, SWT.CHECK);
		btnMammal.setText("Mammal");
		
		btnBird = new Button(grpFormFlags, SWT.CHECK);
		btnBird.setText("Bird");
		
		btnReptile = new Button(grpFormFlags, SWT.CHECK);
		btnReptile.setText("Reptile");
		
		btnSnake = new Button(grpFormFlags, SWT.CHECK);
		btnSnake.setText("Snake");
		
		btnDragon = new Button(grpFormFlags, SWT.CHECK);
		btnDragon.setText("Dragon");
		
		btnAmphibian = new Button(grpFormFlags, SWT.CHECK);
		btnAmphibian.setText("Amphibian");
		
		btnFish = new Button(grpFormFlags, SWT.CHECK);
		btnFish.setText("Fish");
		
		btnColdBlood = new Button(grpFormFlags, SWT.CHECK);
		btnColdBlood.setText("Cold blood");
		
		grpPartsFlags = new Group(grpFlags, SWT.NONE);
		RowLayout rl_grpPartsFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpPartsFlags.pack = false;
		grpPartsFlags.setLayout(rl_grpPartsFlags);
		GridData gd_grpPartsFlags = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpPartsFlags.widthHint = 0;
		grpPartsFlags.setLayoutData(gd_grpPartsFlags);
		grpPartsFlags.setText("Parts Flags");
		
		btnHead = new Button(grpPartsFlags, SWT.CHECK);
		btnHead.setText("Head");
		
		btnArms = new Button(grpPartsFlags, SWT.CHECK);
		btnArms.setText("Arms");
		
		btnLegs = new Button(grpPartsFlags, SWT.CHECK);
		btnLegs.setText("Legs");
		
		btnHeart = new Button(grpPartsFlags, SWT.CHECK);
		btnHeart.setText("Heart");
		
		btnBrains = new Button(grpPartsFlags, SWT.CHECK);
		btnBrains.setText("Brains");
		
		btnGuts = new Button(grpPartsFlags, SWT.CHECK);
		btnGuts.setText("Guts");
		
		btnHands = new Button(grpPartsFlags, SWT.CHECK);
		btnHands.setText("Hands");
		
		btnFeet = new Button(grpPartsFlags, SWT.CHECK);
		btnFeet.setText("Feet");
		
		btnFingers = new Button(grpPartsFlags, SWT.CHECK);
		btnFingers.setText("Fingers");
		
		btnEar = new Button(grpPartsFlags, SWT.CHECK);
		btnEar.setText("Ear");
		
		btnEye = new Button(grpPartsFlags, SWT.CHECK);
		btnEye.setText("Eye");
		
		btnTongue = new Button(grpPartsFlags, SWT.CHECK);
		btnTongue.setText("Tongue");
		
		btnEyestalks = new Button(grpPartsFlags, SWT.CHECK);
		btnEyestalks.setText("Eyestalks");
		
		btnTentacles = new Button(grpPartsFlags, SWT.CHECK);
		btnTentacles.setText("Tentacles");
		
		btnFins = new Button(grpPartsFlags, SWT.CHECK);
		btnFins.setText("Fins");
		
		btnWings = new Button(grpPartsFlags, SWT.CHECK);
		btnWings.setText("Wings");
		
		btnTail = new Button(grpPartsFlags, SWT.CHECK);
		btnTail.setText("Tail");
		
		btnClaws = new Button(grpPartsFlags, SWT.CHECK);
		btnClaws.setText("Claws");
		
		btnFangs = new Button(grpPartsFlags, SWT.CHECK);
		btnFangs.setText("Fangs");
		
		btnHorns = new Button(grpPartsFlags, SWT.CHECK);
		btnHorns.setText("Horns");
		
		btnScales = new Button(grpPartsFlags, SWT.CHECK);
		btnScales.setText("Scales");
		
		btnTusks = new Button(grpPartsFlags, SWT.CHECK);
		btnTusks.setText("Tusks");
		
		grpValues = new Group(sashForm_1, SWT.NONE);
		grpValues.setText("Values");
		grpValues.setLayout(new GridLayout(1, false));
		
		grpCombatValues = new Group(grpValues, SWT.NONE);
		grpCombatValues.setLayout(new GridLayout(1, false));
		grpCombatValues.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpCombatValues.setText("Combat Values");
		
		Group grpCore = new Group(grpCombatValues, SWT.NONE);
		RowLayout rl_grpCore = new RowLayout(SWT.HORIZONTAL);
		rl_grpCore.justify = true;
		grpCore.setLayout(rl_grpCore);
		grpCore.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpCore.setText("Core");
		
		Composite composite_5 = new Composite(grpCore, SWT.NONE);
		composite_5.setLayout(new GridLayout(2, false));
		
		Label lblLevel = new Label(composite_5, SWT.NONE);
		lblLevel.setText("Level");
		
		Spinner mobLvlSpinner = new Spinner(composite_5, SWT.BORDER);
		
		Composite composite_6 = new Composite(grpCore, SWT.NONE);
		composite_6.setLayout(new GridLayout(2, false));
		
		Label lblTreasure = new Label(composite_6, SWT.NONE);
		lblTreasure.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTreasure.setText("Treasure");
		
		mobTreasure = new Text(composite_6, SWT.BORDER);
		mobTreasure.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Composite composite_6_1 = new Composite(grpCore, SWT.NONE);
		composite_6_1.setLayout(new GridLayout(2, false));
		
		Label lblMobGrp = new Label(composite_6_1, SWT.NONE);
		lblMobGrp.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMobGrp.setText("Mob Group");
		
		mobGroup = new Text(composite_6_1, SWT.BORDER);
		mobGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Group grpAcValues = new Group(grpCombatValues, SWT.NONE);
		grpAcValues.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpAcValues.setText("AC Values/Damage");
		RowLayout rl_grpAcValues = new RowLayout(SWT.HORIZONTAL);
		rl_grpAcValues.justify = true;
		rl_grpAcValues.pack = false;
		rl_grpAcValues.spacing = 0;
		grpAcValues.setLayout(rl_grpAcValues);
		
		Composite composite_7 = new Composite(grpAcValues, SWT.NONE);
		composite_7.setLayout(new GridLayout(1, false));
		
		Label lblPierceAc = new Label(composite_7, SWT.NONE);
		lblPierceAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblPierceAc.setText("Pierce AC");
		
		mobPierceAC = new Text(composite_7, SWT.BORDER);
		GridData gd_mobPierceAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobPierceAC.widthHint = 51;
		mobPierceAC.setLayoutData(gd_mobPierceAC);
		
		Composite composite_7_1 = new Composite(grpAcValues, SWT.NONE);
		composite_7_1.setLayout(new GridLayout(1, false));
		
		Label lblBashAc = new Label(composite_7_1, SWT.NONE);
		lblBashAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblBashAc.setText("Bash AC");
		
		mobBashAC = new Text(composite_7_1, SWT.BORDER);
		GridData gd_mobBashAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobBashAC.widthHint = 51;
		mobBashAC.setLayoutData(gd_mobBashAC);
		
		Composite composite_7_2 = new Composite(grpAcValues, SWT.NONE);
		composite_7_2.setLayout(new GridLayout(1, false));
		
		Label lblSlashAc = new Label(composite_7_2, SWT.NONE);
		lblSlashAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSlashAc.setText("Slash AC");
		
		mobSlashAC = new Text(composite_7_2, SWT.BORDER);
		GridData gd_mobSlashAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobSlashAC.widthHint = 51;
		mobSlashAC.setLayoutData(gd_mobSlashAC);
		
		Composite composite_7_3 = new Composite(grpAcValues, SWT.NONE);
		composite_7_3.setLayout(new GridLayout(1, false));
		
		Label lblMagicAc = new Label(composite_7_3, SWT.NONE);
		lblMagicAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblMagicAc.setText("Magic AC");
		
		mobMagicAC = new Text(composite_7_3, SWT.BORDER);
		GridData gd_mobMagicAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobMagicAC.widthHint = 51;
		mobMagicAC.setLayoutData(gd_mobMagicAC);
		
		Composite composite_7_4 = new Composite(grpAcValues, SWT.NONE);
		composite_7_4.setLayout(new GridLayout(1, false));
		
		Label lblDmgType = new Label(composite_7_4, SWT.NONE);
		lblDmgType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDmgType.setText("Dmg Type");
		
		Combo mobDamageType = new Combo(composite_7_4, SWT.NONE);
		GridData gd_mobDamageType = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_mobDamageType.widthHint = 42;
		mobDamageType.setLayoutData(gd_mobDamageType);
		
		Composite composite_7_4_1 = new Composite(grpAcValues, SWT.NONE);
		composite_7_4_1.setLayout(new GridLayout(1, false));
		
		Label lblDamage = new Label(composite_7_4_1, SWT.NONE);
		lblDamage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDamage.setText("Damage");
		
		Combo mobDamage = new Combo(composite_7_4_1, SWT.NONE);
		GridData gd_mobDamage = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_mobDamage.widthHint = 42;
		mobDamage.setLayoutData(gd_mobDamage);
		
		grpDice = new Group(grpCombatValues, SWT.NONE);
		grpDice.setLayout(new GridLayout(6, false));
		grpDice.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpDice.setText("Dice");
		
		lblHit = new Label(grpDice, SWT.NONE);
		lblHit.setText("Hit");
		
		mobHitDice1 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobHitDice1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_mobHitDice1.widthHint = 32;
		mobHitDice1.setLayoutData(gd_mobHitDice1);
		
		lblD = new Label(grpDice, SWT.NONE);
		lblD.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblD.setText("d");
		
		mobHitDice2 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobHitDice2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_mobHitDice2.widthHint = 32;
		mobHitDice2.setLayoutData(gd_mobHitDice2);
		
		label_1 = new Label(grpDice, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_1.setText("+");
		
		mobHitDice3 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobHitDice3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_mobHitDice3.widthHint = 40;
		mobHitDice3.setLayoutData(gd_mobHitDice3);
		
		lblMana = new Label(grpDice, SWT.NONE);
		lblMana.setText("Mana");
		
		mobManaDice1 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobManaDice1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_mobManaDice1.widthHint = 32;
		mobManaDice1.setLayoutData(gd_mobManaDice1);
		
		Label lblD_1 = new Label(grpDice, SWT.NONE);
		lblD_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblD_1.setText("d");
		
		mobManaDice2 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobManaDice2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_mobManaDice2.widthHint = 32;
		mobManaDice2.setLayoutData(gd_mobManaDice2);
		
		Label lblD_2 = new Label(grpDice, SWT.NONE);
		lblD_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblD_2.setText("+");
		
		mobManaDice3 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobManaDice3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_mobManaDice3.widthHint = 40;
		mobManaDice3.setLayoutData(gd_mobManaDice3);
		
		lblDmg = new Label(grpDice, SWT.NONE);
		lblDmg.setText("Dmg");
		
		mobDamageDice1 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobDamageDice1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_mobDamageDice1.widthHint = 32;
		mobDamageDice1.setLayoutData(gd_mobDamageDice1);
		
		Label lblD_3 = new Label(grpDice, SWT.NONE);
		lblD_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblD_3.setText("d");
		
		mobDamageDice2 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobDamageDice2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_mobDamageDice2.widthHint = 32;
		mobDamageDice2.setLayoutData(gd_mobDamageDice2);
		
		Label label_2 = new Label(grpDice, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("+");
		
		mobDamageDice3 = new Text(grpDice, SWT.BORDER);
		GridData gd_mobDamageDice3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_mobDamageDice3.widthHint = 40;
		mobDamageDice3.setLayoutData(gd_mobDamageDice3);
		
		Group grpAlignment = new Group(grpValues, SWT.NONE);
		grpAlignment.setLayout(new GridLayout(1, false));
		grpAlignment.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpAlignment.setText("Alignment");
		
		Scale scale_2 = new Scale(grpAlignment, SWT.NONE);
		scale_2.setPageIncrement(100);
		scale_2.setMaximum(2000);
		scale_2.setSelection(1000);
		scale_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_13 = new Composite(grpAlignment, SWT.NONE);
		composite_13.setLayout(new GridLayout(3, true));
		composite_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEvil = new Label(composite_13, SWT.NONE);
		lblEvil.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblEvil.setText("Evil");
		
		Label lblNeutral = new Label(composite_13, SWT.NONE);
		lblNeutral.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNeutral.setText("Neutral");
		
		Label lblGood = new Label(composite_13, SWT.NONE);
		lblGood.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblGood.setText("Good");
		
		grpActAffOffFlags = new Group(sashForm_1, SWT.NONE);
		grpActAffOffFlags.setText("Flags");
		grpActAffOffFlags.setLayout(new GridLayout(1, false));
		
		Group grpActFlags = new Group(grpActAffOffFlags, SWT.NONE);
		RowLayout rl_grpActFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpActFlags.pack = false;
		grpActFlags.setLayout(rl_grpActFlags);
		grpActFlags.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpActFlags.setText("Act Flags");
		
		Button btnNpc = new Button(grpActFlags, SWT.CHECK);
		btnNpc.setText("NPC");
		
		Button btnSentinel = new Button(grpActFlags, SWT.CHECK);
		btnSentinel.setText("Sentinel");
		
		Button btnScavenger = new Button(grpActFlags, SWT.CHECK);
		btnScavenger.setText("Scavenger");
		
		Button btnAggressive = new Button(grpActFlags, SWT.CHECK);
		btnAggressive.setText("Aggressive");
		
		Button btnStayArea = new Button(grpActFlags, SWT.CHECK);
		btnStayArea.setText("Stay area");
		
		Button btnWimpy = new Button(grpActFlags, SWT.CHECK);
		btnWimpy.setText("Wimpy");
		
		Button btnPet = new Button(grpActFlags, SWT.CHECK);
		btnPet.setText("Pet");
		
		Button btnTrain = new Button(grpActFlags, SWT.CHECK);
		btnTrain.setText("Train");
		
		Button btnPractice = new Button(grpActFlags, SWT.CHECK);
		btnPractice.setText("Practice");
		
		Button btnHunter = new Button(grpActFlags, SWT.CHECK);
		btnHunter.setText("Hunter");
		
		Button btnUndead_1 = new Button(grpActFlags, SWT.CHECK);
		btnUndead_1.setText("Undead");
		
		Button btnCleric = new Button(grpActFlags, SWT.CHECK);
		btnCleric.setText("Cleric");
		
		Button btnMage = new Button(grpActFlags, SWT.CHECK);
		btnMage.setText("Mage");
		
		Button btnThief = new Button(grpActFlags, SWT.CHECK);
		btnThief.setText("Thief");
		
		Button btnWarrior = new Button(grpActFlags, SWT.CHECK);
		btnWarrior.setText("Warrior");
		
		Button btnNoAlign = new Button(grpActFlags, SWT.CHECK);
		btnNoAlign.setText("No align");
		
		Button btnNoPurge = new Button(grpActFlags, SWT.CHECK);
		btnNoPurge.setText("No purge");
		
		Button btnOutdoors = new Button(grpActFlags, SWT.CHECK);
		btnOutdoors.setText("Outdoors");
		
		Button btnIndoors = new Button(grpActFlags, SWT.CHECK);
		btnIndoors.setText("Indoors");
		
		Button btnRideable = new Button(grpActFlags, SWT.CHECK);
		btnRideable.setText("Rideable");
		
		Button btnHealer = new Button(grpActFlags, SWT.CHECK);
		btnHealer.setText("Healer");
		
		Button btnGain = new Button(grpActFlags, SWT.CHECK);
		btnGain.setText("Gain");
		
		Button btnUpdate = new Button(grpActFlags, SWT.CHECK);
		btnUpdate.setText("Update");
		
		Button btnChanger = new Button(grpActFlags, SWT.CHECK);
		btnChanger.setText("Changer");
		
		Button btnNoTrack = new Button(grpActFlags, SWT.CHECK);
		btnNoTrack.setText("No track");
		
		Group grpAffFlags = new Group(grpActAffOffFlags, SWT.NONE);
		RowLayout rl_grpAffFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpAffFlags.pack = false;
		grpAffFlags.setLayout(rl_grpAffFlags);
		grpAffFlags.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpAffFlags.setText("Aff Flags");
		
		Button btnBlind = new Button(grpAffFlags, SWT.CHECK);
		btnBlind.setText("Blind");
		
		Button btnInvisible = new Button(grpAffFlags, SWT.CHECK);
		btnInvisible.setText("Invisible");
		
		Button btnDetectEvil = new Button(grpAffFlags, SWT.CHECK);
		btnDetectEvil.setText("Detect evil");
		
		Button btnDetectInvis = new Button(grpAffFlags, SWT.CHECK);
		btnDetectInvis.setText("Detect invis");
		
		Button btnDetectMagic = new Button(grpAffFlags, SWT.CHECK);
		btnDetectMagic.setText("Detect magic");
		
		Button btnDetectHide = new Button(grpAffFlags, SWT.CHECK);
		btnDetectHide.setText("Detect hide");
		
		Button btnDetectGood = new Button(grpAffFlags, SWT.CHECK);
		btnDetectGood.setText("Detect good");
		
		Button btnSanctuary = new Button(grpAffFlags, SWT.CHECK);
		btnSanctuary.setText("Sanctuary");
		
		Button btnFaerieFire = new Button(grpAffFlags, SWT.CHECK);
		btnFaerieFire.setText("Faerie fire");
		
		Button btnInfravision = new Button(grpAffFlags, SWT.CHECK);
		btnInfravision.setText("Infravision");
		
		Button btnProtectEvil = new Button(grpAffFlags, SWT.CHECK);
		btnProtectEvil.setText("Protect evil");
		
		Button btnProtectGood = new Button(grpAffFlags, SWT.CHECK);
		btnProtectGood.setText("Protect good");
		
		Button btnSneaking = new Button(grpAffFlags, SWT.CHECK);
		btnSneaking.setText("Sneaking");
		
		Button btnHiding = new Button(grpAffFlags, SWT.CHECK);
		btnHiding.setText("Hiding");
		
		Button btnFlying = new Button(grpAffFlags, SWT.CHECK);
		btnFlying.setText("Flying");
		
		Button btnPassDoor = new Button(grpAffFlags, SWT.CHECK);
		btnPassDoor.setText("Pass door");
		
		Button btnHaste = new Button(grpAffFlags, SWT.CHECK);
		btnHaste.setText("Haste");
		
		Button btnDarkVision = new Button(grpAffFlags, SWT.CHECK);
		btnDarkVision.setText("Dark vision");
		
		Button btnSwimming = new Button(grpAffFlags, SWT.CHECK);
		btnSwimming.setText("Swimming");
		
		Button btnRegeneration = new Button(grpAffFlags, SWT.CHECK);
		btnRegeneration.setText("Regeneration");
		
		Group grpOffFlags = new Group(grpActAffOffFlags, SWT.NONE);
		RowLayout rl_grpOffFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpOffFlags.pack = false;
		grpOffFlags.setLayout(rl_grpOffFlags);
		grpOffFlags.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpOffFlags.setText("Off Flags");
		
		Button btnAreaAttack = new Button(grpOffFlags, SWT.CHECK);
		btnAreaAttack.setText("Area attack");
		
		Button btnBackstab = new Button(grpOffFlags, SWT.CHECK);
		btnBackstab.setText("Backstab");
		
		Button btnBash = new Button(grpOffFlags, SWT.CHECK);
		btnBash.setText("Bash");
		
		Button btnBerserk = new Button(grpOffFlags, SWT.CHECK);
		btnBerserk.setText("Berserk");
		
		Button btnDisarm = new Button(grpOffFlags, SWT.CHECK);
		btnDisarm.setText("Disarm");
		
		Button btnDodge = new Button(grpOffFlags, SWT.CHECK);
		btnDodge.setText("Dodge");
		
		Button btnFade = new Button(grpOffFlags, SWT.CHECK);
		btnFade.setText("Fade");
		
		Button btnFast = new Button(grpOffFlags, SWT.CHECK);
		btnFast.setText("Fast");
		
		Button btnKick = new Button(grpOffFlags, SWT.CHECK);
		btnKick.setText("Kick");
		
		Button btnKickDirt = new Button(grpOffFlags, SWT.CHECK);
		btnKickDirt.setText("Kick dirt");
		
		Button btnParry = new Button(grpOffFlags, SWT.CHECK);
		btnParry.setText("Parry");
		
		Button btnRescue = new Button(grpOffFlags, SWT.CHECK);
		btnRescue.setText("Rescue");
		
		Button btnTail_1 = new Button(grpOffFlags, SWT.CHECK);
		btnTail_1.setText("Tail");
		
		Button btnTrip = new Button(grpOffFlags, SWT.CHECK);
		btnTrip.setText("Trip");
		
		Button btnCrush = new Button(grpOffFlags, SWT.CHECK);
		btnCrush.setText("Crush");
		
		grpImmresvuln = new Group(grpActAffOffFlags, SWT.NONE);
		grpImmresvuln.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpImmresvuln.setLayout(new GridLayout(5, false));
		grpImmresvuln.setText("Imm/Res/Vuln");
		new Label(grpImmresvuln, SWT.NONE);
		
		label = new Label(grpImmresvuln, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		lblImmune = new Label(grpImmresvuln, SWT.NONE);
		lblImmune.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblImmune.setText("Imm");
		
		lblResistant = new Label(grpImmresvuln, SWT.NONE);
		lblResistant.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblResistant.setText("Res");
		
		lblVuln = new Label(grpImmresvuln, SWT.NONE);
		lblVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblVuln.setText("Vuln");
		
		lblSummon = new Label(grpImmresvuln, SWT.NONE);
		lblSummon.setText("Summon");
		new Label(grpImmresvuln, SWT.NONE);
		
		summonImm = new Button(grpImmresvuln, SWT.CHECK);
		summonImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		summonRes = new Button(grpImmresvuln, SWT.CHECK);
		summonRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button summonVuln = new Button(grpImmresvuln, SWT.CHECK);
		summonVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblCharm = new Label(grpImmresvuln, SWT.NONE);
		lblCharm.setText("Charm");
		new Label(grpImmresvuln, SWT.NONE);
		
		Button charmImm = new Button(grpImmresvuln, SWT.CHECK);
		charmImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button charmRes = new Button(grpImmresvuln, SWT.CHECK);
		charmRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button charmVuln = new Button(grpImmresvuln, SWT.CHECK);
		charmVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblMagic = new Label(grpImmresvuln, SWT.NONE);
		lblMagic.setText("Magic");
		new Label(grpImmresvuln, SWT.NONE);
		
		Button magicImm = new Button(grpImmresvuln, SWT.CHECK);
		magicImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button magicRes = new Button(grpImmresvuln, SWT.CHECK);
		magicRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button magicVuln = new Button(grpImmresvuln, SWT.CHECK);
		magicVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblWeapons = new Label(grpImmresvuln, SWT.NONE);
		lblWeapons.setText("Weapons");
		new Label(grpImmresvuln, SWT.NONE);
		
		Button weaponsImm = new Button(grpImmresvuln, SWT.CHECK);
		weaponsImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button weaponsRes = new Button(grpImmresvuln, SWT.CHECK);
		weaponsRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button weaponsVuln = new Button(grpImmresvuln, SWT.CHECK);
		weaponsVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblBash = new Label(grpImmresvuln, SWT.NONE);
		lblBash.setText("Bash");
		new Label(grpImmresvuln, SWT.NONE);
		
		Button bashImm = new Button(grpImmresvuln, SWT.CHECK);
		bashImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button bashRes = new Button(grpImmresvuln, SWT.CHECK);
		bashRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button bashVuln = new Button(grpImmresvuln, SWT.CHECK);
		bashVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblPierce = new Label(grpImmresvuln, SWT.NONE);
		lblPierce.setText("Pierce");
		new Label(grpImmresvuln, SWT.NONE);
		
		Button pierceImm = new Button(grpImmresvuln, SWT.CHECK);
		pierceImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		pierceRes = new Button(grpImmresvuln, SWT.CHECK);
		pierceRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		pierceVuln = new Button(grpImmresvuln, SWT.CHECK);
		pierceVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblSlash = new Label(grpImmresvuln, SWT.NONE);
		lblSlash.setText("Slash");
		new Label(grpImmresvuln, SWT.NONE);
		
		slashImm = new Button(grpImmresvuln, SWT.CHECK);
		slashImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		slashRes = new Button(grpImmresvuln, SWT.CHECK);
		slashRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		slashVuln = new Button(grpImmresvuln, SWT.CHECK);
		slashVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblFire = new Label(grpImmresvuln, SWT.NONE);
		lblFire.setText("Fire");
		new Label(grpImmresvuln, SWT.NONE);
		
		fireImm = new Button(grpImmresvuln, SWT.CHECK);
		fireImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		fireRes = new Button(grpImmresvuln, SWT.CHECK);
		fireRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		fireVuln = new Button(grpImmresvuln, SWT.CHECK);
		fireVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblCold = new Label(grpImmresvuln, SWT.NONE);
		lblCold.setText("Cold");
		new Label(grpImmresvuln, SWT.NONE);
		
		coldImm = new Button(grpImmresvuln, SWT.CHECK);
		coldImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		coldRes = new Button(grpImmresvuln, SWT.CHECK);
		coldRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		coldVuln = new Button(grpImmresvuln, SWT.CHECK);
		coldVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblLightning = new Label(grpImmresvuln, SWT.NONE);
		lblLightning.setText("Lightning");
		new Label(grpImmresvuln, SWT.NONE);
		
		lightningImm = new Button(grpImmresvuln, SWT.CHECK);
		lightningImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lightningRes = new Button(grpImmresvuln, SWT.CHECK);
		lightningRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lightningVuln = new Button(grpImmresvuln, SWT.CHECK);
		lightningVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblAcid = new Label(grpImmresvuln, SWT.NONE);
		lblAcid.setText("Acid");
		new Label(grpImmresvuln, SWT.NONE);
		
		acidImm = new Button(grpImmresvuln, SWT.CHECK);
		acidImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		acidRes = new Button(grpImmresvuln, SWT.CHECK);
		acidRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		acidVuln = new Button(grpImmresvuln, SWT.CHECK);
		acidVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblPoison = new Label(grpImmresvuln, SWT.NONE);
		lblPoison.setText("Poison");
		new Label(grpImmresvuln, SWT.NONE);
		
		poisonImm = new Button(grpImmresvuln, SWT.CHECK);
		poisonImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		poisonRes = new Button(grpImmresvuln, SWT.CHECK);
		poisonRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		poisonVuln = new Button(grpImmresvuln, SWT.CHECK);
		poisonVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblNegative = new Label(grpImmresvuln, SWT.NONE);
		lblNegative.setText("Negative");
		new Label(grpImmresvuln, SWT.NONE);
		
		negativeImm = new Button(grpImmresvuln, SWT.CHECK);
		negativeImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		negativeRes = new Button(grpImmresvuln, SWT.CHECK);
		negativeRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		negativeVuln = new Button(grpImmresvuln, SWT.CHECK);
		negativeVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblHoly = new Label(grpImmresvuln, SWT.NONE);
		lblHoly.setText("Holy");
		new Label(grpImmresvuln, SWT.NONE);
		
		holyImm = new Button(grpImmresvuln, SWT.CHECK);
		holyImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		holyRes = new Button(grpImmresvuln, SWT.CHECK);
		holyRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		holyVuln = new Button(grpImmresvuln, SWT.CHECK);
		holyVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblEnergy = new Label(grpImmresvuln, SWT.NONE);
		lblEnergy.setText("Energy");
		new Label(grpImmresvuln, SWT.NONE);
		
		energyImm = new Button(grpImmresvuln, SWT.CHECK);
		energyImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		energyRes = new Button(grpImmresvuln, SWT.CHECK);
		energyRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		energyVuln = new Button(grpImmresvuln, SWT.CHECK);
		energyVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblMental = new Label(grpImmresvuln, SWT.NONE);
		lblMental.setText("Mental");
		new Label(grpImmresvuln, SWT.NONE);
		
		mentalImm = new Button(grpImmresvuln, SWT.CHECK);
		mentalImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		mentalRes = new Button(grpImmresvuln, SWT.CHECK);
		mentalRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		mentalVuln = new Button(grpImmresvuln, SWT.CHECK);
		mentalVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblDisease = new Label(grpImmresvuln, SWT.NONE);
		lblDisease.setText("Disease");
		new Label(grpImmresvuln, SWT.NONE);
		
		diseaseImm = new Button(grpImmresvuln, SWT.CHECK);
		diseaseImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		diseaseRes = new Button(grpImmresvuln, SWT.CHECK);
		diseaseRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		diseaseVuln = new Button(grpImmresvuln, SWT.CHECK);
		diseaseVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblDrowning = new Label(grpImmresvuln, SWT.NONE);
		lblDrowning.setText("Drowning");
		new Label(grpImmresvuln, SWT.NONE);
		
		drowningImm = new Button(grpImmresvuln, SWT.CHECK);
		drowningImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		drowningRes = new Button(grpImmresvuln, SWT.CHECK);
		drowningRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		drowningVuln = new Button(grpImmresvuln, SWT.CHECK);
		drowningVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblLight = new Label(grpImmresvuln, SWT.NONE);
		lblLight.setText("Light");
		new Label(grpImmresvuln, SWT.NONE);
		
		lightImm = new Button(grpImmresvuln, SWT.CHECK);
		lightImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lightRes = new Button(grpImmresvuln, SWT.CHECK);
		lightRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lightVuln = new Button(grpImmresvuln, SWT.CHECK);
		lightVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblSound = new Label(grpImmresvuln, SWT.NONE);
		lblSound.setText("Sound");
		new Label(grpImmresvuln, SWT.NONE);
		
		soundImm = new Button(grpImmresvuln, SWT.CHECK);
		soundImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		soundRes = new Button(grpImmresvuln, SWT.CHECK);
		soundRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		soundVuln = new Button(grpImmresvuln, SWT.CHECK);
		soundVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblWood = new Label(grpImmresvuln, SWT.NONE);
		lblWood.setText("Wood");
		new Label(grpImmresvuln, SWT.NONE);
		
		woodImm = new Button(grpImmresvuln, SWT.CHECK);
		woodImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		woodRes = new Button(grpImmresvuln, SWT.CHECK);
		woodRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		woodVuln = new Button(grpImmresvuln, SWT.CHECK);
		woodVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblSilver = new Label(grpImmresvuln, SWT.NONE);
		lblSilver.setText("Silver");
		new Label(grpImmresvuln, SWT.NONE);
		
		silverImm = new Button(grpImmresvuln, SWT.CHECK);
		silverImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		silverRes = new Button(grpImmresvuln, SWT.CHECK);
		silverRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		silverVuln = new Button(grpImmresvuln, SWT.CHECK);
		silverVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblIron = new Label(grpImmresvuln, SWT.NONE);
		lblIron.setText("Iron");
		new Label(grpImmresvuln, SWT.NONE);
		
		ironImm = new Button(grpImmresvuln, SWT.CHECK);
		ironImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		ironRes = new Button(grpImmresvuln, SWT.CHECK);
		ironRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		ironVuln = new Button(grpImmresvuln, SWT.CHECK);
		ironVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		grpShopspecial = new Group(sashForm_1, SWT.NONE);
		grpShopspecial.setText("Shop/Special");
		grpShopspecial.setLayout(new GridLayout(1, false));
		
		Group grpShopkeeper = new Group(grpShopspecial, SWT.NONE);
		grpShopkeeper.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpShopkeeper.setText("Shopkeeper");
		grpShopkeeper.setLayout(new GridLayout(1, false));
		
		Button mobShopEnable = new Button(grpShopkeeper, SWT.CHECK);
		mobShopEnable.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		mobShopEnable.setText("Mobile is a shopkeeper");
		
		Composite composite_8 = new Composite(grpShopkeeper, SWT.NONE);
		composite_8.setLayout(new GridLayout(3, false));
		composite_8.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		Label lblOpenHour = new Label(composite_8, SWT.NONE);
		lblOpenHour.setText("Open Hour");
		new Label(composite_8, SWT.NONE);
		
		Label lblCloseHour = new Label(composite_8, SWT.NONE);
		lblCloseHour.setText("Close Hour");
		
		Spinner mobShopOpenHour = new Spinner(composite_8, SWT.BORDER);
		mobShopOpenHour.setMaximum(23);
		mobShopOpenHour.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label label_3 = new Label(composite_8, SWT.NONE);
		label_3.setText("  -  ");
		
		Spinner mobShopCloseHour = new Spinner(composite_8, SWT.BORDER);
		mobShopCloseHour.setMaximum(23);
		mobShopCloseHour.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Composite composite_9 = new Composite(grpShopkeeper, SWT.NONE);
		composite_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_9.setSize(345, 99);
		composite_9.setLayout(new GridLayout(2, true));
		
		Label lblProfitbuyingFromRate = new Label(composite_9, SWT.NONE);
		lblProfitbuyingFromRate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblProfitbuyingFromRate.setText("Profit-buying from rate");
		
		Label lblProfitsellingToRate = new Label(composite_9, SWT.NONE);
		lblProfitsellingToRate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblProfitsellingToRate.setText("Profit-selling to rate");
		
		Scale scale = new Scale(composite_9, SWT.NONE);
		scale.setPageIncrement(25);
		scale.setMaximum(300);
		scale.setMinimum(100);
		scale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Scale scale_1 = new Scale(composite_9, SWT.NONE);
		scale_1.setSelection(100);
		scale_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Spinner mobShopProfitBuy = new Spinner(composite_9, SWT.BORDER);
		mobShopProfitBuy.setMaximum(300);
		mobShopProfitBuy.setMinimum(100);
		mobShopProfitBuy.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Spinner mobShopProfitSell = new Spinner(composite_9, SWT.BORDER);
		mobShopProfitSell.setSelection(100);
		mobShopProfitSell.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Composite composite_10 = new Composite(grpShopkeeper, SWT.NONE);
		composite_10.setLayout(new GridLayout(2, false));
		composite_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNoOfItem = new Label(composite_10, SWT.NONE);
		lblNoOfItem.setText("No. of item types to buy");
		
		Spinner mobShopItemTypeNo = new Spinner(composite_10, SWT.BORDER);
		mobShopItemTypeNo.setMaximum(5);
		
		Composite composite_11 = new Composite(grpShopkeeper, SWT.NONE);
		composite_11.setLayout(new GridLayout(2, false));
		composite_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblItemType = new Label(composite_11, SWT.NONE);
		lblItemType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType.setText("Item type 1");
		
		Combo mobShopItemType1 = new Combo(composite_11, SWT.NONE);
		mobShopItemType1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_5 = new Label(composite_11, SWT.NONE);
		lblItemType_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_5.setText("Item type 2");
		
		Combo mobShopItemType2 = new Combo(composite_11, SWT.NONE);
		mobShopItemType2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_1 = new Label(composite_11, SWT.NONE);
		lblItemType_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_1.setText("Item type 3");
		
		Combo mobShopItemType3 = new Combo(composite_11, SWT.NONE);
		mobShopItemType3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_2 = new Label(composite_11, SWT.NONE);
		lblItemType_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_2.setText("Item type 4");
		
		Combo mobShopItemType4 = new Combo(composite_11, SWT.NONE);
		mobShopItemType4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_3 = new Label(composite_11, SWT.NONE);
		lblItemType_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_3.setText("Item type 5");
		
		Combo mobShopItemType5 = new Combo(composite_11, SWT.NONE);
		mobShopItemType5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Group grpPracticer = new Group(grpShopspecial, SWT.NONE);
		RowLayout rl_grpPracticer = new RowLayout(SWT.HORIZONTAL);
		rl_grpPracticer.pack = false;
		grpPracticer.setLayout(rl_grpPracticer);
		grpPracticer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpPracticer.setText("Practicer");
		
		Button btnGroupnone = new Button(grpPracticer, SWT.CHECK);
		btnGroupnone.setText("group_none");
		
		Button btnGroupweaponmaster = new Button(grpPracticer, SWT.CHECK);
		btnGroupweaponmaster.setText("group_weaponmaster");
		
		Button btnGroupattack = new Button(grpPracticer, SWT.CHECK);
		btnGroupattack.setText("group_attack");
		
		Button btnGroupbeguiling = new Button(grpPracticer, SWT.CHECK);
		btnGroupbeguiling.setText("group_beguiling");
		
		Button btnGroupcreation = new Button(grpPracticer, SWT.CHECK);
		btnGroupcreation.setText("group_creation");
		
		Button btnGroupcurative = new Button(grpPracticer, SWT.CHECK);
		btnGroupcurative.setText("group_curative");
		
		Button btnGroupdetection = new Button(grpPracticer, SWT.CHECK);
		btnGroupdetection.setText("group_detection");
		
		Button btnGroupdraconian = new Button(grpPracticer, SWT.CHECK);
		btnGroupdraconian.setText("group_draconian");
		
		Button btnGroupenchantment = new Button(grpPracticer, SWT.CHECK);
		btnGroupenchantment.setText("group_enchantment");
		
		Button btnGroupenhancement = new Button(grpPracticer, SWT.CHECK);
		btnGroupenhancement.setText("group_enhancement");
		
		Button btnGroupharmful = new Button(grpPracticer, SWT.CHECK);
		btnGroupharmful.setText("group_harmful");
		
		Button btnGrouphealing = new Button(grpPracticer, SWT.CHECK);
		btnGrouphealing.setText("group_healing");
		
		Button btnGroupillusion = new Button(grpPracticer, SWT.CHECK);
		btnGroupillusion.setText("group_illusion");
		
		Button btnGroupmaladictions = new Button(grpPracticer, SWT.CHECK);
		btnGroupmaladictions.setText("group_maladictions");
		
		Button btnGroupprotective = new Button(grpPracticer, SWT.CHECK);
		btnGroupprotective.setText("group_protective");
		
		Button btnGrouptransportation = new Button(grpPracticer, SWT.CHECK);
		btnGrouptransportation.setText("group_transportation");
		
		Button btnGroupweather = new Button(grpPracticer, SWT.CHECK);
		btnGroupweather.setText("group_weather");
		
		Button btnGroupfightmaster = new Button(grpPracticer, SWT.CHECK);
		btnGroupfightmaster.setText("group_fightmaster");
		
		Button btnGroupsuddendeath = new Button(grpPracticer, SWT.CHECK);
		btnGroupsuddendeath.setText("group_suddendeath");
		
		Button btnGroupmeditation = new Button(grpPracticer, SWT.CHECK);
		btnGroupmeditation.setText("group_meditation");
		
		Button btnGroupcabal = new Button(grpPracticer, SWT.CHECK);
		btnGroupcabal.setText("group_cabal");
		
		Button btnGroupdefense = new Button(grpPracticer, SWT.CHECK);
		btnGroupdefense.setText("group_defense");
		
		Button btnGroupdefensive = new Button(grpPracticer, SWT.CHECK);
		btnGroupdefensive.setText("group_defensive");
		
		Button btnGroupwizard = new Button(grpPracticer, SWT.CHECK);
		btnGroupwizard.setText("group_wizard");
		
		Group grpProgsfuncs = new Group(grpShopspecial, SWT.NONE);
		grpProgsfuncs.setLayout(new RowLayout(SWT.HORIZONTAL));
		grpProgsfuncs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpProgsfuncs.setText("Progs/Funcs");
		
		Composite composite_12 = new Composite(grpProgsfuncs, SWT.NONE);
		GridLayout gl_composite_12 = new GridLayout(2, false);
		composite_12.setLayout(gl_composite_12);
		
		Label lblProg = new Label(composite_12, SWT.NONE);
		lblProg.setText("Prog");
		
		Label lblFunction = new Label(composite_12, SWT.NONE);
		lblFunction.setText("Function");
		
		Combo combo_3 = new Combo(composite_12, SWT.NONE);
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		text_3 = new Text(composite_12, SWT.BORDER);
		GridData gd_text_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_3.widthHint = 100;
		text_3.setLayoutData(gd_text_3);
		
		Composite composite_12_1 = new Composite(grpProgsfuncs, SWT.NONE);
		composite_12_1.setLayout(new GridLayout(1, false));
		
		Label lblSpecialFunction = new Label(composite_12_1, SWT.NONE);
		lblSpecialFunction.setText("Special function");
		
		text_4 = new Text(composite_12_1, SWT.BORDER);
		GridData gd_text_4 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_4.widthHint = 100;
		text_4.setLayoutData(gd_text_4);
		sashForm_1.setWeights(new int[] {413, 326, 418, 360});
		
		TabItem tbtmObjectEditor_1 = new TabItem(tabFolder_1, SWT.NONE);
		tbtmObjectEditor_1.setText("Object Editor");
		
		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(tabFolder_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmObjectEditor_1.setControl(scrolledComposite_2);
		scrolledComposite_2.setExpandHorizontal(true);
		scrolledComposite_2.setExpandVertical(true);
		
		Composite composite_14 = new Composite(scrolledComposite_2, SWT.NONE);
		composite_14.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_2 = new SashForm(composite_14, SWT.SMOOTH);
		
		Group grpGrp = new Group(sashForm_2, SWT.NONE);
		grpGrp.setText("grp1");
		grpGrp.setLayout(new GridLayout(1, false));
		
		Group grpGrp_4 = new Group(grpGrp, SWT.NONE);
		grpGrp_4.setLayout(new GridLayout(1, false));
		GridData gd_grpGrp_4 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpGrp_4.widthHint = 200;
		grpGrp_4.setLayoutData(gd_grpGrp_4);
		grpGrp_4.setText("grp1_1");
		
		Label lblLbl = new Label(grpGrp_4, SWT.NONE);
		lblLbl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblLbl.setText("lbl1");
		
		txtTxt = new Text(grpGrp_4, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtTxt.setText("txt1");
		GridData gd_txtTxt = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTxt.widthHint = 150;
		gd_txtTxt.heightHint = 250;
		txtTxt.setLayoutData(gd_txtTxt);
		
		Group grpGrp_1 = new Group(sashForm_2, SWT.NONE);
		grpGrp_1.setText("grp2");
		grpGrp_1.setLayout(new GridLayout(1, false));
		
		Group grpGrp_5 = new Group(grpGrp_1, SWT.NONE);
		GridData gd_grpGrp_5 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpGrp_5.widthHint = 250;
		grpGrp_5.setLayoutData(gd_grpGrp_5);
		grpGrp_5.setText("grp2_1");
		
		Group grpGrp_2 = new Group(sashForm_2, SWT.NONE);
		grpGrp_2.setText("grp3");
		grpGrp_2.setLayout(new GridLayout(1, false));
		
		Group grpGrp_3 = new Group(sashForm_2, SWT.NONE);
		grpGrp_3.setText("grp4");
		grpGrp_3.setLayout(new GridLayout(1, false));
		sashForm_2.setWeights(new int[] {10, 10, 10, 10});
		scrolledComposite_2.setContent(composite_14);
		scrolledComposite_2.setMinSize(composite_14.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		TabItem tbtmAreaOverview = new TabItem(tabFolder, SWT.NONE);
		tbtmAreaOverview.setText("Area Overview");
		
		ListViewer listViewer = new ListViewer(tabFolder, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		tbtmAreaOverview.setControl(list);
		
		CLabel lblLog = new CLabel(composite_1, SWT.NONE);
		lblLog.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblLog.setText("Log");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_scrolledComposite.heightHint = 103;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		text = new Text(scrolledComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.CANCEL | SWT.MULTI);
		scrolledComposite.setContent(text);
		scrolledComposite.setMinSize(text.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		m_bindingContext = initDataBindings();

	}
	
	/*private void updateWorldObjectTree() {
		this.worldObjectTree.setContentProvider(new TreeContentProvider());
		this.worldObjectTree.setLabelProvider(new TreeLabelProvider());
		this.worldObjectTree.setInput(parser.getArea().getRooms().values());
	}*/
	
	
	class fileOpenItemListener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent event) {
			System.out.println("Open clicked");
			FileDialog fd = new FileDialog(shell, SWT.OPEN);
			fd.setText("Open");
			String[] filterExt = { "*.are", "*.*" };
			fd.setFilterExtensions(filterExt);
			filePath = fd.open();
			System.out.println("Open selected: " + filePath);
			parser = new AreaFileParser(filePath);
			tree.removeAll();
			parser.getArea().getRooms().forEach((key, value) -> {
		    	TreeItem roomItem = new TreeItem(tree,0);
		    	roomItem.setText("Room " + key + " - " + value.header);
		    });
			
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent event) {
			System.out.println("Open clicked");
			FileDialog fd = new FileDialog(shell, SWT.OPEN);
			fd.setText("Open");
			String[] filterExt = { "*.are", "*.*" };
			fd.setFilterExtensions(filterExt);
			filePath = fd.open();
			System.out.println("Open selected: " + filePath);
			parser = new AreaFileParser(filePath);
		}
	}
	
	class fileSaveItemListener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent event) {
			System.out.println("Save clicked");
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent event) {
			System.out.println("Save clicked");
		}
	}
	
	class fileExitItemListener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent event) {
			System.out.println("Exit clicked");
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent event) {
			System.out.println("Exit clicked");
		}
	}
	
	public class TreeContentProvider implements ITreeContentProvider, IResourceChangeListener   {
		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof Room) {
				Room room = (Room)parentElement;
				return concat(room.getMobileResets().values().toArray(), 
					room.getObjectResets().values().toArray());
			}
			else if(parentElement instanceof MobileReset) {
				MobileReset mobileReset = (MobileReset)parentElement;
				return concat(mobileReset.getGiveResets().toArray(),
						mobileReset.getEquipResets().toArray());
			}
			else if(parentElement instanceof ObjectReset) {
				ObjectReset objectReset = (ObjectReset)parentElement;
				return objectReset.getListContains().toArray();
			}
			
			// TODO: implement other resets, give equip...
			return null;
		}

		@Override
		public void resourceChanged(IResourceChangeEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class TreeLabelProvider implements ILabelProvider {
		
		private Image room;
		private Image mobile;
		
		public TreeLabelProvider() {
		    // Create the list to hold the listeners
//		    listeners = new ArrayList();
		    // Create the images
			try {
				room = new Image(null, new FileInputStream("resources/tree/room.gif"));
				mobile = new Image(null, new FileInputStream("resources/tree/mobile.gif"));
			} 
			catch (FileNotFoundException e) {
				// Swallow it; we'll do without images
			}
		  }

		@Override
		public void addListener(ILabelProviderListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			if (room != null)
				room.dispose();
			if (mobile != null)
				mobile.dispose();
		}

		@Override
		public boolean isLabelProperty(Object arg0, String arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Image getImage(Object element) {
			Image image = null;
			if (element instanceof Room) {
				image = room;
			} 
			else if (element instanceof MobileReset) {
				image = mobile;
			}
//			else throw unknownElement(element);
			return image;
		}

		@Override
		// TODO: change returned names
		public String getText(Object element) {
			if (element instanceof Room) {
				Room room = (Room) element;
				return room.getHeader();
			}
			else if (element instanceof MobileReset) {
				MobileReset mobileReset = (MobileReset) element;
				return mobileReset.mobileVNum;
			}
			else if (element instanceof ObjectReset) {
				ObjectReset objectReset = (ObjectReset) element;
				return objectReset.objectVNum;
			}
			return "NO NAME";
		}
	}
	
	public static <T> T[] concat(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
	public Tree getTree() {
		return tree;
	}
	public Spinner getRoomVnumSpinner() {
		return RoomVnumSpinner;
	}
	public Text getRoomNameText() {
		return roomNameText;
	}
	public Text getRoomDescText() {
		return roomDescText;
	}
	public Group getGrpDoors() {
		return grpDoors;
	}
	public int getRoomVnumSpinnerSelection() {
		return RoomVnumSpinner.getSelection();
	}
	public void setRoomVnumSpinnerSelection(int selection) {
		RoomVnumSpinner.setSelection(selection);
	}
	public String getRoomNameTextVal() {
		return roomNameText.getText();
	}
	public void setRoomNameTextVal(String text_1) {
		roomNameText.setText(text_1);
	}
	public String getRoomDescTextVal() {
		return roomDescText.getText();
	}
	public void setRoomDescTextVal(String text_2) {
		roomDescText.setText(text_2);
	}
	public Table getRoomExtrasTable() {
		return roomExtrasTable;
	}
	public TableViewerColumn getRoomExtrasKeywordsColumn() {
		return tableViewerColumn;
	}
	public TableViewerColumn getRoomExtrasDescColumn() {
		return tableViewerColumn_1;
	}
	public Text getNorthDescText() {
		return northDescText;
	}
	public Text getNorthDoorKeywordText() {
		return northDoorKeywordText;
	}
	public Combo getNorthDoorStateCombo() {
		return northDoorStateCombo;
	}
	public Composite getNorthComposite() {
		return northComposite;
	}
	public Combo getNorthDoorKeyCombo() {
		return northDoorKeyCombo;
	}
	public Combo getNorthDoorSizeCombo() {
		return northDoorSizeCombo;
	}
	public Button getNorthDoorFlagJCheck() {
		return northDoorFlagJCheck;
	}
	public Button getNorthDoorFlagHCheck() {
		return northDoorFlagHCheck;
	}
	public Button getNorthDoorFlagKCheck() {
		return northDoorFlagKCheck;
	}
	public Button getNorthDoorFlagACheck() {
		return northDoorFlagACheck;
	}
	public Button getNorthDoorFlagBCheck() {
		return northDoorFlagBCheck;
	}
	public Button getNorthDoorFlagICheck() {
		return northDoorFlagICheck;
	}
	public Button getNorthDoorFlagFCheck() {
		return northDoorFlagFCheck;
	}
	public Button getNorthDoorFlagCCheck() {
		return northDoorFlagCCheck;
	}
	public Button getNorthDoorFlagLCheck() {
		return northDoorFlagLCheck;
	}
	public Button getNorthDoorFlagGCheck() {
		return northDoorFlagGCheck;
	}
	public Text getEastDescText() {
		return eastDescText;
	}
	public Text getEastDoorKeywordText() {
		return eastDoorKeywordText;
	}
	public Combo getEastDoorStateCombo() {
		return eastDoorStateCombo;
	}
	public Combo getEastDoorKeyCombo() {
		return eastDoorKeyCombo;
	}
	public Combo getEastDoorSizeCombo() {
		return eastDoorSizeCombo;
	}
	public Button getEastDoorFlagJCheck() {
		return eastDoorFlagJCheck;
	}
	public Button getEastDoorFlagACheck() {
		return eastDoorFlagACheck;
	}
	public Button getEastDoorFlagICheck() {
		return eastDoorFlagICheck;
	}
	public Button getEastDoorFlagCCheck() {
		return eastDoorFlagCCheck;
	}
	public Button getEastDoorFlagFCheck() {
		return eastDoorFlagFCheck;
	}
	public Button getEastDoorFlagGCheck() {
		return eastDoorFlagGCheck;
	}
	public Button getEastDoorFlagHCheck() {
		return eastDoorFlagHCheck;
	}
	public Button getEastDoorFlagKCheck() {
		return eastDoorFlagKCheck;
	}
	public Button getEastDoorFlagLCheck() {
		return eastDoorFlagLCheck;
	}
	public Button getEastDoorFlagBCheck() {
		return eastDoorFlagBCheck;
	}
	public Combo getSouthDoorKeyCombo() {
		return southDoorKeyCombo;
	}
	public Combo getSouthDoorStateCombo() {
		return southDoorStateCombo;
	}
	public Combo getSouthDoorSizeCombo() {
		return southDoorSizeCombo;
	}
	public Text getSouthDescText() {
		return southDescText;
	}
	public Text getSouthDoorKeywordText() {
		return southDoorKeywordText;
	}
	public Button getSouthDoorFlagICheck() {
		return southDoorFlagICheck;
	}
	public Button getSouthDoorFlagKCheck() {
		return southDoorFlagKCheck;
	}
	public Button getSouthDoorFlagCCheck() {
		return southDoorFlagCCheck;
	}
	public Button getSouthDoorFlagJCheck() {
		return southDoorFlagJCheck;
	}
	public Button getSouthDoorFlagLCheck() {
		return southDoorFlagLCheck;
	}
	public Button getSouthDoorFlagGCheck() {
		return southDoorFlagGCheck;
	}
	public Button getSouthDoorFlagACheck() {
		return southDoorFlagACheck;
	}
	public Button getSouthDoorFlagBCheck() {
		return southDoorFlagBCheck;
	}
	public Button getSouthDoorFlagFCheck() {
		return southDoorFlagFCheck;
	}
	public Button getSouthDoorFlagHCheck() {
		return southDoorFlagHCheck;
	}
	public Combo getWestDoorSizeCombo() {
		return westDoorSizeCombo;
	}
	public Combo getWestDoorKeyCombo() {
		return westDoorKeyCombo;
	}
	public Text getWestDescText() {
		return westDescText;
	}
	public Combo getWestDoorStateCombo() {
		return westDoorStateCombo;
	}
	public Text getWestDoorKeywordText() {
		return westDoorKeywordText;
	}
	public Button getWestDoorFlagFCheck() {
		return westDoorFlagFCheck;
	}
	public Button getWestDoorFlagGCheck() {
		return westDoorFlagGCheck;
	}
	public Button getWestDoorFlagKCheck() {
		return westDoorFlagKCheck;
	}
	public Button getWestDoorFlagACheck() {
		return westDoorFlagACheck;
	}
	public Button getWestDoorFlagICheck() {
		return westDoorFlagICheck;
	}
	public Button getWestDoorFlagLCheck() {
		return westDoorFlagLCheck;
	}
	public Button getWestDoorFlagHCheck() {
		return westDoorFlagHCheck;
	}
	public Button getWestDoorFlagJCheck() {
		return westDoorFlagJCheck;
	}
	public Button getWestDoorFlagBCheck() {
		return westDoorFlagBCheck;
	}
	public Button getWestDoorFlagCCheck() {
		return westDoorFlagCCheck;
	}
	public Text getUpDoorKeywordText() {
		return upDoorKeywordText;
	}
	public Text getUpDescText() {
		return upDescText;
	}
	public Combo getUpDoorStateCombo() {
		return upDoorStateCombo;
	}
	public Combo getUpDoorKeyCombo() {
		return upDoorKeyCombo;
	}
	public Combo getUpDoorSizeCombo() {
		return upDoorSizeCombo;
	}
	public Button getUpDoorFlagACheck() {
		return upDoorFlagACheck;
	}
	public Button getUpDoorFlagKCheck() {
		return upDoorFlagKCheck;
	}
	public Button getUpDoorFlagBCheck() {
		return upDoorFlagBCheck;
	}
	public Button getUpDoorFlagFCheck() {
		return upDoorFlagFCheck;
	}
	public Button getUpDoorFlagLCheck() {
		return upDoorFlagLCheck;
	}
	public Button getUpDoorFlagCCheck() {
		return upDoorFlagCCheck;
	}
	public Button getUpDoorFlagJCheck() {
		return upDoorFlagJCheck;
	}
	public Button getUpDoorFlagICheck() {
		return upDoorFlagICheck;
	}
	public Button getUpDoorFlagGCheck() {
		return upDoorFlagGCheck;
	}
	public Button getUpDoorFlagHCheck() {
		return upDoorFlagHCheck;
	}
	public Text getDownDescText() {
		return downDescText;
	}
	public Combo getDownDoorKeyCombo() {
		return downDoorKeyCombo;
	}
	public Combo getDownDoorStateCombo() {
		return downDoorStateCombo;
	}
	public Combo getDownDoorSizeCombo() {
		return downDoorSizeCombo;
	}
	public Text getDownDoorKeywordText() {
		return downDoorKeywordText;
	}
	public Button getDownDoorFlagACheck() {
		return downDoorFlagACheck;
	}
	public Button getDownDoorFlagGCheck() {
		return downDoorFlagGCheck;
	}
	public Button getDownDoorFlagHCheck() {
		return downDoorFlagHCheck;
	}
	public Button getDownDoorFlagBCheck() {
		return downDoorFlagBCheck;
	}
	public Button getDownDoorFlagJCheck() {
		return downDoorFlagJCheck;
	}
	public Button getDownDoorFlagCCheck() {
		return downDoorFlagCCheck;
	}
	public Button getDownDoorFlagFCheck() {
		return downDoorFlagFCheck;
	}
	public Button getDownDoorFlagKCheck() {
		return downDoorFlagKCheck;
	}
	public Button getDownDoorFlagICheck() {
		return downDoorFlagICheck;
	}
	public Button getDownDoorFlagLCheck() {
		return downDoorFlagLCheck;
	}
	public Scale getRoomHPScale() {
		return roomHPScale;
	}
	public Spinner getRoomHPSpinner() {
		return roomHPSpinner;
	}
	public Scale getRoomMPScale() {
		return roomMPScale;
	}
	public Spinner getRoomMPSpinner() {
		return roomMPSpinner;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSelectionRoomHPScaleObserveWidget = WidgetProperties.selection().observe(roomHPScale);
		IObservableValue observeSelectionRoomHPSpinnerObserveWidget = WidgetProperties.selection().observe(roomHPSpinner);
		bindingContext.bindValue(observeSelectionRoomHPScaleObserveWidget, observeSelectionRoomHPSpinnerObserveWidget, null, null);
		//
		IObservableValue observeSelectionRoomMPScaleObserveWidget = WidgetProperties.selection().observe(roomMPScale);
		IObservableValue observeSelectionRoomMPSpinnerObserveWidget = WidgetProperties.selection().observe(roomMPSpinner);
		bindingContext.bindValue(observeSelectionRoomMPScaleObserveWidget, observeSelectionRoomMPSpinnerObserveWidget, null, null);
		//
		return bindingContext;
	}
	public Button getRoomSectorMountain() {
		return roomSectorMountain;
	}
	public Button getRoomSectorCity() {
		return roomSectorCity;
	}
	public Button getRoomSectorForest() {
		return roomSectorForest;
	}
	public Button getRoomSectorHill() {
		return roomSectorHill;
	}
	public Button getRoomSectorDeepWater() {
		return roomSectorDeepWater;
	}
	public Button getRoomSectorWater() {
		return roomSectorWater;
	}
	public Button getRoomSectorInside() {
		return roomSectorInside;
	}
	public Button getRoomSectorDesert() {
		return roomSectorDesert;
	}
	public Button getRoomSectorAir() {
		return roomSectorAir;
	}
	public Button getRoomSectorField() {
		return roomSectorField;
	}
	public Button getRoomSectorUnused() {
		return roomSectorUnused;
	}
	public Button getBtnRoomRegistry() {
		return btnRoomRegistry;
	}
	public Button getBtnRoomNowhere() {
		return btnRoomNowhere;
	}
	public Button getBtnRoomBank() {
		return btnRoomBank;
	}
	public Button getBtnRoomDark() {
		return btnRoomDark;
	}
	public Button getBtnRoomNoSummon() {
		return btnRoomNoSummon;
	}
	public Button getBtnRoomNoMob() {
		return btnRoomNoMob;
	}
	public Button getBtnRoomHeroesOnly() {
		return btnRoomHeroesOnly;
	}
	public Button getBtnRoomNoMagic() {
		return btnRoomNoMagic;
	}
	public Button getBtnRoomPrivate() {
		return btnRoomPrivate;
	}
	public Button getBtnRoomLaw() {
		return btnRoomLaw;
	}
	public Button getBtnRoomIndoors() {
		return btnRoomIndoors;
	}
	public Button getBtnRoomSolitary() {
		return btnRoomSolitary;
	}
	public Button getBtnRoomSafe() {
		return btnRoomSafe;
	}
	public Button getBtnRoomImpOnly() {
		return btnRoomImpOnly;
	}
	public Button getBtnRoomNoRecall() {
		return btnRoomNoRecall;
	}
	public Button getBtnRoomNewbiesOnly() {
		return btnRoomNewbiesOnly;
	}
	public Button getBtnRoomPetShop() {
		return btnRoomPetShop;
	}
	public Button getBtnRoomGodsOnly() {
		return btnRoomGodsOnly;
	}
}
