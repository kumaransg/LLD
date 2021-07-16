/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: LoggerLevel.java, v 0.1 2021-03-06 11:20 PM paras.chawla Exp $$
 */
public enum LoggerLevel {

    FATAL("FATAL", 5),
    ERROR("ERROR", 4),
    WARN("WARN", 3),
    INFO("INFO", 2),
    DEBUG("DEBUG", 1);

    private final String level;
    private final int    levelNumber;

    LoggerLevel(String level, int levelNumber) {
        this.level = level;
        this.levelNumber = levelNumber;
    }

    public String getLevel() {
        return level;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public static LoggerLevel getLevelByName(String levelName) {

        for (LoggerLevel loggerLevel : LoggerLevel.values()) {
            if (loggerLevel.getLevel().equals(levelName)) { return loggerLevel; }
        }
        return null;
    }

    public static List<LoggerLevel> getEqualToAndHigherLevels(LoggerLevel level) {
        if (level == null) {
            return null;
        }

        ArrayList<LoggerLevel> levelList = new ArrayList<LoggerLevel>();
        for (LoggerLevel l : LoggerLevel.values()) {
            if (l.getLevelNumber() >= level.getLevelNumber()) {
                levelList.add(l);
            }
        }

        return levelList;
    }

}