package app.manager;

import app.parking.ParkingSpot;
import app.parking.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerManager extends ParkingManager {

    private List<ParkingSpot> parkingSpotList = new ArrayList<>();

    public FourWheelerManager() {

    }

    public FourWheelerManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList);
        this.parkingSpotList = parkingSpotList;
    }


    @Override
    public ParkingSpot findParkingSpace() {
        for (ParkingSpot parkingSpot : this.parkingSpotList) {
            if (parkingSpot.isEmpty()) {
                ParkingSpot parkingSpace;
                parkingSpace = parkingSpot;
                this.parkingSpotList.remove(parkingSpot);
                return parkingSpace;
            }
        }
        return null;
    }

    @Override
    public void addParkingSpace(ParkingSpot parkingSpot) {
        this.parkingSpotList.add(parkingSpot);
    }

    @Override
    public void removeParkingSpace(ParkingSpot parkingSpot) {
        this.parkingSpotList.remove(parkingSpot);
    }

    @Override
    public ParkingSpot ParkVehicle(Vehicle vehicle,ParkingSpot parkingSpot) {
        final ParkingSpot parkingSpot1 = parkingSpot.parkVehicle(vehicle);
        this.parkingSpotList.add(parkingSpot);
        return parkingSpot1;
    }

    @Override
    public void removeVehicle(String vehicle) {
        for (ParkingSpot parkingSpot : this.parkingSpotList) {
            if(parkingSpot.getVehicle() != null && parkingSpot.getVehicle().getVehicleNumber().equals(vehicle)) {
                parkingSpot.setVehicle(null);
                parkingSpot.setEmpty(true);
                break;
            }
        }
    }
}
