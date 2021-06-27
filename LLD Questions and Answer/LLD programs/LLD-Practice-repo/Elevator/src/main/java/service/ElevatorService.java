package service;

import model.Direction;
import model.Elevator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElevatorService implements IElevatorService{
    private static Logger logger= LoggerFactory.getLogger(ElevatorService.class);
    private Elevator elevator;

    @Override
    public void toggleFan() {
        Boolean currentFanState= elevator.getIsFanOn();

        if(currentFanState) logger.info("Turning OFF Fan "+elevator.getId() );
        else logger.info("Turning ON Fan "+elevator.getId());

        elevator.setIsFanOn(!currentFanState);
    }

    @Override
    public void toggleLights() {
        Boolean currentLightState= elevator.getIsLightsOn();

        if(currentLightState) logger.info("Turning OFF Lights "+elevator.getId());
        else logger.info("Turning ON Lights "+elevator.getId());

        elevator.setIsFanOn(!currentLightState);
    }

    @Override
    public void toggleAlarm() {
        Boolean currentAlarmState= elevator.getIsAlarmOn();

        if(currentAlarmState) logger.info("Turning OFF Alarm "+elevator.getId());
        else logger.info("Turning ON Alarm "+elevator.getId());

        elevator.setIsFanOn(!currentAlarmState);
    }

    @Override
    public void goToFloor(Integer floor) {
        logger.info("Adding floor :",floor,"in ",elevator.getId());

        elevator.getState().addFloor(floor);
    }

    @Override
    public void stopImmediately() {
        logger.info("Stopping elevator immediately "+elevator.getId());
        elevator.getState().setDirection(Direction.STOP);
    }
}
