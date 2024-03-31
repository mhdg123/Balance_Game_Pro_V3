<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zxx">
<!-- css -->
<%@ include file="../layout/header-fix.jsp"%>
<title>Watch shop | eCommers</title>
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

					<!-- <div class="table-responsive">
						<div class="d-flex align-items-center justify-content-between">
							내 찜보기 필터 토글 버튼
							<a href="/user/makeQuestionPage" class="genric-btn info radius"
								style="margin-right: 12px;">건의하기</a>
							<div class="switch-wrap d-flex align-items-center">
								<p style="margin-right: 6px; margin-bottom: 0;">읽지 않은 메일</p>
								<div class="primary-switch">
									<input type="checkbox" id="default-switch" /> <label
										for="default-switch"></label>
								</div>
							</div>
						</div>
					</div> -->

					<!-- 내 찜보기 필터 토글 버튼 -->

					<!-- 추가 -->
					<div class="container">
						<div class="cart_inner">
							<div class="table-responsive">
								<table class="table" style="width: 100%; margin: 0">
									<tr>
										<th style="width: 5%"><input type="checkbox" id="check-all"></th>
										<th  class="letterFilterButton">읽음</th>
										<th  class="letterFilterButton">삭제</th>
										<th style="text-align: right;width:70%">읽지 않은 메일</th>
										<th>
											<div class="primary-switch">
												<input type="checkbox" id="default-switch" /> <label
													for="default-switch"></label>
											</div>
										</th>
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
												<td style="padding: 10px;"><p style="margin: 0;">${data.letterStatus}</p></td>

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
				<li class="page-item"><a onclick="beforeData();"
					class="page-link" aria-label="Previous"> <i
						class="ti-angle-left"></i>
				</a></li>
				<li class="page-item"><a href="#" class="page-link">1</a></li>
				<li class="page-item active"><a href="#" class="page-link">2</a>
				</li>
				<li class="page-item"><a onclick="nextData();"
					class="page-link" aria-label="Next"> <i class="ti-angle-right"></i>
				</a></li>
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
		function test1() {
			alert("문제 상세페이지 이동");
		}
		function nextData() {
			alert("다음 페이지");
		}

		function beforeData() {
			alert("이전 페이지 ");
		}
	</script>
	
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
	console.log("안읽음 처리");
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

		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});
	
}
function letterRead(){
	console.log("읽음 처리");
	
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

		},
		error: function(error) {
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});
	
}
function letterDelete(){
	console.log("삭제 처리");
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

</script>
	
</body>

</html>