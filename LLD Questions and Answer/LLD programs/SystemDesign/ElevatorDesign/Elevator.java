package SystemDesign.ElevatorDesign;

public class Elevator {
    public enum DIRECTION {
        NONE, UP, DOWN
    }
    private DIRECTION direction = DIRECTION.NONE;
    private Boolean move = false;

    private boolean [] floors;
    private int countUp = 0;
    private int countDown = 0;
    private int cf = 0;
    private int min = Constants.MIN_FLOOR;
    private int max = Constants.MAX_FLOOR;
    private int numFloors;

    private ElevatorEventListener elEventListener;

    public Elevator(int numFloors) {
        if(numFloors<0)  throw new IllegalArgumentException();
        this.numFloors = numFloors;
        floors = new boolean [numFloors];
    }


    public Integer getCurrentFloor() {
        return cf;
    }

    public int getGoalFloor() {
        if(direction == DIRECTION.UP ) return max;
        if(direction == DIRECTION.DOWN ) return min;
        return -1;
    }

    public void moveNext(){
        if(!move) {
            move = (direction != DIRECTION.NONE);
            return;
        }
        if(direction == DIRECTION.UP) {
            if(floors[++cf]) {
                floors[cf] = false;
                if(--countUp == 0) {
                    direction = (countDown == 0)?(DIRECTION.NONE):(DIRECTION.DOWN);
                    max = Constants.MAX_FLOOR;
                }
                move = false;
                if(elEventListener != null) elEventListener.onStopped(this);
            }
            return;
        }
        if (direction == DIRECTION.DOWN) {
            if(floors[--cf]) {
                floors[cf] = false;
                if(++countDown == 0) {
                    direction = (countUp == 0)?(DIRECTION.NONE):(DIRECTION.UP);
                    min = Constants.MIN_FLOOR;
                }
                move = false;
                if(elEventListener != null) elEventListener.onStopped(this);
            }
        }
    }

    public void setGoalFloor(int gf) {
        if((gf<0) || (gf >= numFloors ) ) throw new IllegalArgumentException();
        if(cf == gf) return;
        if(floors[gf]) return;
        floors[gf] = true;
        if(gf>cf) { countUp++;  	max = (gf>max)?(gf):(max); }
        if(gf<cf) { countDown--; 	min = (gf<min)?(gf):(min); }
        if(direction == DIRECTION.NONE)
            direction = (gf>cf)?(DIRECTION.UP):(DIRECTION.DOWN);
    }

    public void reset() {
        cf = countUp = countDown = 0;
        move = false;
        direction = DIRECTION.NONE;
        floors = new boolean [numFloors];
        max = Constants.MAX_FLOOR; min = Constants.MIN_FLOOR;
    }

    public void moveToFloor(int floor) {
        if((floor<0) || (floor >= numFloors ) ) throw new IllegalArgumentException();
        reset();
        cf = floor;
    }

    public boolean getMove() {
        return move;
    }
    public DIRECTION getDirection() {
        return direction;
    }

    public void setElEventListener(ElevatorEventListener elEventListener) {
        this.elEventListener = elEventListener;
    }
}
