/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package snakeandladder.service;

import java.util.Random;

/**
 * @author paras.chawla
 * @version $Id: DiceService.java, v 0.1 2020-11-16 20:49 paras.chawla Exp $$
 */
public class DiceService {

    //The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
    public static int roll() {
        return new Random().nextInt(6) + 1;
    }

}