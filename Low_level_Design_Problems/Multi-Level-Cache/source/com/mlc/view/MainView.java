package com.mlc.view;

import com.mlc.services.MultiLevelCache;

import java.util.Scanner;
import java.util.List;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLayers = Integer.parseInt(scanner.nextLine());

        String capacityLine = scanner.nextLine();
        String[] capacities = capacityLine.split(" ");

        String readTimeLine = scanner.nextLine();
        String[] readTimes = readTimeLine.split(" ");

        String writeTimeLine = scanner.nextLine();
        String[] writeTimes = writeTimeLine.split(" ");

        MultiLevelCache mlcache = new MultiLevelCache(numLayers);
        for(int i=0; i<numLayers; i++) {
            //numLayers-i gives first added element the highest priority and so on
            mlcache.addLayer(capacities[i], readTimes[i], writeTimes[i], i+1);
        }

        while(true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch(commandType) {
                case "WRITE":
                    System.out.println("Write Time is: " + mlcache.write(commands[1]));
                    break;
                case "READ":
                    System.out.println("Read Time is: " + mlcache.read(commands[1]));
                    break;
                case "CACHESIZE":
                    System.out.println("Cache Size for Each Layer is: ");
                    List<Integer> cacheSizes = mlcache.getCacheSize();
                    for(int i=0; i<cacheSizes.size(); i++) {
                        System.out.println("Layer " + (i+1) + ": " + cacheSizes.get(i));
                    }
                    break;
            }
        }

    }
}