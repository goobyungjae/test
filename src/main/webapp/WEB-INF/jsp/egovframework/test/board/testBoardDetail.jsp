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
	<div>
		<div>
			<h1>테스트</h1>
		</div>
	
		<div>
			<h3>테스트 상세페이지</h3>
		</div>

		<div>
			<table style="width: 100%; border: 2px solid #444444;">
				<colgroup>
					<col style="width: 5%;">
					<col style="width: 5%;">
					<col style="width: 15%;">
					<col style="width: 10%;">
					<col style="width: 10%;">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>이미지</th>
						<th>제목</th>
						<th>작성자 아이디</th>
						<th>작성자 이름</th>
					</tr>
				</thead>

				<tbody style="text-align: center;">
						<tr>
							<td><c:out value="${testBoardDetail.boardId}" /></td>
							<td></td>
							<td><c:out value="${testBoardDetail.boardTitle}" /> </td>
							<td><c:out value="${testBoardDetail.boardWriterId}" /></td>
							<td><c:out value="${testBoardDetail.boardWriterName}" /></td>
						</tr>
				</tbody>
			</table>

			<div>
				<c:forEach items="${testCommentList}" var="testCommentList">
				<div>
					<c:out value="${testCommentList.commentId}" />
					<c:out value="${testCommentList.commentWriterId}" />
					<c:out value="${testCommentList.commentWriterName}" />
					<c:out value="${testCommentList.commentContents}" />
					<c:out value="${testCommentList.commentReg}" />
				</div>
				</c:forEach>
			</div>

			<div>
				<span>
					<a href="/test/board/updateTestBoard.do"><span>게시글 수정하기</span></a>						
				</span>
				<span>
					<a href="/test/board/deleteTestBoard.do"><span>게시글 삭제하기</span></a>						
				</span>
				<span>
					<a href="/test/board/selectTestBoardList.do"><span>게시핀 목록</span></a>						
				</span>
			</div>
		</div>
	</div>
</body>
</html>