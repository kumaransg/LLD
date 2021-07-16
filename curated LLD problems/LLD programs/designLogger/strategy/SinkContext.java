/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.strategy;

import designLogger.model.Message;
import designLogger.strategy.impl.ConsoleSinkStrategy;
import designLogger.strategy.impl.DatabaseSinkStrategy;
import designLogger.strategy.impl.FileSinkStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: SinkContext.java, v 0.1 2021-03-07 11:03 PM paras.chawla Exp $$
 */
public class SinkContext {

    private        SinkStrategy              sinkStrategy;
    private static Map<String, SinkStrategy> strategyRegister = new HashMap<>();

    static {
        SinkContext.registerStrategy("Console", new ConsoleSinkStrategy());
        SinkContext.registerStrategy("Database", new DatabaseSinkStrategy());
        SinkContext.registerStrategy("File", new FileSinkStrategy());
    }

    private static void registerStrategy(String strategyName, SinkStrategy strategy) {
        strategyRegister.put(strategyName, strategy);
    }

    public static SinkStrategy getRegisteredStrategy(String strategyName) {
        if (strategyRegister.containsKey(strategyName)) {
            return strategyRegister.get(strategyName);
        }

        return null;
    }

    public void setStrategy(SinkStrategy strategy) {
        this.sinkStrategy = strategy;
    }

    public void executeStrategy(Message loggerMessage){
        this.sinkStrategy.write(loggerMessage);
    }

}