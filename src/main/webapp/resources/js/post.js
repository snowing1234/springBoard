/**
 * 게시글 JAVASCRIPT 함수 모음
 */

/*******************게시글**************************/
function valCheck(){
	if ($("#title").val()== "") {
		alert("제목을 입력해주세요.");
		return false;
	}
	if ($("#content").val() =="") {
		alert("내용을 입력해주세요.");
		return false;
	}
}


function insertPost(boardId){
	if (valCheck() == false) {
		return false;
	}
	const  post =  $("#form").serialize();
	$.ajax({
		cache : false,
		method:"POST",
		url : 	pageContext+`/post/${boardId}/insert.do`,
		data : post,
		success:function(postId){
			if (postId.indexOf("ERROR") == -1 ) { //성공
				//첨부파일 여부 확인
				if ($("#file").val() == "") {
					alert("저장되었습니다");
				}else {
					if (uploadPost(boardId, postId)) {
						location.href="list.do";
					};
				}
			}
			if (postId == "ERROR_NOT_LOGIN") {//실패
				alert("로그인 후 다시 시도해주세요.");
			}
		},
		error:function(request,status){
			alert("글 저장 중 문제가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
};

//첨부파일 업로드
function uploadPost(boardId, postId){
	var  formData= new FormData($("#fileForm")[0]);
	var result = false;
	$.ajax({
		type:"POST",
		enctype : 'multipart/form-data',
		url : pageContext+`/post/${boardId}/${postId}/fileInsert.do`,
		async : false,
		data : formData,
		processData : false,
		contentType :  false,
		cache : false,
		success:function(data){
			if (data == "SUCCESS") {
				alert("저장되었습니다.");
				result = true;
			}
			if (data == "ERROR_NOT_LOGIN") {
				alert("로그인 후 다시 시도해주세요.");
			}
		},
		error:function(request,status){
			alert("글 저장 중 문제가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
			return false;
		}
	});
	return result;
}


function deletePost(boardId, postId){
	$.ajax({
		cache : false,
		method:"GET",
		contentType : 'application/json',
		url : pageContext+`/post/${boardId}/${postId}/delete.do`,
		success:function(data){
			boardErrorCode(data, pageContext+`/post/${boardId}/list.do`,"삭제 되었습니다");
		},
		error:function(request,status){
			alert("삭제 중 오류가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
}

function updatePost(boardId, postId){
	if (valCheck()==false) {
		return false;
	}
	var post =  $("#form").serialize();
	$.ajax({
		cache : false,
		method:"POST",
		url : pageContext+`/post/${boardId}/${postId}/update.do`, // 요기에
		data : post,
		success:function(data){
			if (data == "SUCCESS") {
				uploadPost(boardId, postId);
			}
			boardErrorCode(data, pageContext+`/post/${boardId}/list.do`,"수정되었습니다");
		},
		error:function(request,status){
			alert("오류가 발생하였습니다. 잠시후 재시도 부탁드립니다.");
		}
	});
}

/*

function downloadFile(filename){
	const encFileName = encodeURI(filename);
	window.location =`fileDownLoad.do?FileName=${encFileName}`;
}
*/

// Ajax 처리방식 
function downloadFile(filename){
	const encFileName = encodeURI(filename);
	$.ajax({
		method:"GET",
		url : `fileDownLoad.do`,
		success : function(data) {
			window.location =`fileDownLoad.do?FileName=${encFileName}`;
		},
		error:function(request,status){
			alert("오류가 발생했습니다.");
		}
	});
}

function deleteFile(filename, fileIdx){
	const encFileName = encodeURI(filename);
	$.ajax({
		method:"GET",
		url : `fileDelete.do?FileName=${filename}`,
		success : function(data) {	
			alert("파일이 삭제되었습니다.");
			$("#file_0").empty(); 
		},
		error:function(request,status){
			alert("오류가 발생했습니다.");
		}
	});
}
