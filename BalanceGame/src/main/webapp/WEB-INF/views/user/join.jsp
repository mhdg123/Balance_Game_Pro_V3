<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>회원가입</title>
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
    <header>
      <!-- Header Start -->
      <div class="header-area">
        <div class="main-header header-sticky">
          <div class="container-fluid">
            <div class="menu-wrapper">
              <!-- Logo -->
              <div class="logo">
                <a href="index.html"
                  ><img src="assets/img/logo/logo.png" alt=""
                /></a>
              </div>
              <!-- Main-menu -->
              <div class="main-menu d-none d-lg-block">
                <nav>
                  <ul id="navigation">
                    <!-- 비로그인 시 -->
                    <li class="hot"><a href="game.html">게임하기</a></li>
                    <li><a href="titleList.html">문제목록</a></li>
                    <li><a href="titleList.html">건의</a></li>
                    <!-- 비로그인 시 -->
                    <!-- 로그인 시 -->
                    <li><a href="game.html">게임하기(로그인시)</a></li>
                    <li><a href="titleList.html">문제목록(로그인시)</a></li>
                    <li><a href="#">000(로그인시)</a></li>
                    <!-- 로그인 시 -->
                  </ul>
                </nav>
              </div>
              <!-- Header Right -->
              <div class="header-right">
                <ul>
                  <li>
                    <div class="nav-search search-switch">
                      <span class="flaticon-search"></span>
                    </div>
                  </li>
                  <li>
                    <a href="login.html"><span class="flaticon-user"></span></a>
                  </li>
                  <li>
                    <a href="cart.html"
                      ><span class="flaticon-shopping-cart"></span
                    ></a>
                  </li>
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
      <div class="slider-area">
        <div class="single-slider slider-height2 d-flex align-items-center">
          <div class="container">
            <div class="row">
              <div class="col-xl-12">
                <div class="hero-cap text-center">
                  <h2>회원가입</h2>
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
              <div style="width: 50%; margin: 0 auto">
                <h2>회원가입</h2>
                <form
                  class="row contact_form"
                  action="#"
                  method="post"
                  novalidate="novalidate"
                >
                  <!-- <div class="col-md-6 form-group p_star">
                      <input type="text" class="form-control" id="first" name="name" />
                      <span class="placeholder" data-placeholder="아이디 입력"></span>
                    </div>
                    <div class="col-md-6 form-group p_star">
                      <input type="text" class="form-control" id="last" name="name" />
                      <span class="placeholder" data-placeholder="Last name"></span>
                    </div> -->

                  <!----------------------------------------이름 입력창---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp이름</div>
                  <div class="col-md-12 form-group p_star">
                    <input
                      type="text"
                      class="form-control"
                      id="name"
                      name="name"
                      placeholder="이름 입력해주세요"
                    />
                  </div>
                  <!----------------------------------------이름 입력창---------------------------------------->
                  <!----------------------------------------나이 입력창---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp나이</div>
                  <div class="col-md-12 form-group p_star">
                    <input
                      type="text"
                      class="form-control"
                      id="age"
                      name="age"
                      placeholder="나이 입력해주세요"
                    />
                  </div>
                  <!----------------------------------------나이 입력창---------------------------------------->
                  <!----------------------------------------아이디 입력창---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp아이디</div>
                  <div class="col-md-12 form-group p_star">
                    <input
                      type="text"
                      class="form-control"
                      id="loginId"
                      name="loginId"
                      placeholder="아이디 입력"
                    />
                  </div>
                  <!----------------------------------------아이디 입력창---------------------------------------->
                  <!----------------------------------------비밀번호 입력창---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp비밀번호</div>
                  <div class="col-md-12 form-group p_star">
                    <input
                      type="password"
                      class="form-control"
                      id="memberPassword"
                      name="memberPassword"
                      placeholder="비밀번호 입력"
                    />
                  </div>
                  <!----------------------------------------비밀번호 입력창---------------------------------------->
                  <!----------------------------------------비밀번호 확인 입력창---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp비밀번호 확인</div>
                  <div class="col-md-12 form-group p_star">
                    <input
                      type="password"
                      class="form-control"
                      id="passwordCheck"
                      name="passwordCheck"
                      placeholder="비밀번호 확인 입력"
                    />
                  </div>
                  <!----------------------------------------비밀번호 확인 입력창---------------------------------------->
                  <!----------------------------------------폰번호 입력창---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp휴대폰 번호</div>
                  <div class="col-md-12 form-group1 p_star">
                    <input
                      type="tel"
                      class="form-control"
                      id="cellPhone"
                      name="cellPhone"
                      placeholder="폰번호 입력"
                    />
                  </div>
                  <!----------------------------------------폰번호 입력창---------------------------------------->
                  <!----------------------------------------인증번호 입력창---------------------------------------->
                  <div class="col-md-6 form-group p_star">
                    <br />
                    <input
                      type="text"
                      class="form-control"
                      id="certification"
                      name="certification"
                      placeholder="인증번호 입력"
                    />
                  </div>
                  <!----------------------------------------인증번호 입력창---------------------------------------->
                  <!----------------------------------------인증번호 발송버튼---------------------------------------->
                  <div>
                    <br />
                    &nbsp&nbsp&nbsp&nbsp<a
                      onclick=""
                      class="genric-btn info circle"
                      >인증번호 발송</a
                    >
                  </div>
                  <!----------------------------------------인증번호 발송버튼---------------------------------------->
                  <!-- 인증번호가 발송되면 재발송, 확인버튼 display : none 제거하기  -->
                  <!----------------------------------------인증번호 재발송---------------------------------------->
                  <div style="display: none">
                    <br />
                    &nbsp&nbsp&nbsp&nbsp<a
                      href="#"
                      class="genric-btn info circle"
                      >인증번호 재발송</a
                    >
                  </div>
                  <!----------------------------------------인증번호 재발송---------------------------------------->
                  <!----------------------------------------인증번호 확인---------------------------------------->
                  <div style="display: none">
                    <br />
                    &nbsp&nbsp&nbsp&nbsp<a
                      href="#"
                      class="genric-btn info circle"
                      >인증번호 확인</a
                    >
                  </div>
                  <!----------------------------------------인증번호 확인---------------------------------------->
                  <!----------------------------------------이메일 입력창---------------------------------------->
                  <div class="col-md-12 form-group p_star">
                    <div><br />이메일</div>
                    <input
                      type="email"
                      class="form-control"
                      id="company"
                      name="company"
                      placeholder="이메일 입력해주세요"
                    />
                  </div>
                  <!----------------------------------------이메일 입력창---------------------------------------->
                  <!----------------------------------------성별 선택---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp성별</div>
                  <div class="col-md-12 form-group p_star">
                    <select class="country_select">
                      <option value="1">남자</option>
                      <option value="2">여자</option>
                    </select>
                  </div>
                  <!----------------------------------------성별 선택---------------------------------------->
                  <!----------------------------------------주소 입력---------------------------------------->
                  <div>&nbsp&nbsp&nbsp&nbsp주소</div>
                  <div class="col-md-12 form-group p_star">
                    <input
                      type="text"
                      class="form-control"
                      id="add1"
                      name="add1"
                      placeholder="주소"
                    />
                  </div>
                  <div>
                    &nbsp&nbsp&nbsp&nbsp<a
                      href="#"
                      class="genric-btn info circle"
                      >주소 찾기</a
                    >
                    <div><br /></div>
                    <!-- 공백 -->
                  </div>
                  <!----------------------------------------주소 입력---------------------------------------->

                  <div
                    style="justify-items: center"
                    class="col-md-12 form-group p_star"
                  >
                    <button
                      type="submit"
                      class="button button-contactForm btn_1 boxed-btn"
                      style="width: 100%"
                    >
                      회원가입
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <!----------------------------------------필요시 살리기---------------------------------------->
      </section>
      <!--================End Checkout Area =================-->
    </main>

    <!----------------------------------------푸터---------------------------------------->
    </main>
	<!-- 메인 페이지 푸터 -->
    <%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

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