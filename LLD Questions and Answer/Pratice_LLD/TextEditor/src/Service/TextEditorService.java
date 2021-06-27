package Service;

public interface TextEditorService {
    void moveCursorLeft();

    void moveCursorRight();

    //insert the char right before cursor
    void insertCharacter(char ch);

    //delete the char right before cursor
    void backspace();

    void undo();

    void  printCurrentText();

}
