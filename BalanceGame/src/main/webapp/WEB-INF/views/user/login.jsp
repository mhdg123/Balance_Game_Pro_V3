<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>로그인</title>
<!-- css -->

<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

	<!-- 헤너 네비 바 -->
	<%@ include file="../layout/header.jsp"%>
	<!-- 헤너 네비 바 -->
	<main>
		<!-- Hero Area Start-->
		<div class="slider-area ">
			<div class="single-slider slider-height2 d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="hero-cap text-center">
								<h2>로그인</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Hero Area End-->
		<!--================login_part Area =================-->
		<section class="login_part section_padding ">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-6 col-md-6">
						<div class="login_part_text text-center">
							<div class="login_part_text_iner">
								<h2>처음 오셨나요?</h2>
								<p>회원가입부터 해주세요</p>
								<a href="/user/joinAgree" class="btn_3">회원가입</a>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="login_part_form">
							<div class="login_part_form_iner">
								<h3>
									환영합니다. <br> 로그인 해주세요.
								</h3>
								<form class="row contact_form" action="/user/login"
									method="post" novalidate="novalidate"
									onsubmit="return login();">
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="loginId"
											name="loginId" value="" placeholder="아이디">
									</div>
									<div class="col-md-12 form-group p_star">
										<input type="password" class="form-control"
											id="memberPassword" name="memberPassword" value=""
											placeholder="패스워드">
									</div>
									<div class="col-md-12 form-group">
										<div class="creat_account d-flex align-items-center">
											<input type="checkbox" id="f-option" name="selector">
											<label for="f-option">아이디 저장</label>
										</div>
										<button type="submit" value="submit" class="btn_3">log
											in</button>
										<a href="mySearchInfo.html" class="lost_pass"
											id="searchLoginPw"> 회원정보 찾기</a>
										<!-- <a class="lost_pass"  id="searchLoginId" style="cursor: pointer;" >아이디 찾기 /</a> -->
									</div>
								</form>
								<!-- 네이버로그인 시작 -->


								<!-- 네이버 로그인 버튼 노출 영역 -->
								<!--     <div id="naver_id_login">네이버 로그인</div>
    //네이버 로그인 버튼 노출 영역
  <script type="text/javascript">
        var naver_id_login = new naver_id_login("5nji9jWWSPZCvKt4pNf7", "http://localhost:8088/naverLogin");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("white", 2,40);
        naver_id_login.setDomain("http://localhost:8088");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();
    </script> -->



								<%
								String clientId = "5nji9jWWSPZCvKt4pNf7";//애플리케이션 클라이언트 아이디값";
								String redirectURI = URLEncoder.encode("http://localhost:8088/naverLogin", "UTF-8");
								SecureRandom random = new SecureRandom();
								String state = new BigInteger(130, random).toString();
								String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
								apiURL += "&client_id=" + clientId;
								apiURL += "&redirect_uri=" + redirectURI;
								apiURL += "&state=" + state;
								session.setAttribute("state", state);
								%>
								<a href="<%=apiURL%>"><img height="50"
									src="/resources/assets/img/jarvis/naver_button.png" /></a>


								<!-- 네이버로그인 끝 -->
								<a id="kakao-login-btn"></a>
							</div>
						</div>
					</div>

				</div>


			</div>
		</section>
		<!--================login_part end =================-->
	</main>
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->




	<!--  아이디찾기 비밀번호찾기 
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
    //  아이디 찾기
     document.getElementById("searchLoginId").addEventListener("click", async () => {
  const { value: formValues } = await Swal.fire({
    title: "아이디 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="가입 이름">
      <input id="swal-input2" class="swal2-input" placeholder="가입시 이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const email = document.getElementById("swal-input1").value;
      const birthdate = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ name, email }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (!response.ok) {
          return "서버 전송 실패";
        // throw new Error("서버에 데이터 전송 실패!");
      }

      // 성공적인 응답 처리 (원하는 논리로 변경)
      const data = await response.json();
      console.log("회원님의 아이디는 : " + data + "입니다.") 
    //   console.log("서버 응답:", data); // 예시: 응답 데이터 기록
      return formValues; // 추가 처리를 위해 formValues 반환
    }
  });

  if (formValues) {
    Swal.fire(JSON.stringify(formValues));
  }
});


// 패스워드 찾기
document.getElementById("searchLoginPw").addEventListener("click", async () => {
  const { value: formValues } = await Swal.fire({
    title: "비밀번호 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="가입 이름">
      <input id="swal-input2" class="swal2-input" placeholder="가입시 이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const email = document.getElementById("swal-input1").value;
      const birthdate = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ email, birthdate }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (!response.ok) {
          return "서버 전송 실패";
        // throw new Error("서버에 데이터 전송 실패!");
      }

      // 성공적인 응답 처리 (원하는 논리로 변경)
      const data = await response.json();
      console.log("회원님의 아이디는 : " + data + "입니다.") 
    //   console.log("서버 응답:", data); // 예시: 응답 데이터 기록
      return formValues; // 추가 처리를 위해 formValues 반환
    }
  });

  if (formValues) {
    Swal.fire(JSON.stringify(formValues));
  }
}); -->

	<script>
		function login() {
			var loginId = $("#loginId").val();
			var memberPassword = $("#memberPassword").val();
			if (!loginId) {
				showError("아이디", "닉네임을 입력해주세요");
				return false;
			}
			if (!memberPassword) {
				showError("비밀번호", "비밀번호를 입력해주세요");
				return false;

			}
			return true;
		}
	</script>

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- sweetalert -->
	<script src="/resources/common/js/alert.js"></script>
	<script src="/resources/user/js/kakaoLogin.js"></script>

</body>

</html>