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
			<h3>테스트 게시판</h3>
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
					<c:forEach items="${testBoardList}" var="testBoardList">
						<tr>
							<td><c:out value="${testBoardList.boardId}" /></td>
							<td></td>
							<td><a href="${boardDetailUrl}"><c:out value="${testBoardList.boardTitle}" /><c:url value='/test/board/selectTestBoardDetail.do' var="boardDetailUrl"><c:param name="boardId" value="${testBoardList.boardId}"/></c:url></a>[ <c:out value="${testBoardList.commentInBoardCount}" /> ]</td>
							<td><c:out value="${testBoardList.boardWriterId}" /></td>
							<td><c:out value="${testBoardList.boardWriterName}" /></td>
						</tr>
					</c:forEach>
					
					<c:if test="${fn:length(testBoardList) == 0}">
						<tr>
							<td>등록된 게시글이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>

			<div>
				<div>
					<a href="/test/board/insertTestBoardView.do"><span>게시글 등록</span></a>						
				</div>
			</div>
		</div>
	</div>
</body>
</html>