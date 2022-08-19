package my.task.exercises;

import java.util.Set;

public class ThreeSet {
        public static void main(String[] args) {
            Set<String> elements = new java.util.TreeSet<>();
            elements.add("one");
            elements.add("two");
            elements.add("three");
            elements.add("four");

            for (int i = 0; i < elements.size(); i++) {
                System.out.println(elements);
            }
        }
}