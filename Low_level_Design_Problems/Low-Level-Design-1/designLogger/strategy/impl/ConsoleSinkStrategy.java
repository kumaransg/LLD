/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.strategy.impl;

import designLogger.model.Message;
import designLogger.strategy.SinkStrategy;

/**
 * @author paras.chawla
 * @version $Id: ConsoleSinkStrategy.java, v 0.1 2021-03-07 11:28 PM paras.chawla Exp $$
 */
public class ConsoleSinkStrategy implements SinkStrategy {

    @Override
    public void write(Message message) {
        System.out.println("ConsoleSinkStrategy: " + message.getEpoch() +
                ": {" + message.getLoggerLevel().getLevel() + "}:" +
                ": {" + message.getNameSpace() + "}: "
                + message.getMessage());
    }
}