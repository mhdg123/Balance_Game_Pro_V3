<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 우편함 동작로직 -->
<!-- 메시지박스 -->
<!-- 메시지 개수 받아오기 -->
<script>
$(document).ready(function() {
    // 페이지 로드가 완료되면 실행될 코드를 여기에 작성합니다.
	 $.ajax({
	        type: "POST",
	        url: "/user/mailCount",
	        data: {},
	        dataType: 'text',
	        success: function(data) {
	        	 console.log(data);
	             //$('.cnt').css("content",data);
	             $('#letterContent').text(data);
	        },
	        error: function(error) {
	            console.log('에러발생');
	            console.log('에러의 종류:' + error);
	        }
	    });
    
});


</script>

<!-- 메시지 개수 받아오기 -->

<!-- 메시지 상세 받아오기 -->
<script>

$(document).on('click', '.letter-box', async function() {
    console.log("메시지 박스 클릭");
    var letterId = $(this).attr('id');
    
    try {
        var data = await $.ajax({
            type: "POST",
            url: "/user/mailCheck",
            data: {
                "letterId": letterId
            },
            dataType: 'json',
            success: function(data) {
                console.log(data);
                $.ajax({
        	        type: "POST",
        	        url: "/user/mailCount",
        	        data: {},
        	        dataType: 'text',
        	        success: function(data) {
        	        	 console.log(data);
        	             //$('.cnt').css("content",data);
        	             $('#letterContent').text(data);
        	        },
        	        error: function(error) {
        	            console.log('에러발생');
        	            console.log('에러의 종류:' + error);
        	        }
        	    });
            },
            error: function(error) {
                console.log('에러발생');
                console.log('에러의 종류:' + error);
            }
            
        });
        
        const { value: text } = await Swal.fire({
            title:
                "<div class='f-left'><h2>"+data.title+"</h2><p class='f-left'>"+data.sender+"</p></div>",
            html: "<div class='' style='height:100px; width:100%;border: 1px solid rgb(200,200,200)'>"+data.letterContents+"</div>",
            showCloseButton: true
        });
    } catch (error) {
        console.log('에러발생');
        console.log('에러의 종류:' + error);
    }
});
    </script>
<!-- 메시지 상세 받아오기 -->



<!-- 드롭박스 스크립트 -->
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
<!-- 드롭박스 스크립트 -->

<!-- 메시지 목록 받아오기 -->
<script type="text/javascript">
$('#dropdown-btn').on('click',function(){
    var letterElement = $("#letter-group");
    var newletterElement = $("<div></div>"); // 새로운 jQuery 객체 생성
    
    $.ajax({
        type: "POST",
        url: "/user/mailBoxAsync",
        data: {},
        dataType: 'json',
        success: function(data) {
            console.log(data);
            // 데이터들 만큼 반복하여 어펜드
            // 클릭 이벤트 활성화 여부 확인
            $.each(data, function(index, data) {
                console.log(data.sender);
                // 새로운 요소를 생성하여 newletterElement에 추가합니다.
                var newElement = $('<div class="letter-box" id="'+ data.letterId +'">' +
                                    '<div>보낸사람 : ' + data.sender + '</div>' +
                                    '<div>제목 : ' + data.title + '</div>' +
                                '</div><hr />');
                newletterElement.append(newElement);
            });
            
            
            // letterElement를 비워놓고 newletterElement를 추가합니다.
            letterElement.html(newletterElement);
            
            // 새로운 요소를 추가합니다.
           // var dropdownArrow = $('<div class="dropdown-arrow letter-box" id="addLetter" style="text-align: center;">...</div>');
           // letterElement.append(dropdownArrow);
        },
        error: function(error) {
            console.log('에러발생');
            console.log('에러의 종류:' + error);
        }
    });
});
	
	
	</script>
<!-- 메시지 목록 받아오기 -->

<!-- 메시지 추가로 받아오기 -->
<script type="text/javascript">

/* 구현미정 */

</script>
<!-- 메시지 추가로 받아오기 -->


<!-- 메시지박스 -->
<!-- 우편함 동작로직 -->





<script type="text/javascript">
	function unlinkApp() {
		 var msg = '로그아웃 하였습니다.'
    	var decodedMsg = decodeURIComponent(msg) // 메세지 디코딩  
		Kakao.init('a1d65a9b4d7e633373b709fc13e2df12'); // javascript API 키
		Kakao.API.request({
			url: '/v1/user/unlink',
			success: function(res) {
				location.href = '/user/logout';
			},
			fail: function(err) {
				location.href = '/user/logout';
			},
		})
	}
</script>





