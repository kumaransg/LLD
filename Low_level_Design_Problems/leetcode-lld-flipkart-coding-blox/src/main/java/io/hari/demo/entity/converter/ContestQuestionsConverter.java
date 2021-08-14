package io.hari.demo.entity.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.hari.demo.entity.helper.ContestQuestions;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * @Author hayadav
 * @create 4/24/2021
 */
public class ContestQuestionsConverter implements AttributeConverter<ContestQuestions, String > {
    ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(ContestQuestions contestQuestions) {
        if (contestQuestions == null) return "";
        return objectMapper.writeValueAsString(contestQuestions);
    }

    @SneakyThrows
    @Override
    public ContestQuestions convertToEntityAttribute(String s) {
        if (s == null || s.length() == 0) return new ContestQuestions();
        return objectMapper.readValue(s, ContestQuestions.class);
    }
}
