package app.manager;

import app.parking.ParkingSpot;
import app.parking.Vehicle;

import java.util.List;

public abstract class ParkingManager {

    private List<ParkingSpot> parkingSpotList;

    public ParkingManager() {

    }
    public ParkingManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public abstract ParkingSpot findParkingSpace();

    public abstract void addParkingSpace(ParkingSpot parkingSpot);

    public abstract void removeParkingSpace(ParkingSpot parkingSpot);

    public abstract ParkingSpot ParkVehicle(Vehicle vehicle,ParkingSpot parkingSpot);

    public abstract void removeVehicle(String vehicle);

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
}
