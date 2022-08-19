package my.task.exercises.maths;

import java.util.Scanner;

public class NumberTable {

    public static void main(String[] args) {

        NumberTable onlyNumbers = new NumberTable();
        onlyNumbers.easierMethod();

        //For table
        Scanner sc = new Scanner(System.in);
        System.out.println("Method for table:\nGive me something number");
        int n = sc.nextInt() + 1;
        int[] table = new int[n];

        System.out.println("-----------------");

        for(int i = 1; i <= table.length -1; i++){
            n--;
            System.out.print(n + " ");
        }

        System.out.println("\n-----------------");

        n-=1;

        for(int i = 1; i <= table.length - 1; i++){
            n++;
            System.out.print(n + " ");
        }

        System.out.println("\n-----------------");

        for(int i = 1; i < n + 1; i++)
            if(i % 3 == 0)
                System.out.print(i + " ");
    }


    public void easierMethod(){

        //Only Numbers
        System.out.println("\nMethod for numbers:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Give me something number");

        int n = sc.nextInt();
        System.out.println(n + "\n");

        for(int i = 1; i <= n; i++){

            System.out.print(i + " ");
        }

        System.out.println("\n------------------------");

        for(int i = n; i >= 1; i--){

            System.out.print(i + " ");
        }

        System.out.println("\n------------------------");

        for(int i = 1; i < n + 1; i++) {
            if(i % 3 == 0)
                System.out.print(i + " ");
        }
    }
}