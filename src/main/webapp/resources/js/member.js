/**
 * 회원관련 JAVASCRIPT 함수 모음
 */

/*******************회원가입**************************/

//비밀번호 변경 (currentPW, changePW)
function updatePW(){
	var data = new Object();
	data.currentPW = $("#currentPW").val();
	data.changePW = $("#changePW").val();
	
	var jsonData = JSON.stringify(data);
	
	$.ajax({
		type:"POST",
		url: pageContext+"/member/updatePW.do", 
		contentType : "application/json",
		data : jsonData,
		success:function(result){
			if(result == "SUCCESS"){
				alert("정상적으로 변경되었습니다.");
				location.href=pageContext+"/member/myInfo.do";
			}else if (result == "ERROR_LOGOUT"){
				alert("로그아웃 되었습니다. 다시 로그인해주시기 바랍니다.");
			}else{
				alert("비밀번호를 다시 확인해주시기 바랍니다.");
			}
		},
		error:function(request,status, error){
			alert("오류가 발생하였습니다. \n code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 회원탈퇴
function deleteMember(){
	var data = new Object();
	data.currentPW = $("#currentPW").val();
	
	var jsonData = JSON.stringify(data);
	
	$.ajax({
		type:"POST",
		url: pageContext+"/member/delete.do", 
		contentType : "application/json",
		data : jsonData,
		success:function(result){
			if(result == "SUCCESS"){
				alert("회원탈퇴되었습니다. 이용해주셔서 감사합니다.");
				location.href=pageContext+"/member/myInfo.do";
			}else if (result == "ERROR_LOGOUT"){
				alert("로그아웃 되었습니다. 다시 로그인해주시기 바랍니다.");
			}else{
				alert("비밀번호를 다시 확인해주시기 바랍니다.");
			}
		},
		error:function(request,status, error){
			alert("오류가 발생하였습니다. \n code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 회원가입 { id, pw, pw2, nickName }
function insertMember(){
	if ($("#warn_nickname").text() != $("#warn_id").text()) {
		alert("아이디와 닉네임을 확인해주세요");
		return false;
	}
	if ($("#pw").val() != $("#pw2").val()) {
		alert("비밀번호를 확인해주세요.");
		return false;
	}
	var data  =  $("#member").serialize();
	console.log(data);
	$.ajax({
		type:"POST",
		url: pageContext+"/member/insert.do",
		data : data,
		success:function(result){
			if(result == "SUCCESS"){
				alert("회원가입되었습니다.");
				location.href=pageContext
			}else{
				alert("비밀번호를 다시 확인해주시기 바랍니다.");
			}
		},
		error:function(request,status, error){
			alert("오류가 발생하였습니다. \n code:"+request.status+"\n"+"error:"+error);
		}
	});
}

//아이디 중복검사 (클릭시)
function CheckId() {
	$.ajax({
		type:"GET",
		url: pageContext+"/member/idDupleCheck.do",
		data :  "id=" + $("#id").val(),
		success:function(result){
			if(result == "SUCCESS"){
				$("#warn_id").text("사용가능합니다.");
			}else{
				$("#warn_id").text("다른 아이디을 입력해주세요.");
			}
		},
		error:function(request,status, error){
			alert("오류가 발생하였습니다. \n code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 닉네임 중복검사 (입력시)
function CheckNickName() {
	$.ajax({
		type:"GET",
		url: pageContext+"/member/nickNameDupleCheck.do",
		data : "nickName=" + $("#nickName").val(),
		success:function(result){
			if(result == "SUCCESS"){
				$("#warn_nickname").text("사용가능합니다.");
			}else{
				$("#warn_nickname").text("다른 닉네임을 입력해주세요.");
			}
		},
		error:function(request,status, error){
			alert("오류가 발생하였습니다. \n code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function kakao_getToken() {
	
	const app_key = "965dbed2b5cdf6d4b6ad511f46129932";
	const redirect_uri = "http://happysue.coo.kr/springBoard/auth/kakao.do";
	location.href=`https://kauth.kakao.com/oauth/authorize?client_id=${app_key}&redirect_uri=${redirect_uri}&response_type=code&state=`;
}
