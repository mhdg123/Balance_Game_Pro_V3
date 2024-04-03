<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<form id="joinForm" action="/naver/join" method="POST">
    <input type="hidden" value="${memberData.loginId }" name="loginId">
    <input type="hidden" value="${memberData.name }" name="name">
    <input type="hidden" value="${memberData.nickName }" name="nickName">
    <input type="hidden" value="${memberData.grade }" name="grade">
    <input type="hidden" value="${memberData.gender }" name="gender">
    <input type="hidden" value="${memberData.email }" name="email">
    <input type="hidden" value="${memberData.cellPhone }" name="cellPhone">
    <input type="hidden" value="${memberData.age }" name="age">
</form>

<script type="text/javascript">
window.onload = function() {
    document.getElementById("joinForm").submit();
};
</script>
</body>
</html>