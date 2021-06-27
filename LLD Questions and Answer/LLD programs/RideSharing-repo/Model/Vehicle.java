/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Model;

/**
 *
 * @author paragkanodia
 */
public class Vehicle {
    private String userName;
    private String model;
    private String vehicleNumber;

    public Vehicle(String userName, String model, String vehicleNumber) {
        this.userName = userName;
        this.model = model;
        this.vehicleNumber = vehicleNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    
}
