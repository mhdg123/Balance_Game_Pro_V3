
function commentAll(questionId) {


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
												style="display: inline-block;">신고</div>
											<div class="btn-reply text-uppercase"
												style="display: inline-block;">삭제</div>
										</div>
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