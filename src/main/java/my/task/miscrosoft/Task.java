package my.task.miscrosoft;

import java.util.*;

public class Task {
    public static void main(String[] args) {
    find_K_for_3_numbers_of_list();
}

    public static void find_K_for_3_numbers_of_list() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Program finding k as the result of 3 added numbers from the list\n" +
                "Enter the size of the list: ");
        int x = sc.nextInt();
        int[] arr = new int[x];
        for (int y = 0; y < arr.length; y++) {
            System.out.print("Enter a number in the list " + (y+1) + ": ");
            arr[y] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (Objects.equals(arr[i], arr[j])) {
                    System.out.println(arr[i]);
                }
            }
        }
        System.out.println("\nList " + Arrays.toString(arr) +
                "\nEnter the required result - k: ");
        int k = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int l = j + 1; l < arr.length; l++) {
                    final int equal = arr[i] + arr[j] + arr[l];
                    if(equal == k) {
                        System.out.println(arr[i] + " + " + arr[j] + " + " + arr[l] + " = " + equal);
                        return;
                    }
                }
            }
        }
    }
}