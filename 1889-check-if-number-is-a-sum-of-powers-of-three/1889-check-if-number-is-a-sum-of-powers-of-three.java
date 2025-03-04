public class Solution {
    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12)); // true
        System.out.println(checkPowersOfThree(91)); // true
        System.out.println(checkPowersOfThree(21)); // false
    }
}