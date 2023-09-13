package org.example;

import org.example.entity.Resident;

import java.util.*;

public class RandomPersonCreator {

    // Русский алфавит в нижнем регистре
    private static final String[] russianAlphabet = {
            "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "i",
            "й", "к", "л", "м", "н", "о", "п", "р", "с", "т",
            "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь",
            "э", "ю", "я"
    };

    // Представление русских букв в английском алфавите
    private static final String[] englishEquivalent = {
            "a", "b", "v", "g", "d", "e", "yo", "zh", "z", "i", "i",
            "y", "k", "l", "m", "n", "o", "p", "r", "s", "t",
            "u", "f", "kh", "ts", "ch", "sh", "shch", "'", "y", "'",
            "e", "yu", "ya"
    };

    private static final Map<String, String> changeAlphabet = new HashMap<>();
    Random random = new Random();

    int numOfBuildings;
    int numOfFlats;

    public RandomPersonCreator (int numOfBuildings, int numOfFlats){
        this.numOfBuildings = numOfBuildings;
        this.numOfFlats = numOfFlats;

        for (int i = 0; i < russianAlphabet.length; i++) {
            String rus = russianAlphabet[i];
            String eng = englishEquivalent[i];
            changeAlphabet.put(rus, eng);
        }
    }

    private boolean findFlatId(int flatId, List<Resident> residents){
        boolean isSuchFlatInOwned = false;
        for (Resident r: residents) {
            if(r.getFlatId() == flatId && r.getOwnerShip() == 1){
                isSuchFlatInOwned = true;
            }
        }
        return isSuchFlatInOwned;
    }

    public List<Resident> createPerson (String [] names, String [] lastnames, int numOfNeedPersons){
        List <Resident> residents = new ArrayList<>();

        for (int i = 0; i < numOfNeedPersons; i++){
            int id = i+1;
            int randomName = random.nextInt(names.length);
            int randomLastname = random.nextInt(lastnames.length);
            String name = names[randomName];
            String lastname = lastnames[randomLastname];
            if (name.charAt(name.length()-1) == 'а' || name.charAt(name.length()-1) == 'я'){
                lastname += 'а';
            }
            String email = createEmail(lastname);
            int buildingId = random.nextInt(numOfBuildings) + 1;
            int flatId = random.nextInt(numOfFlats) + 1;
            int parkingRight = random.nextInt(2);
            int ownership = random.nextInt(2);
            if(ownership == 1){
                if (findFlatId(flatId, residents)) {
                    ownership = 0;
                }
            }

            String fullName = name + " " + lastname;

            Resident resident = new Resident(id);
            resident.setName(fullName);
            resident.setEmail(email);
            resident.setBuildingId(buildingId);
            resident.setFlatId(flatId);
            resident.setParkingRight(parkingRight);
            resident.setOwnerShip(ownership);

            residents.add(resident);

        }
        return residents;
    }

    private String createEmail(String lastName){
        String lower = lastName.toLowerCase();
        String [] emailEnd = {"@ukr.net", "@gmail.com", "@yahoo.com", "@outlook.com", "@icloud.com"};
        StringBuilder sb = new StringBuilder();
        for (String letter : lower.split("")){
            sb.append(changeAlphabet.get(letter));
        }
        int randomPos = random.nextInt(emailEnd.length);
        sb.append(emailEnd[randomPos]);
        return sb.toString();
    }

    public static void main(String[] args) {
        RandomPersonCreator creator = new RandomPersonCreator(6, 151);
        String [] names = {"Анна", "Марія", "Олександр", "Іван", "Катерина", "Олена", "Андрій", "Вікторія", "Павло", "Ярослав",
                "Оксана", "Ірина", "Василь", "Наталія", "Юрій", "Людмила", "Григорій", "Тетяна", "Михайло", "Дарина",
                "Роман", "Софія", "Ігор", "Ангеліна", "Дмитро", "Світлана", "Сергій", "Лариса", "Максим", "Ольга"};

        String [] lastnames = {"Іванов", "Петров", "Смирнов", "Соколов", "Михайлов", "Федоров", "Волков", "Алексеев", "Лебедев", "Семенов",
                "Егоров", "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Морозов", "Ковалев", "Захаров",
                "Горбачев", "Кузнецов", "Титов", "Кудрявцев", "Комаров", "Белов", "Киселев", "Макаров", "Анисимов", "Баранов"};
        long start = System.currentTimeMillis();
        List<Resident> persons = creator.createPerson(names, lastnames, 100);
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);

        for (Resident r: persons) {
            System.out.println(r);
        }
    }
}
