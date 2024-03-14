<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
 <!-- css -->
    <%@ include file="layout/header-fix.jsp"%>
    <title>Watch shop | eCommers</title>
<!-- css -->
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
                  <h2>문제목록</h2>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--================ 문제목록 =================-->
      <section class="cart_area section_padding">
        <div class="container">
          <div class="cart_inner">

            <div class="table-responsive">
              <div class="d-flex align-items-center justify-content-between">
                <!-- 내 찜보기 필터 토글 버튼 -->
                <button class="genric-btn info radius" style="margin-right: 12px;">문제 제출</button>
                <div class="switch-wrap d-flex align-items-center">
                  <p style="margin-right: 6px; margin-bottom: 0;">내 찜보기</p>
                  <div class="primary-switch">
                    <input type="checkbox" id="default-switch" />
                    <label for="default-switch"></label>
                  </div>
                </div>
              </div>
            </div>

            <!-- 내 찜보기 필터 토글 버튼 -->

            <!-- 추가 -->
              <div class="container">
                <div class="cart_inner">
                  <div class="table-responsive">
                    <table class="table" style="width:100%">
                      <thead>
                        <tr>
                          <th scope="col"style="width:5%">NO</th>
                          <th scope="col" style="width:50%">제목</th>
                          <th scope="col" style="width:25%">등록일</th>
                          <th scope="col" style="width:15%">찜개수</th>
                          <th scope="col" style="width:5%">찜</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>
                            <p>1</p>
                          </td>
                          <td>
                            <p>뭐 드실?</p>
                          </td>
                          <td>
                            <p>2024-03-12</p>
                          </td>
                          <td>
                            <p>999</p>
                          </td>

                          <td>
                            <div style="margin-bottom: 5px;">
                              <a style="cursor: pointer;" onclick="test();"><img src="assets/img/thumb/fill-hearts.png" height="20px;" width="20px;" style="margin-right: 15px;"></a>
                            </div>
                          </td>
                        </tr>
                        <tr>
                          <td>
                            <p>2</p>
                          </td>
                          <td>
                            <p>집에 가자</p>
                          </td>
                          <td>
                            <p>2024-03-12</p>
                          </td>
                          <td>
                            <p>999</p>
                          </td>

                          <td>
                            <div style="margin-bottom: 5px;">
                              <a style="cursor: pointer;" onclick="test();"><img src="assets/img/thumb/fill-hearts.png" height="20px;" width="20px;" style="margin-right: 15px;"></a>
                            </div>
                          </td>
                        </tr>

                        
                      </tbody>
                    </table>
                  </div>
                </div>
            </section>

      <!-- 추가 -->

      <nav class="blog-pagination justify-content-center d-flex">
        <ul class="pagination">
          <li class="page-item">
            <a onclick="beforeData();" class="page-link" aria-label="Previous">
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
            <a onclick="nextData();" class="page-link" aria-label="Next">
              <i class="ti-angle-right"></i>
            </a>
          </li>
        </ul>
      </nav>
      <!--================ 문제목록 =================-->
    </main>
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

    <!-- Scrollup, nice-select, sticky -->
    <script src="./assets/js/jquery.scrollUp.min.js"></script>
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>

    <!-- Jquery Plugins, main Jquery -->
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
    <script>
      function test() {
        alert("좋아요 누름");
      }

      function test1() {
        alert("문제 상세페이지 이동");
      }
      function nextData() {
        alert("다음 페이지");
      }

      function beforeData() {
        alert("이전 페이지 ");
      }
    </script>
  </body>
</html>