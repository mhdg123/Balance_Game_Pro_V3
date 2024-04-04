console.log("[로그] sponsorListDate.js");
$(document).ready(function(){
    $("#btnDate").click(function(){
        console.log("[로그] sponsorListDate.js 진입");
        $.ajax({
            type:"POST",
            url: "adminPaymentManageDateAsync",
            dataType:"json",
            success:function(datas){
                if(datas == "false"){
                    console.log("false");
                } else {
                    const userInfoObj = {
                        id: '최신순',
                        datas: datas
                    };
                    sessionStorage.setItem('userInfoObj', JSON.stringify(userInfoObj));
                    console.log("[로그 datas]" + datas);
                    var i = 1;
                    let elem = "<tr>";
                    datas.forEach(supporter => {
                        elem += "<td>" + i + "</td>";
                        elem += "<td>" + supporter.loginId + "(" + supporter.nickName + ")" + "</td>";
                        elem += "<td>" + supporter.paymentAmount + "</td>";
                        elem += "<td>" + supporter.paymentDate + "</td>";
                        elem += "</tr>";
                        i++;
                    });
                    $("table tbody").html(elem);
                }
            },
            error:function(error){
                console.log("error: " + error);
            }
        });
    });
});
