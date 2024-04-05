<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
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
		<input type="hidden" id="loginId" value="${loginId }">
		<div class="slider-area">
			<div class="slider-active">
				<!-- Single Slider -->
				<div class="single-slider align-items-center slide-bg">
					<div class="container">

						<div id="play" style="text-align: center; padding-top: 10vh; padding-bottom: 10vh;">
							<div>
								<div class="hero__caption">
									<!-- 메인페이지 헤드라인 -->
									<div id="title">
										<h2 style="display: inline-block; margin-right: 10px;">${questionData.title}</h2>

									</div>

									<!-- Hero-btn -->
									<div class="button-container">
										<br /> <br />

										<button id="answer_A" class="genric-btn primary-border radius e-large game-button answer" type="button" value="A">
											<c:if test="${not empty questionData.answerAImg }">
												<img style="width: 100%; max-width: 200px; height: 200px" src="/resources/upload/${questionData.answerAImg }" />
											</c:if>
											${questionData.answerA}
										</button>

										<button id="answer_B" class="genric-btn primary-border radius e-large game-button answer" type="button" value="B">
											<c:if test="${not empty questionData.answerBImg }">
												<img style="width: 100%; max-width: 200px; height: 200px" src="/resources/upload/${questionData.answerBImg }" />
											</c:if>${questionData.answerB}</button>

									</div>
								</div>
							</div>
						</div>

						<div class="container">
							<c:if test="${questionData.wishId <= 0}">
								<h2 style="color: #ff2020;" class="fa ti-heart wish" id="${questionData.questionId}"></h2>
								<!-- ti-heart 빈 하트 -->
							</c:if>
							<c:if test="${questionData.wishId > 0}">
								<h2 style="color: #ff2020;" class="fa fa-heart wish" id="${questionData.questionId}"></h2>
								<!-- fa-heart 꽉 찬 하트 -->
							</c:if>

							<button class="genric-btn default f-right large click" style="font-size: 30px;" id="next">Next ></button>
						</div>

					</div>

				</div>
				<!-- Single Slider -->
			</div>
			<!-- 광고 이미지 -->
			<%@ include file="../layout/advertisement.jsp"%>
		</div>

		<!-- Comments -->
		<div class="container click">
			<div class="comments-area" id="comments-area">
				<!-- 댓글 입력 Start -->
				<div class="col-12">
					<div class="form-group" id="comment-insert-box">
						<textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="3" placeholder="댓글을 입력하세요"></textarea>
					</div>
					<div class="form-group f-right">
						<button type="submit" id="write" class="genric-btn info-border radius large">댓글 입력</button>
					</div>
				</div>

				<!-- 댓글 입력 End -->
				<br /> <br /> <br />
				<h4>댓글</h4>
				<div id="comment-box"></div>








				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						
					</ul>
				</nav>
			</div>
		</div>
	</main>
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->


	<!-- JS here -->

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- 푸터 고정 스크립트 공통 모음 -->


	<!-- 게임 세팅 -->
	<script type="text/javascript">	
	   var pageName;
       // 현재 페이지 및 총 페이지 수

	var currentPage = `${page}`;
	var totalPage = `${totalPage}`;
	var questionId=${questionData.questionId};
    $(document).ready(function() {
    	$(".click").hide();

    	$("#next").on("click", function() {
    		location.href = '/user/gamePage';
    	});
    });
    
    </script>


	<!-- 답변 버튼 클릭 -->
	<script type="text/javascript">
    
    $(".answer").on("click", function() {
    	
    	//var qId = document.getElementById('qId').value;
    	//var loginId = document.getElementById('loginId').value;
    	var answerValue = $(this).prop('value');
    	//로그인 아이디,질문 pk 로그
    	console.log("답변클릭 "+ $(this).prop("value"));
    	//console.log(loginId);
    	console.log("${questionData.questionId}");
    	
    	//totalAnswer(qId, loginId, answerValue);
		var answerACount;
		var answerBCount;
    	
        $.ajax({
            type: "POST",
            url: "/user/answerAsync",
            data: {
                'questionId': `${questionData.questionId}`,
                //'loginId': `${loginId}`
                'answer': answerValue
            },
            dataType: 'json',
            success: function(data) {
                console.log(data.answerACount);
                console.log(data.answerBCount);
                var total = data.answerACount + data.answerBCount;
                console.log(total);
                answerACount=Math.round(((data.answerACount * 1.0) / total) * 100);
                answerBCount=Math.round(((data.answerBCount * 1.0) / total) * 100);
            },
            error: function(error) {
                console.log('에러발생');
                console.log('에러의 종류:' + error);
            }
        });
    	
    	
    	
    	//$('#play').html('<h2 class="col-12"><br />뭐 드실?</h2><div class="comments-area"><div class="col-12"><div><div><div class="serial">메밀묵</div><div class="percentage" style="width: 80%; display: inline-block"><div class="progress"><div class="progress-bar color-1" role="progressbar" style="width: 20%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div></div></div><div style="display: inline-block">20%</div></div><div style="display: block"><br /></div><div><div class="serial">찹쌀떡</div><div class="percentage" style="width: 80%; display: inline-block"><div class="progress"><div class="progress-bar color-1" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div></div></div><div style="display: inline-block">80%</div></div></div></div></div>');
    	
    	// #play 요소를 찾습니다.
var playElement = document.getElementById("play");

// 내용을 변경합니다.
playElement.innerHTML = `
    <h1 class="col-12"><br />${questionData.title}</h1>
    <div class="comments-area">
        <div class="col-12">
            <div>
                <div>
                    
                    <div class="percentage" style="width: 80%; display: inline-block">
                    <h4 class="serial" style="text-align: left;">${questionData.answerA}</h4>
                        <div class="progress">
                            <div class="progress-bar color-1" id="answer_A" role="progressbar" style="width: 0%" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <div id="answer_A_percent" style="display: inline-block">0%</div>
                </div>
                <div style="display: block"><br /></div>
                <!-- 답변B -->
                <div>
                    
                    <div class="percentage" style="width: 80%; display: inline-block">
                    <h4 class="serial" style="text-align: left;">${questionData.answerB}</h4>
                        <div class="progress">
                            <div class="progress-bar color-1" id="answer_B" role="progressbar" style="width: 0%" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                    <div id="answer_B_percent" style="display: inline-block">0%</div>
                </div>
            </div>
        </div>
    </div>`;
    
	setTimeout(function() {
	    $("#answer_A").css("width",answerACount+"%");
	    $("#answer_B").css("width",answerBCount+"%");
	    
	    $("#answer_A_percent").text(answerACount+"%");
	    $("#answer_B_percent").text(answerBCount+"%");
    
}, 100); // 100ms 후에 실행됩니다.

    	commentAll();

	$(".click").show();
    });
    </script>


	<!-- 찜 클릭 -->

	<script type="text/javascript">
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
							$("#" + questionId).attr("class", "fa fa-heart wish");
						}
						else if(data=="wishOff"){
							$("#" + questionId).attr("class", "fa ti-heart wish");
						}
						
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
	<!-- 찜 클릭 -->

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
					title: "댓글 정지",
					text: "아이템 구매 후 사용가능합니다.",
					icon: "info"
				});
				return;
			}
			
			if(!blankSpace()){
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
					console.log(data);
					$('#comment').val("");
					currentPage=1;
					commentAll();
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
	
	


	<script src="/resources/user/js/currentAsyncPage.js"></script>
	<!-- 페이징 js -->
	

	<script src="/resources/user/js/commentAll.js"></script>
	<script src="/resources/user/js/blankSpace.js"></script>



</body>
</html>