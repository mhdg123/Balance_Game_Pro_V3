<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!-- 헤더 고정 -->
<%@ include file="../adminLayout/header-fix.jsp"%>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<!-- 상단 nav 바 -->
		<%@ include file="../adminLayout/header.jsp"%>
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
								<li class="nav-item"><a href="/admin/memberManagementPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>유저관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>문제관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/paymentManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>포인트 결제 관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminItemManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>아이템관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminLetterListPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
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




		<!-- 총문제 수, 문제 승인, 회원수, 후원금액 -->
		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<!-- Small boxes (Stat box) -->


					<!-- /.row -->
					<!-- 건의 사항 데이터 시작 -->

					<div class="row">
						<div class="card-body table-responsive p-0">

							<div class="card" style="margin-top: 20px;">
								<div class="card-header">
									<h3 class="card-title">건의사항</h3>
									<div class="card-tools">
										<div style="margin-left: 66px;">
											<!-- <label>이름 검색</label>
											<input id="searchName" type="checkbox"> -->
										</div>
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
												<th>제목</th>
												<th>읽음 상태</th>
												<th>날짜</th>
											</tr>
${letterDatas}
										</thead>
										<tbody>
											<c:if test="${empty letterDatas}">
												<tr>
													<td colspan="1">건의사항이 없습니다.</td>
												</tr>

											</c:if>
										<tbody id="suggestionTableBody">
											<c:forEach var="data" items="${letterDatas}">
												
													<tr onclick="location.href = '/admin/letterDetailPage?letterId=${data.letterId}'">
														<td id="loginIdData">${data.sender}</td>
														<td id="titleData">${data.title}</td>
														<c:if test="${data.letterStatus == 'T' }">
															<td id="titleData">읽음</td>
														</c:if>
														<c:if test="${data.letterStatus == 'F' }">
															<td id="titleData">읽지 않음</td>
														</c:if>
														<td id="titleData">${data.letterDate}</td>
													</tr>
												
											</c:forEach>
										</tbody>
										</tbody>
									</table>
									<nav class="blog-pagination justify-content-center d-flex">
										<ul class="pagination">
                           				</ul>
									</nav>
								</div>

							</div>
						</div>
					</div>
					<!-- 건의 사항 데이터 끝 -->
				</div>
			</section>
		</div>
	</div>
	<!-- 푸터 -->
	<%@ include file="../adminLayout/footer.jsp"%>
	<!-- 스크립트 모음 -->
	<!-- 페이징 js -->
	<script type="text/javascript">
		var currentPage = ${page};
		var totalPage = ${totalPage};
		console.log(currentPage);
		document.addEventListener('DOMContentLoaded', function() {
			// 페이지 업데이트 실행
			pageName = 'memberManagementPage';
			updatePagination();
		});
	</script>
	<script src="/resources/user/js/currentAdminPage.js"></script>
	<%@ include file="../adminLayout/footer-fix.jsp"%>

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</body>
</html>
