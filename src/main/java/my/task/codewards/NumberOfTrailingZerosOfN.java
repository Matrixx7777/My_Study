package my.task.codewards;

public class NumberOfTrailingZerosOfN {
    public static void zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
        System.out.println(count);
    }

    public static void main(String[] args) {
        NumberOfTrailingZerosOfN.zeros(0);
        NumberOfTrailingZerosOfN.zeros(6);
        NumberOfTrailingZerosOfN.zeros(14);
    }
}