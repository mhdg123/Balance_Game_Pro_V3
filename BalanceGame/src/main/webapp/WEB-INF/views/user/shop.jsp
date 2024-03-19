<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String name = "테스트";
String email = "asdf@naver.com";
String phone = "010-1234-1234";
String address = "서울";
int totalPrice = 10;
%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<!-- 카카오페이 -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<title>Watch shop | eCommers</title>
<!-- css -->

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
								<h2>상점</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Hero Area End-->
		<!-- Latest Products Start -->
		<section class="popular-items latest-padding">
			<div class="container">
				<div class="row product-btn justify-content-between mb-40">
					<div class="properties__button">
						<!--Nav Button  -->
						<nav>
							<div class="nav nav-tabs" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"> 아이템 </a> <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"> 포인트 </a>
							</div>
						</nav>
						<!--End Nav Button  -->
					</div>
					<!-- Grid and List view -->
					<div class="grid-list-view"></div>
					<!-- Select items -->
				</div>
				<!-- Nav Card -->
				<div class="tab-content" id="nav-tabContent">
					<input type="hidden" value="${itemData.loginId }" id="loginData">
					<!-- 아이템 구매 탭 버튼 -->
					<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
						<div class="row">
							<!-- 아이템 탭 1번 아이템 -->
							<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="/resources/assets/img/gallery/popular1.png" alt="">
										<div class="img-cap">
											<a href="#"><span>구매하기</span></a>
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="#">${itemData.itemName }</a>
										</h3>
										<!--  -->
										<span>${itemData.itemPrice }원</span>
									</div>
								</div>
							</div>
							<!-- 아이템 탭 1번 아이템 -->

							<!-- 아이템 탭 2번 아이템 -->
						<!-- 	<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="/resources/assets/img/gallery/popular2.png" alt="">
										<div class="img-cap">
											<a href="#"><span>구매하기</span></a>
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="#">광고제거</a>
										</h3>
										<span>1000원</span>
									</div>
								</div>
							</div> -->
							<!-- 아이템 탭 2번 아이템 -->

							<!-- 아이템 탭 3번 아이템 -->
						<!-- 	<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="/resources/assets/img/gallery/popular2.png" alt="">
										<div class="img-cap">
											<a href="#"><span>구매하기</span></a>
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="#">랜덤박스</a>
										</h3>
										<span>1000원</span>
									</div>
								</div>
							</div> -->
							<!-- 아이템 탭 3번 아이템 -->
						</div>
					</div>
					<!-- 아이템 구매 탭 버튼 -->

					<!-- 포인트 구매 탭 버튼 -->
					<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
						<div class="row">
							<!-- 포인트 탭 1번 포인트  -->
							<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<!-- 반복문 돌리기 -->
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="/resources/assets/img/gallery/popular2.png" alt="">
										<!-- 포인트 충전 이미지 url -->
										<div class="img-cap">
											<a href="javascript:itemBuy(1, '1000원 충전', 1000);"><span>구매하기</span></a>
											<!-- 조회시 데이터 넣기 -->
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="javascript:itemBuy(1, '1000원 충전', 1000);">1001 &nbspPoint</a>
											<!-- 조회시 데이터 넣기 -->
										</h3>
										<span>1000원</span>
									</div>
								</div>
							</div>
							<!-- 반복문 돌리기 -->
							<!-- 포인트 탭 1번 포인트  -->
							<!-- 포인트 탭 2번 포인트  -->
							<!-- <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<div class="single-popular-items mb-50 text-center">
									<div class="popular-img">
										<img src="/resources/assets/img/gallery/popular2.png" alt="">
										<div class="img-cap">
											<a href="#"><span>구매하기</span></a>
										</div>
									</div>
									<div class="popular-caption">
										<h3>
											<a href="#">1000&nbspPoint</a>
										</h3>
										<span>10000원</span>
									</div>
								</div>
							</div> -->
							<!-- 포인트 탭 2번 포인트  -->
						</div>
					</div>
					<!-- 포인트 구매 탭 버튼 -->
				</div>
			</div>
		</section>
		<!-- Latest Products End -->
		<!--? Shop Method Start-->
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
		<a href="/user/loginPage"> ㄱㄱㄱㄱㄱ</a> <a onclick="itemBuy(1,'asdf',30000);">sssss</a>
	</main>
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

	<!-- JS here -->
	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<script src="/resources/common/js/alert.js"></script>

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<script>
	function itemBuy(itemId, itemName, itemPrice) { // 결제할 포인트 아이템 pk, 포인트 아이템 이름, 아이템 가격
		alert(itemId +"" + itemName + "" + itemPrice)
	    var IMP = window.IMP;
	    var loginId = 'testId'; // 로그인 아이디
	    var everythings_fine = true;
	    IMP.init('imp77111714'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	    var msg;

	    IMP.request_pay({
	        pg: 'kakaopay',
	        pay_method: 'card',
	        merchant_uid: 'merchant_' + new Date().getTime(),
	        name: (itemPrice * 0.1) + ' 포인트 충전하기', // 충전 금액의 10% 포인트
	        loginId: loginId, // 로그인 아이디
	        itemId: itemId, // 아이템 PK
	        itemName : itemName, // 아이템 이름
	        amount: itemPrice, // 상품 가격
	        
	    }, function(rsp) {
	        if (rsp.success) {
	            jQuery.ajax({
	                url: "/async/payment",
	                type: 'POST',
	                dataType: 'json',
	                data: {
	                    imp_uid: rsp.imp_uid,
	                    loginId: loginId, // 로그인 아이디
	                    itemId: itemId, // 아이템 PK
	                    itemName : itemName, // 아이템 이름
	                    amount: itemPrice // 상품 가격
	                }
	            }).done(function(data) {
	                // 성공 메시지를 받은 후 처리
	                if(data.status == "success") {
	                	redirectToSuccessPage("결제완료")
	                }else {
	                	redirectToFailPage("결제 실패");
	                }
	                
	            }).fail(function(jqXHR, textStatus, errorThrown) {
	                console.error("AJAX request failed: ", textStatus, errorThrown);
	            });
	        } else {
	            // msg = '결제에 실패하였습니다.';
	             redirectToFailPage(msg);
	        }
	    });

	    // 성공 페이지로 이동하는 함수
	     var decodedMsg; // 컨트롤러에 데이터넘길때 인코딩메세지를 디코딩 해줘야 함
	     function redirectToSuccessPage(msg) {
	    	 decodedMsg = decodeURIComponent(msg)
	         // location.href = 'alert.do?msg=' + msg + '&status=success&redirect=main.do'; 
	        Swal.fire({
	             title: "감사합니다!",
	             text: msg,
	             // imageUrl: "images/thankyou.gif",
	             imageWidth: 360,
	             imageHeight: 360,
	             imageAlt: "Custom image"
	         }).then((result) => {
	             if (result.isConfirmed) {
	                 // 확인 버튼이 눌렸을 때 실행할 코드
	                 // location.href='/alert/' + decodedMsg + '/success/' + 'main' ; // 파라미터 포함 메인 페이지 이동
	                   location.href='/' ; //  메인 페이지 이동
	             }
	         });
	     }

	    // 실패 페이지로 이동하는 함수
	     function redirectToFailPage(msg) {
	    	 decodedMsg = decodeURIComponent(msg) // 컨트롤러에 데이터넘길때 인코딩메세지를 디코딩 해줘야 함
	         location.href = '/' ;
	     }
	}
</script>
</body>
</html>