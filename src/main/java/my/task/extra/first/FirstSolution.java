package my.task.extra.first;

import java.util.*;

public class FirstSolution {
    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 2, 4 }; int x = 3;
        Integer[] integersList = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(integersList, Collections.reverseOrder());
        array = Arrays.stream(integersList).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array) + "\n" + search(array,x));
    }
    private static boolean search(int[] array, int x) { return Arrays.stream(array).anyMatch(e -> Objects.equals(e, x)); }
}