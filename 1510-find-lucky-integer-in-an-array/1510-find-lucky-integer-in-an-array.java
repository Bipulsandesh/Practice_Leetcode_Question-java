class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501]; // Numbers in arr are ≤ 500
        
        // Step 1: Count frequencies
        for (int num : arr) {
            freq[num]++;
        }
        
        // Step 2: Find largest lucky number
        for (int i = 500; i > 0; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        
        // Step 3: No lucky number found
        return -1;
    }
}