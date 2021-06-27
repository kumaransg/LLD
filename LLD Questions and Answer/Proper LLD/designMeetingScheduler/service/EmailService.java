/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler.service;

import designMeetingScheduler.externalclient.SESClient;

import java.util.List;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: EmailService.java, v 0.1 2021-03-18 10:47 AM paras.chawla Exp $$
 */
public class EmailService {

    SESClient client;

    public void sendBulkEmail(String template, List<String> emails, Map<String, Object> model) {
        for (String email : emails) {
            sendEmail(template, email, model);
        }
    }

    private boolean sendEmail(String template, String email, Map<String, Object> model) {
        return client.sendTemplateEmail(template, email, model);
    }
}