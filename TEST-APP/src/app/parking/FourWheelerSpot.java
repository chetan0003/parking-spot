package app.parking;

public class FourWheelerSpot extends ParkingSpot {


    public FourWheelerSpot(Long id) {
        super(id);
    }

    @Override
    public int getPrice() {
        return 20;
    }
}
