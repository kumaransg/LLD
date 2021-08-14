/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 *//*

package com.pc.multilevelparkinglot;

import ParkingConstants;
import InteractiveRequest;
import Request;
import AbstractService;
import ParkingServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

*/
/**
 * @author paras.chawla
 * @version $Id: ParkingLotRuner.java, v 0.1 2020-11-13 00:36 paras.chawla Exp $$
 *//*


*/
/* Main class running Parking Lot
1. Use switch case for Console and File based processing
2. Get Processor based on ProgramType , InteractiveProcessor or FileProcessor based on programType
3. Show User what command to type create parking lot or park car etc
4. create request out of what user is entering
5. validate request
6. process request
*//*

public class ParkingLotRuner {

    public static void main(String[] args) {

        AbstractService service = new ParkingServiceImpl();

        switch (args.length) {

            case 0:
                printUsage();
                processInteractive(service);
            default:
                System.out.println("Invalid input. Use java -jar <jar_file_path> <input_file_path>");
        }
    }

    private static void processInteractive(AbstractService service) {

        String input;
        System.out.println("Please enter 'exit' to end execution");
        System.out.println("Input your command");

        // continue reading from console and processing the request
        while (true) {

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                input = bufferedReader.readLine().trim();
                Request request = new InteractiveRequest(input);

                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    if (!processor.validate(request)) {
                        System.out.println(ParkingConstants.INVALID_REQUEST);
                    } else { processor.execute(request); }
                }

            } catch (Exception e) {
            }
        }

    }

    private static void printUsage() {
        StringBuffer buffer = new StringBuffer();
        buffer = buffer.append(
                "--------------Please Enter one of the below commands. {variable} to be replaced -----------------------")
                .append("\n");
        buffer = buffer.append("A) For creating parking lot of size n               ---> create_parking_lot {capacity}").append("\n");
        buffer = buffer.append("B) To park a car                                    ---> park <<car_number>> {car_clour}").append("\n");
        buffer = buffer.append("C) Remove(Unpark) car from parking                  ---> leave {slot_number}").append("\n");
        buffer = buffer.append("D) Print status of parking slot                     ---> status").append("\n");
        buffer = buffer.append(
                "E) Get cars registration no for the given car color ---> registration_numbers_for_cars_with_colour {car_color}")
                .append("\n");
        buffer = buffer.append("F) Get slot numbers for the given car color         ---> slot_numbers_for_cars_with_colour {car_color}")
                .append("\n");
        buffer = buffer.append(
                "G) Get slot number for the given car number         ---> slot_number_for_registration_number {car_number}")
                .append("\n");
        System.out.println(buffer.toString());
    }
}*/
