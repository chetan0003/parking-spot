package app;

import app.manager.ParkingManager;
import app.parking.*;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingSpotClient {
    static Map<String, List<ParkingSpot>> parkingSpotMap = new LinkedHashMap<>();

    static {
        parkingSpotMap.put(VehicleType.TWO_WHEELER.name(), addParkingSpotForTwoWheeler());
        parkingSpotMap.put(VehicleType.FOUR_WHEELER.name(), addParkingSpotForFourWheeler());
    }

    public static void main(String[] args) {
        printBanner();
        Scanner scanner = new Scanner(System.in);

        final int vehicleChoice = scanner.nextInt();
        final String vehicleType = vehicleChoice == 1 ? VehicleType.TWO_WHEELER.name() : VehicleType.FOUR_WHEELER.name();

        //Add parking spot
        final List<ParkingSpot> parkingSpots = parkingSpotMap.get(vehicleType);
        //Enterance Gate
        EnteranceGate enteranceGate = new EnteranceGate();
        final ParkingManager twoParkingManager = enteranceGate.getParkingManagerFactory().getParkingManager(VehicleType.TWO_WHEELER.name(), parkingSpots);
        enteranceGate.setParkingManager(twoParkingManager);
        choices();
        String chices = "";
        Vehicle vehicle = null;
        ParkingSpot parkingSpotSpace = null;
        while (true) {
            System.out.println(chices);
            final int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    parkingSpotSpace = findParkingSpot(enteranceGate);
                    if (parkingSpotSpace == null) {
                        throw new RuntimeException("No Parking Spot Available");
                    }
                    chices = "For Book Spot Type 2";
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    if (parkingSpotSpace != null) {
                        System.out.println("        Enter Vehicle Number to book spot   \n");
                        final String numberPlate = scanner2.nextLine();
                        vehicle = getVehicle(numberPlate, vehicleType);
                        bookSpot(enteranceGate, vehicle, parkingSpotSpace);
                        System.out.println("After Parking Vehicle :: Available Parking Spot For " + vehicleType + " : " + twoParkingManager.getParkingSpotList().stream().filter(f -> f.isEmpty()).collect(Collectors.toList()).size() + "\n");
                    } else {
                        System.out.println("You can not book directly, first find the space");
                    }
                    choices();
                    chices = "";
                    break;
                case 3:
                    System.out.println("        Enter Vehicle Number to book spot   \n");
                    Scanner scanner3 = new Scanner(System.in);
                    final String vehicleNumber = scanner3.nextLine();
                    removeVehicle(enteranceGate, vehicleNumber);
                    System.out.println("After Removal of Vehicle :: Available Parking Spot For " + vehicleType + " : " + twoParkingManager.getParkingSpotList().stream().filter(f -> f.isEmpty()).collect(Collectors.toList()).size() + "\n");
                    choices();
                    break;
                case 4:
                    showBooking(enteranceGate);
                    break;
                default:
                    System.out.println("Wrong choice entered :" + choice);
                    choices();
                    break;
            }
            System.out.println();

        }
    }

    static ParkingSpot findParkingSpot(EnteranceGate enteranceGate) {
        final ParkingSpot parkingSpotSpace = enteranceGate.findSpace(VehicleType.TWO_WHEELER.name());
        if (parkingSpotSpace != null) {
            System.out.println("==========AVAILABLE PARKING SPOT==========");
            System.out.println("=====   Parking Number:   " + parkingSpotSpace.getId() + "        =====");
            System.out.println("=====   Space Available:  " + parkingSpotSpace.isEmpty() + "       =====");
            System.out.println("=====   Price:            " + parkingSpotSpace.getPrice() + "         =====");
            System.out.println("==========================================\n");
        }
        return parkingSpotSpace;
    }

    static void removeVehicle(EnteranceGate enteranceGate, String vehicle) {
        enteranceGate.removeVehicle(vehicle);
    }

    static Ticket bookSpot(EnteranceGate enteranceGate, Vehicle vehicle, ParkingSpot parkingSpotSpace) {
        final Ticket ticket = enteranceGate.bookSpot(vehicle, parkingSpotSpace);
        return ticket;
    }

    public static void showBooking(EnteranceGate enteranceGate) {
        boolean isBookingAvailable = false;
        System.out.printf("%-15s %-20s %-20s %-10s%n", "Parking Spot", "Vehicle Number", "Vehicle Type", "Price");

        for (ParkingSpot parkingSpot : enteranceGate.getParkingManager().getParkingSpotList()) {
            if (!parkingSpot.isEmpty()) {
                System.out.printf("%-15s %-20s %-20s %-10.2f%n",
                        parkingSpot.getId(),
                        parkingSpot.getVehicle().getVehicleNumber(),
                        parkingSpot.getVehicle().getVehicleType().name(),
                        (double) parkingSpot.getPrice());
                isBookingAvailable = true;
            }
        }
        if (!isBookingAvailable) {
            System.out.println("............................................");
            System.out.println("...............No Booking Yet...............");
            System.out.println("............................................\n");
            choices();
        } else {
            choices();
        }

    }

    static Vehicle getVehicle(String numberPlate, String vehicleType) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(numberPlate);
        vehicle.setVehicleType(VehicleType.valueOf(vehicleType));
        return vehicle;
    }

    static List<ParkingSpot> addParkingSpotForTwoWheeler() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for (int i = 101; i <= 105; i++) {
            ParkingSpot parkingSpot = new TwoWheelerSpot(Long.parseLong(String.valueOf(i)));
            parkingSpotList.add(parkingSpot);
        }
        return parkingSpotList;
    }

    static List<ParkingSpot> addParkingSpotForFourWheeler() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for (int i = 111; i <= 115; i++) {
            ParkingSpot parkingSpot = new FourWheelerSpot(Long.parseLong(String.valueOf(i)));
            parkingSpotList.add(parkingSpot);
        }
        return parkingSpotList;
    }

    static void printBanner() {
        System.out.println("==========WELCOME TO PARKING SPOT BOOKING SYSTEM==========\n");
        System.out.println("         SELECT VEHICLE TYPE     \n");
        System.out.println("            1." + VehicleType.TWO_WHEELER.name() + "           ");
        System.out.println("            2." + VehicleType.FOUR_WHEELER.name() + "          ");
    }

    static void choices() {
        System.out.println();
        System.out.println("             1. FindParkingSpace()");
        System.out.println("             2. BookParkingSpace()");
        System.out.println("             3. RemoveVehicleFromParkingSpace()");
        System.out.println("             4. ShowBooking()");
    }
}
