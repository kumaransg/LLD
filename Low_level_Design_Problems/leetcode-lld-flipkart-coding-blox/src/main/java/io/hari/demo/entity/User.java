package io.hari.demo.entity;

import io.hari.demo.entity.converter.UserContestQuestionsConverter;
import io.hari.demo.entity.helper.UserContestQuestions;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

/**
 * @Author hayadav
 * @create 4/24/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(unique = true)
    String username;

    BigInteger score;

    @Builder.Default
    @Convert(converter = UserContestQuestionsConverter.class)
    UserContestQuestions userContestQuestions = new UserContestQuestions();
}
