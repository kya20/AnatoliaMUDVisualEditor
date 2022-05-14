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
import com.amve.parser.AreaFileParser;
import com.amve.utils.MobileReset;
import com.amve.utils.ObjectReset;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
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

public class VisualEditor {

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

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			VisualEditor window = new VisualEditor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1366, 768);
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
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnKeywords = tableViewerColumn.getColumn();
		tblclmnKeywords.setWidth(100);
		tblclmnKeywords.setText("keywords");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn_1.getColumn();
		tblclmnDescription.setWidth(223);
		tblclmnDescription.setText("Description");
		
		Group grpRoomFlags = new Group(sashForm, SWT.NONE);
		grpRoomFlags.setText("Room Flags");
		grpRoomFlags.setLayout(new GridLayout(1, false));
		
		Group grpFlags = new Group(grpRoomFlags, SWT.NONE);
		GridData gd_grpFlags = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpFlags.heightHint = 157;
		grpFlags.setLayoutData(gd_grpFlags);
		grpFlags.setText("Flags");
		
		Group grpSectorType = new Group(grpRoomFlags, SWT.NONE);
		GridData gd_grpSectorType = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_grpSectorType.heightHint = 106;
		grpSectorType.setLayoutData(gd_grpSectorType);
		grpSectorType.setText("Sector Type");
		
		Group grpRecoveryRates = new Group(grpRoomFlags, SWT.NONE);
		grpRecoveryRates.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpRecoveryRates.setText("Recovery Rates");
		
		grpDoors = new Group(sashForm, SWT.NONE);
		grpDoors.setText("Doors");
		grpDoors.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TabFolder tabFolder_2 = new TabFolder(grpDoors, SWT.NONE);
		
		TabItem tbtmNorth = new TabItem(tabFolder_2, SWT.NONE);
		tbtmNorth.setText("North");
		
		Composite northComposite = new Composite(tabFolder_2, SWT.NONE);
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
		
		Combo northDoorStateCombo = new Combo(northComposite, SWT.READ_ONLY);
		northDoorStateCombo.setVisibleItemCount(3);
		northDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		northDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey = new Label(northComposite, SWT.NONE);
		lblDoorKey.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey.setText("Door Key");
		
		Combo northDoorKeyCombo = new Combo(northComposite, SWT.READ_ONLY);
		northDoorKeyCombo.setItems(new String[] {"(None)"});
		northDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize = new Label(northComposite, SWT.NONE);
		lblDoorSize.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize.setText("Door Size");
		
		Combo northDoorSizeCombo = new Combo(northComposite, SWT.READ_ONLY);
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
		
		Button northDoorFlagACheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		Button northDoorFlagBCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagBCheck.setText("Door resets to closed");
		
		Button northDoorFlagCCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagCCheck.setText("Door resets to locked");
		
		Button northDoorFlagFCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		Button northDoorFlagGCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		Button northDoorFlagHCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagHCheck.setText("Lock easy to pick");
		
		Button northDoorFlagICheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagICheck.setText("Lock hard to pick");
		
		Button northDoorFlagJCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagJCheck.setText("Lock infuriating to pick");
		
		Button northDoorFlagKCheck = new Button(composite_4, SWT.CHECK);
		northDoorFlagKCheck.setText("Door cannot be closed");
		
		Button northDoorFlagLCheck = new Button(composite_4, SWT.CHECK);
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
		
		Combo eastDoorStateCombo = new Combo(eastComposite, SWT.READ_ONLY);
		eastDoorStateCombo.setVisibleItemCount(3);
		eastDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		eastDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_1 = new Label(eastComposite, SWT.NONE);
		lblDoorKey_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_1.setText("Door Key");
		
		Combo eastDoorKeyCombo = new Combo(eastComposite, SWT.READ_ONLY);
		eastDoorKeyCombo.setItems(new String[] {"(None)"});
		eastDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_1 = new Label(eastComposite, SWT.NONE);
		lblDoorSize_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_1.setText("Door Size");
		
		Combo eastDoorSizeCombo = new Combo(eastComposite, SWT.READ_ONLY);
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
		
		Button eastDoorFlagACheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		Button eastDoorFlagBCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagBCheck.setText("Door resets to closed");
		
		Button eastDoorFlagCCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagCCheck.setText("Door resets to locked");
		
		Button eastDoorFlagFCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		Button eastDoorFlagGCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		Button eastDoorFlagHCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagHCheck.setText("Lock easy to pick");
		
		Button eastDoorFlagICheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagICheck.setText("Lock hard to pick");
		
		Button eastDoorFlagJCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagJCheck.setText("Lock infuriating to pick");
		
		Button eastDoorFlagKCheck = new Button(composite_4_1, SWT.CHECK);
		eastDoorFlagKCheck.setText("Door cannot be closed");
		
		Button eastDoorFlagLCheck = new Button(composite_4_1, SWT.CHECK);
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
		
		Combo southDoorStateCombo = new Combo(southComposite, SWT.READ_ONLY);
		southDoorStateCombo.setVisibleItemCount(3);
		southDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		southDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_2 = new Label(southComposite, SWT.NONE);
		lblDoorKey_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_2.setText("Door Key");
		
		Combo southDoorKeyCombo = new Combo(southComposite, SWT.READ_ONLY);
		southDoorKeyCombo.setItems(new String[] {"(None)"});
		southDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_2 = new Label(southComposite, SWT.NONE);
		lblDoorSize_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_2.setText("Door Size");
		
		Combo southDoorSizeCombo = new Combo(southComposite, SWT.READ_ONLY);
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
		
		Button southDoorFlagACheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		Button southDoorFlagBCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagBCheck.setText("Door resets to closed");
		
		Button southDoorFlagCCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagCCheck.setText("Door resets to locked");
		
		Button southDoorFlagFCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		Button southDoorFlagGCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		Button southDoorFlagHCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagHCheck.setText("Lock easy to pick");
		
		Button southDoorFlagICheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagICheck.setText("Lock hard to pick");
		
		Button southDoorFlagJCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagJCheck.setText("Lock infuriating to pick");
		
		Button southDoorFlagKCheck = new Button(composite_4_2, SWT.CHECK);
		southDoorFlagKCheck.setText("Door cannot be closed");
		
		Button southDoorFlagLCheck = new Button(composite_4_2, SWT.CHECK);
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
		
		Combo westDoorStateCombo = new Combo(westComposite, SWT.READ_ONLY);
		westDoorStateCombo.setVisibleItemCount(3);
		westDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		westDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_3 = new Label(westComposite, SWT.NONE);
		lblDoorKey_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_3.setText("Door Key");
		
		Combo westDoorKeyCombo = new Combo(westComposite, SWT.READ_ONLY);
		westDoorKeyCombo.setItems(new String[] {"(None)"});
		westDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_3 = new Label(westComposite, SWT.NONE);
		lblDoorSize_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_3.setText("Door Size");
		
		Combo westDoorSizeCombo = new Combo(westComposite, SWT.READ_ONLY);
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
		
		Button westDoorFlagACheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		Button westDoorFlagBCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagBCheck.setText("Door resets to closed");
		
		Button westDoorFlagCCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagCCheck.setText("Door resets to locked");
		
		Button westDoorFlagFCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		Button westDoorFlagGCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		Button westDoorFlagHCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagHCheck.setText("Lock easy to pick");
		
		Button westDoorFlagICheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagICheck.setText("Lock hard to pick");
		
		Button westDoorFlagJCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagJCheck.setText("Lock infuriating to pick");
		
		Button westDoorFlagKCheck = new Button(composite_4_3, SWT.CHECK);
		westDoorFlagKCheck.setText("Door cannot be closed");
		
		Button westDoorFlagLCheck = new Button(composite_4_3, SWT.CHECK);
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
		
		Combo upDoorStateCombo = new Combo(upComposite, SWT.READ_ONLY);
		upDoorStateCombo.setVisibleItemCount(3);
		upDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		upDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_4 = new Label(upComposite, SWT.NONE);
		lblDoorKey_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_4.setText("Door Key");
		
		Combo upDoorKeyCombo = new Combo(upComposite, SWT.READ_ONLY);
		upDoorKeyCombo.setItems(new String[] {"(None)"});
		upDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_4 = new Label(upComposite, SWT.NONE);
		lblDoorSize_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_4.setText("Door Size");
		
		Combo upDoorSizeCombo = new Combo(upComposite, SWT.READ_ONLY);
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
		
		Button upDoorFlagACheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		Button upDoorFlagBCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagBCheck.setText("Door resets to closed");
		
		Button upDoorFlagCCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagCCheck.setText("Door resets to locked");
		
		Button upDoorFlagFCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		Button upDoorFlagGCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		Button upDoorFlagHCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagHCheck.setText("Lock easy to pick");
		
		Button upDoorFlagICheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagICheck.setText("Lock hard to pick");
		
		Button upDoorFlagJCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagJCheck.setText("Lock infuriating to pick");
		
		Button upDoorFlagKCheck = new Button(composite_4_4, SWT.CHECK);
		upDoorFlagKCheck.setText("Door cannot be closed");
		
		Button upDoorFlagLCheck = new Button(composite_4_4, SWT.CHECK);
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
		
		Combo downDoorStateCombo = new Combo(downComposite, SWT.READ_ONLY);
		downDoorStateCombo.setVisibleItemCount(3);
		downDoorStateCombo.setItems(new String[] {"Opened", "Closed", "Locked"});
		downDoorStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorKey_5 = new Label(downComposite, SWT.NONE);
		lblDoorKey_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorKey_5.setText("Door Key");
		
		Combo downDoorKeyCombo = new Combo(downComposite, SWT.READ_ONLY);
		downDoorKeyCombo.setItems(new String[] {"(None)"});
		downDoorKeyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDoorSize_5 = new Label(downComposite, SWT.NONE);
		lblDoorSize_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDoorSize_5.setText("Door Size");
		
		Combo downDoorSizeCombo = new Combo(downComposite, SWT.READ_ONLY);
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
		
		Button downDoorFlagACheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagACheck.setText("Door may be opened and closed, no lock, resets to open");
		
		Button downDoorFlagBCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagBCheck.setText("Door resets to closed");
		
		Button downDoorFlagCCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagCCheck.setText("Door resets to locked");
		
		Button downDoorFlagFCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagFCheck.setText("Door with unpickable lock (key needed)");
		
		Button downDoorFlagGCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagGCheck.setText("Door immune to \"pass door\" spell (can pick)");
		
		Button downDoorFlagHCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagHCheck.setText("Lock easy to pick");
		
		Button downDoorFlagICheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagICheck.setText("Lock hard to pick");
		
		Button downDoorFlagJCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagJCheck.setText("Lock infuriating to pick");
		
		Button downDoorFlagKCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagKCheck.setText("Door cannot be closed");
		
		Button downDoorFlagLCheck = new Button(composite_4_5, SWT.CHECK);
		downDoorFlagLCheck.setText("Door cannot be locked");
		scrolledComposite_1_5.setContent(composite_4_5);
		scrolledComposite_1_5.setMinSize(composite_4_5.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite_1_5.setMinSize(new Point(323, 193));
		sashForm.setWeights(new int[] {1, 1, 1});
		
		TabItem tbtmMobEditor = new TabItem(tabFolder_1, SWT.NONE);
		tbtmMobEditor.setText("Mob Editor");
		
		TabItem tbtmObjectEditor_1 = new TabItem(tabFolder_1, SWT.NONE);
		tbtmObjectEditor_1.setText("Object Editor");
		
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
}
