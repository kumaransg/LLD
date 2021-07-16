/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger;

import designLogger.api.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: MainClientRunner.java, v 0.1 2021-03-07 11:46 PM paras.chawla Exp $$
 */
public class MainClientRunner {

    public static void main(String[] args) {

        /* Client adding logging configuration as per conveience*/
        Logger logger = new Logger();

        List<String> fatalSinkType = new ArrayList<>();
        fatalSinkType.add("Database");
        fatalSinkType.add("Console");

        logger.addLoggerConfig("FATAL",fatalSinkType);

        List<String> errorSinkType = new ArrayList<>();
        errorSinkType.add("File");
        errorSinkType.add("Console");

        logger.addLoggerConfig("ERROR",errorSinkType);

        List<String> warnSinkType = new ArrayList<>();
        warnSinkType.add("Console");

        logger.addLoggerConfig("WARN",warnSinkType);

        List<String> infoSinkType = new ArrayList<>();
        warnSinkType.add("Console");

        logger.addLoggerConfig("INFO",warnSinkType);

        List<String> debugSinkType = new ArrayList<>();
        warnSinkType.add("Console");

        logger.addLoggerConfig("INFO",warnSinkType);

        // Setting global Logger Level
        logger.addGlobalLogLevel("WARN");

        logger.log("I'm fatal", "FATAL", "Main.class");
        logger.log("I'm Error", "ERROR", "Main.class");
        logger.log("I'm Warn", "WARN", "Main.class");
        logger.log("I'm debug", "DEBUG", "Main.class");
        logger.log("I'm Info", "INFO", "Main.class");

    }

}