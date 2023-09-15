const modalOpenButton = document.getElementById('modalOpenButton');
const modalCloseButton = document.getElementById('modalCloseButton');
const modal = document.getElementById('modalContainer');

const modalOpenButton1 = document.getElementById('modalOpenButton1');
const modalCloseButton1 = document.getElementById('modalCloseButton1');
const modal1 = document.getElementById('modalContainer1');


const modalCloseButton2=document.getElementById('modalCloseButtonId');
const modal2=document.getElementById('modalContainerId');


const modalCloseButton3=document.getElementById('modalCloseButtonPw');
const modal3=document.getElementById('modalContainerPw');

//비밀번호 재설정






modalOpenButton.addEventListener('click', () => {
    modal.classList.remove('hidden');

});
modalCloseButton.addEventListener('click', () => {
    modal.classList.add('hidden');
});
window.addEventListener('click', (e) => {
    e.target === modal ? modal.classList.remove('show-modal') : false
})


//로그인에서 회원가입으로 넘기기
function openSignUp(){
    modal.classList.add('hidden');
    modal2.classList.add('hidden');
    modal3.classList.add('hidden');
    modal1.classList.remove('hidden');
}
///로그인에서 회원가입 넘기기 완료.
//로그인으로 넘어가기
function openLogin(){

    modal.classList.remove('hidden');
    modal3.classList.add('hidden');
    modal2.classList.add('hidden');
    modal1.classList.add('hidden');

}

function openPw(){

    modal.classList.add('hidden');
    modal3.classList.remove('hidden');
    modal2.classList.add('hidden');
    modal1.classList.add('hidden');

}

modalCloseButton3.addEventListener('click', () => {
    modal3.classList.add('hidden');
});


////로그인으로 넘어가기 완료


//ID찾기
function openId(){
    modal.classList.add('hidden');
    modal1.classList.add('hidden');
    modal2.classList.remove('hidden');
    modal3.classList.add('hidden');
}




modalCloseButton2.addEventListener('click', () => {
    modal2.classList.add('hidden');



});


//ID 찾기 완료.

//PW 찾기 .


///PW 찾기 완료


modalOpenButton1.addEventListener('click', () => {
    modal1.classList.remove('hidden');

});
modalCloseButton1.addEventListener('click', () => {
    modal1.classList.add('hidden');



});
window.addEventListener('click', (e) => {
    e.target === modal1 ? modal1.classList.remove('show-modal') : false
})


// signup.addEventListener('click', () => {
//     modal1.classList.add('hidden');
// });