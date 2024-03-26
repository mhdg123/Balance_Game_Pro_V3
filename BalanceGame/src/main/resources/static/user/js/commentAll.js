
function commentAll(questionId) {

	console.log("loginId : "+loginId);
	console.log("commentAll"+questionId);
	$.ajax({
		type: "POST",
		url: "/user/commentAsync",
		data: {
			'questionId': questionId
		},
		dataType: 'json',
		success: function(data) {

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
												style="display: inline-block;" onclick="commentWarning(${data.commentId})">신고</div>`;
												
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
			$("#comment-box").html(elem);
			//document.getElementById(".save").src="images/찜o.png";
		},
		error: function(error) {

			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});


}

function commentDelete(commentId) {
	console.log(loginId+" "+questionId+" "+commentId);
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
			commentAll(questionId);
			}
		},
		error: function(error) {

			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});

}


function commentWarning(commentId) {
	console.log(loginId+" "+questionId+" "+commentId);
	$.ajax({
		type: "POST",
		url: "/user/warningCommentAsync",
		data: {
			'commentId': commentId
		},
		dataType: 'text',
		success: function(data) {
			console.log("성공 실패 : "+data);
			if(data=="1"){
				Swal.fire({
				title: "신고",
				text: "신고가 완료 되었습니다.",
				icon: "info"
			});
			}
		},
		error: function(error) {

			console.log('에러발생');
			console.log('에러의 종류:' + error);
		}

	});

}


