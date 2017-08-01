package com.gms.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.MemberBean;
import com.gms.web.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}
	private MemberDAOImpl() {}
	@Override
	public String insert(MemberBean member) {
		String rs = "";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getSsn());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String countMembers() {
		int res =0;
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeQuery();
			if(rs.next()) {
				res=Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(res);
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = null;
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberBean> selectByNames(String name) {
		List<MemberBean> list = new ArrayList<>();
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String update(MemberBean member) {
		String rs="";
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getId());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String id) {
		String rs="";
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
