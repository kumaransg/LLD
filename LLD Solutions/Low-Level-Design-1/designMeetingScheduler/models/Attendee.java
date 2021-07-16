/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designMeetingScheduler.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author paras.chawla
 * @version $Id: Attendee.java, v 0.1 2021-03-18 10:43 AM paras.chawla Exp $$
 */

@Getter
@Setter
@AllArgsConstructor
public class Attendee {

    String name;
    String emailId;
}