<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>유저관리 상세 페이지</title>

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
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<div class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__shake" src="images/logo.png" alt="AdminLTELogo" height="60" width="60">
		</div>

		<!-- Navbar -->
		<nav class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu" href="adminPage.do" role="button"> <img src="images/123.png" alt="Menu" width="30" height="30">
				</a></li>
				<li class="nav-item d-none d-sm-inline-block nav-link">유저상세 페이지</li>
				<li class="nav-item d-none d-sm-inline-block"><a href="logout.do" class="nav-link">로그아웃</a></li>
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
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<a href="/admin/adminPage" class="brand-link"> <img src="images/logo.png" alt="자비스로고" class="brand-image img-circle elevation-3" style="opacity: .8"> <span class="brand-text font-weight-light">관리자</span>
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
								<li class="nav-item"><a href="/admin/memberManagementPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
										<p>유저관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>문제관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/paymentManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>후원관리</p>
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
							</ul></li>
					</ul>
				</nav>
			</div>
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">


			<!-- Main content -->
			<section class="content">
				<div class="container-fluid" style="padding-bottom: 1px;">


					<!-- /.row -->
					<!-- Main row -->
					<div class="col-md-9">
						<div class="card card-primary card-outline">
							<div class="card-header">
								<h3 class="card-title">유저 정보</h3>
							</div>

							<c:choose>
								<c:when test="${not empty memberData}">
									<table border="1">
										<tr>
											<th style="width: 78px;">ID</th>
											<td>${memberData.loginId}</td>
										</tr>
										<tr>
											<th>Login ID</th>
											<td>${memberData.loginId}</td>
										</tr>
										<tr>
											<th>name</th>
											<td>${memberData.name}</td>
										</tr>
										<tr>
											<th>email</th>
											<td>${memberData.email}</td>
										</tr>
										<tr>
											<th>address</th>
											<td>${memberData.address}</td>
										</tr>
										<tr>
											<th>age</th>
											<td>${memberData.age}</td>
										</tr>
									</table>

									<%-- <div class="card-body">
										<div class="form-group">
											<label for="name">이름:</label>
											<input class="form-control" type="text" name="name" value="${member.name}">
										</div>
										<div class="form-group">
											<label for="email">이메일:</label>
											<input class="form-control" type="text" name="email" value="${member.email}">
										</div>
										<div class="form-group">
											<label for="address">주소:</label>
											<input class="form-control" type="text" name="address" value="${member.address}">
										</div>
										<div class="form-group">
											<label for="age">나이:</label>
											<input class="form-control" type="text" name="age" value="${member.age}">
										</div>
									</div> --%>
								</c:when>
								<c:otherwise>
									<p>회원 정보가 없습니다.</p>
								</c:otherwise>
							</c:choose>

							<div class="card-footer">
								<div class="float-left">
									<form action="/admin/adminMemberDelete" method="post">
										<input type="hidden" name="loginId" value="${memberData.loginId}">
										<button type="submit" class="btn btn-block btn-danger">회원삭제</button>
									</form>
								</div>
							</div>
						</div>
					</div>


					<div class="card" style="margin-top: 20px;">
						<div class="card-header">
							<h3 class="card-title">댓글목록</h3>

						</div>

						<div class="card-body table-responsive p-0">
							<table class="table table-hover text-nowrap">
								<thead>
									<tr>
										<th>번호</th>
										<th>아이디</th>
										<th>댓글내용</th>
										<th>상태</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty commentDatas}">
										<tr>
											<td colspan="1">작성된 댓글이 없습니다.</td>
										</tr>
									</c:if>

									<c:forEach var="data" items="${commentDatas}" varStatus="loop">
										<tr>
											<td>${loop.index + 1}</td>
											<td>${data.loginId}</td>
											<td>${data.comments}</td>

											<td>
												<input class="cId" type="hidden" value="${data.commentId}" />
												<button type="button" class="commentDelete">삭제</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>

				</div>
		</div>
		<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<footer class="main-footer">
		<strong>자비스(주) &copy; 1234-5678 </strong> All rights reserved.
		<div class="float-right d-none d-sm-inline-block">
			<b>Version</b> 3.2.0
		</div>
	</footer>

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

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
	<script src="js/commentDelete.js"></script>
</body>
</html>
