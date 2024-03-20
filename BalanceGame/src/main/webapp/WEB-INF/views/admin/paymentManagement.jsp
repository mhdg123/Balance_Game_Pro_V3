<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<!-- 헤더 고정 -->
<%@ include file="../adminLayout/header-fix.jsp"%>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<div class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__shake" src="images/logo.png" alt="AdminLTELogo" height="60" width="60">
		</div>
		<!-- 상단 nav 바 -->
		<jsp:include page="../adminLayout/header.jsp" />
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
								<li class="nav-item"><a href="/admin/memberManagementPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>유저관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>문제관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/paymentManagementPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
										<p>후원관리</p>
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
									<div class="row">
										<div class="col-md-6">
											<h3 class="card-title">후원목록</h3>
										</div>
										<div class="col-md-6">
											<div class="btn-group float-right" role="group" aria-label="후원순">
												<button type="button" class="btn btn-outline-success" id="btnDate">최신순</button>
												<button type="button" class="btn btn-outline-success" id="btnRank">후원순</button>
											</div>
										</div>

									</div>
								</div>


								<div class="row">
									<div class="col-sm-6">
										<!-- 해당 구역 왼쪽 내용 -->
									</div>
									<div class="col-sm-6">
										<!-- 검색 버튼 -->
										<div class="text-right" style="padding-right: 10px;">
											<input id="range_1" type="hidden" name="range_1" value="" class="irs-hidden-input" tabindex="-1" readonly="">
											<button type="button" class="btn btn-outline-primary btn-sm" id="btn" style="width: 50px">검색</button>
										</div>
									</div>
								</div>


								<div class="card-body table-responsive p-0">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>번호</th>
												<th>ID(닉네임)</th>
												<th>후원금액</th>
												<th>날짜</th>
											</tr>
										</thead>


										<tbody>
											<c:if test="${empty sdatas}">
												<tr>
													<td colspan="1">회원 정보가 없습니다.</td>
												</tr>

											</c:if>


											<c:forEach var="data" items="${sdatas}" varStatus="loop">
												<tr onclick="location.href = 'adminMemberDetailPage.do?loginId=${data.loginId}'">
													<td>${loop.index + 1}</td>
													<td>
														<%-- <crown:crown ranking="${data.ranking}" />${data.name}(${data.loginId})</td> --%>
													<td>
														<fmt:formatNumber value="${data.total}" currencyCode="KRW" />
													</td>
													<td>${data.date}</td>
												</tr>

											</c:forEach>
										</tbody>
									</table>
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
		

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<%@ include file="../adminLayout/footer.jsp"%>
	<%@ include file="../adminLayout/footer-fix.jsp"%>
	<script>
		$(function() {
			/* BOOTSTRAP SLIDER */
			$('.slider').bootstrapSlider()

			/* ION SLIDER */
			$('#range_1').ionRangeSlider({
				min : 0,
				max : 10000000,
				from : 0,
				to : 10000000,
				type : 'double',
				step : 1,
				prefix : '￦',
				prettify : false,
				hasGrid : true
			})
		})
	</script>
</body>
</html>