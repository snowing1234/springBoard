/**
 * 게시글 JAVASCRIPT 함수 모음
 */

/*******************게시글**************************/


function insertPost(){
	if ($("#title").val()== "") {
		alert("제목을 입력해주세요.");
		return false;
	}
	if ($("#content").val() =="") {
		alert("내용을 입력해주세요.");
		return false;
	}
	var post =  $("#form").serialize();
	$.ajax({
		cache : false,
		method:"POST",
		url : "insert.do", // 요기에
		data : post,
		success:function(data){
			if (data == "SUCCESS") {
				alert("게시글이 저장되었습니다.");
				location.href="list.do";
			}
			if (data == "ERROR_NOT_LOGIN") {
				alert("로그인 후 다시 시도해주세요.");
			}
		},
		error:function(request,status){
			alert("글 저장 중 문제가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
}

/* 작업필요한 함수들 reference. baord.js
function updateBoard(){
	if (valCheck()==false) {
		return false;
	}
	var board =  $("#board").serialize();
	$.ajax({
		cache : false,
		method:"POST",
		url : pageContext+"/board/update.do", // 요기에
		data : board,
		success:function(data){
			boardErrorCode(data, pageContext+"/board/list.do","게시판이 수정되었습니다");
		},
		error:function(request,status){
			alert("게시판 수정 중 오류가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
}

function deleteBoard(){
	var data = new Object();
	data.id = $("#id").val();
	
	var jsonData = JSON.stringify(data);

	$.ajax({
		cache : false,
		method:"POST",
		contentType : 'application/json',
		url : pageContext+"/board/delete.do", 
		data : jsonData,
		success:function(data){
			boardErrorCode(data, pageContext+"/board/list.do","게시판이 삭제 되었습니다");
		},
		error:function(request,status){
			alert("게시판 삭제 중 오류가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
}
//값 유효성 체크
function valCheck(){
	if (getByte($("#id").val()) > 20) {
		alert("20글자 이내로 입력해주세요.");
		return false;
	}
	if (getByte($("#name").val()) > 30) {
		alert("30바이트 이내로 입력해주세요.");
		return false;
	}
	if ($("#style option:selected").val() == "") {
		alert("게시판 스타일을 선택해주세요.");
		return false;
	}
	if ($("#listStyle option:selected").val() == "") {
		alert("리스트 스타일을 선택해주세요.");
		return false;
	}
}

//체크박스 값 설정
function boardChkBoxValSet(name, jstl){
	 if(jstl== "T") {
		 $("input:checkbox[name="+name+"]").prop('checked', true);
	 }
}

//에러코드 모음
function boardErrorCode(data, successLocation, successMessage) {
	if (data == "SUCCESS"){
		if (successMessage != ""){
			alert(successMessage);
		}
		location.href=successLocation;
	}
	else if (data == "ERROR_NOT_MANAGER"){
		alert("관리자만 사용가능합니다.");
	}
	else if (data == "ERROR_NOT_LOGIN") {
		alert("로그인 후 사용바랍니다.");
	}
	else if (data == "ERROR_DUBPLE_ID") {
		alert("게시판 이름이 이미 존재합니다. 다른 이름으로 변경해주세요.");
	}
	else if (data == "ERROR_NULL_ID") {
		alert("게시판 이름을 설정해주세요.");
	}
	else if (data == "ERROR_NULL_NAME") {
		alert("표출될 이름을 설정해주세요.");
	}
	else {
		alert("저장시 문제가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
	}
}
*/


