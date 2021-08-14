package SystemDesign.SnakeGame2;

import java.util.Random;

public class Game2 {
    FoodInterface foodInterface;
    public static final int DIRECTION_NONE=0,DIRECTION_UP =1, DIRECTION_DOWN=-1, DIRECTION_RIGHT =1, DIRECTION_LEFT =-1;
    private Snake snake;
    private BoardInterface boardInterface;
    private int direction;
    private boolean gameOver;

    public Game2(Snake snake, BoardInterface bi) {
        this.snake = snake;
        this.boardInterface=bi;
        foodInterface=new FoodService();
    }

    public void update(){
        if(gameOver)
            return;
        if(direction==DIRECTION_NONE)
            return;
        
        Cell nextCell = getNextCell(snake.getHead());
        if(snake.checkCrash(nextCell))
        {
            gameOver=true;
            return;
        }
        snake.move(nextCell);
        if(nextCell.getCellType()==CellType.Food){
            snake.grow();
            generateFood();
        }
    }

    private void generateFood() {
        Cell cell = foodInterface.generateFood(boardInterface.getBoard().length, boardInterface.getBoard()[0].length);
        boardInterface.generateFood(cell);
    }

    private Cell getNextCell(Cell head) {
        int row = head.getRow();
        int col = head.getCol();
        if (direction == DIRECTION_RIGHT) {
            col++;
        }
        else if (direction == DIRECTION_LEFT) {
            col--;
        }
        else if (direction == DIRECTION_UP) {
            row++;
        }
        else if (direction == DIRECTION_DOWN) {
            row--;
        }
        while(row>=boardInterface.getBoard().length || col>=boardInterface.getBoard()[0].length || row<0 || col<0) {
            //random();
            //return getNextCell(head);
            if(row>=boardInterface.getBoard().length)
                row=row-1;
            else if(row<0)
                row=row+1;

            if(col>=boardInterface.getBoard()[0].length)
                col=col-1;
            else if(col<0)
                col=col+1;

        }
//        System.out.println(row);
//        System.out.println(col);
        Cell nextCell = boardInterface.getBoard()[row][col];
        return nextCell;
    }


    public static void main(String [] args){
        Snake snake = new Snake(new Cell(0,0));
        BoardInterface bi = new Board(2000,2000);
        Game2 game = new Game2(snake,bi);
        game.gameOver=false;
        game.direction=DIRECTION_RIGHT;

        for(int i=0;i<40000;i++){
            if(i%2==0)
                game.generateFood();
            game.update();
            game.direction = game.random();
            if(game.gameOver)
            {
                System.out.println("~~~~GAME OVER~~~~");
                break;
            }
        }
    }

    private int random() {
        //int r = (int ) (Math.random() * 4);
        Random rand = new Random();
        int r = rand.nextInt(4)+1;
        //System.out.println(r);
        if(r==4)
            return DIRECTION_DOWN;
        else if(r==1)
            return DIRECTION_LEFT;
        else if(r==2)
            return DIRECTION_RIGHT;
        else
            return DIRECTION_UP;
    }
}
