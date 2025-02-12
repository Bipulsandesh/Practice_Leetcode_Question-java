import java.util.*;

public class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        
        for (int num : nums) {
            int sumOfDigits = sumOfDigits(num);
            if (map.containsKey(sumOfDigits)) {
                maxSum = Math.max(maxSum, num + map.get(sumOfDigits));
                map.put(sumOfDigits, Math.max(num, map.get(sumOfDigits)));
            } else {
                map.put(sumOfDigits, num);
            }
        }
        
        return maxSum;
    }
    
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

