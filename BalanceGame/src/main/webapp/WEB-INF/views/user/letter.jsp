<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
  <head>
 <!-- css -->
    <%@ include file="../layout/header-fix.jsp"%>
   <title>BalanceGame | Jarvis</title>
<!-- css -->
    <style>
      .ck-editor__editable {
        height: 400px;
      }
      .ck-content {
        font-size: 12px;
      }
    </style>
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
                  <h2>건의하기</h2>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <section class="confirmation_part section_padding">
        <div class="container" style="margin: 0 auto">
          <h1>건의하기</h1>
          <form action="/user/sendLetter" method="POST">
          	제목 <input
                      type="text"
                      class="form-control"
                      id="title"
                      name="title"
                      placeholder="제목 입력해주세요"
                    />
            <textarea name="letterContents" id="editor"></textarea>
            <p>
              <br />
              <input
                type="submit"
                value="전송"
                class="genric-btn primary radius f-right"
              />
            </p>
          </form>
        </div>
      </section>
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
    
    <!-- ck에디터 -->
    <script src="https://cdn.ckeditor.com/ckeditor5/41.1.0/classic/ckeditor.js"></script>
    <script>
      ClassicEditor.create(document.querySelector("#editor"), {
        removePlugins: ["Heading"],
        toolbar: [
          "bold",
          "italic",
          "bulletedList",
          "numberedList",
          "blockQuote",
        ],
        language: "ko",
      });
    </script>
    <script>
document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('form').addEventListener('submit', function(event) {
        // 폼의 submit 이벤트가 발생했을 때 실행되는 함수
        
        // 제목과 내용 가져오기
        var title = document.getElementById('title').value.trim();
        var contents = CKEDITOR.instances['editor'].getData().trim();
        
        // 제목이나 내용이 비어 있는지 확인
        if (title === '' || contents === '') {
            // 하나라도 비어 있다면
            alert('제목과 내용을 모두 입력해주세요.');
            event.preventDefault(); // 폼 제출 막기
        }
    });
});
</script>
  </body>
</html>