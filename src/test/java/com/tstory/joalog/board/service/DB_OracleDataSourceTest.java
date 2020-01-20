package com.tstory.joalog.board.service;

import java.sql.Connection;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/mapper/context-mapper.xml"}) 
 
public class DB_OracleDataSourceTest {
 
    @Inject
    private DataSource ds;
    
    @Test
    public void testConection() throws Exception{
        
        try(Connection con = ds.getConnection()){
            System.out.println(con);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
