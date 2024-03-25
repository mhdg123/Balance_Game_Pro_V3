<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!-- 헤더 고정 -->
<%@ include file="../adminLayout/header-fix.jsp"%>
<!-- <style>
   .table td:first-child {
        text-align: left;
    }
    .table th, .table td {
        text-align: center;
    }
     .table th:first-child, .table td:first-child {
        text-align: left;
    }
    .table th, .table td {
        text-align: center;
    }
    .table th:first-child, .table td:first-child {
        text-align: left;
        width: 80px; /* 아이템 번호의 너비를 조정합니다. */
    }
    .table td:first-child {
        text-align: center; /* 아이템 번호 열의 텍스트를 가운데 정렬합니다. */
    }
</style> -->
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<div class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__shake" src="images/logo.png" alt="AdminLTELogo" height="60" width="60">
		</div>

		<jsp:include page="../adminLayout/header.jsp" />

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
								<li class="nav-item"><a href="/admin/memberManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>유저관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>문제관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/paymentManagementPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>후원관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminItemManagementPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
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
				<section class="content">
					<div class="row" style="display: flex; justify-content: center">
						<div class="col-md-9">
							<div class="card">
								<div class="card-header p-2">
									<ul class="nav nav-pills">
										<li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">아이템</a></li>
										<li class="nav-item"><a class="nav-link" href="#timeline" data-toggle="tab">포인트</a></li>
										<div class="input-group input-group-sm ml-auto" style="width: 120px;">
											<a href="/admin/adminCreateItemPage"><button type="button" class="btn btn-block btn-success">아이템 추가</button></a>
											<div class="input-group-append"></div>
										</div>
									</ul>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<div class="tab-content">
										<div class="tab-pane active" id="activity">
											<!-- 아이템 데이터 공간 -->
											<div class="card-body table-responsive p-0">
												<table class="table table-hover text-nowrap">
													<thead>
														<tr>
															<th>NO</th>
															<th>아이템 명</th>
															<th>포인트</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="data" items="${itemTypeDatas}" varStatus="loop">
																<tr onclick="location.href = '/admin/itemDetailPage?itemId=${data.itemId}'">
																	<td>${loop.index + 1}</td>
																	<td>${data.itemName}</td>
																	<td>${data.itemPrice}</td>
																	<td>${data.itemType}</td>
																</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
										<div class="tab-pane" id="timeline">
											<!-- 포인트 데이터 공간 -->
											<div class="card-body table-responsive p-0">
												<table class="table table-hover text-nowrap">
													<thead>
														<tr>
															<th>아이템 번호</th>
															<th>아이템 명</th>
															<th>포인트</th>
															<th>타입</th>

														</tr>
													</thead>
													<tbody>
														<c:forEach var="data" items="${pointTypeDatas}" varStatus="loop">
																<tr onclick="location.href = '/admin/itemDetailPage?itemId=${data.itemId}'">
																	<td>${loop.index + 1}</td>
																	<td>${data.itemName}</td>
																	<td>${data.itemPrice}</td>
																	<td>${data.itemType}</td>
																</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>

					</div>
					<div class="row"></div>
				</section>

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
	<script>
		$(document).ready(function() {
			// 페이지가 로드될 때 기본적으로 아이템 탭의 데이터를 표시
			$('#activity').addClass('active');
			$('#timeline').removeClass('active');

			// 탭이 클릭될 때 해당 탭의 데이터를 표시
			$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
				var target = $(e.target).attr("href"); // activated tab
				if (target === "#activity") {
					$('#activity').addClass('active');
					$('#timeline').removeClass('active');
				} else if (target === "#timeline") {
					$('#timeline').addClass('active');
					$('#activity').removeClass('active');
				}
			});
		});
	</script>
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






</body>
</html>
