document.write('<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>');
//아이디 찾기
function findEmail() {
    let fName = $("#findName").val();
    let fPhone = $("#findPhone").val();

    const data = {
        fName: fName,
        fPhone: fPhone
    }

    if (fName == null || fName === "") {
        swal ( "입력해주세요" ,  "이름을 입력해주세요." ,  "error" )
        $("#findName").focus();
        return false;
    }

    if (fPhone == null || fPhone === "") {
        swal ( "입력해주세요" ,  "전화번호를 입력해주세요." ,  "error" )
        $("#findPhone").focus();
        return false;
    }

    $.ajax({

        type: "post",            // HTTP method type(GET, POST) 형식이다.
        url: "/findEmail",      // 컨트롤러에서 대기중인 URL 주소이다.
        data: data,            // Json 형식의 데이터이다.
        success: function (email) {// 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            if (email != null) {
                console.log(email);
                // alert(fName + "님의 이메일은 " + email + "입니다.");
            } else {
                swal ( "" ,  "존재하지 않는 이메일입니다." ,  "error" )
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            swal ( "오류" ,  "이메일찾기에 실패하였습니다." ,  "error" )
        }
    });

    return true;
}