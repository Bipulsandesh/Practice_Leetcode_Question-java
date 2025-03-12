import java.util.Arrays;

class Solution { // Rename class to Solution
    public int maximumCount(int[] nums) {
        int negCount = findFirstZeroOrPositive(nums);
        int posCount = nums.length - findFirstPositive(nums);
        return Math.max(negCount, posCount);
    }

    private int findFirstZeroOrPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Main function for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumCount(new int[]{-2,-1,-1,1,2,3})); // Output: 3
        System.out.println(solution.maximumCount(new int[]{-3,-2,-1,0,0,1,2})); // Output: 3
        System.out.println(solution.maximumCount(new int[]{5,20,66,1314})); // Output: 4
    }
}

