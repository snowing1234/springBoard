<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="container">
 
	  <div class="py-5 text-center">
	    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
	    <h2>게시판</h2>
	  </div>
	
	
	<div class="column">
    <div class="order-md-1">
      <h4 class="mb-3">게시판 이름</h4>
      <form class="needs-validation .was-validated" id="form">

        <div class="mb-3">
          <label for="username">제목</label>
          <div class="input-group">
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" required>
          </div>
        </div>

	      <div class="mb-3">
			      <label for="validationTextarea">내용</label>
			       <div class="input-group">
			         <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요" required></textarea>
			      </div>
	       </div>
	       <hr class="mb-4">
      </form>
      
      
      <div class="mb-3">
         <label for="validationTextarea">첨부파일</label>
         <div class="input-group">
            <form id="fileForm"class="needs-validation .was-validated">
           <input type="file" name="file" id="file"/>
            </form>  
         </div>
         
         <div>
             <ul id="attchedFile" style="">
                 <li></li>
             </ul>
         </div>
     </div>
         
      <button class="btn btn-primary btn-lg btn-block" type="button" onclick="insertPost()">작성</button>
    </div>
  </div>
 </div>