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
			     ${post.content}
			   </td>
			  </tr>
		 </tbody>
	</table>
	
  <c:if test="${updateAuthority eq 'T'}">
    <div class="r_button_wrapper" style="align:center">
	    <button class="btn btn-primary" type="button" onclick="movePage('update.do')">수정</button>
	    <button class="btn btn-primary" type="button" onclick="deletePost(${board.id}, ${post.postId})">삭제</button>
    </div>
  </c:if>
 
 </div>
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
 </style>
