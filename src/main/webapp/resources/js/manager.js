/**
 * 게시글 JAVASCRIPT 함수 모음
 */

/*******************게시글**************************/

  function getTistoryPostList() {
	    const app_key = "75b39948020ccbb447a6246fe5de10be";
	    const redirect_uri = "http://110.35.176.5:9090/springBoard/api/tistory/list.do"; 
	    alert(`https://www.tistory.com/oauth/authorize?client_id=${app_key}&redirect_uri=${redirect_uri}&response_type=code&state=110.35.176.5:9090`);
	    window.open(`https://www.tistory.com/oauth/authorize?client_id=${app_key}&redirect_uri=${redirect_uri}&response_type=code&state=110.35.176.5:9090`, "_blank");
	}
