package com.system.design.oops.amazon;


import java.util.Date;

public abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public boolean sendNotification(Account account){ return true;}
}
