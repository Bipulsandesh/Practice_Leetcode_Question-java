public class Solution {
    public static long coloredCells(long n) { // Change int to long
        return n * n + (n - 1) * (n - 1);
    }

    public static void main(String[] args) {
        // Large test case
        System.out.println(coloredCells(69675)); // Expected: 9709071901

        // Other test cases
        System.out.println(coloredCells(1)); // Output: 1
        System.out.println(coloredCells(2)); // Output: 5
        System.out.println(coloredCells(3)); // Output: 13
        System.out.println(coloredCells(4)); // Output: 25
    }
}

