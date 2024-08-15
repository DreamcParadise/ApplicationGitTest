package com.smartdio.application.intro;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * 应用程序的启动器，通过这个Application可以控制Ecipse应用程序的各个方面。
 */
public class Application implements IApplication {

	/**
	 * 启动应用程序
	 */
	public Object start(IApplicationContext context) {
		Display display = PlatformUI.createDisplay();//建立Display对象
		try {
			//启动Workbench,即Ecipse应用程序的窗口
			//实际上createAndRunWorkbench的运行过程就是整个应用程序的运行过程。
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			//createAndRunWorkbench返回，就是整个Ecipse应用程序结束
			if (returnCode == PlatformUI.RETURN_RESTART) {//如果返回的代号是重启
				return IApplication.EXIT_RESTART;//返回预定义的重启标志
			}
			return IApplication.EXIT_OK;//其他则返回退出标志
		} finally {
			display.dispose();
		}
	}

	/**
	 * 停止应用程序
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {//通过一个线程执行资源的清理工作
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
