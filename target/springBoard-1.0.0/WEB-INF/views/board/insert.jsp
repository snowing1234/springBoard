<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tstory.joalog.board.dao.Board" %>
 <div class="container">
 
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>게시판</h2>
    <p class="lead">안녕하세요. 류지수의 게시판입니다.</p>
  </div>

  <div class="column">
    <div class="order-md-1">
      <h4 class="mb-3">게시판 이름</h4>
      <form class="needs-validation .was-validated" method="post" action="insert.do" novalidate>

        <div class="mb-3">
          <label for="username">제목</label>
          <div class="input-group">
            <input type="text" class="form-control" id="validationCustom01" name="boardTitle" placeholder="제목을 입력하세요" required>
          </div>
        </div>

	    <div class="mb-3">
		  <label for="validationTextarea">내용</label>
		   <div class="input-group">
		     <textarea class="form-control" id="validationTextarea" name="content" placeholder="Required example textarea" required></textarea>
		  </div>
		</div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">작성</button>
      </form>
    </div>
  </div>
 </div>
