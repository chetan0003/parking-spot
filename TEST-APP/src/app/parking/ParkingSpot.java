package app.parking;

import java.util.Random;

public class ParkingSpot {

    private Long id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private int price = 10;

    public ParkingSpot(Long id) {
        this.id = id;
        isEmpty = true;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isEmpty = false;
        return this;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        isEmpty = true;
        return true;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
