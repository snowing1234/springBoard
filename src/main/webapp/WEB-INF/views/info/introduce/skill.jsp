<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>

  .left_box {
    background-color : #a38994;
    padding-right : 0px;
  }
  .right_box {
    padding : 6%;
  }
  
  .logo {
    width : 25%;
  }
  
  .title {
    padding-top : 50px;
  }
  
</style>



  <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="container title">
      <h2>사용기술</h2> 
    </div>
    
    <div class="container">
	    <div class="row">
		    <!-- Example row of columns -->
		    <div class="col-lg-6">
	        <h5><img class="logo" src="${pageContext.request.contextPath}/resources/image/info/nodejs.png" /></h5>
	         <ul class="list-unstyled">
	          <li>사용자 인증 (passport)</li>
	          <li>파일첨부 (Multer)</li>
	          <li>MySQL DB연결 및 사용(Sequelize)</li>
	          <li>실시간 데이터 전송 (Soket.io)</li>
	        </ul>
	        <span style="font-size: small; float: right; margin-right: 20%;">출처 : nodejs 교과서</span>
	      </div>  
	      <div class="col-lg-6">
	        <h5><img class="logo" style="margin : 10px 0px 10px 0px;" src="${pageContext.request.contextPath}/resources/image/info/egov.png" /></h5>
	        <ul class="list-unstyled">
	          <li></li>
	          <li>카카오톡 로그인 API 구현</li>
	          <li>게시판 CRUD</li>
	          <li>Mybatis</li>
	          <li>ORACLE</li>
	        </ul>
		    </div>
	    </div>
	  </div>


