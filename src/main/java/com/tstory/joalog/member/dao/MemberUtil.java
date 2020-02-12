package com.tstory.joalog.member.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MemberUtil {

    public static String getIp (HttpServletRequest request) {
        String ip = null;
        if (ip == null) {	ip = request.getHeader("Proxy-Client-IP");}
        if (ip == null) {	 ip = request.getHeader("WL-Proxy-Client-IP");}
        if (ip == null) {	ip = request.getHeader("HTTP_CLIENT_IP");}
        if (ip == null) {	ip = request.getHeader("HTTP_X_FORWARDED_FOR");}
        if (ip == null) {	ip = request.getRemoteAddr();}
        return ip;
    }
    
    public static String getLoginId(HttpSession session) throws Exception{
    	String id = "";
    	try {
    		id = session.getAttribute("MYBOARD_MEMBER").toString();
    	} catch(Exception e) {
    		throw new Exception("ERROR_LOGOUT");
    	}
    	return id;
    }
    
    public static void setLogout(HttpSession session){
		session.setAttribute("MYBOARD_MEMBER", "");
		session.setAttribute("MYBOARD_MANAGER", "");
		session.setAttribute("MYBOARD_NICK", "");
    }
}
