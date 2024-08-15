/**
 * 
 */
package com.smartdio.application.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author mai
 *
 */
public class MckoiPanel extends Composite {

	private Label label = null;
	private Text folderText = null;
	private Button folderButton = null;
	private Label label1 = null;
	private Label label3 = null;
	private Text usernameText = null;
	private Label label2 = null;
	private Label label5 = null;
	private Text passText = null;
	
	private DirectoryDialog dirDialog = null ;
	
	private boolean modified = false;

	/**
	 * @param parent
	 * @param style
	 */
	public MckoiPanel(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		initialize();
		dirDialog = new DirectoryDialog(this.getShell()) ;
	}
	
	private void initialize() {
		GridData gridData2 = new GridData();
		gridData2.widthHint = 200;
		GridData gridData1 = new GridData();
		gridData1.widthHint = 200;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.widthHint = 200;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		label = new Label(this, SWT.NONE);
		label.setText("dataFolder");
		folderText = new Text(this, SWT.BORDER);
		folderText.setLayoutData(gridData);
		/*
		folderText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				lsn.modifyText(e);
			}
		});*/
		folderButton = new Button(this, SWT.NONE);
		folderButton.setText("browse");
		folderButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						getFolder();
					}
				});
		label1 = new Label(this, SWT.NONE);
		label1.setText("userName");
		usernameText = new Text(this, SWT.BORDER);
		usernameText.setLayoutData(gridData1);
		usernameText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				if("".equals(usernameText.getText())){
					modified=false;
					return ;
				}
				modified = true;
				if(lsn!=null){
					lsn.modifyText(e);
				}
			}
		});
		label3 = new Label(this, SWT.NONE);
		label2 = new Label(this, SWT.NONE);
		label2.setText("userPass");
		passText = new Text(this, SWT.BORDER);
		passText.setLayoutData(gridData2);
		passText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn!=null){
					lsn.modifyText(e);
				}
			}
		});
		label5 = new Label(this, SWT.NONE);
		this.setLayout(gridLayout);
		setSize(new Point(300, 200));
	}
	
	protected void getFolder(){
		String dir =dirDialog.open();
		if(dir!=null){
			folderText.setText(dir);
		}
	}
	
	public void storePreference(){
		// TODO 实现保存配置
	}
	
	public void loadPreference(){
		// TODO 实现装载的配置
		
	}

	/**
	 * @return Returns the modified.
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * @param modified The modified to set.
	 */
	public void setModified(boolean modified) {
		this.modified = modified;
	}
	/**
	 * 修改监听器
	 * 
	 */
	ModifyListener lsn ;
	public void addModifyListener (ModifyListener lsn){
		this.lsn = lsn;
	}

}
