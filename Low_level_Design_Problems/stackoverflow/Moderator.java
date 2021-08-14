package stackoverflow;

public class Moderator extends User{
    public boolean closeQuestion(Question q) {return true;}
    public boolean restoreQuestion(Question q) {return true;}
}
