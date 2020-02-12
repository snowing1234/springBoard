<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<style>
 .main_img {
   width : 20%;
   margin-left : auto;
   margin-right : auto;
   display : block;
   
 }
 
  .sub_img {
   width : 50%;
   margin-top : 20px;
   margin-bottom : 20px;
   margin-left : auto;
   margin-right : auto;
   display : block;
 }
 
 .sub_img_con {
   padding : 10px;
   text-align : center;
 }
 
 .top_container {
   text-align: center;
 }
 
 h3 {
   font-size: x-large;
 }
 
 h1 {
  color: honeydew;
  text-shadow: 0px 2px #ffffff, 3px 4px 0px #53899f;
 }
</style>

<main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron" style="background-color : #a3d1ce;">
    <div class="container top_container">
      <div class="img">
        <img class="main_img"src="${pageContext.request.contextPath}/resources/image/main/main_icon.png" >
      </div>
      <p><h1>MY PORTFOLIO</h1></p><span style="color: #4f5d73;">
      		<%
      			Object id= session.getAttribute("MYBOARD_NICK");
      			if (id != null && !id.toString().equals("")) { //f로그인 체크
      		%>
      				<%= id.toString()%>님 반갑습니다. <br/>
      				
      				상단의 메뉴를 통해 게시판을 사용해보세요.
			<%
      			}
      		%>
      	</span>
    </div>
  </div>

  <div class="container">
    <!-- Example row of columns -->
     <div class="row font-style">
      <div class="col-3 sub_img_con" onclick="movePage('/springBoard/info/introduce/profile.info')">
        <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/1.png">
        <span>프로필</span>
      </div>
      <div class="col-3 sub_img_con" onclick="movePage('/springBoard/info/introduce/skill.info')">
        <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/2.png">
        <span>사용 기술</span>
      </div>
      <div class="col-3 sub_img_con" onclick="openPage('https://github.com/snowing1234')">
        <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/3.png">
        <span>Git</span>
      </div>
      <div class="col-3 sub_img_con" onclick="openPage('https://joalog.tistory.com/')">
         <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/tstory.jpg">
         <span>blog</span>
      </div>
    </div>
    <div style="font-size: small; padding : 5% 5% 5% 5%; text-align : center;">
      	본 사이트는 반응형  홈페이지로 모바일과 데스크탑 버전 모두 사용 가능합니다.
      </div>
  </div> <!-- /container -->
</main>	
