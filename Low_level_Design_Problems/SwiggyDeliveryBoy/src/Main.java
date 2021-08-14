import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        double speed = 10;
        String csvFile = "directions.txt";
        String cvsSplitBy = ",";

        List<Point> gpsPoints = getGpsPoints(csvFile, cvsSplitBy);
        int time = 0;

        for (int i = 0; i < gpsPoints.size() - 1; i++)
        {
            Point currentPoint = gpsPoints.get(i);
            Point nextPoint = gpsPoints.get(i + 1);
            double distance = DistanceCalculator.getDistance(currentPoint.getLatitude(),
                                                             currentPoint.getLongitude(),
                                                             nextPoint.getLatitude(),
                                                             nextPoint.getLongitude(),
                                                             'K');
            String bearing = DirectionCalculator.getBearing(currentPoint.getLatitude(),
                                                            currentPoint.getLongitude(),
                                                            nextPoint.getLatitude(),
                                                            nextPoint.getLongitude());

            Direction direction = DirectionCalculator.bearingToDirection.get(bearing);

            if (i == 0)
            {
                System.out.println("Time = " + time + " Start");
            }

            if (direction != Direction.STRAIGHT && i != 0)
            {
                System.out.println("Time = " + time + " Take " + direction.name());
            }

            System.out.println("Time = " + time + " Go straight for " + distance + " kms");
            time += distance / speed;
        }
    }

    private static List<Point> getGpsPoints(final String csvFile, final String cvsSplitBy)
    {
        List<Point> gpsPoints = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
        {
            while ((line = br.readLine()) != null)
            {
                String[] pointInformation = line.split(cvsSplitBy);
                gpsPoints.add(new Point(Double.parseDouble(pointInformation[0]),
                                        Double.parseDouble(pointInformation[1])));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return gpsPoints;
    }
}
