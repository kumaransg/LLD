/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package texteditor.main;

import texteditor.impl.SimpleTextEditor;

/**
 * @author paras.chawla
 * @version $Id: Main.java, v 0.1 2020-10-27 12:54 paras.chawla Exp $$
 */
public class Main {

    public static void main(String[] args) {
        SimpleTextEditor editor = new SimpleTextEditor();

        editor.insert('a'); editor.print();
        editor.insert('b'); editor.print();
        editor.insert('c'); editor.print();

        editor.moveLeft(); editor.print();
        editor.moveLeft(); editor.print();
        editor.moveLeft(); editor.print();

        editor.moveRight(); editor.print();
        editor.moveRight(); editor.print();
        editor.moveRight(); editor.print();

        editor.backspace(); editor.print();
        editor.moveLeft(); editor.print();

        editor.undo(); editor.print();
        editor.undo(); editor.print();
        editor.undo(); editor.print();
        editor.undo(); editor.print();
        editor.undo(); editor.print();
    }

}