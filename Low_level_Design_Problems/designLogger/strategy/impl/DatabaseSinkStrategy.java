/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.strategy.impl;

import designLogger.model.Message;
import designLogger.strategy.SinkStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: ConsoleSinkStrategy.java, v 0.1 2021-03-07 11:28 PM paras.chawla Exp $$
 */
public class DatabaseSinkStrategy implements SinkStrategy {

    Map<LocalDateTime,Message> inMemoryDatabase = new HashMap();

    @Override
    public void write(Message message) {
        inMemoryDatabase.put(message.getEpoch() ,message);
        System.out.println(inMemoryDatabase);
    }
}