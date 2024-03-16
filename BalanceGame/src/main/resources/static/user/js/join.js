 let authStatus = 0;
    function joinFormAction() {

    // 입력된 값 가져오기
    let name = $('#name').val(); // 이름
    let nickName = $('#nickName').val(); // 이름
    let age = $('#age').val(); // 나이
    let loginId = $('#loginId').val(); // 아이디
    let password = $('#memberPassword').val(); // 비밀번호
    let passwordCheck = $('#passwordCheck').val(); // 비밀번호 확인
    let cellPhone = $("#cellPhone").val(); // 핸드폰 번호
    let email = $('#email').val(); // 이메일
    let gender = $("#gender").val();
    let address = $('#address').val(); // 주소
    let authNumCk = $("#authNum").val(); // 입력된 인증번호
    

    // 이름 유효성 검사
    let namePattern = /^[가-힣]{2,4}$/; // 이름은 한글로 2글자 이상 4글자 이하
    if (!namePattern.test(name)) {
        showError("이름", "한글로 2글자 이상 4글자 이하로 입력해주세요.");
        return false;
    }
    
    // 나이 유효성 검사
    if (age === "") {
        showError("나이", "생년월일을 입력해주세요");
        return false;
    }
    
    // 아이디 유효성 검사
    let loginIdPattern = /^[a-zA-Z0-9]{5,10}$/; // 아이디는 5글자 이상
    if (!loginIdPattern.test(loginId)) {
        showError("아이디", "영어로 5글자 이상 10글자 이하로 입력해주세요.");
        return false;
    }
    
     // 닉네임 미 입력시 예외처리
    if (!nickName) {
        showError("닉네임", "닉네임을 입력해주세요");
        return false;
    }  


    /*// 비밀번호 유효성 검사
    let passwordPattern = /^(?=.*[!@#$%^&*(),.?":{}|<>])(?=.*[a-zA-Z]).{6,15}$/; // 특수문자와 영어를 포함하여 6자 이상 15자 이하
    if (!passwordPattern.test(password)) {
        showError("비밀번호", "특수문자와 영어를 포함하여 6자 이상 15자 이하로 입력해주세요.");
        return false;
    }*/

    // 비밀번호 일치 확인
    if (password != passwordCheck) {
        showError("비밀번호", "비밀번호가 일치하지 않습니다. 다시 확인해 주세요.");
        return false;
    }

    

    // 이메일 유효성 검사
    let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/; // 이메일 형식
    if (!emailPattern.test(email)) {
        showError("이메일", "이메일 형식이 맞지 않습니다.");
        return false;
    }

    // 주소 입력 확인
    if (!address) {
        showError("주소", "주소를 입력해주세요.");
        return false;
    }

    // 성별 선택 확인
    if (!gender) {
        showError("성별", "성별을 선택해주세요.");
        return false;
    }

    // 핸드폰 번호 유효성 검사
    let phonePattern = /^01[016789]\d{8}$/; // 숫자로만 이루어진 11자리 번호
    if (!phonePattern.test(cellPhone)) {
        showError("핸드폰번호", "숫자만 입력 가능합니다.");
        return false;
    }


    // 핸드폰 번호 입력 확인
    if (!cellPhone) {
        showError("휴대폰 번호", "휴대폰 번호를 입력해주세요");
        return false;
    }

    // 인증번호 확인
    if (authStatus <= 0 ) { // authStatus: 인증 성공 여부
        showError("인증확인", "인증번호가 일치하지 않습니다. 다시 확인해주세요");
        return false;
    }

    // 인증번호 미 입력시 예외처리
    if (!authNumCk) {
        showError("인증확인", "인증번호를 입력해주세요");
        return false;
    }        

    // 아이디 중복체크 확인여부 
    if (useIdCheck == 0) {
        showError("중복", "중복된 아이디 입니다");
        return false;
    }
    
    // 패스워드 일치 확인
    if(!passwordCheckResult) {
		showError("비밀번호 확인", "패스워드가 일치하지 않습니다.");
		return false;
	}
    return true; // 모든 유효성 검사 통과
    }
    
    
    
 	// 경고 메세지 출력 함수
	function showError(title, text) {
	    Swal.fire({
	        title: title,
	        text: text,
	        icon: "warning"
	    });
	}
 	
	// 성공 메세지 출력 함수
	function showSuccess(title, text) {
	    Swal.fire({
	        title: title,
	        text: text,
	        icon: "success"
	    });
	}
	
	// 아이디 중복 체크 이벤트 리스너
	$('#loginId').keyup(function () {
	    checkDuplicateId();
	});
	
	// 아이디 중복 확인 함수
	function checkDuplicateId() {
	    let loginId = $('#loginId').val();
	    if (loginId.length >= 5) {
	        $.ajax({
	            url: "idCheckAsync",
	            type: "POST",
	            data: {
	                loginId: loginId
	            },
	            dataType: 'json',
	            success: function (result) {
	                let feedback = $("#id_feedback");
	                if (result == 1) {
	                    useIdCheck = 0;
	                    showIdFeedback('이미 사용중인 아이디입니다.', '#dc3545');
	                } else {
	                    useIdCheck = 1;
	                    showIdFeedback('사용할 수 있는 아이디입니다.', '#2fb380');
	                }
	            },
	            error: function (request, status, error) {
	                showIdFeedback('서버 요청 실패', '#dc3545');
	            }
	        });
	    } else {
	        showIdFeedback('아이디 5글자 이상으로 입력해주세요.', '#dc3545');
	    }
	}
	
	// 아이디 중복 체크 알림 메세지 함수
	function showIdFeedback(message, color) {
	    let feedback = $("#id_feedback");
	    feedback.html(message);
	    feedback.css('color', color);
	    feedback.css('font-size', '20px');
	}
	
	// 인증번호 확인 함수
	function authNumCheck() {
	    let authNumCk = $("#authNum").val();
	    if (authNum == authNumCk) {
	        showSuccess("인증확인", "인증번호가 확인되었습니다.");
	        authStatus = 1; // 인증번호 확인 성공시 회원가입 가능 상태값 부여
	    } else {
	        authStatus = 0; // 인증번호 확인 실패시 회원가입 불가능 상태값 부여
	        showError("인증확인", "인증번호가 일치하지 않습니다. 다시 확인해주세요");
	    }
	}
	

    // 패스워드 확인 성공 = true
	var passwordCheckResult; 
	
	// 비밀번호 확인 하는 함수	
	function checkPassword() {
	var memberPassword = $("#memberPassword").val();
    var passwordCheck = $("#passwordCheck").val();
    var errorDiv = $("#passwordError").val();
    
    if(memberPassword !== passwordCheck) {
        errorDiv.innerHTML = '[비밀번호가 일치하지 않습니다.]';
        errorDiv.style.color = 'red';
        passwordCheckResult = false; 
        
    } else {
        errorDiv.innerHTML = '[비밀번호가 일치합니다.]';
        errorDiv.style.color = 'green';
        passwordCheckResult = true; 
    }
}



/* 주소 API */

function addressSearch(){
   var pop = window.open("/user/addressSearchApi","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadAddrPart1,addrDetail){
      var address = roadAddrPart1 + " " + addrDetail;
      document.joinForm.address.value = address;
}




	
	
	