package my.test.java.task.first;

public class Fibonacci {
    public int fibonacci(int n) {
        if(n == 0) return 0;
        else if((n == 1)||(n == 2)) return 1;
        else if(n == 3) return 3;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}