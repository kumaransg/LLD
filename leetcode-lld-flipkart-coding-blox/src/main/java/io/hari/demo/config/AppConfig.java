package io.hari.demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Map;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "app-config")
public class AppConfig {
    Map<String, BigInteger> scoreConstant;
    ContestQuestionAssignment contestQuestionAssignment;

    @Getter
    @ToString
    public static enum ContestQuestionAssignment {
        all_questions, random_questions;
    }
}

