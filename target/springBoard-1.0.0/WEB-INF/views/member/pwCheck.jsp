
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.tstory.joalog.member.dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>

  .row {
   margin : 10px;
  }
  
  h3{
    margin : 50px 10px 50px 25px;
  }
</style>

<br />
<div class="container" style="max-width = 780px;">
  <h3>비밀번호 변경</h3>
  <form class="form-update" method="post" action="update.do">
	  <div class="row">
	     <div class="col-sm-4"><label for="currentPW">현재 비밀번호</label></div>
	     <div class="col-sm-8"><input type="password" id="currentPW" class="form-control" placeholder="" required autofocus></div>
	  </div>
	  <div class="row">
  	  <button class="btn btn-lg btn-primary btn-block" type="button" onclick="deleteMember()">확인</button>
	  </div>
  </form>
</div>
