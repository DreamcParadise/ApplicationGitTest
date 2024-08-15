/*******************************************************************************
 * Copyright (c) 2008 Smart Mai(smardio@gmail.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Smart Mai(smardio@gmail.com) - initial API and implementation
 ******************************************************************************/
package com.smartdio.application.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.smartdio.application.Activator;

/**
 *实现Eclipse首选项对话框中的首选项页面。对数据库进行设置。
 */
public class DBPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	DBPreferencePanel dbPanel;//数据库相关选项的设置面板

	/**
	 * 构造方法
	 */
	public DBPreferencePage() {
		super();
	}
	/**
	 * 构造方法
	 * @param title 指定该选项页的标题
	 */
	public DBPreferencePage(String title) {
		super(title);
	}

	/**
	 * 构造方法
	 * @param title  指定该选项页的标题
	 * @param image  指定该选项页的图标
	 */
	public DBPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	/**
	 * 建立选项页中的部件
	 */
	protected Control createContents(Composite parent) {
		dbPanel = new DBPreferencePanel(parent, SWT.NONE);//建立数据库相关选项的设置面板
		dbPanel.loadPreference();//装载设置项的值
		return dbPanel;
	}

	/**
	 * 用户在首选项对话框上，按下“应用(Apply)”按钮后，Eclipse系统将调用该方法
	 */
	protected void performApply() {
		dbPanel.storePreference();//执行设置项的保存
		super.performApply();
	}

	/**
	 * 用户在首选项对话框上，按下“确定(OK)”按钮后，Eclipse系统将调用该方法
	 */
	public boolean performOk() {
		dbPanel.storePreference();//执行设置项的保存
		return super.performOk();
	}



	/**
	 * 初始化
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

}
