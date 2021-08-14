package stackoverflow.model;

/**
 * @author priyamvora
 * @created 24/04/2021
 */
public class Moderator extends Account {
    public Moderator(String name, String email) {
        super(name, email);
    }

    public void closeQuestion(String questionId) {

    }

    public void deleteQuestion(String questionId) {

    }
}
