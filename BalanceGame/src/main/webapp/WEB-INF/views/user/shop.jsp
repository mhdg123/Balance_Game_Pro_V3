<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
String name = "테스트";
String email = "asdf@naver.com";
String phone = "010-1234-1234";
String address = "서울";
int totalPrice = 10;
%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<!-- 카카오페이 -->
<script type="text/javascript"
   src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

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
		<input type="hidden" id="loginId" name="loginId" value="${loginId}">
		<section class="popular-items latest-padding">
         <div class="container">
            <div class="row product-btn justify-content-between mb-40">
               <div class="properties__button">
                  <!--Nav Button  -->
                  <nav>
                     <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home-tab"
                           data-toggle="tab" href="#nav-home" role="tab"
                           aria-controls="nav-home" aria-selected="true"> 아이템 </a> <a
                           class="nav-item nav-link" id="nav-profile-tab"
                           data-toggle="tab" href="#nav-profile" role="tab"
                           aria-controls="nav-profile" aria-selected="false"> 포인트 </a>
                     </div>
                  </nav>
                  <!--End Nav Button  -->
               </div>
               <!-- Grid and List view -->
               <div class="grid-list-view"></div>
               <!-- Select items -->
            </div>
            <!-- Nav Card -->
            <div class="tab-content" id="nav-tabContent">
               <%-- <input type="hidden" value="${itemData.loginId }" id="loginData"> --%>
               <!-- 아이템 구매 탭 버튼 -->
               <div class="tab-pane fade show active" id="nav-home"
                  role="tabpanel" aria-labelledby="nav-home-tab">
                  <div class="row">

                     <c:forEach var="data" items="${itemDatas}">
                        <!-- 아이템 탭 1번 아이템 -->
                        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                           <div class="single-popular-items mb-50 text-center">
                              <div class="popular-img">
                                 <img src="/resources/assets/img/gallery/popular1.png" alt="">
                                 <div class="img-cap">
                                    <a href="javascript:PointItemBuy('${data.itemId}')"><span>구매하기</span></a>
                                 </div>
                              </div>
                              <div class="popular-caption">
                                 <h3>
                                    <a href="#">${data.itemName }</a>
                                 </h3>
                                 <!--  -->
                                 <span>${data.itemPrice }point</span>
                              </div>
                           </div>
                        </div>
                        <!-- 아이템 탭 1번 아이템 -->
                     </c:forEach>
                  </div>
               </div>
               <!-- 아이템 구매 탭 버튼 -->

               <!-- 포인트 구매 탭 버튼 -->
               <div class="tab-pane fade" id="nav-profile" role="tabpanel"
                  aria-labelledby="nav-profile-tab">
                  <div class="row">
                     <!-- 포인트 탭 1번 포인트  -->
                     <c:forEach var="data" items="${paymentDatas}">
                        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                           <!-- 반복문 돌리기 -->
                           <div class="single-popular-items mb-50 text-center">
                              <div class="popular-img">
                                 <img src="/resources/assets/img/gallery/popular2.png" alt="">
                                 <!-- 포인트 충전 이미지 url -->
                                 <div class="img-cap">
                                    <a href="javascript:itemBuy('${data.itemId }', '${data.itemName }', '${data.itemPrice }');"><span>구매하기</span></a>
                                    <!-- 조회시 데이터 넣기 -->
                                 </div>
                              </div>
                              <div class="popular-caption">
                                 <h3>
                                    <a href="javascript:itemBuy('${data.itemId }', '${data.itemName }', '${data.itemPrice }');">${data.itemName }&nbspPoint</a>
                                    <!-- 조회시 데이터 넣기 -->
                                 </h3>
                                 <span>${data.itemPrice }원</span>
                              </div>
                           </div>
                        </div>
                     </c:forEach>
                     <!-- 반복문 돌리기 -->
                     <!-- 포인트 탭 1번 포인트  -->
                  </div>
               </div>
               <!-- 포인트 구매 탭 버튼 -->
            </div>
         </div>
      </section>
      <!-- Latest Products End -->

   </main>
   <!-- 메인 페이지 푸터 -->
   <%@ include file="../layout/index-footer.jsp"%>
   <!-- 메인 페이지 푸터 -->

   <!-- JS here -->
   <!-- 푸터 고정 스크립트 공통 모음 -->
   <%@ include file="../layout/footer-fix.jsp"%>
   <script src="/resources/common/js/alert.js"></script>
   <script src="/resources/user/js/shop.js"></script>
   <!-- 푸터 고정 스크립트 공통 모음 -->
</body>
</html>