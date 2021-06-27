package SystemDesign.SnakeGame2;

public class Cell {
    private int row;
    private int col;
    private CellType cellType;

    public Cell(int row, int col, CellType cellType) {
        this.row = row;
        this.col = col;
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
