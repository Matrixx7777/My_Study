package my.task.exercises.maths;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        double x;
        double result1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number for x: ");
        x = scanner.nextInt();

        if(x>= 1 && x<=20){
            System.out.println("\nThird example  1/3x(power of 2) +2 for x <1 or x >20");
            result1 = (1.0/3.0) * x + x +2;
            System.out.println("Result = " + result1);

            if(x<=10){
                System.out.println("\nFirst example sin(PI * x) +1  for x <1,10> " );
                result1 = Math.sin((Math.PI * x)) + 1;
                System.out.println("Result = " + result1 );
            }

            else {
                System.out.println("\nSecond example root of two x for x (10,20>");
                result1 = Math.sqrt(x);
                System.out.println("Result = " + result1);
            }

        }else {
            System.out.println("Incorrect number or undefined number");
        }
    }
}