package io.hari.demo.entity.helper;

import lombok.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author hayadav
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserContestQuestions {
    Map<Long, List<Long>> contestQuestionsMap = new HashMap<>();
}
