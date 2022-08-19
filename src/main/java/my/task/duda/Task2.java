package my.task.duda;

import java.util.ArrayList;

public class Task2 {
    public static ArrayList<Integer> findNPerfectNumbers(int n) {
        ArrayList<Integer>  list = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(findNPerfectNumbers(4));
    }
}