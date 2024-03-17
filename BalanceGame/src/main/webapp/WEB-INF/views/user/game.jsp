<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
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
                                <h1 style="display: inline-block; margin-right: 10px;">${data.title}</h1>
                                
                            </div>
                            
                            <!-- Hero-btn -->
                            <div class="button-container">
                                <br />
                                <br />
                                <div id="answer_A">
                                    <button class="genric-btn primary-border radius e-large game-button answer" type="button">
                                        <span>${data.answerA}</span>
                                    </button>
                                </div>
                                <div id="answer_B">
                                    <button class="genric-btn primary-border radius e-large game-button answer" type="button">
                                        <span>${data.answerB}</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container">
                	<c:if test="${data.likeID <= 0}">
						<h2 style="color: #ff2020;" class="fa ti-heart wish" id="1"></h2> <!-- ti-heart 빈 하트 -->
					</c:if>
					<c:if test="${data.likeID > 0}">
						<h2 style="color: #ff2020;" class="fa fa-heart wish"  id="1"></h2> <!-- fa-heart 꽉 찬 하트 -->
					</c:if>
                
                    <button class="genric-btn default f-right large click" style="font-size: 30px;" id="next">
                        Next >
                    </button>
                </div>
            </div>
        </div>
        <!-- Single Slider -->
    </div>
</div>

      <!-- Comments -->
      <div class="container click" >
        <div class="comments-area">
          <!-- 댓글 입력 Start -->
          <div class="col-12">
            <div class="form-group">
              <textarea
                class="form-control w-100"
                name="comment"
                id="comment"
                cols="30"
                rows="3"
                placeholder="댓글을 입력하세요"
              ></textarea>
            </div>
            <div class="form-group f-right">
              <button type="submit" class="genric-btn info-border radius large">
                댓글 입력
              </button>
            </div>
          </div>

          <!-- 댓글 입력 End -->
          <br /><br /><br />
          <h4>댓글</h4>

          <div class="comment-list">
            <div>
              <div>
                <div class="desc">
                  <div class="d-flex">
                    <div class="d-flex align-items-center">
                      <h5>
                        <a href="#" style="color: black">쿠리만쥬</a>
                      </h5>
                      <p class="date">December 4, 2017 at 3:12 pm</p>
                    </div>
                  </div>
                  <div>
                    <p class="comment">
                      밤만쥬에서 모티브를 얻은 듯한 수달 캐릭터로 초기 낙서
                      작업물에서부터 꽤 일찍 등장했다. 밤만쥬를 안주로 술을
                      마시는 것이 본격적인 첫 등장.
                    </p>
                  </div>
                  <!-- 이름 날짜 삭제 -->
                  <div class="d-flex justify-content-between">
                    <div class="d-flex align-items-center"></div>
                    <div class="reply-btn">
                      <div class="btn-reply text-uppercase" style="display: inline-block;">신고</div>
                      <div class="btn-reply text-uppercase" style="display: inline-block;">삭제</div>
                    </div>
                  </div>
                </div>
                <hr />
              </div>
            </div>
          </div>

          <div class="comment-list">
            <div>
              <div>
                <div class="desc">
                  <div class="d-flex">
                    <div class="d-flex align-items-center">
                      <h5>
                        <a href="#" style="color: black">하치와레</a>
                      </h5>
                      <p class="date">December 4, 2017 at 3:12 pm</p>
                    </div>
                  </div>
                  <div>
                    <p class="comment">
                      주요 캐릭터 3인방이며 서브 주인공 격 캐릭터다. 주인공
                      치이카와의 단짝친구 중 한 명. 치이카와와 함께 책을 읽으며
                      말하던 것이 첫 등장.
                    </p>
                  </div>
                  <!-- 이름 날짜 삭제 -->
                  <div class="d-flex justify-content-between">
                    <div class="d-flex align-items-center"></div>
                    <div class="reply-btn">
                      <div class="btn-reply text-uppercase" style="display: inline-block;">신고</div>
                      <div class="btn-reply text-uppercase" style="display: inline-block;">삭제</div>
                    </div>
                  </div>
                </div>
                <hr />
              </div>
            </div>
          </div>

          <div class="comment-list">
            <div>
              <div>
                <div class="desc">
                  <div class="d-flex">
                    <div class="d-flex align-items-center">
                      <h5>
                        <a href="#" style="color: black">모몽가</a>
                      </h5>
                      <p class="date">December 4, 2017 at 3:12 pm</p>
                    </div>
                  </div>
                  <div class="d-flex">
                    <p class="comment">
                      주요 캐릭터 3인방이며 서브 주인공 격 캐릭터다. 주인공
                      치이카와의 단짝친구 중 한 명. 치이카와와 함께 책을 읽으며
                      말하던 것이 첫 등장.
                    </p>
                  </div>
                  <!-- 이름 날짜 삭제 -->
                  <div class="d-flex justify-content-between">
                    <div class="d-flex align-items-center"></div>
                    <div class="reply-btn">
                      <div class="btn-reply text-uppercase" style="display: inline-block;">신고</div>
                      <div class="btn-reply text-uppercase" style="display: inline-block;">삭제</div>
                    </div>
                  </div>
                </div>
                <hr />
              </div>
            </div>
          </div>
          <nav class="blog-pagination justify-content-center d-flex">
            <ul class="pagination">
              <li class="page-item">
                <a href="#" class="page-link" aria-label="Previous">
                  <i class="ti-angle-left"></i>
                </a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link">1</a>
              </li>
              <li class="page-item active">
                <a href="#" class="page-link">2</a>
              </li>
              <li class="page-item">
                <a href="#" class="page-link" aria-label="Next">
                  <i class="ti-angle-right"></i>
                </a>
              </li>
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
    	
/*     	var qId = document.getElementById('qId').value;
    	var loginId = document.getElementById('loginId').value;
    	var answerValue = $(this).prop('value'); */
    	//로그인 아이디,질문 pk 로그
    	/*console.log($(this).prop("value"));
    	console.log(loginId);
    	console.log(qId);*/
    	
    	//totalAnswer(qId, loginId, answerValue);
		var answerACount;
		var answerBCount;
    	
        $.ajax({
            type: "POST",
            url: "/user/answerAsync",
            data: {
                //'qId': qId,
                //'loginId': `${loginId}`
                //'answer': answerValue
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
    <h1 class="col-12"><br />${data.title}</h1>
    <div class="comments-area">
        <div class="col-12">
            <div>
                <div>
                    
                    <div class="percentage" style="width: 80%; display: inline-block">
                    <h4 class="serial" style="text-align: left;">${data.answerA}</h4>
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
                    <h4 class="serial" style="text-align: left;">${data.answerB}</h4>
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

    	//commentAll(qId);


	$(".click").show();
    });
    </script>
    
    
    <!-- 찜 클릭 -->
    
   <script type="text/javascript">
   $(".wish").on("click", function() {
		console.log("[성공]");
		var loginId =`${loginId}`;
		//var qId = document.getElementById('qId').value;
		var saveId = $(this).prop('questionId');
		//var page = document.getElementById('page').value;
		console.log(loginId);
		console.log(saveId);
		if (loginId == null) {
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
					'loginId': loginId,
					'qId': saveId
				},
				dataType: 'text',
				success: function(data) {
					console.log(data);
					if (data == "실패") {
						console.log("실패");
					} else {
						//console.log($("#" + saveId).attr("class", "fa wish " + "fa-heart") + "<<<<<")
						$("#" + saveId).attr("class", "fa wish " + data);
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
    
    
    
    
    
    
  </body>
</html>