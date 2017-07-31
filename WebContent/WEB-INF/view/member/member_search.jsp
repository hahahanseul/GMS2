<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="member_head.jsp" %>
<div id="container">
<form id="member_search_box" action="<%=request.getContextPath()%>/member/service_search.jsp" method="get">
	검색조건<select name="option">
		<option value="id" selected>ID</option>
		<option value="name">이름</option>
	</select><br>
	<input type="text" name="search">
	<input id="find_btn" type="submit" value="제출"/>
	<input id="clear_btn" type="reset" value="취소"/>
</form>
</div>
<%@ include file="../common/footer.jsp" %>