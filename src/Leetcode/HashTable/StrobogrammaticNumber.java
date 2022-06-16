package Leetcode.HashTable;

import java.util.HashMap;

public class StrobogrammaticNumber {
    public static void main (String[] args) {
        String s1 = "69"; //true
        String s2 = "88"; //true
        String s3 = "962"; //false
        String s4 = "808"; //true
        String s5 = "816"; //false
        String s6 = "1990661"; //true

        System.out.println(isStrobogrammatic(s6));
    }
    public static boolean isStrobogrammatic(String num) {
        if (num.length() < 1) {
            return false;
        }

        //if it is valid length
        //build the hashmap
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        if (num.length() == 1) {
            char tempChar = num.charAt(0);
            if (!map.containsKey(tempChar) || tempChar == '6' || tempChar == '9') {
                return false;
            } else {
                return true;
            }
        }

        //if (num.length() == 2) {}


        for (int i = 0, j = num.length() - 1; i < num.length()/2; i++, j--) {

            char currChar = num.charAt(i);
            char endChar = num.charAt(j);

            if (!map.containsKey(currChar) || !map.containsKey(endChar)) {
                return false;
            } else if(currChar == '6' || currChar == '9') {
                if (currChar == '6' && endChar != map.get(currChar)) {

                    return false;
                } else if (currChar == '9' && endChar != map.get(currChar)) {

                    return false;
                }
            } else {
                if (currChar != map.get(endChar)) {

                    return false;
                }
            }
        }
        //handle middle char if necessary
        if (num.length() % 2 != 0) {
            char midChar = num.charAt((num.length() / 2));

            if (!map.containsKey(midChar) || midChar == '6' || midChar == '9') {

                System.out.println("returns here");
                return false;
            }
        }
        return true;
    }
}


/*
UNDERSTAND
MATCH
hashmap
PLAN
map of numbers that satisfy this -> (ones that are themselves 0, 1, 8, or turn into each other 6, 9
order matters?
[818] -> [818] true
[908] -> [806] false

if 6 -> 9 or if 9 -> 6

iterate the string from beginning and end. these numbers need to be one of hte numbers in the map
and if 6 -> 9 or 9 ->6 else equal themselves

O(n) time where n is the length of the string
O(1) space as the hashmap is constant size
 */
