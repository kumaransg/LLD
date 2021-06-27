import java.util.HashMap;
import java.util.Map;

/**
 * @author rajesh.c on 09/12/18.
 */
public class DirectionCalculator
{
    public static final Map<String, Direction> bearingToDirection = new HashMap<String, Direction>() {{
        put("N", Direction.STRAIGHT);
        put("NNE", Direction.SLIGHT_RIGHT);
        put("NE", Direction.SLIGHT_RIGHT);
        put("ENE", Direction.RIGHT);
        put("E", Direction.RIGHT);
        put("N", Direction.STRAIGHT);
        put("NNW", Direction.SLIGHT_LEFT);
        put("NW", Direction.SLIGHT_LEFT);
        put("WNW", Direction.LEFT);
        put("W", Direction.LEFT);
        put("WSW", Direction.EXTREME_LEFT);
        put("SW", Direction.EXTREME_LEFT);
        put("SSW", Direction.EXTREME_LEFT);
        put("S", Direction.U_TURN);
        put("ESE", Direction.EXTREME_RIGHT);
        put("SE", Direction.EXTREME_RIGHT);
        put("SSE", Direction.EXTREME_RIGHT);
    }};

    public static String getBearing(double lat1, double lon1, double lat2, double lon2)
    {
        double latitude1 = Math.toRadians(lat1);
        double latitude2 = Math.toRadians(lat2);
        double longDiff = Math.toRadians(lon2 - lon1);
        double y = Math.sin(longDiff) * Math.cos(latitude2);
        double x =
                Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2) * Math.cos(
                        longDiff);

        double resultDegree = (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;

        String[] coordNames = {"N", "NNE", "NE", "ENE", "E",
                "ESE", "SE", "SSE", "S", "SSW", "SW",
                "WSW", "W", "WNW", "NW", "NNW", "N"};

        double directionid = Math.round(resultDegree / 22.5);
        if (directionid < 0)
        {
            directionid = directionid + 16;
        }

        String compasLoc = coordNames[(int) directionid];
        return compasLoc;
    }
}
