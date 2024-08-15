/*
 * 朗日信息技术有限公司版权所有 2001-2005}
 * 本源代码是朗日信息技术有限公司的财产,
 * 受《著作权法》、《中华人民共和国软件保护条例》及《国际版权公约》保护, 
 * 任何企业或者个人未经朗日信息技术有限公司的明确书面授权许可,
 * 不得复制、销售本源代码给非本企业人员,不得对本源代码及其拷贝进行修改, 
 * 不得在任何公共媒体上散播本源代码，不得把本源代码编译成目标软件,
 * 不得复制本源代码全部或部分到其他非本企业的软件产品中。
 * 
 * 
 * Copyright (c) 2001-2005 by Luminary Technology LTD. China. 
 * All rights reserved.
 * 
 * 创建日期 2005-10-3
 * @author Smart
 */
package com.smartdio.application.preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Smart
 * 修改处
 */

//创建分支

//分支添加
public class MySQLPanel extends Composite {

	private Label hostLbl = null;
	private Text host = null;
	private Label dbaseLbl = null;
	private Text dBase = null;
	private Label userLbl = null;
	private Text user = null;
	private Label passwordLbl = null;
	private Text password = null;

	private boolean modified = false ;
	
    private Composite parent ;
	/**
	 * @param parent
	 * @param style
	 */
	public MySQLPanel(Composite parent, int style) {
		super(parent, style);
		this.parent= parent ;
		initialize();
	}

	private void initialize() {
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		hostLbl = new Label(this, SWT.NONE);
		hostLbl.setText("host");
		host = new Text(this, SWT.BORDER);
		host.setLayoutData(gridData3);
		host.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn!=null){
					lsn.modifyText(e);
				}
			}
		});
		dbaseLbl = new Label(this, SWT.NONE);
		dbaseLbl.setText("dBase");
		dBase = new Text(this, SWT.BORDER);
		dBase.setLayoutData(gridData2);
		dBase.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn!=null){
					lsn.modifyText(e);
				}
			}
		});
		userLbl = new Label(this, SWT.NONE);
		userLbl.setText("dbUser");
		user = new Text(this, SWT.BORDER);
		user.setLayoutData(gridData1);
		user.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn!=null){
					lsn.modifyText(e);
				}
			}
		});
		passwordLbl = new Label(this, SWT.NONE);
		passwordLbl.setText("password");
		password = new Text	(this, SWT.BORDER);
		password.setLayoutData(gridData);
		password.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
			public void modifyText(org.eclipse.swt.events.ModifyEvent e) {
				modified = true;
				if(lsn!=null){
					lsn.modifyText(e);
				}
			}
		});
		this.setLayout(gridLayout);
		setSize(new Point(300, 200));
	}
	
	public void storePreference(){
		// TODO 保存配置
	}
	
	
	
	

	public void loadPreference(){
	  // TODO 载入配置

		
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
