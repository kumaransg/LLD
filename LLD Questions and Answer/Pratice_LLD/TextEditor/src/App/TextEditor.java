package App;

import Model.CharacterNode;
import Model.UndoAction;
import Service.TextEditorService;

import java.util.Stack;

public class TextEditor implements TextEditorService {
    CharacterNode cursor;
    CharacterNode head;
    CharacterNode tail;
    Stack<UndoAction> undoActionStack;

    public TextEditor() {
        this.cursor = new CharacterNode('|');
        this.head = new CharacterNode('$');
        this.tail = new CharacterNode('$');
        this.head.setNext(cursor);
        this.cursor.setPrev(this.head);
        this.cursor.setNext(this.tail);
        this.tail.setPrev(this.cursor);
        this.undoActionStack = new Stack<>();
    }

    @Override
    public void moveCursorLeft() {
        moveCursorLeftHelper(UndoAction.Operation.UndoSave.UNDO_SAVE);
    }

    public void moveCursorLeftHelper(UndoAction.Operation.UndoSave save) {
        if (this.cursor.getPrev() == this.head) {
            return;
        }

        CharacterNode prev = cursor.getPrev();
        CharacterNode next = cursor.getNext();

        cursor.setPrev(prev.getPrev());
        cursor.setNext(prev);

        prev.setNext(next);
        next.setPrev(prev);
        prev.getPrev().setNext(cursor);
        if (save == UndoAction.Operation.UndoSave.UNDO_SAVE)
            undoActionStack.push(new UndoAction(cursor, UndoAction.Operation.UNDO_LEFT));
    }

    @Override
    public void moveCursorRight() {
        moveCursorRightHelper(UndoAction.Operation.UndoSave.UNDO_SAVE);
    }

    public void moveCursorRightHelper(UndoAction.Operation.UndoSave save) {
        if (this.cursor.getNext() == this.tail) {
            return;
        }
        CharacterNode prev = cursor.getPrev();
        CharacterNode next = cursor.getNext();

        cursor.setPrev(next);
        cursor.setNext(next.getNext());
        next.setNext(cursor);
        prev.setNext(next);
        next.setPrev(prev);
        if (save == UndoAction.Operation.UndoSave.UNDO_SAVE)
            undoActionStack.push(new UndoAction(next, UndoAction.Operation.UNDO_RIGHT));
    }

    @Override
    public void insertCharacter(char ch) {
        insertCharacterHelper(ch, UndoAction.Operation.UndoSave.UNDO_SAVE);
    }

    public void insertCharacterHelper(char ch, UndoAction.Operation.UndoSave save) {
        CharacterNode current = new CharacterNode(ch);
        CharacterNode prev = cursor.getPrev();
        current.setPrev(prev);
        current.setNext(cursor);
        prev.setNext(current);
        cursor.setPrev(current);
        if (save == UndoAction.Operation.UndoSave.UNDO_SAVE)
            undoActionStack.push(new UndoAction(current, UndoAction.Operation.UNDO_INSERT));
    }

    @Override
    public void backspace() {
        backspaceHelper(UndoAction.Operation.UndoSave.UNDO_SAVE);
    }

    public void backspaceHelper(UndoAction.Operation.UndoSave save) {
        CharacterNode prev = cursor.getPrev();
        CharacterNode delete = new CharacterNode(prev.getCh());
        if (prev == this.head) {
            return;
        }
        cursor.setPrev(prev.getPrev());
        prev.getPrev().setNext(cursor);
        if (save == UndoAction.Operation.UndoSave.UNDO_SAVE)
            undoActionStack.push(new UndoAction(delete, UndoAction.Operation.UNDO_DELETE));
    }

    @Override
    public void undo() {
        if (undoActionStack.isEmpty()) {
            return;
        }
        UndoAction action = undoActionStack.pop();
        action.applyUndo(this);
    }

    public void printCurrentText() {
        CharacterNode current = this.head.getNext();
        while (current.getNext() != null) {
            System.out.print(current.getCh() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
