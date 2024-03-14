<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
          <div
            class="single-slider slider-height d-flex align-items-center slide-bg"
          >
            <div class="container">
              <div class="row justify-content align-items-center">
                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-8">
                  <div class="hero__caption">
                    <!-- 메인페이지 헤드라인 -->
                    <h1
                      data-animation="fadeInLeft"
                      data-delay=".4s"
                      data-duration="2000ms"
                    >
                      밸런스 게임
                    </h1>
                    <p
                      data-animation="fadeInLeft"
                      data-delay=".7s"
                      data-duration="2000ms"
                    >
                      Balance Game
                    </p>
                    <!-- Hero-btn -->
                    <div
                      class="hero__btn"
                      data-animation="fadeInLeft"
                      data-delay=".8s"
                      data-duration="2000ms"
                    >
                      <a href="game.html" class="btn hero-btn">게임하기</a>
                      <a href="login.html" class="btn hero-btn">로그인하기</a>
                    </div>
                  </div>
                </div>
                <div
                  class="col-xl-3 col-lg-3 col-md-4 col-sm-4 d-none d-sm-block"
                >
                  <div
                    class="hero__img"
                    data-animation="bounceIn"
                    data-delay=".4s"
                  >
                    <img
                      src="/resources/assets/img/jarvis/jarvis_logo.png"
                      alt=""
                      class="heartbeat"
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Single Slider -->
        </div>
      </div>
      <!-- Watch Choice  End-->
    </main>
	<!-- 메인 페이지 푸터 -->
    <%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->


    <!-- JS here -->

    <!-- 푸터 고정 스크립트 공통 모음 -->    
    <%@ include file="../layout/footer-fix.jsp"%>
    <!-- 푸터 고정 스크립트 공통 모음 -->  
 
  </body>
</html>
