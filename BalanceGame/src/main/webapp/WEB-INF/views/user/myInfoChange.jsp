<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>BalanceGame | Jarvis</title>
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
						<div style="width: 50%; min-width:360px;  margin: 0 auto;">
							<h2>변경</h2>
							<form class="row contact_form" action="/user/myInfoChangePage"
								method="post" onsubmit="return myjoinFormAction();"
								name="joinForm" novalidate="novalidate">
								<!----------------------------------------이름 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp이름</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="name" name="name"
										value="${memberData.name}" readonly required />
								</div>
								<!----------------------------------------이름 입력창---------------------------------------->

								<!----------------------------------------아이디 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp아이디</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="loginId"
										name="loginId" value="${memberData.loginId}" readonly required />
								</div>
								<!----------------------------------------아이디 입력창---------------------------------------->
								<!----------------------------------------닉네임 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp닉네임</div>
								<!-- 버튼옆으로 -->
								<div class="col-md-12 form-group p_star input-button-container">
									<input type="text" class="form-control input-field"
										id="nickName" name="nickName" value="${memberData.nickName}"
										readonly required />
									<button type="button"
										class="genric-btn primary radius change-ck-button"
										id="couponButton">쿠폰사용</button>
								</div>
								<!----------------------------------------닉네임 입력창---------------------------------------->
								<!----------------------------------------폰번호 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp휴대폰 번호</div>
								<div class="col-md-12 form-group1 p_star input-button-container">
									<input type="tel" class="form-control" id="cellPhone"
										name="cellPhone" value="${memberData.cellPhone}"
										${memberData.loginType == 'SOCIAL' ? 'readonly' : ''} required />
									<button type="button" id="sendNum"
										class="genric-btn primary radius change-ck-button"
										style="display: none;">인증번호 발송</button>
								</div>

								<!-- 번호 인증하기 -->
								<div id="certificationDiv"
									class="col-md-12 form-group1 p_star input-button-container"
									style="display: none;">
									<input type="text" class="form-control"
										id="certification" name="certification" placeholder="인증번호 입력"
										required />
									<button type="button" onclick="myAuthNumCheck()" 
										class="genric-btn primary radius change-ck-button">인증번호 확인</button>
								</div>

								<!----------------------------------------폰번호 입력창---------------------------------------->

								<!----------------------------------------이메일 입력창---------------------------------------->

								<div>
									<br> &nbsp&nbsp&nbsp&nbsp이메일
								</div>
								<div class="col-md-12 form-group p_star input-button-container">
									<input type="email" class="form-control" id="email"
										name="email" required value="${memberData.email}"
										${memberData.loginType == 'SOCIAL' ? 'readonly' : ''} />
									<button type="button" id="emailCode"
										class="genric-btn primary radius change-ck-button"
										style="display: none;">이메일 인증</button>
								</div>
								<!-- 인증하기 -->

								<div id="emailCheckDiv"
									class="col-md-12 form-group1 p_star input-button-container"
									style="display: none;">
									<input type="text" class="form-control"
										id="emailCheck" required name="emailCheck"
										placeholder="인증번호 입력" />
									<button type="button" onclick="emailCodeCheck()"
										class="genric-btn primary radius change-ck-button">인증번호확인</button>
								</div>

								<!----------------------------------------이메일 입력창---------------------------------------->
								<!----------------------------------------나이 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp생년월일</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="age" name="age"
										required value="${memberData.age}" readonly />
								</div>
								<!----------------------------------------나이 입력창---------------------------------------->
								<!----------------------------------------성별 선택---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp성별</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="gender" required
										name="gender" value="${memberData.gender}" readonly />
								</div>
								<!----------------------------------------성별 선택---------------------------------------->
								<!----------------------------------------주소 입력---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp주소</div>
								<div class="col-md-12 form-group p_star input-button-container">
									<input type="text" class="form-control input-field" required
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
		var cellPhone = ${memberData.cellPhone};
		var email = `${memberData.email}`;
		var myAuthStatus = 1;
		var emailCodeStatus = 1;
		$(document).ready(function() {
			
			// 휴대폰 번호 input 요소의 값이 변경될 때마다 스크립트 함수 호출
			$('#cellPhone').on('input', function() {
				var changedPhone = $(this).val();
				// 변경 발생 시 실행할 스크립트 함수 호출
				// 예를 들어, 휴대폰 번호가 변경될 때 특정 동작을 수행하도록 설정할 수 있습니다.
				console.log(changedPhone);
				if (cellPhone != changedPhone) {
					console.log('휴대폰 번호가 변경되었습니다.');
					myAuthStatus = 0;
					//$('#certificationDiv').show(); // 변경되면 버튼 보이기
					$(this).addClass('input-field'); // input-field 클래스 추가
					$('#sendNum').show();
				} else {
					console.log('같은 휴대폰 번호');
					myAuthStatus = 1;
					//$('#certificationDiv').hide(); // 같으면 버튼 숨기기
					$(this).removeClass('input-field'); // input-field 클래스 제거
					$('#sendNum').hide();
				}
			});

			// 이메일 input 요소의 값이 변경될 때마다 스크립트 함수 호출
			$('#email').on('input', function() {
				var changedEmail = $(this).val();
				// 변경 발생 시 실행할 스크립트 함수 호출
				// 예를 들어, 이메일이 변경될 때 특정 동작을 수행하도록 설정할 수 있습니다.
				if (email != changedEmail) {
					console.log('이메일이 변경되었습니다.');
					emailCodeStatus = 0;
					//$('#emailCheckDiv').show(); // 변경되면 버튼 보이기
					$(this).addClass('input-field'); // input-field 클래스 추가
					$('#emailCode').show();
				} else {
					console.log('같은 이메일');
					emailCodeStatus = 1;
					//$('#emailCheckDiv').hide(); // 같으면 버튼 숨기기
					$(this).removeClass('input-field'); // input-field 클래스 제거
					$('#emailCode').hide();
				}
			});
			$('#couponButton').click(function() {
				console.log("닉네임 변경 시도");
				$.ajax({
					type : "POST",
					url : "/user/nameChangeCouponAsync",
					data : {
						'itemId' : 1
					},
					dataType : 'text',
					success : function(data) {
						if (data == 'success') {

							Swal.fire({
								icon : 'success',
								title : '닉네임 변경이 가능합니다',
								showConfirmButton : true
							// 확인 버튼을 보여줍니다.
							});
							// 닉네임 입력 필드의 readonly 속성 해제
							$('#nickName').prop('readonly', false);
						} else {

							// 스위트 알림으로 '쿠폰이 없습니다' 메시지를 표시합니다.
							Swal.fire({
								icon : 'error',
								title : '쿠폰이 없습니다',
								showConfirmButton : true
							// 확인 버튼을 보여줍니다.
							});
						}
					},
					error : function(error) {
						console.log('에러발생');
						console.log('에러의 종류:' + error);
					}
				});
			});
			
			$(document).on('click', '#sendNum', function() {
				// 인증번호 발송 로직 구현
				myAuthStatus = 0;
				// 발송 후 번호 인증하기 부분을 보이도록 변경
				document.getElementById("certificationDiv").style.display = "block";

				sendAuthNum();
			});
		});
	</script>
	<script type="text/javascript">
		var randomCode;

		$(document).on('click', '#emailCode', function() {
			emailCodeStatus = 0;
			document.getElementById("emailCheckDiv").style.display = "block";
			var emailInput = document.getElementById("email");
			var email = emailInput.value;

			console.log(email);
			$.ajax({
				type : "POST",
				url : "/user/isEmailCodeCorrect",
				data : {
					"email" : email
				},
				dataType : 'text',
				success : function(data) {
					randomCode = data;
					console.log(randomCode);
				},
				error : function(error) {
					console.log('에러발생');
					console.log('에러의 종류:' + error);
				}
			});

		});
		function emailCodeCheck() {
			var userCode = document.getElementById("emailCheck").value;
			console.log(userCode);
			if (randomCode == userCode) {
				Swal.fire({
					icon : 'success',
					title : '이메일 확인이 완료되었습니다',
					showConfirmButton : true
				// 확인 버튼을 보여줍니다.
				});
				$('#email').prop('readonly', true);
				emailCodeStatus = 1;
			} else {
				Swal.fire({
					icon : 'error',
					title : '다시 확인해주세요',
					showConfirmButton : true
				// 확인 버튼을 보여줍니다.
				});
			}

		}
	</script>
	<script>
		
	</script>


	<!-- 회원가입 -->
	<script src="/resources/user/js/join.js"></script>
</body>
</html>