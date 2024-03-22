<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="preloader flex-column justify-content-center align-items-center">
	<img class="animation__shake" src="images/logo.png" alt="AdminLTELogo" height="60" width="60">
</div>
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"  role="button"> <img src="images/123.png" alt="메뉴로고" width="30" height="30">
		</a></li>
		<a href="/"><li class="nav-item d-none d-sm-inline-block nav-link">메인 페이지</li></a>
		<c:if test="${loginId != null }">
			<li class="nav-item d-none d-sm-inline-block"><a href="/user/logout" class="nav-link">로그아웃</a></li>
		</c:if>
	</ul>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item dropdown">
			<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
				<div class="dropdown-divider"></div>
				<div class="dropdown-divider"></div>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
			</div>
		</li>
		<li class="nav-item dropdown"></li>

	</ul>
</nav>