package Leetcode;

import java.util.HashMap;

public class RomanToIntvtwo {
    public static void main (String [] args) {
        String test1 = "III"; //3
        String test2 = "LVIII"; //58
        String test3 = "MCMXCIV"; //1994
        String test4 = "IV"; //4
        System.out.println(romanToInt(test4));
    }
    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap <>();
        //create a hashmap of the roman numbers and int values
        map.put('I',1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum= 0;
        int prev = map.get(s.charAt(0));
        int next = 0;

        for(int i = 1; i < s.length(); i++){
            next = map.get(s.charAt(i));
            if (prev<next){
                sum-=prev;
            }else{
                sum+=prev;
            }
            prev = next;
        }
        sum+=prev;
        return sum; //placeholder
    }
}
