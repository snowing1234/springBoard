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
              <td>${post.title} <span class="info">첨부 : ${post.fileCnt}</span></td>    
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
          if (id != null) {
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
