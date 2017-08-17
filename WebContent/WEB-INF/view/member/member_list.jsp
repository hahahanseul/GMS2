<%@page import="java.util.Set"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/common_head.jsp" />
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
			<th>수강과목</th>
			<th>등록일</th>
			<th>수정/삭제</th> 
		</tr>
			<c:forEach var="i" items="${requestScope.list}">
			<tr id="member_menu">
				<td>${i.num}</td>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.ssn}</td>
				<td>${i.phone}</td>
				<td>${i.email}</td>
				<td>${i.title}</td>
				<td>${i.regdate}</td>
				<td>수정/삭제</td> 
			</tr>	
			</c:forEach>
			
	</table>
	</div>
<jsp:include page="../common/footer.jsp" />