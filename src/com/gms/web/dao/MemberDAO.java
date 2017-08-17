package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	public String insert(Map<?,?> map);
	public List<?> selectAll();
	public String countMembers();
	public MemberBean selectById(String id);
	public List<?> selectByNames(String name);
	public String update(MemberBean member);
	public String delete(String id);
	//MemberBean[] list=new MemberBean[4];
}
