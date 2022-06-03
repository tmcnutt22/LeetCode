package Leetcode;

import java.util.Stack;
import java.util.HashMap;


class ValidParentheses {
    public static void main(String[] args) {
        String string = "{}{}()";
        String string2 = "({{(([[]]))}})";
        System.out.println(isValid(string2));
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        if (s.length() % 2 != 0) {
            return false;
        }

        //creates a chararray
        char[] charArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        //iterates the charArray
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.containsKey(charArray[i]) && stack.isEmpty()) {
                return false;
            } if (hashMap.containsKey(charArray[i]) && hashMap.get(charArray[i]) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }

        return stack.isEmpty();
    }
}
