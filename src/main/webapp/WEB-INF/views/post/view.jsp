<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <div class="container">
    <br />
    <br />
    <br />
    
   <h4 class="mb-3">${board.name}</h4>
   <table class="table">
	   <thead class="thead-light">
		   <tr><th>
		     <p class="title">${post.title}</p>
		     <ul class="info">
			     <li>${post.writer} </li>
			     <li>&nbsp|&nbsp</li>
			     <li> ${post.dateWrite}</li>
		     </ul> 
		   </th></tr>
     </thead>
     
     <tbody>
			 <tr>
			   <td>
			       <pre>${post.content}</pre>
			   </td>
			  </tr>
			  
			  <tr>
			     <td>
			         <span><b>첨부파일</b></span>
			         <c:forEach items="${files}" var="file" varStatus="idx" step="1">
			           <ul  class="simpleUL">
			                <li  class="table-font-center">
			                    <svg class="bi bi-folder-symlink-fill" width="1.5em" height="1.5em" viewBox="0 0 20 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
													    <path d="M15.81 5h-3.982a2 2 0 01-1.414-.586l-.828-.828A2 2 0 008.172 3H4.5a2 2 0 00-2 2l.04.87a1.99 1.99 0 00-.342 1.311l.637 7A2 2 0 004.826 16h10.348a2 2 0 001.991-1.819l.637-7A2 2 0 0015.81 5zM4.19 5c-.24 0-.47.042-.684.12L3.5 4.98a1 1 0 011-.98h3.672a1 1 0 01.707.293L9.586 5H4.19zm9.608 5.271l-3.182 1.97c-.27.166-.616-.036-.616-.372V11.1s-2.571-.3-4 2.4c.571-4.8 3.143-4.8 4-4.8v-.769c0-.336.346-.538.616-.371l3.182 1.969c.27.166.27.576 0 .742z" clip-rule=""></path>
													</svg>
                          ${file.filenameReal} 
                          <div class="btn badge badge-secondary" onclick='downloadFile("${file.filenameReal}")' >다운로드</div>
                      </li>
			           </ul>
			         </c:forEach>
			     </td>
			  </tr>
		 </tbody>
	</table> 
 </div>
 
   <c:if test="${updateAuthority eq 'T'}">
    <div class="r_button_wrapper" style="align:center">
      <button class="btn btn-primary" type="button" onclick="movePage('update.do')">수정</button>
      <button class="btn btn-primary" type="button" onclick="deletePost(${board.id}, ${post.postId})">삭제</button>
    </div>
  </c:if>
 <!--  style --> 
 <style>
  .title {
    float : left;
    font-size : 1.2em;
    margin-top : 0;
    margin-bottom : 0;
  }
  
  .info{
    list-style : none;
    float : right;
    font-weight : initial;
    margin-top : 0;
    margin-bottom : 0;
  }
  
  .info li {
    display : listitem ;
    float : left;
   }
   
  .r_button_wrapper {
    display : flex;
    flex-direction : row;
    justify-content : center;
    margin : 1em 0em 1em 0em;
  }
  
  button {
    margin : 0em 1em 0em 1em ;
  }
  
   .simpleUL{
        list-style-type: none;
        padding-left: 0
    }
    
    .simpleUL li {
        margin:10px;
    }
 </style>
