package Leetcode;

public class PalindromeII {
    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {

        /*
        Examples and test cases
        Input: s = "aba"
        Output: true

        Input: s = "abca"
        Output: true
        Explanation: You could delete the character 'c'.

        Input: s = "abc"
        Output: false
         */

        /*
        Understand:
        What should I return if the string is "" || " "?

        Match:
        Use the 2 pointer technique

        Plan
        Use the two pointer technique.
        Start at the beginning and the end.
        If there is an unmatched character, then increment or decrement additional?
         */
        if (s.isEmpty() || s.length() == 1) return true;

        int idxBeg = 0, idxEnd = s.length() - 1;
        while (idxBeg < idxEnd){
           if (s.charAt(idxBeg) == s.charAt(idxEnd)) {
               idxBeg++;
               idxEnd--;
           } else {
                return (palindromeHelper(s, idxBeg + 1, idxEnd) || palindromeHelper(s, idxBeg, idxEnd - 1));
           }
        }

        return true;
    }

    public static boolean palindromeHelper(String s, int beg, int end) {
        while (beg < end) {
            if (s.charAt(beg) == s.charAt(end)) {
                beg++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
