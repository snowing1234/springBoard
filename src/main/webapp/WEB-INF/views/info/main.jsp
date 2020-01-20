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
</style>

<main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron" style="background-color : #a3d1ce;">
    <div class="container top_container">
      <div class="img">
        <img class="main_img"src="${pageContext.request.contextPath}/resources/image/main/main_icon.png" >
      </div>
      <p><h1>MY PORTFOLIO</h1></p>
    </div>
  </div>

  <div class="container">
    <!-- Example row of columns -->
     <div class="row font-style">
      <div class="col-sm-3 sub_img_con" onclick="movePage('/springBoard/info/introduce/profile.info')">
        <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/1.png">
        <h3>프로필</h3>
      </div>
      <div class="col-sm-3 sub_img_con" onclick="movePage('/springBoard/info/introduce/skill.info')">
        <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/2.png">
        <h3>사용 기술</h3>
      </div>
      <div class="col-sm-3 sub_img_con" onclick="movePage('https://github.com/snowing1234')">
        <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/3.png">
        <h3>Git</h3>
      </div>
      <div class="col-sm-3 sub_img_con" onclick="movePage('https://joalog.tistory.com/')">
         <img class="sub_img" src="${pageContext.request.contextPath}/resources/image/main/tstory.jpg">
         <h3>blog</h3>
      </div>
    </div>
  </div> <!-- /container -->
</main>	
