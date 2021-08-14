package SystemDesign.SnakeGame2;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;

    public Snake(Cell initPos)
    {
        head = initPos;
        snakePartList.add(head);
    }

    public void grow()
    {
        snakePartList.add(head);
    }

    public void move(Cell nextCell)
    {
        System.out.println("Snake is moving to " +
                nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);

        head = nextCell;
        snakePartList.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell)
    {
        System.out.println("Going to check for Crash");
        for (Cell cell : snakePartList) {
            if (cell == nextCell) {
                return true;
            }
        }

        return false;
    }

    public LinkedList<Cell> getSnakePartList()
    {
        return snakePartList;
    }

    public void setSnakePartList(LinkedList<Cell> snakePartList)
    {
        this.snakePartList = snakePartList;
    }

    public Cell getHead()
    {
        return head;
    }

    public void setHead(Cell head)
    {
        this.head = head;
    }
}
