package io.hari.demo.service;

import io.hari.demo.dao.QuestionDao;
import io.hari.demo.constant.Level;
import io.hari.demo.entity.Contest;
import io.hari.demo.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public Question createQuestion(String question, Level level, Integer score) {
        final Question newQuestion = Question.builder().question(question).level(level).score(BigInteger.valueOf(score)).build();
        return questionDao.save(newQuestion);
    }

    public List<Question> getAllQuestionLevelWise(final Level questionLevel) {
        final List<Question> allByLevel = questionDao.findAllByLevelQuestions(questionLevel.toString());
        if (allByLevel.size() == 0) return questionDao.findAll();
        return allByLevel;
    }
    public List<Long> getContestQuestions(Contest contest) {
        final int totalContestQuestionCount = contest.getContestQuestions().getQuestions().size();
        final List<Long> randomQuestionIndex = randomQuestionIndex(totalContestQuestionCount);
        List<Long> randomQuestion = new LinkedList<>();
        for (Long index : randomQuestionIndex) {
            final List<Long> questions = contest.getContestQuestions().getQuestions();
            final Long actualQueId = questions.get(Integer.valueOf(String.valueOf(index)));
            randomQuestion.add(actualQueId);
        }
        return randomQuestion;
    }

    public List<Long> randomQuestionIndex(int totalContestQuestionCount) {//20
        final Random random = new Random();
        int userQuestionCount = random.nextInt(totalContestQuestionCount);//3
        while (userQuestionCount == 0) userQuestionCount = random.nextInt(totalContestQuestionCount);
        return findRandomHelper(totalContestQuestionCount, userQuestionCount);
    }

    public List<Long> findRandomHelper(int maxLimitBound, int count) {//20, 3
        final Random random = new Random();
        List<Long> list = new LinkedList<>();
        for (int j = 0; j < count; j++) {
            Long newRandomValue = Long.valueOf(random.nextInt(maxLimitBound));
            while (list.contains(newRandomValue)) { //duplicate check: if already present, find different random values
                newRandomValue = Long.valueOf(random.nextInt(maxLimitBound));
            }
            list.add(newRandomValue);
        }
        return list;
    }
}
