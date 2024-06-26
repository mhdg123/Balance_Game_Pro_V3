<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<title>관리자 문제승인 페이지</title>

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
<script>
    // 문제등록시간 포멧팅
    function formatCreateTime(time) {
        var date = new Date(time);
        var year = date.getFullYear().toString().slice(-2); // 연도 뒤의 두 자리만 가져오기
        var month = ("0" + (date.getMonth() + 1)).slice(-2); // 월 가져오기 (월은 0부터 시작하므로 +1 해줌)
        var day = ("0" + date.getDate()).slice(-2); // 일 가져오기
        var hours = date.getHours();
        var minutes = ("0" + date.getMinutes()).slice(-2); // 분 가져오기
        var ampm = hours >= 12 ? 'PM' : 'AM'; // 오전/오후 구분
        hours = hours % 12; // 12시간 형식으로 변환
        hours = hours ? hours : 12; // 0시는 12시로 표시
        var formattedHours = ("0" + hours).slice(-2); // 두 자리 숫자로 표현
        var formattedTime = year + "/" + month + "/" + day + " " + ampm + " " + formattedHours + ":" + minutes + " [ " + getTimeAgo(date) + " ]";
        return formattedTime;
    }

    // 시간 차이 계산 함수
    function getTimeAgo(date) {
        var now = new Date(); // 현재 시간 가져오기
        var diff = Math.floor((now - date) / (1000 * 60)); // 분 단위로 현재 시간과의 차이 계산
        
        if (diff < 1) {
            return "방금 전";
        } else if (diff < 60) {
            return diff + "분전";
        } else if (diff < 1440) {
            return Math.floor(diff / 60) + "시간 전";
        } else {
            return Math.floor(diff / 1440) + "일 전";
        }
    }
</script>


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
<style>
/* 스타일링을 위한 CSS */
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
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
				<div class="container-fluid">

					<!-- /.row -->
					<!-- Main row -->
					<div class="row">
						<div class="col-12">
							<div class="card" style="margin-top: 20px;">
								<div class="card-header">
									<h3 class="card-title">문제승인목록</h3>
									<div class="card-tools">

										<div class="input-group input-group-sm" style="width: 100px;">
											<a href="/admin/adminMakeQuestionPage"><button type="button" class="btn btn-block btn-primary">문제출제</button></a>
											<div class="input-group-append"></div>
										</div>
									</div>
								</div>

								<div class="card-body table-responsive p-0">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>NO</th>
												<th>Writer</th>
												<th>Title</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${fn:length(questionDatas_f) <=0 }">
												<tr>
													<td colspan="1">출제문제가 없습니다</td>
												</tr>
											</c:if>
											<c:set var="startIndex" value="${(page-1)*10}" />
											<c:forEach var="data" items="${questionDatas_f}" varStatus="loop">
												<tr onclick="location.href = '/admin/questionDetaileAccessPage?questionId=${data.questionId}'">
													<td>${startIndex+loop.index + 1}</td>
													<td>${data.writer}</td>
													<td>${data.title}</td>
													<td>${data.questionDate}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<nav class="blog-pagination justify-content-center d-flex">
										<ul class="pagination">
                           								</ul>
									</nav>
								</div>

							</div>



						</div>

						<!-- right col (We are only adding the ID to make the widgets sortable)-->

						<!-- right col -->
					</div>
					<!-- /.row (main row) -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
	<%@ include file="../adminLayout/footer.jsp"%>
	</div>
	<!-- ./wrapper -->
		<!-- 페이징 js -->
	<script type="text/javascript">
		var currentPage = ${page};
		var totalPage = ${totalPage};
		console.log(currentPage);
		document.addEventListener('DOMContentLoaded', function() {
			// 페이지 업데이트 실행
			pageName = 'questionManagementPage';
			updatePagination();
		});
	</script>
	<script src="/resources/user/js/currentAdminPage.js"></script>

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
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="/resources/adminLte/dist/js/pages/dashboard.js"></script>
	<!-- 인공지능 -->
	<script src="/resources/adminLte/dist/js/ai.js"></script>
</body>
</html>
