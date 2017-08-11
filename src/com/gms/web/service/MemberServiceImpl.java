package com.gms.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,Object> login(MemberBean member) {
		Map<String,Object> map = new HashMap<>();
		MemberBean m = findById(member.getId());
		String page = (m != null) ?( (member.getPw().equals(m.getPw())) ? "main" :"login_fail") :  "join";
		map.put("page", page);
		map.put("user", m);
		return map;
	}
}