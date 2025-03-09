package app.parking;

public class Ticket {

    private Long entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public Ticket() {

    }
    public Ticket(Long entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = System.currentTimeMillis();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        final String vihicleType = vehicle.getVehicleType().name();
        System.out.println("========================Ticket=========================");
        System.out.println("=                                                     =");
        System.out.println("=      Vehicl Type: = "+vihicleType+"                     =");
        System.out.println("=      Vehicl Number: = "+vehicle.getVehicleNumber()+"                   =");
        System.out.println("=      Booking Spot Number: = "+parkingSpot.getId()+"                     =");
        System.out.println("=      Price: = "+parkingSpot.getPrice()+      "                                    =");
        System.out.println("=                                                     =");
        System.out.println("=======================================================");
        return this;
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
