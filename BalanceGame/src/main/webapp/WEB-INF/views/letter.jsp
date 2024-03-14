<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
  <head>
 <!-- css -->
    <%@ include file="layout/header-fix.jsp"%>
    <title>Watch shop | eCommers</title>
<!-- css -->
    <style>
      .ck-editor__editable {
        height: 400px;
      }
      .ck-content {
        font-size: 12px;
      }
    </style>
  </head>

  <body>
        <!-- 헤너 네비 바 -->
    <%@ include file="layout/header.jsp"%>
    <!-- 헤너 네비 바 -->
    <main>
      <!-- Hero Area Start-->
      <div class="slider-area">
        <div class="single-slider slider-height2 d-flex align-items-center">
          <div class="container">
            <div class="row">
              <div class="col-xl-12">
                <div class="hero-cap text-center">
                  <h2>건의하기</h2>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <section class="confirmation_part section_padding">
        <div class="container" style="margin: 0 auto">
          <h1>건의하기</h1>
          <form action="" method="POST">
            <textarea name="text" id="editor"></textarea>
            <p>
              <br />
              <input
                type="submit"
                value="전송"
                class="genric-btn primary radius f-right"
              />
            </p>
          </form>
        </div>
      </section>
      <!--================End Checkout Area =================-->
    </main>

    <!----------------------------------------푸터---------------------------------------->
    <footer>
      <!-- Footer Start-->
      <br />
      <br />
      <div class="footer-area footer-padding">
        <div class="container">
          <div class="row d-flex justify-content-between">
            <div class="col-xl-3 col-lg-3 col-md-5 col-sm-6">
              <div class="single-footer-caption mb-50">
                <div class="single-footer-caption mb-30">
                  <!-- logo -->
                  <div class="footer-logo">
                    <a href="index.html"
                      ><img
                        style="width: 90%"
                        src="assets/img/jarvis/logotext.png"
                        alt=""
                    /></a>
                  </div>
                  <div class="footer-tittle">
                    <div class="footer-pera">
                      <p>밸런스 게임</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-2 col-lg-3 col-md-3 col-sm-5">
              <div class="single-footer-caption mb-50">
                <div class="footer-tittle">
                  <h4>Quick Blog Links</h4>
                  <ul>
                    <li><a href="#">📗 박찬우 Blog</a></li>
                    <li><a href="#">📘 박현구 Blog</a></li>
                    <li><a href="#">📙 전은주 Blog</a></li>
                    <li><a href="#">📕 조지훈 Blog</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-lg-3 col-md-4 col-sm-7">
              <div class="single-footer-caption mb-50">
                <div class="footer-tittle">
                  <h4>Cooperation</h4>
                  <ul>
                    <li>
                      <a href="#"
                        ><img
                          src="assets/img/jarvis/notion_logo.png"
                          style="width: 5%"
                        />
                        Notion</a
                      >
                    </li>
                    <li>
                      <a href="#"
                        ><img
                          src="assets/img/jarvis/github_logo.png"
                          style="width: 5%"
                        />
                        GitHub</a
                      >
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <!-- Footer bottom -->
          <div class="row align-items-center">
            <div class="col-xl-7 col-lg-8 col-md-7">
              <div class="footer-copy-right">
                <p>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                  서울특별시 강남구 역삼동 736-7
                  <i class="fa fa-heart" aria-hidden="true"></i>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
              </div>
            </div>
            <div class="col-xl-5 col-lg-4 col-md-5">
              <div class="footer-copy-right f-right">
                <!-- social -->
                <div class="footer-social">
                  <a href="#"><i class="fab fa-twitter"></i></a>
                  <a href="#"><i class="fab fa-facebook-f"></i></a>
                  <a href="#"><i class="fab fa-behance"></i></a>
                  <a href="#"><i class="fas fa-globe"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Footer End-->
    </footer>
    <!--? Search model Begin -->
    <div class="search-model-box">
      <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-btn">+</div>
        <form class="search-model-form">
          <input
            type="text"
            id="search-input"
            placeholder="Searching key....."
          />
        </form>
      </div>
    </div>
    <!-- Search model end -->

    <!-- JS here -->

    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>

    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- Scroll up, nice-select, sticky -->
    <script src="./assets/js/jquery.scrollUp.min.js"></script>
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>

    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>

    <!-- Jquery Plugins, main Jquery -->
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
    <!-- ck에디터 -->
    <script src="https://cdn.ckeditor.com/ckeditor5/41.1.0/classic/ckeditor.js"></script>
    <script>
      ClassicEditor.create(document.querySelector("#editor"), {
        removePlugins: ["Heading"],
        toolbar: [
          "bold",
          "italic",
          "bulletedList",
          "numberedList",
          "blockQuote",
        ],
        language: "ko",
      });
    </script>
  </body>
</html>