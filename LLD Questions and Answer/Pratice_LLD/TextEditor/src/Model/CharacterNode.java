package Model;
// DLL
public class CharacterNode {
    CharacterNode prev;
    CharacterNode next;
    char ch;

    public CharacterNode() {
        this.prev = null;
        this.next = null;
    }

    public CharacterNode(char ch) {
        super();
        this.ch = ch;
    }

    public CharacterNode getPrev() {
        return prev;
    }

    public void setPrev(CharacterNode prev) {
        this.prev = prev;
    }

    public CharacterNode getNext() {
        return next;
    }

    public void setNext(CharacterNode next) {
        this.next = next;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }
}
