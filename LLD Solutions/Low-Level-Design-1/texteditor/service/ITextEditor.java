/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package texteditor.service;

import texteditor.models.CharacterNode;

/**
 * @author paras.chawla
 * @version $Id: ITextEditor.java, v 0.1 2020-10-27 10:56 paras.chawla Exp $$
 */
public interface ITextEditor {
    void moveLeft();

    void moveRight();

    void backspace();

    void insert(char data);

    void undo();

    String print();

    CharacterNode getCursor();
}