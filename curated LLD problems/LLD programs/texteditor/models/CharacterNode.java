/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package texteditor.models;

/**
 * @author paras.chawla
 * @version $Id: CharacterNode.java, v 0.1 2020-10-27 10:52 paras.chawla Exp $$
 */

// Doubly linked list used as text editor data structure
public class CharacterNode {

    char          ch;
    CharacterNode prev;
    CharacterNode next;

    public CharacterNode(char ch) {
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
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

    @Override
    public String toString() {
        return ch+ "";
    }
}