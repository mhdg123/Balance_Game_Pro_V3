<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>Watch shop | eCommers</title>
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
								<h2>문제출제</h2>
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
						<div style="width: 50%; margin: 0 auto">
							<h2>문제 출제</h2>
							<form class="row contact_form" action="/user/makeQuestion"
								method="post" novalidate="novalidate" enctype="multipart/form-data">
								<!----------------------------------------문제 제목 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp제목</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="title" name="title"
										placeholder="제목 입력해주세요" />
								</div>
								<!----------------------------------------문제 제목 입력창---------------------------------------->
								<!----------------------------------------답변_A 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp답변_A</div>
								<div class="image-show" id="chooseFileAInput"></div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="answerA"
										name="answerA" placeholder="답변_A 입력해주세요" />
									<!-- 이미지 A 등록 input태그 -->	
									<input type="file" accept="image/*" name="file" id="chooseFileA" onchange="loadFile(this)"/>
								</div>
								<!----------------------------------------답변_A 입력창---------------------------------------->
								<!----------------------------------------답변_B 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp답변_B</div>
								<div class="image-show" id="chooseFileBInput"></div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="answerB"
										name="answerB" placeholder="답변_B 입력" />
										<!-- 이미지 B 등록 input태그 -->	
										<input type="file" accept="image/*" name="file" id="chooseFileB" onchange="loadFile(this)"/>
								</div>
								<!----------------------------------------답변_B 입력창---------------------------------------->
								<!----------------------------------------출제 이유 입력창---------------------------------------->
								<div>&nbsp&nbsp&nbsp&nbsp출제 이유</div>
								<div class="col-md-12 form-group p_star">
									<input type="text" class="form-control" id="explanation"
										name="explanation" placeholder="출제 이유 입력" />
								</div>
								<!----------------------------------------출제 이유 입력창---------------------------------------->
								<div style="justify-items: center"
									class="col-md-12 form-group p_star">
									<button type="submit"
										class="button button-contactForm btn_1 boxed-btn"
										style="width: 100%">문제 출제하기</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!----------------------------------------필요시 살리기---------------------------------------->
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
	
	
	<!-- input 태그 사진 넣는 js  -->
    <script src="/resources/user/js/image.js"></script>                    
	
	
	
</body>
</html>