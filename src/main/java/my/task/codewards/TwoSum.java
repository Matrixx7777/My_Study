package my.task.codewards;

import java.util.Arrays;

public class TwoSum {
    public static void twoSum(int[] numbers, int target) {
        int[] result = new int[0];
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    if(numbers[i] != numbers[j]) {
                        if (numbers[j] < numbers[i])
                            result = new int[]{j, i};
                        else if (numbers[i] < numbers[j])
                            result = new int[]{i, j};
                    }
                    else if(numbers[i] == numbers[j])
                        result = new int[]{i, j};
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        int[] numbers = {8,1,4,3,5};
        int target = 8;
        TwoSum.twoSum(numbers, target);
    }
}