package com.gms.web.util;

import javax.servlet.http.HttpServletRequest;

import com.gms.web.command.Command;
import com.gms.web.factory.CommandFactory;

public class Separator {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		String servletPath=request.getServletPath();
		System.out.println("서블릿 패스:" + servletPath);
		String dir = servletPath.substring(1,servletPath.indexOf("."));
		System.out.println("디렉토리 패스: " + dir);
		cmd=CommandFactory.createCommand(dir, action, page);
	}
}
