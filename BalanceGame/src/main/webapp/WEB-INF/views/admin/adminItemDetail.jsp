<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<title>관리자 아이템 상세 페이지</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">

<link rel="stylesheet" href="/resources/adminLte/plugins/fontawesome-free/css/all.min.css">

<link rel="stylesheet" href="/resources/adminLte/plugins/ekko-lightbox/ekko-lightbox.css">

<link rel="stylesheet" href="/resources/adminLte/dist/css/adminlte.min.css?v=3.2.0">
<script defer="" referrerpolicy="origin" src="/cdn-cgi/zaraz/s.js?z=JTdCJTIyZXhlY3V0ZWQlMjIlM0ElNUIlNUQlMkMlMjJ0JTIyJTNBJTIyQWRtaW5MVEUlMjAzJTIwJTdDJTIwR2FsbGVyeSUyMiUyQyUyMnglMjIlM0EwLjE0OTUwMTQxMTUxMDc2ODklMkMlMjJ3JTIyJTNBMTUzNiUyQyUyMmglMjIlM0E4NjQlMkMlMjJqJTIyJTNBNzM4JTJDJTIyZSUyMiUzQTE1MzYlMkMlMjJsJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZhZG1pbmx0ZS5pbyUyRnRoZW1lcyUyRnYzJTJGcGFnZXMlMkZnYWxsZXJ5Lmh0bWwlMjIlMkMlMjJyJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZhZG1pbmx0ZS5pbyUyRnRoZW1lcyUyRnYzJTJGJTIyJTJDJTIyayUyMiUzQTI0JTJDJTIybiUyMiUzQSUyMlVURi04JTIyJTJDJTIybyUyMiUzQS01NDAlMkMlMjJxJTIyJTNBJTVCJTVEJTdE"></script><script nonce="251f9257-59ea-4d72-9e68-7435c37cb0ec">try{(function(w,d){!function(lD,lE,lF,lG){lD[lF]=lD[lF]||{};lD[lF].executed=[];lD.zaraz={deferred:[],listeners:[]};lD.zaraz.q=[];lD.zaraz._f=function(lH){return async function(){var lI=Array.prototype.slice.call(arguments);lD.zaraz.q.push({m:lH,a:lI})}};for(const lJ of["track","set","debug"])lD.zaraz[lJ]=lD.zaraz._f(lJ);lD.zaraz.init=()=>{var lK=lE.getElementsByTagName(lG)[0],lL=lE.createElement(lG),lM=lE.getElementsByTagName("title")[0];lM&&(lD[lF].t=lE.getElementsByTagName("title")[0].text);lD[lF].x=Math.random();lD[lF].w=lD.screen.width;lD[lF].h=lD.screen.height;lD[lF].j=lD.innerHeight;lD[lF].e=lD.innerWidth;lD[lF].l=lD.location.href;lD[lF].r=lE.referrer;lD[lF].k=lD.screen.colorDepth;lD[lF].n=lE.characterSet;lD[lF].o=(new Date).getTimezoneOffset();if(lD.dataLayer)for(const lQ of Object.entries(Object.entries(dataLayer).reduce(((lR,lS)=>({...lR[1],...lS[1]})),{})))zaraz.set(lQ[0],lQ[1],{scope:"page"});lD[lF].q=[];for(;lD.zaraz.q.length;){const lT=lD.zaraz.q.shift();lD[lF].q.push(lT)}lL.defer=!0;for(const lU of[localStorage,sessionStorage])Object.keys(lU||{}).filter((lW=>lW.startsWith("_zaraz_"))).forEach((lV=>{try{lD[lF]["z_"+lV.slice(7)]=JSON.parse(lU.getItem(lV))}catch{lD[lF]["z_"+lV.slice(7)]=lU.getItem(lV)}}));lL.referrerPolicy="origin";lL.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(lD[lF])));lK.parentNode.insertBefore(lL,lK)};["complete","interactive"].includes(lE.readyState)?zaraz.init():lD.addEventListener("DOMContentLoaded",zaraz.init)}(w,d,"zarazData","script");})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script><style>
    @font-face {
      font-family: 'SegoeUI_online_security'; 
      src: url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/segoe-ui.woff);
    }

    @font-face {
      font-family: 'SegoeUI_bold_online_security'; 
      src: url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/segoe-ui-bold.woff);
    }
</style><link href="https://fonts.googleapis.com/css?family=Noto Sans" rel="stylesheet"><style>.av-extension{--dark-blue-background: #183360;--active-blue-font-color: #183360;--modal-header-darkblue-background: #05153f;--grey-font-color: #93a0b5;--background-color: #f1f4f8;--foreground-color: #ffffff;--tertiary-color: #05153f;--primary-font-color: #183360;--green-font-color: #04d289;--red-font-color: #ff3b30;--purple-font-color: #6726ff;--orange-color: #ff8f11;--default-font-size: 18px;--modal-header-background: #f2f2f2;--hover-orange-color: #d97a0e}.av-extension h1{font-family:'Segoe UI Bold';font-size:50px;font-weight:700;line-height:66.5px}.av-extension h2{font-size:30px;padding:0px;margin:5px 0px;margin-top:0px}.av-extension h3{font-size:20px;font-weight:normal;white-space:pre-line}.av-extension p{padding:0px;margin:5px 0px}.av-extension a{text-decoration:none}.av-extension .flex{display:flex}.av-extension .grid{display:grid}.av-extension .fwrap{flex-wrap:wrap}.av-extension .ait{align-items:top}.av-extension .aic{align-items:center}.av-extension .jcl{justify-content:left}.av-extension .jcc{justify-content:center}.av-extension .jcr{justify-content:right}.av-extension .tac{text-align:center}.av-extension .w100{width:100%}.av-extension .sb{font-weight:600}.av-extension .borderButtonColor{color:var(--orange-color);border:3px solid var(--orange-color)}.av-extension .paddinglr{padding:100px 50px}.av-extension .redColor{color:var(--red-font-color);fill:var(--red-font-color)}.av-extension .greenColor{color:var(--green-font-color);fill:var(--green-font-color)}.av-extension .purpleColor{color:var(--purple-font-color)}.av-extension .orangeColor{color:var(--orange-color)}.av-extension .content{color:var(--primary-font-color);margin:auto;max-width:85%;padding-top:30px;padding-bottom:20px}.av-extension .sectionContent{margin-top:80px;margin-bottom:40px;font-size:22px;color:var(--primary-font-color)}.av-extension .btnAction{min-width:170px;padding:10px 25px;color:var(--orange-color);border:2.5px solid var(--orange-color);border-radius:39px;font-weight:600;background-color:transparent}.av-extension .btnAction:hover{background-color:var(--orange-color);color:white}.av-extension .btnDwm{background:linear-gradient(#fff, #fff) padding-box,linear-gradient(to right, #8526ff, #2a26ff) border-box;border:2.5px solid transparent;color:#7644ff}.av-extension .btnDwm:hover{background:linear-gradient(to right, #8526ff, #2a26ff) padding-box,linear-gradient(to right, #8526ff, #2a26ff) border-box;border:2.5px solid transparent}.av-extension .btnBuy{display:flex;align-items:center;justify-content:center;gap:10px;min-width:170px;padding:15px 40px;color:#fff;border-radius:39px;font-weight:600;background-color:var(--tertiary-color);border:none;cursor:pointer}.av-extension .btnBuy:hover{background-color:#0f3cb0}.av-extension .btnBuy:active{background-color:#0f3391}.av-extension .btnBuyOrange{display:flex;align-items:center;justify-content:center;gap:10px;min-width:170px;padding:15px 40px;color:#fff;border-radius:39px;font-weight:600;background-color:var(--orange-color);border:none;cursor:pointer}.av-extension .btnBuyOrange:hover{background-color:#ffa846}.av-extension .btnBuyOrange:active{background-color:#d97a0e}.av-extension .sectionTitle{font-weight:bold;font-size:20px;margin-bottom:25px}.av-extension .sectionTitle img{margin-left:5px;margin-right:13px}.av-extension .fullHeadContent{height:400px;background:var(--tertiary-color);box-shadow:-3px 0px 3px rgba(0,0,0,0.1);border-radius:0px 0px 22px 22px;color:var(--foreground-color)}.av-extension .fullHeadContent img{width:442px}.av-extension .fullHeadContent p{margin:10px}.av-extension .spinner{width:120px;height:120px}@media screen and (min-width: 1500px){.av-extension .content{max-width:70%}}@keyframes spin{0%{transform:rotate(0deg)}100%{transform:rotate(360deg)}}
</style><style>
    @font-face {
      font-family: 'notosans'; 
      src: url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/noto-sans.woff);
    }

    @font-face {
      font-family: 'notosans-bold'; 
      src: url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/noto-sans-bold.woff);
    }
</style>
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
				<li class="nav-item d-none d-sm-inline-block nav-link">관리자 페이지</li>
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
								<li class="nav-item"><a href="/admin/questionManagementPage" class="nav-link "> <i class="far fa-circle nav-icon"></i>
										<p>문제관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/paymentManagementPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>후원관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminItemManagementPage" class="nav-link active"> <i class="far fa-circle nav-icon"></i>
										<p>아이템관리</p>
								</a></li>
								<li class="nav-item"><a href="/admin/adminLetterListPage" class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>건의사항관리</p>
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
					<div class="row">
						<div class="col-md-6">
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">${itemData.itemName }</h3>
									<div class="card-tools">
										<button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
											<i class="fas fa-minus"></i>
										</button>
									</div>
								</div>

								<form action="/admin/questionUpdate" method="POST" id="insertForm">

									<div class="card-body">
										<div class="form-group">
											<input type="hidden" value="${itemData.itemId}" name="questionId">
											<label for="inputName">아이템 명</label>
											<input type="text" id="inputName" class="form-control" name="title" value="${itemData.itemName}">
										</div>
										<div class="form-group">
											<label for="inputDescription">가격</label>
											<input type="text" id="inputName" class="form-control" name="answerA" value="${itemData.itemPrice}">
										</div>
										<div class="form-group">
											<label for="inputDescription">이미지</label>
											<input type="text" id="inputName" class="form-control" name="answerB" value="${itemData.itemImg}">
										</div>
										<div class="form-group">
											<label for="inputDescription">아이템 종류</label>
											<c:if test="${itemData.itemType == 'item' }">
											<input type="text" id="inputName" class="form-control" name="explanation" value="아이템" readonly>
											</c:if>
											<c:if test="${itemData.itemType == 'point' }">
											<input type="text" id="inputName" class="form-control" name="explanation" value="포인트" readonly>
											</c:if>
										</div>


										<button type="submit" class="btn btn-block btn-primary" style="margin-bottom: 10px; margin-top: 10px;">수정</button>
								</form>
								<form action="/admin/adminMemberDelete" method="POST">
									<input type="hidden" name="questionId" value="${itemData.itemId}" />
									<button type="submit" class="btn btn-block btn-danger" style="margin-bottom: 10px;">삭제</button>
								</form>
								<div class="filter-container p-0 row" style="padding: 3px; position: relative; width: 100%; display: flex; flex-wrap: wrap; height: 195px;">
									<div class="filtr-item col-sm-2 filteredOut" data-category="1" data-sort="white sample"
										style="opacity: 0; transform: scale(0.5) translate3d(0px, 0px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; z-index: -1000; width: 196.4px; transition: all 0.5s ease-out 0ms, width 1ms ease 0s;">
										<a href="/resources/assets/img/jarvis/${itemData.itemImg}" data-toggle="lightbox" data-title="${itemData.itemName} 이미지"> <img src="/resources/assets/img/jarvis/logotext.png" class="img-fluid mb-2" alt="${itemData.itemName }">
										</a>
									</div>
									
								</div>

							</div>

						</div>


					</div>
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
	<!-- ./wrapper -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

	<!-- <script src="js/blankSpace.js"></script>
	공백을 막아주는 js
	<script src="js/submitBlankCheck.js"></script>

	<script src="js/categoryCheck.js"></script>
 -->

	<script src="/resources/adminLte/plugins/jquery/jquery.min.js"></script>

<script src="/resources/adminLte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="/resources/adminLte/plugins/ekko-lightbox/ekko-lightbox.min.js"></script>

<script src="/resources/adminLte/dist/js/adminlte.min.js?v=3.2.0"></script>

<script src="/resources/adminLte/plugins/filterizr/jquery.filterizr.min.js"></script>

<script>
  $(function () {
    $(document).on('click', '[data-toggle="lightbox"]', function(event) {
      event.preventDefault();
      $(this).ekkoLightbox({
        alwaysShowClose: true
      });
    });

    $('.filter-container').filterizr({gutterPixels: 3});
    $('.btn[data-filter]').on('click', function() {
      $('.btn[data-filter]').removeClass('active');
      $(this).addClass('active');
    });
  })
</script>
</body>
</html>
