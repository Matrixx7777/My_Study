package my.task.others.third;

import java.util.List;
import java.util.Arrays;

class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");

        int incl = list.get(0);
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < list.size(); i++)
        {
            /* current max excluding i */
            excl_new = Math.max(incl, excl);

            /* current max including i */
            incl = excl + list.get(i);
            excl = excl_new;
        }

        /* return max of incl and excl */
        return (Math.max(incl, excl));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        // Should return 20, since 9 and 11 are the largest elements
        // and their sum is 20
        System.out.println(findMaxSum(list));
    }
}