let cart = {
    totalPrice: 0,
    delCheckedItem: function () {

        var test = [];

        $('input:checkbox[name=buy]').each(function (index) {
            if ($(this).is(":checked") == true) {
                test.push($(this).val());
                console.log(test);
            }
        })


        $.ajax({
            url: '/checkDelete', //Controller에서 요청 받을 주소
            type: 'POST', //POST 방식으로 전달
            data: {"c_lcode": test},

            success: function (result) {
                if (result > 0) { //선택삭제
                    document.querySelectorAll("input[name=buy]:checked").forEach(function (item) {
                        item.parentElement.parentElement.remove();
                    })

                    //AJAX 서버 업데이트 전송

                    //전송 처리 결과가 성공이면
                    location.reload();
                    this.totalPrice = 0;
                    this.reCalc();
                } else {
                    alert("오류가 발생하였습니다. 관리자에게 문의 바랍니다.");
                }
            }
        }),
            //AJAX 서버 업데이트 전송

            //전송 처리 결과가 성공이면
            this.reCalc();
        this.updateUI();
    },
    //장바구니 전체 비우기
    delAllItem: function () {

        $.ajax({
            url: '/allDelete', //Controller에서 요청 받을 주소
            type: 'POST', //POST 방식으로 전달
            data: {},

            success: function (result) {
                if (result > 0) { //전체삭제 성공했을 경우
                    document.querySelectorAll('.rowdata').forEach(function (item) {
                        item.remove();
                    })
                    //AJAX 서버 업데이트 전송

                    //전송 처리 결과가 성공이면
                    location.reload();
                    this.totalPrice = 0;
                    this.reCalc();

                } else {
                    alert("오류가 발생하였습니다. 관리자에게 문의 바랍니다.");
                }
            }
        })


    },
    //재계산
    reCalc: function () {
        this.totalPrice = 0;
        document.querySelectorAll(".p_price").forEach(function (item) {
            if (item.parentElement.parentElement.firstElementChild.firstElementChild.checked == true) {
                var price = item.getAttribute('value');
                price = Number(price);
                this.totalPrice += price;
            }
        }, this);
    },
    //화면 업데이트
    updateUI: function () {
        document.querySelector('#sum_p_price').textContent = this.totalPrice.formatNumber() + '원';
    },
    checkItem: function () {
        this.reCalc();
        this.updateUI();
    },
    delItem: function () {
        event.target.parentElement.parentElement.remove();
        this.reCalc();
        this.updateUI();
    }
}

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
    if (this == 0) return 0;
    let regex = /(^[+-]?\d+)(\d{3})/;
    let nstr = (this + '');
    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
    return nstr;
};

function checkPayPage() {
    // 체크박스에서 선택한 값의 강의코드 가져오기
    let payList = [];
    $('input:checkbox[name=buy]').each(function () {
        if ($(this).is(":checked")) {
            payList.push($(this).val());
        }
    });

    // localStorage.setItem('payList', payList);
    console.log("페이리스트 : " + payList);

    // 값이 비어있지 않은 경우에만 페이지로 이동
    // if (payList != [] || payList != null) {
    var form = document.getElementById('orderform');

    console.log(form);

    var objs;

    objs = document.createElement('input');

    objs.setAttribute('type', 'hidden');

    objs.setAttribute('name', 'payList');      // 받을 네이밍

    objs.setAttribute('value', payList);       // 넘길 파라메터

    form.appendChild(objs);

    form.submit();
    return false;

}