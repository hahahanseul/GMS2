package com.gms.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.web.constant.Action;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CommonController Get진입");
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		Separator.init(request);
		switch (request.getParameter(Action.CMD)) {
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.LOGIN:
			MemberService service = MemberServiceImpl.getInstance();
			MemberBean m=new MemberBean();
			m.setId(request.getParameter("id"));
			m.setPw(request.getParameter("pw"));
			Map<String,Object> map = service.login(m);
			if(map.get("page").equals("main")) {
				session.setAttribute("user", map.get("user"));
			}
			Separator.cmd.setPage(String.valueOf(map.get("page")));
			Separator.cmd.process();
			DispatcherServlet.send(request, response);
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CommonController Post진입");
	}
}
