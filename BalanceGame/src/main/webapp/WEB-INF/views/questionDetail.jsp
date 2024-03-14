<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
  <head>
 <!-- css -->
    <%@ include file="layout/header-fix.jsp"%>
    <title>Watch shop | eCommers</title>
<!-- css -->
    
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
                  <h2>문제 상세페이지</h2>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--================ 문제목록 =================-->
      <section>
        <div class="container">
          <!-- 필터 -->
          <div
            class="row f-right"
            style="
              padding-top: 10px;
              display: flex;
              align-items: center;
              gap: 10px;
            "
          >
            <div>필터</div>
            <div class="default-select col-md-3" id="default-select">
              <select>
                <option value="1">전체</option>
                <option value="2">남자</option>
                <option value="3">여자</option>
              </select>
            </div>
          </div>

          <!-- 결과 -->
          <div style="height: 80px"></div>
          <h2 class="col-12"><br />뭐 드실?</h2>
          <div class="comments-area">
            <div class="col-12">
              <div>
                <!-- 답변A -->
                <div>
                  <div class="serial">메밀묵</div>
                  <div
                    class="percentage"
                    style="width: 80%; display: inline-block"
                  >
                    <div class="progress">
                      <div
                        class="progress-bar color-1"
                        role="progressbar"
                        style="width: 20%"
                        aria-valuenow="80"
                        aria-valuemin="0"
                        aria-valuemax="100"
                      ></div>
                    </div>
                  </div>
                  <div style="display: inline-block">20%</div>
                </div>
                <div style="display: block"><br /></div>
                <!-- 답변B -->
                <div>
                  <div class="serial">찹쌀떡</div>
                  <div
                    class="percentage"
                    style="width: 80%; display: inline-block"
                  >
                    <div class="progress">
                      <div
                        class="progress-bar color-1"
                        role="progressbar"
                        style="width: 80%"
                        aria-valuenow="80"
                        aria-valuemin="0"
                        aria-valuemax="100"
                      ></div>
                    </div>
                  </div>
                  <div style="display: inline-block">80%</div>
                </div>
              </div>
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
                  <button
                    type="submit"
                    class="genric-btn info-border radius large"
                  >
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
                          치이카와의 단짝친구 중 한 명. 치이카와와 함께 책을
                          읽으며 말하던 것이 첫 등장.
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
                          치이카와의 단짝친구 중 한 명. 치이카와와 함께 책을
                          읽으며 말하던 것이 첫 등장.
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
        </div>
      </section>
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
  </body>
</html>