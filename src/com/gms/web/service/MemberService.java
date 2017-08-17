package com.gms.web.service;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberService {
	public String addMember(Map<String, Object> map);
	public List<?> getMembers();
	public List<?> findByNames(String name);
	public MemberBean findById(String id);
	public String countMembers();
	public String modify(MemberBean member);
	public String remove(String id);
	public Map<String,Object> login(MemberBean member);
	//MemberBean[] list=new MemberBean[4];
}
