class Solution {
    public boolean reorderedPowerOf2(int n) {

        int[] countOfN = getDigitCount(n);
        int power = 1; // 2^0
        for (int i = 0; i < 31; i++) {

            int[] countOfPower = getDigitCount(power);
            if (areCountsEqual(countOfN, countOfPower)) {
                return true; // Found a match
            }

            power = power * 2;
        }

        return false;
    }

    // Function to count digits 
    private int[] getDigitCount(int num) {
        int[] count = new int[10]; 

        while (num > 0) {
            int lastDigit = num % 10; // Get last digit
            count[lastDigit]++;       // Increase its count
            num = num / 10;           // Remove last digit
        }

        return count;
    }

    // Function to compare two digit count arrays
    private boolean areCountsEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 10; i++) { 
            if (arr1[i] != arr2[i]) {
                return false; 
            }
        }
        return true;
    }
}