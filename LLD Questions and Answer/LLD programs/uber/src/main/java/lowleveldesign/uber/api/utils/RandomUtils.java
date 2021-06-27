package lowleveldesign.uber.api.utils;

public class RandomUtils {

    public static String getRandom6Length() {
        int random6Digit = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(random6Digit);
    }

}
