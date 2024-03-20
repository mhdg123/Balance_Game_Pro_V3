<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>회원가입</title>
<!-- css -->
</head>

<body>
	<!-- 헤너 네비 바 -->
	<%@ include file="../layout/header.jsp"%>
	<!-- 헤너 네비 바 -->
	<main>
		<!-- Hero Area Start-->
		<div class="slider-area">
			<div class="single-slider slider-height2 d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="hero-cap text-center">
								<h2>회원가입</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================Checkout Area =================-->
		<c:if test="${status == 'balanceJoin' }">
			<section class="checkout_area section_padding">
				<div class="container">
					<div class="comments-area">
						<div class="row">
							<div style="width: 50%; margin: 0 auto">
								<h2>회원가입</h2>
								<form class="row contact_form" action="/user/join" method="POST" onsubmit="return joinFormAction();" name="joinForm">

									<input id="role" type="hidden" name="role" value="USER">
									<input id="advertisementStatus" type="hidden" name="advertisementStatus" value="T">
									<!----------------------------------------이름 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;이름</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="name" name="name" placeholder="이름 입력해주세요" value="테스트" />
									</div>
									<!----------------------------------------이름 입력창---------------------------------------->
									<!----------------------------------------나이 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;생년월일</div>
									<div class="col-md-12 form-group p_star">
										<input type="date" class="form-control" id="age" name="age" placeholder="나이 입력해주세요" />
									</div>
									<!----------------------------------------나이 입력창---------------------------------------->
									<!----------------------------------------아이디 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;아이디</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="loginId" name="loginId" placeholder="아이디 입력" value="testId" />
										<div>
											<font id="id_feedback" size="2"></font>
										</div>
									</div>
									<!----------------------------------------아이디 입력창---------------------------------------->
									<!----------------------------------------닉네임 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;닉네임</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="nickName" name="nickName" placeholder="닉에미 입력" value="자비스" />
									</div>
									<!----------------------------------------닉네임 입력창---------------------------------------->
									<!----------------------------------------비밀번호 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;비밀번호</div>
									<div class="col-md-12 form-group p_star">
										<input type="password" class="form-control" id="memberPassword" name="memberPassword" placeholder="비밀번호 입력" value="test1234" onkeyup="checkPassword();" />
									</div>
									<!----------------------------------------비밀번호 입력창---------------------------------------->
									<!----------------------------------------비밀번호 확인 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 확인&nbsp;&nbsp;&nbsp;</div>
									<div id="passwordError"></div>
									<div class="col-md-12 form-group p_star">
										<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" placeholder="비밀번호 확인 입력" value="test1234" onkeyup="checkPassword();" />
									</div>

									<!----------------------------------------비밀번호 확인 입력창---------------------------------------->
									<!----------------------------------------폰번호 입력창---------------------------------------->
									<span>&nbsp;&nbsp;&nbsp;휴대폰 번호</span>
									<div class="col-md-12 form-group1 p_star">
										<input type="tel" class="form-control" id="cellPhone" name="cellPhone" placeholder="폰번호 입력" value="01012345678" />
									</div>
									<!----------------------------------------폰번호 입력창---------------------------------------->
									<!----------------------------------------인증번호 입력창---------------------------------------->
									<div class="col-md-6 form-group p_star">
										<br />
										<input type="text" class="form-control" id="certification" name="certification" placeholder="인증번호 입력" value="1234" />
									</div>
									<!----------------------------------------인증번호 입력창---------------------------------------->
									<!----------------------------------------인증번호 발송버튼---------------------------------------->
									<div class="send-auth-num">
										<br /> <a href="javascript:sendAuthNum();" class="genric-btn info circle">인증번호 발송</a>
									</div>
									<!----------------------------------------인증번호 재발송---------------------------------------->
									<div class="resend-auth-num" style="display: none">
										<br /> <a href="javascript:sendAuthNum();" class="genric-btn info circle">인증번호 재발송</a>
									</div>
									<!----------------------------------------인증번호 확인---------------------------------------->
									<div class="confirm-auth-num" style="display: none">
										<br /> <a href="javascript:authNumCheck();" class="genric-btn info circle">인증번호 확인</a>
									</div>
									<!----------------------------------------인증번호 확인---------------------------------------->
									<!----------------------------------------이메일 입력창---------------------------------------->
									<div class="col-md-12 form-group p_star">
										<div>
											<br />이메일
										</div>
										<input type="email" class="form-control" id="email" name="email" placeholder="이메일 입력해주세요" value="test@naver.com" />
									</div>
									<!----------------------------------------이메일 입력창---------------------------------------->
									<!----------------------------------------성별 선택---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;성별</div>
									<div class="col-md-12 form-group p_star">
										<select id="gender" name="gender" class="country_select">
											<option value="M">남자</option>
											<option value="F">여자</option>
										</select>
									</div>
									<!----------------------------------------성별 선택---------------------------------------->
									<!----------------------------------------주소 입력---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;주소</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="address" name="address" placeholder="주소" value="서울특별시 강남구 역삼동 736-7" />
									</div>
									<div>
										&nbsp;&nbsp;&nbsp;<a class="genric-btn info circle" onClick="addressSearch();">주소 찾기</a>
										<div>
											<br />
										</div>
										<!-- 공백 -->
									</div>
									<!----------------------------------------주소 입력---------------------------------------->

									<div style="justify-items: center" class="col-md-12 form-group p_star">
										<button type="submit" class="button button-contactForm btn_1 boxed-btn" style="width: 100%">회원가입</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</c:if>

		<!----------------------------------------소셜 로그인 회원가입 홈---------------------------------------->
		<c:if test="${status == 'socialJoin' }">
			<section class="checkout_area section_padding">
				<div class="container">
					<div class="comments-area">
						<div class="row">
							<div style="width: 50%; margin: 0 auto">
								<h2>카카오 회원가입</h2>
								<form class="row contact_form" action="/user/join" method="POST" onsubmit="return socialFormAction();" name="joinForm">
									<input type="hidden" name="memberPassword" value="${memberData.memberPassword }">
									<input id="role" type="hidden" name="role" value="USER">
									<input id="advertisementStatus" type="hidden" name="advertisementStatus" value="T">
									<!----------------------------------------이름 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;이름</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="name" name="name" placeholder="이름 입력해주세요" value=${memberData.name } readonly />
									</div>
									<!----------------------------------------이름 입력창---------------------------------------->
									<!----------------------------------------나이 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;생년월일</div>
									<div class="col-md-12 form-group p_star">
										<input type="date" class="form-control" id="age" name="age" placeholder="나이 입력해주세요" value=${memberData.age } readonly />
									</div>
									<!----------------------------------------나이 입력창---------------------------------------->
									<!----------------------------------------아이디 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;아이디</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="loginId" name="loginId" placeholder="아이디 입력" value=${memberData.loginId } readonly />
										<div>
											<font id="id_feedback" size="2"></font>
										</div>
									</div>
									<!----------------------------------------아이디 입력창---------------------------------------->
									<!----------------------------------------닉네임 입력창---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;닉네임</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="nickName" name="nickName" placeholder="닉에미 입력" value=${memberData.nickName } readonly />
									</div>
									<!----------------------------------------닉네임 입력창---------------------------------------->

									<!----------------------------------------폰번호 입력창---------------------------------------->
									<span>&nbsp;&nbsp;&nbsp;휴대폰 번호</span>
									<div class="col-md-12 form-group1 p_star">
										<input type="tel" class="form-control" id="cellPhone" name="cellPhone" placeholder="폰번호 입력" value=${memberData.cellPhone } readonly />
									</div>
									<!----------------------------------------폰번호 입력창---------------------------------------->

									<!----------------------------------------이메일 입력창---------------------------------------->
									<div class="col-md-12 form-group p_star">
										<div>
											<br />이메일
										</div>
										<input type="email" class="form-control" id="email" name="email" placeholder="이메일 입력해주세요" value=${memberData.email } readonly />
									</div>
									<!----------------------------------------이메일 입력창---------------------------------------->
									<!----------------------------------------성별 선택---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;성별</div>
									<div class="col-md-12 form-group p_star">
									<input type=hidden name="gender" value="${memberData.gender}">
										<select id="gender"  class="country_select" disabled>
											<option value="M" ${memberData.gender == 'M' ? 'selected' : ''}>남자</option>
											<option value="F" ${memberData.gender == 'F' ? 'selected' : ''}>여자</option>
										</select>
									</div>
									<!----------------------------------------성별 선택---------------------------------------->
									<!----------------------------------------주소 입력---------------------------------------->
									<div>&nbsp;&nbsp;&nbsp;주소</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="address" name="address" placeholder="주소를 입력해주세요" value="" />
									</div>
									<div>
										&nbsp;&nbsp;&nbsp;<a class="genric-btn info circle" onClick="addressSearch();">주소 찾기</a>
										<div>
											<br />
										</div>
										<!-- 공백 -->
									</div>
									<!----------------------------------------주소 입력---------------------------------------->

									<div style="justify-items: center" class="col-md-12 form-group p_star">
										<button type="submit" class="button button-contactForm btn_1 boxed-btn" style="width: 100%">회원가입</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</c:if>
		<!----------------------------------------소셜 로그인 회원가입 홈---------------------------------------->
	</main>
	<!----------------------------------------푸터---------------------------------------->

	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 회원가입 -->
	<script src="/resources/user/js/join.js"></script>
	<!-- sweetalert -->
	<script src="/resources/common/js/alert.js"></script>
	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>

	<script>
	</script>
</body>
</html>