package com.smartdio.application.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;


/**
 * @author Smart
 *
 */
public class DBPreferencePanel extends Composite {

	private Group preferenceGroup = null;
	private Label label = null;
	private Label dbTypeLbl = null;
	private Combo dbType = null;
	private Composite formComposite = null;
	private MySQLPanel mySQLPanel = null;
	
	private boolean modified = false;
	
	private String[] selectedType=new String[]{"","MySQL","MCKIO","MSSQL","ORACLE"}; 
	/**
	 * @param parent
	 * @param style
	 */
	public DBPreferencePanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
	}
	


	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		this.setLayout(gridLayout);
		createPreferenceGroup();
		setSize(new Point(300, 200));
		label = new Label(this, SWT.NONE);
		dbType.add("");
		dbType.add("MySQL");
		dbType.add("mckoi");
		//dbType.add("MSSQL");
		//dbType.add("ORACLE");
		mySQLPanel.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn==null)return ;
				lsn.modifyText(e);
			}
		});
		
		this.mckoiPanel.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn==null)return ;
				lsn.modifyText(e);
			}
		});
	}

	/**
	 * This method initializes preferenceGroup	
	 *
	 */
	private void createPreferenceGroup() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		GridData gridData = new org.eclipse.swt.layout.GridData();
		gridData.horizontalSpan = 2;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		preferenceGroup = new Group(this, SWT.NONE);
		preferenceGroup.setText("dbPreference");
		preferenceGroup.setLayout(gridLayout1);
		preferenceGroup.setLayoutData(gridData);
		dbTypeLbl = new Label(preferenceGroup, SWT.NONE);
		dbTypeLbl.setText("dbType");
		createDbType();
		createFormComposite();
	}

	/**
	 * This method initializes dbType	
	 *
	 */
	private void createDbType() {
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		dbType = new Combo(preferenceGroup, SWT.NONE);
		dbType.setLayoutData(gridData2);
		dbType.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
			
			      modified = true;
			      changePanel();
			      
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	}
	
	
	protected void changePanel(){
		int i =dbType.getSelectionIndex();
		switch(i){
		case 0:
			mySQLPanel.setVisible(false);
			mckoiPanel.setVisible(false);
			break;
		case 1:
			mySQLPanel.setVisible(true);
			mckoiPanel.setVisible(false);
			break;
		case 2:
			mySQLPanel.setVisible(false);
			mckoiPanel.setVisible(true);
			break;
		case 3:
			mySQLPanel.setVisible(false);
			mckoiPanel.setVisible(false);
			break;
		case 4:
			mySQLPanel.setVisible(false);
			mckoiPanel.setVisible(false);
			break;
		}
	}

	/**
	 * This method initializes formComposite	
	 *
	 */
	private void createFormComposite() {
		GridData gridData3 = new org.eclipse.swt.layout.GridData();
		gridData3.horizontalSpan = 2;
		gridData3.grabExcessVerticalSpace = true;
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData3.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData3.grabExcessHorizontalSpace = true;
		formComposite = new Composite(preferenceGroup, SWT.NONE);
		formComposite.setLayout(new FormLayout());
		createMySQLPanel();
		formComposite.setLayoutData(gridData3);
		createMckoiPanel();
	}

	/**
	 * This method initializes mySQLPanel	
	 *
	 */
	private void createMySQLPanel() {
		mySQLPanel = new MySQLPanel(formComposite, SWT.NONE);
		mySQLPanel.setVisible(false);
	}
	
	
	private String getSelectedType(int index){
		return selectedType[index];
	}
	
	public void storePreference(){

	}
	
	public void loadPreference(){
		
				dbType.select(0);
	
		
		
	}
	
	protected void loadPreferenceByIndex(int i){
	
		switch(i){
		case 0:
			
			break;
		case 1:
			mySQLPanel.setVisible(true);
			mckoiPanel.setVisible(false);
			mySQLPanel.loadPreference();
			
			break;
		case 2:
			mySQLPanel.setVisible(false);
			mckoiPanel.setVisible(true);
			mckoiPanel.loadPreference();
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}

	/**
	 * @return Returns the modified.
	 */
	public boolean isModified() {
		if( modified && mySQLPanel.isModified()) return true;
		if( modified && this.mckoiPanel.isModified()) return true;
		return false;
	}

	/**
	 * @param modified The modified to set.
	 */
	public void setModified(boolean modified) {
		this.modified = modified;
	}
	
	ModifyListener lsn ;
	private MckoiPanel mckoiPanel = null;
	public void addModifyListener (ModifyListener lsn){
		this.lsn = lsn;
	}

	/**
	 * This method initializes mckoiPanel	
	 *
	 */
	private void createMckoiPanel() {
		mckoiPanel = new MckoiPanel(formComposite, SWT.NONE);
		mckoiPanel.setVisible(false);
		
	}

}
