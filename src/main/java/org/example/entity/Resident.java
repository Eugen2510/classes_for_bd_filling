package org.example.entity;

public class Resident {
    private final int id;
    private String name;
    private String email;
    private int buildingId;
    private int flatId;
    private int parkingRight;
    private int ownerShip;

    public Resident (int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public int getParkingRight() {
        return parkingRight;
    }

    public void setParkingRight(int parkingRight) {
        this.parkingRight = parkingRight;
    }

    public int getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(int ownerShip) {
        this.ownerShip = ownerShip;
    }

    @Override
    public String toString() {
        return "(" +
                id +
                ", '" + name + '\'' +
                ", '" + email + '\'' +
                ", " + buildingId +
                ", " + flatId +
                ", " + parkingRight +
                ", " + ownerShip +
                "),";
    }
}
