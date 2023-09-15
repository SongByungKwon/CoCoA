
document.write('<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>');
document.write("<script src='/js/Modal.js'></script>");

//회원가입
function signUpFriend(){

    let fEmail = $("#signUpFEmail").val();
    let fName = $("#signUpFName").val();
    let fPhone = $("#signUpFPhone").val();
    let fPassword = $("#signUpFPassword").val();
    let selectedValue = $("input[name='signUpFJob']:checked").val();
    let fJob = selectedValue;

    const data = {
        fEmail : fEmail ,
        fName : fName ,
        fPassword : fPassword ,
        fPhone : fPhone ,
        fJob : fJob
    }

    $.ajax({

        type : "POST",            // HTTP method type(GET, POST) 형식이다.
        url : "/mainHome",      // 컨트롤러에서 대기중인 URL 주소이다.
        data : data,            // Json 형식의 데이터이다.
        success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.

            console.log(data);
            swal ( "회원가입 성공" ,  "코송이님 환영합니다." ,  "success" )
            modal1.style.display = "none"
},
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            swal ( "회원가입 실패" ,  "관계자에게 문의하세요." ,  "error" )

        }
    });

}
