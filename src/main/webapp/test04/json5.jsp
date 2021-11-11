<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$("#checkJson").click(function() {
			var _jsonInfo = '{"name":"한나","age":"모름","gender":"여자","저서":"평범한 악"}';
			$.ajax({
				type:"post",
				async:false,
				url:"${pageContext.request.contextPath}/json",
				data:{jsonInfo:_jsonInfo},
				success:function(data, textStatus) {
				},
				error:function(data,textStatus) {
					alert("에러 발생!");
				},
				complete:function(data,textStatus) {
					alert("성공!");
				}
			});
		});
	});
</script>
</head>
<body>
 <button id="checkJson">실행</button>
</body>
</html>