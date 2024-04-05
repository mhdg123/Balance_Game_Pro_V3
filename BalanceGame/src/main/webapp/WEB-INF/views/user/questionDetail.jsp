<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>Watch shop | eCommers</title>
<!-- css -->
<script>
        var loginId = "${loginId}";
        var questionId="${questionData.questionId}";
    </script>
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
								<h2>문제 상세페이지</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================ 문제목록 =================-->
		<section>
			<div class="container">


				<!-- 결과 -->
				<div style="height: 80px; margin-top: 40px">
					<!-- 필터 -->
					<div style="display: flex; justify-content: space-between; align-items: center;">
						<a href="/user/questionListPage"><p>< 문제목록</p></a>
						<div class="row f-right" style="display: flex; align-items: center; gap: 10px;">
							<div>필터</div>
							<div class="default-select col-md-3" id="default-select">
								<select>
									<option value="1">전체</option>
									<option value="2">남자</option>
									<option value="3">여자</option>
								</select>
							</div>
						</div>
					</div>

				</div>
				<h2 class="col-12">
					<br />${questionData.title}
					<c:if test="${questionData.wishId > 0}">
						<div style="margin-bottom: 5px;" class="f-right">
							<div style="cursor: pointer;">
								<img src="/resources/assets/img/thumb/fill-hearts.png" height="20px;" width="20px;" style="margin-right: 15px;" class="wish" id="${questionData.questionId}">
							</div>
						</div>
					</c:if>
					<c:if test="${questionData.wishId <= 0}">
						<div style="margin-bottom: 5px;" class="f-right">
							<div style="cursor: pointer;">
								<img src="/resources/assets/img/thumb/empty-hearts.png" height="20px;" width="20px;" style="margin-right: 15px;" class="wish" id="${questionData.questionId}">
							</div>
						</div>
					</c:if>
				</h2>
				<div class="comments-area">
					<div class="col-12">
						<div>
							<!-- 답변A -->
							<div>
								<div class="serial">${questionData.answerA}</div>
								<div class="percentage" style="width: 80%; display: inline-block">
									<div class="progress">
										<div class="progress-bar color-1" id="answer_A" role="progressbar" style="width: 0%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
									</div>
								</div>
								<div id="answer_A_percent" style="display: inline-block">0%</div>
							</div>
							<div style="display: block">
								<br />
							</div>
							<!-- 답변B -->
							<div>
								<div class="serial">${questionData.answerB}</div>
								<div class="percentage" style="width: 80%; display: inline-block">
									<div class="progress">
										<div class="progress-bar color-1" id="answer_B" role="progressbar" style="width: 0%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
									</div>
								</div>
								<div id="answer_B_percent" style="display: inline-block">0%</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Comments -->
				<div class="container">
					<div class="comments-area" id="comments-area">
						<!-- 댓글 입력 Start -->
						<!-- 광고 이미지 -->
						<%@ include file="../layout/advertisement.jsp"%>
						<div class="col-12">
							<div class="form-group">
								<textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="3" placeholder="댓글을 입력하세요"></textarea>
							</div>
							<div class="form-group f-right">
								<button type="submit" id="write" class="genric-btn info-border radius large">댓글 입력</button>
							</div>
						</div>

						<!-- 댓글 입력 End -->
						<br /> <br />
						<br />

						<h4>댓글</h4>
						<div id="comment-box">
							<%-- <c:forEach var="data" items="${commentDatas}" varStatus="loop">
								<div class="comment-list">
									<div>
										<div>
											<div class="desc">
												<div class="d-flex">
													<div class="d-flex align-items-center">
														<h5>
															<a href="#" style="color: black">${data.loginId}</a>
														</h5>
														<p class="date">${data.commentDate}</p>
													</div>
												</div>
												<div>
													<p class="comment">${data.comments}</p>
												</div>
												<!-- 이름 날짜 삭제 -->
												<div class="d-flex justify-content-between">
													<div class="d-flex align-items-center"></div>
													<div class="reply-btn">
														<div class="btn-reply text-uppercase" style="display: inline-block;" onclick="commentWarning(${data.commentId},'${data.loginId}')">신고</div>
														<c:if test="${data.loginId==loginId }">
															<div class="btn-reply text-uppercase" style="display: inline-block;" onclick="commentDelete(${data.commentId})">삭제</div>
														</c:if>
													</div>
												</div>
											</div>
											<hr />
										</div>
									</div>
								</div>
							</c:forEach> --%>
						</div>


						<nav class="blog-pagination justify-content-center d-flex">
							<ul class="pagination">
								
							</ul>
						</nav>
					</div>
				</div>
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


	<!-- 문제 세팅 -->
	<script type="text/javascript">
	   var pageName;
       // 현재 페이지 및 총 페이지 수

	var currentPage = `${page}`;
	var totalPage = `${totalPage}`;
	var questionId=${questionData.questionId};
		$(document).ready(
				function() {
					var answerACount = Number("${questionData.answerACount}");
					var answerBCount = Number("${questionData.answerBCount}");
					var total = answerACount + answerBCount;
					/* 					console.log("answerACount : "+answerACount);
					 console.log("answerBCount : "+answerBCount);
					 console.log("total : "+total); */

					// answerACount와 answerBCount가 0인 경우를 처리합니다.
					var answerAPercentage = total !== 0 ? Math
							.round((answerACount / total) * 100) : 0;
					var answerBPercentage = total !== 0 ? Math
							.round((answerBCount / total) * 100) : 0;

					setTimeout(function() {
						$("#answer_A").css("width", answerAPercentage + "%");
						$("#answer_B").css("width", answerBPercentage + "%");

						$("#answer_A_percent").text(answerAPercentage + "%");
						$("#answer_B_percent").text(answerBPercentage + "%");

					}, 100); // 100ms 후에 실행됩니다.
					
					commentAll();
				});
	</script>
	<!-- 문제 세팅 -->

	<!-- 댓글입력 -->
	<script type="text/javascript">
		$("#write").on("click", function() {

			var comments = $('#comment').val().trim();
			if (loginId == "") {
				console.log("[로그]로그인 x");
				Swal.fire({
					title: "로그인 필요",
					text: "로그인 후 사용가능합니다.",
					icon: "info"
				});
				return;
			}	
			
			if(`${commentStatus}`=='F'){
				Swal.fire({
					title: "정지",
					text: "아이템 구매 후 사용가능합니다.",
					icon: "info"
				});
				return;
			}
			if (!blankSpace()) {
				console.log('댓글 공백');
				$('#comment').val("");
				return;
			}

			$.ajax({
				type : "POST",
				url : "/user/commentWriteAsync",
				data : {
					'questionId' : `${questionData.questionId}`,
					'comments' : comments

				},
				dataType : 'text',
				success : function(data) {
					if (data == "success") {
						$('#comment').val("");
						currentPage=1;
						commentAll();
					}

				},
				error : function(error) {

					console.log('에러발생');
					console.log('에러의 종류:' + error);
				}

			});

		});

		$("#comment").on("keydown", function(e) {
			console.log(e.key);
			if (e.key == 'Enter' || e.key == 'NumpadEnter') {
				console.log("엔터침" + e.key);
				$("#write").click();
			}
		});
	</script>
	<!-- 댓글입력 -->
	<script src="/resources/user/js/blankSpace.js"></script>


	<!-- 찜 하기 스크립트 -->
	<script>
		$(".wish")
				.on(
						"click",
						function() {
							console.log("[성공]");
							var loginId = `${loginId}`;
							//var qId = document.getElementById('qId').value;
							var questionId = $(this).prop('id');
							//var page = document.getElementById('page').value;
							//console.log(loginId);
							console.log(questionId);
							if (loginId == "") {
								console.log("[로그]로그인 x");
								Swal.fire({
									title : "로그인 필요",
									text : "로그인 후 사용가능합니다.",
									icon : "info"
								});
							} else {
								console.log("[로그] 로그인 o");
								//요소 값 가져오기
								//https://luahius.tistory.com/158
								$
										.ajax({
											type : "POST",
											url : "/user/wishAsync",
											data : {
												'questionId' : questionId
											},
											dataType : 'text',
											success : function(data) {
												console.log(data);
												if (data == "실패") {
													console.log("실패");
												} else {
													//console.log($("#" + saveId).attr("class", "fa wish " + "fa-heart") + "<<<<<")
													if (data == "wishOn") {
														$("#" + questionId)
																.attr("src",
																		"/resources/assets/img/thumb/fill-hearts.png");
													} else if (data == "wishOff") {
														$("#" + questionId)
																.attr("src",
																		"/resources/assets/img/thumb/empty-hearts.png");
													}

													/* 						if (data == "찜x.png" && page == "wishPage") {
																				location.reload();
																			} */
												}

												//document.getElementById(".save").src="images/찜o.png";
											},
											error : function(error) {
												console.log('에러발생');
												console.log('에러의 종류:' + error);
											}

										});
							}
						});
		
	</script>
	<script src="/resources/user/js/currentAsyncPage.js"></script>
	<!-- 페이징 js -->
	<!-- 찜 하기 스크립트 -->
	<script src="/resources/user/js/commentAll.js"></script>
		

</body>
</html>