
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-control {
  margin-bottom : 20px;
}

.text-center{
  text-align : center;
}
</style>

<script type="Text/javascript">
	function login(){
		if ($("#id").val() == "") {
			alert("아이디를 입력해주세요.");
			return false;
		}
		if ($("#pw").val() == "") {
			alert("비밀번호를 입력해주세요.");
		  return false;
		}
		var form =  $("#form").serialize();
		  $.ajax({
		    cache : false,
		    method:"POST",
		    
		    url : pageContext+"/member/login.do", // 요기에
		    data : form,
		    success:function(data){
		      if (data == false) {
		    	  alert("정보를 다시 확인해주세요"); 
		      }else{
		    	  //메인으로 이동
		    	  location.href = pageContext+"/index.jsp";
		      }
		    },
		    error:function(request,status){
		      alert("잠시후 록인을 재시도 해주세요.");
		    }
		  });
	}
</script>


<br />
<div class="container" style="max-width = 780px;">
	<form class="form-signin" id="form" method="post" action="login.do">
	
	  <label for="inputId">아이디</label>
	  <input type="text" id="id" name="id" class="form-control" placeholder="아이디" required autofocus>
	  <label for="inputPw">비밀번호</label>
	  <input type="password" id="pw" name="pw"class="form-control" placeholder="비밀번호" required>
	     <div class="checkbox">
      <label>
        <input type="checkbox" value="remember-me"> 자동 로그인
      </label>
    </div>
    
	  <button class="btn btn-lg btn-primary btn-block login" type="button" onclick="login()">로그인</button>

	  <div class="join">아직 회원이 아니신가요? <a href="insert.do">회원가입 ></a></div>
	</form>
	
	<hr/>
	
	<div class="form-signin kakao_login">
	   <a onclick="kakao_getToken()">
	     <img src="/springBoard/resources/image/login_kakao.png" />
	   </a>
	</div>
</div>

<style>
  .join {
	  text-align : center;
	  padding : 10 10 10 10;
  }
  
  .login {
    font-size : 1.0em;
  }
  .kakao_login {
    float : center;
  }
</style>
