package Leetcode.String;

public class NumLasersInBank {
        public static int numberOfBeams(String[] bank) {
            int[] deviceFreq = new int[bank.length];
            int deviceCount = 0;

            for (int i = 0; i < bank.length; i++) {
                for (char c: bank[i].toCharArray()) {
                    if (c == '1') {
                        deviceFreq[i]++;
                    }
                }
            }

//            printArr(deviceFreq);

            //move index until you find the first non-zero

            int index = 0;
            int lastNumDevices = 0;
            int currNumDevices = 0;

            while(index < deviceFreq.length) {
                if (deviceFreq[index] == 0) {
                    index++;
                    continue;
                }

                currNumDevices = deviceFreq[index];

                //last index
                if (index == deviceFreq.length - 1 && deviceFreq[index - 1] > 0) {
                    deviceCount += (currNumDevices * lastNumDevices);
                    break;
                }


                //anything in between 0 and len - 1
                if (index > 0 && deviceFreq[index - 1] == 0 && lastNumDevices > 0) {
                    deviceCount += (currNumDevices * lastNumDevices);
                }

                lastNumDevices = currNumDevices;
                index++;
            }

            return deviceCount;
        }

        public static void printArr(int[] deviceFreq) {
            for (int i = 0; i < deviceFreq.length; i++) {
                System.out.print(deviceFreq[i] + ", ");
            }
        }

        public static void main(String[] args) {
            String[] bank = {"011001","000000","010100","001000"};
            System.out.println(numberOfBeams(bank));
        }
}
