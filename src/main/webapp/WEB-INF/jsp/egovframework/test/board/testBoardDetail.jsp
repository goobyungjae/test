<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<%-- <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<form name="bdForm" method="post">
		<input type="hidden" value="${testBoardDetail.boardId}"  name="boardId">
	</form>
	<div>
		<div>
			<h1>테스트</h1>
		</div>
	
		<div>
			<h3>테스트 상세페이지</h3>
		</div>

		<div>
			<div>
				<span><c:out value="${testBoardDetail.boardTitle}" /></span>
				<span><c:out value="${testBoardDetail.boardReg}" /></span>
			</div>
			<div>
				<span><c:out value="${testBoardDetail.boardWriterName}" /></span>
				<span>조회수 <c:out value="${testBoardDetail.boardViews}"/></span>
				<span>추천수</span>
				<span>댓글 <c:out value="${commentCnt}"/></span>
			</div>
			<div>	
				<div><c:out value="${testBoardDetail.boardContents}" /></div>
				<div>추천</div>
			</div>
			
			<div>
				<h3>댓글 <c:out value="${commentCnt}"/>개</h3>
				<c:forEach items="${testCommentList}" var="testCommentList">
					<div>
						<div>
							<span><c:out value="${testCommentList.commentWriterName}" /></span>
							<span><c:out value="${testCommentList.commentReg}"/></span>
							<span><a href="">변경</a></span>
							<span><a href="">삭제</a></span>
						</div>
						
						<div><c:out value="${testCommentList.commentContents}" /></div>
					</div>
				</c:forEach>
			</div>

			<div>
				<div>
					<a href="javascript:fnRegist();"><span>좋아요</span></a>
				</div>
			
				<span>
					<a href="/test/board/selectTestBoardList.do">게시판 목록</a>						
				</span>
			</div>
		</div>
	</div>
	
<script>
	function fnRegist() {
		if(confirm("등록 하시겠습니까?")){
			
			$.ajax({
				url : '<c:url value="/test/board/inserTestBoardCommend.do"/>',
				type : 'post',
				dataType: "json",
				data :$("form[name=bdForm]").serialize(),
				success : function(result) {
					alert("성공");
				}
			});
		}
	}
</script>

</body>
</html>