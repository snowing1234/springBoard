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
  
</style>

<main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="row">
	    <!-- Example row of columns -->
	    <div class=" left_box col-lg-6 sub_img_con" >
	      <img src="${pageContext.request.contextPath}/resources/image/info/profile3.jpg" style="width:100%">
	    </div>
	    <div class="col-lg-6 right_box">
        <h2 stlye="font-family:">프로필</h2>

        <br/>
        <h5><b>사용언어</b></h5>
         <ul class="list-unstyled">
          <li>Java</li>
          <li>javascript</li>
          <li>JQuery</li>
          <li>nodejs</li>
          <li>
              <a href="https://www.intersystems.com/products/cache/">
                  Caché (케세이, interSystems)
              </a>
          </li>
        </ul>


        <h5><b>자격증</b></h5>
        <ul class="list-unstyled">
          <li>정보처리기사</li>
          <li>SQL Developer</li>
          <li>MOS Master</li>
          <li>워드프로세서 1급</li>
        </ul>

	      
	
	     <h5><b>정독한 개발 도서 목록 </b></h5>
				<table class="table table-responsive-xl x">
				   <tr>
	           <td> <img style="width : 100px;" src="https://image.aladin.co.kr/product/2049/54/cover500/899264986x_1.jpg"></td>
	           <td>
	             <ul class="list-unstyled"> 
	               <li><b>Power Java</b></li>        
	               <li>천인국, 하상호</li>  
	               <li>인피니티북스</li>
	             </ul>
	           </td>
	         </tr>
				   <tr>
				     <td> <img style="width : 100px;" src="https://image.aladin.co.kr/product/2030/81/cover150/8959522678_1.jpg"></td>
				     <td>
               <ul class="list-unstyled"> 
	               <li><b>바로바로 할 수 있는 jQuery 입문</b></li>        
	               <li>유광열</li>  
	               <li>제우미디어</li>
	             </ul>
	           </td>
				   </tr>
				   <tr>
	           <td> <img style="width : 100px;" src="https://image.aladin.co.kr/product/50/85/cover500/1156641780_1.jpg"></td>
	           <td>
               <ul class="list-unstyled"> 
	               <li><b>C C++로 배우는 자료구조</b></li>        
	               <li>주우석 , 최종환</li>  
	               <li>한빛아카데미</li>
	             </ul>
	           </td>
	         </tr>
	         <tr>
	           <td> <img style="width : 100px;" src="https://image.aladin.co.kr/product/7012/98/cover500/8980782802_1.jpg"></td>
	           <td>
               <ul class="list-unstyled"> 
	               <li><b>JSP 웹프로그래밍</b></li>        
	               <li>최범균</li>  
	               <li>가메출판사</li>
	             </ul>
	           </td>
	         </tr>
	         <tr>
             <td> <img style="width : 100px;" src="https://image.aladin.co.kr/product/15837/93/cover150/k422533335_1.jpg"></td>
             <td>
               <ul class="list-unstyled"> 
                 <li><b>Node.js 교과서</b></li>        
                 <li>조현영</li>  
                 <li>길벗</li>
               </ul>
             </td>
           </tr>
				</table>
	    </div>
    </div>
</main>	

