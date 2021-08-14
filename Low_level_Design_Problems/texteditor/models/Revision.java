/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package texteditor.models;

import texteditor.Action;

/**
 * @author paras.chawla
 * @version $Id: Revision.java, v 0.1 2020-10-27 10:58 paras.chawla Exp $$
 */

// Storing last action performed with characterNode
public class Revision {

    Action        action;
    CharacterNode node;

    public Revision(Action action, CharacterNode node) {
        this.action = action;
        this.node = node;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public CharacterNode getNode() {
        return node;
    }

    public void setNode(CharacterNode node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "action=" + action +
                ", node=" + node +
                '}';
    }
}