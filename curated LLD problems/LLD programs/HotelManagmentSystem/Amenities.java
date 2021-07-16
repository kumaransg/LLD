package HotelManagmentSystem;

// Applying chain of responsibility pattern
public interface Amenities {

    public void setNextChain(Amenities nextAmenity);

    public void levyCharge(String amenityName);
}
