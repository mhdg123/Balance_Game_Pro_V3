<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<!-- 헤더 고정 스타일 공통 모음 -->
<%@ include file="../layout/header-fix.jsp"%>
<!-- 헤더 고정 스타일 공통 모음 -->
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
                            <a href="index.html"><img src="assets/img/jarvis/logo2.png" alt=""></a>
                        </div>
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>                                                
                                <ul id="navigation">  
                                     <!-- 비로그인 시 -->
                                     <li><a href="game.html">게임하기</a></li>
                                     <li><a href="titleList.html">문제목록</a></li>
                                     <li><a href="itemStroe.html">상점</a></li>
                                     <!-- 비로그인 시 -->
                                     <!-- 로그인 시 -->
                                     <li><a href="game.html">게임하기(로그인시)</a></li>
                                     <li><a href="titleList.html">문제목록(로그인시)</a></li>
                                     <li><a href="#">000(로그인시)</a></li>
                                     <li><a href="itemStore.html">상점(로그인시)</a></li>
                                     <!-- 로그인 시 -->
                                </ul>
                            </nav>
                        </div>
                        <!-- Header Right -->
                        <div class="header-right">
                            <ul>
                                <li> <a href="login.html"><span class="flaticon-user"></span></a></li>
                                <li><a href="cart.html"><span class="flaticon-shopping-cart"></span></a> </li>
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
                                <h2>로그인</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero Area End-->
        <!--================login_part Area =================-->
        <section class="login_part section_padding ">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>처음 오셨나요?</h2>
                                <p>회원가입부터 해주세요</p>
                                <a href="join.html" class="btn_3">회원가입</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>환영합니다. <br>
                                    로그인 해주세요.</h3>
                                <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="name" name="name" value=""
                                            placeholder="아이디">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="password" name="password" value=""
                                            placeholder="패스워드">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <div class="creat_account d-flex align-items-center">
                                            <input type="checkbox" id="f-option" name="selector">
                                            <label for="f-option">아이디 저장</label>
                                        </div>
                                        <button type="submit" value="submit" class="btn_3">
                                            log in
                                        </button>
                                        <a href="mySearchInfo.html" class="lost_pass" id="searchLoginPw"> 회원정보 찾기</a>
                                        <!-- <a class="lost_pass"  id="searchLoginId" style="cursor: pointer;" >아이디 찾기 /</a> -->
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================login_part end =================-->
    </main>
   
    <!--? Search model Begin -->
    <div class="search-model-box">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-btn">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Searching key.....">
            </form>
        </div>
    </div>



<!--  아이디찾기 비밀번호찾기 
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
    //  아이디 찾기
     document.getElementById("searchLoginId").addEventListener("click", async () => {
  const { value: formValues } = await Swal.fire({
    title: "아이디 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="가입 이름">
      <input id="swal-input2" class="swal2-input" placeholder="가입시 이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const email = document.getElementById("swal-input1").value;
      const birthdate = document.getElementById("swal-input2").value;

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
});


// 패스워드 찾기
document.getElementById("searchLoginPw").addEventListener("click", async () => {
  const { value: formValues } = await Swal.fire({
    title: "비밀번호 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="가입 이름">
      <input id="swal-input2" class="swal2-input" placeholder="가입시 이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const email = document.getElementById("swal-input1").value;
      const birthdate = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ email, birthdate }),
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
}); -->

        
    <!-- 푸터 고정 스크립트 공통 모음 -->    
    <%@ include file="../layout/footer-fix.jsp"%>
    <!-- 푸터 고정 스크립트 공통 모음 -->    

</body>
    
</html>