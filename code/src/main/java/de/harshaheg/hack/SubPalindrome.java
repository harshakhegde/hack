package de.harshaheg.hack;

import java.util.Arrays;
import java.util.List;

public class SubPalindrome {
    static String longestPali = new String();

    public static void main(String[] args) {
        List<String> ips = Arrays.asList("mom", "dad", "df", "wertkmomkkhagrsd", "malayalam", "abacdgfdcaba");
        for (String test : ips) {
            longestPali = new String();
            System.out.println(longestPalindrome(test));
        }

    }

    public static String longestPalindrome(String s) {
        //System.out.println(s);

        if (longestPali.isEmpty() && s.length() > 1) {
            int j = s.length();
            int i = 0;
            String substring = s.substring(i, j);
            if (isPalindrome(substring)) {
                longestPali = (substring.length() > longestPali.length()) ? substring : longestPali;
            } else {
                longestPalindrome(s.substring(i, --j));
                longestPalindrome(s.substring(++i, j));
            }
            return longestPali;
        } else {
            return longestPali;
        }
    }

    private static boolean isPalindrome(String ss) {
        StringBuilder sb = new StringBuilder(ss);
        String rev_ss = sb.reverse().toString();
        return ss.equals(rev_ss);

    }
}
