package stackoverflow.dao;

import stackoverflow.model.Answer;
import stackoverflow.model.Comment;
import stackoverflow.model.Question;
import stackoverflow.model.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class StackOverflowDao {
    private final Map<String, Question> questionIdToQuestionMap;
    private final Map<String, Answer> answerIdToAnswerMap;
    private final Map<String, Comment> commentIdToCommentMap;

    public StackOverflowDao() {
        this.questionIdToQuestionMap = new HashMap<>();
        this.answerIdToAnswerMap = new HashMap<>();
        this.commentIdToCommentMap = new HashMap<>();
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(this.questionIdToQuestionMap.values());
    }

    public Question getQuestion(String questionId) {
        return this.questionIdToQuestionMap.get(questionId);
    }

    public void addQuestion(Question question) {
        this.questionIdToQuestionMap.put(question.getEntityId(), question);
    }

    public void addAnswer(String questionId, Answer answer) {
        Question question = questionIdToQuestionMap.get(questionId);
        if (question != null) {
            question.addAnswer(answer);
        }
        answerIdToAnswerMap.put(answer.getEntityId(), answer);
    }

    public void addCommentToQuestion(String questionId, Comment comment) {
        Question question = questionIdToQuestionMap.get(questionId);
        if (question != null) {
            question.addComment(comment);
        }
        commentIdToCommentMap.put(comment.getEntityId(), comment);
    }

    public void addCommentToAnswer(String answerId, Comment comment) {
        Answer answer = answerIdToAnswerMap.get(answerId);
        if (answer != null) {
            answer.addComment(comment);
        }
        commentIdToCommentMap.put(comment.getEntityId(), comment);
    }

    public void addTagToQuestion(String questionId, Tag tag) {
        getQuestion(questionId).addTag(tag);
    }

}
