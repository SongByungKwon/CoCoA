$(function () {
    let emailValidCheck = document.getElementById('signUpFEmail');
    let nameCheck = document.getElementById('signUpFName');
    let phoneCheck = document.getElementById('signUpFPhone');
    let pwdCheck = document.getElementById('signUpFPassword');
    let pwdCkCheck = document.getElementById('signUpFPasswordChk');

    emailValidCheck.addEventListener('focusout', function (event) {
        setValidEmail(event.target.value);
    });

    nameCheck.addEventListener('focusout', function (event) {
        setValidName(event.target.value);
    });

    phoneCheck.addEventListener('focusout', function (event) {
        setValidPhone(event.target.value);
    });

    pwdCheck.addEventListener('focusout', function (event) {
        setValidPwd(event.target.value);
    });

    pwdCkCheck.addEventListener('focusout', function (event) {
        setValidPwdCk(event.target.value);

        if (pwdCheck.value !== pwdCkCheck.value) {
            $("#vaildPwdCk").text('비밀번호를 동일하게 입력해주세요.').css("color", "red");
            // console.log(pwdCheck.values + pwdCkCheck.values);
            return false;
        } else {
            $("#vaildPwdCk").text(''); // 동일한 경우에는 메시지를 지웁니다.
            // console.log("비번 똑같음");
            return true;
        }
    });
});

//이메일 유효성 검사
function setValidEmail(emailValidCheck) {
    if (emailValidCheck.trim() === '') {
        $("#vaildEmail").text('이메일을 입력해주세요').css("color", "red");
        return false;
    }
    if (!email_check(emailValidCheck)) {
        $("#vaildEmail").text('잘못된 형식의 이메일 주소입니다').css("color", "red");
        // console.log("정규표현식에 맞지 않음 incorrect");
        return false;

    } else {
        checkEmail();
        $("#vaildEmail").text('유효한 형식의 이메일 입니다.').css("color", "green");

        // console.log("정규표현식에 맞음 correct");

        return true;
    }
}

function setValidName(nameCheck) {
    if (nameCheck.trim() === '') {
        $("#vaildName").text('이름을 입력해주세요.').css("color", "red");
        return false;
    } else {
        $("#vaildName").text('');
    }
}

function setValidPhone(phoneCheck) {
    if (phoneCheck.trim() === '') {
        $("#vaildPhone").text('전화번호를 입력해주세요.').css("color", "red");
        return false;
    } else {
        $("#vaildPhone").text('');
    }
}

function setValidPwd(pwdCheck) {
    if (pwdCheck.trim() === '') {
        $("#vaildPwd").text('비밀번호를 입력해주세요.').css("color", "red");
        return false;
    } else {
        $("#vaildPwd").text('');
    }
}

function setValidPwdCk(pwdCkCheck) {
    if (pwdCkCheck.trim() === '') {
        $("#vaildPwdCk").text('비밀번호 확인을 입력해주세요.').css("color", "red");
        // console.log(pwdCkCheck);
        return false;
    }else {
        $("#vaildPwdCk").text('');
    }
}

function email_check(fEmail) {
    // console.log(fEmail);
    let regex = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

    return (fEmail != '' && fEmail != 'undefined' && regex.test(fEmail));

}

//이메일 중복검사
function checkEmail() {
    let fEmail = $('#signUpFEmail').val(); //email값이 "id"인 입력란의 값을 저장

    $.ajax({
            url: '/', //Controller에서 요청 받을 주소
            type: 'POST', //POST 방식으로 전달
            data: {
                "fEmail": fEmail
            },

            success: function (cnt) { //컨트롤러에서 넘어온 cnt값을 받는다
                if (cnt == 0) { //cnt가 1이 아니면(0일 경우) -> 사용 가능한 아이디
                    $("#vaildEmail").text("사용할 수 있는 아이디 입니다.").css("color", "green");

                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $("#vaildEmail").text("이미 존재하는 이메일 입니다.").css("color", "red");
                    $('#vaildEmail').val('');
                }
            }
            ,
        }
    );
}