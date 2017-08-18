package com.gms.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAOImpl getInstance() {return new MemberDAOImpl();}
	Connection conn;
	private MemberDAOImpl() {
		conn=null;
	}
	@Override
	public String insert(Map<?,?> map) {
		String rs = "";
		MemberBean member = (MemberBean)map.get("member");
	/*	MajorBean major=(MajorBean)map.get("major");*/
	   @SuppressWarnings("unchecked")
       List<MajorBean> list=(List<MajorBean>)map.get("major");

		PreparedStatement pstmt=null;
		try {
			conn = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getBirthday());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getProfile());
			pstmt.executeUpdate();
			for(int i=0;i<list.size();i++) {
				pstmt=conn.prepareStatement(SQL.MAJOR_INSERT);
				pstmt.setString(1, list.get(i).getMajorId());
				pstmt.setString(2, list.get(i).getTitle());
				pstmt.setString(3, list.get(i).getId());
				pstmt.setString(4, list.get(i).getSubjId());
				rs=String.valueOf(pstmt.executeUpdate());
			}
			System.out.println("DB INSERT결과:" + rs);
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(conn != null){
				try{
					conn.rollback();
				}catch(SQLException ex){
					e.printStackTrace();
				}
			}
		}
		return rs;
	}

	@Override
	public List<?> selectAll() {
		List<StudentBean> list = new ArrayList<>();
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_LIST).executeQuery();
			StudentBean stud = null;
			while(rs.next()) {
				stud = new StudentBean();
				stud.setNum(rs.getString(DB.NUM));
				stud.setId(rs.getString(DB.ID));
				stud.setName(rs.getString(DB.MEMBER_NAME));
				stud.setSsn(rs.getString(DB.MEMBER_SSN));
				stud.setEmail(rs.getString(DB.EMAIL));
				stud.setPhone(rs.getString(DB.PHONE));
				stud.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				stud.setTitle(rs.getString(DB.TITLE));
				list.add(stud);
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
				member.setBirthday(rs.getString(DB.MEMBER_SSN));
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
				member.setBirthday(rs.getString(DB.MEMBER_SSN));
				
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
