package com.gms.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.ResponseAPDU;

import com.gms.web.constant.Action;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController Get 진입");
		switch (request.getParameter("action")) {
		case Action.MOVE:
			Separator.init(request);
			DispatcherServlet.send(request, response);
			break;

		case "":
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("MemberController Post 진입");
	}

}
