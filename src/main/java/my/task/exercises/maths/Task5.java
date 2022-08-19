package my.task.exercises.maths;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = 0;
        int theBiggestNumber = 0;
        int theSmallestNumber = 0;

        System.out.println("Enter positive integers\n" + "If you would like to finish it, you have to enter '-99'");

        while(number != (-99)){
            number = sc.nextInt();
            if(number <= theSmallestNumber){
                theSmallestNumber = number;
            }
            else if(number >= theBiggestNumber){
                theBiggestNumber = number;
            }
        }
        System.out.println("\nThe smallest number is " + theSmallestNumber +
                "\nThe biggest number is " + theBiggestNumber);
    }
}