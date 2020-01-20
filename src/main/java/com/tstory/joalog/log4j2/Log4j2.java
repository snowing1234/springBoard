package com.tstory.joalog.log4j2;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2 {

    private static Logger LOGGER = LoggerFactory.getLogger(Log4j2.class);

    public static void main(String[] args) throws IOException,SQLException{
        LOGGER.info("a test message");
    }
}