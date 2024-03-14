<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
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
        <!-- Hero Area Start-->
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>상점</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero Area End-->
        <!-- Latest Products Start -->
        <section class="popular-items latest-padding">
            <div class="container">
                <div class="row product-btn justify-content-between mb-40">
                    <div class="properties__button">
                        <!--Nav Button  -->
                        <nav>                                                      
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"> 아이템 </a>
                                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"> 포인트 </a>
                            </div>
                        </nav>
                        <!--End Nav Button  -->
                    </div>
                    <!-- Grid and List view -->
                    <div class="grid-list-view">
                    </div>
                    <!-- Select items -->
                </div>
                <!-- Nav Card -->
                <div class="tab-content" id="nav-tabContent">
                    <!-- 아이템 구매 탭 버튼 -->
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <div class="row">
                            <!-- 아이템 탭 1번 아이템 -->
                            <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                                <div class="single-popular-items mb-50 text-center">
                                    <div class="popular-img">
                                        <img src="assets/img/gallery/popular1.png" alt="">
                                        <div class="img-cap">
                                            <a href="#"><span>구매하기</span></a>
                                        </div>
                                    </div>
                                    <div class="popular-caption">
                                        <h3><a href="#">닉네임 변경</a></h3>
                                        <span>1000원</span>
                                    </div>
                                </div>
                            </div>
                            <!-- 아이템 탭 1번 아이템 -->

                            <!-- 아이템 탭 2번 아이템 -->
                            <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                                <div class="single-popular-items mb-50 text-center">
                                    <div class="popular-img">
                                        <img src="assets/img/gallery/popular2.png" alt="">
                                        <div class="img-cap">
                                            <a href="#"><span>구매하기</span></a>
                                        </div>
                                    </div>
                                    <div class="popular-caption">
                                        <h3><a href="#">광고제거</a></h3>
                                        <span>1000원</span>
                                    </div>
                                </div>
                            </div>
                            <!-- 아이템 탭 2번 아이템 -->

                            <!-- 아이템 탭 3번 아이템 -->
                            <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                                <div class="single-popular-items mb-50 text-center">
                                    <div class="popular-img">
                                        <img src="assets/img/gallery/popular2.png" alt="">
                                        <div class="img-cap">
                                            <a href="#"><span>구매하기</span></a>
                                        </div>
                                    </div>
                                    <div class="popular-caption">
                                        <h3><a href="#">랜덤박스</a></h3>
                                        <span>1000원</span>
                                    </div>
                                </div>
                            </div>
                            <!-- 아이템 탭 3번 아이템 -->
                        </div>
                    </div>
                    <!-- 아이템 구매 탭 버튼 -->

                    <!-- 포인트 구매 탭 버튼 -->
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="row">
                            <!-- 포인트 탭 1번 포인트  -->
                            <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                                <div class="single-popular-items mb-50 text-center">
                                    <div class="popular-img">
                                        <img src="assets/img/gallery/popular2.png" alt="">
                                        <div class="img-cap">
                                            <a href="#"><span>구매하기</span></a>
                                        </div>
                                    </div>
                                    <div class="popular-caption">
                                        <h3><a href="#">100&nbspPoint</a></h3>
                                        <span>1000원</span>
                                    </div>
                                </div>
                            </div>
                            <!-- 포인트 탭 1번 포인트  -->
                            <!-- 포인트 탭 2번 포인트  -->
                            <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                                <div class="single-popular-items mb-50 text-center">
                                    <div class="popular-img">
                                        <img src="assets/img/gallery/popular2.png" alt="">
                                        <div class="img-cap">
                                            <a href="#"><span>구매하기</span></a>
                                        </div>
                                    </div>
                                    <div class="popular-caption">
                                        <h3><a href="#">1000&nbspPoint</a></h3>
                                        <span>10000원</span>
                                    </div>
                                </div>
                            </div>
                            <!-- 포인트 탭 2번 포인트  -->
                        </div>
                    </div>
                            <!-- 포인트 구매 탭 버튼 -->
                </div>
            </div>
        </section>
        <!-- Latest Products End -->
        <!--? Shop Method Start-->
        <div class="shop-method-area">
            <div class="container">
                <div class="method-wrapper">
                    <div class="row d-flex justify-content-between">
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-method mb-40">
                                <i class="ti-package"></i>
                                <h6>Free Shipping Method</h6>
                                <p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-method mb-40">
                                <i class="ti-unlock"></i>
                                <h6>Secure Payment System</h6>
                                <p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
                            </div>
                        </div> 
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-method mb-40">
                                <i class="ti-reload"></i>
                                <h6>Secure Payment System</h6>
                                <p>aorem ixpsacdolor sit ameasecur adipisicing elitsf edasd.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Shop Method End-->
    </main>
	<!-- 메인 페이지 푸터 -->
    <%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

<!-- JS here -->
    <!-- 푸터 고정 스크립트 공통 모음 -->    
    <%@ include file="../layout/footer-fix.jsp"%>
    <!-- 푸터 고정 스크립트 공통 모음 -->  
    <script>
        function pointBuy() {
            alert("카카오페이 결제");
        }
    </script>
</body>
</html>