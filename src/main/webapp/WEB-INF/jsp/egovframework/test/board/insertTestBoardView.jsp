<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<%-- <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="./summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({ 
			height: 500,
			minHeight: null,
			maxHeight: null,
			focus: true
		});
	});

</script>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h1>테스트</h1>
		</div>

		<div>
			<h3>테스트 게시글 등록</h3>
		</div>

		<div>
			<form id="testForm" name="testForm" method="post" enctype="multipart/form-data">
				<table>
					<tbody>
						<select>
							<option>게시글 메뉴</option>
						</select>
						<tr>
							<td><input placeholder="제목"></td>
						</tr>
						<tr>
							<td><textarea id="summernote" name="editordata"></textarea>
							</td>
						</tr>
						<tr>
							<td>첨부파일 목록</td>
						</tr>
						<tr>
							<td><input type="file" id="fileUpload" multiple></td>
						</tr>
						<tr>
							<td><div id="fileUploadList">여기에 `리스트를 쭉 뿌려줄거야</div></td>
						</tr>

					</tbody>
				</table>
			</form>


			<div>
				<a href=""><span>등록</span></a>
				<a href=""><span>취소</span></a>
			</div>
		</div>
	</div>
</body>
</html>