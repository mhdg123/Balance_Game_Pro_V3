console.log("[로그] rangeSlider.js");
$(document).ready(function() {
    $("#btn").click(function() {
        var inputVal = document.querySelector('#range_1');
        const minAmount = parseFloat(inputVal.value.split(";")[0]);
        const maxAmount = parseFloat(inputVal.value.split(";")[1]);
		console.log(minAmount);
		console.log(maxAmount);
        // 세션 스토리지에서 데이터 가져오기
        const userInfoObj = JSON.parse(sessionStorage.getItem('userInfoObj'));
		console.log("userInfoObj" + userInfoObj);
        if(userInfoObj) {
            // 필터링 함수 호출
            const filteredData = filterByAmount(minAmount, maxAmount, userInfoObj);
            var i = 1;
            let elem = "<tr>";
            filteredData.forEach(supporter => {
                elem += "<td>" + i + "</td>";
                elem += "<td>" + supporter.loginId + "(" + supporter.nickName + ")" + "</td>";
                if(userInfoObj.id == 'latest') {
                    elem += "<td>" + supporter.paymentAmount + "</td>";
                } else if(userInfoObj.id == 'ranking') {
                    elem += "<td>" + supporter.total + "</td>";
                }
                elem += "<td>" + supporter.paymentDate + "</td>";
                elem += "</tr>";
                i++;
            });

            $("table tbody").html(elem);
        } else {
            console.log("세션 스토리지에서 데이터를 가져올 수 없습니다.");
        }
    });
});

// 필터링 함수
function filterByAmount(minAmount, maxAmount, supportList) {
	   if (!supportList) {
        console.log("supportList가 정의되지 않았거나 null입니다.");
        return []; // supportList가 정의되지 않은 경우 빈 배열 반환
    }
    console.log("filter 로그: " + supportList.datas[0].name);
    if(supportList.id == 'ranking'){
        return supportList.datas.filter(supporter => supporter.total >= minAmount && supporter.total <= maxAmount);
    } else if(supportList.id == 'latest'){
        return supportList.datas.filter(supporter => supporter.paymentAmount >= minAmount && supporter.paymentAmount <= maxAmount);
    }
}

