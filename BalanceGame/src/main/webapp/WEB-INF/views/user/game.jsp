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
      <!--? slider Area Start -->
      <div class="slider-area">
        <div class="slider-active">
          <!-- Single Slider -->
          <div class="single-slider align-items-center slide-bg">
            <div class="container">
              <div
                style="
                  text-align: center;
                  padding-top: 10vh;
                  padding-bottom: 10vh;
                "
              >
                <div>
                  <div class="hero__caption">
                    <!-- 메인페이지 헤드라인 -->
                    <h1>뭐 드실?</h1>
                    <!-- Hero-btn -->
                    <div class="button-container">
                      <br />
                      <br />
                      <a
                        href="#"
                        class="genric-btn primary-border radius e-large game-button"
                        ><span>찹쌀떡</span></a
                      >
                      <a
                        href="#"
                        class="genric-btn primary-border radius e-large game-button"
                        ><span>메밀묵</span></a
                      >
                    </div>
                  </div>
                </div>
              </div>

              <div class="container">
                <button
                  class="genric-btn default f-right large"
                  style="font-size: 30px"
                >
                  Next >
                </button>
              </div>
            </div>
          </div>
          <!-- Single Slider -->
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
              <button type="submit" class="genric-btn info-border radius large">
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
                        <a href="#" style="color: black">모몽가</a>
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
    </main>
    </main>
	<!-- 메인 페이지 푸터 -->
    <%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->


    <!-- JS here -->

    <!-- 푸터 고정 스크립트 공통 모음 -->    
    <%@ include file="../layout/footer-fix.jsp"%>
    <!-- 푸터 고정 스크립트 공통 모음 -->  
  </body>
</html>