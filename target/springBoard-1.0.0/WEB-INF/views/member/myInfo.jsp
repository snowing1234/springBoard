
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.tstory.joalog.member.dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  본문 -->
<br />
<div class="container">
  <h3>내 정보</h3>
  <table class="table table-borderless"> 
    <tr class="row">
      <td class="col-3"><b>아이디 </b></td>
      <td class="col-9">${member.id}</td>
    </tr>
    <tr class="row">
      <td class="col-3"><b>닉네임</b></td>
      <td class="col-9">${member.nickName}</td>
    </tr>
    <tr class="row">
      <td class="col-3"><b>비밀번호</b></td>
      <td class="col-9"><a href="update.do">비밀번호 변경></a></td>
    </tr>
    <tr class="row">
      <td class="col-3"><b>가입일</b></td>
      <td class="col-9"><a href="update.do">${member.dateRegister}</a></td>
    </tr>
  </table>
  
   <div style="text-align:right;">
     <a href="pwCheck.do">회원탈퇴 </a>
   </div>
</div>


    <!-- 로그인 체크 -->
    <% if (request.getAttribute("member") == null) { %>
      <script type="text/javascript">
        errorLogin();
      </script>
    <% } %>
    
