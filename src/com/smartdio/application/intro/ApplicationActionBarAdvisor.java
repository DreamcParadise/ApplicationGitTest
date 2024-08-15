package com.smartdio.application.intro;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction introAction;
	
	private IContributionItem newSubMenu ;
	private IContributionItem perspectiveList ; 
	private IContributionItem viewsList ;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {

		
		// 文件相关的Action
		newSubMenu = ContributionItemFactory.NEW_WIZARD_SHORTLIST.create(window);
		register(ActionFactory.NEW.create(window));
		register(ActionFactory.SAVE.create(window));
		register(ActionFactory.SAVE_ALL.create(window));
		register(ActionFactory.CLOSE.create(window));
		register(ActionFactory.CLOSE_ALL.create(window));
		register(ActionFactory.PRINT.create(window));
		register(ActionFactory.QUIT.create(window));

		// 编辑相关的Action
		register(ActionFactory.UNDO.create(window));
		register(ActionFactory.REDO.create(window));
		register(ActionFactory.CUT.create(window));
		register(ActionFactory.COPY.create(window));
		register(ActionFactory.PASTE.create(window));
		register(ActionFactory.FIND.create(window));
		register(ActionFactory.REFRESH.create(window));
		register(ActionFactory.SELECT_ALL.create(window));

		// 和窗口相关的Action
		perspectiveList = ContributionItemFactory.PERSPECTIVES_SHORTLIST.create(window);
		viewsList = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
		register(ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window));
		register(ActionFactory.SHOW_VIEW_MENU.create(window));
		register(ActionFactory.PREFERENCES.create(window));
		register(ActionFactory.CLOSE_PERSPECTIVE.create(window));
		register(ActionFactory.CLOSE_ALL_PERSPECTIVES.create(window));

		// 帮助相关的Action
		introAction = ActionFactory.INTRO.create(window);
		register(introAction);
		register(ActionFactory.HELP_CONTENTS.create(window));
		register(ActionFactory.ABOUT.create(window));
		register(ActionFactory.HELP_SEARCH.create(window));
		register(ActionFactory.DYNAMIC_HELP.create(window));
	}

	protected void fillMenuBar(IMenuManager menuBar) {//添加菜单
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		menuBar.add(fileMenu);
		MenuManager editMenu = new MenuManager("&Edit",
				IWorkbenchActionConstants.M_EDIT);
		menuBar.add(editMenu);
		MenuManager windowMenu = new MenuManager("&Window",
				IWorkbenchActionConstants.M_WINDOW);
		menuBar.add(windowMenu);
		MenuManager helpMenu = new MenuManager("&Help",
				IWorkbenchActionConstants.M_HELP);
		menuBar.add(helpMenu);
		// 添加菜单项
		makeFileMenu(fileMenu);
		makeEditMenu(editMenu);
		makeWindowMenu(windowMenu);
		makeHelpMenu(helpMenu);
	}

	protected void makeFileMenu(MenuManager fileMenu) {
		// 新建相关的组
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.NEW_GROUP));
		MenuManager newMenu= new MenuManager("New");//新建命令
		newMenu.add(newSubMenu);//新建子菜单
		fileMenu.add(newMenu);
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// 保存相关的组
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.SAVE_GROUP));
		fileMenu.add(getAction(ActionFactory.SAVE.getId()));
		fileMenu.add(getAction(ActionFactory.SAVE_ALL.getId()));
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// 关闭相关的组
		fileMenu.add(getAction(ActionFactory.CLOSE.getId()));
		fileMenu.add(getAction(ActionFactory.CLOSE_ALL.getId()));
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// 打印相关的组
		fileMenu.add(getAction(ActionFactory.PRINT.getId()));
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.PRINT_EXT));
		fileMenu.add(new org.eclipse.jface.action.Separator());
		// 退出
		fileMenu.add(getAction(ActionFactory.QUIT.getId()));
		fileMenu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
	}

	protected void makeEditMenu(MenuManager editMenu) {
		// undo

		editMenu.add(getAction(ActionFactory.UNDO.getId()));
		editMenu.add(getAction(ActionFactory.REDO.getId()));
		editMenu.add(new org.eclipse.jface.action.Separator());

		// copy
		editMenu.add(getAction(ActionFactory.CUT.getId()));
		editMenu.add(getAction(ActionFactory.COPY.getId()));
		editMenu.add(getAction(ActionFactory.PASTE.getId()));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// find
		editMenu.add(getAction(ActionFactory.FIND.getId()));
		editMenu.add(new GroupMarker(IWorkbenchActionConstants.FIND_EXT));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// refresh
		editMenu.add(getAction(ActionFactory.REFRESH.getId()));
		editMenu.add(new org.eclipse.jface.action.Separator());
		// select
		editMenu.add(getAction(ActionFactory.SELECT_ALL.getId()));
		editMenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
	}

	protected void makeWindowMenu(MenuManager windowMenu) {
		
		// perspective list ----
		MenuManager perspectiveMenu = new MenuManager("Open Perspective");
		perspectiveMenu.add(perspectiveList);
		windowMenu.add(perspectiveMenu);
		// view menu ----
		MenuManager viewsMenu = new MenuManager("Show View");
		viewsMenu.add(viewsList);
		windowMenu.add(viewsMenu);
		
		windowMenu.add(new org.eclipse.jface.action.Separator());
		windowMenu.add(getAction(ActionFactory.CLOSE_PERSPECTIVE.getId()));
		windowMenu.add(getAction(ActionFactory.CLOSE_ALL_PERSPECTIVES.getId()));
		windowMenu.add(new org.eclipse.jface.action.Separator());
		windowMenu.add(new GroupMarker(IWorkbenchActionConstants.WINDOW_EXT));
		windowMenu.add(getAction(ActionFactory.PREFERENCES.getId()));
	}

	protected void makeHelpMenu(MenuManager helpMenu) {
		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		helpMenu.add(getAction(ActionFactory.HELP_CONTENTS.getId()));

		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(getAction(ActionFactory.HELP_SEARCH.getId()));
		helpMenu.add(getAction(ActionFactory.DYNAMIC_HELP.getId()));

		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(getAction(ActionFactory.INTRO.getId()));

		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
		helpMenu.add(new org.eclipse.jface.action.Separator());
		helpMenu.add(getAction(ActionFactory.ABOUT.getId()));
	}
}
