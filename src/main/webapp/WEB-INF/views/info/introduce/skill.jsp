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
    height : 4em;
    margin-left : auto;
    margin-right : auto;
    margin-bottom : 0.5em;
    display : block;
  }
  
  .title {
    padding-top : 50px;
  }
  
  .lang {
    padding : 1em 1em 1em 1em;
  }
  
  .border {
    border-radius: 0.5em;
    padding: 1.5em;
  }
  
</style>



  <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="container title">
      <h2>사용기술</h2> 
    </div>
    
    <div class="container">
	    <div class="row">
	      <div class="lang col-lg-6">
	         <div class=" border">
			        <img class="logo"  src="${pageContext.request.contextPath}/resources/image/info/egov.png" />
			        <ul class="list-group list-group-flush">
			          <li  class="list-group-item">카카오톡 로그인 API 구현</li>
			          <li  class="list-group-item">게시판 단일 파일첨부 및 삭제</li>
			          <li  class="list-group-item">게시판 CRUD</li>
			          <li  class="list-group-item">Mybatis</li>
			          <li  class="list-group-item">ORACLE</li>
			        </ul>
	        </div>
		    </div>
		    <div class="lang col-lg-6">
		      <div class=" border">
	          <img class="logo"  src="${pageContext.request.contextPath}/resources/image/info/cache.gif" />
	          <ul class="list-group list-group-flush">
	            <li  class="list-group-item">홈페이지 상단 배너, 공지사항 내 게시글 연결 처리</li>
	            <li  class="list-group-item">Discovery EDS 검색기능 개선 및 추가 <a href="http://kuh.futurenuri.co.kr/uload/schoSite/image/1453251641999.pdf">자세히 보기</a></li>
	            <li  class="list-group-item">학술 DB 사이트 SSO 추가</li>
	            <li  class="list-group-item">도서이미지 API 추가</li>
	            <li  class="list-group-item">간단한 안내페이지 추가 및 수정</li>
	          </ul>
          </div>
        </div>
        <div class=" lang col-lg-6">
            <div class=" border">
              <img class="logo" src="${pageContext.request.contextPath}/resources/image/info/nodejs2.png" />
               <ul class="list-group list-group-flush">
                <li  class="list-group-item">사용자 인증 (passport)</li>
                <li  class="list-group-item">파일첨부 (Multer)</li>
                <li  class="list-group-item">MySQL DB연결 및 사용(Sequelize)</li>
                <li  class="list-group-item">실시간 데이터 전송 (Soket.io)</li>
              </ul>
            </div>
        </div>  
	    </div>
	  </div>


