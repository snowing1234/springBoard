<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="com.tstory.joalog.post.dao.Post" %>
<%@ page import="com.tstory.joalog.board.dao.Board" %>
<%@ page import="java.util.List" %>

<% List<Post> list = (List<Post>) request.getAttribute("list");
   Board board = (Board) request.getAttribute("board"); System.out.println(list);
%>

    <br />
    <br />
    <br />
    <div class="container">
    
      <h3>${board.name}</h3>
      <table class="table table-responsive-xl x">
        <thead class="thead-light">
         <tr class="table-font-center"> 
          <th scope="col">ⓒ</th>
          <th scope="col">제목</th>
          <th scope="col">작성자</th>
          <th scope="col">조회수</th>
          <th scope="col">작성일</th>
         </tr>
        </thead>
        <tbody>
          <c:if test="${list == null || list.size() == 0 }">
            <tr>
               <th><div>생성된 게시판이 없습니다. 게시판을 생성해주세요.</div></th>
            </tr>
          </c:if>
          <c:forEach items="${list}" var="post" varStatus="idx" step="1">
            <tr onclick='movePage("${post.postId}/view.do")'>
              <th  class="table-font-center">${idx.count}</th>
              <td>${post.title} 
              		<c:if test="${post.fileCnt > 0}">
						<svg class="bi bi-folder" width="1em" height="1em" viewBox="0 0 20 20" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
						  <path d="M11.828 6a3 3 0 01-2.12-.879l-.83-.828A1 1 0 008.173 4H4.5a1 1 0 00-1 .981L3.546 6h-1L2.5 5a2 2 0 012-2h3.672a2 2 0 011.414.586l.828.828A2 2 0 0011.828 5v1z"></path>
						  <path fill-rule="evenodd" d="M15.81 6H4.19a1 1 0 00-.996 1.09l.637 7a1 1 0 00.995.91h10.348a1 1 0 00.995-.91l.637-7A1 1 0 0015.81 6zM4.19 5a2 2 0 00-1.992 2.181l.637 7A2 2 0 004.826 16h10.348a2 2 0 001.991-1.819l.637-7A2 2 0 0015.81 5H4.19z" clip-rule="evenodd"></path>
						</svg>
						<span>${post.fileCnt}</span>
					</c:if>
			  </td>    
              <td class="table-font-center">${post.writernick}</td>
              <td class="table-font-center">${post.hit}</td>
              <td class="table-font-center">${post.dateWrite}</td>
            </tr>
          </c:forEach>
       </tbody>
      </table>
    
      <div class="row">
        <div class="col-9"></div>
        <%
          Object id = session.getAttribute("MYBOARD_MEMBER");
          if (id != null &&  (!id.toString().equals("")) ) {
        %>
        <div class="col-3"><a class="btn btn-outline-primary" href="insert.do">글쓰기</a></div>
        <% } %>
      </div>
    </div>

<style>
.info {
  color : #dee2e6;
}

.table-font-center {
  text-align : center;
}
</style>
