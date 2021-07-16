import java.util.Stack;

public class TextEditor {

    private static final char EMPTY_CHAR = '\0';
    private final ListNode head;
    private final ListNode tail;

    private final Stack<UndoEdit> undoEdits;
    private ListNode cursor;

    static class ListNode {
        char ch;
        ListNode prev;
        ListNode next;

        ListNode() {
            ch = EMPTY_CHAR;

        }

        ListNode(final char ch) {
            this.ch = ch;

        }

        @Override

        public boolean equals(final Object o) {
            final ListNode that = (ListNode) o;
            return ch == that.ch;
        }
    }
    // store undo edits.

    public TextEditor() {
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        undoEdits = new Stack<>();
        cursor = tail;

    }

    public boolean moveCursorLeft() {
        return moveCursorLeft(Undo.SAVE);

    }

    private boolean moveCursorLeft(final Undo undo) {
        if (cursor.prev == head) {
            return false;
        }
        cursor = cursor.prev;
        undo.add(new UndoEdit(UndoEdit.Operation.MOVE_CURSOR_RIGHT), this);
        return true;

    }

    public boolean moveCursorRight() {
        return moveCursorRight(Undo.SAVE);

    }

    private boolean moveCursorRight(final Undo undo) {
        if (cursor.next == null) {
            return false;
        }
        cursor = cursor.next;
        undo.add(new UndoEdit(UndoEdit.Operation.MOVE_CURSOR_LEFT), this);
        return true;
    }

    public boolean insertCharacter(final char ch) {
        return insertCharacter(ch, Undo.SAVE);

    }

    private boolean insertCharacter(final char ch, final Undo undo) {
        final ListNode node = new ListNode(ch);
        node.prev = cursor.prev;
        node.next = cursor;
        cursor.prev.next = node;
        cursor.prev = node;
        undo.add(new UndoEdit(UndoEdit.Operation.BACKSPACE), this);
        return true;

    }

    public boolean backspace() {
        return backspace(Undo.SAVE);
    }

    private boolean backspace(final Undo undo) {
        if (cursor.prev == head) {
            return false;
        }
        final char ch = cursor.prev.ch;
        undo.add(new UndoEdit(UndoEdit.Operation.INSERT_CHARACTER, ch), this);
        final ListNode deleted = cursor.prev;
        deleted.prev.next = cursor;
        cursor.prev = deleted.prev;
        deleted.prev = null;
        deleted.next = null;
        return true;

    }

    public boolean undo() {
        if (!undoEdits.empty()) {
            final UndoEdit edit = undoEdits.pop();
            return edit.apply(this);
        }
        return false;

    }

    private void saveForUndo(final UndoEdit action) {
        undoEdits.add(action);

    }

    // for unit test/debug

    ListNode cursor() {
        return cursor;
    }

    @Override

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        ListNode node = head.next;
        while (node != null) {
            if (node == cursor) {
                builder.append("|");
            }
            if (node != tail) {
                builder.append(node.ch);
            }
            node = node.next;
        }
        return builder.toString();
    }

    enum Undo {
        SAVE {
            @Override
            public void add(final UndoEdit edit, final TextEditor textEditor) {
                textEditor.saveForUndo(edit);
            }
        },
        UNSAVE;

        /**
         * Default implementation for doing nothing
         *
         * @param edit
         * @param textEditor
         */
        public void add(final UndoEdit edit, final TextEditor textEditor) {
            // do nothing
        }

    }

    /**
     * Helper class to encapsulate undo operation and character.
     */

    private static class UndoEdit {

        private final Operation operation;
        private final char ch;

        public UndoEdit(final Operation operation) {
            this.operation = operation;
            this.ch = EMPTY_CHAR;
        }

        public UndoEdit(final Operation operation, final char ch) {
            this.operation = operation;
            this.ch = ch;
        }

        public boolean apply(final TextEditor editor) {
            return operation.apply(ch, editor);
        }

        @Override

        public String toString() {
            return operation.toString() + " " + ch;
        }

        enum Operation {
            MOVE_CURSOR_LEFT {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.moveCursorLeft(Undo.UNSAVE);
                }
            },

            MOVE_CURSOR_RIGHT {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.moveCursorRight(Undo.UNSAVE);
                }
            },

            INSERT_CHARACTER {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.insertCharacter(ch, Undo.UNSAVE);
                }
            },

            BACKSPACE {
                @Override
                public boolean apply(final char ch, final TextEditor editor) {
                    return editor.backspace(Undo.UNSAVE);
                }
            };

            public abstract boolean apply(char ch, TextEditor editor);
        }
    }
}
