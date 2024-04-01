<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<!-- 헤더 고정 -->
<%@ include file="../adminLayout/header-fix.jsp"%>

<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<div class="preloader flex-column justify-content-center align-items-center">
			<img class="animation__shake" src="images/logo.png" alt="AdminLTELogo" height="60" width="60">
		</div>
		<!-- 상단 nav 바 -->
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
								<li class="nav-item"><a href="/admin/warningManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>신고관리</p>
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
									<h3 class="card-title">유저목록</h3>
									<div class="card-tools">
										<div class="input-group input-group-sm" style="width: 150px;">
											<input type="text" id="searchLoginId" name="table_search" class="form-control float-right" placeholder="검색">
											<div class="input-group-append">
												<button type="submit" class="btn btn-default">
													<i class="fas fa-search"></i>
												</button>
											</div>
										</div>
									</div>
								</div>

								<div class="card-body table-responsive p-0">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<th>아이디</th>
												<th>주소</th>
												<th>이메일</th>
												<th>나이</th>
												<th>성별</th>
												<th>후원금액</th>
												<th>후원랭킹</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${empty memberDatas}">
												<tr>
													<td colspan="1">회원 정보가 없습니다.</td>
												</tr>

											</c:if>
										</tbody>
										<tbody id="suggestionTableBody">
											<c:forEach var="data" items="${memberDatas}">
												<tr onclick="location.href = '/admin/adminMemberDetailPage?loginId=${data.loginId}'">
													<td id="loginIdData">${data.loginId}</td>
													<td id="addressData">${data.address}</td>
													<td id="eamilData">${data.email}</td>
													<td id="ageData">${data.age}</td>
													<td id="genderData">${data.gender}</td>
													<td id="totalData">
														<fmt:formatNumber value="${data.total}" currencyCode="KRW" />
													</td>
													<td id="rankingData">${data.ranking}</td>
												</tr>

											</c:forEach>
										</tbody>
									</table>
								</div>

							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<!-- 푸터 -->
	<jsp:include page="../adminLayout/footer.jsp" />
	<!-- 스크립트 모음 -->
	<jsp:include page="../adminLayout/footer-fix.jsp" />
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</body>
</html>