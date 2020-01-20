package com.tstory.joalog.board.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;

public class DB_ConnectionTest {
	
	String CLASS = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String USERNAME = "springboard";
	String PASSWORD = "1234";
	
	Connection conn;
	
	@Test
	public void testConnect() throws Exception{
		try {     //5.생성자에서 커넥션 얻기
			 
            Class.forName(CLASS);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
 
        } catch (SQLException e) {
        	 e.printStackTrace();
        }  
	}
}
