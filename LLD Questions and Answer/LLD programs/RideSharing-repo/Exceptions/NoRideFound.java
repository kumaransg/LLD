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
public class NoRideFound extends RuntimeException{

    public NoRideFound() {
        super("No Ride Found");
    }
    
    
}
