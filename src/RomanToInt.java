import java.util.HashMap;

class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int output = 0;
        output += hashMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'V' && s.charAt(i - 1) == 'I' || s.charAt(i) == 'X' && s.charAt(i - 1) == 'I') {
                output += hashMap.get(s.charAt(i)) - 2;
            } else if (s.charAt(i) == 'L' && s.charAt(i - 1) == 'X' || s.charAt(i) == 'C' && s.charAt(i - 1) == 'X') {
                output += hashMap.get(s.charAt(i)) - 20;
            } else if (s.charAt(i) == 'D' && s.charAt(i - 1) == 'C' || s.charAt(i) == 'M' && s.charAt(i - 1) == 'C') {
                output += hashMap.get(s.charAt(i)) - 200;
            } else {
                output += hashMap.get(s.charAt(i));
            }
        }
        return output;
    }

}
