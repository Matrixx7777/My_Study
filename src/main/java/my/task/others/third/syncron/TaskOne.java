package my.task.others.third.syncron;

import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        Solution st = new Solution();
        String S = "ABBBAB";
        int res = st.maxUniqueSplit(S);

        System.out.println(res + "\n" + S);
    }
}

class Solution {

    public int maxUniqueSplit(String S) {
        return maxUnique(S, new HashSet<>());
    }

    public int maxUnique(String S, Set<String> set) {
        int max = 1;

        for (int i = 1; i <= S.length(); i++) {

            String tmp = S.substring(0, i);

            if (!set.contains(tmp)) {

                set.add(tmp);

                max = Math.max(max, maxUnique(
                        S.substring(i), set)
                        + 1);

                set.remove(tmp);
            }
        }
        return max;
    }
}