package my.task.extra.first;

import java.util.*;

public class SecondSolution {
    public static void main(String[] args) {
        int[] array = { 3, 5, 1, 2, 4 }; int x = 3;
        Arrays.sort(array);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(array) + "\n" + search(array,x));
    }
    private static boolean search(int[] array, int x) { return Arrays.stream(array).anyMatch(e -> Objects.equals(e, x)); }
}