<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

    <style>
      .dropdown {
        display: inline-block;
        position: relative;
      }

      .letter {
        background-color: #fff;
        border: none;
        border-radius: 5px;
        font-size: 18px;
        padding: 0px 10px;
        cursor: pointer;
      }
      .letter img {
        width: 18px;
      }
      .letter:hover {
        color: #ff2020;
        img {
          content: url(assets/img/jarvis/messageiconCutRed.png);
        }
      }

      .dropdown-options {
        display: none;
        position: absolute;
        overflow: auto;
        background-color: #dddddd;
        border-radius: 5px;
        z-index: 1;
        width: 350px;
        padding: 10px;
        left: auto;
        right: 0;
      }

      .dropdown-options a {
        display: block;
        color: #000000;
        padding: 5px;
        text-decoration: none;
        padding: 0px 5px;
      }

      .dropdown-options a:hover {
        color: #0a0a23;
        background-color: #ffffff;
        border-radius: 5px;
      }
      .cnt {
        position: relative;
      }

      .cnt::before {
        position: absolute;
        content: "999";
        background: #ff003c;
        color: #fff;
        text-align: center;
        border-radius: 8px;
        font-size: 10px;
        top: -5px;
        left: 20px;
        transition: 0.2s;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        padding: 1px 3px;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: 500;
      }
    </style>
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
                    <li><a href="game.html">게임하기</a></li>
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
                    <a href="shop.html">
                      <span style="font-size: small">100p</span></a
                    >
                  </li>

                  <li>
                    <div class="dropdown" id="dropdown">
                      <button class="letter cnt" id="dropdown-btn">
                        <img src="assets/img/jarvis/messageiconCut.png" />
                        <span style="font-size: small" class="window_min_text"
                          >메시지</span
                        >
                      </button>
                      <div class="dropdown-options" id="dropdown-options">
                        <div>우편함</div>
                        <div style="border: 1px solid rgb(0, 0, 0)">
                          <a href="javascript:test();"
                            ><div style="margin-bottom: 5px">
                              보낸사람 : 관리자
                            </div>
                            <div>제목 : 안녕하세요</div>
                          </a>
                          <hr style="margin: 5px" />
                          <a href="#"
                            ><div style="margin-bottom: 5px">
                              보낸사람 : 관리자
                            </div>
                            <div>제목 : 집에 가세요</div>
                          </a>
                          <hr style="margin: 5px" />
                          <a href="#"
                            ><div style="margin-bottom: 5px">
                              보낸사람 : 관리자
                            </div>
                            <div
                              style="
                                overflow: hidden;
                                white-space: nowrap;
                                text-overflow: ellipsis;
                              "
                            >
                              제목 : 안녕하세요 박현구 입니다 집에 보내주세요
                            </div>
                          </a>
                          <hr style="margin: 5px" />
                        </div>
                      </div>
                    </div>
                  </li>
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
                      src="assets/img/jarvis/jarvis_logo.png"
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

    <footer>
      <!-- Footer Start-->
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
