<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--? Preloader Start -->
<!-- 페이지 로딩 -->
<%@ include file="../layout/header-fix.jsp"%>

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
						<a href="/"><img
							src="/resources/assets/img/jarvis/logotext.png" alt="" /></a>
					</div>
					<!-- Main-menu -->
					<div class="main-menu d-none d-lg-block">
						<nav>
							<ul id="navigation">
								<!-- 비로그인 시 -->
								<li><a href="/user/gamePage">게임하기</a></li>
								<li><a href="/user/questionListPage">문제목록</a></li>
								<li><a href="/user/rankListPage">포인트 랭킹</a></li>
								<li><a href="/user/shopPage" class="hiddenText">상점</a></li>
								<!-- 로그인 시 -->
								<c:if test="${loginId != null }">
									<li><a href="/user/letterPage">건의하기</a></li>
									<a style="color: red;" href="/admin/adminPage">관리자 페이지로가기</a>
									
									
									<li><a href="/user/myInfoPage" class="hiddenText">마이페이지</a></li>
									<li><a href="/user/letterListPage" class="hiddenText">모든 우편 보기</a></li>

									<li><a href="/user/logout" class="hiddenText">로그아웃</a></li>
								</c:if>
								<c:if test="${loginId == null }">
									<li><a href="/user/loginPage">건의하기</a></li>
									<li><a href="/user/loginPage" class="hiddenText">로그인</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
					<!-- Header Right -->
					<div class="header-right">
						<ul>
							<!-- 포인트 금액 -->
							<c:if test="${loginId != null }">
								<li><span style="font-size: small">${point}</span></li>
								<!-- 포인트 금액 -->

								<!-- 메세지 아이콘  -->

								<li>
									<div class="dropdown" id="dropdown">
										<button class="letter" id="dropdown-btn">

											<img src="/resources/assets/img/jarvis/messageiconCut.png" />
											<p class="nav-counter" id="letterContent">0</p>

											<span style="font-size: small" class="window_min_text">우편함
											</span>

										</button>
										<div class="dropdown-options shadow p-3 mb-5 bg-body rounded"
											id="dropdown-options">
											<div>우편함</div>
											<div class="letter-group" id="letter-group"
												style="overflow-y: auto; height: 200px;"></div>
											<a href="/user/letterListPage" class="f-right"
												style="color: black;">모든 우편 보기</a>
										</div>
									</div>
								</li>
								<!-- 메세지 아이콘  -->
								<li>
									<!-- 비로그인 상태에서 상점은 들어갈수 있지만 아이템 구매서 로그인 요구하기 --> <a
									href="/user/shopPage"><span class="flaticon-shopping-cart"><span
											style="font-size: small" class="window_min_text">상점</span> </span></a> <!-- 비로그인 상태에서 상점은 들어갈수 있지만 아이템 구매서 로그인 요구하기 -->
								</li>
								<li><a href="/user/myInfoPage"><span
										class="flaticon-user"><span style="font-size: small"
											class="window_min_text">마이페이지</span></span> </a></li>
								<li><a onclick="unlinkApp();"><span
										class="flaticon-arrow"><span class="window_min_text"
											style="font-size: small">로그아웃</span></span></a></li>
							</c:if>

							<!-- 비로그인 시 -->
							<c:if test="${loginId == null }">
								<li>
									<!-- 비로그인 상태에서 상점은 들어갈수 있지만 아이템 구매서 로그인 요구하기 --> <a
									href="/user/shopPage"><span class="flaticon-shopping-cart"><span
											style="font-size: small" class="window_min_text">상점</span> </span></a> <!-- 비로그인 상태에서 상점은 들어갈수 있지만 아이템 구매서 로그인 요구하기 -->
								</li>
								<li><a href="/user/loginPage"><span
										class="flaticon-arrow"><span class="window_min_text"
											style="font-size: small">로그인</span></span></a></li>
							</c:if>
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