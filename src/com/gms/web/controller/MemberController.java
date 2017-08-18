package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.constant.Action;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController 진입");
		Separator.init(request);
		MemberBean member = new MemberBean();
		MemberService service=MemberServiceImpl.getInstance();
		switch (request.getParameter("action")) {
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.JOIN:
			System.out.println("=== join 진입 ===");	
			Map<?,?> map=ParamsIterator.execute(request);
			member.setId((String)map.get("join_id"));
			member.setPw((String)map.get("join_pw"));
			member.setName((String)map.get("join_name"));
			member.setBirthday((String)map.get("join_birth"));
			member.setGender((String)map.get("gender"));
			member.setEmail((String)map.get("join_email"));
			member.setMajor((String)map.get("major"));
			member.setPhone((String)map.get("join_phone"));
			member.setProfile("profile.jpg");
			String[] subjects=((String)map.get("subject")).split(",");
			List<MajorBean> list=new ArrayList<>();
			MajorBean major=null;
			for(int i=0;i<subjects.length;i++){
				major=new MajorBean();
				major.setMajorId(String.valueOf((int)((Math.random() * 9999) + 1000)));
				major.setId((String)map.get("join_id"));
				major.setTitle((String)map.get("join_name"));
				major.setSubjId(subjects[i]);
				list.add(major);
			}
			Map<String,Object>tempMap=new HashMap<>();
			tempMap.put("member", member);
			tempMap.put("major", list);
			String rs=service.addMember(tempMap);
			Separator.cmd.setDirectory("common");
			Separator.cmd.process();
			System.out.println("컨트롤러 insert결과:" + rs);
			DispatcherServlet.send(request, response);
			break;
		default:System.out.println("FAIL..");break;
		case Action.LIST:
			System.out.println("멤버리스트 진입");
			 @SuppressWarnings("unchecked") 
			 List<StudentBean> memberList=( List<StudentBean>)service.getMembers();
			 System.out.println("DB에서 가져온 memberList" + memberList);
			 request.setAttribute("pageNumber",request.getParameter("pageNumber"));
			 request.setAttribute("list", memberList);
			 request.setAttribute("prevBlock", "0");
			 request.setAttribute("startPage", "1");
			 int theNumberOfPages=( memberList.size()%5!=0)? memberList.size()/5+1:memberList.size()/5;
			 request.setAttribute("theNumberOfPages", theNumberOfPages);
			 request.setAttribute("endPage", String.valueOf(theNumberOfPages));
			DispatcherServlet.send(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("MemberController Post 진입");
	}

}
