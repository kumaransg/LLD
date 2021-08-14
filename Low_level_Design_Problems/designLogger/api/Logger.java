/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.api;

import designLogger.conf.LoggerConfiguration;
import designLogger.enums.LoggerLevel;
import designLogger.model.Message;
import designLogger.strategy.SinkContext;
import designLogger.strategy.SinkStrategy;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: Logger.java, v 0.1 2021-03-07 10:53 PM paras.chawla Exp $$
 */
public class Logger {

    private static LoggerConfiguration instance = LoggerConfiguration.getInstance();

    SinkContext context=new SinkContext();

    public void log(@NonNull final String message, @NonNull final String level, @NonNull final String namespace) {

        LoggerLevel messageLoggerLevel = LoggerLevel.getLevelByName(level);
        LoggerLevel globalLoggerLevel = LoggerLevel.getLevelByName(instance.getGlobalLogLevel());

        // check whether need to log or not
        if (messageLoggerLevel.getLevelNumber() >= globalLoggerLevel.getLevelNumber()) {

            // get List<Sink> out of Level from configuration
            List<String> sinkList = instance.getConfig(messageLoggerLevel);

            // traverse sinkList and process message
            for (String sinkName : sinkList) {

                // get Sink Strategy and execute message
                SinkStrategy strategy = context.getRegisteredStrategy(sinkName);

                // execute message on particular strategy
                context.setStrategy(strategy);

                Message loggerMessage = new Message(messageLoggerLevel, LocalDateTime.now(),message,namespace);

                // execute Message
                context.executeStrategy(loggerMessage);
            }

        }
    }

    /* Add Level-Sink related Configuration */
    public void addLoggerConfig(String level, List<String> sink){
        LoggerLevel logLevel = LoggerLevel.getLevelByName(level);
        instance.addLevelSinkConfiguration(logLevel, sink);
    }

    /* Add Level-Sink related Configuration */
    public void addGlobalLogLevel(String level){
        instance.setGlobalLogLevel(level);
    }

}