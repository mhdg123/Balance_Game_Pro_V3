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
	
	function showNeedLogin(msg) {
		decodedMsg = decodeURIComponent(msg)
		// location.href = 'alert.do?msg=' + msg + '&status=success&redirect=main.do'; 
		Swal.fire({
			title: "로그인!",
			text: msg,
			// imageUrl: "images/thankyou.gif",
			imageWidth: 360,
			imageHeight: 360,
			imageAlt: "Custom image"
		}).then((result) => {
			if (result.isConfirmed) {
				// 확인 버튼이 눌렸을 때 실행할 코드
				// location.href='/alert/' + decodedMsg + '/success/' + 'main' ; // 파라미터 포함 메인 페이지 이동
				location.href = '/user/loginPage'; //  메인 페이지 이동
			}
		});
	}
	