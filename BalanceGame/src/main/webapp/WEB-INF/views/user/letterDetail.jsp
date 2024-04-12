<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>BalanceGame | Jarvis</title>
<!-- css -->

</head>

<body>
	<!-- 헤너 네비 바 -->
	<%@ include file="../layout/header.jsp"%>
	<!-- 헤너 네비 바 -->
	<main>
		<!-- Hero Area Start-->

		<!--================ 문제목록 =================-->
		<section>
			<div class="container" style="min-height:600px">
	

				<!-- 결과 -->
				<div style="height: 80px;margin-top: 40px">
							<!-- 필터 -->
				<div
					style="display: flex; justify-content: space-between; align-items: center;">
					<a href="/user/letterListPage"><p>< 우편목록</p></a>

				</div>
				
				</div>
				<h2 class="col-12">
					<br />${letterData.title}
					
				</h2>
				<br>
				<p class="col-12">보낸사람&nbsp&nbsp   ${letterData.sender}</p>
				<p class="col-12">받는사람&nbsp&nbsp   ${letterData.loginId}</p>
				<p class="col-12">${letterData.letterDate}</p>
				
				<div class="comments-area">
					<div class="col-12">
						<div>
							${letterData.letterContents}
						</div>
					</div>
				</div>
				<hr>
			</div>
			
		</section>
		<!--================ 문제목록 =================-->
	</main>
	
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

	<!-- JS here -->

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- 푸터 고정 스크립트 공통 모음 -->


	




</body>
</html>