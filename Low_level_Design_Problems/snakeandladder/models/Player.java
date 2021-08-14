/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package snakeandladder.models;

import lombok.Getter;

import java.util.UUID;

/**
 * @author paras.chawla
 * @version $Id: Player.java, v 0.1 2020-11-16 20:47 paras.chawla Exp $$
 */

@Getter
public class Player {

    private String name;
    private String id;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

}