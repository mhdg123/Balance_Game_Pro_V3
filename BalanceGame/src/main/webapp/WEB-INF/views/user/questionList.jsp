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
							<a href="/user/makeQuestionPage" class="genric-btn info radius"
								style="margin-right: 12px;">문제 제출</a>
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
										<c:set var="startIndex" value="${(page-1)*10}" />
										<c:forEach var="data" items="${questionDatas}"
											varStatus="loop">
											<tr>
												<td
													onClick="location.href='questionDetailPage?questionId=${data.questionId}'">
													<p>${startIndex + loop.index + 1}</p>
												</td>
												<!-- loop.index는 0부터 시작하므로 +1을 해서 순번을 출력합니다. -->
												<td class="qTitle"
													onClick="location.href='questionDetailPage?questionId=${data.questionId}'"><p>${data.title}</p></td>
												<td class="qTitle"
													onClick="location.href='questionDetailPage?questionId=${data.questionId}'"><p>${data.questionDate}</p></td>
												<td class="qTitle"
													onClick="location.href='questionDetailPage?questionId=${data.questionId}'"><p>${data.likeCount}</p></td>
												<td><input id="qId" type="hidden"
													value="${data.questionId}" /> <c:if
														test="${data.wishId > 0}">
														<div style="margin-bottom: 5px;">
															<div style="cursor: pointer;">
																<img src="/resources/assets/img/thumb/fill-hearts.png"
																	height="20px;" width="20px;"
																	style="margin-right: 15px;" class="wish"
																	id="${data.questionId}">
															</div>
														</div>
													</c:if> <c:if test="${data.wishId <= 0}">
														<div style="margin-bottom: 5px;">
															<div style="cursor: pointer;">
																<img src="/resources/assets/img/thumb/empty-hearts.png"
																	height="20px;" width="20px;"
																	style="margin-right: 15px;" class="wish"
																	id="${data.questionId}">
															</div>
														</div>
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>



								</table>
								<c:if test="${fn:length(questionDatas) <= 0 }">

									<div>출제된 문제가 없습니다.</div>

								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>

		</section>

		<!-- 추가 -->

		<nav class="blog-pagination justify-content-center d-flex">
			<ul class="pagination">
				
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
	<!-- 찜 하기 스크립트 -->
	<script>
	
	console.log("얀여"+`${totalPage}`);
	
	   $(".wish").on("click", function() {
			console.log("[성공]");
			var loginId =`${loginId}`;
			//var qId = document.getElementById('qId').value;
			var questionId = $(this).prop('id');
			//var page = document.getElementById('page').value;
			//console.log(loginId);
			console.log(questionId);
			if (loginId == "") {
				console.log("[로그]로그인 x");
				Swal.fire({
					title: "로그인 필요",
					text: "로그인 후 사용가능합니다.",
					icon: "info"
				});
			} else {
				console.log("[로그] 로그인 o");
				//요소 값 가져오기
				//https://luahius.tistory.com/158
				$.ajax({
					type: "POST",
					url: "/user/wishAsync",
					data: {
						'questionId': questionId
					},
					dataType: 'text',
					success: function(data) {
						console.log(data);
						if (data == "실패") {
							console.log("실패");
						} 
						else {
							//console.log($("#" + saveId).attr("class", "fa wish " + "fa-heart") + "<<<<<")
							if(data=="wishOn"){
								$("#" + questionId).attr("src", "/resources/assets/img/thumb/fill-hearts.png");
							}
							else if(data=="wishOff"){
								$("#" + questionId).attr("src", "/resources/assets/img/thumb/empty-hearts.png");
							}
							location.reload();
	/* 						if (data == "찜x.png" && page == "wishPage") {
								location.reload();
							} */
						}

						//document.getElementById(".save").src="images/찜o.png";
					},
					error: function(error) {
						console.log('에러발생');
						console.log('에러의 종류:' + error);
					}

				});
			}
		});

	</script>
<!-- 페이징 js -->
	<script type="text/javascript">
	var currentPage = ${page};
	var totalPage = ${totalPage};
	document.addEventListener('DOMContentLoaded', function() {
	    // 페이지 업데이트 실행
	    pageName='questionListPage';
	    updatePagination();
	});
	</script>
	<script src="/resources/user/js/currentPage.js"></script>
	<!-- 페이징 js -->
</body>

</html>