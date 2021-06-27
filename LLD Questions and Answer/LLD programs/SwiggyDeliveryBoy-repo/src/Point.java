/**
 * @author rajesh.c on 07/12/18.
 */
public class Point
{
    private double latitude;
    private double longitude;

    public Point(final double latitude, final double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(final double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(final double longitude)
    {
        this.longitude = longitude;
    }
}
