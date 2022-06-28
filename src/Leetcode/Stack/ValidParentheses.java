package Leetcode.Stack;

import java.util.Stack;
import java.util.HashMap;


class ValidParentheses {
    public static void main(String[] args) {
        String string = "{}{}()";
        String string2 = "({{(([[]]))}})";
        System.out.println(isValid(string));
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

        //iterates the charArray
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c) && stack.isEmpty()) {
                return false;
            } if (hashMap.containsKey(c) && hashMap.get(c) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
