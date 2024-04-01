<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>Watch shop | eCommers</title>
<!-- css -->
<!-- SweetAlert2 CSS -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10"> -->
<!-- SweetAlert2 JS -->
<!-- <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script> -->
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
								<h2>정보변경</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================Checkout Area =================-->
		<section class="checkout_area section_padding">
			<div class="container">


				<div class="comments-area">
					<div class="row">
						<div style="width: 50%; margin: 0 auto;">
							<h2>변경</h2>
							<form class="row contact_form" action="/user/myInfoChangePage"
								method="post" name="joinForm" novalidate="novalidate">
								<!----------------------------------------이름 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp이름</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="name" name="name"
										value="${memberData.name}" disabled />
								</div>
								<!----------------------------------------이름 입력창---------------------------------------->

								<!----------------------------------------아이디 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp아이디</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="loginId"
										name="loginId" value="${memberData.loginId}" disabled />
								</div>
								<!----------------------------------------아이디 입력창---------------------------------------->
								<!----------------------------------------닉네임 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp닉네임</div>
								<!-- 버튼옆으로 -->
								<div class="col-md-12 form-group p_star input-button-container">
									<input type="text" class="form-control input-field"
										id="nikeName" name="nikeName" value="${memberData.nickName}"
										disabled />
									<button type="button"
										class="genric-btn primary radius change-ck-button"
										id="couponButton">쿠폰사용</button>
								</div>
								<!----------------------------------------닉네임 입력창---------------------------------------->
								<!----------------------------------------폰번호 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp휴대폰 번호</div>
								<div class="col-md-12 form-group1 p_star input-button-container">
									<input type="tel"
										class="form-control ${memberData.loginType != 'SOCIAL' ? 'input-field' : ''}"
										id="cellPhone" name="cellPhone"
										value="${memberData.cellPhone}"
										${memberData.loginType == 'SOCIAL' ? 'disabled' : ''} />
									<button class="genric-btn primary radius change-ck-button"
										${memberData.loginType == 'SOCIAL' ? 'style="display:none;"' : ''}>문자발송</button>
								</div>

								<!----------------------------------------폰번호 입력창---------------------------------------->

								<!----------------------------------------이메일 입력창---------------------------------------->

								<div>
									<br> &nbsp&nbsp&nbsp&nbsp이메일
								</div>
								<div class="col-md-12 form-group p_star input-button-container">
									<input type="email"
										class="form-control ${memberData.loginType != 'SOCIAL' ? 'input-field' : ''}"
										id="email" name="email" value="${memberData.email}"
										${memberData.loginType == 'SOCIAL' ? 'disabled' : ''} />
									<button class="genric-btn primary radius change-ck-button"
										${memberData.loginType == 'SOCIAL' ? 'style="display:none;"' : ''}>이메일
										인증</button>
								</div>
								<!----------------------------------------이메일 입력창---------------------------------------->
								<!----------------------------------------나이 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp생년월일</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="age" name="age"
										value="${memberData.age}" disabled />
								</div>
								<!----------------------------------------나이 입력창---------------------------------------->
								<!----------------------------------------성별 선택---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp성별</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="gender"
										name="gender" value="${memberData.gender}" disabled />
								</div>
								<!----------------------------------------성별 선택---------------------------------------->
								<!----------------------------------------주소 입력---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp주소</div>
								<div class="col-md-12 form-group p_star input-button-container">
									<input type="text" class="form-control input-field"
										id="address" name="address" value="${memberData.address}" />
									<button type="button"
										class="genric-btn primary radius change-ck-button"
										onClick="addressSearch();">주소찾기</button>
								</div>

								<!----------------------------------------주소 입력---------------------------------------->
								<div style="justify-items: center;"
									class="col-md-12 form-group p_star">
									<button type="submit"
										class="button button-contactForm btn_1 boxed-btn"
										style="width: 100%;">변경</button>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</section>
		<!--================End Checkout Area =================-->
	</main>

	<!----------------------------------------푸터---------------------------------------->
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

	<!-- JS here -->

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- 푸터 고정 스크립트 공통 모음 -->

	<script>
		var genderElement = document.getElementById('gender');
		if (genderElement.value === 'M') {
			genderElement.value = '남';
		} else if (genderElement.value === 'F') {
			genderElement.value = '여';
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#couponButton').click(function() {
				console.log("닉네임 변경 시도");
				$.ajax({
					type : "POST",
					url : "/user/nameChangeCouponAsync",
					data : {
						'itemId':1
					},
					dataType : 'text',
					success : function(data) {
						if(data=='success'){
							
							Swal.fire({
		                        icon: 'success',
		                        title: '닉네임 변경이 가능합니다',
		                        showConfirmButton: true // 확인 버튼을 보여줍니다.
		                    });
						$('#nikeName').prop('disabled', false); // 닉네임 입력 필드를 활성화합니다.
						}
						else {
							
							// 스위트 알림으로 '쿠폰이 없습니다' 메시지를 표시합니다.
							Swal.fire({
		                        icon: 'error',
		                        title: '쿠폰이 없습니다',
		                        showConfirmButton: true // 확인 버튼을 보여줍니다.
		                    });
						}
					},
					error : function(error) {
						console.log('에러발생');
						console.log('에러의 종류:' + error);
					}
				});
			});
		});
	</script>



	<!-- 회원가입 -->
	<script src="/resources/user/js/join.js"></script>
</body>
</html>