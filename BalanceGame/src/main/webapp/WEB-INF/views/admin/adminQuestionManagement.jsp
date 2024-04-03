<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 헤더 고정 -->
<%@ include file="../adminLayout/header-fix.jsp"%>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="../adminLayout/header.jsp" />
		<!-- 왼쪽 사이드 바 -->
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
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
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
									<h3 class="card-title">문제목록</h3>
									<div class="card-tools">

										<div class="input-group input-group-sm" style="width: 100px;">
											<a href="/admin/adminMakeQuestionPage"><button type="button" class="btn btn-block btn-primary">문제출제</button></a>
											<div class="input-group-append"></div>
										</div>
									</div>
									<div class="card-tools">

										<div class="input-group input-group-sm" style="width: 120px;">
											<a href="/admin/questionAccessPage"><button type="button" class="btn btn-block btn-success">문제승인</button></a>
											<div class="input-group-append"></div>
										</div>
									</div>
								</div>

								<div class="card-body table-responsive p-0">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>NO</th>
												<th>아이디</th>
												<th>제목</th>
												<th>상세 이유</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${empty questionDatas}">
												<tr>
													<td colspan="1">출제된 문제가 없습니다.</td>
												</tr>
											</c:if>
											<c:forEach var="data" items="${questionDatas}" varStatus="loop">
												<tr onclick="location.href = '/admin/questionDetailPage?questionId=${data.questionId}'">
													<td>${loop.index + 1}</td>
													<td>${data.writer}</td>
													<td>${data.title}</td>
													<td>${data.explanation}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
             								<ul class="pagination">
										<li class="paginate_button page-item previous" id="example2_previous">
											<a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
										</li>
										<li class="paginate_button page-item ">
											<a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a>
										</li>
										<li class="paginate_button page-item ">
											<a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a>
										</li>
										<li class="paginate_button page-item ">
											<a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a>
										</li>
										<li class="paginate_button page-item ">
											<a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0" class="page-link">4</a>
										</li>
										<li class="paginate_button page-item active">
											<a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0" class="page-link">5</a>
										</li>
										<li class="paginate_button page-item ">
											<a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0" class="page-link">6</a>
										</li>
										<li class="paginate_button page-item next" id="example2_next">
											<a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
										</li>
									</ul>
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
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="/resources/adminLte/dist/js/pages/dashboard.js"></script>
	<!-- 인공지능 -->
	<script src="/resources/adminLte/dist/js/ai.js"></script>
</body>
</html>
