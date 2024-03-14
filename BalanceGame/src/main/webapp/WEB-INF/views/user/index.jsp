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

    <script src="/resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="/resources/assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="/resources/assets/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/slick.min.js"></script>

    <!-- One Page, Animated-HeadLin -->
    <script src="/resources/assets/js/wow.min.js"></script>
    <script src="/resources/assets/js/animated.headline.js"></script>
    <script src="/resources/assets/js/jquery.magnific-popup.js"></script>

    <!-- Scrollup, nice-select, sticky -->
    <script src="/resources/assets/js/jquery.scrollUp.min.js"></script>
    <script src="/resources/assets/js/jquery.nice-select.min.js"></script>
    <script src="/resources/assets/js/jquery.sticky.js"></script>

    <!-- contact js -->
    <script src="/resources/assets/js/contact.js"></script>
    <script src="/resources/assets/js/jquery.form.js"></script>
    <script src="/resources/assets/js/jquery.validate.min.js"></script>
    <script src="/resources/assets/js/mail-script.js"></script>
    <script src="/resources/assets/js/jquery.ajaxchimp.min.js"></script>

    <!-- Jquery Plugins, main Jquery -->
    <script src="/resources/assets/js/plugins.js"></script>
    <script src="/resources/assets/js/main.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
      async function test() {
        const { value: text } = await Swal.fire({
          title:
            "<div class='f-left'><h1>안녕하세요</h1><p class='f-left'>관리자</p></div>",
          html: `
          <div class='' style="height:100px; width:100%;border: 1px solid rgb(200,200,200)">집에 보내 주세요 </div>
          `,
          showCloseButton: true,
        });
      }
    </script>

    <!-- 메시지박스 -->
    <script>
      document.addEventListener("click", function (event) {
        var dropdown = document.getElementById("dropdown");
        var dropdownOptions = document.getElementById("dropdown-options");
        var targetElement = event.target; // 클릭된 요소

        // 클릭된 요소가 드롭다운 메뉴 내부에 속하지 않은 경우에만 메뉴를 닫습니다.
        if (!dropdown.contains(targetElement)) {
          dropdownOptions.style.display = "none";
        }
      });

      document
        .getElementById("dropdown-btn")
        .addEventListener("click", function (event) {
          event.stopPropagation(); // 클릭 이벤트가 부모로 전파되는 것을 막습니다.
          var dropdownOptions = document.getElementById("dropdown-options");
          if (dropdownOptions.style.display === "block") {
            dropdownOptions.style.display = "none";
          } else {
            dropdownOptions.style.display = "block";
          }
        });
    </script>
  </body>
</html>
