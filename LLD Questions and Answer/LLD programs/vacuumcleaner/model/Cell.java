/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package vacuumcleaner.model;

import vacuumcleaner.enums.DirectionEnum;

/**
 * @author paras.chawla
 * @version $Id: Cell.java, v 0.1 2020-08-13 09:10 paras.chawla Exp $$
 */
public class Cell {

    // x cordinate
    int x;

    // y cordinate
    int y;

    // direction at (x,y)
    DirectionEnum direction;

    public Cell(){}

    public Cell(int x, int y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}