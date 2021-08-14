/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designBlackJack.util;

/**
 * @author paras.chawla
 * @version $Id: AssortedMethodsUtil.java, v 0.1 2020-12-20 14:01 paras.chawla Exp $$
 */
public class AssortedMethodsUtil {

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
}