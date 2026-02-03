class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;
        
        for (int p = 1; p <= n -1; p++) {
        	boolean first_increasing = true;
        	for (int i = 1; i <= p; i++) {
        		if (nums[i] <= nums[i - 1]) {
        		     first_increasing = false;
        		     break;
        		}
        	}
        	if (!first_increasing) continue;
        	
        	for (int q = p + 1; q < n - 1; q++) {
        		boolean decreasing = true;
        		for (int i = p + 1; i <= q; i++) {
        			  if (nums[i] >= nums[i - 1]) {
        			  	decreasing = false;
        			  	break;
        			  }
        		}
        		if (!decreasing) continue;
        		
        		boolean last_increasing = true;
        		for (int i = q + 1; i < n; i++) {
        			if (nums[i] <= nums[i - 1]) {
        				last_increasing =false;
        				break;
        			}
        		}
        		if (last_increasing) return true;
        	}
        }
        
        return false;
    }
}