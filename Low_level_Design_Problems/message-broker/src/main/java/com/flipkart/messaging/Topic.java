package com.flipkart.messaging;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 9:59 PM
 *
 * @author anirudha
 */
public class Topic {

    private final String name;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
