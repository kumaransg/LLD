package service;

import model.User;

public interface IOnBoardingService {
    public User add_user(String user, String gender, Integer age);
    public void add_vehicle(String user, String vechicle, String vehicleNumber);
}
