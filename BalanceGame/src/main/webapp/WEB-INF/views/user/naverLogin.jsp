<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<!-- <script type="text/javascript">
  var naver_id_login = new naver_id_login("5nji9jWWSPZCvKt4pNf7", "http://localhost:8088/naverLogin");
  // ���� ��ū �� ���
  alert(naver_id_login.oauthParams.access_token);
  // ���̹� ����� ������ ��ȸ
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // ���̹� ����� ������ ��ȸ ���� ������ ������ ó���� callback function
  function naverSignInCallback() {
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age'));
  }
</script> -->

<%--   <%
    String clientId = "5nji9jWWSPZCvKt4pNf7";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
    String clientSecret = "zlplsCHeig";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("YOUR_CALLBACK_URL", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // ���� ȣ��
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // ���� �߻�
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
        out.println(res.toString());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  %> --%>

Ȯ��
</body>
</html>