<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<jsp:include page="../member/member_head.jsp" />
	<div id ="container">
		<table id="index_tab">
		<tr id="index_menu">	
			<th><i class="glyphicon glyphicon-user"></i>학생관리</th>
			<th><i class="glyphicon glyphicon-cloud"></i>성적관리</th>
			<th><i class="glyphicon glyphicon-thumbs-up"></i>게시판</th>
			
		</tr>
		<tr>
			<td>
			<ul class="index_ul">
				<li><a href="${ctx}/member.do?action=move&page=member_add">학생정보 추가</a></li>
				<li><a href="${ctx}/member.do?action=move&page=member_list">학생정보 목록</a></li>
				<li><a href="${ctx}/member.do?action=move&page=member_search">학생정보 상세</a></li>
				<li><a href="${ctx}/member.do?action=move&page=member_update">학생정보 수정</a></li>
				<li><a href="${ctx}/member.do?action=move&page=member_delete">학생정보 삭제</a></li>
			</ul>
			</td>
			<td>
			<ul class="index_ul" >
				<li><a href="${ctx}/grade/grade_add.jsp">성적 입력</a></li>
				<li><a href="${ctx}/grade/grade_list.jsp">성적 목록</a></li>
				<li><a href="${ctx}/grade/grade_detail.jsp">성적 상세</a></li>
				<li><a href="${ctx}/grade/grade_update.jsp">성적 수정</a></li>
				<li><a href="${ctx}/grade/grade_delete.jsp">성적 삭제</a></li>
			</ul>
			</td> 
			<td>
			<ul class="index_ul">
				<li><a href="${ctx}/board/board_write.jsp">게시글 쓰기</a></li>
				<li><a href="${ctx}/board/board_list.jsp">게시글 목록</a></li>
				<li><a href="${ctx}/board/board_detail.jsp">게시글 상세</a></li>
				<li><a href="${ctx}/board/board_update.jsp">게시글 수정</a></li>
				<li><a href="${ctx}/board/board_delete.jsp">게시글 삭제</a></li>
			</ul>
			</td>
		</tr>
		</table>
	</div>
<jsp:include page="../common/footer.jsp" />