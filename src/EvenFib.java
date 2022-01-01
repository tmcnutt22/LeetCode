import java.util.ArrayList;
import java.util.List;

public class EvenFib {

    public static void main(String[] args) {
        System.out.println(evenFib(4000000));
    }

    public static int evenFib(int limit) {
        ArrayList<Integer> list = new ArrayList<>(List.of(0,1));
        int sumOfEvenFib = 0;
        int currentFib = 1;
        while (currentFib < limit) {
            currentFib = list.get(0) + list.get(1);
            list.add(0, list.get(1));
            list.add(1, currentFib);
            if (currentFib % 2 == 0) {
                sumOfEvenFib += currentFib;
            }
        }
        return sumOfEvenFib;
    }
    /*

    static int evenFibSum(int limit)
    {
        if (limit < 2)
            return 0;

        // Initialize first two even prime numbers
        // and their sum
        long ef1 = 0, ef2 = 2;
        long sum = ef1 + ef2;

        // calculating sum of even Fibonacci value
        while (ef2 <= limit)
        {
            // get next even value of Fibonacci sequence
            long ef3 = 4 * ef2 + ef1;

            // If we go beyond limit, we break loop
            if (ef3 > limit)
                break;

            // Move to next even number and update sum
            ef1 = ef2;
            ef2 = ef3;
            sum += ef2;
        }

        return(int) sum;
    }

    // Driver code
    public static void main (String[] args)
    {
        int limit = 1000;
        System.out.println(evenFibSum(limit));

    }

     */
}
