<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="container">
 
  <div class="py-5 text-center">
    <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h2>MY PORTFOLIO</h2>
    <p class="lead">회원가입</p>
  </div>

  <div class="column">
    <div class="order-md-1">
      <h4 class="mb-3">회원 가입</h4>
      <form class="needs-validation .was-validated" id="member" novalidate>
        <div class="mb-3">
          <label for="id">아이디</label>
          <div class="input-group">
            <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요" required>
            <button type="button" class="btn btn-outline-primary" onclick="CheckId()">중복검사</button>
            <div class="invalid-feedback" id="warn_id">
                            중복검사를 해주세요.
            </div>
          </div>
        </div>
	      <div class="mb-3">
		      <label for="pw">비밀번호</label>
		     <div class="input-group">
            <input type="password" class="form-control" id="pw" name="pw" placeholder="아이디를 입력하세요" required>
          </div>
	  	  </div>
	  	  <div class="mb-3">
          <label for="pw2">비밀번호 확인</label>
          <div class="input-group">
            <input type="password" class="form-control" id="pw2" name="pw2" placeholder="아이디를 입력하세요" required>
          </div>
        </div>
        
	  	  <div class="mb-3">
          <label for="nickName">닉네임</label>
          <div class="input-group">
            <input type="text" class="form-control" onkeyup="CheckNickName()" id="nickName" name="nickName" placeholder="아이디를 입력하세요" required>
            <div class="invalid-feedback" id="warn_nickname">
                          
           </div>
          </div>
        </div>
        
		  	<hr class="mb-4">
	      <button class="btn btn-primary btn-lg btn-block" type="button" onclick="insertMember()">작성</button>
      </form>
    </div>
  </div>
 </div>

