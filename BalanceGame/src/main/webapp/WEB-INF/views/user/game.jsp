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
      <!--? slider Area Start -->
      <div class="slider-area">
        <div class="slider-active">
          <!-- Single Slider -->
          <div class="single-slider align-items-center slide-bg">
            <div class="container" >
              <div
                style="
                  text-align: center;
                  padding-top: 10vh;
                  padding-bottom: 10vh;
                "
                id="play"
              >
                <div>
                  <div class="hero__caption">
                    <!-- 메인페이지 헤드라인 -->
                    <div id="title">
                    <h1>뭐 드실?</h1>
                    </div>
                    <!-- Hero-btn -->
                    <div class="button-container">
                      <br />
                      <br />
                      <div id="answer_A">
                      <button
                        class="genric-btn primary-border radius e-large game-button answer"
                        type="button"
                        ><span>찹쌀떡</span></button
                      >
                      </div>
                      <div id="answer_B">
                      <button
                        class="genric-btn primary-border radius e-large game-button answer"
                        type="button"
                        ><span>메밀묵</span></button
                      >
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="container click">
                <button
                  class="genric-btn default f-right large"
                  style="font-size: 30px"
                  id ="next"
                >
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
                      <a href="#" class="btn-reply text-uppercase">삭제</a>
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
                      <a href="#" class="btn-reply text-uppercase">삭제</a>
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
                      <a href="#" class="btn-reply text-uppercase">삭제</a>
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
    		location.href = 'gamePage.do';
    	});
    });
    
    </script>
    
    
    <!-- 버튼 클릭 -->
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

    	
    	
    	//$('#play').html('<h2 class="col-12"><br />뭐 드실?</h2><div class="comments-area"><div class="col-12"><div><div><div class="serial">메밀묵</div><div class="percentage" style="width: 80%; display: inline-block"><div class="progress"><div class="progress-bar color-1" role="progressbar" style="width: 20%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div></div></div><div style="display: inline-block">20%</div></div><div style="display: block"><br /></div><div><div class="serial">찹쌀떡</div><div class="percentage" style="width: 80%; display: inline-block"><div class="progress"><div class="progress-bar color-1" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div></div></div><div style="display: inline-block">80%</div></div></div></div></div>');
    	
    	// #play 요소를 찾습니다.
var playElement = document.getElementById("play");

// 내용을 변경합니다.
playElement.innerHTML = `
    <h1 class="col-12"><br />뭐 드실?</h1>
    <div class="comments-area">
        <div class="col-12">
            <div>
                <div>
                    
                    <div class="percentage" style="width: 80%; display: inline-block">
                    <h4 class="serial" style="text-align: left;">메밀묵</h4>
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
                    <h4 class="serial" style="text-align: left;">찹쌀떡</h4>
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
    $("#answer_A").css("width","20%");
    $("#answer_B").css("width","80%");
    
    $("#answer_A_percent").text("20%");
    $("#answer_B_percent").text("80%");
    
}, 100); // 100ms 후에 실행됩니다.

    	//commentAll(qId);

    	
    	/* $(".answer").css("height", "100px");
    	$(".answer").css("line-height", "100px");
    	$(".answer").css("font-size", "30px");
    	$(".answer").css("transition", "1000ms");
    	$(".answer").attr("disabled", true);

    	$("#title h1").css("font-size", "30px");
    	$("#title h1").css("transition", "1000ms");

    	$(".save").css("width", "30px");
    	$(".save").css("height", "30px");
    	$(".save").css("transition", "1000ms");

 */
	$(".click").show();
    });
    </script>
    
  </body>
</html>