package com.low.level.design;

import java.util.ArrayList;
import java.util.List;

enum VehicleType{
    BIKE,CAR,BUS
}
enum SpotSize{
    SMALL,MEDIUM,LARGE
}
class Vehicle{
    private final VehicleType type;
    private final String number;
    public Vehicle(VehicleType type,String number){
        this.type=type;
        this.number=number;
    }
    public VehicleType getType(){
        return this.type;
    }
    public String getNumber(){
        return this.number;
    }
}
class ParkingSpot{
    private final SpotSize size;
    private final int spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId,SpotSize size){
        this.spotId=spotId;
        this.size=size;
        this.isOccupied=false;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if(isOccupied) return false;
        switch(vehicle.getType()){
            case BIKE:
                return true;
            case CAR:
                return (this.size==SpotSize.MEDIUM || this.size==SpotSize.LARGE);
            case BUS:
                return this.size==SpotSize.LARGE;
        }
        return false;
    }

    public boolean park(Vehicle vehicle){
        if(!canFitVehicle(vehicle)) return false;
        this.vehicle=vehicle;
        this.isOccupied=true;
        return true;
    }

    public void leave() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getSpotId() {
        return spotId;
    }

    public SpotSize getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
class ParkingLevel{
    private final int levelId;
    private final List<ParkingSpot> spots;
    public ParkingLevel(int levelId,int small,int medium,int large){
        this.levelId=levelId;
        this.spots = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < small; i++) spots.add(new ParkingSpot( id++,SpotSize.SMALL));
        for (int i = 0; i < medium; i++) spots.add(new ParkingSpot( id++,SpotSize.MEDIUM));
        for (int i = 0; i < large; i++) spots.add(new ParkingSpot(id++,SpotSize.LARGE));
    }
    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:spots){
            if(spot.park(vehicle)){
                System.out.println("Parked vehicle " + vehicle.getNumber() + " at Level " + levelId + ", Spot " + spot.getSpotId());
                return true;
            }
        }
        return false;
    }

    public boolean leaveVehicle(String vehicleNumber) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().getNumber().equals(vehicleNumber)) {
                spot.leave();
                System.out.println("Vehicle " + vehicleNumber + " left from Level " + levelId + ", Spot " + spot.getSpotId());
                return true;
            }
        }
        return false;
    }

    public void display() {
        System.out.println("Level " + levelId + " Status:");
        for (ParkingSpot spot : spots) {
            System.out.println("Spot " + spot.getSpotId() + " (" + spot.getSize() + ") - " + (spot.isOccupied() ? "Occupied by " + spot.getVehicle().getNumber() : "Free"));
        }
    }

    public boolean isFull() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) return false;
        }
        return true;
    }
}
class ParkingLot {
    private final List<ParkingLevel> levels;

    public ParkingLot(int numLevels, int smallPerLevel, int mediumPerLevel, int largePerLevel) {
        levels = new ArrayList<>();
        for (int i = 0; i < numLevels; i++) {
            levels.add(new ParkingLevel(i + 1, smallPerLevel, mediumPerLevel, largePerLevel));
        }
    }

    public boolean park(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        System.out.println("No available spot for vehicle " + vehicle.getNumber());
        return false;
    }

    public boolean leave(String vehicleNumber) {
        for (ParkingLevel level : levels) {
            if (level.leaveVehicle(vehicleNumber)) {
                return true;
            }
        }
        System.out.println("Vehicle " + vehicleNumber + " not found");
        return false;
    }

    public void display() {
        for (ParkingLevel level : levels) {
            level.display();
        }
    }
}
public class ParkingImplementationMain {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 2, 2, 1); // 2 levels, each with 2 small, 2 medium, 1 large spot

        Vehicle bike1 = new Vehicle(VehicleType.BIKE, "B1");
        Vehicle car1 = new Vehicle(VehicleType.CAR, "C1");
        Vehicle truck1 = new Vehicle(VehicleType.BUS, "T1");

        lot.park(bike1);
        lot.park(car1);
        lot.park(truck1);

        lot.display();

        lot.leave("C1");
        lot.display();

        Vehicle truck2 = new Vehicle(VehicleType.BUS, "T2");
        lot.park(truck2);

        lot.display();
    }
}
