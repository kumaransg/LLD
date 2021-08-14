package com.uditagarwal.pub_sub_queue.model;


public class Message {
    private final String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
