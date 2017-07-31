<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="member_head.jsp" %>
<div id="container">
	<div id="member_box">
		<div id="member_detail_title">회원정보 상세조회 </div>
		<form action="<%=request.getContextPath()%>/member/service_update.jsp">
			<table id="member_detail_tab">
				<tr>
					<td colspan="2" rowspan="3"><img id="member_img" src="<%=request.getContextPath()%>/img/" alt="" /></td>
					<td class="content_title">이름</td>
					<td></td>
				</tr>
				<tr>
					<td class="content_title">ID</td>
					<td></td>
				</tr>
				<tr>
					<td class="content_title">주민등록번호</td>
					<td></td>
				</tr>
				<tr>
					<td class="content_title">휴대전화</td>
					<td colspan="3"><input type="text" name="phone" placeholder=""/></td>
				</tr>
				<tr>
					<td class="content_title">이메일</td>
					<td colspan="3"><input type="email" name="email" placeholder=""/></td>
				</tr>
				<tr>
					<td class="content_title">학점</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td class="content_title">전공</td>
					<td colspan="3"><input type="text" name="major" placeholder=""></td>
				</tr>
				<tr>
					<td class="content_title">등록일</td>
					<td colspan="3"></td>
				</tr>
			</table>
		<div id="member_btn_box">
			<input type="submit" id="confirm_btn" value="수정"/>
			<input type="button"id="cancel_btn" value="취소" onclick="javascript:cancel()">
		</div>
		<input type="hidden" name="id" value=""/>
		</form>
	
	</div>
</div>
<script>
function cancel(){
	location.href="<%=request.getContextPath()%>/member/member_list.jsp?action=list";
}
</script>
<%@ include file="../common/footer.jsp" %>
