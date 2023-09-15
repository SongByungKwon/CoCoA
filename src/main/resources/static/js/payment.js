//체크박스 확인
function payForm() {
    let checkBox = document.getElementById("agree");

    if (!checkBox.checked) {
        alert('체크박스 선택은 필수입니다.');
    } else {
        var title = [];
        var code = [];

        $('.l_code').each(function (index) {
            var l_code = document.getElementsByClassName('l_code')[index].id;
            var l_title = document.getElementsByClassName('l_title')[index].innerText;

            console.log(l_code);
            console.log(l_title);

            code.push(l_code);
            title.push(l_title);

        })

        $.ajax({
            url: '/goPayment', //Controller에서 요청 받을 주소
            type: 'POST', //POST 방식으로 전달
            data: {"c_lcode": code, "title": title},

            success: function (result) {
                if (result == 1) { //선택삭제
                    alert("결제 성공");
                    location.replace("/paymentList"); //겟방식 이동

                } else {
                    console.log(result);
                    alert("오류가 발생하였습니다. 관리자에게 문의 바랍니다.");
                }
            }
        })



    }
}




