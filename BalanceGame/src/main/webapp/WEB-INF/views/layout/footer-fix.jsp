<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="/resources/assets/js/vendor/modernizr-3.5.0.min.js"></script>
<!-- Jquery, Popper, Bootstrap -->
<script src="/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/resources/assets/js/popper.min.js"></script>
<script src="/resources/assets/js/bootstrap.min.js"></script>
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

<!-- sweetAlert  -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- 부트스트랩 기존꺼 적용 안되서 추가  -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
        if (dropdown) {
        var dropdownOptions = document.getElementById("dropdown-options");
        var targetElement = event.target; // 클릭된 요소

        // 클릭된 요소가 드롭다운 메뉴 내부에 속하지 않은 경우에만 메뉴를 닫습니다.
        if (!dropdown.contains(targetElement)) {
          dropdownOptions.style.display = "none";
        }
        }
      });
     
      var dropdownBtn = document.getElementById("dropdown-btn");

   // dropdown-btn 요소가 존재하는지 확인합니다.
   if (dropdownBtn) {
       // dropdown-btn 요소가 존재하면 클릭 이벤트 핸들러를 추가합니다.
       dropdownBtn.addEventListener("click", function(event) {
           event.stopPropagation(); // 클릭 이벤트가 부모로 전파되는 것을 막습니다.
           var dropdownOptions = document.getElementById("dropdown-options");
           if (dropdownOptions.style.display === "block") {
               dropdownOptions.style.display = "none";
           } else {
               dropdownOptions.style.display = "block";
           }
       });
   }
    </script>
<script type="text/javascript">
	function unlinkApp() {
		 var msg = '로그아웃 하였습니다.'
    	var decodedMsg = decodeURIComponent(msg) // 메세지 디코딩  
		Kakao.init('a1d65a9b4d7e633373b709fc13e2df12'); // javascript API 키
		Kakao.API.request({
			url: '/v1/user/unlink',
			success: function(res) {
				alert("111")
				location.href = '/user/logout';
			},
			fail: function(err) {
				alert("2222")
				location.href = '/user/logout';
			},
		})
	}
</script>