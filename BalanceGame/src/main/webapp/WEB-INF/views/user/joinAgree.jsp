<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<%@ include file="../layout/header-fix.jsp"%>
<title>약관동의</title>
<style>
.about-details-cap {
	border: 2px solid black; /* 원하는 선의 두께와 색상으로 수정하세요 */
}
</style>
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
								<h2>약관동의</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Hero Area End-->
		<!-- About Details Start -->
		<div class="about-details section-padding30">
			<div class="container">
				<div class="row">
					<h1>약관동의</h1>
					<!-- 약관동의 시작 -->
					<div class="offset-xl-1 col-lg-8">
						<div class="about-details-cap mb-10" style="max-height: 300px; overflow-y: auto;">
							<!-- <h4>약관동의</h4> -->
							<p>Risus commodo viverra sebfd do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse gravida. Risus commodo viverra sebfd do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
						<input type="checkbox" id="optionalCheckbox">
						<label for="optionalCheckbox">선택</label>
						<div class="about-details-cap mt-50 mb-10" style="max-height: 300px; overflow-y: auto;">
							<!-- <h4>약관동의</h4> -->
							<p>Risus commodo viverra sebfd do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse gravida. Risus commodo viverra sebfd do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
						<input type="checkbox" id="requiredCheckbox">
						<label for="requiredCheckbox">필수</label>
						<div class="form-group mt-3 text-center">
							<button type="submit" class="button button-contactForm boxed-btn" id="join" onclick="redirectToMain()" disabled>다음</button>
							<input type="checkbox" id="selectAllCheckbox">
							<label for="selectAllCheckbox">전체 선택</label>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 약관동의 끝 -->
		<div class="shop-method-area">
			<div class="container">
				<div class="method-wrapper">
					<div class="row d-flex justify-content-between">
						<div class="col-xl-4 col-lg-4 col-md-6">
							<div class="single-method mb-40">
								<i class="ti-package"></i>
								<h6>Free Shipping Method</h6>
								<p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
							</div>
						</div>
						<div class="col-xl-4 col-lg-4 col-md-6">
							<div class="single-method mb-40">
								<i class="ti-unlock"></i>
								<h6>Secure Payment System</h6>
								<p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
							</div>
						</div>
						<div class="col-xl-4 col-lg-4 col-md-6">
							<div class="single-method mb-40">
								<i class="ti-reload"></i>
								<h6>Secure Payment System</h6>
								<p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- Shop Method End-->
	</main>
	<footer>
		<!-- Footer Start-->
		<div class="footer-area footer-padding">
			<div class="container">
				<div class="row d-flex justify-content-between">
					<div class="col-xl-3 col-lg-3 col-md-5 col-sm-6">
						<div class="single-footer-caption mb-50">
							<div class="single-footer-caption mb-30">
								<!-- logo -->
								<div class="footer-logo">
									<a href="index.html"><img src="/resources/assets/img/logo/logo2_footer.png" alt=""></a>
								</div>
								<div class="footer-tittle">
									<div class="footer-pera">
										<p>Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-2 col-lg-3 col-md-3 col-sm-5">
						<div class="single-footer-caption mb-50">
							<div class="footer-tittle">
								<h4>Quick Links</h4>
								<ul>
									<li><a href="#">About</a></li>
									<li><a href="#"> Offers & Discounts</a></li>
									<li><a href="#"> Get Coupon</a></li>
									<li><a href="#"> Contact Us</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-3 col-md-4 col-sm-7">
						<div class="single-footer-caption mb-50">
							<div class="footer-tittle">
								<h4>New Products</h4>
								<ul>
									<li><a href="#">Woman Cloth</a></li>
									<li><a href="#">Fashion Accessories</a></li>
									<li><a href="#"> Man Accessories</a></li>
									<li><a href="#"> Rubber made Toys</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-3 col-md-5 col-sm-7">
						<div class="single-footer-caption mb-50">
							<div class="footer-tittle">
								<h4>Support</h4>
								<ul>
									<li><a href="#">Frequently Asked Questions</a></li>
									<li><a href="#">Terms & Conditions</a></li>
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Report a Payment Issue</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- Footer bottom -->
				<div class="row align-items-center">
					<div class="col-xl-7 col-lg-8 col-md-7">
						<div class="footer-copy-right">
							<p>
								Copyright ©2020 All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com/">Colorlib</a>
							</p>
						</div>
					</div>
					<div class="col-xl-5 col-lg-4 col-md-5">
						<div class="footer-copy-right f-right">
							<!-- social -->
							<div class="footer-social">
								<a href="#"><i class="fab fa-twitter"></i></a> <a href="https://www.facebook.com/sai4ull"><i class="fab fa-facebook-f"></i></a> <a href="#"><i class="fab fa-behance"></i></a> <a href="#"><i class="fas fa-globe"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- <script>
        // "전체 선택" 체크박스를 클릭했을 때 모든 체크박스를 선택하거나 해제하는 함수
        function toggleAllCheckboxes() {
            var checkboxes = document.querySelectorAll('input[type="checkbox"]');
            var selectAllCheckbox = document.querySelector('#selectAllCheckbox');

            checkboxes.forEach(function(checkbox) {
                if (checkbox !== selectAllCheckbox) {
                    checkbox.checked = selectAllCheckbox.checked;
                }
            });

            // 전체 선택 체크박스가 체크되면 필수와 선택 체크박스 모두 체크되도록 함
            var requiredCheckbox = document.querySelector('input[type="checkbox"][id="requiredCheckbox"]');
            var optionalCheckbox = document.querySelector('input[type="checkbox"][id="optionalCheckbox"]');
            requiredCheckbox.checked = selectAllCheckbox.checked;
            optionalCheckbox.checked = selectAllCheckbox.checked;

            // 다음 버튼 상태 업데이트
            validateNextButton();
        }

        // "다음" 버튼을 클릭했을 때 필수 항목이 모두 선택되어 있는지 확인하는 함수
        function validateNextButton() {
            var requiredCheckbox = document.querySelector('input[type="checkbox"][id="requiredCheckbox"]');
            var nextButton = document.querySelector('.button-contactForm');

            if (requiredCheckbox.checked) {
                nextButton.disabled = false; // 필수 항목이 체크되어 있으면 다음 버튼 활성화
            } else {
                nextButton.disabled = true; // 필수 항목이 체크되어 있지 않으면 다음 버튼 비활성화
            }
        }

        // 전체 선택 체크박스에 이벤트 리스너 추가
        document.querySelector('#selectAllCheckbox').addEventListener('click', toggleAllCheckboxes);

        // 필수 및 선택 체크박스에 이벤트 리스너 추가
        var requiredCheckbox = document.querySelector('input[type="checkbox"][id="requiredCheckbox"]');
        var optionalCheckbox = document.querySelector('input[type="checkbox"][id="optionalCheckbox"]');
        requiredCheckbox.addEventListener('click', validateNextButton);
        optionalCheckbox.addEventListener('click', validateNextButton);

        // 페이지 로드 시 초기 다음 버튼 상태 확인
        window.onload = validateNextButton;
    </script> -->


	<script>
		$(document).ready(
				function() {
					// "전체 선택" 체크박스를 클릭했을 때 모든 체크박스를 선택하거나 해제하는 함수
					function toggleAllCheckboxes() {
						var checkboxes = $('input[type="checkbox"]');
						var selectAllCheckbox = $('#selectAllCheckbox');

						if (selectAllCheckbox.prop('checked')) {
							// 모든 체크박스 선택
							checkboxes.each(function() {
								if ($(this).attr('id') !== selectAllCheckbox
										.attr('id')) {
									$(this).prop('checked', true);
								}
							});
						} else {
							// 모든 체크박스 해제
							checkboxes.each(function() {
								if ($(this).attr('id') !== selectAllCheckbox
										.attr('id')) {
									$(this).prop('checked', false);
								}
							});
						}
					}

					// "다음" 버튼을 클릭했을 때 필수 항목이 모두 선택되어 있는지 확인하는 함수
					function validateNextButton() {
						var requiredCheckbox = $('#requiredCheckbox'); // 필수 선택 체크
						var nextButton = $('.button-contactForm');

						if (requiredCheckbox.prop('checked')) {
							nextButton.prop('disabled', false); // 필수 항목이 체크되어 있으면 다음 버튼 활성화
						} else {
							nextButton.prop('disabled', true); // 필수 항목이 체크되어 있지 않으면 다음 버튼 비활성화
							 alert("필수 항목을 선택하세요!"); // 필수 선택이 안 된 경우 경고 메시지 표시 
						}
					}

					// 페이지 로드 시 초기 다음 버튼 비활성화

					function msg() {
						if (requiredCheckbox.prop('checked')) {
							nextButton.prop('disabled', false); // 필수 항목이 체크되어 있지 않으면 다음 버튼 활성화
							alert("ffffff")
						}
					}

					// 필수 및 선택 체크박스에 이벤트 리스너 추가
					$('#requiredCheckbox').on('click', validateNextButton);
					$('#optionalCheckbox').on('click', validateNextButton);

					// 전체 선택 체크박스에 이벤트 리스너 추가
					$('#selectAllCheckbox').on('click', toggleAllCheckboxes);
					$('#selectAllCheckbox').on('click', validateNextButton);

					// 다음 버튼을 클릭했을 때 /main 페이지로 이동하는 함수
					$('#join').on(
							'click',
							function() {
								validateNextButton();
								/*  if (!$('#requiredCheckbox').prop('checked'))) {
								msg(); // '/main' 페이지로 이동
								  }  */
								if ($('#requiredCheckbox').prop('checked')) {
									window.location.href = "/user/joinPage"; // '/main' 페이지로 이동
								}
								if ($('#requiredCheckbox').prop('checked')
										&& $('#optionalCheckbox').prop(
												'checked')) {
									window.location.href = "/user/joinPage"; // '/main' 페이지로 이동
								}

							});
				});
	</script>

</body>
</html>