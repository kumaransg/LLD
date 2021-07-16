/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package texteditor.impl;

import texteditor.Action;
import texteditor.models.CharacterNode;
import texteditor.models.Revision;
import texteditor.service.ITextEditor;

import java.util.Stack;

/**
 * @author paras.chawla
 * @version $Id: SimpleTextEditor.java, v 0.1 2020-10-27 11:01 paras.chawla Exp $$
 * Using Doubly Linked List
 * Approach 1 - https://www.careercup.com/question?id=5726975948226560
 * Using StringBuilder
 * Approach 2 - https://massivetechinterview.blogspot.com/2019/04/design-text-editor.html
 */
public class SimpleTextEditor implements ITextEditor {

    // start pointer to keep track of full text and cursor pointer to keep track of current position
    CharacterNode start, cursor;
    Stack<Revision> undoStack;
    int             numChar = 0;

    public SimpleTextEditor() {
        this.cursor = new CharacterNode('\0');
        this.undoStack = new Stack<>();
        this.start = null;
    }

    @Override
    public void moveLeft() {
        if (cursor.getPrev() == null) { return; }
        cursor = cursor.getPrev();

        // Move cursor to RIGHT in case of undo
        undoStack.add(new Revision(Action.RIGHT, null));
    }

    @Override
    public void moveRight() {
        if (cursor.getNext() == null) { return; }
        cursor = cursor.getNext();

        // Move cursor to LEFT in case of undo
        undoStack.add(new Revision(Action.LEFT, null));
    }

    @Override
    public void backspace() {
        // no char to delete
        if (cursor.getPrev() == null) { return; }

        numChar--;
        CharacterNode chDeleted = delete(cursor.getPrev());

        // Insert Deleted character in case of undo
        undoStack.add(new Revision(Action.INSERT, chDeleted));

        if (numChar == 0) {
            start = null;
        }
    }

    private CharacterNode delete(CharacterNode toDelete) {
        CharacterNode prev = toDelete.getPrev();
        CharacterNode next = toDelete.getNext();

        if (prev != null) {
            prev.setNext(next);
        }

        if (next != null) { next.setPrev(prev); }

        if (toDelete.getPrev() == null && numChar == 0) { start = null; }

        if (toDelete == start) { start = next; }

        if (cursor.getPrev() == null && numChar == 0) { start = null; }

        return toDelete;
    }

    @Override
    public void insert(char data) {
        CharacterNode newNode = new CharacterNode(data);
        CharacterNode prev = cursor.getPrev();

        newNode.setNext(cursor);
        cursor.setPrev(newNode);

        if (prev != null) {
            prev.setNext(newNode);
            newNode.setPrev(prev);
        } else {
            start = newNode;
        }

        numChar++;

        // delete new added node in case of Undo
        undoStack.add(new Revision(Action.DELETE, newNode));
    }

    @Override
    public void undo() {
        if (undoStack.isEmpty()) { return; }

        Revision revision = undoStack.pop();
        Action undoAction = revision.getAction();

        switch (undoAction) {
            case LEFT:
                if (cursor != null && cursor.getPrev() != null) {
                    cursor = cursor.getPrev();
                }
                break;
            case RIGHT:
                if (cursor != null && cursor.getNext() != null) {
                    cursor = cursor.getNext();
                }
                break;
            case INSERT:
                insert(revision.getNode().getCh());
                break;
            case DELETE:
                if (cursor != null) {
                    if (cursor.getPrev() == null) {
                        start = null;
                    }
                    delete(cursor.getPrev());
                }
                break;
            default:
                return;
        }
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        CharacterNode temp = start;
        while (temp != null) {

            if (temp == cursor) { builder.append('|'); }
            if (temp.getCh() != '\0') { builder.append(temp.getCh()); }
            temp = temp.getNext();
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    @Override
    public CharacterNode getCursor() {
        return getCursor();
    }
}