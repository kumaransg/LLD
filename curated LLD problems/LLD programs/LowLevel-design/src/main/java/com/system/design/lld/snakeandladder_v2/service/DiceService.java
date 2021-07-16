package com.system.design.lld.snakeandladder_v2.service;

import lombok.Builder;
import lombok.Data;

import java.util.Random;

@Data
@Builder
public class DiceService {
    public static int roll() {
        return new Random().nextInt(6) + 1; // The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
    }
}
