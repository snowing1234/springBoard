/**
 * 게시판 JAVASCRIPT 함수 모음
 */

/*******************게시판**************************/


function insertBoard(){
	if (valCheck()==false) {
		return false;
	}
	var board =  $("#board").serialize();
	$.ajax({
		cache : false,
		method:"POST",
		url : pageContext+"/board/insert.do", // 요기에
		data : board,
		success:function(data){
			boardErrorCode(data, pageContext+"/board/list.do","게시판이 생성되었습니다");
		},
		error:function(request,status){
			alert("게시판 생성중 오류가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
}

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
	else if (data == "ERROR_NULL_NAME") {
		alert("표출될 이름을 설정해주세요.");
	}
	else {
		alert("저장시 문제가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
	}
}


