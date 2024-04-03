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



<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">

<link rel="stylesheet" href="/resources/adminLte/plugins/fontawesome-free/css/all.min.css">

<link rel="stylesheet" href="/resources/adminLte/dist/css/adminlte.min.css?v=3.2.0">
<script defer="" referrerpolicy="origin"
	src="/cdn-cgi/zaraz/s.js?z=JTdCJTIyZXhlY3V0ZWQlMjIlM0ElNUIlNUQlMkMlMjJ0JTIyJTNBJTIyQWRtaW5MVEUlMjAzJTIwJTdDJTIwQ2hhcnRKUyUyMiUyQyUyMnglMjIlM0EwLjE5MDc5OTYzODU1OTQ4NzQ1JTJDJTIydyUyMiUzQTE5MjAlMkMlMjJoJTIyJTNBMTA4MCUyQyUyMmolMjIlM0E5NTMlMkMlMjJlJTIyJTNBMTkyMCUyQyUyMmwlMjIlM0ElMjJodHRwcyUzQSUyRiUyRmFkbWlubHRlLmlvJTJGdGhlbWVzJTJGdjMlMkZwYWdlcyUyRmNoYXJ0cyUyRmNoYXJ0anMuaHRtbCUyMiUyQyUyMnIlMjIlM0ElMjJodHRwcyUzQSUyRiUyRmFkbWlubHRlLmlvJTJGdGhlbWVzJTJGdjMlMkZwYWdlcyUyRmNoYXJ0cyUyRnVwbG90Lmh0bWwlMjIlMkMlMjJrJTIyJTNBMjQlMkMlMjJuJTIyJTNBJTIyVVRGLTglMjIlMkMlMjJvJTIyJTNBLTU0MCUyQyUyMnElMjIlM0ElNUIlNUQlN0Q="></script>
<script nonce="70115523-8333-45ab-9aac-f552aa07a9aa">try{(function(w,d){!function(k,l,m,n){k[m]=k[m]||{};k[m].executed=[];k.zaraz={deferred:[],listeners:[]};k.zaraz.q=[];k.zaraz._f=function(o){return async function(){var p=Array.prototype.slice.call(arguments);k.zaraz.q.push({m:o,a:p})}};for(const q of["track","set","debug"])k.zaraz[q]=k.zaraz._f(q);k.zaraz.init=()=>{var r=l.getElementsByTagName(n)[0],s=l.createElement(n),t=l.getElementsByTagName("title")[0];t&&(k[m].t=l.getElementsByTagName("title")[0].text);k[m].x=Math.random();k[m].w=k.screen.width;k[m].h=k.screen.height;k[m].j=k.innerHeight;k[m].e=k.innerWidth;k[m].l=k.location.href;k[m].r=l.referrer;k[m].k=k.screen.colorDepth;k[m].n=l.characterSet;k[m].o=(new Date).getTimezoneOffset();if(k.dataLayer)for(const x of Object.entries(Object.entries(dataLayer).reduce(((y,z)=>({...y[1],...z[1]})),{})))zaraz.set(x[0],x[1],{scope:"page"});k[m].q=[];for(;k.zaraz.q.length;){const A=k.zaraz.q.shift();k[m].q.push(A)}s.defer=!0;for(const B of[localStorage,sessionStorage])Object.keys(B||{}).filter((D=>D.startsWith("_zaraz_"))).forEach((C=>{try{k[m]["z_"+C.slice(7)]=JSON.parse(B.getItem(C))}catch{k[m]["z_"+C.slice(7)]=B.getItem(C)}}));s.referrerPolicy="origin";s.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(k[m])));r.parentNode.insertBefore(s,r)};["complete","interactive"].includes(l.readyState)?zaraz.init():k.addEventListener("DOMContentLoaded",zaraz.init)}(w,d,"zarazData","script");})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>
<style type="text/css">/* Chart.js */
@
keyframes chartjs-render-animation {
	from {opacity: .99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	animation: chartjs-render-animation 1ms
}

.chartjs-size-monitor, .chartjs-size-monitor-expand,
	.chartjs-size-monitor-shrink {
	position: absolute;
	direction: ltr;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	overflow: hidden;
	pointer-events: none;
	visibility: hidden;
	z-index: -1
}

.chartjs-size-monitor-expand>div {
	position: absolute;
	width: 1000000px;
	height: 1000000px;
	left: 0;
	top: 0
}

.chartjs-size-monitor-shrink>div {
	position: absolute;
	width: 200%;
	height: 200%;
	left: 0;
	top: 0
}
</style>
<style>
@font-face {
	font-family: 'SegoeUI_online_security';
	src:
		url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/segoe-ui.woff);
}

@font-face {
	font-family: 'SegoeUI_bold_online_security';
	src:
		url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/segoe-ui-bold.woff);
}
</style>
<link href="https://fonts.googleapis.com/css?family=Noto Sans" rel="stylesheet">
<style>
.av-extension {
	--dark-blue-background: #183360;
	--active-blue-font-color: #183360;
	--modal-header-darkblue-background: #05153f;
	--grey-font-color: #93a0b5;
	--background-color: #f1f4f8;
	--foreground-color: #ffffff;
	--tertiary-color: #05153f;
	--primary-font-color: #183360;
	--green-font-color: #04d289;
	--red-font-color: #ff3b30;
	--purple-font-color: #6726ff;
	--orange-color: #ff8f11;
	--default-font-size: 18px;
	--modal-header-background: #f2f2f2;
	--hover-orange-color: #d97a0e
}

.av-extension h1 {
	font-family: 'Segoe UI Bold';
	font-size: 50px;
	font-weight: 700;
	line-height: 66.5px
}

.av-extension h2 {
	font-size: 30px;
	padding: 0px;
	margin: 5px 0px;
	margin-top: 0px
}

.av-extension h3 {
	font-size: 20px;
	font-weight: normal;
	white-space: pre-line
}

.av-extension p {
	padding: 0px;
	margin: 5px 0px
}

.av-extension a {
	text-decoration: none
}

.av-extension .flex {
	display: flex
}

.av-extension .grid {
	display: grid
}

.av-extension .fwrap {
	flex-wrap: wrap
}

.av-extension .ait {
	align-items: top
}

.av-extension .aic {
	align-items: center
}

.av-extension .jcl {
	justify-content: left
}

.av-extension .jcc {
	justify-content: center
}

.av-extension .jcr {
	justify-content: right
}

.av-extension .tac {
	text-align: center
}

.av-extension .w100 {
	width: 100%
}

.av-extension .sb {
	font-weight: 600
}

.av-extension .borderButtonColor {
	color: var(--orange-color);
	border: 3px solid var(--orange-color)
}

.av-extension .paddinglr {
	padding: 100px 50px
}

.av-extension .redColor {
	color: var(--red-font-color);
	fill: var(--red-font-color)
}

.av-extension .greenColor {
	color: var(--green-font-color);
	fill: var(--green-font-color)
}

.av-extension .purpleColor {
	color: var(--purple-font-color)
}

.av-extension .orangeColor {
	color: var(--orange-color)
}

.av-extension .content {
	color: var(--primary-font-color);
	margin: auto;
	max-width: 85%;
	padding-top: 30px;
	padding-bottom: 20px
}

.av-extension .sectionContent {
	margin-top: 80px;
	margin-bottom: 40px;
	font-size: 22px;
	color: var(--primary-font-color)
}

.av-extension .btnAction {
	min-width: 170px;
	padding: 10px 25px;
	color: var(--orange-color);
	border: 2.5px solid var(--orange-color);
	border-radius: 39px;
	font-weight: 600;
	background-color: transparent
}

.av-extension .btnAction:hover {
	background-color: var(--orange-color);
	color: white
}

.av-extension .btnDwm {
	background: linear-gradient(#fff, #fff) padding-box,
		linear-gradient(to right, #8526ff, #2a26ff) border-box;
	border: 2.5px solid transparent;
	color: #7644ff
}

.av-extension .btnDwm:hover {
	background: linear-gradient(to right, #8526ff, #2a26ff) padding-box,
		linear-gradient(to right, #8526ff, #2a26ff) border-box;
	border: 2.5px solid transparent
}

.av-extension .btnBuy {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 10px;
	min-width: 170px;
	padding: 15px 40px;
	color: #fff;
	border-radius: 39px;
	font-weight: 600;
	background-color: var(--tertiary-color);
	border: none;
	cursor: pointer
}

.av-extension .btnBuy:hover {
	background-color: #0f3cb0
}

.av-extension .btnBuy:active {
	background-color: #0f3391
}

.av-extension .btnBuyOrange {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 10px;
	min-width: 170px;
	padding: 15px 40px;
	color: #fff;
	border-radius: 39px;
	font-weight: 600;
	background-color: var(--orange-color);
	border: none;
	cursor: pointer
}

.av-extension .btnBuyOrange:hover {
	background-color: #ffa846
}

.av-extension .btnBuyOrange:active {
	background-color: #d97a0e
}

.av-extension .sectionTitle {
	font-weight: bold;
	font-size: 20px;
	margin-bottom: 25px
}

.av-extension .sectionTitle img {
	margin-left: 5px;
	margin-right: 13px
}

.av-extension .fullHeadContent {
	height: 400px;
	background: var(--tertiary-color);
	box-shadow: -3px 0px 3px rgba(0, 0, 0, 0.1);
	border-radius: 0px 0px 22px 22px;
	color: var(--foreground-color)
}

.av-extension .fullHeadContent img {
	width: 442px
}

.av-extension .fullHeadContent p {
	margin: 10px
}

.av-extension .spinner {
	width: 120px;
	height: 120px
}

@media screen and (min-width: 1500px) {
	.av-extension .content {
		max-width: 70%
	}
}

@
keyframes spin { 0%{
	transform: rotate(0deg)
}
100






%
{
transform






:






rotate




(






360deg






)






}
}
</style>
<style>
@font-face {
	font-family: 'notosans';
	src:
		url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/noto-sans.woff);
}

@font-face {
	font-family: 'notosans-bold';
	src:
		url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/noto-sans-bold.woff);
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

		<div class="content-wrapper">

			<div class="card card-success">
				<div class="card-header">
					<h3 class="card-title">월 포인트 통계</h3>
					<div class="card-tools">
						<button type="button" class="btn btn-tool" data-card-widget="collapse">
							<i class="fas fa-minus"></i>
						</button>
						<button type="button" class="btn btn-tool" data-card-widget="remove">
							<i class="fas fa-times"></i>
						</button>
					</div>
				</div>
				<div class="card-body">
					<div class="chart">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>
						<canvas id="barChart" style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%; display: block; width: 764px;" width="764" height="250" class="chartjs-render-monitor"></canvas>
					</div>
				</div>

			</div>
			<!-- Main content -->

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

	<script src="/resources/adminLte/plugins/jquery/jquery.min.js"></script>

	<script src="/resources/adminLte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="/resources/adminLte/plugins/chart.js/Chart.min.js"></script>

	<script src="/resources/adminLte/dist/js/adminlte.min.js?v=3.2.0"></script>


	<script>
  $(function () {

$(document).ready(function() {
    // 캔버스와 샘플 데이터를 사용하여 차트 생성
    var barChartCanvas = $('#barChart').get(0).getContext('2d');
    var barChartData = {};

    var barChartOptions = {
        responsive: true,
        maintainAspectRatio: false,
        datasetFill: false,
    };

    // 서버로부터 데이터를 비동기적으로 가져와 차트를 생성하는 함수
    function fetchDataAndCreateChart() {
        $.ajax({
            url: '/admin/adminChartAsync', // 변경된 URL을 여기에 입력하세요
            type: 'POST',
            success: function(data) {
                // 성공적으로 데이터를 받아온 경우 이 부분에서 데이터를 처리합니다.
                console.log('서버로부터 받은 데이터:', data);
                // 받은 데이터를 차트 데이터로 설정합니다.
                 var parsedData = JSON.parse(data);
                console.log(parsedData[0].totalAmountID)
                
                  var chartDataArray = []; // 차트 데이터를 담을 배열
            
            // 각 월별 데이터를 반복하여 차트 데이터에 추가
            for (var i = 0; i < parsedData.length; i++) {
                chartDataArray.push(parsedData[i].totalAmount);
            }
                
                barChartData = {
                    labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
                    datasets: [
                        {
                        	 label: "포인트 충전 월별",
                             backgroundColor: "rgba(255,99,132,0.2)",
                             borderColor: "rgba(255,99,132,1)",
                             borderWidth: 1,
                             hoverBackgroundColor: "rgba(255,99,132,0.4)",
                             hoverBorderColor: "rgba(255,99,132,1)",
                             data: chartDataArray, 
                        }
                    ]
                };

                // 차트 생성
                new Chart(barChartCanvas, {
                    type: 'bar',
                    data: barChartData,
                    options: barChartOptions,
                });
            },
            error: function(error) {
                // 요청이 실패하거나 응답이 오류인 경우 이 부분에서 오류 처리를 합니다.
                console.error('오류 발생:', error);
            }
        });
    }

    // 페이지가 로드될 때 데이터를 가져와 차트를 생성합니다.
    fetchDataAndCreateChart();
});


    //---------------------
    //- STACKED BAR CHART -
    //---------------------
    var stackedBarChartCanvas = $('#stackedBarChart').get(0).getContext('2d')
    var stackedBarChartData = $.extend(true, {}, barChartData)

    var stackedBarChartOptions = {
      responsive              : true,
      maintainAspectRatio     : false,
      scales: {
        xAxes: [{
          stacked: true,
        }],
        yAxes: [{
          stacked: true
        }]
      }
    }

    new Chart(stackedBarChartCanvas, {
      type: 'bar',
      data: stackedBarChartData,
      options: stackedBarChartOptions
    })
  })
</script>

</body>
</html>
