/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.model;

import com.pc.multilevelparkinglot.exception.InvalidCommandException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: Command.java, v 0.1 2020-11-20 10:18 paras.chawla Exp $$
 */

// User command with command name and params
@Getter
public class Command {

    private              String       commandName;
    private              List<String> params = new ArrayList<>();
    private static final String       SPACE = " ";

    // take input Line, parse and convert into commandName and params
    public Command(String inputString) {

        String tokenList[] = inputString.trim().split(SPACE);

        if (tokenList.length == 0) {
            throw new InvalidCommandException();
        }

        commandName = tokenList[0].toLowerCase();

        for (int i = 1; i < tokenList.length; i++) {
            params.add(tokenList[i]);
        }
    }

}