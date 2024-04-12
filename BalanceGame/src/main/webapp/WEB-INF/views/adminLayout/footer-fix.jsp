<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<script>
		$(document)
				.ready(
						function() {

							$("#searchLoginId").keyup(function() {
								console.log("키업 함수 실행");
								searchLoginId();
							});

							
							function updateTableRow(result) {
								var tableBody = $("#suggestionTableBody");

								if (!result || result.length === 0) {
									// 데이터가 없을 경우 메시지 출력
									tableBody
											.html('<tr><td colspan="2">데이터가 없습니다.</td></tr>');
									return;
								}
								// 데이터가 있을 경우 테이블 업데이트
								var html = "";
								for (var i = 0; i < result.length; i++) {
									var sugId = result[i].sugId;
									var loginId = result[i].loginId;
									var title = result[i].title;

									html += '<tr data-sugId="'
											+ sugId
											+ '" onclick="location.href=\'adminSuggestionDetailPageAction.do?sugId='
											+ sugId + '\'">';
									html += '<td id="loginIdData">' + loginId
											+ '</td>';
									html += '<td id="titleData">' + title
											+ '</td>';
									html += '</tr>';
								}
								tableBody.html(html);
							}
							function searchLoginId() {
								var searchLoginIdData = $("#searchLoginId")
										.val();
								/* var searchNameMode = $("#searchName").prop(
										"checked"); */

								$.ajax({
									url : "idSearchAsync",
									type : "POST",
									data : {
										searchData : searchLoginIdData
										/* searchNameMode : searchNameMode */
									// 체크박스 상태를 전달
									},
									dataType : 'json',
									success : function(result) {
										updateTableRow(result);
									},
									error : function(request, status, error) {
										// 서버 요청 실패시 에러 메시지 표시
										updateTableRow();
										console.error('서버 요청 실패', error);
									}
								});
							}
						});
	</script>