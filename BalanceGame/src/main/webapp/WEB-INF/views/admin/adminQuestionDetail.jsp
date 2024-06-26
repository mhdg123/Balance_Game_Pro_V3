<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<title>관리자 문제 상세 페이지</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="/resources/adminLte/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="/resources/adminLte/plugins/summernote/summernote-bs4.min.css">
<style>
.message {
	border-top: 1px solid #ccc;
	padding: 10px;
	margin-top: 5px;
	background-color: #e6e6e6;
}

#chat-container {
	width: 400px;
	height: 600px;
	display: flex;
	flex-direction: column;
	border: 1px solid #ccc;
}

#chat-messages {
	flex: 1;
	overflow-y: auto;
	padding: 10px;
	display: flex;
	flex-direction: column-reverse;
}

#user-input {
	display: flex;
	padding: 10px;
}

#user-input input {
	flex: 1;
	padding: 10px;
	outline: none;
}

#user-input button {
	border: none;
	background-color: #1e88e5;
	color: white;
	padding: 10px 15px;
	cursor: pointer;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

				<!-- Preloader -->
		<div class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__shake" src="/resources/adminLte/images/logo.png" alt="AdminLTELogo" height="60" width="60">
		</div>

		<!-- Navbar -->
		<nav class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu" href="/admin/adminPage" role="button"> <img src="/resources/adminLte/images/123.png" alt="Menu" width="30" height="30">
				</a></li>
				<li class="nav-item d-none d-sm-inline-block nav-link">문제관리</li>
				<li class="nav-item d-none d-sm-inline-block"><a href="/user/logout" class="nav-link">로그아웃</a></li>
			</ul>
			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">

				<!-- Messages Dropdown Menu -->
				<li class="nav-item dropdown">
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<div class="dropdown-divider"></div>
						<div class="dropdown-divider"></div>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
					</div>
				</li>
				<!-- Notifications Dropdown Menu -->
				<li class="nav-item dropdown"></li>

			</ul>
		</nav>
		<!-- 왼쪽 사이드 바 -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<a href="/admin/adminPage" class="brand-link"> 
			<img src="/resources/adminLte/images/logo.png" alt="자비스로고" class="brand-image img-circle elevation-3" style="opacity: .8"> 
			<span class="brand-text font-weight-light">관리자</span>
			</a>

			<div class="sidebar">

				<div class="form-inline"></div>

				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<li class="nav-item menu-open"><a href="#"
							class="nav-link active"> <i
								class="nav-icon fas fa-tachometer-alt"></i>
								<p>
									관리 <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a href="/admin/adminPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>메인</p>
								</a></li>
								<li class="nav-item"><a href="/admin/memberManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>유저관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
										<p>문제관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/paymentManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>포인트 결제 관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminItemManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>아이템관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminLetterListPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>건의사항관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminAdvertisementManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>광고관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/warningManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>신고관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminChartManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>통계관리</p>
								</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">


			<!-- Main content -->

			<section class="content">
				<div class="row">
					<div class="col-md-6">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">문제</h3>
								<div class="card-tools">
									<button type="button" class="btn btn-tool"
										data-card-widget="collapse" title="Collapse">
										<i class="fas fa-minus"></i>
									</button>
								</div>
							</div>

							<form action="/admin/questionUpdate" method="POST"
								id="insertForm" enctype="multipart/form-data">
								<div class="card-body">
									<div class="form-group">
										<input type="hidden" value="${questionData.questionId}"
											name="questionId"> <label for="inputName">제목</label>
										<input type="text" id="inputName" class="form-control"
											name="title" value="${questionData.title}">
									</div>
									<div class="form-group">
										<label for="inputDescription">선택지A</label>

										<!-- 이미지 출력 -->
										<div class="image-show" id="chooseFileAInput">
											<c:if test="${not empty questionData.answerAImg }">
												<div style="text-align: center;">
													<img class="img" id="chooseFileAImage"
														src="/resources/upload/${questionData.answerAImg}"
														style="width: 70%; height: 70%; object-fit: contain;">
												</div>
												<div class="deleteButton" id="chooseFileAdeleteButton"
													style="color: black; text-align: center;"
													onclick="deleteImage('chooseFileA')">[사진등록취소]</div>
											</c:if>
										</div>
										<!-- 이미지 출력 -->

										<input type="hidden" value="${questionData.answerAImg}"
											name="answerAImg"> <input type="hidden" value="F"
											name="retouch" id="chooseFileARetouch">


										<textarea id="inputDescription" class="form-control" rows="2"
											name="answerA">${questionData.answerA}</textarea>


										<!-- 이미지 변경 -->
										<label for="chooseFileA" class="custom-file-upload"> <span>파일
												선택</span>
										</label> <input type="file" accept="image/*" name="file"
											id="chooseFileA" onchange="loadFile(this)"
											style="display: none;">
										<!-- 이미지 변경 -->



									</div>


									<div class="form-group">
										<label for="inputDescription">선택지B</label>


										<!-- 이미지 출력 -->
										<div class="image-show" id="chooseFileBInput">
											<c:if test="${not empty questionData.answerBImg }">
												<div style="text-align: center;">
													<img class="img" id="chooseFileBImage"
														src="/resources/upload/${questionData.answerBImg}"
														style="width: 70%; height: 70%; object-fit: contain;">
												</div>
												<div class="deleteButton" id="chooseFileBdeleteButton"
													style="color: black; text-align: center;"
													onclick="deleteImage('chooseFileB')">[사진등록취소]</div>
											</c:if>
										</div>
										<!-- 이미지 출력 -->

										<input type="hidden" value="${questionData.answerBImg}"
											name="answerBImg"> <input type="hidden" value="F"
											name="retouch" id="chooseFileBRetouch">

										<textarea id="inputDescription" class="form-control" rows="2"
											name="answerB">${questionData.answerB }</textarea>


										<!-- 이미지 변경 -->
										<label for="chooseFileB" class="custom-file-upload"> <span>파일
												선택</span>
										</label> <input type="file" accept="image/*" name="file"
											id="chooseFileB" onchange="loadFile(this)"
											style="display: none;">
										<!-- 이미지 변경 -->


									</div>
									<div class="form-group">
										<label for="inputDescription">설명</label> <input type="text"
											id="inputName" class="form-control" name="explanation"
											value="${questionData.explanation}">
									</div>


									<input type="hidden" name="questionId" value="${questionData.questionId}" />
									<input type="hidden" id="questionAccessHidden" name="questionAccess" value="${questionData.questionAccess}" />
									<%-- <input type="text" name="questionAccess" value="${questionData.questionAccess}" /> --%>
									출제 <input type="checkbox" id="questionAccess">
										
									<button type="submit" class="btn btn-block btn-primary"
										style="margin-bottom: 10px; margin-top: 10px;">문제수정</button>
								</div>
							</form>
							<form action="/admin/adminQuestionDelete" method="POST">
								<input type="hidden" name="questionId"
									value="${questionData.questionId}" />
								<button type="submit" class="btn btn-block btn-danger"
									style="margin-bottom: 10px;">문제 삭제</button>

							</form>

						</div>

					</div>


				</div>
			</section>
		</div>
	</div>



	<!-- /.container-fluid -->

	<!-- /.content -->

	<%@ include file="../adminLayout/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<script src="js/blankSpace.js"></script>
	<!-- 공백을 막아주는 js -->
	<script src="js/submitBlankCheck.js"></script>

	<script src="js/categoryCheck.js"></script>


	<!-- jQuery -->

	<script src="/resources/adminLte/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="/resources/adminLte/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script
		src="/resources/adminLte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- ChartJS -->
	<script src="/resources/adminLte/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="/resources/adminLte/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script src="/resources/adminLte/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script
		src="/resources/adminLte/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="/resources/adminLte/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="/resources/adminLte/plugins/moment/moment.min.js"></script>
	<script
		src="/resources/adminLte/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="/resources/adminLte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script
		src="/resources/adminLte/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="/resources/adminLte/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/resources/adminLte/dist/js/adminlte.js"></script>

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="/resources/adminLte/dist/js/pages/dashboard.js"></script>

	<script>
		// 문제 출제 여부 체크 //

		// 페이지가 로드될 때 실행되는 함수
window.onload = function() {
    // questionAccess 요소의 값 가져오기
    var questionAccessValue = "${questionData.questionAccess}";

    // questionAccess 요소의 값이 "T"인 경우 체크
    if (questionAccessValue === "T") {
        document.getElementById("questionAccess").checked = true;
    } else {
        document.getElementById("questionAccess").checked = false;
    }
    // questionAccess 요소의 값 설정
    document.getElementById("questionAccess").value = questionAccessValue;

    // 체크박스가 변경될 때 실행되는 함수
    document.getElementById("questionAccess").addEventListener("change", function() {
        // 체크박스가 체크되어 있는지 확인
        var isChecked = this.checked;

        // 컨트롤러에 전송할 값 설정
        var valueToSend = isChecked ? "T" : "F";

        // 여기서 컨트롤러에 값을 전송하는 코드를 추가하면 됩니다.
        console.log("전송할 값:", valueToSend);
        document.getElementById("questionAccessHidden").value = valueToSend;
    });
};
	</script>
	
		<!-- input 태그 사진 넣는 js  -->
	<script src="/resources/user/js/image.js"></script>
	
	
</body>
</html>
