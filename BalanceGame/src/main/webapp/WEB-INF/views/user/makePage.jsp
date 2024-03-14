<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
      <div class="slider-area">
        <div class="single-slider slider-height2 d-flex align-items-center">
          <div class="container">
            <div class="row">
              <div class="col-xl-12">
                <div class="hero-cap text-center">
                  <h2>마이페이지</h2>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--================Checkout Area =================-->
      <section class="confirmation_part section_padding">
        <div class="container">
          <div class="row">
            <div class="col-lg-6 col-lx-4" style="margin: 0 auto">
              <div class="single_confirmation_details">
                <h4>회원 정보</h4>
                <ul>
                  <li>
                    <p>이름</p>
                    <span>: 박찬우</span>
                  </li>
                  <li>
                    <p>닉네임</p>
                    <span>: 피터팬</span>
                  </li>
                  <li>
                    <p>이메일</p>
                    <span>: chanwo2024@naver.com</span>
                  </li>
                  <li>
                    <p>전화번호</p>
                    <span>: 010-0000-0000</span>
                  </li>
                  <li>
                    <p>주소</p>
                    <span>: 서울 어딘가</span>
                  </li>
                  <li>
                    <p>생년월일</p>
                    <span>: 1999-10-01</span>
                  </li>
                  <li>
                    <p>성별</p>
                    <span>: 남</span>
                  </li>
                  <li>
                    <p>가입일</p>
                    <span>: 2024-03-12</span>
                  </li>
                </ul>
              </div>
              <br />
              <a href="javascript:changeInfo();"
                class="genric-btn primary radius change-ck-button f-right"
              >
                정보 변경
            </a>
            </div>
          </div>
        </div>
      </section>
<!-- 해당 유저 댓글 -->
<div class="container">
    <div class="comments-area">
        

      <h4>댓글</h4>

      <div class="comment-list">
        <div>
          <div>
            <div class="desc">
              <div class="d-flex">
                <div class="d-flex align-items-center">
                  <h5>
                    <a href="#" style="color: black">피터팬</a>
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
                    <a href="#" style="color: black">피터팬</a>
                  </h5>
                  <p class="date">December 4, 2017 at 3:12 pm</p>
                </div>
              </div>
              <div>
                <p class="comment">
                  주요 캐릭터 3인방이며 서브 주인공 격 캐릭터다. 주인공
                  치이카와의 단짝친구 중 한 명. 치이카와와 함께 책을 읽으며
                  말하던 것이 첫 등장.
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
                    <a href="#" style="color: black">피터팬</a>
                  </h5>
                  <p class="date">December 4, 2017 at 3:12 pm</p>
                </div>
              </div>
              <div class="d-flex">
                <p class="comment">
                  주요 캐릭터 3인방이며 서브 주인공 격 캐릭터다. 주인공
                  치이카와의 단짝친구 중 한 명. 치이카와와 함께 책을 읽으며
                  말하던 것이 첫 등장.
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
</div>

      <!--================End Checkout Area =================-->
    </main>

    <!----------------------------------------푸터---------------------------------------->
   <!-- 메인 페이지 푸터 -->
    <%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->


    <!-- JS here -->

    <!-- 푸터 고정 스크립트 공통 모음 -->    
    <%@ include file="../layout/footer-fix.jsp"%>
    <!-- 푸터 고정 스크립트 공통 모음 -->  
    <script>
    // 이름 & 이메일로 아이디 찾기
    async function changeInfo() {
        const { value: formValues } = await Swal.fire({
    title: "2차 인증",
    html: `
      <input id="swal-input1" class="swal2-input" placeholder="비밀번호">
    `,
    focusConfirm: false,
    preConfirm: async () => {
      const password = document.getElementById("swal-input1").value;

      // 서버에 데이터 전송 (fetch API 사용) (실제 API 엔드포인트로 변경)
      const response = await fetch("/api/find-id", {
        method: "POST",
        body: JSON.stringify({ password }),
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