package my.task.others.second;

import java.util.*;

public class GFG {

    // Function to check if the current
    // string is balanced or not
    static boolean balanced(int[] small, int[] caps) {

        // For every character, check if
        // there exists uppercase as well
        // as lowercase characters
        for(int i = 0; i < 26; i++)
        {
            if (small[i] != 0 && (caps[i] == 0))
                return false;

            else if ((small[i] == 0) && (caps[i] != 0))
                return false;
        }
        return true;
    }

    // Function to find smallest length substring
    // in the given string which is balanced
    public int smallestBalancedSubstring(String s) {

        // Store frequency of
        // lowercase characters
        int[] small = new int[26];

        // Stores frequency of
        // uppercase characters
        int[] caps = new int[26];

        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        // Count frequency of characters
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                caps[s.charAt(i) - 'A']++;
            else
                small[s.charAt(i) - 'a']++;
        }

        // Mark those characters which
        // are not present in both
        // lowercase and uppercase
        Map<Character,
                Integer> mp = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            if (small[i] != 0 && caps[i] == 0)
                mp.put((char)(i + 'a'), 1);
            else if (caps[i] != 0 && small[i] == 0)
                mp.put((char)(i + 'A'), 1);
            // mp[char(i + 'A')] = 1;
        }

        // Initialize the frequencies
        // back to 0
        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        // Marks the start and
        // end of current substring
        int i = 0, st = 0;

        // Marks the start and end
        // of required substring
        int start = -1, end = -1;

        // Stores the length of
        // smallest balanced substring
        int minm = Integer.MAX_VALUE;

        while (i < s.length()) {
            if (mp.get(s.charAt(i)) != null) {

                // Remove all characters
                // obtained so far
                while (st < i)
                {
                    if (s.charAt(st) >= 65 &&
                            s.charAt(st) <= 90)
                        caps[s.charAt(st) - 'A']--;
                    else
                        small[s.charAt(st) - 'a']--;

                    st++;
                }
                i += 1;
                st = i;
            }
            else {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                    caps[s.charAt(i) - 'A']++;
                else
                    small[s.charAt(i) - 'a']++;

                // Remove extra characters from
                // front of the current substring
                while (true) {
                    if (s.charAt(st) >= 65 &&
                            s.charAt(st) <= 90 &&
                            caps[s.charAt(st) - 'A'] > 1)
                    {
                        caps[s.charAt(st) - 'A']--;
                        st++;
                    }
                    else if (s.charAt(st) >= 97 &&
                            s.charAt(st) <= 122 &&
                            small[s.charAt(st) - 'a'] > 1)
                    {
                        small[s.charAt(st) - 'a']--;
                        st++;
                    }
                    else
                        break;
                }

                // If substring (st, i) is balanced
                if (balanced(small, caps)) {
                    if (minm > (i - st + 1))
                    {
                        minm = i - st + 1;
                        start = st;
                        end = i;
                    }
                }
                i += 1;
            }
        }

        // No balanced substring
        if (start == -1)
            return -1;

            // Store answer string
        else {
            StringBuilder ans = new StringBuilder();
            for(int j = start; j <= end; j++)
                ans.append(s.charAt(j));

            return ans.length();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Given string
        String s = "azABaabba";
        String s2 = "TacoCat";
        String s3 = "AcZCbaBz";
        String s4 = "abcdefghijklmnopqrstuvwxyz";

        GFG gfg = new GFG();
        int gfg1 = gfg.smallestBalancedSubstring(s);
        int gfg2 = gfg.smallestBalancedSubstring(s2);
        int gfg3 = gfg.smallestBalancedSubstring(s3);
        int gfg4 = gfg.smallestBalancedSubstring(s4);

        System.out.println(gfg1 + "\n" + gfg2+ "\n"  + gfg3+ "\n"  + gfg4+ "\n" );
    }
}