package org.example;

import org.example.entity.Flat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFlatCreator {
    int numOfBuildings;
    int numOfFlatInBuilding;
    int allNumberOfFlats;
    int numOfFlatOnFloor;
    public RandomFlatCreator (int numOfBuildings, int floors, int numOfFlatOnFloor){
        this.numOfBuildings = numOfBuildings;
        this.numOfFlatOnFloor = numOfFlatOnFloor;
        numOfFlatInBuilding = floors * numOfFlatOnFloor;
        allNumberOfFlats = numOfBuildings * numOfFlatInBuilding;
    }

    Random random = new Random();


    public List<Flat> generateRandomFlats(){
        int flatNumber = 1;
        int buildingId = 1;
        int floor = 1;
        List<Flat> flats = new ArrayList<>();

        for (int i = 1; i <= allNumberOfFlats; i++) {

            int area = random.nextInt(41) + 60;
            int numOfRooms = random.nextInt(4) + 1;

            Flat flat = new Flat(i);
            flat.setBuildingId(buildingId);
            flat.setApartmentNumber(flatNumber++);
            flat.setArea(area);
            flat.setFloor(floor);
            flat.setNumOfRooms(numOfRooms);

            flats.add(flat);

            if (i % numOfFlatOnFloor == 0){
                floor++;
            }

            if (i % numOfFlatInBuilding == 0){
                buildingId++;
                flatNumber = 1;
                floor = 1;
            }


        }
        return flats;
    }

    public int getAllNumberOfFlats(){
        return allNumberOfFlats;
    }

    public static void main(String[] args) {
        RandomFlatCreator creator = new RandomFlatCreator(5, 5, 4);
        List<Flat> flats = creator.generateRandomFlats();

        for (Flat f: flats) {
            System.out.println(f);
        }
    }
}
