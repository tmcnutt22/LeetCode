package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> retList = new ArrayList<>();

        int index = 1;
        while (index <= n) {
            if (index % 3 == 0 && index % 5 == 0) {
                retList.add("FizzBuzz");
            } else if(index % 3 == 0) {
                retList.add("Fizz");
            } else if(index % 5 == 0) {
                retList.add("Buzz");
            } else {
                retList.add(Integer.toString(index));
            }
            index++;
        }
        return retList;
    }
}
