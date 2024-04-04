	var pageName;
	// 현재 페이지 및 총 페이지 수


// 페이지 번호 노출 범위 설정 (5개씩)
var paginationRange = 5;

// 페이지 번호 목록 생성 함수
function generatePagination() {
    var paginationHTML = '<nav class="blog-pagination justify-content-center d-flex"><ul class="pagination">';

    // 이전 페이지 링크 추가
    paginationHTML += '<li class="page-item"><a onclick="beforeData();" class="page-link" aria-label="Previous">이전</a></li>';

    // 페이지 번호 목록 추가
    for (var i = Math.max(1, Math.min(currentPage - Math.floor(paginationRange / 2), totalPage - paginationRange + 1)); i <= Math.min(totalPage, Math.max(currentPage + Math.floor(paginationRange / 2), paginationRange)); i++) {
        if (i === currentPage) {
            paginationHTML += '<li class="page-item active"><a href="#" class="page-link">' + i + '</a></li>';
        } else {
            paginationHTML += '<li class="page-item"><a href="#" class="page-link" onclick="goToPage(' + i + ');">' + i + '</a></li>';
        }
    }

    // 다음 페이지 링크 추가
    paginationHTML += '<li class="page-item"><a onclick="nextData();" class="page-link" aria-label="Next">다음</a></li>';

    paginationHTML += '</ul></nav>';

    return paginationHTML;
}

// 페이지 목록 업데이트 함수
function updatePagination() {
    var paginationContainer = document.querySelector('.blog-pagination');
    if (paginationContainer) {
        paginationContainer.innerHTML = generatePagination();
    }
}

// 특정 페이지로 이동 함수
function goToPage(pageNumber) {
    location.href = '/admin/' + pageName + '?currentPage=' + pageNumber;
}

function nextData() {
    if ((currentPage + 1) <= totalPage) {
        location.href = '/admin/' + pageName + '?currentPage=' + (currentPage + 1);
    }
}

function beforeData() {
    if ((currentPage - 1) >= 1) {
        location.href = '/admin/' + pageName + '?currentPage=' + (currentPage - 1);
    }
}

// 페이지 로드 시 페이지네이션 생성
document.addEventListener("DOMContentLoaded", function() {
    updatePagination();
});