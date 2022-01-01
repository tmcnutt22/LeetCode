public class Summation {
    public static void main (String[] args) {
        double sum = 0;
        double multiplier = 4;
        for (int i = 1; i <= 15; i++) {
            sum += (4*Math.pow(i, 2)) + 7;
        }
        System.out.println(sum);
        System.out.println(sum * multiplier);
    }
}
