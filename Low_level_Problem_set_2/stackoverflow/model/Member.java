package stackoverflow.model;

import stackoverflow.dao.StackOverflowDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Member extends Guest {
    private final Account account;
    private final List<Badge> badgeList;

    public Member(Account account) {
        this.account = account;
        this.badgeList = new ArrayList<>();
    }

    public void addBadge(Badge badge) {
        this.badgeList.add(badge);
    }

    public List<Badge> getBadgeList() {
        return badgeList;
    }

    public void addQuestion(StackOverflowDao stackOverflowDao, Question question) {
        stackOverflowDao.addQuestion(question);
    }

    public void addAnswer(StackOverflowDao stackOverflowDao, String questionId, Answer answer) {
        stackOverflowDao.addAnswer(questionId, answer);
    }

    public void addCommentToQuestion(StackOverflowDao stackOverflowDao, String questionId, Comment comment) {
        stackOverflowDao.addCommentToQuestion(questionId, comment);
    }

    public void addCommentToAnswer(StackOverflowDao stackOverflowDao, String answerId, Comment comment) {
        stackOverflowDao.addCommentToAnswer(answerId, comment);
    }

    public void addTagToQuestion(StackOverflowDao stackOverflowDao, String questionId, Tag tag) {
        stackOverflowDao.addTagToQuestion(questionId, tag);
    }

    public void vote(Entity entity) {

    }

    public void flag(Entity entity) {

    }

    @Override
    public String toString() {
        return "Member{" +
                "account=" + account +
                ", badgeList=" + badgeList +
                '}';
    }
}

