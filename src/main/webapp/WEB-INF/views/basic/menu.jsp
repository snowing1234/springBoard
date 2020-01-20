<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상단 고정용 
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">  -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark navbar-application">
  <a class="navbar-brand" href="/springBoard/index.jsp">MY PORTFOLIO</a>
      
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse collapse" id="navbarsExampleDefault">
    <ul class="nav navbar-nav  navbar-global ">
      <li class="nav-item active">
				<a class="nav-link" href="/springBoard/post/0/list.do">게시판 <span class="sr-only"></span></a>
      </li>
    </ul>

    <ul class="nav navbar-nav ml-auto">
      <% Object id = session.getAttribute("MYBOARD_MEMBER");
         Object manager = session.getAttribute("MYBOARD_MANAGER");
         if (id == null || id.toString().equals("")) {%> <!-- 로그아웃 상태 -->
       <li class="nav-item"><a class="nav-link" href="/springBoard/member/login.do">로그인</a></li>
      <% } else if(id.toString().contains("KAKAO")){ %> <!-- KAKAO 회원 -->
       <li class="nav-item nav-nick"><%=session.getAttribute("MYBOARD_NICK")%>님</li>
       <li class="nav-item"><a class="nav-link" href="/springBoard/member/logout.do">로그아웃</a></li>
      <% } else if(manager == null || manager.toString().equals("")){ %> <!-- MY BAORD 회원 -->
       <li class="nav-item nav-nick"><%=session.getAttribute("MYBOARD_NICK")%>님</li>
       <li class="nav-item"><a class="nav-link" href="/springBoard/member/myInfo.do">내 정보</a></li>
    	 <li class="nav-item"><a class="nav-link" href="/springBoard/member/logout.do">로그아웃</a></li>
    	<% } else{ %> <!-- MY BAORD 관리자 -->
    	 <li class="nav-item"><a class="nav-link" href="/springBoard/member/myInfo.do">내 정보</a></li>
       <li class="nav-item"><a class="nav-link" href="/springBoard/member/logout.do">로그아웃</a></li>
       <li class="nav-item"><a class="nav-link" href="/springBoard/board/list.do">관리자</a></li>
    	<% } %>
    	
    	
    </ul>
  </div>
</nav>

