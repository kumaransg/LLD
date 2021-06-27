package App;/*
( '|' denotes where the cursor locates. 'text' shows what's been written to the text editor. )

Start with empty text
text = "|"

insertCharacter('a')
text = "a|"

insertCharacter('b')
text = "ab|"

insertCharacter('c')
text = "abc|"

moveCursorLeft()
text = "ab|c"

moveCursorLeft()
text = "a|bc"

backspace()
text = "|bc"

moveCursorLeft()
text = "|bc" (nothing happens since cursor was on the leftmost position)

undo()
text = "a|bc"

undo()
text = "ab|c"

undo()
text = "abc|"

undo()
text = "ab|"

undo()
text = "a|"
 */

import App.TextEditor;
import Service.TextEditorService;

public class TextEditorApplication {
    public static void main(String[] args) {
        TextEditorService textEditor = new TextEditor();

        textEditor.insertCharacter('a');
        textEditor.insertCharacter('e');
        textEditor.insertCharacter('c');
        textEditor.printCurrentText();
        textEditor.moveCursorLeft();
        textEditor.printCurrentText();
        textEditor.moveCursorRight();
        textEditor.printCurrentText();
        textEditor.backspace();
        textEditor.backspace();
        textEditor.printCurrentText();
        textEditor.undo();
        textEditor.printCurrentText();
        textEditor.undo();
        textEditor.printCurrentText();

        textEditor.undo();
        textEditor.printCurrentText();
        textEditor.undo();
        textEditor.printCurrentText();
    }
}
