function itemBuy(itemId, itemName, itemPrice) { // 결제할 포인트 아이템 pk, 포인트 아이템 이름, 아이템 가격
	var loginId = $('#loginId').val(); // 로그인 아이디
	if( loginId == "") {
		showNeedLogin("로그인후 이용해주세요")
		return;
	}
	var IMP = window.IMP;
	var everythings_fine = true;
	IMP.init('imp77111714'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	var msg;

	IMP.request_pay({
		pg: 'kakaopay',
		pay_method: 'card',
		merchant_uid: 'merchant_' + new Date().getTime(),
		name: Math.floor(itemPrice * 0.1) + ' 포인트 충전하기', // 충전 금액의 10% 포인트
		loginId: loginId, // 로그인 아이디
		itemId: itemId, // 아이템 PK
		itemName: itemName, // 아이템 이름
		amount: itemPrice // 상품 가격

	}, function(rsp) {
		console.log(rsp)
		alert(rsp)
		if (rsp.success) {
			jQuery.ajax({
				url: "/user/coinpurchase",	
				type: 'POST',
				dataType: 'json',
				data: {
					imp_uid: rsp.imp_uid,
					loginId: loginId, // 로그인 아이디
					itemId: itemId, // 아이템 PK
					itemName: itemName, // 아이템 이름
					amount: itemPrice // 상품 가격
				}
			}).done(function(data) {
				// 성공 메시지를 받은 후 처리
				if (data.status == "success") {
					redirectToSuccessPage("결제완료")
				} else {
					redirectToFailPage("결제 실패");
				}

			}).fail(function(jqXHR, textStatus, errorThrown) {
				console.error("AJAX request failed: ", textStatus, errorThrown);
			});
		} else {
			// msg = '결제에 실패하였습니다.';
			redirectToFailPage(msg);
		}
	});

	// 성공 페이지로 이동하는 함수
	var decodedMsg; // 컨트롤러에 데이터넘길때 인코딩메세지를 디코딩 해줘야 함
	function redirectToSuccessPage(msg) {
		decodedMsg = decodeURIComponent(msg)
		// location.href = 'alert.do?msg=' + msg + '&status=success&redirect=main.do'; 
		Swal.fire({
			title: "감사합니다!",
			text: msg,
			// imageUrl: "images/thankyou.gif",
			imageWidth: 360,
			imageHeight: 360,
			imageAlt: "Custom image"
		}).then((result) => {
			if (result.isConfirmed) {
				// 확인 버튼이 눌렸을 때 실행할 코드
				// location.href='/alert/' + decodedMsg + '/success/' + 'main' ; // 파라미터 포함 메인 페이지 이동
				location.href = '/'; //  메인 페이지 이동
			}
		});
	}

	// 실패 페이지로 이동하는 함수
	function redirectToFailPage(msg) {
		decodedMsg = decodeURIComponent(msg) // 컨트롤러에 데이터넘길때 인코딩메세지를 디코딩 해줘야 함
		location.href = '/';
	}
}

// 아이템 구매 함수
function PointItemBuy(itemId) {
	let form = document.createElement('form');

	let obj;
	obj = document.createElement('input');
	obj.setAttribute('type', 'hidden');
	obj.setAttribute('name', 'itemId');
	obj.setAttribute('value', itemId);

	form.appendChild(obj);
	form.setAttribute('method', 'post');
	form.setAttribute('action', '/user/itemPurchase');
	document.body.appendChild(form);
	form.submit();
}

