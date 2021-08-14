/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ridesharing.Exceptions;

/**
 *
 * @author paragkanodia
 */
public class VehicleAlreadyExists extends RuntimeException{

    public VehicleAlreadyExists() {
        super("Vehicle already exists");
    }
    
}
