<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="com.tstory.joalog.board.dao.Board" %>

<!--  페이지에서 사용할 정보 셋팅 -->
<% Board board = (Board) request.getAttribute("board"); %>
<script>
//Value Setting
 $(function(){
	 $("select[name=style]").val("${board.style}").prop("selected", true);
	 $("select[name=listStyle]").val("${board.listStyle}").prop("selected", true);
	 boardChkBoxValSet("fileAttach", "${board.fileAttach}");
	 boardChkBoxValSet("privateSet", "${board.privateSet}");
	 boardChkBoxValSet("notice", "${board.notice}");
	 boardChkBoxValSet("reply", "${board.reply}");
	 boardChkBoxValSet("comments", "${board.comments}");
	 boardChkBoxValSet("replyComment", "${board.replyComment}");
 });
	 
 
</script>
  <style>

  </style> 
    
 <div class="container">
 
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>게시판 설정 수정하기</h2>
    <p class="lead">원하시는 형태에 맞는 게시판을 설정해주세요.</p>
  </div>
  <div class="container" >
    <form class="needs-validation .was-validated" method="post" action="javascript:updateBoard()" name="form" id="board" novalidate>
      
      <h4 class="mb-3">기본 설정</h4>

      <div class="row py-2">
        <div class="col-md-3" > <label for="id">게시판 이름 (영어)</label> </div>
        <div class="col-md-9 input-group"> <input type="text" class="form-control" name="id" id="id" value="${board.id}" placeholder="ex) default" readonly></div>
      </div>
      
      <div class="row py-2">
        <div class="col-md-3" >  <label for="name">표출될 게시판 이름</label> </div>
        <div class="col-md-9 input-group"> <input type="text" class="form-control" name="name" id="name" value="${board.name}" placeholder="ex) 자유 게시판" required/></div>
      </div>
      
      <div class="row py-2">
        <div class="col-md-3 checkbox"> <label>게시판 스타일</label> </div>
        <div class="col-md-9">
          <select class="form-control" name="style" >
            <option value="">선택하세요</option>
            <option value="default">기본</option>
            <option value="test1">테스트.</option>
          </select>
        </div>
      </div>

      <div class="row py-2">
        <div class="col-md-3 checkbox"> <label>리스트 스타일</label> </div>
        <div class="col-md-9">
          <select class="form-control" name="listStyle">
            <option value="">선택하세요</option>
            <option value="list">리스트형</option>
            <option value="somenail">썸네일형</option>
            <option value="image list">이미지형</option>
            <option value="only image">제목 없는 이미지형</option>          
          </select>
        </div>
      </div>
        
      <hr class="mb-1 py-3">
      
      <h4>게시판 옵션</h4>
      <div class="checkbox">
        <label><input type="checkbox" name="fileAttach"> 파일첨부 기능</label><br/>
        <label><input type="checkbox" name="privateSet"> 비공개</label><br/>
        <label><input type="checkbox" name="notice"> 상단공지사항</label><br/>
        <label><input type="checkbox" name="reply"> 답글</label><br/>
        <label><input type="checkbox" name="comments"> 댓글</label><br/>
        <label><input type="checkbox" name="replyComment"> 리댓글 </label><br/>
      </div>
      
      <div class="text-center">
        <button class="btn btn-primary btn-md"  type="button" onclick="updateBoard();">수정</button>
        <button class="btn btn-primary btn-md"  type="button" onclick="deleteBoard()">삭제</button>   
      </div>  
    </form>
    </div>
 </div>
