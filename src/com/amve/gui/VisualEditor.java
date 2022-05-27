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

import com.amve.area.Mobile;
import com.amve.area.Mobile.Race;
import com.amve.area.Room;
import com.amve.area.Shop;
import com.amve.globals.GlobalVariables;
import com.amve.globals.GlobalVariables.DoorFlag;
import com.amve.globals.GlobalVariables.DoorState;
import com.amve.globals.GlobalVariables.ExitDirection;
import com.amve.globals.GlobalVariables.ItemExtra;
import com.amve.globals.GlobalVariables.RoomFlag;
import com.amve.globals.GlobalVariables.RoomSector;
import com.amve.parser.AreaFileParser;
import com.amve.utils.Armor;
import com.amve.utils.Container;
import com.amve.utils.Drink;
import com.amve.utils.EquipReset;
import com.amve.utils.Exit;
import com.amve.utils.ExtraDescription;
import com.amve.utils.Food;
import com.amve.utils.Item;
import com.amve.utils.Light;
import com.amve.utils.MobileReset;
import com.amve.utils.Money;
import com.amve.utils.ObjectReset;
import com.amve.utils.Potion;
import com.amve.utils.Scroll;
import com.amve.utils.Staff;
import com.amve.utils.Wand;
import com.amve.utils.Weapon;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Slider;

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
	private Combo northDoorStateCombo;
	private Composite northComposite;
	private Text northDoorKeyCombo;
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
	private Text eastDoorKeyCombo;
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
	private Text southDoorKeyCombo;
	private Combo southDoorStateCombo;
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
	private Text westDoorKeyCombo;
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
	private Text upDoorKeyCombo;
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
	private Text downDoorKeyCombo;
	private Combo downDoorStateCombo;
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
	private Spinner mobTreasure;
	private Spinner mobGroup;
	private Spinner mobPierceAC;
	private Spinner mobBashAC;
	private Spinner mobSlashAC;
	private Spinner mobMagicAC;
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
	private Table roomExtrasTable;
	private Text objName;
	private Text objShortDesc;
	private Text objLongDesc;
	private Table objectExtrasTable;
	private Text noneModifTxt;
	private Text strModif;
	private Text dexModif;
	private Text intModif;
	private Text wisModif;
	private Text conModif;
	private Text chaModif;
	private Text classModif;
	private Text levelModif;
	private Text ageModif;
	private Text manaModif;
	private Text hpModif;
	private Text moveModif;
	private Text expModif;
	private Text armorModif;
	private Text hitrollModif;
	private Text damrollModif;
	private Text sexModif;
	private Text spellModif;
	private Text saveModif;
	private Text objFuncText;
	private Button northDoorCheckbox;
	private Button eastDoorCheckbox;
	private Button southDoorCheckbox;
	private Button westDoorCheckbox;
	private Button upDoorCheckbox;
	private Button downDoorCheckbox;
	private Group grpResets;
	private Combo mobSizeCombo;
	private Combo mobRaceCombo;
	private Combo combo;
	private Combo combo_1;
	private Combo combo_2;
	private Button btnPoison;
	private Button btnVanishes;
	private Button btnOther;
	private Button btnMagical;
	private Button btnEdible;
	private Button btnAnimal;
	private Button btnSentient;
	private Button btnUndead;
	private Button btnConstruct;
	private Spinner mobLvlSpinner;
	private Text mobDamageType;
	private Scale scale_2;
	private Spinner spinner_2;
	private Button summonVuln;
	private Button magicRes;
	private Button weaponsVuln;
	private Button charmVuln;
	private Button weaponsImm;
	private Button bashRes;
	private Button magicImm;
	private Button magicVuln;
	private Button bashVuln;
	private Button bashImm;
	private Button charmImm;
	private Button pierceImm;
	private Button charmRes;
	private Button weaponsRes;
	private Text objMaterial;
	private Spinner objWeight;
	private Spinner objCost;
	private Combo objStatus;
	private Spinner objLevel;
	private Button btnOnTorso;
	private Button btnLegs_1;
	private Button btnTake;
	private Button btnNoSac;
	private Button btnTwoHands;
	private Button btnHead_1;
	private Button btnNeck;
	private Button btnHeld;
	private Button btnWielded;
	private Button btnAsShield;
	private Button btnWaist;
	private Button btnFinger;
	private Button btnArms_1;
	private Button btnLeftWrist;
	private Button btnHands_1;
	private Button btnFeet_1;
	private Button btnAboutBody;
	private Button btnFloatingNearby;
	private Button btnTattoo;
	private Button btnDark;
	private Button btnBless;
	private Button btnNoLocate;
	private Button btnGlowing;
	private Button btnBurnproof;
	private Button btnHumming;
	private Button btnInventory;
	private Button btnNoSacrifice;
	private Button btnHadTimer;
	private Button btnSellExtract;
	private Button btnMeltDrop;
	private Button btnAntievil;
	private Button btnVisRot;
	private Button btnNoRemove;
	private Button btnAntineutral;
	private Button btnRotDeath;
	private Button btnEvil;
	private Button btnMagic;
	private Button btnNoSell;
	private Button btnAntigood;
	private Button btnVisDeeath;
	private Button btnInvisible_1;
	private Button btnNoDrop;
	private Button btnNoPurge_1;
	private Button btnNoUncurse;
	private Button btnNonmetal;
	private Button btnLock;
	private Spinner mobShopOpenHour;
	private Button mobShopEnable;
	private Spinner mobShopCloseHour;
	private Scale scale;
	private Scale scale_1;
	private Spinner mobShopProfitBuy;
	private Spinner mobShopProfitSell;
	private Spinner mobShopItemTypeNo;
	private Combo mobShopItemType1;
	private Combo mobShopItemType2;
	private Combo mobShopItemType3;
	private Combo mobShopItemType4;
	private Combo mobShopItemType5;
	private Text actFlagsText;
	private Text affFlagsText;
	private Text offFlagsText;
	private TabFolder tabFolder_1;
	private Text armorPierce;
	private Text armorBash;
	private Text armorSlash;
	private Text armorMagic;
	private Text armorBulk;
	private Text wandStaffSpell;
	private Text magicItemSpell1;
	private Text magicItemSpell2;
	private Text magicItemSpell3;
	private Text magicItemSpell4;
	private Text weaponDmgType;
	private Text drinkLiquidType;
	private Group grpTypeProperties;
	private Composite moneyTypeComp;
	private Composite lightTypeComp;
	private Composite foodTypeComp;
	private Composite magicItemTypeComp;
	private Composite containerTypeComp;
	private Composite weaponTypeComp;
	private Composite drinkTypeComp;
	private Composite armorTypeComp;
	private Composite wandStaffTypeComp;
	private Spinner containerMaxItemWeight;
	private Spinner weaponDiceNo;
	private Spinner lightLevel;
	private Spinner moneySilverVal;
	private Spinner magicItemLevel;
	private Spinner containerWeightMult;
	private Spinner moneyGoldVal;
	private Spinner lightDuration;
	private Spinner weaponDiceFaces;
	private Spinner foodNormal;
	private Spinner wandStaffSpellLevel;
	private Combo magicItemSpellCount;
	private Spinner drinkCurrentAmount;
	private Button drinkPoisoned;
	private Combo weaponClass;
	private Spinner drinkContainerSize;
	private Spinner containerMaxTotalWeight;
	private Spinner wandStaffMaxCharge;
	private Spinner foodFull;
	private Button foodPoisoned;
	private Spinner wandStaffCurrCharge;
	private Combo objProg;
	private Combo objLimit;
	private Combo objType;

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
		getNorthDoorKeyCombo().setText("");
		getNorthDoorCheckbox().setSelection(false);
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
		getEastDoorKeyCombo().setText("");
		getEastDoorCheckbox().setSelection(false);
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
		getSouthDoorKeyCombo().setText("");
		getSouthDoorCheckbox().setSelection(false);
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
		getWestDoorKeyCombo().setText("");
		getWestDoorCheckbox().setSelection(false);
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
		getUpDoorKeyCombo().setText("");
		getUpDoorCheckbox().setSelection(false);
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
		getDownDoorKeyCombo().setText("");
		getDownDoorCheckbox().setSelection(false);
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
		m_bindingContext.updateTargets();
		for (Map.Entry<ExitDirection, Exit> ex : parser.getArea().getRooms().get(key).exits.entrySet()) {
			int i = ex.getKey().num;
			switch (i) {
			case 0: //north
				getNorthDoorCheckbox().setSelection(false);
				getNorthDoorCheckbox().setSelection(true);
				getNorthDoorCheckbox().setSelection(false);
				getNorthDoorCheckbox().setSelection(true);
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
				getNorthDoorKeyCombo().setText(ex.getValue().keyVNum);
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
				getEastDoorCheckbox().setSelection(true);
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
				getEastDoorKeyCombo().setText(ex.getValue().keyVNum);
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
				getSouthDoorCheckbox().setSelection(true);
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
				getSouthDoorKeyCombo().setText(ex.getValue().keyVNum);
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
				getWestDoorCheckbox().setSelection(true);
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
				getWestDoorKeyCombo().setText(ex.getValue().keyVNum);
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
				getUpDoorCheckbox().setSelection(true);
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
				getUpDoorKeyCombo().setText(ex.getValue().keyVNum);
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
				getDownDoorCheckbox().setSelection(true);
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
				getDownDoorKeyCombo().setText(ex.getValue().keyVNum);
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
		m_bindingContext.updateTargets();
	}

	private void updateMobPanel(String key) {
		Mobile mob = new Mobile();
		for (Mobile m: parser.getArea().getMobiles()) {
			if (m.getvNum().equals(key)) {
				mob = m;
			}
		}
		String name = "";
		for (String s: mob.nameList) {
			name = name + " " + s;
		}
		name = name.stripLeading();
		getMobNameText().setText(name);
		getMobShortDescText().setText(mob.shortDescription);
		getMobLongDescText().setText(mob.longDescription);
		getMobLookDescText().setText(mob.lookDescription);
		getMobRaceCombo().select(mob.race.getRaceNumber());
		getMobSizeCombo().select(mob.size.num);
		getMobMaterialText().setText(mob.material);
		getMobStartPosCombo().select(mob.startPos.num);
		getMobDefaultPosCombo().select(mob.defaultPos.num);
		getMobSexCombo().select(mob.gender.num);
		
		getMobLvlSpinner().setSelection(mob.level);
		getMobTreasure().setSelection(mob.treasure);
		getMobGroup().setSelection(mob.mobileGroup);
		
		java.util.List<String> forms = new ArrayList<String>(Arrays.asList(mob.form.split("")));
		java.util.List<String> parts = new ArrayList<String>(Arrays.asList(mob.part.split("")));
		
		for (String s: forms) {
			getBtnAnimal().setSelection("G".equals(s));
			getBtnSentient().setSelection("H".equals(s));
			getBtnUndead().setSelection("I".equals(s));
			getBtnConstruct().setSelection("J".equals(s));
			getBtnMist().setSelection("K".equals(s));
			getBtnIntangible().setSelection("L".equals(s));
			getBtnBiped().setSelection("M".equals(s));
			getBtnCentaur().setSelection("N".equals(s));
			getBtnInsect().setSelection("O".equals(s));
			getBtnSpider().setSelection("P".equals(s));
			getBtnCrustacean().setSelection("Q".equals(s));
			getBtnWorm().setSelection("R".equals(s));
			getBtnBlob().setSelection("S".equals(s));
			getBtnMammal().setSelection("V".equals(s));
			getBtnBird().setSelection("W".equals(s));
			getBtnReptile().setSelection("X".equals(s));
			getBtnSnake().setSelection("Y".equals(s));
			getBtnDragon().setSelection("Z".equals(s));
			getBtnAmphibian().setSelection("a".equals(s));
			getBtnFish().setSelection("b".equals(s));
			getBtnColdBlood().setSelection("c".equals(s));
		}
		
		getMobPierceAC().setSelection(mob.armorClasses.get("pierce"));
		getMobBashAC().setSelection(mob.armorClasses.get("bash"));
		getMobSlashAC().setSelection(mob.armorClasses.get("slash"));
		getMobMagicAC().setSelection(mob.armorClasses.get("magic"));
		getMobDamageType().setText(mob.damageType);
		
		getMobHitDice1().setText(Integer.toString(mob.hitDice.diceNo));
		getMobHitDice2().setText(Integer.toString(mob.hitDice.diceFaces));
		getMobHitDice3().setText(Integer.toString(mob.hitDice.diceBonus));
		
		getMobDamageDice1().setText(Integer.toString(mob.damageDice.diceNo));
		getMobDamageDice2().setText(Integer.toString(mob.damageDice.diceFaces));
		getMobDamageDice3().setText(Integer.toString(mob.damageDice.diceBonus));
		
		getMobManaDice1().setText(Integer.toString(mob.manaDice.diceNo));
		getMobManaDice2().setText(Integer.toString(mob.manaDice.diceFaces));
		getMobManaDice3().setText(Integer.toString(mob.manaDice.diceBonus));
		
		getMobAlignmentSpinner().setSelection(mob.alignment);
		
		//act aff off
		getActFlagsText().setText(mob.action);
		getAffFlagsText().setText(mob.affect);
		getOffFlagsText().setText(mob.offensive);
		

		getSummonImm().setSelection(false);
		getCharmImm().setSelection(false);
		getMagicImm().setSelection(false);
		getWeaponsImm().setSelection(false);
		getBashImm().setSelection(false);
		getPierceImm().setSelection(false);
		getSlashImm().setSelection(false);
		getFireImm().setSelection(false);
		getColdImm().setSelection(false);
		getLightningImm().setSelection(false);
		getAcidImm().setSelection(false);
		getPoisonImm().setSelection(false);
		getNegativeImm().setSelection(false);
		getHolyImm().setSelection(false);
		getEnergyImm().setSelection(false);
		getMentalImm().setSelection(false);
		getDiseaseImm().setSelection(false);
		getDrowningImm().setSelection(false);
		getLightImm().setSelection(false);
		getSoundImm().setSelection(false);
		getWoodImm().setSelection(false);
		getSilverImm().setSelection(false);
		getIronImm().setSelection(false);
		getSummonRes().setSelection(false);
		getCharmRes().setSelection(false);
		getMagicRes().setSelection(false);
		getWeaponsRes().setSelection(false);
		getBashRes().setSelection(false);
		getPierceRes().setSelection(false);
		getSlashRes().setSelection(false);
		getFireRes().setSelection(false);
		getColdRes().setSelection(false);
		getLightningRes().setSelection(false);
		getAcidRes().setSelection(false);
		getPoisonRes().setSelection(false);
		getNegativeRes().setSelection(false);
		getHolyRes().setSelection(false);
		getEnergyRes().setSelection(false);
		getMentalRes().setSelection(false);
		getDiseaseRes().setSelection(false);
		getDrowningRes().setSelection(false);
		getLightRes().setSelection(false);
		getSoundRes().setSelection(false);
		getWoodRes().setSelection(false);
		getSilverRes().setSelection(false);
		getIronRes().setSelection(false);
		getSummonVuln().setSelection(false);
		getCharmVuln().setSelection(false);
		getMagicVuln().setSelection(false);
		getWeaponsVuln().setSelection(false);
		getBashVuln().setSelection(false);
		getPierceVuln().setSelection(false);
		getSlashVuln().setSelection(false);
		getFireVuln().setSelection(false);
		getColdVuln().setSelection(false);
		getLightningVuln().setSelection(false);
		getAcidVuln().setSelection(false);
		getPoisonVuln().setSelection(false);
		getNegativeVuln().setSelection(false);
		getHolyVuln().setSelection(false);
		getEnergyVuln().setSelection(false);
		getMentalVuln().setSelection(false);
		getDiseaseVuln().setSelection(false);
		getDrowningVuln().setSelection(false);
		getLightVuln().setSelection(false);
		getSoundVuln().setSelection(false);
		getWoodVuln().setSelection(false);
		getSilverVuln().setSelection(false);
		getIronVuln().setSelection(false);
		
		java.util.List<String> imms = new ArrayList<String>(Arrays.asList(mob.immunity.split("")));
		java.util.List<String> ress = new ArrayList<String>(Arrays.asList(mob.resistance.split("")));
		java.util.List<String> vuls = new ArrayList<String>(Arrays.asList(mob.vulnerability.split("")));
		
		
		for (String s: imms) {
			switch (s) {
			case "A": //summon
				getSummonImm().setSelection(true);
				break;
			case "B": //charm
				getCharmImm().setSelection(true);
				break;
			case "C": //magic
				getMagicImm().setSelection(true);
				break;
			case "D": //weapons
				getWeaponsImm().setSelection(true);
				break;
			case "E": //bash
				getBashImm().setSelection(true);
				break;
			case "F": //pierce
				getPierceImm().setSelection(true);
				break;
			case "G": //slash
				getSlashImm().setSelection(true);
				break;
			case "H": //fire
				getFireImm().setSelection(true);
				break;
			case "I": //cold
				getColdImm().setSelection(true);
				break;
			case "J": //lightning
				getLightningImm().setSelection(true);
				break;
			case "K": //acid
				getAcidImm().setSelection(true);
				break;
			case "L": //poison
				getPoisonImm().setSelection(true);
				break;
			case "M": //negative
				getNegativeImm().setSelection(true);
				break;
			case "N": //holy
				getHolyImm().setSelection(true);
				break;
			case "O": //energy
				getEnergyImm().setSelection(true);
				break;
			case "P": //mental
				getMentalImm().setSelection(true);
				break;
			case "Q": //disease
				getDiseaseImm().setSelection(true);
				break;
			case "R": //drowning
				getDrowningImm().setSelection(true);
				break;
			case "S": //light
				getLightImm().setSelection(true);
				break;
			case "T": //sound
				getSoundImm().setSelection(true);
				break;
			case "X": //wood
				getWoodImm().setSelection(true);
				break;
			case "Y": //silver
				getSilverImm().setSelection(true);
				break;
			case "Z": //iron"
				getIronImm().setSelection(true);
				break;
			}
		}
		
		for (String s: ress) {
			switch (s) {
			case "A": //summon
				getSummonRes().setSelection(true);
				break;
			case "B": //charm
				getCharmRes().setSelection(true);
				break;
			case "C": //magic
				getMagicRes().setSelection(true);
				break;
			case "D": //weapons
				getWeaponsRes().setSelection(true);
				break;
			case "E": //bash
				getBashRes().setSelection(true);
				break;
			case "F": //pierce
				getPierceRes().setSelection(true);
				break;
			case "G": //slash
				getSlashRes().setSelection(true);
				break;
			case "H": //fire
				getFireRes().setSelection(true);
				break;
			case "I": //cold
				getColdRes().setSelection(true);
				break;
			case "J": //lightning
				getLightningRes().setSelection(true);
				break;
			case "K": //acid
				getAcidRes().setSelection(true);
				break;
			case "L": //poison
				getPoisonRes().setSelection(true);
				break;
			case "M": //negative
				getNegativeRes().setSelection(true);
				break;
			case "N": //holy
				getHolyRes().setSelection(true);
				break;
			case "O": //energy
				getEnergyRes().setSelection(true);
				break;
			case "P": //mental
				getMentalRes().setSelection(true);
				break;
			case "Q": //disease
				getDiseaseRes().setSelection(true);
				break;
			case "R": //drowning
				getDrowningRes().setSelection(true);
				break;
			case "S": //light
				getLightRes().setSelection(true);
				break;
			case "T": //sound
				getSoundRes().setSelection(true);
				break;
			case "X": //wood
				getWoodRes().setSelection(true);
				break;
			case "Y": //silver
				getSilverRes().setSelection(true);
				break;
			case "Z": //iron"
				getIronRes().setSelection(true);
				break;
			}
		}
		
		for (String s: vuls) {
			switch (s) {
			case "A": //summon
				getSummonVuln().setSelection(true);
				break;
			case "B": //charm
				getCharmVuln().setSelection(true);
				break;
			case "C": //magic
				getMagicVuln().setSelection(true);
				break;
			case "D": //weapons
				getWeaponsVuln().setSelection(true);
				break;
			case "E": //bash
				getBashVuln().setSelection(true);
				break;
			case "F": //pierce
				getPierceVuln().setSelection(true);
				break;
			case "G": //slash
				getSlashVuln().setSelection(true);
				break;
			case "H": //fire
				getFireVuln().setSelection(true);
				break;
			case "I": //cold
				getColdVuln().setSelection(true);
				break;
			case "J": //lightning
				getLightningVuln().setSelection(true);
				break;
			case "K": //acid
				getAcidVuln().setSelection(true);
				break;
			case "L": //poison
				getPoisonVuln().setSelection(true);
				break;
			case "M": //negative
				getNegativeVuln().setSelection(true);
				break;
			case "N": //holy
				getHolyVuln().setSelection(true);
				break;
			case "O": //energy
				getEnergyVuln().setSelection(true);
				break;
			case "P": //mental
				getMentalVuln().setSelection(true);
				break;
			case "Q": //disease
				getDiseaseVuln().setSelection(true);
				break;
			case "R": //drowning
				getDrowningVuln().setSelection(true);
				break;
			case "S": //light
				getLightVuln().setSelection(true);
				break;
			case "T": //sound
				getSoundVuln().setSelection(true);
				break;
			case "X": //wood
				getWoodVuln().setSelection(true);
				break;
			case "Y": //silver
				getSilverVuln().setSelection(true);
				break;
			case "Z": //iron"
				getIronVuln().setSelection(true);
				break;
			}
		}
		
		getMobShopEnable().setSelection(false);
		Shop mobShop = new Shop();
		//shop stuff
		for (Shop j: parser.getArea().shops) {
			if (j.getMobileVNum().equals(key)) {
				mobShop = j;
				getMobShopEnable().setSelection(true);
			}
		}
		if (getMobShopEnable().getSelection()) {
			getMobShopOpenHour().setSelection(mobShop.getOpenHour());
			getMobShopCloseHour().setSelection(mobShop.getCloseHour());
			getMobShopItemTypeNo().setSelection(mobShop.getBuyItemTypes().size());
			if (!mobShop.getBuyItemTypes().isEmpty()) {
				for (int i = 0; i < mobShop.getBuyItemTypes().size(); i++) {
					if (i == 0) {
						getMobShopItemType1().select(Integer.valueOf(mobShop.getBuyItemTypes().get(i)));
					}
					else if (i == 1) {
						getMobShopItemType2().select(Integer.valueOf(mobShop.getBuyItemTypes().get(i)));
					}
					else if (i == 2) {
						getMobShopItemType3().select(Integer.valueOf(mobShop.getBuyItemTypes().get(i)));
					}
					else if (i == 3) {
						getMobShopItemType4().select(Integer.valueOf(mobShop.getBuyItemTypes().get(i)));
					}
					else if (i == 4) {
						getMobShopItemType5().select(Integer.valueOf(mobShop.getBuyItemTypes().get(i)));
					}
					else {
						System.out.println("item types too many");
					}
				} 
			}
			getMobShopProfitBuy().setSelection(mobShop.getBuyMultiplier());
			getMobShopProfitSell().setSelection(mobShop.getSellMultiplier());
		}
			
	}
	
	private void updateObjPanel(String key) {
		com.amve.area.Object obj = new com.amve.area.Object();
		for (com.amve.area.Object o: parser.getArea().getObjects()) {
			if (o.vNum.equals(key)) {
				obj = o;
			}
		}
		String name = "";
		for (String s: obj.nameList) {
			name = name + " " + s;
		}
		getObjName().setText(name);
		getObjShortDesc().setText(obj.shortDescription);
		getObjLongDesc().setText(obj.longDescription);
		
		for (ExtraDescription extra : obj.item.extraDescriptions) {
			TableItem extrasItem = new TableItem(objectExtrasTable, SWT.NONE);
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
		getObjMaterial().setText(obj.material);
		getObjLevel().setSelection(Integer.parseInt(obj.item.level));
		getObjWeight().setSelection(Integer.parseInt(obj.item.weight));
		getObjCost().setSelection(Integer.parseInt(obj.item.weight));
		getObjStatus().select(0);
		getObjType().select(0);
		//getMoneyTypeComp().exclude = true;
		GridData gd1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd1.exclude = true;
		/*
		getMoneyTypeComp().setLayoutData(gd1);
		getLightTypeComp().setLayoutData(gd1);
		getFoodTypeComp().setLayoutData(gd1);
		getMagicItemTypeComp().setLayoutData(gd1);
		getContainerTypeComp().setLayoutData(gd1);
		getWeaponTypeComp().setLayoutData(gd1);
		getDrinkTypeComp().setLayoutData(gd1);
		getArmorTypeComp().setLayoutData(gd1);
		getWandStaffTypeComp().setLayoutData(gd1);
		*/
		getMoneyTypeComp().getParent().layout(true, true);
		getLightTypeComp().getParent().layout(true, true);
		getFoodTypeComp().getParent().layout(true, true);
		getMagicItemTypeComp().getParent().layout(true, true);
		getContainerTypeComp().getParent().layout(true, true);
		getWeaponTypeComp().getParent().layout(true, true);
		getDrinkTypeComp().getParent().layout(true, true);
		getArmorTypeComp().getParent().layout(true, true);
		getWandStaffTypeComp().getParent().layout(true, true);
		GridData gd2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd2.exclude = false;
		switch (obj.item.itemType.name) {
		case "light":
			Item i = obj.item;
			Light l = (Light) i;
			getObjType().select(1);
			getLightTypeComp().setLayoutData(gd2);
			getLightLevel().setSelection(Integer.parseInt(obj.item.level));
			getLightDuration().setSelection((l.lightDuration));
			break;
		case "scroll":
			Item ii = obj.item;
			Scroll s = (Scroll) ii;
			getObjType().select(2);
			getMagicItemTypeComp().setLayoutData(gd2);
			getMagicItemLevel().setSelection(s.spellLevel);
			getMagicItemSpellCount().select(s.spellList.size());
			if (s.spellList.size() >= 1) {
				getMagicItemSpell1().setText(s.spellList.get(0));
			}
			if (s.spellList.size() >= 2) {
				getMagicItemSpell2().setText(s.spellList.get(1));
			}
			if (s.spellList.size() >= 3) {
				getMagicItemSpell3().setText(s.spellList.get(2));
			}
			if (s.spellList.size() >= 4) {
				getMagicItemSpell4().setText(s.spellList.get(3));
			}
			break;
		case "wand":
			Item iw = obj.item;
			Wand w = (Wand) iw;
			getObjType().select(3);
			getWandStaffTypeComp().setLayoutData(gd2);
			getWandStaffSpell().setText(w.spellName);
			getWandStaffSpellLevel().setSelection(w.spellLevel);
			getWandStaffMaxCharge().setSelection(w.maxCharges);
			getWandStaffCurrCharge().setSelection(w.curCharges);
			break;
		case "staff":
			Item is = obj.item;
			Staff st = (Staff) is;
			getObjType().select(4);
			getWandStaffTypeComp().setLayoutData(gd2);
			getWandStaffSpell().setText(st.spellName);
			getWandStaffSpellLevel().setSelection(st.spellLevel);
			getWandStaffMaxCharge().setSelection(st.maxCharges);
			getWandStaffCurrCharge().setSelection(st.curCharges);
			break;
		case "weapon":
			Item iww = obj.item;
			Weapon ww = (Weapon) iww;
			getObjType().select(5);
			getWeaponTypeComp().setLayoutData(gd2);
			getWeaponClass().setText(ww.weaponClass.name);
			getWeaponDmgType().setText(ww.damageMessage);
			getWeaponDiceNo().setSelection(ww.dice.diceNo);
			getWeaponDiceFaces().setSelection(ww.dice.diceFaces);
			break;
		case "armor":
			Item ia = obj.item;
			Armor aa = (Armor) ia;
			getObjType().setText("armor");
			getArmorTypeComp().setLayoutData(gd2);
			getArmorPierce().setText(aa.pierce);
			getArmorBash().setText(aa.bash);
			getArmorSlash().setText(aa.slash);
			getArmorMagic().setText("");
			getArmorBulk().setText(aa.bulk);
			break;
		case "potion":
			Item iii = obj.item;
			Potion p = (Potion) iii;
			getObjType().select(2);
			getMagicItemTypeComp().setLayoutData(gd2);
			getMagicItemLevel().setSelection(p.spellLevel);
			getMagicItemSpellCount().select(p.spellList.size());
			if (p.spellList.size() >= 1) {
				getMagicItemSpell1().setText(p.spellList.get(0));
			}
			if (p.spellList.size() >= 2) {
				getMagicItemSpell2().setText(p.spellList.get(1));
			}
			if (p.spellList.size() >= 3) {
				getMagicItemSpell3().setText(p.spellList.get(2));
			}
			if (p.spellList.size() >= 4) {
				getMagicItemSpell4().setText(p.spellList.get(3));
			}
			break;
		case "money":
			Item i_ = obj.item;
			Money mn = (Money) i_;
			getObjType().setText("money");
			getMoneyTypeComp().setLayoutData(gd2);
			getMoneyGoldVal().setSelection(mn.goldValue);
			getMoneySilverVal().setSelection(mn.silverValue);
			break;
		case "food":
			Item ii_ = obj.item;
			Food fd = (Food) ii_;
			getObjType().setText("food");
			getFoodTypeComp().setLayoutData(gd2);
			getFoodFull().setSelection(fd.hoursFull);
			getFoodNormal().setSelection(fd.hoursNormal);
			getFoodPoisoned().setSelection(fd.isPoisoned);
			break;
		case "drink":
			Item iii_ = obj.item;
			Drink dk = (Drink) iii_;
			getObjType().setText("drink");
			getDrinkTypeComp().setLayoutData(gd2);
			getDrinkContainerSize().setSelection(dk.containerSize);
			getDrinkCurrentAmount().setSelection(dk.currentAmount);
			getDrinkPoisoned().setSelection(dk.isPoisoned);
			break;
		case "container":
			Item i__ = obj.item;
			Container ct = (Container) i__;
			getObjType().setText("container");
			getContainerTypeComp().setLayoutData(gd2);
			getContainerMaxItemWeight().setSelection(ct.maxItemWeight);
			getContainerMaxTotalWeight().setSelection(ct.maxTotalWeight);
			getContainerWeightMult().setSelection(ct.weightMultiplier);
			break;
		default: 
			getObjType().setText(obj.item.itemType.name);
		}
		getBtnDark().setSelection(false);
		getBtnGlowing().setSelection(false);
		getBtnHumming().setSelection(false);
		getBtnLock().setSelection(false);
		getBtnEvil().setSelection(false);
		getBtnInvisible().setSelection(false);
		getBtnMagic().setSelection(false);
		getBtnNoDrop().setSelection(false);
		getBtnBless().setSelection(false);
		getBtnAntigood().setSelection(false);
		getBtnAntievil().setSelection(false);
		getBtnAntineutral().setSelection(false);
		getBtnNoRemove().setSelection(false);
		getBtnInventory().setSelection(false);
		getBtnNoPurge().setSelection(false);
		getBtnRotDeath().setSelection(false);
		getBtnVisDeeath().setSelection(false);
		getBtnNoSacrifice().setSelection(false);
		for (ItemExtra e: obj.item.extraFlags) {
			switch (e.name) {
			case "dark":
				getBtnDark().setSelection(true);
				break;
			case "glowing":
				getBtnGlowing().setSelection(true);
				break;
			case "humming":
				getBtnHumming().setSelection(true);
				break;
			case "lock":
				getBtnLock().setSelection(true);
				break;
			case "evil":
				getBtnEvil().setSelection(true);
				break;
			case "invisible":
				getBtnInvisible().setSelection(true);
				break;
			case "magic":
				getBtnMagic().setSelection(true);
				break;
			case "no drop":
				getBtnNoDrop().setSelection(true);
				break;
			case "bless":
				getBtnBless().setSelection(true);
				break;
			case "anti-good":
				getBtnAntigood().setSelection(true);
				break;
			case "anti-evil":
				getBtnAntievil().setSelection(true);
				break;
			case "anti-neutral":
				getBtnAntineutral().setSelection(true);
				break;
			case "no remove":
				getBtnNoRemove().setSelection(true);
				break;
			case "inventory":
				getBtnInventory().setSelection(true);
				break;
			case "no purge":
				getBtnNoPurge().setSelection(true);
				break;
			case "rot death":
				getBtnRotDeath().setSelection(true);
				break;
			case "vis death":
				getBtnVisDeeath().setSelection(true);
				break;
			case "no sacrifice":
				getBtnNoSacrifice().setSelection(true);
				break;
			}
		}
	}
	
	private void saveRoom(String key) {
		//parser.getArea().getRooms().get(key).setvNum(RoomVnumSpinner.setSelection(Integer.parseInt(key)));
		parser.getArea().getRooms().get(key);
		parser.getArea().getRooms().get(key).setHeader(getRoomNameText().getText()); 
		parser.getArea().getRooms().get(key).description = getRoomDescText().getText();
		//extras skip
		
		parser.getArea().getRooms().get(key).healingAdjust = Integer.toString(getRoomHPSpinner().getSelection());
		parser.getArea().getRooms().get(key).manaAdjust = Integer.toString(getRoomMPSpinner().getSelection());
		
			/*
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
			*/
		//this.roomFlags.add(RoomFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get(flags.substring(i, i+1))));
		if (getBtnRoomDark().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.DARK)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.DARK);
			}
		}
		if (getBtnRoomNoMob().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.NO_MOB)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.NO_MOB);
			}
		}
		if (getBtnRoomIndoors().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.INDOORS)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.INDOORS);
			}
		}
		if (getBtnRoomPrivate().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.PRIVATE)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.PRIVATE);
			}
		}
		if (getBtnRoomSafe().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.SAFE)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.SAFE);
			}
		}
		if (getBtnRoomSolitary().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.SOLITARY)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.SOLITARY);
			}
		}
		if (getBtnRoomPetShop().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.PET_SHOP)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.PET_SHOP);
			}
		}
		if (getBtnRoomNoRecall().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.NO_RECALL)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.NO_RECALL);
			}
		}
		if (getBtnRoomImpOnly().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.IMP_ONLY)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.IMP_ONLY);
			}
		}
		if (getBtnRoomGodsOnly().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.GODS_ONLY)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.GODS_ONLY);
			}
		}
		if (getBtnRoomHeroesOnly().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.HEROES_ONLY)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.HEROES_ONLY);
			}
		}
		if (getBtnRoomNewbiesOnly().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.NEWBIES_ONLY)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.NEWBIES_ONLY);
			}
		}
		if (getBtnRoomLaw().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.LAW)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.LAW);
			}
		}
		if (getBtnRoomNowhere().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.NOWHERE)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.NOWHERE);
			}
		}
		if (getBtnRoomBank().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.BANK)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.BANK);
			}
		}
		if (getBtnRoomNoMagic().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.NO_MAGIC)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.NO_MAGIC);
			}
		}
		if (getBtnRoomNoSummon().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.NOSUMMON)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.NOSUMMON);
			}
		}
		if (getBtnRoomRegistry().getSelection()) {
			if (!parser.getArea().getRooms().get(key).roomFlags.contains(RoomFlag.REGISTRY)) {
				parser.getArea().getRooms().get(key).roomFlags.add(RoomFlag.REGISTRY);
			}
		}
		/*
		 * getRoomSectorInside().setSelection(true);
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
		 */
		if (getRoomSectorInside().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.INSIDE;
		}
		if (getRoomSectorCity().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.CITY;
		}
		if (getRoomSectorField().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.FIELD;
		}
		if (getRoomSectorForest().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.FOREST;
		}
		if (getRoomSectorHill().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.HILL;
		}
		if (getRoomSectorMountain().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.MOUNTAIN;
		}
		if (getRoomSectorWater().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.WATER;
		}
		if (getRoomSectorDeepWater().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.DEEPWATER;
		}
		if (getRoomSectorUnused().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.UNUSED;
		}
		if (getRoomSectorAir().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.AIR;
		}
		if (getRoomSectorDesert().getSelection()) {
			parser.getArea().getRooms().get(key).roomSector = RoomSector.DESERT;
		}
		parser.getArea().getRooms().get(key).healingAdjust = Integer.toString(getRoomHPSpinner().getSelection());
		parser.getArea().getRooms().get(key).manaAdjust = Integer.toString(getRoomMPSpinner().getSelection());
		
		Map<ExitDirection, Exit> exits2 = new HashMap<>();
		for (Map.Entry<ExitDirection, Exit> ex : parser.getArea().getRooms().get(key).exits.entrySet()) {
			int i = ex.getKey().num;
			if (ex.getValue().doorFlags != null) {
				switch (i) {
				case 0:
					if (getNorthDoorCheckbox().getSelection()) {
						ex.getValue().exitDescription = getNorthDescText().getText();
						ex.getValue().keyWords.clear();
						ex.getValue().keyWords.add(getNorthDoorKeywordText().getText());
						ex.getValue().doorState = DoorState.valueOfNum(getNorthDoorStateCombo().getSelectionIndex());
						ex.getValue().keyVNum = getNorthDoorKeyCombo().getSelectionText();

						if (getNorthDoorFlagACheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (getNorthDoorFlagBCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (getNorthDoorFlagCCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (getNorthDoorFlagFCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (getNorthDoorFlagGCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (getNorthDoorFlagHCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (getNorthDoorFlagICheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (getNorthDoorFlagJCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (getNorthDoorFlagKCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (getNorthDoorFlagLCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}

						if (!getNorthDoorFlagACheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (!getNorthDoorFlagBCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (!getNorthDoorFlagCCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (!getNorthDoorFlagFCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (!getNorthDoorFlagGCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (!getNorthDoorFlagHCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (!getNorthDoorFlagICheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (!getNorthDoorFlagJCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (!getNorthDoorFlagKCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (!getNorthDoorFlagLCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}
					}
					break;
				case 1:
					if (getEastDoorCheckbox().getSelection()) {
						ex.getValue().exitDescription = getEastDescText().getText();
						ex.getValue().keyWords.clear();
						ex.getValue().keyWords.add(getEastDoorKeywordText().getText());
						ex.getValue().doorState = DoorState.valueOfNum(getEastDoorStateCombo().getSelectionIndex());
						ex.getValue().keyVNum = getEastDoorKeyCombo().getSelectionText();

						if (getEastDoorFlagACheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (getEastDoorFlagBCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (getEastDoorFlagCCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (getEastDoorFlagFCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (getEastDoorFlagGCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (getEastDoorFlagHCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (getEastDoorFlagICheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (getEastDoorFlagJCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (getEastDoorFlagKCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (getEastDoorFlagLCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}

						if (!getEastDoorFlagACheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (!getEastDoorFlagBCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (!getEastDoorFlagCCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (!getEastDoorFlagFCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (!getEastDoorFlagGCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (!getEastDoorFlagHCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (!getEastDoorFlagICheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (!getEastDoorFlagJCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (!getEastDoorFlagKCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (!getEastDoorFlagLCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}
					}
					break;
				case 2:
					if (getSouthDoorCheckbox().getSelection()) {
						ex.getValue().exitDescription = getSouthDescText().getText();
						ex.getValue().keyWords.clear();
						ex.getValue().keyWords.add(getSouthDoorKeywordText().getText());
						ex.getValue().doorState = DoorState.valueOfNum(getSouthDoorStateCombo().getSelectionIndex());
						ex.getValue().keyVNum = getSouthDoorKeyCombo().getSelectionText();

						if (getSouthDoorFlagACheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (getSouthDoorFlagBCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (getSouthDoorFlagCCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (getSouthDoorFlagFCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (getSouthDoorFlagGCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (getSouthDoorFlagHCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (getSouthDoorFlagICheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (getSouthDoorFlagJCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (getSouthDoorFlagKCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (getSouthDoorFlagLCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}

						if (!getSouthDoorFlagACheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (!getSouthDoorFlagBCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (!getSouthDoorFlagCCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (!getSouthDoorFlagFCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (!getSouthDoorFlagGCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (!getSouthDoorFlagHCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (!getSouthDoorFlagICheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (!getSouthDoorFlagJCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (!getSouthDoorFlagKCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (!getSouthDoorFlagLCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}
					}
					break;
				case 3:
					if (getWestDoorCheckbox().getSelection()) {
						ex.getValue().exitDescription = getWestDescText().getText();
						ex.getValue().keyWords.clear();
						ex.getValue().keyWords.add(getWestDoorKeywordText().getText());
						ex.getValue().doorState = DoorState.valueOfNum(getWestDoorStateCombo().getSelectionIndex());
						ex.getValue().keyVNum = getWestDoorKeyCombo().getSelectionText();

						if (getWestDoorFlagACheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (getWestDoorFlagBCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (getWestDoorFlagCCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (getWestDoorFlagFCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (getWestDoorFlagGCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (getWestDoorFlagHCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (getWestDoorFlagICheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (getWestDoorFlagJCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (getWestDoorFlagKCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (getWestDoorFlagLCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}

						if (!getWestDoorFlagACheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (!getWestDoorFlagBCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (!getWestDoorFlagCCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (!getWestDoorFlagFCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (!getWestDoorFlagGCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (!getWestDoorFlagHCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (!getWestDoorFlagICheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (!getWestDoorFlagJCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (!getWestDoorFlagKCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (!getWestDoorFlagLCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}
					}
					break;
				case 4:
					if (getUpDoorCheckbox().getSelection()) {
						ex.getValue().exitDescription = getUpDescText().getText();
						ex.getValue().keyWords.clear();
						ex.getValue().keyWords.add(getUpDoorKeywordText().getText());
						ex.getValue().doorState = DoorState.valueOfNum(getUpDoorStateCombo().getSelectionIndex());
						ex.getValue().keyVNum = getUpDoorKeyCombo().getSelectionText();

						if (getUpDoorFlagACheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (getUpDoorFlagBCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (getUpDoorFlagCCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (getUpDoorFlagFCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (getUpDoorFlagGCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (getUpDoorFlagHCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (getUpDoorFlagICheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (getUpDoorFlagJCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (getUpDoorFlagKCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (getUpDoorFlagLCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}

						if (!getUpDoorFlagACheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (!getUpDoorFlagBCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (!getUpDoorFlagCCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (!getUpDoorFlagFCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (!getUpDoorFlagGCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (!getUpDoorFlagHCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (!getUpDoorFlagICheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (!getUpDoorFlagJCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (!getUpDoorFlagKCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (!getUpDoorFlagLCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}
					}
					break;
				case 5:
					if (getDownDoorCheckbox().getSelection()) {
						ex.getValue().exitDescription = getDownDescText().getText();
						ex.getValue().keyWords.clear();
						ex.getValue().keyWords.add(getDownDoorKeywordText().getText());
						ex.getValue().doorState = DoorState.valueOfNum(getDownDoorStateCombo().getSelectionIndex());
						ex.getValue().keyVNum = getDownDoorKeyCombo().getSelectionText();

						if (getDownDoorFlagACheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (getDownDoorFlagBCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (getDownDoorFlagCCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (getDownDoorFlagFCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (getDownDoorFlagGCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (getDownDoorFlagHCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (getDownDoorFlagICheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (getDownDoorFlagJCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (getDownDoorFlagKCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (getDownDoorFlagLCheck().getSelection()) {
							if (!ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.add(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}

						if (!getDownDoorFlagACheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("A")));
							}
						}
						if (!getDownDoorFlagBCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("B")));
							}
						}
						if (!getDownDoorFlagCCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("C")));
							}
						}
						if (!getDownDoorFlagFCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("F")));
							}
						}
						if (!getDownDoorFlagGCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("G")));
							}
						}
						if (!getDownDoorFlagHCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("H")));
							}
						}
						if (!getDownDoorFlagICheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("I")));
							}
						}
						if (!getDownDoorFlagJCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("J")));
							}
						}
						if (!getDownDoorFlagKCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("K")));
							}
						}
						if (!getDownDoorFlagLCheck().getSelection()) {
							if (ex.getValue().doorFlags
									.contains(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")))) {
								ex.getValue().doorFlags
										.remove(DoorFlag.valueOfNum(GlobalVariables.LETTER_TRANSLATIONS.get("L")));
							}
						}
					}
					break;
				}
			}
			exits2.put(ex.getKey(), ex.getValue());
		}
		parser.getArea().getRooms().get(key).exits = exits2;
	}
	
	private void saveMob(String key) {
		for (Mobile m: parser.getArea().getMobiles()) {
			if (m.getvNum().equals(key)) {
				m.nameList.clear();
				m.nameList.add(getMobNameText().getText());
				
				m.shortDescription = getMobShortDescText().getText();
				m.longDescription = getMobLongDescText().getText();
				m.lookDescription = getMobLookDescText().getText();
				
				m.race.setRaceNumber(getMobRaceCombo().getSelectionIndex());
				m.size = GlobalVariables.Size.valueOfNum(getMobSizeCombo().getSelectionIndex());
				m.material = getMobMaterialText().getText();
				m.startPos = GlobalVariables.Position.valueOfNum(getMobStartPosCombo().getSelectionIndex());
				m.defaultPos = GlobalVariables.Position.valueOfNum(getMobDefaultPosCombo().getSelectionIndex());
				m.gender = GlobalVariables.Sex.valueOfNum(getMobSexCombo().getSelectionIndex());
				m.level = getMobLvlSpinner().getSelection();
				m.treasure = getMobTreasure().getSelection();
				m.mobileGroup = getMobGroup().getSelection();
				m.armorClasses.put("pierce", getMobPierceAC().getSelection());
				m.armorClasses.put("bash", getMobBashAC().getSelection());
				m.armorClasses.put("slash", getMobSlashAC().getSelection());
				m.armorClasses.put("magic", getMobMagicAC().getSelection());
				m.hitDice.diceNo = Integer.parseInt(getMobHitDice1().getText());
				m.hitDice.diceFaces = Integer.parseInt(getMobHitDice2().getText());
				m.hitDice.diceBonus = Integer.parseInt(getMobHitDice3().getText());
				m.manaDice.diceNo = Integer.parseInt(getMobManaDice1().getText());
				m.manaDice.diceFaces = Integer.parseInt(getMobManaDice2().getText());
				m.manaDice.diceBonus = Integer.parseInt(getMobManaDice3().getText());
				m.damageDice.diceNo = Integer.parseInt(getMobDamageDice1().getText());
				m.damageDice.diceFaces = Integer.parseInt(getMobDamageDice2().getText());
				m.damageDice.diceBonus = Integer.parseInt(getMobDamageDice3().getText());
				m.alignment = getMobAlignmentSpinner().getSelection();
				m.action = getActFlagsText().getText();
				m.affect = getAffFlagsText().getText();
				m.offensive = getOffFlagsText().getText();

				String imm = "";
				String res = "";
				String vul = "";

				if (getSummonImm().getSelection()) {
				imm += "A";
				}
			
				if (getCharmImm().getSelection()) {
				imm += "B";
				}
			
				if (getMagicImm().getSelection()) {
				imm += "C";
				}
			
				if (getWeaponsImm().getSelection()) {
				imm += "D";
				}
			
				if (getBashImm().getSelection()) {
				imm += "E";
				}
			
				if (getPierceImm().getSelection()) {
				imm += "F";
				}
			
				if (getSlashImm().getSelection()) {
				imm += "G";
				}
			
				if (getFireImm().getSelection()) {
				imm += "H";
				}
			
				if (getColdImm().getSelection()) {
				imm += "I";
				}
			
				if (getLightningImm().getSelection()) {
				imm += "J";
				}
			
				if (getAcidImm().getSelection()) {
				imm += "K";
				}
			
				if (getPoisonImm().getSelection()) {
				imm += "L";
				}
			
				if (getNegativeImm().getSelection()) {
				imm += "M";
				}
			
				if (getHolyImm().getSelection()) {
				imm += "N";
				}
			
				if (getEnergyImm().getSelection()) {
				imm += "O";
				}
			
				if (getMentalImm().getSelection()) {
				imm += "P";
				}
			
				if (getDiseaseImm().getSelection()) {
				imm += "Q";
				}
			
				if (getDrowningImm().getSelection()) {
				imm += "R";
				}
			
				if (getLightImm().getSelection()) {
				imm += "S";
				}
			
				if (getSoundImm().getSelection()) {
				imm += "T";
				}
			
				if (getWoodImm().getSelection()) {
				imm += "X";
				}
			
				if (getSilverImm().getSelection()) {
				imm += "Y";
				}
			
				if (getIronImm().getSelection()) {
				imm += "Z";
				}
				
				if (getSummonRes().getSelection()) {
					res += "A";
					}
				
					if (getCharmRes().getSelection()) {
					res += "B";
					}
				
					if (getMagicRes().getSelection()) {
					res += "C";
					}
				
					if (getWeaponsRes().getSelection()) {
					res += "D";
					}
				
					if (getBashRes().getSelection()) {
					res += "E";
					}
				
					if (getPierceRes().getSelection()) {
					res += "F";
					}
				
					if (getSlashRes().getSelection()) {
					res += "G";
					}
				
					if (getFireRes().getSelection()) {
					res += "H";
					}
				
					if (getColdRes().getSelection()) {
					res += "I";
					}
				
					if (getLightningRes().getSelection()) {
					res += "J";
					}
				
					if (getAcidRes().getSelection()) {
					res += "K";
					}
				
					if (getPoisonRes().getSelection()) {
					res += "L";
					}
				
					if (getNegativeRes().getSelection()) {
					res += "M";
					}
				
					if (getHolyRes().getSelection()) {
					res += "N";
					}
				
					if (getEnergyRes().getSelection()) {
					res += "O";
					}
				
					if (getMentalRes().getSelection()) {
					res += "P";
					}
				
					if (getDiseaseRes().getSelection()) {
					res += "Q";
					}
				
					if (getDrowningRes().getSelection()) {
					res += "R";
					}
				
					if (getLightRes().getSelection()) {
					res += "S";
					}
				
					if (getSoundRes().getSelection()) {
					res += "T";
					}
				
					if (getWoodRes().getSelection()) {
					res += "X";
					}
				
					if (getSilverRes().getSelection()) {
					res += "Y";
					}
				
					if (getIronRes().getSelection()) {
					res += "Z";
					}
				
					if (getSummonVuln().getSelection()) {
						vul += "A";
						}
					
						if (getCharmVuln().getSelection()) {
						vul += "B";
						}
					
						if (getMagicVuln().getSelection()) {
						vul += "C";
						}
					
						if (getWeaponsVuln().getSelection()) {
						vul += "D";
						}
					
						if (getBashVuln().getSelection()) {
						vul += "E";
						}
					
						if (getPierceVuln().getSelection()) {
						vul += "F";
						}
					
						if (getSlashVuln().getSelection()) {
						vul += "G";
						}
					
						if (getFireVuln().getSelection()) {
						vul += "H";
						}
					
						if (getColdVuln().getSelection()) {
						vul += "I";
						}
					
						if (getLightningVuln().getSelection()) {
						vul += "J";
						}
					
						if (getAcidVuln().getSelection()) {
						vul += "K";
						}
					
						if (getPoisonVuln().getSelection()) {
						vul += "L";
						}
					
						if (getNegativeVuln().getSelection()) {
						vul += "M";
						}
					
						if (getHolyVuln().getSelection()) {
						vul += "N";
						}
					
						if (getEnergyVuln().getSelection()) {
						vul += "O";
						}
					
						if (getMentalVuln().getSelection()) {
						vul += "P";
						}
					
						if (getDiseaseVuln().getSelection()) {
						vul += "Q";
						}
					
						if (getDrowningVuln().getSelection()) {
						vul += "R";
						}
					
						if (getLightVuln().getSelection()) {
						vul += "S";
						}
					
						if (getSoundVuln().getSelection()) {
						vul += "T";
						}
					
						if (getWoodVuln().getSelection()) {
						vul += "X";
						}
					
						if (getSilverVuln().getSelection()) {
						vul += "Y";
						}
					
						if (getIronVuln().getSelection()) {
						vul += "Z";
						}
				m.immunity = imm;
				m.vulnerability =vul;
				m.resistance = res;
			}
		}
	}

	private void saveObj(String key) {
		for (com.amve.area.Object o: parser.getArea().getObjects()) {
			if (o.vNum.equals(key)) {
				o.nameList.clear();
				o.nameList.add(getObjName().getText());
				o.shortDescription = getObjShortDesc().getText();
				o.longDescription = getObjLongDesc().getText();
				o.material = getObjMaterial().getText();
				o.item.level = Integer.toString(getObjLevel().getSelection());
				o.item.weight = Integer.toString(getObjWeight().getSelection());
				o.item.cost = Integer.toString(getObjCost().getSelection());
				switch (getObjType().getText()) {
				case "light":
					Item i = o.item;
					Light l = (Light) i;
					l.level = Integer.toString(getLightLevel().getSelection());
					l.lightDuration = getLightDuration().getSelection();
					o.item = l;
					break;
				case "scroll":
					Item ii = o.item;
					Scroll s = (Scroll) ii;
					s.spellLevel = getMagicItemLevel().getSelection();
					s.spellList.clear();
					if (getMagicItemSpellCount().getSelectionIndex() != 0) {
						if (getMagicItemSpellCount().getSelectionIndex() >= 1) {
							s.spellList.add(getMagicItemSpell1().getText());
						}
						if (getMagicItemSpellCount().getSelectionIndex() >= 2) {
							s.spellList.add(getMagicItemSpell2().getText());
						}
						if (getMagicItemSpellCount().getSelectionIndex() >= 3) {
							s.spellList.add(getMagicItemSpell3().getText());
						}
						if (getMagicItemSpellCount().getSelectionIndex() >= 4) {
							s.spellList.add(getMagicItemSpell4().getText());
						}
					}
					o.item = s;
					break;
				case "wand":
					Item iw = o.item;
					Wand w = (Wand) iw;
					w.spellName = getWandStaffSpell().getText();
					w.spellLevel = getWandStaffSpellLevel().getSelection();
					w.maxCharges = getWandStaffMaxCharge().getSelection();
					w.curCharges = getWandStaffCurrCharge().getSelection();
					o.item = w;
					break;
				case "staff":
					Item is = o.item;
					Staff st = (Staff) is;
					st.spellName = getWandStaffSpell().getText();
					st.spellLevel = getWandStaffSpellLevel().getSelection();
					st.maxCharges = getWandStaffMaxCharge().getSelection();
					st.curCharges = getWandStaffCurrCharge().getSelection();
					o.item = st;
					break;
				case "weapon":
					Item iww = o.item;
					Weapon ww = (Weapon) iww;
					ww.weaponClass = GlobalVariables.WeaponClass.valueOfName(getWeaponClass().getText());
					ww.damageMessage = getWeaponDmgType().getText();
					ww.dice.diceNo = getWeaponDiceNo().getSelection();
					ww.dice.diceFaces = getWeaponDiceFaces().getSelection();
					o.item = ww;
					break;
				case "armor":
					Item ia = o.item;
					Armor aa = (Armor) ia;
					aa.pierce = getArmorPierce().getText();
					aa.bash = getArmorBash().getText();
					aa.slash = getArmorSlash().getText();
					aa.bulk = getArmorBulk().getText();
					o.item = aa;
					break;
				case "potion":
					Item iii = o.item;
					Potion p = (Potion) iii;
					p.spellLevel = getMagicItemLevel().getSelection();
					p.spellList.clear();
					if (getMagicItemSpellCount().getSelectionIndex() != 0) {
						if (getMagicItemSpellCount().getSelectionIndex() >= 1) {
							p.spellList.add(getMagicItemSpell1().getText());
						}
						if (getMagicItemSpellCount().getSelectionIndex() >= 2) {
							p.spellList.add(getMagicItemSpell2().getText());
						}
						if (getMagicItemSpellCount().getSelectionIndex() >= 3) {
							p.spellList.add(getMagicItemSpell3().getText());
						}
						if (getMagicItemSpellCount().getSelectionIndex() >= 4) {
							p.spellList.add(getMagicItemSpell4().getText());
						}
					}
					o.item = p;
					break;
				case "money":
					Item i_ = o.item;
					Money mn = (Money) i_;
					mn.goldValue = getMoneyGoldVal().getSelection();
					mn.silverValue = getMoneySilverVal().getSelection();
					o.item = mn;
					break;
				case "food":
					Item ii_ = o.item;
					Food fd = (Food) ii_;
					fd.hoursFull = getFoodFull().getSelection();
					fd.hoursNormal= getFoodNormal().getSelection();
					fd.isPoisoned= getFoodPoisoned().getSelection();
					o.item = fd;
					break;
				case "drink":
					Item iii_ = o.item;
					Drink dk = (Drink) iii_;
					dk.containerSize = getDrinkContainerSize().getSelection();
					dk.currentAmount = getDrinkCurrentAmount().getSelection();
					dk.isPoisoned = getDrinkPoisoned().getSelection();
					o.item = dk;
					break;
				case "container":
					Item i__ = o.item;
					Container ct = (Container) i__;
					ct.maxItemWeight = getContainerMaxItemWeight().getSelection();
					ct.maxTotalWeight = getContainerMaxTotalWeight().getSelection();
					ct.weightMultiplier = getContainerWeightMult().getSelection();
					o.item = ct;
					break;
				}
				
			}
		}
		getMoneyTypeComp().getParent().layout(true, true);
		getLightTypeComp().getParent().layout(true, true);
		getFoodTypeComp().getParent().layout(true, true);
		getMagicItemTypeComp().getParent().layout(true, true);
		getContainerTypeComp().getParent().layout(true, true);
		getWeaponTypeComp().getParent().layout(true, true);
		getDrinkTypeComp().getParent().layout(true, true);
		getArmorTypeComp().getParent().layout(true, true);
		getWandStaffTypeComp().getParent().layout(true, true);
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
		
		Composite composite_18 = new Composite(composite, SWT.NONE);
		RowLayout rl_composite_18 = new RowLayout(SWT.HORIZONTAL);
		rl_composite_18.pack = false;
		composite_18.setLayout(rl_composite_18);
		composite_18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Button btnSave = new Button(composite_18, SWT.NONE);
		btnSave.addListener(SWT.Selection,  new Listener() {
			@Override
			public void handleEvent(Event e) {
				String tmp = tree.getSelection()[0].getText();
				if (getTabFolder1().getSelectionIndex() == 0) {
					tmp = tmp.replace("Room ", "");
					tmp = tmp.replaceAll("\\s.*", "");
					saveRoom(tmp);
				}
				else if (getTabFolder1().getSelectionIndex() == 1) {
					tmp = tmp.replace("Mobile ", "");
					tmp = tmp.replaceAll("\\s.*", "");
					saveMob(tmp);
				}
				else if (getTabFolder1().getSelectionIndex() == 2) {
					tmp = tmp.replace("Object ", "");
					tmp = tmp.replaceAll("\\s.*", "");
					saveObj(tmp);
				}
			}
		});
		btnSave.setText("Save");
		
		Button btnReload = new Button(composite_18, SWT.NONE);
		btnReload.setText("Reload");
	    parser.getArea().getRooms().forEach((key, value) -> {
	    	TreeItem roomItem = new TreeItem(tree,0);
	    	roomItem.setText("Room " + key + " - " + value.header);
	    	value.getMobileResets().forEach((k, v) -> {
	    		TreeItem mobItem = new TreeItem(roomItem,0);
	    		Mobile mob  = new Mobile();
	    		for (Mobile m: parser.getArea().getMobiles()) {
	    			if (m.getvNum().equals(k)) {
	    				mob = m;
	    			}
	    		}
	    		mobItem.setText("Mobile " + k + " - " + mob.shortDescription);
	    		for (MobileReset r: v) {
		    		if (r.equipResets != null) {	
	    				if (!r.equipResets.isEmpty()) {
		    				for (EquipReset er: r.equipResets) {
		    					com.amve.area.Object obj  = new com.amve.area.Object();
		    					TreeItem objItem = new TreeItem(mobItem,0);
		    					for (com.amve.area.Object o: parser.getArea().getObjects()) {
		    		    			if (o.vNum.equals(er.objectVNum)) {
		    		    				obj = o;
		    		    			}
		    		    		}
		    					objItem.setText("Object " + obj.vNum + " - " + obj.shortDescription);
		    				}
		    			}
		    		}
	    		}
	    	});
	    	value.getObjectResets().forEach((k, v) -> {
	    		TreeItem objItem = new TreeItem(roomItem,0);
	    		com.amve.area.Object obj  = new com.amve.area.Object();
	    		for (com.amve.area.Object o: parser.getArea().getObjects()) {
	    			if (o.vNum.equals(k)) {
	    				obj = o;
	    			}
	    		}
	    		objItem.setText("Object " + k + " - " + obj.shortDescription);
	    	});
	    });

	      tree.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event event) {
	          if (event.detail == SWT.CHECK) {
	            text.setText(event.item + " was checked.");
	          } 
	          else {
	            text.setText(event.item + " was selected");
	            String tmp = tree.getSelection()[0].getText();
	            if (tmp.startsWith("Room")) {
					tmp = tmp.replace("Room ", "");
					tmp = tmp.replaceAll("\\s.*", "");
					updateRoomPanel(tmp);
					getTabFolder1().setSelection(0);
				}
	            else if (tmp.startsWith("Mobile")) {
	            	tmp = tmp.replace("Mobile ", "");
					tmp = tmp.replaceAll("\\s.*", "");
					updateMobPanel(tmp);
					getTabFolder1().setSelection(1);
	            }
	            else if (tmp.startsWith("Object")) {
	            	tmp = tmp.replace("Object ", "");
					tmp = tmp.replaceAll("\\s.*", "");
					updateObjPanel(tmp);
					getTabFolder1().setSelection(2);
	            }
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
		
		tabFolder_1 = new TabFolder(tabFolder, SWT.NONE);
		tbtmObjectEditor.setControl(tabFolder_1);
		
		TabItem tbtmRoomEditor = new TabItem(tabFolder_1, SWT.NONE);
		tbtmRoomEditor.setText("Room Editor");
		
		ScrolledComposite scrolledComposite_3 = new ScrolledComposite(tabFolder_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmRoomEditor.setControl(scrolledComposite_3);
		scrolledComposite_3.setExpandHorizontal(true);
		scrolledComposite_3.setExpandVertical(true);
		
		Composite composite_15 = new Composite(scrolledComposite_3, SWT.NONE);
		composite_15.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(composite_15, SWT.NONE);
		
		Group grpRoomData = new Group(sashForm, SWT.NONE);
		grpRoomData.setText("Room Data");
		grpRoomData.setLayout(new GridLayout(1, false));
		
		Group grpVnum = new Group(grpRoomData, SWT.NONE);
		grpVnum.setLayout(new GridLayout(2, false));
		GridData gd_grpVnum = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpVnum.widthHint = 1;
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
		gd_grpDescription.widthHint = 250;
		gd_grpDescription.heightHint = 355;
		grpDescription.setLayoutData(gd_grpDescription);
		grpDescription.setText("Description");
		
		Label lblRoomName = new Label(grpDescription, SWT.NONE);
		lblRoomName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblRoomName.setText("Room Name");
		
		roomNameText = new Text(grpDescription, SWT.BORDER);
		roomNameText.setToolTipText("Room name (a few words)");
		GridData gd_roomNameText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_roomNameText.widthHint = 1;
		roomNameText.setLayoutData(gd_roomNameText);
		
		Label lblRoomDescription = new Label(grpDescription, SWT.NONE);
		lblRoomDescription.setText("Room Description");
		
		roomDescText = new Text(grpDescription, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		roomDescText.setToolTipText("Room description (a few lines)");
		GridData gd_roomDescText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_roomDescText.widthHint = 250;
		gd_roomDescText.heightHint = 68;
		roomDescText.setLayoutData(gd_roomDescText);
		
		Label lblDetailsAndExtras = new Label(grpDescription, SWT.NONE);
		lblDetailsAndExtras.setText("Details and Extras");
		
		roomExtrasTable = new Table(grpDescription, SWT.BORDER | SWT.FULL_SELECTION);
		roomExtrasTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		roomExtrasTable.setHeaderVisible(true);
		roomExtrasTable.setLinesVisible(true);
		makeLastColumnAutoExpand(roomExtrasTable, 200);
		
		TableColumn tblclmnKeywords = new TableColumn(roomExtrasTable, SWT.NONE);
		tblclmnKeywords.setWidth(150);
		tblclmnKeywords.setText("Keywords");
		
		TableColumn tblclmnDetails = new TableColumn(roomExtrasTable, SWT.NONE);
		Rectangle rect = roomExtrasTable.getClientArea();
		int extraspace = rect.width - 100;
		tblclmnDetails.setWidth(300);
		tblclmnDetails.setText("Details");
		
		Group grpRoomFlags = new Group(sashForm, SWT.NONE);
		grpRoomFlags.setText("Room Flags");
		grpRoomFlags.setLayout(new GridLayout(1, false));
		
		Group grpRoomFlagsInner = new Group(grpRoomFlags, SWT.NONE);
		RowLayout rl_grpRoomFlagsInner = new RowLayout(SWT.HORIZONTAL);
		rl_grpRoomFlagsInner.pack = false;
		grpRoomFlagsInner.setLayout(rl_grpRoomFlagsInner);
		GridData gd_grpRoomFlagsInner = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpRoomFlagsInner.widthHint = 1;
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
		gd_grpSectorType.widthHint = 1;
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
		GridData gd_grpRecoveryRates = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpRecoveryRates.widthHint = 1;
		grpRecoveryRates.setLayoutData(gd_grpRecoveryRates);
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
		
		northDoorCheckbox = new Button(northComposite, SWT.CHECK);
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
		
		northDoorKeyCombo = new Text(northComposite, SWT.BORDER);
		northDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		grpResets = new Group(northComposite, SWT.NONE);
		grpResets.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_grpResets = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpResets.widthHint = 200;
		grpResets.setLayoutData(gd_grpResets);
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
		
		eastDoorCheckbox = new Button(eastComposite, SWT.CHECK);
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
		
		eastDoorKeyCombo = new Text(eastComposite, SWT.BORDER);
		eastDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_1 = new Group(eastComposite, SWT.NONE);
		GridData gd_grpResets_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpResets_1.widthHint = 200;
		grpResets_1.setLayoutData(gd_grpResets_1);
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
		
		southDoorCheckbox = new Button(southComposite, SWT.CHECK);
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
		
		southDoorKeyCombo = new Text(southComposite, SWT.BORDER);
		southDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_2 = new Group(southComposite, SWT.NONE);
		GridData gd_grpResets_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpResets_2.widthHint = 200;
		grpResets_2.setLayoutData(gd_grpResets_2);
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
		
		westDoorCheckbox = new Button(westComposite, SWT.CHECK);
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
		
		westDoorKeyCombo = new Text(westComposite, SWT.BORDER);
		westDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_3 = new Group(westComposite, SWT.NONE);
		GridData gd_grpResets_3 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpResets_3.widthHint = 200;
		grpResets_3.setLayoutData(gd_grpResets_3);
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
		
		upDoorCheckbox = new Button(upComposite, SWT.CHECK);
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
		
		upDoorKeyCombo = new Text(upComposite, SWT.BORDER);
		upDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_4 = new Group(upComposite, SWT.NONE);
		GridData gd_grpResets_4 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpResets_4.widthHint = 200;
		grpResets_4.setLayoutData(gd_grpResets_4);
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
		
		downDoorCheckbox = new Button(downComposite, SWT.CHECK);
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
		
		downDoorKeyCombo = new Text(downComposite, SWT.BORDER);
		downDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpResets_5 = new Group(downComposite, SWT.NONE);
		GridData gd_grpResets_5 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grpResets_5.widthHint = 200;
		grpResets_5.setLayoutData(gd_grpResets_5);
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
		scrolledComposite_3.setContent(composite_15);
		scrolledComposite_3.setMinSize(composite_15.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		TabItem tbtmMobEditor = new TabItem(tabFolder_1, SWT.NONE);
		tbtmMobEditor.setText("Mob Editor");
		
		ScrolledComposite scrolledComposite_4 = new ScrolledComposite(tabFolder_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmMobEditor.setControl(scrolledComposite_4);
		scrolledComposite_4.setExpandHorizontal(true);
		scrolledComposite_4.setExpandVertical(true);
		
		Composite composite_16 = new Composite(scrolledComposite_4, SWT.NONE);
		composite_16.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		sashForm_1 = new SashForm(composite_16, SWT.NONE);
		
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
		GridData gd_mobNameText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_mobNameText.widthHint = 250;
		mobNameText.setLayoutData(gd_mobNameText);
		
		Label lblShortDescription = new Label(grpDescription_1, SWT.NONE);
		lblShortDescription.setText("Short Description");
		
		mobShortDescText = new Text(grpDescription_1, SWT.BORDER);
		GridData gd_mobShortDescText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_mobShortDescText.widthHint = 250;
		mobShortDescText.setLayoutData(gd_mobShortDescText);
		
		Label lblLongDescription = new Label(grpDescription_1, SWT.NONE);
		lblLongDescription.setText("Long Description");
		
		mobLongDescText = new Text(grpDescription_1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_mobLongDescText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_mobLongDescText.widthHint = 250;
		gd_mobLongDescText.heightHint = 61;
		mobLongDescText.setLayoutData(gd_mobLongDescText);
		
		Label lblLookDescription = new Label(grpDescription_1, SWT.NONE);
		lblLookDescription.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblLookDescription.setText("Look Description");
		
		mobLookDescText = new Text(grpDescription_1, SWT.BORDER | SWT.V_SCROLL);
		GridData gd_mobLookDescText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_mobLookDescText.widthHint = 250;
		gd_mobLookDescText.heightHint = 119;
		mobLookDescText.setLayoutData(gd_mobLookDescText);
		
		grpAppearance = new Group(grpVisual, SWT.NONE);
		GridData gd_grpAppearance = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpAppearance.widthHint = 250;
		grpAppearance.setLayoutData(gd_grpAppearance);
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
		
		mobRaceCombo = new Combo(grpAppearance, SWT.READ_ONLY);
		mobRaceCombo.setItems(new String[] {"unknown", "human", "elf", "half-elf", "dark-elf", "rockseer", "dwarf", "svirfnebli", "duergar", "arial", "gnome", "storm giant", "cloud giant", "fire giant", "frost giant", "felar", "githyanki", "satyr", "troll", "black dragon", "blue dragon", "green dragon", "red dragon", "white dragon", "brass dragon", "gold dragon", "silver dragon", "bronze dragon", "copper dragon", "bat", "bear", "cat", "centipede", "dog", "doll", "fido", "fox", "goblin", "hobgoblin", "kobold", "lizard", "modron", "orc", "pig", "rabbit", "school monster", "snake", "song bird", "water fowl", "wolf", "wyvern", "dragon", "giant", "golem", "undead", "drow", "draconian", "sprite", "aarakocra", "beholder", "tiger", "lion", "centaur", "death knight", "dracolich", "air elemental", "earth elemental", "fire elemental", "water elemental", "fish", "gargoyle", "ghost", "ghoul", "gnoll", "harpy", "lamia", "lich", "minotaur", "ogre", "zombie", "horse", "unique"});
		mobRaceCombo.setToolTipText("Race of the mobile");
		GridData gd_mobRaceCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_mobRaceCombo.widthHint = 130;
		mobRaceCombo.setLayoutData(gd_mobRaceCombo);
		
		mobSizeCombo = new Combo(grpAppearance, SWT.READ_ONLY);
		mobSizeCombo.setToolTipText("Size of the mobile");
		mobSizeCombo.setItems(new String[] {"Tiny", "Small", "Medium", "Large", "Huge", "Giant", "Gargantuan"});
		mobSizeCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		mobMaterialText = new Text(grpAppearance, SWT.BORDER);
		mobMaterialText.setToolTipText("The material of the mobile");
		GridData gd_mobMaterialText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_mobMaterialText.widthHint = 250;
		mobMaterialText.setLayoutData(gd_mobMaterialText);
		
		Label lblStartPos = new Label(grpAppearance, SWT.NONE);
		lblStartPos.setText("Start Pos.");
		
		Label lblDefaultPos = new Label(grpAppearance, SWT.NONE);
		lblDefaultPos.setText("Default Pos.");
		
		Label lblSex = new Label(grpAppearance, SWT.NONE);
		lblSex.setText("Sex");
		
		combo = new Combo(grpAppearance, SWT.READ_ONLY);
		combo.setItems(new String[] {"stand", "sit", "rest", "sleep"});
		combo.setToolTipText("Position the mobile will be loaded in");
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		combo_1 = new Combo(grpAppearance, SWT.READ_ONLY);
		combo_1.setItems(new String[] {"stand", "sit", "rest", "sleep"});
		combo_1.setToolTipText("Position the mobile will return after a fight. Cannot go back to sleep");
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		combo_2 = new Combo(grpAppearance, SWT.READ_ONLY);
		combo_2.setItems(new String[] {"none", "male", "female", "either"});
		combo_2.setToolTipText("Gender of the mobile");
		combo_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		grpFlags = new Group(grpVisual, SWT.NONE);
		GridData gd_grpFlags = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpFlags.exclude = true;
		grpFlags.setLayoutData(gd_grpFlags);
		grpFlags.setLayout(new GridLayout(1, false));
		grpFlags.setText("Flags");
		
		Group grpCorpseFlags = new Group(grpFlags, SWT.NONE);
		GridData gd_grpCorpseFlags = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpCorpseFlags.widthHint = 1;
		grpCorpseFlags.setLayoutData(gd_grpCorpseFlags);
		grpCorpseFlags.setText("Corpse Flags");
		RowLayout rl_grpCorpseFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpCorpseFlags.pack = false;
		grpCorpseFlags.setLayout(rl_grpCorpseFlags);
		
		btnEdible = new Button(grpCorpseFlags, SWT.CHECK);
		btnEdible.setToolTipText("Mobile can be eaten");
		btnEdible.setText("Edible");
		
		btnPoison = new Button(grpCorpseFlags, SWT.CHECK);
		btnPoison.setToolTipText("Mobile is poisonous when eaten (should also be edible)");
		btnPoison.setText("Poison");
		
		btnMagical = new Button(grpCorpseFlags, SWT.CHECK);
		btnMagical.setToolTipText("Mobile's magic nature causes strange effects when eaten");
		btnMagical.setText("Magical");
		
		btnVanishes = new Button(grpCorpseFlags, SWT.CHECK);
		btnVanishes.setToolTipText("Mobile vanishes after death (i.e. a wraith)");
		btnVanishes.setText("Vanishes");
		
		btnOther = new Button(grpCorpseFlags, SWT.CHECK);
		btnOther.setToolTipText("Mobile is not flesh and blood (defined by material type)");
		btnOther.setText("Other");
		
		Group grpFormFlags = new Group(grpFlags, SWT.NONE);
		GridData gd_grpFormFlags = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpFormFlags.widthHint = 1;
		grpFormFlags.setLayoutData(gd_grpFormFlags);
		RowLayout rl_grpFormFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpFormFlags.pack = false;
		grpFormFlags.setLayout(rl_grpFormFlags);
		grpFormFlags.setText("Form Flags");
		
		btnAnimal = new Button(grpFormFlags, SWT.CHECK);
		btnAnimal.setText("Animal");
		
		btnSentient = new Button(grpFormFlags, SWT.CHECK);
		btnSentient.setText("Sentient");
		
		btnUndead = new Button(grpFormFlags, SWT.CHECK);
		btnUndead.setText("Undead");
		
		btnConstruct = new Button(grpFormFlags, SWT.CHECK);
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
		gd_grpPartsFlags.widthHint = 1;
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
		GridData gd_grpCombatValues = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpCombatValues.minimumWidth = 250;
		gd_grpCombatValues.widthHint = 300;
		grpCombatValues.setLayoutData(gd_grpCombatValues);
		grpCombatValues.setText("Combat Values");
		
		Group grpCore = new Group(grpCombatValues, SWT.NONE);
		RowLayout rl_grpCore = new RowLayout(SWT.HORIZONTAL);
		rl_grpCore.justify = true;
		grpCore.setLayout(rl_grpCore);
		GridData gd_grpCore = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpCore.widthHint = 1;
		grpCore.setLayoutData(gd_grpCore);
		grpCore.setText("Core");
		
		Composite composite_5 = new Composite(grpCore, SWT.NONE);
		composite_5.setLayout(new GridLayout(2, false));
		
		Label lblLevel = new Label(composite_5, SWT.NONE);
		lblLevel.setText("Level");
		
		mobLvlSpinner = new Spinner(composite_5, SWT.BORDER);
		
		Composite composite_6 = new Composite(grpCore, SWT.NONE);
		composite_6.setLayout(new GridLayout(2, false));
		
		Label lblTreasure = new Label(composite_6, SWT.NONE);
		lblTreasure.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTreasure.setText("Treasure");
		
		mobTreasure = new Spinner(composite_6, SWT.BORDER);
		mobTreasure.setMaximum(9999);
		mobTreasure.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Composite composite_6_1 = new Composite(grpCore, SWT.NONE);
		composite_6_1.setLayout(new GridLayout(2, false));
		
		Label lblMobGrp = new Label(composite_6_1, SWT.NONE);
		lblMobGrp.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMobGrp.setText("Mob Group");
		
		mobGroup = new Spinner(composite_6_1, SWT.BORDER);
		mobGroup.setMaximum(9999);
		mobGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Group grpAcValues = new Group(grpCombatValues, SWT.NONE);
		GridData gd_grpAcValues = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpAcValues.widthHint = 1;
		grpAcValues.setLayoutData(gd_grpAcValues);
		grpAcValues.setText("AC Values/Damage");
		RowLayout rl_grpAcValues = new RowLayout(SWT.HORIZONTAL);
		rl_grpAcValues.justify = true;
		rl_grpAcValues.pack = false;
		rl_grpAcValues.spacing = 0;
		grpAcValues.setLayout(rl_grpAcValues);
		
		Composite composite_7 = new Composite(grpAcValues, SWT.NONE);
		composite_7.setLayout(new GridLayout(1, false));
		
		Label lblPierceAc = new Label(composite_7, SWT.NONE);
		lblPierceAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblPierceAc.setText("Pierce AC");
		
		mobPierceAC = new Spinner(composite_7, SWT.BORDER);
		mobPierceAC.setMaximum(9999);
		mobPierceAC.setMinimum(-9999);
		GridData gd_mobPierceAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobPierceAC.widthHint = 51;
		mobPierceAC.setLayoutData(gd_mobPierceAC);
		
		Composite composite_7_1 = new Composite(grpAcValues, SWT.NONE);
		composite_7_1.setLayout(new GridLayout(1, false));
		
		Label lblBashAc = new Label(composite_7_1, SWT.NONE);
		lblBashAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblBashAc.setText("Bash AC");
		
		mobBashAC = new Spinner(composite_7_1, SWT.BORDER);
		mobBashAC.setMaximum(9999);
		mobBashAC.setMinimum(-9999);
		GridData gd_mobBashAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobBashAC.widthHint = 51;
		mobBashAC.setLayoutData(gd_mobBashAC);
		
		Composite composite_7_2 = new Composite(grpAcValues, SWT.NONE);
		composite_7_2.setLayout(new GridLayout(1, false));
		
		Label lblSlashAc = new Label(composite_7_2, SWT.NONE);
		lblSlashAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblSlashAc.setText("Slash AC");
		
		mobSlashAC = new Spinner(composite_7_2, SWT.BORDER);
		mobSlashAC.setMaximum(9999);
		mobSlashAC.setMinimum(-9999);
		GridData gd_mobSlashAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobSlashAC.widthHint = 51;
		mobSlashAC.setLayoutData(gd_mobSlashAC);
		
		Composite composite_7_3 = new Composite(grpAcValues, SWT.NONE);
		composite_7_3.setLayout(new GridLayout(1, false));
		
		Label lblMagicAc = new Label(composite_7_3, SWT.NONE);
		lblMagicAc.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblMagicAc.setText("Magic AC");
		
		mobMagicAC = new Spinner(composite_7_3, SWT.BORDER);
		mobMagicAC.setMaximum(9999);
		mobMagicAC.setMinimum(-9999);
		GridData gd_mobMagicAC = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_mobMagicAC.widthHint = 51;
		mobMagicAC.setLayoutData(gd_mobMagicAC);
		
		Composite composite_7_4 = new Composite(grpAcValues, SWT.NONE);
		composite_7_4.setLayout(new GridLayout(1, false));
		
		Label lblDmgType = new Label(composite_7_4, SWT.NONE);
		lblDmgType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDmgType.setText("Dmg Type");
		
		mobDamageType = new Text(composite_7_4, SWT.BORDER);
		GridData gd_mobDamageType = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_mobDamageType.widthHint = 72;
		mobDamageType.setLayoutData(gd_mobDamageType);
		
		grpDice = new Group(grpCombatValues, SWT.NONE);
		grpDice.setLayout(new GridLayout(6, false));
		GridData gd_grpDice = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpDice.widthHint = 1;
		gd_grpDice.minimumWidth = 250;
		grpDice.setLayoutData(gd_grpDice);
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
		GridData gd_grpAlignment = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpAlignment.widthHint = 1;
		grpAlignment.setLayoutData(gd_grpAlignment);
		grpAlignment.setText("Alignment");
		
		scale_2 = new Scale(grpAlignment, SWT.NONE);
		scale_2.setPageIncrement(100);
		scale_2.setMaximum(2000);
		scale_2.setSelection(1000);
		scale_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		spinner_2 = new Spinner(grpAlignment, SWT.BORDER);
		spinner_2.setMaximum(1000);
		spinner_2.setMinimum(-1000);
		GridData gd_spinner_2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_spinner_2.widthHint = 60;
		spinner_2.setLayoutData(gd_spinner_2);
		int MobAlignValToSlider = 0;
		
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
		GridData gd_grpActFlags = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpActFlags.exclude = true;
		gd_grpActFlags.widthHint = 1;
		grpActFlags.setLayoutData(gd_grpActFlags);
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
		GridData gd_grpAffFlags = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpAffFlags.exclude = true;
		gd_grpAffFlags.widthHint = 1;
		grpAffFlags.setLayoutData(gd_grpAffFlags);
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
		GridData gd_grpOffFlags = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpOffFlags.exclude = true;
		gd_grpOffFlags.widthHint = 1;
		grpOffFlags.setLayoutData(gd_grpOffFlags);
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
		
		Composite composite_19 = new Composite(grpActAffOffFlags, SWT.NONE);
		composite_19.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_19.setLayout(new GridLayout(2, false));
		
		Label lblActionFlags = new Label(composite_19, SWT.NONE);
		lblActionFlags.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblActionFlags.setText("Action flags:");
		
		actFlagsText = new Text(composite_19, SWT.BORDER);
		actFlagsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAffectFlags = new Label(composite_19, SWT.NONE);
		lblAffectFlags.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAffectFlags.setText("Affect flags:");
		
		affFlagsText = new Text(composite_19, SWT.BORDER);
		affFlagsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOffensiveFlags = new Label(composite_19, SWT.NONE);
		lblOffensiveFlags.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOffensiveFlags.setText("Offensive flags:");
		
		offFlagsText = new Text(composite_19, SWT.BORDER);
		offFlagsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		grpImmresvuln = new Group(grpActAffOffFlags, SWT.NONE);
		GridData gd_grpImmresvuln = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpImmresvuln.widthHint = 1;
		grpImmresvuln.setLayoutData(gd_grpImmresvuln);
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
		
		summonVuln = new Button(grpImmresvuln, SWT.CHECK);
		summonVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblCharm = new Label(grpImmresvuln, SWT.NONE);
		lblCharm.setText("Charm");
		new Label(grpImmresvuln, SWT.NONE);
		
		charmImm = new Button(grpImmresvuln, SWT.CHECK);
		charmImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		charmRes = new Button(grpImmresvuln, SWT.CHECK);
		charmRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		charmVuln = new Button(grpImmresvuln, SWT.CHECK);
		charmVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblMagic = new Label(grpImmresvuln, SWT.NONE);
		lblMagic.setText("Magic");
		new Label(grpImmresvuln, SWT.NONE);
		
		magicImm = new Button(grpImmresvuln, SWT.CHECK);
		magicImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		magicRes = new Button(grpImmresvuln, SWT.CHECK);
		magicRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		magicVuln = new Button(grpImmresvuln, SWT.CHECK);
		magicVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblWeapons = new Label(grpImmresvuln, SWT.NONE);
		lblWeapons.setText("Weapons");
		new Label(grpImmresvuln, SWT.NONE);
		
		weaponsImm = new Button(grpImmresvuln, SWT.CHECK);
		weaponsImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		weaponsRes = new Button(grpImmresvuln, SWT.CHECK);
		weaponsRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		weaponsVuln = new Button(grpImmresvuln, SWT.CHECK);
		weaponsVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblBash = new Label(grpImmresvuln, SWT.NONE);
		lblBash.setText("Bash");
		new Label(grpImmresvuln, SWT.NONE);
		
		bashImm = new Button(grpImmresvuln, SWT.CHECK);
		bashImm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		bashRes = new Button(grpImmresvuln, SWT.CHECK);
		bashRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		bashVuln = new Button(grpImmresvuln, SWT.CHECK);
		bashVuln.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		lblPierce = new Label(grpImmresvuln, SWT.NONE);
		lblPierce.setText("Pierce");
		new Label(grpImmresvuln, SWT.NONE);
		
		pierceImm = new Button(grpImmresvuln, SWT.CHECK);
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
		GridData gd_grpShopkeeper = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpShopkeeper.widthHint = 1;
		grpShopkeeper.setLayoutData(gd_grpShopkeeper);
		grpShopkeeper.setText("Shopkeeper");
		grpShopkeeper.setLayout(new GridLayout(1, false));
		
		mobShopEnable = new Button(grpShopkeeper, SWT.CHECK);
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
		
		mobShopOpenHour = new Spinner(composite_8, SWT.BORDER);
		mobShopOpenHour.setMaximum(23);
		mobShopOpenHour.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label label_3 = new Label(composite_8, SWT.NONE);
		label_3.setText("  -  ");
		
		mobShopCloseHour = new Spinner(composite_8, SWT.BORDER);
		mobShopCloseHour.setMaximum(23);
		mobShopCloseHour.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Composite composite_9 = new Composite(grpShopkeeper, SWT.NONE);
		GridData gd_composite_9 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite_9.widthHint = 1;
		composite_9.setLayoutData(gd_composite_9);
		composite_9.setSize(345, 99);
		composite_9.setLayout(new GridLayout(2, true));
		
		Label lblProfitbuyingFromRate = new Label(composite_9, SWT.NONE);
		lblProfitbuyingFromRate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblProfitbuyingFromRate.setText("Profit-buying from rate");
		
		Label lblProfitsellingToRate = new Label(composite_9, SWT.NONE);
		lblProfitsellingToRate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblProfitsellingToRate.setText("Profit-selling to rate");
		
		scale = new Scale(composite_9, SWT.NONE);
		scale.setPageIncrement(25);
		scale.setMaximum(300);
		scale.setMinimum(100);
		scale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		scale_1 = new Scale(composite_9, SWT.NONE);
		scale_1.setSelection(100);
		scale_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		mobShopProfitBuy = new Spinner(composite_9, SWT.BORDER);
		mobShopProfitBuy.setMaximum(300);
		mobShopProfitBuy.setMinimum(100);
		mobShopProfitBuy.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		mobShopProfitSell = new Spinner(composite_9, SWT.BORDER);
		mobShopProfitSell.setSelection(100);
		mobShopProfitSell.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Composite composite_10 = new Composite(grpShopkeeper, SWT.NONE);
		composite_10.setLayout(new GridLayout(2, false));
		GridData gd_composite_10 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite_10.widthHint = 1;
		composite_10.setLayoutData(gd_composite_10);
		
		Label lblNoOfItem = new Label(composite_10, SWT.NONE);
		lblNoOfItem.setText("No. of item types to buy");
		
		mobShopItemTypeNo = new Spinner(composite_10, SWT.BORDER);
		mobShopItemTypeNo.setMaximum(5);
		
		Composite composite_11 = new Composite(grpShopkeeper, SWT.NONE);
		composite_11.setLayout(new GridLayout(2, false));
		GridData gd_composite_11 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite_11.widthHint = 1;
		composite_11.setLayoutData(gd_composite_11);
		
		Label lblItemType = new Label(composite_11, SWT.NONE);
		lblItemType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType.setText("Item type 1");
		
		mobShopItemType1 = new Combo(composite_11, SWT.READ_ONLY);
		mobShopItemType1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_5 = new Label(composite_11, SWT.NONE);
		lblItemType_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_5.setText("Item type 2");
		
		mobShopItemType2 = new Combo(composite_11, SWT.READ_ONLY);
		mobShopItemType2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_1 = new Label(composite_11, SWT.NONE);
		lblItemType_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_1.setText("Item type 3");
		
		mobShopItemType3 = new Combo(composite_11, SWT.READ_ONLY);
		mobShopItemType3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_2 = new Label(composite_11, SWT.NONE);
		lblItemType_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_2.setText("Item type 4");
		
		mobShopItemType4 = new Combo(composite_11, SWT.READ_ONLY);
		mobShopItemType4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblItemType_3 = new Label(composite_11, SWT.NONE);
		lblItemType_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblItemType_3.setText("Item type 5");
		
		mobShopItemType5 = new Combo(composite_11, SWT.READ_ONLY);
		mobShopItemType5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Group grpPracticer = new Group(grpShopspecial, SWT.NONE);
		RowLayout rl_grpPracticer = new RowLayout(SWT.HORIZONTAL);
		rl_grpPracticer.pack = false;
		grpPracticer.setLayout(rl_grpPracticer);
		GridData gd_grpPracticer = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpPracticer.exclude = true;
		gd_grpPracticer.widthHint = 1;
		grpPracticer.setLayoutData(gd_grpPracticer);
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
		GridData gd_grpProgsfuncs = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpProgsfuncs.widthHint = 1;
		grpProgsfuncs.setLayoutData(gd_grpProgsfuncs);
		grpProgsfuncs.setText("Progs/Funcs");
		
		Composite composite_12 = new Composite(grpProgsfuncs, SWT.NONE);
		GridLayout gl_composite_12 = new GridLayout(2, false);
		composite_12.setLayout(gl_composite_12);
		
		Label lblProg = new Label(composite_12, SWT.NONE);
		lblProg.setText("Prog");
		
		Label lblFunction = new Label(composite_12, SWT.NONE);
		lblFunction.setText("Function");
		
		Combo combo_3 = new Combo(composite_12, SWT.READ_ONLY);
		combo_3.setItems(new String[] {"fight_prog", "death_prog", "give_prog", "greet_prog", "speech_prog", "bribe_prog", "area_prog"});
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
		sashForm_1.setWeights(new int[] {1, 1, 1, 1});
		scrolledComposite_4.setContent(composite_16);
		scrolledComposite_4.setMinSize(new Point(1200, 800));
		
		TabItem tbtmObjectEditor_1 = new TabItem(tabFolder_1, SWT.NONE);
		tbtmObjectEditor_1.setText("Object Editor");
		
		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(tabFolder_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmObjectEditor_1.setControl(scrolledComposite_2);
		scrolledComposite_2.setExpandHorizontal(true);
		scrolledComposite_2.setExpandVertical(true);
		
		Composite composite_14 = new Composite(scrolledComposite_2, SWT.NONE);
		composite_14.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_2 = new SashForm(composite_14, SWT.SMOOTH);
		
		Group grpGeneralProperties = new Group(sashForm_2, SWT.NONE);
		grpGeneralProperties.setText("General Properties");
		grpGeneralProperties.setLayout(new GridLayout(1, false));
		
		Group grpDescription_2 = new Group(grpGeneralProperties, SWT.NONE);
		grpDescription_2.setLayout(new GridLayout(1, false));
		grpDescription_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpDescription_2.setText("Description");
		
		Label lblObjectName = new Label(grpDescription_2, SWT.NONE);
		lblObjectName.setText("Object Name");
		
		objName = new Text(grpDescription_2, SWT.BORDER);
		objName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblShortDescription_1 = new Label(grpDescription_2, SWT.NONE);
		lblShortDescription_1.setText("Short Description");
		
		objShortDesc = new Text(grpDescription_2, SWT.BORDER);
		objShortDesc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblLongDescription_1 = new Label(grpDescription_2, SWT.NONE);
		lblLongDescription_1.setText("Long Description");
		
		objLongDesc = new Text(grpDescription_2, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_objLongDesc = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_objLongDesc.heightHint = 72;
		objLongDesc.setLayoutData(gd_objLongDesc);
		
		Label lblExtras = new Label(grpDescription_2, SWT.NONE);
		lblExtras.setText("Extras");
		
		objectExtrasTable = new Table(grpDescription_2, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_objectExtrasTable = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_objectExtrasTable.heightHint = 100;
		objectExtrasTable.setLayoutData(gd_objectExtrasTable);
		objectExtrasTable.setHeaderVisible(true);
		objectExtrasTable.setLinesVisible(true);
		makeLastColumnAutoExpand(objectExtrasTable, 200);
		
		TableColumn tblclmnKeywords_1 = new TableColumn(objectExtrasTable, SWT.NONE);
		tblclmnKeywords_1.setWidth(100);
		tblclmnKeywords_1.setText("Keywords");
		
		TableColumn tblclmnDescription = new TableColumn(objectExtrasTable, SWT.NONE);
		tblclmnDescription.setWidth(100);
		tblclmnDescription.setText("Description");
		
		Group grpType = new Group(grpGeneralProperties, SWT.NONE);
		grpType.setLayout(new RowLayout(SWT.HORIZONTAL));
		grpType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpType.setText("Type");
		
		Composite composite_17 = new Composite(grpType, SWT.NONE);
		composite_17.setLayout(new GridLayout(1, false));
		
		Label lblMaterial_1 = new Label(composite_17, SWT.NONE);
		lblMaterial_1.setText("Material");
		
		objMaterial = new Text(composite_17, SWT.BORDER);
		objMaterial.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_17_1 = new Composite(grpType, SWT.NONE);
		composite_17_1.setLayout(new GridLayout(1, false));
		
		Label lbLevel = new Label(composite_17_1, SWT.NONE);
		lbLevel.setText("Level");
		
		objLevel = new Spinner(composite_17_1, SWT.BORDER);
		
		Composite composite_17_1_1 = new Composite(grpType, SWT.NONE);
		composite_17_1_1.setLayout(new GridLayout(1, false));
		
		Label lblWeight = new Label(composite_17_1_1, SWT.NONE);
		lblWeight.setText("Weight");
		
		objWeight = new Spinner(composite_17_1_1, SWT.BORDER);
		objWeight.setMaximum(9999);
		
		Composite composite_17_1_1_1 = new Composite(grpType, SWT.NONE);
		composite_17_1_1_1.setLayout(new GridLayout(1, false));
		
		Label lblCost = new Label(composite_17_1_1_1, SWT.NONE);
		lblCost.setText("Cost");
		
		objCost = new Spinner(composite_17_1_1_1, SWT.BORDER);
		objCost.setMaximum(9999);
		
		Composite composite_17_2 = new Composite(grpType, SWT.NONE);
		composite_17_2.setLayout(new GridLayout(1, false));
		
		Label lbStatus = new Label(composite_17_2, SWT.NONE);
		lbStatus.setText("Status");
		
		objStatus = new Combo(composite_17_2, SWT.READ_ONLY);
		objStatus.setItems(new String[] {"excellent", "good", "fine", "average", "poor", "fragile", "broken"});
		objStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_17_2_1 = new Composite(grpType, SWT.NONE);
		composite_17_2_1.setLayout(new GridLayout(1, false));
		
		Label lblType = new Label(composite_17_2_1, SWT.NONE);
		lblType.setText("Type");
		
		objType = new Combo(composite_17_2_1, SWT.READ_ONLY);
		objType.setItems(new String[] {"none", "light", "scroll", "wand", "staff", "weapon", "treasure", "armor", "potion", "clothing", "furniture", "trash", "container", "drink_con", "key", "food", "money", "boat", "corpse_npc", "corpse_pc", "fountain", "pill", "protect", "map", "portal", "warp_stone", "room_key", "gem", "jewelry", "jukebox", "tattoo"});
		objType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		grpTypeProperties = new Group(grpGeneralProperties, SWT.NONE);
		grpTypeProperties.setLayout(new GridLayout(1, false));
		grpTypeProperties.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpTypeProperties.setText("Type Properties");
		
		armorTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		armorTypeComp.setLayout(new GridLayout(6, false));
		//gd_armorTypeComp.exclude = true;
		armorTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblBash_2 = new Label(armorTypeComp, SWT.NONE);
		lblBash_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBash_2.setText("Pierce:");
		
		armorPierce = new Text(armorTypeComp, SWT.BORDER);
		armorPierce.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblBash_3 = new Label(armorTypeComp, SWT.NONE);
		lblBash_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBash_3.setText("Bash:");
		
		armorBash = new Text(armorTypeComp, SWT.BORDER);
		armorBash.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSlash_2 = new Label(armorTypeComp, SWT.NONE);
		lblSlash_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSlash_2.setText("Slash:");
		
		armorSlash = new Text(armorTypeComp, SWT.BORDER);
		armorSlash.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMagic_2 = new Label(armorTypeComp, SWT.NONE);
		lblMagic_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMagic_2.setText("Magic:");
		
		armorMagic = new Text(armorTypeComp, SWT.BORDER);
		armorMagic.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblBulk = new Label(armorTypeComp, SWT.NONE);
		lblBulk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBulk.setText("Bulk:");
		
		armorBulk = new Text(armorTypeComp, SWT.BORDER);
		armorBulk.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(armorTypeComp, SWT.NONE);
		new Label(armorTypeComp, SWT.NONE);
		
		wandStaffTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		GridLayout gl_wandStaffTypeComp = new GridLayout(4, false);
		wandStaffTypeComp.setLayout(gl_wandStaffTypeComp);
		wandStaffTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpell = new Label(wandStaffTypeComp, SWT.NONE);
		lblSpell.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpell.setText("Spell:");
		
		wandStaffSpell = new Text(wandStaffTypeComp, SWT.BORDER);
		wandStaffSpell.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpellLevel = new Label(wandStaffTypeComp, SWT.NONE);
		lblSpellLevel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpellLevel.setText("Spell level:");
		
		wandStaffSpellLevel = new Spinner(wandStaffTypeComp, SWT.BORDER);
		wandStaffSpellLevel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblMaxCharges = new Label(wandStaffTypeComp, SWT.NONE);
		lblMaxCharges.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMaxCharges.setText("Max. charges:");
		
		wandStaffMaxCharge = new Spinner(wandStaffTypeComp, SWT.BORDER);
		wandStaffMaxCharge.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblCurrentCharges = new Label(wandStaffTypeComp, SWT.NONE);
		lblCurrentCharges.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCurrentCharges.setText("Current charges:");
		
		wandStaffCurrCharge = new Spinner(wandStaffTypeComp, SWT.BORDER);
		wandStaffCurrCharge.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		magicItemTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		magicItemTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		magicItemTypeComp.setLayout(new GridLayout(6, false));
		
		Label lblPotionLevel = new Label(magicItemTypeComp, SWT.NONE);
		lblPotionLevel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPotionLevel.setText("Effect level:");
		
		magicItemLevel = new Spinner(magicItemTypeComp, SWT.BORDER);
		GridData gd_magicItemLevel = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_magicItemLevel.widthHint = 50;
		magicItemLevel.setLayoutData(gd_magicItemLevel);
		
		Label lblSpellNo = new Label(magicItemTypeComp, SWT.NONE);
		lblSpellNo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpellNo.setText("Spell no:");
		
		magicItemSpellCount = new Combo(magicItemTypeComp, SWT.READ_ONLY);
		GridData gd_magicItemSpellCount = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_magicItemSpellCount.widthHint = 50;
		magicItemSpellCount.setLayoutData(gd_magicItemSpellCount);
		magicItemSpellCount.setVisibleItemCount(5);
		magicItemSpellCount.setItems(new String[] {"0", "1", "2", "3", "4"});
		magicItemSpellCount.select(0);
		
		Label lblSpell_1 = new Label(magicItemTypeComp, SWT.NONE);
		lblSpell_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpell_1.setText("Spell 1:");
		
		magicItemSpell1 = new Text(magicItemTypeComp, SWT.BORDER);
		magicItemSpell1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpell_2 = new Label(magicItemTypeComp, SWT.NONE);
		lblSpell_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpell_2.setText("Spell 2:");
		
		magicItemSpell2 = new Text(magicItemTypeComp, SWT.BORDER);
		magicItemSpell2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpell_3 = new Label(magicItemTypeComp, SWT.NONE);
		lblSpell_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpell_3.setText("Spell 3:");
		
		magicItemSpell3 = new Text(magicItemTypeComp, SWT.BORDER);
		magicItemSpell3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpell_4 = new Label(magicItemTypeComp, SWT.NONE);
		lblSpell_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpell_4.setText("Spell 4:");
		
		magicItemSpell4 = new Text(magicItemTypeComp, SWT.BORDER);
		magicItemSpell4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		weaponTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		weaponTypeComp.setLayout(new GridLayout(4, false));
		weaponTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblWeaponClass = new Label(weaponTypeComp, SWT.NONE);
		lblWeaponClass.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWeaponClass.setText("Weapon class:");
		
		weaponClass = new Combo(weaponTypeComp, SWT.READ_ONLY);
		weaponClass.setItems(new String[] {"exotic", "sword", "dagger", "spear", "mace", "axe", "flail", "whip", "polearm", "bow", "arrow", "lance"});
		weaponClass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDamageType = new Label(weaponTypeComp, SWT.NONE);
		lblDamageType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDamageType.setText("Damage type:");
		
		weaponDmgType = new Text(weaponTypeComp, SWT.BORDER);
		weaponDmgType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDiceNo = new Label(weaponTypeComp, SWT.NONE);
		lblDiceNo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDiceNo.setText("Dice no:");
		
		weaponDiceNo = new Spinner(weaponTypeComp, SWT.BORDER);
		weaponDiceNo.setMaximum(1000);
		
		Label lblDiceFaces = new Label(weaponTypeComp, SWT.NONE);
		lblDiceFaces.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDiceFaces.setText("Dice faces:");
		
		weaponDiceFaces = new Spinner(weaponTypeComp, SWT.BORDER);
		weaponDiceFaces.setMaximum(1000);
		
		foodTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		foodTypeComp.setLayout(new GridLayout(6, false));
		foodTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblFullHours = new Label(foodTypeComp, SWT.NONE);
		lblFullHours.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFullHours.setText("Full hours:");
		
		foodFull = new Spinner(foodTypeComp, SWT.BORDER);
		
		Label lblNormalHours = new Label(foodTypeComp, SWT.NONE);
		lblNormalHours.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNormalHours.setText("Normal hours:");
		
		foodNormal = new Spinner(foodTypeComp, SWT.BORDER);
		
		Label lblPoisoned = new Label(foodTypeComp, SWT.NONE);
		lblPoisoned.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPoisoned.setText("Poisoned?");
		
		foodPoisoned = new Button(foodTypeComp, SWT.CHECK);
		
		lightTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		lightTypeComp.setLayout(new GridLayout(4, false));
		lightTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblItemLevel = new Label(lightTypeComp, SWT.NONE);
		lblItemLevel.setText("Item level:");
		
		lightLevel = new Spinner(lightTypeComp, SWT.BORDER);
		
		Label lblLightDuration = new Label(lightTypeComp, SWT.NONE);
		lblLightDuration.setText("Light duration:");
		
		lightDuration = new Spinner(lightTypeComp, SWT.BORDER);
		lightDuration.setMaximum(9999);
		lightDuration.setMinimum(-1);
		
		containerTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		containerTypeComp.setLayout(new GridLayout(6, false));
		containerTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMaxItemWeight = new Label(containerTypeComp, SWT.NONE);
		lblMaxItemWeight.setText("Max. item weight:");
		
		containerMaxItemWeight = new Spinner(containerTypeComp, SWT.BORDER);
		
		Label lblMaxTotalWeight = new Label(containerTypeComp, SWT.NONE);
		lblMaxTotalWeight.setText("Max. total weight:");
		
		containerMaxTotalWeight = new Spinner(containerTypeComp, SWT.BORDER);
		
		Label lblWeightMultiplier = new Label(containerTypeComp, SWT.NONE);
		lblWeightMultiplier.setText("Weight multiplier:");
		
		containerWeightMult = new Spinner(containerTypeComp, SWT.BORDER);
		containerWeightMult.setMaximum(200);
		
		moneyTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		moneyTypeComp.setLayout(new GridLayout(4, false));
		moneyTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblGoldValue = new Label(moneyTypeComp, SWT.NONE);
		lblGoldValue.setText("Gold value:");
		
		moneyGoldVal = new Spinner(moneyTypeComp, SWT.BORDER);
		moneyGoldVal.setMaximum(9999);
		
		Label lblSilverValue = new Label(moneyTypeComp, SWT.NONE);
		lblSilverValue.setText("Silver value:");
		
		moneySilverVal = new Spinner(moneyTypeComp, SWT.BORDER);
		moneySilverVal.setMaximum(9999);
		
		drinkTypeComp = new Composite(grpTypeProperties, SWT.NONE);
		drinkTypeComp.setLayout(new GridLayout(6, false));
		drinkTypeComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblContainerSize = new Label(drinkTypeComp, SWT.NONE);
		lblContainerSize.setText("Container size:");
		
		drinkContainerSize = new Spinner(drinkTypeComp, SWT.BORDER);
		
		Label lblCurrentAmount = new Label(drinkTypeComp, SWT.NONE);
		lblCurrentAmount.setText("Current amount:");
		
		drinkCurrentAmount = new Spinner(drinkTypeComp, SWT.BORDER);
		
		Label lblLiquidType = new Label(drinkTypeComp, SWT.NONE);
		lblLiquidType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLiquidType.setText("Liquid type:");
		
		drinkLiquidType = new Text(drinkTypeComp, SWT.BORDER);
		drinkLiquidType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		drinkPoisoned = new Button(drinkTypeComp, SWT.CHECK);
		drinkPoisoned.setText("Poisoned?");
		new Label(drinkTypeComp, SWT.NONE);
		new Label(drinkTypeComp, SWT.NONE);
		new Label(drinkTypeComp, SWT.NONE);
		new Label(drinkTypeComp, SWT.NONE);
		new Label(drinkTypeComp, SWT.NONE);
		
		Group grpFlags_1 = new Group(sashForm_2, SWT.NONE);
		grpFlags_1.setText("Flags");
		grpFlags_1.setLayout(new GridLayout(1, false));
		
		Group grpExtraFlags = new Group(grpFlags_1, SWT.NONE);
		grpExtraFlags.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpExtraFlags.setText("Extra Flags");
		RowLayout rl_grpExtraFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpExtraFlags.pack = false;
		grpExtraFlags.setLayout(rl_grpExtraFlags);
		
		btnGlowing = new Button(grpExtraFlags, SWT.CHECK);
		btnGlowing.setText("Glowing");
		
		btnHumming = new Button(grpExtraFlags, SWT.CHECK);
		btnHumming.setText("Humming");
		
		btnDark = new Button(grpExtraFlags, SWT.CHECK);
		btnDark.setText("Dark");
		
		btnLock = new Button(grpExtraFlags, SWT.CHECK);
		btnLock.setText("Lock");
		
		btnEvil = new Button(grpExtraFlags, SWT.CHECK);
		btnEvil.setText("Evil");
		
		btnInvisible_1 = new Button(grpExtraFlags, SWT.CHECK);
		btnInvisible_1.setText("Invisible");
		
		btnMagic = new Button(grpExtraFlags, SWT.CHECK);
		btnMagic.setText("Magic");
		
		btnNoDrop = new Button(grpExtraFlags, SWT.CHECK);
		btnNoDrop.setText("No drop");
		
		btnBless = new Button(grpExtraFlags, SWT.CHECK);
		btnBless.setText("Bless");
		
		btnAntigood = new Button(grpExtraFlags, SWT.CHECK);
		btnAntigood.setText("Anti-good");
		
		btnAntievil = new Button(grpExtraFlags, SWT.CHECK);
		btnAntievil.setText("Anti-evil");
		
		btnAntineutral = new Button(grpExtraFlags, SWT.CHECK);
		btnAntineutral.setText("Anti-neutral");
		
		btnNoRemove = new Button(grpExtraFlags, SWT.CHECK);
		btnNoRemove.setText("No remove");
		
		btnInventory = new Button(grpExtraFlags, SWT.CHECK);
		btnInventory.setText("Inventory");
		
		btnNoPurge_1 = new Button(grpExtraFlags, SWT.CHECK);
		btnNoPurge_1.setText("No purge");
		
		btnRotDeath = new Button(grpExtraFlags, SWT.CHECK);
		btnRotDeath.setText("Rot death");
		
		btnVisDeeath = new Button(grpExtraFlags, SWT.CHECK);
		btnVisDeeath.setText("Vis deeath");
		
		btnNoSacrifice = new Button(grpExtraFlags, SWT.CHECK);
		btnNoSacrifice.setText("No sacrifice");
		
		btnNonmetal = new Button(grpExtraFlags, SWT.CHECK);
		btnNonmetal.setText("Non-metal");
		
		btnNoLocate = new Button(grpExtraFlags, SWT.CHECK);
		btnNoLocate.setText("No locate");
		
		btnMeltDrop = new Button(grpExtraFlags, SWT.CHECK);
		btnMeltDrop.setText("Melt drop");
		
		btnHadTimer = new Button(grpExtraFlags, SWT.CHECK);
		btnHadTimer.setText("Had timer");
		
		btnSellExtract = new Button(grpExtraFlags, SWT.CHECK);
		btnSellExtract.setText("Sell extract");
		
		btnBurnproof = new Button(grpExtraFlags, SWT.CHECK);
		btnBurnproof.setText("Burn-proof");
		
		btnNoUncurse = new Button(grpExtraFlags, SWT.CHECK);
		btnNoUncurse.setText("No uncurse");
		
		btnNoSell = new Button(grpExtraFlags, SWT.CHECK);
		btnNoSell.setText("No sell");
		
		btnVisRot = new Button(grpExtraFlags, SWT.CHECK);
		btnVisRot.setText("Vis rot");
		
		Group grpWearFlags = new Group(grpFlags_1, SWT.NONE);
		grpWearFlags.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpWearFlags.setText("Wear Flags");
		RowLayout rl_grpWearFlags = new RowLayout(SWT.HORIZONTAL);
		rl_grpWearFlags.pack = false;
		grpWearFlags.setLayout(rl_grpWearFlags);
		
		btnTake = new Button(grpWearFlags, SWT.CHECK);
		btnTake.setText("Take");
		
		btnFinger = new Button(grpWearFlags, SWT.RADIO);
		btnFinger.setText("Finger");
		
		btnNeck = new Button(grpWearFlags, SWT.RADIO);
		btnNeck.setText("Neck");
		
		btnOnTorso = new Button(grpWearFlags, SWT.RADIO);
		btnOnTorso.setText("On torso");
		
		btnHead_1 = new Button(grpWearFlags, SWT.RADIO);
		btnHead_1.setText("Head");
		
		btnLegs_1 = new Button(grpWearFlags, SWT.RADIO);
		btnLegs_1.setText("Legs");
		
		btnFeet_1 = new Button(grpWearFlags, SWT.RADIO);
		btnFeet_1.setText("Feet");
		
		btnHands_1 = new Button(grpWearFlags, SWT.RADIO);
		btnHands_1.setText("Hands");
		
		btnArms_1 = new Button(grpWearFlags, SWT.RADIO);
		btnArms_1.setText("Arms");
		
		btnAsShield = new Button(grpWearFlags, SWT.RADIO);
		btnAsShield.setText("As shield");
		
		btnAboutBody = new Button(grpWearFlags, SWT.RADIO);
		btnAboutBody.setText("About body");
		
		btnWaist = new Button(grpWearFlags, SWT.RADIO);
		btnWaist.setText("Waist");
		
		btnLeftWrist = new Button(grpWearFlags, SWT.RADIO);
		btnLeftWrist.setText("Left wrist");
		
		btnWielded = new Button(grpWearFlags, SWT.RADIO);
		btnWielded.setText("Wielded");
		
		btnHeld = new Button(grpWearFlags, SWT.RADIO);
		btnHeld.setText("Held");
		
		btnNoSac = new Button(grpWearFlags, SWT.RADIO);
		btnNoSac.setText("No sac");
		
		btnFloatingNearby = new Button(grpWearFlags, SWT.RADIO);
		btnFloatingNearby.setText("Floating nearby");
		
		btnTattoo = new Button(grpWearFlags, SWT.RADIO);
		btnTattoo.setText("Tattoo");
		
		btnTwoHands = new Button(grpWearFlags, SWT.RADIO);
		btnTwoHands.setText("Two hands");
		
		Group grpImmresvuln_1 = new Group(grpFlags_1, SWT.NONE);
		GridData gd_grpImmresvuln_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpImmresvuln_1.exclude = true;
		grpImmresvuln_1.setLayoutData(gd_grpImmresvuln_1);
		grpImmresvuln_1.setText("Imm/Res/Vuln");
		grpImmresvuln_1.setLayout(new GridLayout(5, false));
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Label label_4 = new Label(grpImmresvuln_1, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblImmune_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblImmune_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblImmune_1.setText("Imm");
		
		Label lblResistant_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblResistant_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblResistant_1.setText("Res");
		
		Label lblVuln_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblVuln_1.setText("Vuln");
		
		Label lblSummon_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblSummon_1.setText("Summon");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button summonImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		summonImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button summonRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		summonRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button summonVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		summonVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblCharm_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblCharm_1.setText("Charm");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button charmImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		charmImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button charmRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		charmRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button charmVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		charmVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblMagic_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblMagic_1.setText("Magic");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button magicImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		magicImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button magicRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		magicRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button magicVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		magicVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblWeapons_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblWeapons_1.setText("Weapons");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button weaponsImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		weaponsImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button weaponsRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		weaponsRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button weaponsVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		weaponsVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblBash_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblBash_1.setText("Bash");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button bashImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		bashImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button bashRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		bashRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button bashVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		bashVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblPierce_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblPierce_1.setText("Pierce");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button pierceImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		pierceImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button pierceRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		pierceRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button pierceVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		pierceVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblSlash_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblSlash_1.setText("Slash");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button slashImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		slashImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button slashRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		slashRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button slashVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		slashVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblFire_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblFire_1.setText("Fire");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button fireImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		fireImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button fireRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		fireRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button fireVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		fireVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblCold_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblCold_1.setText("Cold");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button coldImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		coldImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button coldRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		coldRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button coldVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		coldVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblLightning_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblLightning_1.setText("Lightning");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button lightningImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		lightningImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button lightningRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		lightningRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button lightningVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		lightningVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblAcid_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblAcid_1.setText("Acid");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button acidImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		acidImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button acidRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		acidRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button acidVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		acidVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblPoison_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblPoison_1.setText("Poison");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button poisonImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		poisonImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button poisonRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		poisonRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button poisonVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		poisonVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblNegative_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblNegative_1.setText("Negative");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button negativeImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		negativeImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button negativeRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		negativeRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button negativeVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		negativeVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblHoly_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblHoly_1.setText("Holy");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button holyImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		holyImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button holyRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		holyRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button holyVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		holyVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblEnergy_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblEnergy_1.setText("Energy");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button energyImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		energyImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button energyRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		energyRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button energyVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		energyVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblMental_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblMental_1.setText("Mental");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button mentalImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		mentalImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button mentalRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		mentalRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button mentalVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		mentalVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblDisease_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblDisease_1.setText("Disease");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button diseaseImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		diseaseImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button diseaseRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		diseaseRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button diseaseVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		diseaseVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblDrowning_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblDrowning_1.setText("Drowning");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button drowningImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		drowningImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button drowningRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		drowningRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button drowningVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		drowningVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblLight_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblLight_1.setText("Light");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button lightImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		lightImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button lightRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		lightRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button lightVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		lightVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblSound_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblSound_1.setText("Sound");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button soundImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		soundImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button soundRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		soundRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button soundVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		soundVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblWood_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblWood_1.setText("Wood");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button woodImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		woodImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button woodRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		woodRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button woodVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		woodVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblSilver_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblSilver_1.setText("Silver");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button silverImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		silverImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button silverRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		silverRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button silverVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		silverVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label lblIron_1 = new Label(grpImmresvuln_1, SWT.NONE);
		lblIron_1.setText("Iron");
		new Label(grpImmresvuln_1, SWT.NONE);
		
		Button ironImm_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		ironImm_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button ironRes_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		ironRes_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Button ironVuln_1 = new Button(grpImmresvuln_1, SWT.CHECK);
		ironVuln_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Group grpAffectsSpecials = new Group(sashForm_2, SWT.NONE);
		grpAffectsSpecials.setText("Affects and Specials");
		grpAffectsSpecials.setLayout(new GridLayout(1, false));
		
		Group grpGeneralAffects = new Group(grpAffectsSpecials, SWT.NONE);
		RowLayout rl_grpGeneralAffects = new RowLayout(SWT.HORIZONTAL);
		rl_grpGeneralAffects.pack = false;
		grpGeneralAffects.setLayout(rl_grpGeneralAffects);
		GridData gd_grpGeneralAffects = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpGeneralAffects.exclude = true;
		grpGeneralAffects.setLayoutData(gd_grpGeneralAffects);
		grpGeneralAffects.setText("General Affects");
		
		Button btnBlind_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnBlind_1.setText("Blind");
		
		Button btnInvisible_2 = new Button(grpGeneralAffects, SWT.CHECK);
		btnInvisible_2.setText("Invisible");
		
		Button btnOnlyImp = new Button(grpGeneralAffects, SWT.CHECK);
		btnOnlyImp.setText("Only imp");
		
		Button btnFade_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnFade_1.setText("Fade");
		
		Button btnScream = new Button(grpGeneralAffects, SWT.CHECK);
		btnScream.setText("Scream");
		
		Button btnBloodthirst = new Button(grpGeneralAffects, SWT.CHECK);
		btnBloodthirst.setText("Bloodthirst");
		
		Button btnStun = new Button(grpGeneralAffects, SWT.CHECK);
		btnStun.setText("Stun");
		
		Button btnSanctuary_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnSanctuary_1.setText("Sanctuary");
		
		Button btnFaerieFire_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnFaerieFire_1.setText("Faerie fire");
		
		Button btnInfrared = new Button(grpGeneralAffects, SWT.CHECK);
		btnInfrared.setText("Infrared");
		
		Button btnCurse = new Button(grpGeneralAffects, SWT.CHECK);
		btnCurse.setText("Curse");
		
		Button btnCorruption = new Button(grpGeneralAffects, SWT.CHECK);
		btnCorruption.setText("Corruption");
		
		Button btnPoison_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnPoison_1.setText("Poison");
		
		Button btnProtectionEvil = new Button(grpGeneralAffects, SWT.CHECK);
		btnProtectionEvil.setText("Protection evil");
		
		Button btnProtectionGood = new Button(grpGeneralAffects, SWT.CHECK);
		btnProtectionGood.setText("Protection good");
		
		Button btnSneak = new Button(grpGeneralAffects, SWT.CHECK);
		btnSneak.setText("Sneak");
		
		Button btnHide = new Button(grpGeneralAffects, SWT.CHECK);
		btnHide.setText("Hide");
		
		Button btnSleep = new Button(grpGeneralAffects, SWT.CHECK);
		btnSleep.setText("Sleep");
		
		Button btnCharm = new Button(grpGeneralAffects, SWT.CHECK);
		btnCharm.setText("Charm");
		
		Button btnFlying_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnFlying_1.setText("Flying");
		
		Button btnPassDoor_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnPassDoor_1.setText("Pass door");
		
		Button btnHaste_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnHaste_1.setText("Haste");
		
		Button btnCalm = new Button(grpGeneralAffects, SWT.CHECK);
		btnCalm.setText("Calm");
		
		Button btnPlague = new Button(grpGeneralAffects, SWT.CHECK);
		btnPlague.setText("Plague");
		
		Button btnWeaken = new Button(grpGeneralAffects, SWT.CHECK);
		btnWeaken.setText("Weaken");
		
		Button btnWeakenStun = new Button(grpGeneralAffects, SWT.CHECK);
		btnWeakenStun.setText("Weaken stun");
		
		Button btnBerserk_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnBerserk_1.setText("Berserk");
		
		Button btnSwim = new Button(grpGeneralAffects, SWT.CHECK);
		btnSwim.setText("Swim");
		
		Button btnRegeneration_1 = new Button(grpGeneralAffects, SWT.CHECK);
		btnRegeneration_1.setText("Regeneration");
		
		Button btnSlow = new Button(grpGeneralAffects, SWT.CHECK);
		btnSlow.setText("Slow");
		
		Button btnCamouflage = new Button(grpGeneralAffects, SWT.CHECK);
		btnCamouflage.setText("Camouflage");
		
		Button btnFlaming = new Button(grpGeneralAffects, SWT.CHECK);
		btnFlaming.setText("Flaming");
		
		Button btnHold = new Button(grpGeneralAffects, SWT.CHECK);
		btnHold.setText("Hold");
		
		Button btnProtect = new Button(grpGeneralAffects, SWT.CHECK);
		btnProtect.setText("Protect");
		
		Button btnParalysis = new Button(grpGeneralAffects, SWT.CHECK);
		btnParalysis.setText("Paralysis");
		
		Group grpDetectionAffects = new Group(grpAffectsSpecials, SWT.NONE);
		GridData gd_grpDetectionAffects = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpDetectionAffects.exclude = true;
		grpDetectionAffects.setLayoutData(gd_grpDetectionAffects);
		grpDetectionAffects.setText("Detection Affects");
		RowLayout rl_grpDetectionAffects = new RowLayout(SWT.HORIZONTAL);
		rl_grpDetectionAffects.pack = false;
		grpDetectionAffects.setLayout(rl_grpDetectionAffects);
		
		Button btnDetectImpInvis = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectImpInvis.setText("Detect imp invis");
		
		Button btnDetectFade = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectFade.setText("Detect fade");
		
		Button btnDetectEvil_1 = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectEvil_1.setText("Detect evil");
		
		Button btnDetectInvis_1 = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectInvis_1.setText("Detect invis");
		
		Button btnDetectMagic_1 = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectMagic_1.setText("Detect magic");
		
		Button btnDetectHidden = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectHidden.setText("Detect hidden");
		
		Button btnDetectGood_1 = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectGood_1.setText("Detect good");
		
		Button btnDetectSneak = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectSneak.setText("Detect sneak");
		
		Button btnDetectUndead = new Button(grpDetectionAffects, SWT.CHECK);
		btnDetectUndead.setText("Detect undead");
		
		Button btnDarkVision_1 = new Button(grpDetectionAffects, SWT.CHECK);
		btnDarkVision_1.setText("Dark vision");
		
		Button btnAcuteVision = new Button(grpDetectionAffects, SWT.CHECK);
		btnAcuteVision.setText("Acute vision");
		
		Group grpLocalAffects = new Group(grpAffectsSpecials, SWT.NONE);
		grpLocalAffects.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpLocalAffects.setText("Local Affect Modifiers");
		grpLocalAffects.setLayout(new GridLayout(4, true));
		
		Label lblNone = new Label(grpLocalAffects, SWT.NONE);
		lblNone.setText("None:");
		
		noneModifTxt = new Text(grpLocalAffects, SWT.BORDER);
		noneModifTxt.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblStrength = new Label(grpLocalAffects, SWT.NONE);
		lblStrength.setText("Strength:");
		
		strModif = new Text(grpLocalAffects, SWT.BORDER);
		strModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblDexterity = new Label(grpLocalAffects, SWT.NONE);
		lblDexterity.setText("Dexterity:");
		
		dexModif = new Text(grpLocalAffects, SWT.BORDER);
		dexModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblIntelligence = new Label(grpLocalAffects, SWT.NONE);
		lblIntelligence.setText("Intelligence:");
		
		intModif = new Text(grpLocalAffects, SWT.BORDER);
		intModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblWisdom = new Label(grpLocalAffects, SWT.NONE);
		lblWisdom.setText("Wisdom:");
		
		wisModif = new Text(grpLocalAffects, SWT.BORDER);
		wisModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblConstitution = new Label(grpLocalAffects, SWT.NONE);
		lblConstitution.setText("Constitution:");
		
		conModif = new Text(grpLocalAffects, SWT.BORDER);
		conModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblCharisma = new Label(grpLocalAffects, SWT.NONE);
		lblCharisma.setText("Charisma:");
		
		chaModif = new Text(grpLocalAffects, SWT.BORDER);
		chaModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblClass = new Label(grpLocalAffects, SWT.NONE);
		lblClass.setText("Class:");
		
		classModif = new Text(grpLocalAffects, SWT.BORDER);
		classModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblLevel_1 = new Label(grpLocalAffects, SWT.NONE);
		lblLevel_1.setText("Level:");
		
		levelModif = new Text(grpLocalAffects, SWT.BORDER);
		levelModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblAge = new Label(grpLocalAffects, SWT.NONE);
		lblAge.setText("Age:");
		
		ageModif = new Text(grpLocalAffects, SWT.BORDER);
		ageModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblMana_1 = new Label(grpLocalAffects, SWT.NONE);
		lblMana_1.setText("Mana:");
		
		manaModif = new Text(grpLocalAffects, SWT.BORDER);
		manaModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblHitpoints = new Label(grpLocalAffects, SWT.NONE);
		lblHitpoints.setText("Hitpoints:");
		
		hpModif = new Text(grpLocalAffects, SWT.BORDER);
		hpModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblMovement = new Label(grpLocalAffects, SWT.NONE);
		lblMovement.setText("Movement:");
		
		moveModif = new Text(grpLocalAffects, SWT.BORDER);
		moveModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblArmorClass = new Label(grpLocalAffects, SWT.NONE);
		lblArmorClass.setText("Armor class:");
		
		armorModif = new Text(grpLocalAffects, SWT.BORDER);
		armorModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblExp = new Label(grpLocalAffects, SWT.NONE);
		lblExp.setText("Exp:");
		
		expModif = new Text(grpLocalAffects, SWT.BORDER);
		expModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblDamroll = new Label(grpLocalAffects, SWT.NONE);
		lblDamroll.setText("Damroll:");
		
		damrollModif = new Text(grpLocalAffects, SWT.BORDER);
		damrollModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblHitroll = new Label(grpLocalAffects, SWT.NONE);
		lblHitroll.setText("Hitroll:");
		
		hitrollModif = new Text(grpLocalAffects, SWT.BORDER);
		hitrollModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblSpellAffect = new Label(grpLocalAffects, SWT.NONE);
		lblSpellAffect.setText("Spell affect:");
		
		spellModif = new Text(grpLocalAffects, SWT.BORDER);
		spellModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblSaveVsSpell = new Label(grpLocalAffects, SWT.NONE);
		lblSaveVsSpell.setText("Save spell:");
		
		saveModif = new Text(grpLocalAffects, SWT.BORDER);
		saveModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblSex_1 = new Label(grpLocalAffects, SWT.NONE);
		lblSex_1.setText("Sex:");
		
		sexModif = new Text(grpLocalAffects, SWT.BORDER);
		sexModif.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Group grpSpecials = new Group(grpAffectsSpecials, SWT.NONE);
		grpSpecials.setLayout(new GridLayout(4, false));
		grpSpecials.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpSpecials.setText("Specials");
		
		Label lblProg_1 = new Label(grpSpecials, SWT.NONE);
		lblProg_1.setText("Prog:");
		
		objProg = new Combo(grpSpecials, SWT.READ_ONLY);
		objProg.setItems(new String[] {"fight_prog", "death_prog", "give_prog", "wear_prog", "remove_prog", "get_prog", "sac_prog"});
		
		Label lblFunction_1 = new Label(grpSpecials, SWT.NONE);
		lblFunction_1.setText("Function:");
		
		objFuncText = new Text(grpSpecials, SWT.BORDER);
		
		Label lblLimitations = new Label(grpSpecials, SWT.NONE);
		lblLimitations.setText("Limitations:");
		
		objLimit = new Combo(grpSpecials, SWT.READ_ONLY);
		objLimit.setItems(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
		objLimit.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(grpSpecials, SWT.NONE);
		new Label(grpSpecials, SWT.NONE);
		sashForm_2.setWeights(new int[] {1, 1, 1});
		scrolledComposite_2.setContent(composite_14);
		scrolledComposite_2.setMinSize(new Point(1200, 800));
		
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
		    	value.getMobileResets().forEach((k, v) -> {
		    		TreeItem mobItem = new TreeItem(roomItem,0);
		    		Mobile mob  = new Mobile();
		    		for (Mobile m: parser.getArea().getMobiles()) {
		    			if (m.getvNum().equals(k)) {
		    				mob = m;
		    			}
		    		}
		    		mobItem.setText("Mobile " + k + " - " + mob.shortDescription);
		    		for (MobileReset r: v) {
			    		if (r.equipResets != null) {	
		    				if (!r.equipResets.isEmpty()) {
			    				for (EquipReset er: r.equipResets) {
			    					com.amve.area.Object obj  = new com.amve.area.Object();
			    					TreeItem objItem = new TreeItem(mobItem,0);
			    					for (com.amve.area.Object o: parser.getArea().getObjects()) {
			    		    			if (o.vNum.equals(er.objectVNum)) {
			    		    				obj = o;
			    		    			}
			    		    		}
			    					objItem.setText("Object " + k + " - " + obj.shortDescription);
			    				}
			    			}
			    		}
		    		}
		    	});
		    	value.getObjectResets().forEach((k, v) -> {
		    		TreeItem objItem = new TreeItem(roomItem,0);
		    		com.amve.area.Object obj  = new com.amve.area.Object();
		    		for (com.amve.area.Object o: parser.getArea().getObjects()) {
		    			if (o.vNum.equals(k)) {
		    				obj = o;
		    			}
		    		}
		    		objItem.setText("Object " + k + " - " + obj.shortDescription);
		    	});
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
	public Text getNorthDoorKeyCombo() {
		return northDoorKeyCombo;
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
	public Text getEastDoorKeyCombo() {
		return eastDoorKeyCombo;
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
	public Text getSouthDoorKeyCombo() {
		return southDoorKeyCombo;
	}
	public Combo getSouthDoorStateCombo() {
		return southDoorStateCombo;
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
	public Text getWestDoorKeyCombo() {
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
	public Text getUpDoorKeyCombo() {
		return upDoorKeyCombo;
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
	public Text getDownDoorKeyCombo() {
		return downDoorKeyCombo;
	}
	public Combo getDownDoorStateCombo() {
		return downDoorStateCombo;
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
	public Table getRoomExtrasTable() {
		return roomExtrasTable;
	}
	
	public static void makeLastColumnAutoExpand(Table table, int minWidth) {
		   var resizer = new ControlAdapter() {
		      @Override
		      public void controlResized(ControlEvent event) {
		         var columns = table.getColumns();
		         if (columns.length == 0)
		            return;

		         if (columns.length == 1) {
		            columns[0].setWidth(Math.max(minWidth, table.getClientArea().width));
		            return;
		         }

		         var totalWidthOfOtherColumns = 0;
		         for (var i = 0; i < columns.length - 1; i++) {
		            totalWidthOfOtherColumns += columns[i].getWidth();
		         }

		         var newWidth = Math.max(minWidth, table.getClientArea().width - totalWidthOfOtherColumns);
		         columns[columns.length - 1].setWidth(newWidth);
		      }
		   };

		   table.addControlListener(resizer);
		   for (final var col : table.getColumns()) {
		      col.addControlListener(resizer);
		   }
		}
	public Button getNorthDoorCheckbox() {
		return northDoorCheckbox;
	}
	public Button getEastDoorCheckbox() {
		return eastDoorCheckbox;
	}
	public Button getSouthDoorCheckbox() {
		return southDoorCheckbox;
	}
	public Button getWestDoorCheckbox() {
		return westDoorCheckbox;
	}
	public Button getUpDoorCheckbox() {
		return upDoorCheckbox;
	}
	public Button getDownDoorCheckbox() {
		return downDoorCheckbox;
	}
	public Text getMobLongDescText() {
		return mobLongDescText;
	}
	public Text getMobNameText() {
		return mobNameText;
	}
	public Text getMobShortDescText() {
		return mobShortDescText;
	}
	public Text getMobMaterialText() {
		return mobMaterialText;
	}
	public Combo getMobSizeCombo() {
		return mobSizeCombo;
	}
	public Text getMobLookDescText() {
		return mobLookDescText;
	}
	public Combo getMobRaceCombo() {
		return mobRaceCombo;
	}
	public Combo getMobStartPosCombo() {
		return combo;
	}
	public Combo getMobDefaultPosCombo() {
		return combo_1;
	}
	public Combo getMobSexCombo() {
		return combo_2;
	}
	public Button getMobCorpsePoison() {
		return btnPoison;
	}
	public Button getMobCorpseVanishes() {
		return btnVanishes;
	}
	public Button getMobCorpseOther() {
		return btnOther;
	}
	public Button getMobCorpseMagical() {
		return btnMagical;
	}
	public Button getMobCorpseEdible() {
		return btnEdible;
	}
	public Button getBtnAnimal() {
		return btnAnimal;
	}
	public Button getBtnSentient() {
		return btnSentient;
	}
	public Button getBtnSpider() {
		return btnSpider;
	}
	public Button getBtnBlob() {
		return btnBlob;
	}
	public Button getBtnColdBlood() {
		return btnColdBlood;
	}
	public Button getBtnSnake() {
		return btnSnake;
	}
	public Button getBtnMammal() {
		return btnMammal;
	}
	public Button getBtnUndead() {
		return btnUndead;
	}
	public Button getBtnCrustacean() {
		return btnCrustacean;
	}
	public Button getBtnConstruct() {
		return btnConstruct;
	}
	public Button getBtnFish() {
		return btnFish;
	}
	public Button getBtnBird() {
		return btnBird;
	}
	public Button getBtnAmphibian() {
		return btnAmphibian;
	}
	public Button getBtnIntangible() {
		return btnIntangible;
	}
	public Button getBtnBiped() {
		return btnBiped;
	}
	public Button getBtnCentaur() {
		return btnCentaur;
	}
	public Button getBtnReptile() {
		return btnReptile;
	}
	public Button getBtnDragon() {
		return btnDragon;
	}
	public Button getBtnInsect() {
		return btnInsect;
	}
	public Button getBtnMist() {
		return btnMist;
	}
	public Button getBtnWorm() {
		return btnWorm;
	}
	public Button getMobPartsHead() {
		return btnHead;
	}
	public Button getMobPartsHorns() {
		return btnHorns;
	}
	public Button getMobPartsFeet() {
		return btnFeet;
	}
	public Button getMobPartsTail() {
		return btnTail;
	}
	public Button getMobPartsLegs() {
		return btnLegs;
	}
	public Button getMobPartsBrains() {
		return btnBrains;
	}
	public Button getMobPartsHeart() {
		return btnHeart;
	}
	public Button getMobPartsGuts() {
		return btnGuts;
	}
	public Button getMobPartsHands() {
		return btnHands;
	}
	public Button getMobPartsEye() {
		return btnEye;
	}
	public Button getMobPartsFins() {
		return btnFins;
	}
	public Button getMobPartsTusks() {
		return btnTusks;
	}
	public Button getMobPartsWings() {
		return btnWings;
	}
	public Button getMobPartsFingers() {
		return btnFingers;
	}
	public Button getMobPartsEar() {
		return btnEar;
	}
	public Button getMobPartsTongue() {
		return btnTongue;
	}
	public Button getMobPartsFangs() {
		return btnFangs;
	}
	public Button getMobPartsTentacles() {
		return btnTentacles;
	}
	public Button getMobPartsScales() {
		return btnScales;
	}
	public Button getMobPartsEyestalks() {
		return btnEyestalks;
	}
	public Button getMobPartsArms() {
		return btnArms;
	}
	public Button getMobPartsClaws() {
		return btnClaws;
	}
	public Spinner getMobBashAC() {
		return mobBashAC;
	}
	public Spinner getMobPierceAC() {
		return mobPierceAC;
	}
	public Spinner getMobSlashAC() {
		return mobSlashAC;
	}
	public Spinner getMobLvlSpinner() {
		return mobLvlSpinner;
	}
	public Spinner getMobTreasure() {
		return mobTreasure;
	}
	public Spinner getMobMagicAC() {
		return mobMagicAC;
	}
	public Spinner getMobGroup() {
		return mobGroup;
	}
	public Text getMobDamageType() {
		return mobDamageType;
	}
	public Text getMobHitDice1() {
		return mobHitDice1;
	}
	public Text getMobHitDice2() {
		return mobHitDice2;
	}
	public Text getMobHitDice3() {
		return mobHitDice3;
	}
	public Text getMobDamageDice3() {
		return mobDamageDice3;
	}
	public Text getMobDamageDice1() {
		return mobDamageDice1;
	}
	public Text getMobManaDice1() {
		return mobManaDice1;
	}
	public Text getMobManaDice3() {
		return mobManaDice3;
	}
	public Text getMobManaDice2() {
		return mobManaDice2;
	}
	public Text getMobDamageDice2() {
		return mobDamageDice2;
	}
	public Spinner getMobAlignmentSpinner() {
		return spinner_2;
	}
	public Button getLightningRes() {
		return lightningRes;
	}
	public Button getAcidRes() {
		return acidRes;
	}
	public Button getDrowningRes() {
		return drowningRes;
	}
	public Button getSoundRes() {
		return soundRes;
	}
	public Button getPoisonRes() {
		return poisonRes;
	}
	public Button getDiseaseRes() {
		return diseaseRes;
	}
	public Button getSlashVuln() {
		return slashVuln;
	}
	public Button getFireRes() {
		return fireRes;
	}
	public Button getIronVuln() {
		return ironVuln;
	}
	public Button getSummonVuln() {
		return summonVuln;
	}
	public Button getLightRes() {
		return lightRes;
	}
	public Button getMagicRes() {
		return magicRes;
	}
	public Button getHolyVuln() {
		return holyVuln;
	}
	public Button getDiseaseImm() {
		return diseaseImm;
	}
	public Button getAcidVuln() {
		return acidVuln;
	}
	public Button getWeaponsVuln() {
		return weaponsVuln;
	}
	public Button getIronRes() {
		return ironRes;
	}
	public Button getLightVuln() {
		return lightVuln;
	}
	public Button getSoundImm() {
		return soundImm;
	}
	public Button getCharmVuln() {
		return charmVuln;
	}
	public Button getSilverRes() {
		return silverRes;
	}
	public Button getWeaponsImm() {
		return weaponsImm;
	}
	public Button getEnergyVuln() {
		return energyVuln;
	}
	public Button getPierceVuln() {
		return pierceVuln;
	}
	public Button getDrowningVuln() {
		return drowningVuln;
	}
	public Button getBashRes() {
		return bashRes;
	}
	public Button getDiseaseVuln() {
		return diseaseVuln;
	}
	public Button getFireVuln() {
		return fireVuln;
	}
	public Button getColdRes() {
		return coldRes;
	}
	public Button getMagicImm() {
		return magicImm;
	}
	public Button getColdImm() {
		return coldImm;
	}
	public Button getSummonImm() {
		return summonImm;
	}
	public Button getSlashRes() {
		return slashRes;
	}
	public Button getSilverImm() {
		return silverImm;
	}
	public Button getLightningVuln() {
		return lightningVuln;
	}
	public Button getIronImm() {
		return ironImm;
	}
	public Button getEnergyRes() {
		return energyRes;
	}
	public Button getHolyRes() {
		return holyRes;
	}
	public Button getWoodRes() {
		return woodRes;
	}
	public Button getLightImm() {
		return lightImm;
	}
	public Button getMagicVuln() {
		return magicVuln;
	}
	public Button getHolyImm() {
		return holyImm;
	}
	public Button getNegativeVuln() {
		return negativeVuln;
	}
	public Button getSummonRes() {
		return summonRes;
	}
	public Button getBashVuln() {
		return bashVuln;
	}
	public Button getNegativeRes() {
		return negativeRes;
	}
	public Button getBashImm() {
		return bashImm;
	}
	public Button getWoodVuln() {
		return woodVuln;
	}
	public Button getMentalRes() {
		return mentalRes;
	}
	public Button getCharmImm() {
		return charmImm;
	}
	public Button getAcidImm() {
		return acidImm;
	}
	public Button getMentalVuln() {
		return mentalVuln;
	}
	public Button getSilverVuln() {
		return silverVuln;
	}
	public Button getPierceImm() {
		return pierceImm;
	}
	public Button getCharmRes() {
		return charmRes;
	}
	public Button getSlashImm() {
		return slashImm;
	}
	public Button getDrowningImm() {
		return drowningImm;
	}
	public Button getMentalImm() {
		return mentalImm;
	}
	public Button getPoisonVuln() {
		return poisonVuln;
	}
	public Button getWoodImm() {
		return woodImm;
	}
	public Button getColdVuln() {
		return coldVuln;
	}
	public Button getNegativeImm() {
		return negativeImm;
	}
	public Button getPierceRes() {
		return pierceRes;
	}
	public Button getPoisonImm() {
		return poisonImm;
	}
	public Button getEnergyImm() {
		return energyImm;
	}
	public Button getLightningImm() {
		return lightningImm;
	}
	public Button getFireImm() {
		return fireImm;
	}
	public Button getWeaponsRes() {
		return weaponsRes;
	}
	public Button getSoundVuln() {
		return soundVuln;
	}
	public Table getObjectExtrasTable() {
		return objectExtrasTable;
	}
	public Text getObjShortDesc() {
		return objShortDesc;
	}
	public Text getObjName() {
		return objName;
	}
	public Text getObjLongDesc() {
		return objLongDesc;
	}
	public Text getObjMaterial() {
		return objMaterial;
	}
	public Spinner getObjWeight() {
		return objWeight;
	}
	public Spinner getObjCost() {
		return objCost;
	}
	public Combo getObjStatus() {
		return objStatus;
	}
	public Spinner getObjLevel() {
		return objLevel;
	}
	public Button getOnTorso() {
		return btnOnTorso;
	}
	public Button getLegs() {
		return btnLegs_1;
	}
	public Button getTake() {
		return btnTake;
	}
	public Button getNoSac() {
		return btnNoSac;
	}
	public Button getTwoHands() {
		return btnTwoHands;
	}
	public Button getHead() {
		return btnHead_1;
	}
	public Button getNeck() {
		return btnNeck;
	}
	public Button getHeld() {
		return btnHeld;
	}
	public Button getWielded() {
		return btnWielded;
	}
	public Button getAsShield() {
		return btnAsShield;
	}
	public Button getWaist() {
		return btnWaist;
	}
	public Button getFinger() {
		return btnFinger;
	}
	public Button getArms() {
		return btnArms_1;
	}
	public Button getLeftWrist() {
		return btnLeftWrist;
	}
	public Button getHands() {
		return btnHands_1;
	}
	public Button getFeet() {
		return btnFeet_1;
	}
	public Button getAboutBody() {
		return btnAboutBody;
	}
	public Button getFloatingNearby() {
		return btnFloatingNearby;
	}
	public Button getTattoo() {
		return btnTattoo;
	}
	public Button getBtnDark() {
		return btnDark;
	}
	public Button getBtnBless() {
		return btnBless;
	}
	public Button getBtnNoLocate() {
		return btnNoLocate;
	}
	public Button getBtnGlowing() {
		return btnGlowing;
	}
	public Button getBtnBurnproof() {
		return btnBurnproof;
	}
	public Button getBtnHumming() {
		return btnHumming;
	}
	public Button getBtnInventory() {
		return btnInventory;
	}
	public Button getBtnNoSacrifice() {
		return btnNoSacrifice;
	}
	public Button getBtnHadTimer() {
		return btnHadTimer;
	}
	public Button getBtnSellExtract() {
		return btnSellExtract;
	}
	public Button getBtnMeltDrop() {
		return btnMeltDrop;
	}
	public Button getBtnAntievil() {
		return btnAntievil;
	}
	public Button getBtnVisRot() {
		return btnVisRot;
	}
	public Button getBtnNoRemove() {
		return btnNoRemove;
	}
	public Button getBtnAntineutral() {
		return btnAntineutral;
	}
	public Button getBtnRotDeath() {
		return btnRotDeath;
	}
	public Button getBtnEvil() {
		return btnEvil;
	}
	public Button getBtnMagic() {
		return btnMagic;
	}
	public Button getBtnNoSell() {
		return btnNoSell;
	}
	public Button getBtnAntigood() {
		return btnAntigood;
	}
	public Button getBtnVisDeeath() {
		return btnVisDeeath;
	}
	public Button getBtnInvisible() {
		return btnInvisible_1;
	}
	public Button getBtnNoDrop() {
		return btnNoDrop;
	}
	public Button getBtnNoPurge() {
		return btnNoPurge_1;
	}
	public Button getBtnNoUncurse() {
		return btnNoUncurse;
	}
	public Button getBtnNonmetal() {
		return btnNonmetal;
	}
	public Button getBtnLock() {
		return btnLock;
	}
	public Button getMobShopEnable() {
		return mobShopEnable;
	}
	public Spinner getMobShopCloseHour() {
		return mobShopCloseHour;
	}
	public Combo getMobShopItemType3() {
		return mobShopItemType3;
	}
	public Spinner getMobShopProfitBuy() {
		return mobShopProfitBuy;
	}
	public Spinner getMobShopOpenHour() {
		return mobShopOpenHour;
	}
	public Combo getMobShopItemType1() {
		return mobShopItemType1;
	}
	public Spinner getMobShopItemTypeNo() {
		return mobShopItemTypeNo;
	}
	public Combo getMobShopItemType2() {
		return mobShopItemType2;
	}
	public Spinner getMobShopProfitSell() {
		return mobShopProfitSell;
	}
	public Combo getMobShopItemType5() {
		return mobShopItemType5;
	}
	public Combo getMobShopItemType4() {
		return mobShopItemType4;
	}
	IConverter alignmentSpinnerToSlider = IConverter.create(Integer.class, Integer.class, (o1) -> ((Integer) o1+1000));
	IConverter alignmentSliderToSpinner = IConverter.create(Integer.class, Integer.class, (o1) -> ((Integer) o1-1000));
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
		IObservableValue observeEnabledNorthDescTextObserveWidget = WidgetProperties.enabled().observe(northDescText);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDescTextObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorKeywordTextObserveWidget = WidgetProperties.enabled().observe(northDoorKeywordText);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_1 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorKeywordTextObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorStateComboObserveWidget = WidgetProperties.enabled().observe(northDoorStateCombo);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_2 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorStateComboObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorKeyComboObserveWidget = WidgetProperties.enabled().observe(northDoorKeyCombo);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_3 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorKeyComboObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagACheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagACheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_5 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagACheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagBCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagBCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_6 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagBCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagCCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagCCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_7 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagCCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagFCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagFCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_8 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagFCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagGCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagGCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_9 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagGCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagHCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagHCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_10 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagHCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagICheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagICheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_11 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagICheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagJCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagJCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_12 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagJCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_12, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagKCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagKCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_13 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagKCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_13, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledNorthDoorFlagLCheckObserveWidget = WidgetProperties.enabled().observe(northDoorFlagLCheck);
		IObservableValue observeSelectionNorthDoorCheckboxObserveWidget_14 = WidgetProperties.selection().observe(northDoorCheckbox);
		bindingContext.bindValue(observeEnabledNorthDoorFlagLCheckObserveWidget, observeSelectionNorthDoorCheckboxObserveWidget_14, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDescTextObserveWidget = WidgetProperties.enabled().observe(eastDescText);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDescTextObserveWidget, observeSelectionEastDoorCheckboxObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorKeywordTextObserveWidget = WidgetProperties.enabled().observe(eastDoorKeywordText);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_1 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorKeywordTextObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorStateComboObserveWidget = WidgetProperties.enabled().observe(eastDoorStateCombo);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_2 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorStateComboObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorKeyComboObserveWidget = WidgetProperties.enabled().observe(eastDoorKeyCombo);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_3 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorKeyComboObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagACheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagACheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_5 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagACheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagBCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagBCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_6 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagBCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagCCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagCCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_7 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagCCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagFCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagFCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_8 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagFCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagGCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagGCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_9 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagGCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagHCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagHCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_10 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagHCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagICheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagICheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_11 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagICheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagJCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagJCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_12 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagJCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_12, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagKCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagKCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_13 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagKCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_13, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledEastDoorFlagLCheckObserveWidget = WidgetProperties.enabled().observe(eastDoorFlagLCheck);
		IObservableValue observeSelectionEastDoorCheckboxObserveWidget_14 = WidgetProperties.selection().observe(eastDoorCheckbox);
		bindingContext.bindValue(observeEnabledEastDoorFlagLCheckObserveWidget, observeSelectionEastDoorCheckboxObserveWidget_14, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDescTextObserveWidget = WidgetProperties.enabled().observe(southDescText);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDescTextObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorKeywordTextObserveWidget = WidgetProperties.enabled().observe(southDoorKeywordText);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_1 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorKeywordTextObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorStateComboObserveWidget = WidgetProperties.enabled().observe(southDoorStateCombo);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_2 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorStateComboObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorKeyComboObserveWidget = WidgetProperties.enabled().observe(southDoorKeyCombo);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_3 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorKeyComboObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagACheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagACheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_5 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagACheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagBCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagBCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_6 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagBCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagCCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagCCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_7 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagCCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagFCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagFCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_8 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagFCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagGCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagGCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_9 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagGCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagHCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagHCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_10 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagHCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagICheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagICheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_11 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagICheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagJCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagJCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_12 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagJCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_12, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagKCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagKCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_13 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagKCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_13, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledSouthDoorFlagLCheckObserveWidget = WidgetProperties.enabled().observe(southDoorFlagLCheck);
		IObservableValue observeSelectionSouthDoorCheckboxObserveWidget_14 = WidgetProperties.selection().observe(southDoorCheckbox);
		bindingContext.bindValue(observeEnabledSouthDoorFlagLCheckObserveWidget, observeSelectionSouthDoorCheckboxObserveWidget_14, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDescTextObserveWidget = WidgetProperties.enabled().observe(westDescText);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDescTextObserveWidget, observeSelectionWestDoorCheckboxObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorKeywordTextObserveWidget = WidgetProperties.enabled().observe(westDoorKeywordText);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_1 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorKeywordTextObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorStateComboObserveWidget = WidgetProperties.enabled().observe(westDoorStateCombo);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_2 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorStateComboObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorKeyComboObserveWidget = WidgetProperties.enabled().observe(westDoorKeyCombo);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_3 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorKeyComboObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagACheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagACheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_5 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagACheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagBCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagBCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_6 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagBCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagCCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagCCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_7 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagCCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagFCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagFCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_8 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagFCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagGCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagGCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_9 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagGCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagHCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagHCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_10 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagHCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagICheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagICheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_11 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagICheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagJCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagJCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_12 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagJCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_12, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagKCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagKCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_13 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagKCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_13, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledWestDoorFlagLCheckObserveWidget = WidgetProperties.enabled().observe(westDoorFlagLCheck);
		IObservableValue observeSelectionWestDoorCheckboxObserveWidget_14 = WidgetProperties.selection().observe(westDoorCheckbox);
		bindingContext.bindValue(observeEnabledWestDoorFlagLCheckObserveWidget, observeSelectionWestDoorCheckboxObserveWidget_14, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDescTextObserveWidget = WidgetProperties.enabled().observe(upDescText);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDescTextObserveWidget, observeSelectionUpDoorCheckboxObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorKeywordTextObserveWidget = WidgetProperties.enabled().observe(upDoorKeywordText);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_1 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorKeywordTextObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorStateComboObserveWidget = WidgetProperties.enabled().observe(upDoorStateCombo);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_2 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorStateComboObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorKeyComboObserveWidget = WidgetProperties.enabled().observe(upDoorKeyCombo);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_3 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorKeyComboObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagACheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagACheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_5 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagACheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagBCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagBCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_6 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagBCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagCCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagCCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_7 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagCCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagFCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagFCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_8 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagFCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagGCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagGCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_9 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagGCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagHCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagHCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_10 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagHCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagICheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagICheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_11 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagICheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagJCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagJCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_12 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagJCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_12, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagKCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagKCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_13 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagKCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_13, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledUpDoorFlagLCheckObserveWidget = WidgetProperties.enabled().observe(upDoorFlagLCheck);
		IObservableValue observeSelectionUpDoorCheckboxObserveWidget_14 = WidgetProperties.selection().observe(upDoorCheckbox);
		bindingContext.bindValue(observeEnabledUpDoorFlagLCheckObserveWidget, observeSelectionUpDoorCheckboxObserveWidget_14, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDescTextObserveWidget = WidgetProperties.enabled().observe(downDescText);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDescTextObserveWidget, observeSelectionDownDoorCheckboxObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorKeywordTextObserveWidget = WidgetProperties.enabled().observe(downDoorKeywordText);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_1 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorKeywordTextObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorStateComboObserveWidget = WidgetProperties.enabled().observe(downDoorStateCombo);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_2 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorStateComboObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorKeyComboObserveWidget = WidgetProperties.enabled().observe(downDoorKeyCombo);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_3 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorKeyComboObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagACheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagACheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_5 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagACheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagBCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagBCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_6 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagBCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagCCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagCCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_7 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagCCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagFCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagFCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_8 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagFCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagGCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagGCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_9 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagGCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagHCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagHCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_10 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagHCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagICheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagICheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_11 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagICheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagJCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagJCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_12 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagJCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_12, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagKCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagKCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_13 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagKCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_13, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledDownDoorFlagLCheckObserveWidget = WidgetProperties.enabled().observe(downDoorFlagLCheck);
		IObservableValue observeSelectionDownDoorCheckboxObserveWidget_14 = WidgetProperties.selection().observe(downDoorCheckbox);
		bindingContext.bindValue(observeEnabledDownDoorFlagLCheckObserveWidget, observeSelectionDownDoorCheckboxObserveWidget_14, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeSelectionScale_2ObserveWidget = WidgetProperties.selection().observe(scale_2);
		IObservableValue observeSelectionSpinner_2ObserveWidget = WidgetProperties.selection().observe(spinner_2);
		bindingContext.bindValue(observeSelectionScale_2ObserveWidget, observeSelectionSpinner_2ObserveWidget, UpdateValueStrategy.create(alignmentSliderToSpinner), UpdateValueStrategy.create(alignmentSpinnerToSlider));
		//
		IObservableValue observeEnabledMobShopOpenHourObserveWidget = WidgetProperties.enabled().observe(mobShopOpenHour);
		IObservableValue observeSelectionMobShopEnableObserveWidget = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopOpenHourObserveWidget, observeSelectionMobShopEnableObserveWidget, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopCloseHourObserveWidget = WidgetProperties.enabled().observe(mobShopCloseHour);
		IObservableValue observeSelectionMobShopEnableObserveWidget_1 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopCloseHourObserveWidget, observeSelectionMobShopEnableObserveWidget_1, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledScaleObserveWidget = WidgetProperties.enabled().observe(scale);
		IObservableValue observeSelectionMobShopEnableObserveWidget_2 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledScaleObserveWidget, observeSelectionMobShopEnableObserveWidget_2, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledScale_1ObserveWidget = WidgetProperties.enabled().observe(scale_1);
		IObservableValue observeSelectionMobShopEnableObserveWidget_3 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledScale_1ObserveWidget, observeSelectionMobShopEnableObserveWidget_3, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopProfitBuyObserveWidget = WidgetProperties.enabled().observe(mobShopProfitBuy);
		IObservableValue observeSelectionMobShopEnableObserveWidget_4 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopProfitBuyObserveWidget, observeSelectionMobShopEnableObserveWidget_4, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopProfitSellObserveWidget = WidgetProperties.enabled().observe(mobShopProfitSell);
		IObservableValue observeSelectionMobShopEnableObserveWidget_5 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopProfitSellObserveWidget, observeSelectionMobShopEnableObserveWidget_5, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopItemTypeNoObserveWidget = WidgetProperties.enabled().observe(mobShopItemTypeNo);
		IObservableValue observeSelectionMobShopEnableObserveWidget_6 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopItemTypeNoObserveWidget, observeSelectionMobShopEnableObserveWidget_6, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopItemType1ObserveWidget = WidgetProperties.enabled().observe(mobShopItemType1);
		IObservableValue observeSelectionMobShopEnableObserveWidget_7 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopItemType1ObserveWidget, observeSelectionMobShopEnableObserveWidget_7, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopItemType2ObserveWidget = WidgetProperties.enabled().observe(mobShopItemType2);
		IObservableValue observeSelectionMobShopEnableObserveWidget_8 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopItemType2ObserveWidget, observeSelectionMobShopEnableObserveWidget_8, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopItemType3ObserveWidget = WidgetProperties.enabled().observe(mobShopItemType3);
		IObservableValue observeSelectionMobShopEnableObserveWidget_9 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopItemType3ObserveWidget, observeSelectionMobShopEnableObserveWidget_9, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopItemType4ObserveWidget = WidgetProperties.enabled().observe(mobShopItemType4);
		IObservableValue observeSelectionMobShopEnableObserveWidget_10 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopItemType4ObserveWidget, observeSelectionMobShopEnableObserveWidget_10, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeEnabledMobShopItemType5ObserveWidget = WidgetProperties.enabled().observe(mobShopItemType5);
		IObservableValue observeSelectionMobShopEnableObserveWidget_11 = WidgetProperties.selection().observe(mobShopEnable);
		bindingContext.bindValue(observeEnabledMobShopItemType5ObserveWidget, observeSelectionMobShopEnableObserveWidget_11, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		//
		IObservableValue observeSelectionScaleObserveWidget = WidgetProperties.selection().observe(scale);
		IObservableValue observeSelectionMobShopProfitBuyObserveWidget = WidgetProperties.selection().observe(mobShopProfitBuy);
		bindingContext.bindValue(observeSelectionScaleObserveWidget, observeSelectionMobShopProfitBuyObserveWidget, null, null);
		//
		IObservableValue observeSelectionScale_1ObserveWidget = WidgetProperties.selection().observe(scale_1);
		IObservableValue observeSelectionMobShopProfitSellObserveWidget = WidgetProperties.selection().observe(mobShopProfitSell);
		bindingContext.bindValue(observeSelectionScale_1ObserveWidget, observeSelectionMobShopProfitSellObserveWidget, null, null);
		//
		return bindingContext;
	}
	public Text getOffFlagsText() {
		return offFlagsText;
	}
	public Text getAffFlagsText() {
		return affFlagsText;
	}
	public Text getActFlagsText() {
		return actFlagsText;
	}
	public TabFolder getTabFolder1() {
		return tabFolder_1;
	}
	public Group getGrpTypeProperties() {
		return grpTypeProperties;
	}
	public Composite getMoneyTypeComp() {
		return moneyTypeComp;
	}
	public Composite getLightTypeComp() {
		return lightTypeComp;
	}
	public Composite getFoodTypeComp() {
		return foodTypeComp;
	}
	public Composite getMagicItemTypeComp() {
		return magicItemTypeComp;
	}
	public Composite getContainerTypeComp() {
		return containerTypeComp;
	}
	public Composite getWeaponTypeComp() {
		return weaponTypeComp;
	}
	public Composite getDrinkTypeComp() {
		return drinkTypeComp;
	}
	public Composite getArmorTypeComp() {
		return armorTypeComp;
	}
	public Composite getWandStaffTypeComp() {
		return wandStaffTypeComp;
	}
	public Spinner getContainerMaxItemWeight() {
		return containerMaxItemWeight;
	}
	public Spinner getWeaponDiceNo() {
		return weaponDiceNo;
	}
	public Spinner getLightLevel() {
		return lightLevel;
	}
	public Text getDrinkLiquidType() {
		return drinkLiquidType;
	}
	public Text getWandStaffSpell() {
		return wandStaffSpell;
	}
	public Spinner getMoneySilverVal() {
		return moneySilverVal;
	}
	public Text getMagicItemSpell2() {
		return magicItemSpell2;
	}
	public Spinner getMagicItemLevel() {
		return magicItemLevel;
	}
	public Spinner getContainerWeightMult() {
		return containerWeightMult;
	}
	public Text getMagicItemSpell3() {
		return magicItemSpell3;
	}
	public Text getArmorSlash() {
		return armorSlash;
	}
	public Text getArmorMagic() {
		return armorMagic;
	}
	public Text getArmorPierce() {
		return armorPierce;
	}
	public Spinner getMoneyGoldVal() {
		return moneyGoldVal;
	}
	public Spinner getLightDuration() {
		return lightDuration;
	}
	public Spinner getWeaponDiceFaces() {
		return weaponDiceFaces;
	}
	public Spinner getFoodNormal() {
		return foodNormal;
	}
	public Spinner getWandStaffSpellLevel() {
		return wandStaffSpellLevel;
	}
	public Combo getMagicItemSpellCount() {
		return magicItemSpellCount;
	}
	public Spinner getDrinkCurrentAmount() {
		return drinkCurrentAmount;
	}
	public Text getMagicItemSpell1() {
		return magicItemSpell1;
	}
	public Button getDrinkPoisoned() {
		return drinkPoisoned;
	}
	public Combo getWeaponClass() {
		return weaponClass;
	}
	public Spinner getDrinkContainerSize() {
		return drinkContainerSize;
	}
	public Spinner getContainerMaxTotalWeight() {
		return containerMaxTotalWeight;
	}
	public Text getMagicItemSpell4() {
		return magicItemSpell4;
	}
	public Text getWeaponDmgType() {
		return weaponDmgType;
	}
	public Text getArmorBash() {
		return armorBash;
	}
	public Spinner getWandStaffMaxCharge() {
		return wandStaffMaxCharge;
	}
	public Spinner getFoodFull() {
		return foodFull;
	}
	public Text getArmorBulk() {
		return armorBulk;
	}
	public Button getFoodPoisoned() {
		return foodPoisoned;
	}
	public Spinner getWandStaffCurrCharge() {
		return wandStaffCurrCharge;
	}
	public Text getManaModif() {
		return manaModif;
	}
	public Text getWisModif() {
		return wisModif;
	}
	public Text getSexModif() {
		return sexModif;
	}
	public Text getLevelModif() {
		return levelModif;
	}
	public Text getExpModif() {
		return expModif;
	}
	public Text getConModif() {
		return conModif;
	}
	public Text getSaveModif() {
		return saveModif;
	}
	public Text getHpModif() {
		return hpModif;
	}
	public Text getObjFuncText() {
		return objFuncText;
	}
	public Text getArmorModif() {
		return armorModif;
	}
	public Text getStrModif() {
		return strModif;
	}
	public Text getIntModif() {
		return intModif;
	}
	public Text getClassModif() {
		return classModif;
	}
	public Text getAgeModif() {
		return ageModif;
	}
	public Combo getObjProg() {
		return objProg;
	}
	public Text getDexModif() {
		return dexModif;
	}
	public Text getNoneModifTxt() {
		return noneModifTxt;
	}
	public Text getDamrollModif() {
		return damrollModif;
	}
	public Text getSpellModif() {
		return spellModif;
	}
	public Text getHitrollModif() {
		return hitrollModif;
	}
	public Combo getObjLimit() {
		return objLimit;
	}
	public Text getChaModif() {
		return chaModif;
	}
	public Text getMoveModif() {
		return moveModif;
	}
	public Combo getObjType() {
		return objType;
	}
}

