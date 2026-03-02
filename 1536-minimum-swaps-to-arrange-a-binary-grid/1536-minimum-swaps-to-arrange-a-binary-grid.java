class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeroes = new int[n];
        int cnt = 0;

        // 1. Preprocessing: Count trailing zeroes for each row
        // We only care about how many zeroes are at the end of each row.
        for(int i = 0; i < n; i++){
            cnt = 0;
            for(int j = grid[0].length - 1; j >= 0; j--){
                if(grid[i][j] == 0){
                    cnt++;
                }
                else break; // Stop at the first '1' from the right
            }
            trailingZeroes[i] = cnt;
        }

        int steps = 0;
        // 2. Greedy Approach: Iterate through each row to satisfy the requirement
        for(int i = 0; i < n - 1; i++){
            int needed = n - i - 1; // Requirement for row i to have zeroes below the diagonal
            
            // If current row already satisfies the requirement, move to the next
            if(trailingZeroes[i] >= needed){
                continue;
            }
            
            int idx = -1;
            // 3. Find the first row below current 'i' that meets the 'needed' requirement
            for(int j = i; j < n; j++){
                if(trailingZeroes[j] >= needed){
                    idx = j;
                    break;
                }
            }
            
            // If no such row is found, it's impossible to arrange the grid
            if(idx == -1){
                return -1;
            }
            else{
                // 4. Simulate adjacent swaps (Bubble Sort style)
                // Move the found row at 'idx' up to the current position 'i'
                int temp = trailingZeroes[idx];
                for(int k = idx; k > i; k--){
                    trailingZeroes[k] = trailingZeroes[k - 1]; // Shift rows down
                }
                trailingZeroes[i] = temp;
                
                // Add the number of adjacent swaps performed
                steps += idx - i;
            }
        }
        
        return steps;
    }
}