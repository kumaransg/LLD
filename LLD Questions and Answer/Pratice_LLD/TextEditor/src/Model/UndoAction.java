package Model;

import App.TextEditor;

public class UndoAction {
    CharacterNode node;
     Operation operation;

    public UndoAction(CharacterNode node, Operation operation) {
        this.node = node;
        this.operation = operation;
    }

    public void applyUndo(TextEditor editor) {
        operation.apply(editor,node);
    }

    public enum Operation {
        UNDO_LEFT {
            @Override
            void apply(TextEditor editor, CharacterNode node) {
                editor.moveCursorRightHelper(UndoSave.UNDO_UNSAVE);
            }
        }, UNDO_RIGHT {
            @Override
            void apply(TextEditor editor, CharacterNode node) {
                editor.moveCursorLeftHelper(UndoSave.UNDO_UNSAVE);
            }
        }, UNDO_INSERT {
            @Override
            void apply(TextEditor editor, CharacterNode node) {
                editor.backspaceHelper(UndoSave.UNDO_UNSAVE);
            }
        }, UNDO_DELETE {
            @Override
            void apply(TextEditor editor, CharacterNode node) {
                editor.insertCharacterHelper(node.getCh(), UndoSave.UNDO_UNSAVE);
            }
        };

        public enum UndoSave {
            UNDO_SAVE,
            UNDO_UNSAVE;
        }

        abstract void apply(TextEditor editor, CharacterNode node);
    }
}
