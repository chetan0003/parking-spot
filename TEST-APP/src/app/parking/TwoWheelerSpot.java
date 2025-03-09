package app.parking;

public class TwoWheelerSpot extends ParkingSpot {

    public TwoWheelerSpot(Long id) {
        super(id);
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
