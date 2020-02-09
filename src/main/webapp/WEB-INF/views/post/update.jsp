<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <div class="container">
 
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>게시판</h2>
    <p class="lead">안녕하세요. 류지수의 게시판입니다.</p>
  </div>

  <div class="column">
    <div class="order-md-1">
      <h4 class="mb-3">${board.name}</h4>
      <form class="needs-validation .was-validated" id="form" name="form" novalidate>

        <div class="mb-3">
          <label for="username">제목</label>
          <div class="input-group">
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" value="${post.title}" required>
          </div>
        </div>

		    <div class="mb-3">
			  <label for="validationTextarea">내용</label>
			   <div class="input-group">
			     <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요"  rows="5">${post.content}</textarea>
			   </div>
		   </div>
		    <hr class="mb-4">
      </form>
      
       <div class="mb-3 fileAttach">
	         <span><b>첨부파일</b></span>
	         <div class="input-group">
	            <form id="fileForm"class="needs-validation .was-validated">
	               <input type="file" name="file" id="file"/>
	            </form>  
	         </div>
         
	         <div>
	             <ul id="attchedFile" class="simpleUL">
	             <c:forEach items="${files}" var="file" varStatus="status" step="1">
	                 <li id="file_${status.index}">
                      <svg class="bi bi-folder-symlink-fill" width="1.5em" height="1.5em" viewBox="0 0 20 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path d="M15.81 5h-3.982a2 2 0 01-1.414-.586l-.828-.828A2 2 0 008.172 3H4.5a2 2 0 00-2 2l.04.87a1.99 1.99 0 00-.342 1.311l.637 7A2 2 0 004.826 16h10.348a2 2 0 001.991-1.819l.637-7A2 2 0 0015.81 5zM4.19 5c-.24 0-.47.042-.684.12L3.5 4.98a1 1 0 011-.98h3.672a1 1 0 01.707.293L9.586 5H4.19zm9.608 5.271l-3.182 1.97c-.27.166-.616-.036-.616-.372V11.1s-2.571-.3-4 2.4c.571-4.8 3.143-4.8 4-4.8v-.769c0-.336.346-.538.616-.371l3.182 1.969c.27.166.27.576 0 .742z" clip-rule=""></path>
                       </svg>
	                     <span'><b>${file.filenameReal}</b> ${file.fileSize}Byte</span>
	                     <div class="btn badge badge-secondary"  onclick="deleteFile('${file.filenameReal}','file_${status.index}')">삭제</div>
	                  </li> 
	              </c:forEach>
	             </ul>
	         </div>
        </div>
     
      <div class="text-center">
        <button class="btn btn-primary btn-md"  type="button" onclick="updatePost(${post.boardId}, ${post.postId});">수정</button>
      </div> 
    </div>
  </div>
 </div>
 
 <style>
    .simpleUL{
		    list-style-type: none;
		    padding-left: 0
    }
    
    .simpleUL li {
        margin:10px;
    }
    
    .fileAttach {
      background: lightgray;
      padding: 20px;
      border-radius: .25rem;
    }
    
    .btn {
      cursor: pointer;
    }
 </style>
