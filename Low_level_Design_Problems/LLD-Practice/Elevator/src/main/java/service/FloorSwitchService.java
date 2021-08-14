package service;

import model.FloorSwitch;
import model.SwitchDirection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloorSwitchService implements IFloorSwitchService{
    private FloorSwitch floorSwitch;
    private ElevatorManager elevatorManager;
    Logger logger= LoggerFactory.getLogger(FloorSwitchService.class);

    public void setFloorSwitch(FloorSwitch floorSwitch) {
        this.floorSwitch = floorSwitch;
    }

    @Override
    public void pressSwitch(SwitchDirection switchDirection) {
        logger.info("pressSwitch called: ", switchDirection, floorSwitch);
        switch (switchDirection){
            case UP:
                if(floorSwitch.getState()[0]==true) return;
                floorSwitch.getState()[0]=true;
                elevatorManager.callElevator(floorSwitch.getCurrentFloor(), 0);
                break;

            case DOWN:
                if(floorSwitch.getState()[1]==true) return;
                floorSwitch.getState()[1]=true;
                elevatorManager.callElevator(floorSwitch.getCurrentFloor(), 1);
                break;
        }
    }
}
