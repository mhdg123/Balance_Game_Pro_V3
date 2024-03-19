<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zxx">
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>Watch shop | eCommers</title>
<!-- css -->
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
								<h2>문제목록</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================ 문제목록 =================-->
		<section class="cart_area section_padding">
			<div class="container">
				<div class="cart_inner">

					<div class="table-responsive">
						<div class="d-flex align-items-center justify-content-between">
							<!-- 내 찜보기 필터 토글 버튼 -->
							<button class="genric-btn info radius"
								style="margin-right: 12px;">문제 제출</button>
							<div class="switch-wrap d-flex align-items-center">
								<p style="margin-right: 6px; margin-bottom: 0;">내 찜보기</p>
								<div class="primary-switch">
									<input type="checkbox" id="default-switch" /> <label
										for="default-switch"></label>
								</div>
							</div>
						</div>
					</div>

					<!-- 내 찜보기 필터 토글 버튼 -->

					<!-- 추가 -->
					<div class="container">
						<div class="cart_inner">
							<div class="table-responsive">
								<table class="table" style="width: 100%">

									<thead>
										<tr>
											<th scope="col" style="width: 5%">NO</th>
											<th scope="col" style="width: 50%">제목</th>
											<th scope="col" style="width: 25%">등록일</th>
											<th scope="col" style="width: 15%">찜개수</th>
											<th scope="col" style="width: 5%">찜</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${fn:length(questionDatas) <= 0 }">
											<tr>
												<td colspan="1">출제된 문제가 없습니다.</td>
											</tr>
										</c:if>
										<c:forEach var="data" items="${questionDatas}" varStatus="loop">
											<tr>
												<td
													onClick="location.href='questionDetailPage?questionId=${data.questionId}&writer=${loginId}'"><p>${loop.index + 1}</p></td>
												<!-- loop.index는 0부터 시작하므로 +1을 해서 순번을 출력합니다. -->
												<td class="qTitle"
													onClick="location.href='questionDetailPage?questionId=${data.questionId}&writer=${loginId}'"><p>${data.title}</p></td>
												<td class="qTitle"
													onClick="location.href='questionDetailPage?questionId=${data.questionId}&writer=${loginId}'"><p>${data.questionDate}</p></td>
												<td class="qTitle"
													onClick="location.href='questionDetailPage?questionId=${data.questionId}&writer=${loginId}'"><p>${data.likeCount}</p></td>
												<td><input id="qId" type="hidden" value="${data.questionId}" />
													<c:if test="${data.wishId > 0}">
														<div style="margin-bottom: 5px;">
															<div style="cursor: pointer;" onclick="test();"><img
																src="assets/img/thumb/fill-hearts.png" height="20px;"
																width="20px;" style="margin-right: 15px;"></div>
														</div>
													</c:if> <c:if test="${data.wishId <= 0}">
														<div style="margin-bottom: 5px;">
															<div style="cursor: pointer;" onclick="test();"><img
																src="assets/img/thumb/empty-hearts.png" height="20px;"
																width="20px;" style="margin-right: 15px;"></div>
														</div>
													</c:if>
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

		<!-- 추가 -->

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
		<!--================ 문제목록 =================-->
	</main>
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

	<!-- JS here -->

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- 푸터 고정 스크립트 공통 모음 -->
	<script>
		function test() {
			alert("좋아요 누름");
		}

		function test1() {
			alert("문제 상세페이지 이동");
		}
		function nextData() {
			alert("다음 페이지");
		}

		function beforeData() {
			alert("이전 페이지 ");
		}
	</script>
</body>

</html>