<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <!--? Preloader Start -->
    <!-- 페이지 로딩 -->
    <div id="preloader-active">
      <div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-inner position-relative">
          <div class="preloader-circle"></div>
          <div class="preloader-img pere-text">
            <img src="/resources/assets/img/jarvis/jarvisLogo.png" alt="" />
          </div>
        </div>
      </div>
    </div>
<header>
      <!-- Header Start -->
      <div class="header-area">
        <div class="main-header header-sticky">
          <div class="container-fluid">
            <div class="menu-wrapper">
              <!-- Logo -->
              <div class="logo">
                <a href="index.html"
                  ><img src="/resources/assets/img/jarvis/logotext.png" alt=""
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
                        <img src="/resources/assets/img/jarvis/messageiconCut.png" />
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