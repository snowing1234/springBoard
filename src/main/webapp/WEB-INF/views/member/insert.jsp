<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="container">
 
  <div class="py-5 text-center">
    <h2>MY PORTFOLIO</h2>
    <p class="lead">회 원 가 입</p>
  </div>

  <div class="column">
    <div class="order-md-1">
      
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
          
          <br />
          <br />
          <h5 class="mb-3">회원 가입 안내</h5>
          <p>MY PORTFOLIO 회원가입 페이지 입니다. 회원 식별을 위한 최소한의 정보를 수집하고 있습니다. 회원정보는 현재 암호화되어 저장되지 않으므로 자주 사용하시는 비밀번호는 가급적 사용하지 마시기 바랍니다.
      			비밀번호는 가입 후 변경가능하며, 회원탈퇴 시 회원정보는 지체없이 파기됩니다.
      	  </p>
      	  
      	 <b> 위 주의사항에 동의하십니까?</b>
      	  <input type="checkBox" id="agree"/>
        </div>
        
        
      
        
		  	<hr class="mb-4">
	      <button class="btn btn-primary btn-lg btn-block" type="button" onclick="insertMember()">작성</button>
      </form>
    </div>
  </div>
 </div>

