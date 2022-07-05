package Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxUnitsOnTruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //sorts 2d array
        //Arrays.sort(boxTypes, Comparator.comparingInt(i->i[1]));
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int totalBoxes = 0;
        int totalUnits = 0;
        int index = 0;
        while(totalBoxes <= truckSize && index < boxTypes.length) {
            int currBoxes = boxTypes[index][0]; //curr index's number of boxes
            //System.out.println(currBoxes);
            int unitsPerBox = boxTypes[index][1];
            //System.out.println(unitsPerBox);
            if ((truckSize - totalBoxes) - currBoxes > 0) {
                totalBoxes += currBoxes;
                totalUnits += currBoxes * unitsPerBox;
            } else {
                totalUnits += (truckSize - totalBoxes) * unitsPerBox;
                return totalUnits;
            }
            index++;
        }
        return totalUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
