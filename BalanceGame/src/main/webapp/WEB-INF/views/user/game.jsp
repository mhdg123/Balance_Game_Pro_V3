<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Watch shop | eCommers</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="manifest" href="site.webmanifest" />
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="assets/img/favicon.ico"
    />

    <!-- CSS here -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css" />
    <link rel="stylesheet" href="assets/css/flaticon.css" />
    <link rel="stylesheet" href="assets/css/slicknav.css" />
    <link rel="stylesheet" href="assets/css/animate.min.css" />
    <link rel="stylesheet" href="assets/css/magnific-popup.css" />
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css" />
    <link rel="stylesheet" href="assets/css/themify-icons.css" />
    <link rel="stylesheet" href="assets/css/slick.css" />
    <link rel="stylesheet" href="assets/css/nice-select.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
  </head>

  <body>
    <!--? Preloader Start -->
    <!-- 페이지 로딩 -->
    <div id="preloader-active">
      <div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-inner position-relative">
          <div class="preloader-circle"></div>
          <div class="preloader-img pere-text">
            <img src="assets/img/jarvis/jarvisLogo.png" alt="" />
          </div>
        </div>
      </div>
    </div>
    <!-- Preloader Start -->
    <header>
      <!-- Header Start -->
      <div class="header-area">
        <div class="main-header header-sticky">
          <div class="container-fluid">
            <div class="menu-wrapper">
              <!-- Logo -->
              <div class="logo">
                <a href="index.html"
                  ><img src="assets/img/jarvis/logotext.png" alt=""
                /></a>
              </div>
              <!-- Main-menu -->
              <div class="main-menu d-none d-lg-block">
                <nav>
                  <ul id="navigation">
                    <!-- 비로그인 시 -->
                    <li class="hot"><a href="game.html">게임하기</a></li>
                    <li><a href="titleList.html">문제목록</a></li>
                    <li><a href="titleList.html">포인트 랭킹</a></li>
                    <li><a href="titleList.html">건의하기</a></li>
                    <!-- 비로그인 시 -->
                    <!-- 로그인 시 -->
                    <li>
                      <a href="#" class="hiddenText">마이페이지</a>
                    </li>
                    <li>
                      <a href="#" class="hiddenText">상점</a>
                    </li>
                    <li>
                      <a href="#" class="hiddenText">내 아이템</a>
                    </li>
                    <li>
                      <a href="#" class="hiddenText">우편함</a>
                    </li>
                    <li>
                      <a href="#" class="hiddenText">로그아웃</a>
                    </li>
                  </ul>
                </nav>
              </div>
              <!-- Header Right -->
              <div class="header-right">
                <ul>
                  <!-- 비로그인 시 -->

                  <li>
                    <!-- 비로그인 상태에서 상점은 들어갈수 있지만 아이템 구매서 로그인 요구하기 -->
                    <a href="shop.html"
                      ><span class="flaticon-shopping-cart"
                        ><span style="font-size: small" class="window_min_text"
                          >상점</span
                        >
                      </span></a
                    >
                    <!-- 비로그인 상태에서 상점은 들어갈수 있지만 아이템 구매서 로그인 요구하기 -->
                  </li>
                  <!-- 비로그인 시 -->
                  <li>
                    <a href="myPage.html"
                      ><span class="flaticon-user"
                        ><span style="font-size: small" class="window_min_text"
                          >마이페이지</span
                        ></span
                      ></a
                    >
                  </li>
                  <!-- 로그인 시 -->
                  <li>
                    <a href="login.html"
                      ><span class="flaticon-arrow"
                        ><span class="window_min_text" style="font-size: small"
                          >로그아웃</span
                        ></span
                      ></a
                    >
                  </li>

                  <!-- 로그인 시 -->
                </ul>
              </div>
            </div>
            <!-- Mobile Menu -->
            <div class="col-12">
              <div class="mobile_menu d-block d-lg-none"></div>
            </div>
          </div>
        </div>
      </div>
      <!-- Header End -->
    </header>

    <main>
      <!--? slider Area Start -->
      <div class="slider-area">
        <div class="slider-active">
          <!-- Single Slider -->
          <div class="single-slider align-items-center slide-bg">
            <div class="container">
              <div
                style="
                  text-align: center;
                  padding-top: 10vh;
                  padding-bottom: 10vh;
                "
              >
                <div>
                  <div class="hero__caption">
                    <!-- 메인페이지 헤드라인 -->
                    <h1>뭐 드실?</h1>
                    <!-- Hero-btn -->
                    <div class="button-container">
                      <br />
                      <br />
                      <a
                        href="#"
                        class="genric-btn primary-border radius e-large game-button"
                        ><span>찹쌀떡</span></a
                      >
                      <a
                        href="#"
                        class="genric-btn primary-border radius e-large game-button"
                        ><span>메밀묵</span></a
                      >
                    </div>
                  </div>
                </div>
              </div>

              <div class="container">
                <button
                  class="genric-btn default f-right large"
                  style="font-size: 30px"
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
      <div class="container">
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

    <!-- Scrollup, nice-select, sticky -->
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
  </body>
</html>