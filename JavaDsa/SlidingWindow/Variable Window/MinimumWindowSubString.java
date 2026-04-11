import java.util.*;

class MinimumWindowSubString {

    public static void main(String[] args) {

        String s1 = "mamatatamaramat";
        String s2 = "ata";

        if (s1.length() == 0 || s2.length() == 0) {
            System.out.println("");
            return;
        }

        int[] freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;
        }

        int start = 0, end = 0;
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (end < s1.length()) {

            char ch = s1.charAt(end);
            freq[ch - 'a']++;

            if (freq[ch - 'a'] <= s2Freq[ch - 'a']) {
                matched++;
            }

            while (matched == s2.length()) {

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char leftChar = s1.charAt(start);
                freq[leftChar - 'a']--;

                if (freq[leftChar - 'a'] < s2Freq[leftChar - 'a']) {
                    matched--;
                }

                start++;
            }

            end++;
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println("No window found");
        } else {
            System.out.println(s1.substring(minStart, minStart + minLen));
        }
    }
}