<%@page import="java.util.Set"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../member/member_head.jsp" />
<div id="container">
	<div id="sub_title">회원 목록 </div>
	<table id="member_tab">
		<tr id="member_menu">
			<th>No.</th>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>전 공</th>
			<th>학 점</th>
			<th>등록일</th>
			<th>수정/삭제</th> 
		</tr>
			<tr id="member_menu">
				<td></td>		
				<td></td>
				<td><a href="member_detail.jsp?id="></a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>A</td>
				<td></td>
				<td><a href="member_update.jsp?id=">수정</a>/<a href="service_delete.jsp?id=">삭제</a></td> 
			</tr>	
	</table>
	</div>
<jsp:include page="../common/footer.jsp" />