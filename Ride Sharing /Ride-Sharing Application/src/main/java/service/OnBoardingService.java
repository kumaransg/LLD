package service;

import dao.IUserDAO;
import dao.IVehicleDAO;
import model.User;
import model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

public class OnBoardingService implements IOnBoardingService{
    IUserDAO userDAO;
    IVehicleDAO vehicleDAO;

    @Autowired
    public OnBoardingService(IUserDAO userDAO, IVehicleDAO vehicleDAO) {
        this.userDAO = userDAO;
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public User add_user(String user, String gender, Integer age) {
        return userDAO.addUser(user,gender,age);
    }

    @Override
    public void add_vehicle(String user, String vehicle, String vechicleNumber) {
        User currUser= userDAO.getUser(user);
        Vehicle currVehicle= vehicleDAO.addVehicle(vehicle,vechicleNumber);

        currUser.addVechicle(currVehicle);
    }
}
