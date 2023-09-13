package org.example.entity;

public class FlatOwner {
    private int flatId;
    private int residentId;

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    @Override
    public String toString() {
        return "(" +
                residentId +
                ", " + flatId +
                "),";
    }
}
