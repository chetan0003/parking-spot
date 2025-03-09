package app.manager;

import app.parking.ParkingSpot;
import app.parking.VehicleType;

import java.util.List;

public class ParkingManagerFactory {

    public ParkingManager getParkingManager(String vehicleType, List<ParkingSpot> parkingSpots ) {

        if (VehicleType.FOUR_WHEELER.name().equals(vehicleType)) {
            return new FourWheelerManager(parkingSpots);
        } else if(VehicleType.TWO_WHEELER.name().equals(vehicleType)) {
            return new TwoWheelerManager(parkingSpots);
        }
        return null;
    }
}
