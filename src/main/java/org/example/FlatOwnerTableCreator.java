package org.example;

import org.example.entity.Flat;
import org.example.entity.FlatOwner;
import org.example.entity.Resident;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FlatOwnerTableCreator {
    List<Flat> flats;
    List<Resident> residents;
    RandomFlatCreator flatCreator;
    RandomPersonCreator personCreator;


    public FlatOwnerTableCreator (int numOfBuildings, int floors, int numOfFlatOnFloor, String [] names, String [] lastnames, int numOfPersons){
        flatCreator = new RandomFlatCreator(numOfBuildings, floors, numOfFlatOnFloor);
        personCreator = new RandomPersonCreator(numOfBuildings, flatCreator.getAllNumberOfFlats());

        flats = flatCreator.generateRandomFlats();
        residents = personCreator.createPerson(names, lastnames, numOfPersons);
    }

    private Flat findFlatById(int id){
        Flat flat = null;
        for (Flat f : flats){
            if(f.getId() == id){
                flat = f;
            }
        }
        return flat;
    }

    public List<FlatOwner> createFlatOwnerTable(){
        Random random = new Random();
        List<Resident> owners = new LinkedList<>();
        List<Flat> ownersFlats = new ArrayList<>(flats);
        List<FlatOwner> result = new ArrayList<>();
        for (Resident r : residents){
            if (r.getOwnerShip() == 1){
                owners.add(r);
                int flatId = r.getFlatId();
                ownersFlats.remove(findFlatById(flatId));
            }
        }

        for (Resident r : owners){
            FlatOwner owner = new FlatOwner();
            int ownedFlats = random.nextInt(4);
            if(ownersFlats.size() < ownedFlats){
                ownedFlats = ownersFlats.size();
            }
            int ownerId = r.getId();
            owner.setResidentId(ownerId);
            owner.setFlatId(r.getFlatId());
            result.add(owner);
            for (int i = 0; i < ownedFlats; i++) {
                owner = new FlatOwner();
                int index = random.nextInt(ownersFlats.size());
                int flatId = ownersFlats.remove(index).getId();
                owner.setResidentId(ownerId);
                owner.setFlatId(flatId);
                result.add(owner);

            }

        }
        return result;
    }

    public static void main(String[] args) {
        String [] names = {"Анна", "Марія", "Олександр", "Іван", "Катерина", "Олена", "Андрій", "Вікторія", "Павло", "Ярослав",
                "Оксана", "Ірина", "Василь", "Наталія", "Юрій", "Людмила", "Григорій", "Тетяна", "Михайло", "Дарина",
                "Роман", "Софія", "Ігор", "Ангеліна", "Дмитро", "Світлана", "Сергій", "Лариса", "Максим", "Ольга"};

        String [] lastnames = {"Іванов", "Петров", "Смирнов", "Соколов", "Михайлов", "Федоров", "Волков", "Алексеев", "Лебедев", "Семенов",
                "Егоров", "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Морозов", "Ковалев", "Захаров",
                "Горбачев", "Кузнецов", "Титов", "Кудрявцев", "Комаров", "Белов", "Киселев", "Макаров", "Анисимов", "Баранов"};



        FlatOwnerTableCreator creator = new FlatOwnerTableCreator(5, 5, 4, names, lastnames, 100);
        List <Flat> flats1 = creator.flats;
        List<Resident> residents1 = creator.residents;
        System.out.println("Flats\n-----------------------------------------\n");
        for (Flat f : flats1){
            System.out.println(f);
        }
        System.out.println("Residents\n-----------------------------------------\n");
        for (Resident r : residents1){
            System.out.println(r);
        }

        System.out.println("Owners\n-----------------------------------------\n");
        List<FlatOwner> flatOwnerTable = creator.createFlatOwnerTable();
        for (FlatOwner fo: flatOwnerTable) {
            System.out.println(fo);
        }

        for (int i = 0; i < flatOwnerTable.size(); i++) {
            for (int j = 0; j < flatOwnerTable.size(); j++) {
                if(flatOwnerTable.get(i).getFlatId() == flatOwnerTable.get(j).getFlatId() && i != j){
                    System.out.println("flat " + i  + " == flat " + j);
                }
            }
        }
        System.out.println("size = " + flatOwnerTable.size());
    }
}
