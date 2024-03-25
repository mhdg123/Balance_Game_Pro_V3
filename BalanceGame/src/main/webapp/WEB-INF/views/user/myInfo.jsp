<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>Watch shop | eCommers</title>
<!-- css -->
<style type="text/css">
    .item-element {
        height: 28px;
    }
    .item-element button {
        display: none;
    }
    .item-element:hover {
        background-color: #f2f2f2; /* 마우스 호버 시 회색 배경색 지정 */
    }
    .item-element:hover button {
        display: block;
    }
</style>
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
								<h2>마이페이지</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================Checkout Area =================-->
		<section class="confirmation_part section_padding">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-lx-4">
						<h4>회원 정보</h4>
						<div
							class="single_confirmation_details shadow p-3 mb-5 bg-body rounded"
							style="overflow-y: auto; height: 400px;">

							<ul>
								<li>
									<p>이름</p> <span>: ${memberData.name}</span>
								</li>
								<li>
									<p>닉네임</p> <span>: ${memberData.nickName}</span>
								</li>
								<li>
									<p>이메일</p> <span>: ${memberData.email}</span>
								</li>
								<li>
									<p>전화번호</p> <span>: ${memberData.cellPhone}</span>
								</li>
								<li>
									<p>주소</p> <span>: ${memberData.address}</span>
								</li>
								<li>
									<p>생년월일</p> <span>: ${memberData.age}</span>
								</li>
								<li>
									<p>성별</p> <span>: ${memberData.gender}</span>
								</li>
								<li>
									<p>가입일</p> <span>: ${memberData.memberDate}</span>
								</li>
							</ul>
							<br>
							<h4>사용중인 아이템</h4>
							<ul>
								<li>
									<p>광고제거</p> <span>&nbsp</span>
								</li>
								<li>
									<p>광고제거</p> <span>&nbsp</span>
								</li>
								<li>
									<p>광고제거</p> <span>&nbsp</span>
								</li>
							</ul>

						</div>
						<a href="javascript:changeInfo();"
							class="genric-btn primary radius change-ck-button f-right">
							정보 변경 </a>
					</div>



					<!-- 아이템 -->

					<div class="col-lg-6 col-lx-4">
						<h4>아이템</h4>
						<div class="shadow p-3 mb-5 bg-body rounded"
							style="overflow-y: auto; height: 400px;">
							<ul>
								<c:choose>
									<c:when test="${fn:length(memberItemDatas) > 0}">
										<c:forEach var="data" items="${memberItemDatas}">
											<li class="item-element">
												<div >
													<img src="assets/img/comment/comment_3.png" alt=""> <span>
														&nbsp;&nbsp;${data.itemName}</span>
													<button type="button" class="genric-btn primary radius change-ck-button f-right small">사용</button>
												</div>
											</li>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<li>아이템이 없습니다.</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- 해당 유저 댓글 -->
		<div class="container">
			<div class="comments-area">


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
												<c:if test="${data.loginId==loginId }">
											<div class="btn-reply text-uppercase"
												style="display: inline-block;" onclick="commentDelete(${data.commentId})">삭제</div>
												</c:if>
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
	<script>
    // 이름 & 이메일로 아이디 찾기
    async function changeInfo() {
        const { value: formValues } = await Swal.fire({
    title: "2차 인증",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="비밀번호">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const memberPassword = document.getElementById("swal-input1").value;

		$.ajax({
			type: "POST",
			url: "/user/myInfoPasswordCheckAsync",
			data: {
				'memberPassword': memberPassword
			},
			dataType: 'text',
			success: function(data) {
				console.log(data);
				if (data == "success") {
					console.log("성공");
					location.href ="/user/myPageUpdatePageController";
				}else{
					Swal.fire("비밀번호 확인해주세요");
				}
			},
			error: function(error) {
				console.log('에러발생');
				console.log('에러의 종류:' + error);
			}

		});
      
    
      
    }
  });

     }



    </script>
	<script src="/resources/user/js/commentAll.js"></script>

</body>
</html>