package com.gms.web.service;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
		}
	private MemberServiceImpl() {}
	@Override
	public String addMember(MemberBean member) {
		return (MemberDAOImpl.getInstance().insert(member).equals("1"))?"등록성공":"실패";
	}
	@Override
	public List<MemberBean> getMembers() {
		return MemberDAOImpl.getInstance().selectAll();
	}
	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().countMembers());
	}
	@Override
	public List<MemberBean> findByNames(String name) {
		return MemberDAOImpl.getInstance().selectByNames(name);
	}
	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public String modify(MemberBean param) {
		String msg="";
		return msg;	
	}
	@Override
	public String remove(String id) {
		String msg="";
		return msg;
		
	}
	@Override
	public String login(MemberBean member) {
		MemberBean temp = findById(member.getId());
		return (temp != null)? ((member.getPw().equals(temp.getPw())) ?  "main" : "login_fail") : "join";
		
	
	}
}