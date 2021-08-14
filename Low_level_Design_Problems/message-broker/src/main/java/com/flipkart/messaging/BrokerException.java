package com.flipkart.messaging;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 10:46 PM
 *
 * @author anirudha
 */
public class BrokerException extends Exception {

    public BrokerException(String msg) {
        super(msg);
    }

    public BrokerException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
