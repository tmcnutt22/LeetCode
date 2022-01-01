/*
TODO: Understand this problem. Marked as leetcode easy but many approaches
LEETCODE: 14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {

        return "";
    }
}


/*
understand:
1. is there a difference between capital and lower case letters?
    only lower case
2. can there be an empty strings as inputs?
3. can there be numbers and symbols as inputs?

[cat, dog, fish] -> ""
[stop, step,string] -> "st"
["", "", ""] -> ""

MATCH:
matching strings -> hashing

Plan:
approach 1: naive
loop through each character of a single string and compare to the rest of the array.
if charAt(0) is the same, then move to charAt(1), iterating until either the loop is completed or until there is no
match.
O(n) time
O(1) memory


Time: O(n) doing constant time look ups?
Space: O(n) where n is the size of the array
 */
