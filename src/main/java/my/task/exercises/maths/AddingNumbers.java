package my.task.exercises.maths;

import java.util.Scanner;

public class AddingNumbers {

    public static void main(String[] args) {

        System.out.println("\nMethod for table:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer");
        int m = sc.nextInt();

        int res = 0;

        if(m > 0){
            for(int i = 1; i < m + 1; i++){
                System.out.print(i + " ");
                res += i;
            }

            System.out.println("\nResult = " + res);
        }
        else {
            System.out.println("Incorrect number");
        }
    }
}