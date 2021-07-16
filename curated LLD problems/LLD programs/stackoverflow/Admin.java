package stackoverflow;

public class Admin extends User{
    public boolean blockMember(Member m) {return false;}
    public boolean unblockMember(Member m) {return false;}
}
