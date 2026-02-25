import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        // Step 1: Convert int[] to Integer[]
        Integer[] temp = new Integer[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Sort using custom comparator
        Arrays.sort(temp, (a, b) -> {
            
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            // If bit counts are equal, sort by value
            if(countA == countB) {
                return a - b;
            }

            // Otherwise, sort by bit count
            return countA - countB;
        });

        // Step 3: Copy back to original array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}