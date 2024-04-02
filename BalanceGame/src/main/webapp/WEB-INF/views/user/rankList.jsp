<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>랭킹</title>
<!-- css -->

</head>

<body>
	<!-- 헤너 네비 바 -->
	<%@ include file="../layout/header.jsp"%>
	<!-- 헤너 네비 바 -->
	>
	<main>
		<!-- Hero Area Start-->
		<div class="slider-area ">
			<div class="single-slider slider-height2 d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="hero-cap text-center">
								<h2>랭킹</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================ 랭킹 =================-->
		<section class="cart_area section_padding">
			<div class="container">
				<div class="cart_inner">

					<!-- 내 찜보기 필터 토글 버튼 -->

					<!-- 추가 -->
					<div class="container">
						<div class="cart_inner">
							<div class="table-responsive">
								<table class="table" style="width: 100%">
									<thead>
										<tr>
											<th scope="col" style="width: 5%">NO</th>
											<th scope="col" style="width: 50%">이름</th>
											<th scope="col" style="width: 25%">Point</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="data" items="${memberDatas}" varStatus="loop">
										<tr>
											<td>
												<p>${data.ranking}</p>
											</td>
											<td>
												<p>${data.nickName}</p>
											</td>
											<td>
												<p>${data.total}p</p>
											</td>
										</tr>
										</c:forEach>
										


									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

		</section>
		<nav class="blog-pagination justify-content-center d-flex">
			<ul class="pagination">
				<li class="page-item"><a onclick="beforeData();"
					class="page-link" aria-label="Previous"> <i
						class="ti-angle-left"></i>
				</a></li>
				<li class="page-item"><a href="#" class="page-link">1</a></li>
				<li class="page-item active"><a href="#" class="page-link">2</a>
				</li>
				<li class="page-item"><a onclick="nextData();"
					class="page-link" aria-label="Next"> <i class="ti-angle-right"></i>
				</a></li>
			</ul>
		</nav>
		<!--================ 랭킹 =================-->
	</main>
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

	<!-- JS here -->

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- 푸터 고정 스크립트 공통 모음 -->
<!-- 페이징 js -->
	<script type="text/javascript">
	var currentPage = ${page};
	var totalPage = ${totalPage};
	document.addEventListener('DOMContentLoaded', function() {
	    // 페이지 업데이트 실행
	    pageName='rankListPage';
	    updatePagination();
	});
	</script>
	<script src="/resources/user/js/currentPage.js"></script>
	<!-- 페이징 js -->
</body>
</html>