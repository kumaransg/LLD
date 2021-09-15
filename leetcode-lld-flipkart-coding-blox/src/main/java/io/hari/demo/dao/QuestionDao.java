package io.hari.demo.dao;

import io.hari.demo.entity.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends BaseDao<Question>{
    @Query(value = "select * from questions where level = :level", nativeQuery = true)
    List<Question> findAllByLevelQuestions(String level);
}
