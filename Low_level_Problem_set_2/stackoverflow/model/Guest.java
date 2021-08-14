package stackoverflow.model;

import stackoverflow.dao.StackOverflowDao;

import java.util.List;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Guest {
    public List<Question> searchQuestions(StackOverflowDao stackOverflowDao) {
        return stackOverflowDao.getAllQuestions();
    }

    public Question getQuestion(StackOverflowDao stackOverflowDao, String questionId) {
        return stackOverflowDao.getQuestion(questionId);
    }
}
