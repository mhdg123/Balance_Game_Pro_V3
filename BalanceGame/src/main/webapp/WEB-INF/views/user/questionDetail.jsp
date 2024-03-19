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
				<!-- 필터 -->
				<div class="row f-right"
					style="padding-top: 10px; display: flex; align-items: center; gap: 10px;">
					<div>필터</div>
					<div class="default-select col-md-3" id="default-select">
						<select>
							<option value="1">전체</option>
							<option value="2">남자</option>
							<option value="3">여자</option>
						</select>
					</div>
				</div>

				<!-- 결과 -->
				<div style="height: 80px"></div>
				<h2 class="col-12">
					<br />${questionData.title}</h2>
				<div class="comments-area">
					<div class="col-12">
						<div>
							<!-- 답변A -->
							<div>
								<div class="serial">${questionData.answerA}</div>
								<div class="percentage"
									style="width: 80%; display: inline-block">
									<div class="progress">
										<div class="progress-bar color-1" id="answer_A"
											role="progressbar" style="width: 0%" aria-valuenow="80"
											aria-valuemin="0" aria-valuemax="100"></div>
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
								<div class="percentage"
									style="width: 80%; display: inline-block">
									<div class="progress">
										<div class="progress-bar color-1" id="answer_B"
											role="progressbar" style="width: 0%" aria-valuenow="80"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
								</div>
								<div id="answer_B_percent" style="display: inline-block">0%</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Comments -->
				<div class="container">
					<div class="comments-area">
						<!-- 댓글 입력 Start -->
						<div class="col-12">
							<div class="form-group">
								<textarea class="form-control w-100" name="comment" id="comment"
									cols="30" rows="3" placeholder="댓글을 입력하세요"></textarea>
							</div>
							<div class="form-group f-right">
								<button type="submit"
									class="genric-btn info-border radius large">
									댓글 입력</button>
							</div>
						</div>

						<!-- 댓글 입력 End -->
						<br />
						<br />
						<br />
						<h4>댓글</h4>
						<c:forEach var="data" items="${commentDatas}" varStatus="loop">
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
													<div class="btn-reply text-uppercase"
														style="display: inline-block;">신고</div>
													<div class="btn-reply text-uppercase"
														style="display: inline-block;">삭제</div>
												</div>
											</div>
										</div>
										<hr />
									</div>
								</div>
							</div>
						</c:forEach>



						<nav class="blog-pagination justify-content-center d-flex">
							<ul class="pagination">
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Previous"> <i class="ti-angle-left"></i>
								</a></li>
								<li class="page-item"><a href="#" class="page-link">1</a></li>
								<li class="page-item active"><a href="#" class="page-link">2</a>
								</li>
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Next"> <i class="ti-angle-right"></i>
								</a></li>
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
		$(document).ready(
				function() {
					var answerACount = Math
							.round(((data.answerACount * 1.0) / total) * 100);
					var answerBCount = Math
							.round(((data.answerBCount * 1.0) / total) * 100);

					setTimeout(function() {
						$("#answer_A").css("width", answerACount + "%");
						$("#answer_B").css("width", answerBCount + "%");

						$("#answer_A_percent").text(answerACount + "%");
						$("#answer_B_percent").text(answerBCount + "%");

					}, 100); // 100ms 후에 실행됩니다.
				});
	</script>
	<!-- 문제 세팅 -->

</body>
</html>