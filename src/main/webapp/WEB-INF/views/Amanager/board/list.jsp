<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  jstl useing set -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="com.tstory.joalog.board.dao.Board" %>
<%@ page import="java.util.List" %>

<script type="text/javascript"  src="<c:url value="/resources/js/manager.js"/>"></script>

<!--  페이지에서 사용할 정보 셋팅 -->
<% List<Board> list = (List<Board>) request.getAttribute("list"); %>




    <br />
    <br />
    <br />
    <div class="container">
    
      <div class="row">
           <a class="btn btn-outline-primary" href="javascript:getTistoryPostList()">티스토리 게시글 업데이트</a>
      </div>
      <h3>관리자 게시판 설정</h3>
      <table class="table table-responsive-xl table-hover x">
	      <thead class="thead-light">
	       <tr> 
	         <th scope="col">ⓒ</th>
	         <th scope="col">아이디</th>
	         <th scope="col">이름</th>
	         <th scope="col">공개 여부</th>
	         <th scope="col">파일첨부</th>
	         <th scope="col">공지사항</th>
	         <th scope="col">답글</th>
	         <th scope="col">댓글</th>
	         <th scope="col">답댓글</th>
	         <th scope="col">리스트</th>
	         <th scope="col">카테고리</th>
	        </tr>
	      </thead>
        <tbody>
          <c:if test="${list == null}">
            <tr>
               <th><div>생성된 게시판이 없습니다. 게시판을 생성해주세요.</div></th>
            </tr>
          </c:if>
		      <c:forEach items="${list}" var="board" varStatus="idx" step="1">
	          <tr onclick='movePage("${board.id}/update.do")'>
		          <th scope="row">${idx.count}</th>
		          <td>${board.id}</td>
		          <td>${board.name}</td>    
		          <td>${board.privateSet}</td>
		          <td>${board.fileAttach}</td>
		          <td>${board.notice}</td>
		          <td>${board.reply}</td>
		          <td>${board.comments}</td>
		          <td>${board.replyComment}</td>
		          <td>${board.listStyle}</td>
		          <td>${board.category1}</td>
	          </tr>
		      </c:forEach>
        </tbody>
       </table>
    
	     <div class="row">
	       <div class="col-8"></div>
	      <%
	        Object id = session.getAttribute("MYBOARD_MEMBER");
	        if (id != null) {
	      %>
	       <div class="col-4"><a class="btn btn-outline-primary" href="insert.do">게시판 생성</a></div>
	      <% } %>
	    </div>
    </div>

