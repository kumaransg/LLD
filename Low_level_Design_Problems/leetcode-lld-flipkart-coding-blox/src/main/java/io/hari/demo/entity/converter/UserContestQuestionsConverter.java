package io.hari.demo.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.hari.demo.entity.helper.UserContestQuestions;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @Author hayadav
 * @create 5/1/2021
 */
public class UserContestQuestionsConverter implements AttributeConverter<UserContestQuestions, String> {
    ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(UserContestQuestions userContestQuestions) {
        if (userContestQuestions == null) return "";
        return objectMapper.writeValueAsString(userContestQuestions);
    }

    @SneakyThrows
    @Override
    public UserContestQuestions convertToEntityAttribute(String s) {
        if (s.equals("") || s == null) return new UserContestQuestions();
        return objectMapper.readValue(s, UserContestQuestions.class);
    }
}
