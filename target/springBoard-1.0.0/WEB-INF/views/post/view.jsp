<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <div class="container">

   <h4 class="mb-3">${post.boardId}</h4>
   <table class="table">
	   <thead class="thead-light">
		   <tr>
		     <th scope="col"><div class="title">${post.title}</div></th>
		   </tr>
     </thead>
     
     <tbody>
       <tr><td>작성자  ${post.writer} | ${post.dateWrite}</td></tr>
			 <tr>
			   <td>
			     ${post.content}
			   </td>
			  </tr>
		 </tbody>
	</table>
	
  <c:if test="${updateAuthority eq 'T'}">
    <div class="r_button_wrapper" style="align:center">
	    <button class="btn btn-primary" type="button" onclick="movePage('update.do')">수정</button>
	    <button class="btn btn-primary" type="button" onclick="movePage('delete.do')">삭제</button>
    </div>
  </c:if>
 
 </div>
 <!--  style --> 
 <style>
  .title {
    font-size : 1.3em;
    padding: 1.3rem;
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
 </style>
