/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.conf;

import designLogger.enums.LoggerLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: LoggerConfiguration.java, v 0.1 2021-03-06 11:47 PM paras.chawla Exp $$
 */

// Singleton instance used by whole application
public class LoggerConfiguration {

    private static volatile LoggerConfiguration instance = null;

    private Map<LoggerLevel, List<String>> levelSinkConfigmap = new HashMap<>();
    private String globalLogLevel=null;

    private LoggerConfiguration() {}

    public static LoggerConfiguration getInstance() {
        if (instance == null) {
            // t1 and t2
            synchronized (LoggerConfiguration.class) {
                // t1 entered
                if (instance == null) {
                    instance = new LoggerConfiguration();
                } else {
                    return instance;
                }
            }
        }
        return instance;
    }

   public void addLevelSinkConfiguration(LoggerLevel level, List<String> sinkTypes){
       if(level==null || sinkTypes==null || sinkTypes.isEmpty()){
           return;
       }

       levelSinkConfigmap.put(level, sinkTypes);
   }

    public List<String> getConfig(LoggerLevel level){
        if(level==null){
            return null;
        }

        if(levelSinkConfigmap.containsKey(level)){
            return levelSinkConfigmap.get(level);
        }else {
            return null;
        }
    }

    public void setGlobalLogLevel(String globalLogLevel) {
        this.globalLogLevel = globalLogLevel;
    }

    public String getGlobalLogLevel() {
        return globalLogLevel;
    }
}