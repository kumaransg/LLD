/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package snakeandladder.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: SnakeAndLadderBoard.java, v 0.1 2020-11-16 20:54 paras.chawla Exp $$
 */
// A board includes Snakes, Ladders,Players,size
@Getter
@Setter
public class SnakeAndLadderBoard {

    private int          size;
    private List<Snake>  snakes;
    private List<Ladder> ladders;

    // Player UUID, current Position
    private Map<String, Integer> playerPosition;

    public SnakeAndLadderBoard(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPosition = new HashMap<>();
    }

}