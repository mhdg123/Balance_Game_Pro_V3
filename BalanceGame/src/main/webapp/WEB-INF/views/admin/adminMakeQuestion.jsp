<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<title>관리자 문제출제 페이지</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="/resources/adminLte/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet" href="/resources/adminLte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="/resources/adminLte/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="/resources/adminLte/plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/resources/adminLte/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet" href="/resources/adminLte/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet" href="/resources/adminLte/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet" href="/resources/adminLte/plugins/summernote/summernote-bs4.min.css">
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
					<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
						<li class="nav-item menu-open"><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
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
				<section class="content">
					<div class="row" style="display: flex; justify-content: center">
						<div class="col-md-6">
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">문제</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
											<i class="fas fa-minus"></i>
										</button>
									</div>
								</div>

								<form action="/admin/titleCreate" method="POST" id="insertForm" enctype="multipart/form-data">
									<div class="card-body">
										<div class="form-group">

											<input type="hidden" name="writer" value="관리자">

											<label for="inputName">제목</label>
											<input type="text" id="inputName" class="form-control" name="title">
										</div>
										<div class="form-group">
											<label for="inputDescription">선택지A</label>
											<textarea id="inputDescription" class="form-control" name="answerA" rows="2"></textarea>
										</div>
										<div class="form-group">
											<label for="inputDescription">선택지B</label>
											<textarea id="inputDescription" class="form-control" name="answerB" rows="2"></textarea>
										</div>
										<div class="form-group">
											<label for="inputDescription">출제 이유</label>
											<textarea id="inputDescription" class="form-control" name="explanation" rows="3"></textarea>
										</div>
										<div class="custom-file">
										<input type="file" class="custom-file-input" id="fileFirst" name="file" onchange="displayFileName('First')">
										<label class="custom-file-label" for="fileFirst" id="fileNameFirstLabel">${itemData.itemImg }</label>
									</div>
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="fileSecond" name="file" onchange="displayFileName('Second')">
										<label class="custom-file-label" for="fileSecond" id="fileNameSecondLabel">${itemData.itemImg }</label>
									</div>
										<button type="submit" class="btn btn-block btn-primary">문제출제</button>
									</div>
								</form>

							</div>

						</div>

					</div>
					<div class="row"></div>
				</section>

				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
	<%@ include file="../adminLayout/footer.jsp"%>
	</div>
	<!-- ./wrapper -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

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
	<script src="/resources/adminLte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- ChartJS -->
	<script src="/resources/adminLte/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="/resources/adminLte/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script src="/resources/adminLte/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="/resources/adminLte/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="/resources/adminLte/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="/resources/adminLte/plugins/moment/moment.min.js"></script>
	<script src="/resources/adminLte/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script src="/resources/adminLte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script src="/resources/adminLte/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script src="/resources/adminLte/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/resources/adminLte/dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="/resources/adminLte/dist/js/pages/dashboard.js"></script>
	<!-- 인공지능 -->
	<script src="/resources/adminLte/dist/js/ai.js"></script>

	<!-- <script src="/resources/adminLte/js/blankSpace.js"></script> -->
	<!-- 공백을 막아주는 js -->
	<script src="/resources/adminLte/js/submitBlankCheck.js"></script>
	<!-- 공백 폼 제출을 막아주는 js -->
	
	
	<script>
    document.getElementById("insertForm").addEventListener("submit", function(event) {
        var title = document.getElementById("inputName").value.trim();
        var answerA = document.getElementsByName("answerA")[0].value.trim();
        var answerB = document.getElementsByName("answerB")[0].value.trim();
        var explanation = document.getElementsByName("explanation")[0].value.trim();
        var errorMessage = "";

        if (title === "") {
            errorMessage += "제목을 입력해주세요.\n";
            document.getElementById("inputName").focus();
        }
        if (answerA === "") {
            errorMessage += "선택지A를 입력해주세요.\n";
            document.getElementsByName("answerA")[0].focus();
        }
        if (answerB === "") {
            errorMessage += "선택지B를 입력해주세요.\n";
            document.getElementsByName("answerB")[0].focus();
        }
        if (explanation === "") {
            errorMessage += "출제 이유를 입력해주세요.\n";
            document.getElementsByName("explanation")[0].focus();
        }

        if (errorMessage !== "") {
            alert(errorMessage);
            event.preventDefault(); // 폼 제출 방지
        }
    });
    
 // 파일 등록시 파일명 출력
	   function displayFileName(location) {
		 	var input = document.getElementById('file'+location);
	        var label = document.getElementById('fileName'+ location + 'Label');
	        var fileName = input.files[0].name;
	        label.innerHTML = fileName;
	    }
	  
</script>
	
</body>
</html>
