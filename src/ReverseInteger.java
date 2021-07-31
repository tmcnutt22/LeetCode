class Solution {
    public int reverse(int x) {
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        String temp = String.valueOf(x);
        char[] charArray = new char[temp.length()];
        
        for (int i = 0; i < temp.length(); i++) {
            charArray[i] = temp.charAt(temp.length() - 1 - i);
        }

        String str = String.valueOf(charArray);
        int intReversed;

        try {
            intReversed = Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
  
        if (intReversed > Math.pow(2,31)) {
            return 0;
        }
        
        if (isNegative) {
            return intReversed * -1;
        }
        
    
        return intReversed;
    }
}
