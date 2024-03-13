<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>마이페이</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

  <!-- CSS here -->
      <link rel="stylesheet" href="assets/css/bootstrap.min.css">
      <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
      <link rel="stylesheet" href="assets/css/flaticon.css">
      <link rel="stylesheet" href="assets/css/slicknav.css">
      <link rel="stylesheet" href="assets/css/animate.min.css">
      <link rel="stylesheet" href="assets/css/magnific-popup.css">
      <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
      <link rel="stylesheet" href="assets/css/themify-icons.css">
      <link rel="stylesheet" href="assets/css/slick.css">
      <link rel="stylesheet" href="assets/css/nice-select.css">
      <link rel="stylesheet" href="assets/css/style.css">
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
        <!-- Hero Area Start-->
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>정보변경</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--================Checkout Area =================-->
        <section class="checkout_area section_padding">
          <div class="container">
           
            
            <div class="comments-area">
              <div class="row">
                <div style="width: 50%;margin: 0 auto;">
                  <h2>변경</h3>
                  <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                    <!----------------------------------------이름 입력창---------------------------------------->
                    <div>
                        &nbsp&nbsp&nbsp&nbsp이름
                    </div>
                    <div class="col-md-12 form-group p_star">
                        <input type="text" class="form-control" id="company" name="company" value="이름 데이터" disabled />
                    </div>
                    <!----------------------------------------이름 입력창---------------------------------------->
                   
                    <!----------------------------------------아이디 입력창---------------------------------------->
                    <div>
                        &nbsp&nbsp&nbsp&nbsp아이디
                    </div>
                    <div class="col-md-12 form-group p_star">
                        <input type="text" class="form-control" id="loginId" name="loginId" value="아이디 값" disabled  />
                    </div>
                    <!----------------------------------------아이디 입력창---------------------------------------->
                    <!----------------------------------------비밀번호 입력창---------------------------------------->
                    <div>
                        &nbsp&nbsp&nbsp&nbsp닉네임
                    </div>
                    <!-- 버튼옆으로 -->
                    <div class="col-md-12 form-group p_star input-button-container">
                        <input type="text" class="form-control input-field" id="nikeName" name="nikeName" value="닉네임 데이터"/>
                        <button class="genric-btn primary radius change-ck-button">변경</button>
                    </div>
                    <!----------------------------------------비밀번호 입력창---------------------------------------->
                    <!----------------------------------------폰번호 입력창---------------------------------------->
                    <div>
                        &nbsp&nbsp&nbsp&nbsp휴대폰 번호
                    </div>
                    <div class="col-md-12 form-group1 p_star input-button-container">
                        <input type="tel" class="form-control input-field" id="company" name="company" value="01012345678" />
                        <button class="genric-btn primary radius change-ck-button">문자발송</button>
                    </div>
                    <!----------------------------------------폰번호 입력창---------------------------------------->
                    
                    <!----------------------------------------이메일 입력창---------------------------------------->
                    
                    <div><br>
                        &nbsp&nbsp&nbsp&nbsp이메일
                    </div>
                    <div class="col-md-12 form-group p_star input-button-container">
                        <input type="email" class="form-control input-field" id="company" name="company" value="test@gmail.com" />
                        <button class="genric-btn primary radius change-ck-button">이메일 인증</button>
                    </div>
                    <!----------------------------------------이메일 입력창---------------------------------------->
                     <!----------------------------------------나이 입력창---------------------------------------->
                     <div>
                        &nbsp&nbsp&nbsp&nbsp생년월일
                    </div>
                    <div class="col-md-12 form-group p_star">
                        <input type="text" class="form-control" id="age" name="age"  value="나이 데이터" disabled />
                    </div>
                    <!----------------------------------------나이 입력창---------------------------------------->
                    <!----------------------------------------성별 선택---------------------------------------->
                    <div>
                        &nbsp&nbsp&nbsp&nbsp성별
                    </div>
                    <div class="col-md-12 form-group p_star">
                        <input type="text" class="form-control" id="loginId" name="loginId" value="남자" disabled  />
                    </div>
                    <!----------------------------------------성별 선택---------------------------------------->
                    <!----------------------------------------주소 입력---------------------------------------->
                    <div>
                        &nbsp&nbsp&nbsp&nbsp주소
                    </div>
                    <div class="col-md-12 form-group p_star input-button-container">
                        <input type="text" class="form-control input-field" id="address" name="address" value="주소 데이터"/>
                        <button class="genric-btn primary radius change-ck-button">주소찾기</button>
                    </div>
                    
                    <!----------------------------------------주소 입력---------------------------------------->
                        <div style="justify-items: center;" class="col-md-12 form-group p_star">
                            <button type="submit" class="button button-contactForm btn_1 boxed-btn" style="width: 100%;">변경</button>

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
                <input type="text" id="search-input" placeholder="Searching key.....">
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
  
</body>
</html>