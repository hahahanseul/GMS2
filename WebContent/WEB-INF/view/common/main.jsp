<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<jsp:include page="common_head.jsp" />

<div id ="container">
	<div class="row">
		<div class="col-sm-4">
			<h3>학생관리</h3>
			<ul class="list-group">
				<li class="list-group-item"><a onclick="moveTo('member','member_add')">학생정보 추가</a></li>
				<li class="list-group-item"><a onclick="moveTo('member','member_list')">학생정보 목록</a></li>
				<li class="list-group-item"><a onclick="moveTo('member','member_detail')">학생정보 상세</a></li>
				<li class="list-group-item"><a onclick="moveTo('member','member_search')">학생정보 수정</a></li>
				<li class="list-group-item"><a onclick="deleteTarget('member')">학생정보 삭제</a></li>
			</ul>
		</div>
		<div class="col-sm-4">
			<h3>성적관리</h3>
			<ul class="list-group" >
				<li class="list-group-item"><a onclick="moveTo('grade','grade_add')">성적 입력</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade','grade_list')">성적 목록</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade','grade_detail')">성적 상세</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade','grade_search')">성적 수정</a></li>
				<li class="list-group-item"><a onclick="moveTo('grade')">성적 삭제</a></li>
			</ul>
		</div>
		<div class="col-sm-4">
			<h3>게시판관리</h3>
			<ul class="list-group">
				<li class="list-group-item"><a href="${ctx}/board/board_write.jsp">게시글 쓰기</a></li>
				<li class="list-group-item"><a href="${ctx}/board/board_list.jsp">게시글 목록</a></li>
				<li class="list-group-item"><a href="${ctx}/board/board_detail.jsp">게시글 상세</a></li>
				<li class="list-group-item"><a href="${ctx}/board/board_update.jsp">게시글 수정</a></li>
				<li class="list-group-item"><a href="${ctx}/board/board_delete.jsp">게시글 삭제</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
function moveTo(dir, page){
	location.href="${ctx}/"+dir+".do?action=move&page="+page;
}
function deleteTarget(dir){
	prompt(dir +'의 ID는?');
}

</script>
<jsp:include page="../common/footer.jsp" />