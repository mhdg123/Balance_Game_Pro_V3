<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
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


	<!-- 문제 세팅 -->
	<script type="text/javascript">
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
				});
	</script>
	<!-- 문제 세팅 -->

	<!-- 댓글입력 -->
	<script type="text/javascript">
		$("#write").on("click", function() {

			var comments = $('#comment').val().trim();

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
						location.reload();
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
	<!-- 찜 하기 스크립트 -->


</body>
</html>