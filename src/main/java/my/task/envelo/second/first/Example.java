package my.task.envelo.second.first;

import java.util.Scanner;

public class Example {
    private int tribonacciRecursion(int n) {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else if (n == 3) return 2;
        else return tribonacciRecursion(n - 1) + tribonacciRecursion(n - 2) + tribonacciRecursion(n - 3);
    }

    public void result() {
        Example tr = new Example();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the complete number (From 1 to 37): ");
        int n = sc.nextInt();
        if(n >= 38) System.out.println("Too large number");
        else if (n <= 0) System.out.println("Should be n > 0");
        else {
            int method = tr.tribonacciRecursion(n);
            System.out.println("Tribonacci recursion = " + method);
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.result();
    }
}

// Second idea
//class Solution {
//    private static final int MAX_N = 38;
//    int[] result = new int[MAX_N];
//
//    public int tribonacci(int n) {
//        Arrays.fill(result, -1);
//        return store(n);
//    }
//
//    private int store(int n) {
//        if(n == 1) result[n] = 0;
//        else if( n == 2) result[n] = 1;
//        else if(n == 3) result[n] = 2;
//        else if(n > 3) {
//            result[n] = store(n-3) + store(n-2) + store(n-1);
//        }
//        return result[n];
//    }
//}