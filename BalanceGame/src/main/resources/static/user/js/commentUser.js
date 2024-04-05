
function commentAll() {

	console.log("loginId : "+loginId);
	console.log("commentAll "+currentPage);
	
	if(currentPage==''){
		currentPage=1;
	}
	console.log("commentAll "+currentPage);
	$.ajax({
		type: "POST",
		url: "/user/commentUserAsync",
		data: {
			'currentPage': currentPage
		},
		dataType: 'json',
		success: function(data) {
			if(data.length > 0) {
			console.log('data 현재페이지'+data[0].currentPage);
				console.log('data 총페이지'+data[0].totalPages);
			currentPage=data[0].currentPage;
			totalPage=data[0].totalPages;
			var elem = "";
			$.each(data, function(index, data) {

				
				
					elem += `<div class="comment-list">
						<div>
							<div>
								<div class="desc">
									<div class="d-flex">
										<div class="d-flex align-items-center">
											<h5>
												<a href="#" style="color: black">${data.loginId}</a>
											</h5>
											<p class="date">${data.commentDate}</p>
										</div>
									</div>
									<div>
										<p class="comment">${data.comments}</p>
									</div>
									<!-- 이름 날짜 삭제 -->
									<div class="d-flex justify-content-between">
										<div class="d-flex align-items-center"></div>
										<div class="reply-btn">
											<div class="btn-reply text-uppercase"
												style="display: inline-block;" onclick="commentWarning(${data.commentId},'${data.loginId}')">신고</div>`;
												
											if (data.loginId==loginId){
											elem +=`<div class="btn-reply text-uppercase"
												style="display: inline-block;" onclick="commentDelete(${data.commentId})">삭제</div>`;
												
												}
										elem +=`</div>
									</div>
								</div>
								<hr />
							</div>
						</div>
					</div>`;
				
			});

			pageName='commentPage';
			updatePagination();
			$("#comment-box").html(elem);
			//document.getElementById(".save").src="images/찜o.png";
			}else {
        // data가 비어있는 경우 처리
        console.log('데이터가 비어있습니다.');
    }
		},
		error: function(error) {
var elem = "작성된 댓글이 없습니다";
$("#comment-box").html(elem);
			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});


}

function commentDelete(commentId) {
	
$.ajax({
		type: "POST",
		url: "/user/deleteCommentAsync",
		data: {
			'commentId': commentId
		},
		dataType: 'text',
		success: function(data) {
			console.log("성공 실패 : "+data);
			if(data=="1"){
				console.log("댓글 다시 받아오기");
				commentAll();
			}
		},
		error: function(error) {

			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});

}


function commentWarning(commentId,commentWriter) {
	var loginId = $("#loginId").val();
	if( loginId == "") {
		Swal.fire({
					title: "로그인 필요",
					text: "로그인 후 사용가능합니다.",
					icon: "info"
				});
		return;
	}
	$.ajax({
		type: "POST",
		url: "/user/commentReportAsync",
		data: {
			'commentId': commentId,
			'commentWriter':commentWriter,
			repoter : loginId
		},
		dataType: 'text',
		success: function(data) {
			console.log("성공 실패 : "+data);
			if(data=="success"){
				Swal.fire({
				title: "신고",
				text: "신고가 완료 되었습니다.",
				icon: "success"
			});
			}else if(data == "fail") {
				Swal.fire({
				title: "신고",
				text: "이미 신고 하였습니다",
				icon: "success"
			});
			}
		},
		error: function(error) {

			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});

}


