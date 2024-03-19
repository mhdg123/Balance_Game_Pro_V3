
/* 로그아웃 */
function unlinkApp() {
	var msg = '로그아웃 하였습니다.'
	var decodedMsg = decodeURIComponent(msg) // 메세지 디코딩 
	Kakao.API.request({
		url: '/v1/user/unlink',
		success: function(res) {
			//	alert('success: ' + JSON.stringify(res))
			console.log('success: ' + JSON.stringify(res));
			location.href = '/alert/' + decodedMsg + '/success/' + 'main'; // 파라미터 포함 메인 페이지 이동
		},
		fail: function(err) {
			alert('fail: ' + JSON.stringify(err))
		},
	})
}




var kakaoData;
var loginId;
var name;
var cellPhone;
var nickName;
var email;
var gender;
var year;
var monthDay;
Kakao.init('a1d65a9b4d7e633373b709fc13e2df12'); // javascript API 키
console.log(Kakao.isInitialized());

Kakao.Auth.createLoginButton({

	container: '#kakao-login-btn',
	success: function(authObj) {
		Kakao.API.request({
			url: '/v2/user/me',
			success: function(result) {
				console.log(result); // 카카오에서 넘어온 데이터
				console.log("카카오에서 넘온 데이터 ")
				kakaoData = result.kakao_account;
				loginId = kakaoData.email; // 로그인 아이디 (이메일에서 파싱하기)
				name = kakaoData.name;
				nickName = result.properties.nickname;
				cellPhone = kakaoData.phone_number;
				email = kakaoData.email;
				gender = kakaoData.gender;
				year = kakaoData.birthyear; // 태어난 년도
				monthDay = kakaoData.birthday; // 태어날 월, 일


				$.ajax({ // 카카오 로그인 데이터 파싱하기 위해 비동기 통신
					url: '/user/kakao',
					method: 'POST',
					dataType: 'json',
					data: {
						loginId: loginId,
						name: name,
						nickName: nickName,
						cellPhone: cellPhone,
						email: email,
						gender: gender,
						year: year,
						monthDay: monthDay
					},
					success: function(mDTO) { // 파싱한 회원정보 
						console.log(mDTO);
						console.log('카카오 로그인');
						
						// 파싱한 회원정보를 html form psot방식으로 보내기
						if (mDTO.searchCondition == "join") {
							// form 태그 생성
							var form = document.createElement('form');
							form.setAttribute('method', 'post'); // 전송 방식 설정 (POST)
							form.setAttribute('action', '/user/join/kakao'); // 전송할 URL 설정

							// hidden input 요소 추가 (데이터 전송)
							var inputLoginId = document.createElement('input');
							inputLoginId.setAttribute('type', 'hidden');
							inputLoginId.setAttribute('name', 'loginId');
							inputLoginId.setAttribute('value', mDTO.loginId); // mDTO.loginId 변수에 저장된 값 전달
							form.appendChild(inputLoginId);

							var inputName = document.createElement('input');
							inputName.setAttribute('type', 'hidden');
							inputName.setAttribute('name', 'name');
							inputName.setAttribute('value', mDTO.name); // mDTO.name 변수에 저장된 값 전달
							form.appendChild(inputName);

							var inputNickName = document.createElement('input');
							inputNickName.setAttribute('type', 'hidden');
							inputNickName.setAttribute('name', 'nickName');
							inputNickName.setAttribute('value', mDTO.nickName); // mDTO.nickName 변수에 저장된 값 전달
							form.appendChild(inputNickName);

							var inputCellPhone = document.createElement('input');
							inputCellPhone.setAttribute('type', 'hidden');
							inputCellPhone.setAttribute('name', 'cellPhone');
							inputCellPhone.setAttribute('value', mDTO.cellPhone); // mDTO.cellPhone 변수에 저장된 값 전달
							form.appendChild(inputCellPhone);

							var inputEmail = document.createElement('input');
							inputEmail.setAttribute('type', 'hidden');
							inputEmail.setAttribute('name', 'email');
							inputEmail.setAttribute('value', mDTO.email); // mDTO.email 변수에 저장된 값 전달
							form.appendChild(inputEmail);

							var inputGender = document.createElement('input');
							inputGender.setAttribute('type', 'hidden');
							inputGender.setAttribute('name', 'gender');
							inputGender.setAttribute('value', mDTO.gender); // mDTO.gender 변수에 저장된 값 전달
							form.appendChild(inputGender);

							var inputAge = document.createElement('input');
							inputAge.setAttribute('type', 'hidden');
							inputAge.setAttribute('name', 'age');
							inputAge.setAttribute('value', mDTO.age); // mDTO.age 변수에 저장된 값 전달
							form.appendChild(inputAge);

							// form을 body에 추가하여 화면에 표시되도록 합니다.
							document.body.appendChild(form);

							// form을 자동으로 전송합니다.
							form.submit();
						} else if (mDTO.searchCondition == "login") {
							// form 태그 생성
							var form = document.createElement('form');
							form.setAttribute('method', 'post'); // 전송 방식 설정 (POST)
							form.setAttribute('action', '/user/login/kakao'); // 전송할 URL 설정

							// hidden input 요소 추가 (데이터 전송)
							var inputLoginId = document.createElement('input');
							inputLoginId.setAttribute('type', 'hidden');
							inputLoginId.setAttribute('name', 'loginId');
							inputLoginId.setAttribute('value', mDTO.loginId); // mDTO.loginId 변수에 저장된 값 전달
							form.appendChild(inputLoginId);

							// 나머지 필드들도 위와 같이 추가해줍니다.

							// form을 body에 추가하여 화면에 표시되도록 합니다.
							document.body.appendChild(form);

							// form을 자동으로 전송합니다.
							form.submit();
						}
					}
					,
					error: function(xhr, status, error) {
						// ajax 실패 시 실행할 코드
						console.error('관리자에게 문의 해주세요', status, error);
					}
				});
			},
			fail: function(error) {
				alert(
					'login success, but failed to request user information: ' +
					JSON.stringify(error)
				)
			},
		})
	},
	fail: function(err) {
		alert('failed to login: ' + JSON.stringify(err))
	},
});