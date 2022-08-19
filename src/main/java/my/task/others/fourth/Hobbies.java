package my.task.others.fourth;

import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findHobbyists(String hobby) {

        List<String> hobbyList = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : hobbies.entrySet()) {
            for (int i = 0; i < hobbies.size(); i++) {
                if(hobby.equals(entry.getValue()[i])) {
                    String returnVariable = "Name: " + entry.getKey() + " | hobbies: " + entry.getValue()[i] + " == " + hobby;
                    hobbyList.add(returnVariable);
                }
            }
        }
        return hobbyList;
    }

    public static void main(String[] args ) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Reading");
        System.out.println(Arrays.toString(hobbies.findHobbyists("Pets").toArray()));
    }
}