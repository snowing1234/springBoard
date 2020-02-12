/**
 * 게시판 JAVASCRIPT 함수 모음
 */

/*******************회원가입**************************/


//페이지 이동
function movePage(link){
	location.href = link; 
}

function openPage(link){
	window.open(link, '_blank'); 
}

//글자입력시 바이트 수 체크 (DB 입력시 필요)
function getByte(str) {
	var byte = 0;
	for (var i=0; i<str.length; ++i) {
		(str.charCodeAt(i) > 127) ? byte += 3 : byte++ ;
	}
	return byte;
}

function errorLogin(){
	alert("로그인이 필요한 서비스입니다.");
	location.href = history.back();
}
