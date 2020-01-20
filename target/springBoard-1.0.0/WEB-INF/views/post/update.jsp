<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="container">
 
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>게시판</h2>
    <p class="lead">안녕하세요. 류지수의 게시판입니다.</p>
  </div>

  <div class="column">
    <div class="order-md-1">
      <h4 class="mb-3">게시판 이름</h4>
      <form class="needs-validation .was-validated" id="form" novalidate>

        <div class="mb-3">
          <label for="username">제목</label>
          <div class="input-group">
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" value="${post.title}" required>
          </div>
        </div>

		    <div class="mb-3">
			  <label for="validationTextarea">내용</label>
			   <div class="input-group">
			     <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요" value="${post.content}"required></textarea>
			   </div>
		   </div>
      </form>
      
      <div class="text-center">
        <button class="btn btn-primary btn-md"  type="button" onclick="updatePost();">수정</button>
        <button class="btn btn-primary btn-md"  type="button" onclick="deletePost()">삭제</button>   
      </div>  
      
    </div>
  </div>
 </div>
