package my.task.envelo.second.first;

import java.util.*;

public class ExampleTwo {
    private static final List<Long> tribList = new ArrayList<>(Arrays.asList(0L, 1L, 2L));

    public static Long calculateTribRecList(int n) {
        if(n < 0)
            throw new ArithmeticException("The number must be higher than 0" );
        if(tribList.size() < n) {
            Long value = calculateTribRecList(n - 3) + calculateTribRecList(n - 2) + calculateTribRecList(n - 1);
            tribList.add(value);
        }
        return tribList.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(ExampleTwo.calculateTribRecList(1));
    }
}