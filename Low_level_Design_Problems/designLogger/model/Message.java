/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.model;

import designLogger.enums.LoggerLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author paras.chawla
 * @version $Id: Message.java, v 0.1 2021-03-06 11:20 PM paras.chawla Exp $$
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    private LoggerLevel   loggerLevel;
    private LocalDateTime epoch;
    private String message;
    private String nameSpace;

}