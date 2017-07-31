package com.gms.web.util;

import javax.servlet.http.HttpServletRequest;

public class Separator {
	public static String init(HttpServletRequest request) {
		String servletPath=request.getServletPath();
		System.out.println("서블릿 패스:" + servletPath);
		String directory = servletPath.substring(1,servletPath.indexOf("."));
		System.out.println("디렉토리 패스: " + directory);
		return directory;
	}

}
