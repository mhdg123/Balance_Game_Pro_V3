<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zxx">
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>BalanceGame | Jarvis</title>
<style>
.letterFilterButton{
width: 6%;
min-width: 100px

}

.letterFilterButton:hover{
color:#ff2020;
cursor: pointer;
}
</style>
<!-- css -->
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
								<h2>우편 목록</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================ 문제목록 =================-->
		<section class="cart_area section_padding">
			<div class="container">
				<div class="cart_inner">


					<!-- 내 찜보기 필터 토글 버튼 -->

					<!-- 추가 -->
					<div class="container">
						<div class="cart_inner">
							<div class="table-responsive">
								<table class="table" style="width: 100%; margin: 0">
									<tr>
										<th style="width: 5%"><input type="checkbox" id="check-all"></th>
										<th  class="letterFilterButton">읽음</th>
										<th  class="letterFilterButton" onclick="letterDelete()">삭제</th>
										<th style="text-align: right;width:70%"></th>
										<th>
										<!-- <th style="text-align: right;width:70%">읽지 않은 메일</th>
										<th>
											<div class="primary-switch">
												<input type="checkbox" id="default-switch" /> <label
													for="default-switch"></label>
											</div>
										</th> -->
									</tr>
								</table>
								<table class="table" style="width: 100%">

									<thead>
										<tr>
											<th scope="col" style="width: 5%;height: 0px;padding: 0"></th>
											<th scope="col" style="width: 10%;height: 0px;padding: 0"></th>
											<th scope="col" style="width: 10%;height: 0px;padding: 0"></th>
											<th scope="col" style="width: 60%;height: 0px;padding: 0"></th>
											<th scope="col" style="width: 15%;height: 0px;padding: 0"></th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="data" items="${letterDatas}" varStatus="loop">
											<!-- loop.index는 0부터 시작하므로 +1을 해서 순번을 출력합니다. -->
											<tr>
												<td style="padding: 10px;"><input type="checkbox" name="lettercheck" id="${data.letterId}"></td>
												<td style="padding: 10px;">
												<c:if test="${data.letterStatus=='T'}"><p style="margin: 0; display: none;">${data.letterStatus}</p>
												<img onclick="unRead(${data.letterId})" style="width: 15px; margin-bottom: 10px ;" src="/resources/assets/img/jarvis/letterRead.png">
												</c:if>
												<c:if test="${data.letterStatus=='F'}"><p style="margin: 0; display: none;">${data.letterStatus}</p>
												<img onclick="read(${data.letterId})" style="width: 15px; margin-bottom: 10px ;" src="/resources/assets/img/jarvis/letterUnRead.png">
												</c:if>
												 
												</td>

												<td style="padding: 10px;"
													onClick="location.href='letterDetailPage?letterId=${data.letterId}'"><p
														style="margin: 0;">${data.sender}</p></td>
												<td style="padding: 10px;"
													onClick="location.href='letterDetailPage?letterId=${data.letterId}'"><p
														style="margin: 0;">${data.title}</p></td>
												<td style="padding: 10px;"
													onClick="location.href='letterDetailPage?letterId=${data.letterId}'"><p
														style="margin: 0;min-width: 100px">${data.letterDate}</p></td>

											</tr>
										</c:forEach>
									</tbody>



								</table>
								<c:if test="${fn:length(letterDatas) <= 0 }">

									<div>쪽지가 없습니다.</div>

								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>

		</section>

		<!-- 추가 -->

		<nav class="blog-pagination justify-content-center d-flex">
			<ul class="pagination">
				
			</ul>
		</nav>
		<!--================ 문제목록 =================-->
	</main>
	<!-- 메인 페이지 푸터 -->
	<%@ include file="../layout/index-footer.jsp"%>
	<!-- 메인 페이지 푸터 -->

	<!-- JS here -->

	<!-- 푸터 고정 스크립트 공통 모음 -->
	<%@ include file="../layout/footer-fix.jsp"%>
	<!-- 푸터 고정 스크립트 공통 모음 -->
	<!-- 찜 하기 스크립트 -->

	
<script>
//각 행의 체크박스에 대한 이벤트 리스너 추가
var letterCheckboxes = document.getElementsByName("lettercheck");
for (var i = 0; i < letterCheckboxes.length; i++) {
    letterCheckboxes[i].addEventListener("change", function() {
        updateCheckAllCheckbox();
        updateFilterButtonText();
    });
}

function updateCheckAllCheckbox() {
    var checkAllCheckbox = document.getElementById("check-all");
    var letterCheckboxes = document.getElementsByName("lettercheck");
    for (var i = 0; i < letterCheckboxes.length; i++) {
        if (!letterCheckboxes[i].checked) {
            checkAllCheckbox.checked = false;
            return; // 하나라도 체크가 풀린 경우 함수를 종료합니다.
        }
    }
    // 모든 체크박스가 선택된 경우에만 전체 선택 체크박스를 체크합니다.
    checkAllCheckbox.checked = true;
}

//전체 선택 체크박스에 대한 변경 이벤트 리스너 추가
document.getElementById("check-all").addEventListener("change", function() {
    var checkboxes = document.getElementsByName("lettercheck");
    var allChecked = this.checked;
    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = allChecked;
    }
    updateFilterButtonText();

    // 모든 체크 박스가 해제된 경우 필터 버튼의 클릭 이벤트 제거
    if (!allChecked) {
        var filterButton = document.querySelector(".letterFilterButton");
        filterButton.removeEventListener("click", letterRead);
        filterButton.removeEventListener("click", letterUnRead);
    }
});

function updateFilterButtonText() {
    var filterButton = document.querySelector(".letterFilterButton");
    
    // 이전에 추가된 클릭 이벤트 리스너를 모두 제거합니다.
    filterButton.removeEventListener("click", letterRead);
    filterButton.removeEventListener("click", letterUnRead);

    var checkedLetterStatus = []; // 체크된 행의 letterStatus 값을 저장할 배열
    var letterCheckboxes = document.getElementsByName("lettercheck");
    for (var i = 0; i < letterCheckboxes.length; i++) {
        if (letterCheckboxes[i].checked) {
            var letterStatusCell = letterCheckboxes[i].parentNode.nextElementSibling.querySelector("p");
            var letterStatus = letterStatusCell.textContent.trim();
            checkedLetterStatus.push(letterStatus);
        }
    }

    if (checkedLetterStatus.includes("F")) {
        filterButton.textContent = "읽음";
        filterButton.addEventListener("click", letterRead);
    } else if (checkedLetterStatus.includes("T")) {
        filterButton.textContent = "안읽음";
        filterButton.addEventListener("click", letterUnRead);
    } else {
        filterButton.textContent = "읽음";
        filterButton.removeEventListener("click", letterRead);
        filterButton.removeEventListener("click", letterUnRead);
    }
}
</script>
<script>
function letterUnRead(){
	console.log("체크 안읽음 처리");
	var checkedLetters =letterArr();
	$.ajax({
		type: "POST",
		url: "/user/letterCheckUnRead",
		data: {
			'letterCheck': checkedLetters
		},
		dataType: 'text',
		success: function(data) {
			console.log(data);
			location.reload();
		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});
	
}

function unRead(letterId){
	console.log("단일 안읽음 처리");
	
	var checkedLetters = [];
	 checkedLetters.push(letterId);
	
 	$.ajax({
		type: "POST",
		url: "/user/letterCheckUnRead",
		data: {
			'letterCheck': checkedLetters
		},
		dataType: 'text',
		success: function(data) {
			console.log(data);
			location.reload();
		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	}); 
	
}
function letterRead(){
	console.log("체크 읽음 처리");
	
	var checkedLetters =letterArr();
	console.log("체크 된거 : "+checkedLetters);
	
	
	$.ajax({
		type: "POST",
		url: "/user/letterCheckRead",
		data: {
			"letterCheck": checkedLetters
		},
		dataType: 'json',
		success: function(data) {
			console.log(data);
			location.reload();
		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});
	
}

function read(letterId){
	console.log("단일 읽음 처리");
	
	var checkedLetters = [];
	 checkedLetters.push(letterId);
	
$.ajax({
		type: "POST",
		url: "/user/letterCheckRead",
		data: {
			"letterCheck": checkedLetters
		},
		dataType: 'json',
		success: function(data) {
			console.log(data);
			location.reload();
		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});
	
}


function letterDelete(){
	console.log("체크 삭제 처리");
	var checkedLetters =letterArr();
	$.ajax({
		type: "POST",
		url: "/user/letterCheckDelete",
		data: {
			'letterCheck': checkedLetters
		},
		dataType: 'text',
		success: function(data) {
			console.log(data);
			location.reload();
		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});
	
}
function letterArr(){
    // 체크된 편지 ID를 담을 배열
    var checkedLetters = [];
    
    // 체크된 편지의 ID를 배열에 추가
    var letterCheckboxes = document.getElementsByName("lettercheck");
    for (var i = 0; i < letterCheckboxes.length; i++) {
        if (letterCheckboxes[i].checked) {
            checkedLetters.push(letterCheckboxes[i].id);
        }
    }
    return checkedLetters;
}




	//안읽은 목록
    // 체크박스 요소 가져오기
    var checkbox = document.getElementById('default-switch');

    // 체크박스에 이벤트 리스너 추가하기
    checkbox.addEventListener('change', function() {
        // 체크박스가 선택되었는지 확인하기
        if (this.checked) {
            // 선택되었을 경우, 어떤 동작 수행 (예: 메시지 표시)
            alert('체크박스가 선택되었습니다!');
            // 여기에 추가적인 동작이나 함수 호출할 수 있습니다
        } else {
            // 선택이 해제되었을 경우, 다른 동작 수행
            alert('체크박스가 해제되었습니다!');
            // 여기에 추가적인 동작이나 함수 호출할 수 있습니다
        }
    });
</script>

<!-- 페이징 js -->
	<script type="text/javascript">
	var currentPage = ${page};
	var totalPage = ${totalPage};
	document.addEventListener('DOMContentLoaded', function() {
	    // 페이지 업데이트 실행
	    pageName='letterListPage';
	    updatePagination();
	});
	</script>
	<script src="/resources/user/js/currentPage.js"></script>
	<!-- 페이징 js -->
</body>

</html>
