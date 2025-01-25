public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(11));  // Output: 3
        System.out.println(solution.hammingWeight(128)); // Output: 1
        System.out.println(solution.hammingWeight(2147483645)); // Output: 31
    }
}