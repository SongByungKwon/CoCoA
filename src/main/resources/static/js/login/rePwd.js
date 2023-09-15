document.write('<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>');
//비밀번호 재설정
function checkPwd() {
    let fName = $("#reName").val();
    let fEmail = $("#reEmail").val();

    const data = {
        fName: fName,
        fEmail: fEmail
    }

    if (fName == null || fName === "") {
        swal ( "입력해주세요" ,  "이름을 입력해주세요." ,  "error" )
        $("#reName").focus();
        return "false";
    }

    if (fEmail == null || fEmail === "") {
        swal ( "입력해주세요" ,  "이메일을 입력해주세요." ,  "error" )
        $("#reEmail").focus();
        return "false";
    }

    const btnPw = document.getElementById('btnPw');
    const modalRePwd = document.getElementById('modalContainerPwck');

    if (fName.size() !== 0 && fEmail.size() !== 0) {
        console.log(btnPw);
        modalRePwd.addEventListener('click', () => {
            modal.classList.remove('hidden');
        });
    } else {
        swal ( "없습니다." ,  "일치하는 정보가 없습니다." ,  "error" )
    }
    return true;
}