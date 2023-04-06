package my.task.codewards;

public class SumOfDigits {
    public static int digital_root(int n) {
        if (n == 0) return 0;
        int result = n % 10 + digital_root(n / 10);
        return result % 10 + digital_root(result / 10);
//        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }

    public static void main(String[] args) {
        System.out.println(digital_root(456));
    }
}