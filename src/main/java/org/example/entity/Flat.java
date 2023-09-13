package org.example.entity;

public class Flat {
    private final int id;
    private int buildingId;
    private int apartmentNumber;
    private int area;
    private int floor;
    private int numOfRooms;

    public Flat (int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Override
    public String toString() {
        return "(" +
                id +
                ", " + buildingId +
                ", " + apartmentNumber +
                ", " + area +
                ", " + floor +
                ", " + numOfRooms +
                "),";
    }
}
