<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="/resources/assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="/resources/assets/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/slick.min.js"></script>

    <!-- One Page, Animated-HeadLin -->
    <script src="/resources/assets/js/wow.min.js"></script>
    <script src="/resources/assets/js/animated.headline.js"></script>
    <script src="/resources/assets/js/jquery.magnific-popup.js"></script>

    <!-- Scrollup, nice-select, sticky -->
    <script src="/resources/assets/js/jquery.scrollUp.min.js"></script>
    <script src="/resources/assets/js/jquery.nice-select.min.js"></script>
    <script src="/resources/assets/js/jquery.sticky.js"></script>

    <!-- contact js -->
    <script src="/resources/assets/js/contact.js"></script>
    <script src="/resources/assets/js/jquery.form.js"></script>
    <script src="/resources/assets/js/jquery.validate.min.js"></script>
    <script src="/resources/assets/js/mail-script.js"></script>
    <script src="/resources/assets/js/jquery.ajaxchimp.min.js"></script>

    <!-- Jquery Plugins, main Jquery -->
    <script src="/resources/assets/js/plugins.js"></script>
    <script src="/resources/assets/js/main.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- 우편함 동작로직 -->
       <script>
      async function test() {
        const { value: text } = await Swal.fire({
          title:
            "<div class='f-left'><h1>안녕하세요</h1><p class='f-left'>관리자</p></div>",
          html: `
          <div class='' style="height:100px; width:100%;border: 1px solid rgb(200,200,200)">집에 보내 주세요 </div>
          `,
          showCloseButton: true,
        });
      }
    </script>

    <!-- 메시지박스 -->
    <script>
      document.addEventListener("click", function (event) {
        var dropdown = document.getElementById("dropdown");
        var dropdownOptions = document.getElementById("dropdown-options");
        var targetElement = event.target; // 클릭된 요소

        // 클릭된 요소가 드롭다운 메뉴 내부에 속하지 않은 경우에만 메뉴를 닫습니다.
        if (!dropdown.contains(targetElement)) {
          dropdownOptions.style.display = "none";
        }
      });

      document
        .getElementById("dropdown-btn")
        .addEventListener("click", function (event) {
          event.stopPropagation(); // 클릭 이벤트가 부모로 전파되는 것을 막습니다.
          var dropdownOptions = document.getElementById("dropdown-options");
          if (dropdownOptions.style.display === "block") {
            dropdownOptions.style.display = "none";
          } else {
            dropdownOptions.style.display = "block";
          }
        });
    </script>