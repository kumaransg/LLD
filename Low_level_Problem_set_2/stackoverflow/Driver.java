package stackoverflow;

import stackoverflow.dao.StackOverflowDao;
import stackoverflow.model.*;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Driver {
    public static void main(String[] args) {
        StackOverflowDao stackOverflowDao = new StackOverflowDao();
        Guest guest = new Guest();
        Account account = new Account("Priyam", "priyam@hike.in");
        Member member = new Member(account);

        Account account2 = new Account("Priyam2", "priyam2@hike.in");
        Member member2 = new Member(account2);

        Question question = new Question("Hi how are you?", member);
        member.addQuestion(stackOverflowDao, question);
        getAllQuestions(guest, stackOverflowDao);

        Comment comment = new Comment("Comment on question", member2);
        member2.addCommentToQuestion(stackOverflowDao, question.getEntityId(), comment);
        getAllQuestions(guest, stackOverflowDao);

        Answer answer = new Answer("Answer", member2);
        member2.addAnswer(stackOverflowDao, question.getEntityId(), answer);
        getAllQuestions(guest, stackOverflowDao);

        Comment comment1 = new Comment("Comment on answer", member2);
        member2.addCommentToAnswer(stackOverflowDao, answer.getEntityId(), comment1);
        getAllQuestions(guest, stackOverflowDao);

    }

    private static void getAllQuestions(Guest guest, StackOverflowDao stackOverflowDao) {
        System.out.println(guest.searchQuestions(stackOverflowDao));
    }
}
