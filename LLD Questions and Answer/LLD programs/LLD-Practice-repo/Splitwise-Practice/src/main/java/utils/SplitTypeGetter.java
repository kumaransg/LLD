package utils;

import java.util.List;

public class SplitTypeGetter {
    public static String get(List<String> input){
        /*
            This function abstract out the logic to get the SplitType from the Input.
         */
        return input.get(Integer.parseInt(input.get(3))+4);
    }
}
