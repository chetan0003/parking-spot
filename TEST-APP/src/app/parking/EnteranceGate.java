package app.parking;

import app.manager.ParkingManager;
import app.manager.ParkingManagerFactory;

public class EnteranceGate {

    private ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();
    private ParkingManager parkingManager;
    private Ticket ticket = new Ticket();


    public ParkingSpot findSpace(String vehicleType) {
        final ParkingSpot parkingSpace = this.parkingManager.findParkingSpace();
        return parkingSpace;
    }


    public Ticket bookSpot(Vehicle vehicle,ParkingSpot parkingSpot) {
        this.parkingManager.ParkVehicle(vehicle,parkingSpot);
        Ticket ticket = this.ticket.generateTicket(vehicle, parkingSpot);
        return ticket;
    }

    public void removeVehicle(String vehicle) {
        this.parkingManager.removeVehicle(vehicle);
    }



    public ParkingManagerFactory getParkingManagerFactory() {
        return parkingManagerFactory;
    }

    public void setParkingManagerFactory(ParkingManagerFactory parkingManagerFactory) {
        this.parkingManagerFactory = parkingManagerFactory;
    }

    public ParkingManager getParkingManager() {
        return parkingManager;
    }

    public void setParkingManager(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
