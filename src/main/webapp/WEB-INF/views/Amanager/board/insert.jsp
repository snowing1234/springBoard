<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

 <div class="container">

  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>게시판</h2>
    <p class="lead">원하시는 형태에 맞는 게시판을 설정해주세요.</p>
  </div>
  <div class="container" >
    <form class="needs-validation .was-validated" name="board" id="board" novalidate>
	    
	    <h4 class="mb-3">기본 설정</h4>
      
	    <div class="form-row py-2">
		    <div class="col-md-3"><label for="name">게시판 이름</label></div>
		      <div class="col-md-9">
			      <input class="form-control" type="text" id="name" name="name" onkeyup='KeyUpForName()' placeholder="ex) 자유 게시판" required/> 
			      <div class="invalid-feedback" id="warn_name"></div>
		      </div>
		  </div>
		  
		  <div class="form-row py-2">
		    <div class="col-md-3 checkbox"><label>게시판 스타일</label> </div>
        <div class="col-md-9">
          <select class="form-control" name="style" id="style">
            <option value="">선택하세요</option>
            <option value="default">기본</option>
            <option value="test1">테스트.</option>
          </select>
        </div>
		  </div>

      <div class="row py-2">
        <div class="col-md-3 checkbox"><label>리스트 스타일</label></div>
        <div class="col-md-9">
	        <select class="form-control" name="listStyle" id="listStyle">
	          <option value="">선택하세요</option>
	          <option value="default">기본(리스트형)</option>
	          <option value="somenail">썸네일형</option>
	          <option value="image list">이미지형</option>
	          <option value="only image">제목 없는 이미지형</option>          
	        </select>
	      </div>
      </div>
	      
	    <hr class="mb-1 py-3"/>
	    
		  <h4>게시판 옵션</h4>
	   	<div class="checkbox">
	      <label class="py-2"><input type="checkbox" name="fileAttach"> 파일첨부 기능</label><br/>
	      <label class="py-2"><input type="checkbox" name="privateSet"> 비공개</label><br/>
	      <label class="py-2"><input type="checkbox" name="notice"> 상단공지사항</label><br/>
	      <label class="py-2"><input type="checkbox" name="reply"> 답글</label><br/>
	      <label class="py-2"><input type="checkbox" name="comments"> 댓글</label><br/>
	      <label class="py-2"><input type="checkbox" name="replyComment"> 리댓글</label><br/>
	    </div>
	    
      <button class="btn btn-primary btn-lg btn-block" onclick="insertBoard()">작성</button>    
    </form>
    </div>
 </div>





<script type="text/javascript">
 
 //id 검사
function KeyUpForId() {
  //영어입력 체크
  var expression = RegExp(/[^a-zA-Z]/);
  if (expression.test($("#id").val())){
    $("div[id=warn_id]").text("영어만 입력 가능합니다.");
  }else{
	  //글자수 체크
    if (getByte($("#id").val()) > 20){
      $("div[id=warn_id]").text("20글자 이내로 입력해주세요.");
    }else{
      $("div[id=warn_id]").text("");
    }
  }
}

 //name 검사
function KeyUpForName() {
	//글자수 체크
	if (getByte($("#name").val()) > 40){
	  $("div[id=warn_name]").text("40 바이트 이내로 입력해주세요.");
	}else{
	  $("div[id=warn_name]").text("");
	}

}

 </script>