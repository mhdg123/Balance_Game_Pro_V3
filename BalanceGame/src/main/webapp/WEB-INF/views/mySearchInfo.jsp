<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
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
        <div class="slider-area ">
            <div class="single-slider slider-height2 d-flex align-items-center">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="hero-cap text-center">
                                <h2>내 정보 찾기</h2>
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
                <div class="row product-btn justify-content-center mb-40">
                    <div class="properties__button">
                        <!--Nav Button  -->
                        <nav>                                                      
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"> 아이디 찾기 </a>
                                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"> 비밀번호 찾기 </a>
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
                    <!-- 아이디 찾기 탭 버튼 -->
                    <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        <input type="hidden" id="idSearch" name="idSearch" value="idSearch">
                        <div class="col">
                            <!-- 이메일로 아이디 찾기 버튼 -->
                            <div class="row product-btn justify-content-center mb-40">
                                <input type="hidden" id="searchType" name="searchType" value="email">
                                <a href="javascript:idSearchEmail();" class="genric-btn info circle arrow">이메일로 찾기<span class="lnr lnr-arrow-right"></span></a>
                            </div>
                             <!-- 이메일로 아이디 찾기 버튼 -->

                             <!-- 전화번호로 아이디 찾기 버튼 -->
                             <div class="row product-btn justify-content-center mb-40">
                                <input type="hidden" id="searchType" name="searchType" value="cellPhone">
                                <a href="javascript:idSearchCellPhone();" class="genric-btn info circle arrow">전화번호로 찾기<span class="lnr lnr-arrow-right"></span></a>
                            </div>
                            <!-- 전화번호로 아이디 찾기 버튼 -->
                        </div>
                    </div>
                    <!-- 아이디 찾기 탭 버튼 -->

                    <!-- 비밀번호 찾기 탭 버튼 -->
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <input type="hidden" id="passwordSearch" name="passwordSearch" value="idSearch">
                            <div class="col">
                                <!-- 이메일로 아이디 찾기 버튼 -->
                                <div class="row product-btn justify-content-center mb-40">
                                    <input type="hidden" id="searchType" name="searchType" value="email">
                                    <a href="javascript:passwordSearchEmail();" class="genric-btn info circle arrow">이메일로 찾기<span class="lnr lnr-arrow-right"></span></a>
                                </div>
                                <!-- 이메일로 아이디 찾기 버튼 -->
                                
                                <!-- 전화번호로 아이디 찾기 버튼 -->
                                <div class="row product-btn justify-content-center mb-40">
                                    <input type="hidden" id="searchType" name="searchType" value="cellPhone">
                                    <a href="javascript:passwordSearchCellPhone();" class="genric-btn info circle arrow">전화번호로 찾기<span class="lnr lnr-arrow-right"></span></a>
                                </div>
                                <!-- 전화번호로 아이디 찾기 버튼 -->
                            </div>
                    </div>
                            <!-- 비밀번호 찾기 탭 버튼 -->
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
                                    <a href="index.html"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
                                </div>
                                <div class="footer-tittle">
                                    <div class="footer-pera">
                                        <p>Asorem ipsum adipolor sdit amet, consectetur adipisicing elitcf sed do eiusmod tem.</p>
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-lg-3 col-md-3 col-sm-5">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Quick Links</h4>
                                <ul>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#"> Offers & Discounts</a></li>
                                    <li><a href="#"> Get Coupon</a></li>
                                    <li><a href="#">  Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-4 col-sm-7">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>New Products</h4>
                                <ul>
                                    <li><a href="#">Woman Cloth</a></li>
                                    <li><a href="#">Fashion Accessories</a></li>
                                    <li><a href="#"> Man Accessories</a></li>
                                    <li><a href="#"> Rubber made Toys</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-5 col-sm-7">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Support</h4>
                                <ul>
                                    <li><a href="#">Frequently Asked Questions</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Report a Payment Issue</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer bottom -->
                <div class="row align-items-center">
                    <div class="col-xl-7 col-lg-8 col-md-7">
                        <div class="footer-copy-right">
                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>                 
                        </div>
                    </div>
                    <div class="col-xl-5 col-lg-4 col-md-5">
                        <div class="footer-copy-right f-right">
                            <!-- social -->
                            <div class="footer-social">
                                <a href="#"><i class="fab fa-twitter"></i></a>
                                <a href="https://www.facebook.com/sai4ull"><i class="fab fa-facebook-f"></i></a>
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
    <!-- All JS Custom Plugins Link Here here -->
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


    
      
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
    // 이름 & 이메일로 아이디 찾기
    async function idSearchEmail() {
        const { value: formValues } = await Swal.fire({
    title: "아이디 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="이름">
      <input id="swal-input2" class="swal2-input" placeholder="가입시 이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const name = document.getElementById("swal-input1").value;
      const email = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ name, email }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (!response.ok) {
          return "서버 전송 실패";
        // throw new Error("서버에 데이터 전송 실패!");
      }

      // 성공적인 응답 처리 (원하는 논리로 변경)
      const data = await response.json();
      console.log("회원님의 아이디는 : " + data + "입니다.") 
    //   console.log("서버 응답:", data); // 예시: 응답 데이터 기록
      return formValues; // 추가 처리를 위해 formValues 반환
    }
  });

  if (formValues) {
    Swal.fire(JSON.stringify(formValues));
  }
     }
  



// 이름 & 전화번호로 아이디 찾기
 async function idSearchCellPhone() {
    const { value: formValues } = await Swal.fire({
    title: "비밀번호 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="이름">
      <input id="swal-input2" class="swal2-input" placeholder="전화번호">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const name = document.getElementById("swal-input1").value;
      const cellPhone = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ name, cellPhone }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (!response.ok) {
          return "서버 전송 실패";
        // throw new Error("서버에 데이터 전송 실패!");
      }

      // 성공적인 응답 처리 (원하는 논리로 변경)
      const data = await response.json();
      console.log("회원님의 아이디는 : " + data + "입니다.") 
    //   console.log("서버 응답:", data); // 예시: 응답 데이터 기록
      return formValues; // 추가 처리를 위해 formValues 반환
    }
  });

  if (formValues) {
    Swal.fire(JSON.stringify(formValues));
  }
}


// 아이디 & 이메일 패스워드 찾기
async function passwordSearchEmail() {
    const { value: formValues } = await Swal.fire({
    title: "비밀번호 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="아이디">
      <input id="swal-input2" class="swal2-input" placeholder="이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const loginId = document.getElementById("swal-input1").value;
      const email = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ loginId, email }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (!response.ok) {
          return "서버 전송 실패";
        // throw new Error("서버에 데이터 전송 실패!");
      }

      // 성공적인 응답 처리 (원하는 논리로 변경)
      const data = await response.json();
      console.log("회원님의 아이디는 : " + data + "입니다.") 
    //   console.log("서버 응답:", data); // 예시: 응답 데이터 기록
      return formValues; // 추가 처리를 위해 formValues 반환
    }
  });

  if (formValues) {
    Swal.fire(JSON.stringify(formValues));
  }
}

// 아이디 & 전화번호 패스워드 찾기
async function passwordSearchCellPhone() {
    const { value: formValues } = await Swal.fire({
    title: "비밀번호 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="아이디">
      <input id="swal-input2" class="swal2-input" placeholder="전화번호">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const loginId = document.getElementById("swal-input1").value;
      const cellPhone = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ loginId, cellPhone }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (!response.ok) {
          return "서버 전송 실패";
        // throw new Error("서버에 데이터 전송 실패!");
      }

      // 성공적인 응답 처리 (원하는 논리로 변경)
      const data = await response.json();
      console.log("회원님의 아이디는 : " + data + "입니다.") 
    //   console.log("서버 응답:", data); // 예시: 응답 데이터 기록
      return formValues; // 추가 처리를 위해 formValues 반환
    }
  });

  if (formValues) {
    Swal.fire(JSON.stringify(formValues));
  }
}
  

</script>
</body>
</html>