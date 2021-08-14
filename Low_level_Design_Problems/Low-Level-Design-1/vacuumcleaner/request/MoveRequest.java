/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package vacuumcleaner.request;

import vacuumcleaner.model.Cell;

/**
 * @author paras.chawla
 * @version $Id: MoveRequest.java, v 0.1 2020-08-13 16:05 paras.chawla Exp $$
 */
public class MoveRequest {

    // Current cell
    Cell currCell;

    // Instruction
    char instruction;

    public MoveRequest(Cell currCell, char ch) {
        this.currCell = currCell;
        this.instruction = instruction;
    }

    public Cell getCurrCell() {
        return currCell;
    }

    public char getInstruction() {
        return instruction;
    }
}