<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title></title>
</head>
<body>
	<div>
		<div>
			<h1><a><span>테스트</span></a></h1>
			<div>
	        	<ul>
	            	<li><a title="">테스트 게시판</a></li>
	            	<li><a title=""></a></li>
	            </ul>
	        </div>
		</div>
		
		<div>
			<div>
	            <div class="title_cont">
	                <h2 class="">테스트 게시판</h2>
	             	<!-- <a href="#help_pop" class="btn_a btn_hp_a ml5 pims_modal_open blind"><span class="blind">도움말</span></a>
	                <a href="#question_pop" class="btn_a btn_qu_a ml5 pims_modal_open blind"><span class="blind">도움말</span></a> -->
	            </div>
		
	            <div>
					<!-- search box -->
	            </div>
		            
		        <div>
	                <div>
	                    <div>
							<div>
		                         <table>
		                             <caption><span></span></caption>
									 	<colgroup>
											<col>
											<col>
											<col>
											<col>
											<col>
											<col>
											<col>
										</colgroup>
										<thead>
											<tr>
												<th scope="col">이미지</th>
												<th scope="col">제목</th>
												<th scope="col">작성자</th>
												<th scope="col">날짜</th>
												<th scope="col">조회</th>
												<th scope="col">추천</th>
											</tr>
										</thead>
	
										<tbody style="text-align: center;">
											<c:out value="${testBoardCnt}"/><span> 개의 게시물이 존재합니다.</span>
											<c:forEach items="${testBoardList}" var="testBoardList">
												<tr>
													<td>이미지</td>
													<td>
														<c:url value='/test/board/selectTestBoardDetail.do' var="boardDetailUrl">
														<c:param name="boardId" value="${testBoardList.boardId}"/></c:url>
														<a href="${boardDetailUrl}"><c:out value="${testBoardList.boardTitle}" /></a>
														[ <c:out value="${testBoardList.commentInBoardCount}" /> ]
													</td>
													<td><c:out value="${testBoardList.boardWriterName}"/></td>
													<td><fmt:formatDate value="${testBoardList.boardReg}" pattern="yyyy.MM.dd"/></td>
													<td><c:out value="${testBoardList.boardViews}"/></td>
													<td>추천</td>
												</tr>
											</c:forEach>
											
											<c:if test="${fn:length(testBoardList) == 0}">
												<tr>
													<td>등록된 게시글이 없습니다.</td>
												</tr>
											</c:if>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				<div>
					<div>
						<a href="/test/board/insertTestBoardView.do">게시글 등록</a>						
					</div>
				</div>
				
			</div>
		</div>
	</div>
</html>