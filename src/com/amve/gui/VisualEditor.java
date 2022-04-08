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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import javax.swing.JPanel;


public class VisualEditor {

	protected Shell shell;
	private Text text;

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
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1201, 602);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.NONE);
		mntmFile.setText("File");
		
		MenuItem mntmArea = new MenuItem(menu, SWT.NONE);
		mntmArea.setText("Area");
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.setText("Edit");
		
		MenuItem mntmWindow = new MenuItem(menu, SWT.NONE);
		mntmWindow.setText("Window");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite.widthHint = 149;
		composite.setLayoutData(gd_composite);
		
		Group grpWorldObjects = new Group(composite, SWT.NONE);
		grpWorldObjects.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpWorldObjects.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpWorldObjects.setText("World Objects");
		
		Tree tree = new Tree(grpWorldObjects, SWT.BORDER);
		
		Group grpResetInfo = new Group(composite, SWT.NONE);
		grpResetInfo.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpResetInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpResetInfo.setText("Reset Info");
		
		Tree tree_1 = new Tree(grpResetInfo, SWT.BORDER);
		
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
		tbtmObjectEditor.setText("Object Editor");
		
		TabItem tbtmAreaOverview = new TabItem(tabFolder, SWT.NONE);
		tbtmAreaOverview.setText("Area Overview");
		
		ListViewer listViewer = new ListViewer(tabFolder, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		tbtmAreaOverview.setControl(list);
		
		TabItem tbtmWorldView = new TabItem(tabFolder, SWT.NONE);
		tbtmWorldView.setText("World Visualizer");
		
		Composite composite_2 = new Composite(tabFolder, SWT.EMBEDDED);
		tbtmWorldView.setControl(composite_2);
		
		Frame frame = SWT_AWT.new_Frame(composite_2);
		
		JPanel panel_1 = new JPanel();
		frame.add(panel_1, BorderLayout.CENTER);
		
		CLabel lblLog = new CLabel(composite_1, SWT.NONE);
		lblLog.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblLog.setText("Log");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(composite_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		text = new Text(scrolledComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.CANCEL | SWT.MULTI);
		scrolledComposite.setContent(text);
		scrolledComposite.setMinSize(text.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}
}
