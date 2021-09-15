package io.hari.demo.entity.helper;

import lombok.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author hayadav
 * @create 4/24/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ContestQuestions {
    List<Long> questions = new LinkedList<>();
}
