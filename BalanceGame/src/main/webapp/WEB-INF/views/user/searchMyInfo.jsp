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
	<!-- 메인 페이지 푸터 -->
    <%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

<!-- JS here -->
    <!-- 푸터 고정 스크립트 공통 모음 -->    
    <%@ include file="../layout/footer-fix.jsp"%>
    <!-- 푸터 고정 스크립트 공통 모음 -->  
    <script>
    
    // 이름 & 이메일로 아이디 찾기
    async function idSearchEmail() {
        const { value: formValues } = await Swal.fire({
    title: "아이디 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="이름">
      <input id="swal-input2" class="swal2-input" placeholder="이메일">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const name = document.getElementById("swal-input1").value;
      const email = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/user/isIdInfoCorrect", {
        method: "POST",
        body: JSON.stringify({ name, email }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (response.ok) {
	      const result = await response.json();
	      if(result){
	      	Swal.fire("아이디를 이메일로 전송했습니다 다시 로그인해주세요");
	      	var form = document.createElement("form");
	      	form.method = "GET";
	      	form.action = "/user/loginPage";
	      	document.body.appendChild(form);
	      	form.submit();
	      }
	      else{
	      	Swal.fire("회원정보가 일치하지 않습니다 다시 시도해주세요");
	      }
      }
      else{
      	return "서버 전송 실패";
      }
    }
  });
}
  



// 이름 & 전화번호로 아이디 찾기 지훈
 async function idSearchCellPhone() {
        const { value: formValues } = await Swal.fire({
    title: "아이디 찾기",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="이름">
      <input id="swal-input2" class="swal2-input" placeholder="전화번호">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const name = document.getElementById("swal-input1").value;
      const cellPhone = document.getElementById("swal-input2").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/user/sendMemberIdNumberAsync", {
        method: "POST",
        body: JSON.stringify({ name, cellPhone }),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (response.ok) {
	      const result = await response.json();
	      if(result){
	    	alert("데이터 보내기 성공")
	       Swal.fire("아이디를 전화번호로 전송했습니다 다시 로그인해주세요");
	      	var form = document.createElement("form");
	      	form.method = "GET";
	      	form.action = "/user/loginPage";
	      	document.body.appendChild(form);
	      	form.submit(); 
	      }
	      else{
	      	Swal.fire("회원정보가 일치하지 않습니다 다시 시도해주세요");
	      }
      }
      else{
      	return "서버 전송 실패";
      }
    }
  });
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
      const response = await fetch("/user/isTempPwInfoCorrect", {
        method: "POST",
        body: JSON.stringify({loginId, email}),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (response.ok) {
        const result = await response.json();
		if(result){
			Swal.fire("임시비밀번호를 이메일로 전송했습니다 다시 로그인해주세요");
			//window.location.href = "/user/login"; // 로그인 페이지 경로로 변경
			// 폼을 동적으로 생성합니다.
			var form = document.createElement("form");
			form.method = "GET";
			form.action = "/user/loginPage"; // 이동할 URL을 지정합니다.
			document.body.appendChild(form);
			form.submit();
		}
		else{
			Swal.fire("회원 정보가 일치하지 않습니다 다시 시도해주세요");
		}
      }
      else{
      	return "서버 전송 에러";
      }	
     }
  });
}

// 아이디 & 전화번호 패스워드 찾기 지훈
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
      const response = await fetch("/user/testPw", {
        method: "POST",
        body: JSON.stringify({loginId, cellPhone}),
        headers: { "Content-Type": "application/json" } // 콘텐츠 유형 헤더 설정
      });

      if (response.ok) {
        const result = await response.json();
		if(result){
			Swal.fire("임시비밀번호를 이메일로 전송했습니다 다시 로그인해주세요");
			//window.location.href = "/user/login"; // 로그인 페이지 경로로 변경
			// 폼을 동적으로 생성합니다.
			var form = document.createElement("form");
			form.method = "GET";
			form.action = "/user/loginPage"; // 이동할 URL을 지정합니다.
			document.body.appendChild(form);
			form.submit();
		}
		else{
			Swal.fire("회원 정보가 일치하지 않습니다 다시 시도해주세요");
		}
      }
      else{
      	return "서버 전송 에러";
      }	
     }
  });
}
  

</script>
</body>
</html>