/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for 24 Game.
Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for 24 Game.

*/

class Solution {
    public boolean judgePoint24(int[] nums) {

        double a = Double.valueOf(nums[0]);
        double b = Double.valueOf(nums[1]);
        double c = Double.valueOf(nums[2]);
        double d = Double.valueOf(nums[3]);
        
        return judge(a, b, c, d)
            || judge(a, b, d, c)
            || judge(a, c, b, d)
            || judge(a, c, d, b)
            || judge(a, d, b, c)
            || judge(a, d, c, b)
            || judge(b, a, c, d)
            || judge(b, a, d, c)
            || judge(b, c, a, d)
            || judge(b, c, d, a)
            || judge(b, d, a, c)
            || judge(b, d, c, a)
            || judge(c, a, b, d)
            || judge(c, a, d, b)
            || judge(c, b, a, d)
            || judge(c, b, d, a)
            || judge(c, d, a, b)
            || judge(c, d, b, a)
            || judge(d, a, b, c)
            || judge(d, a, c, b)
            || judge(d, b, a, c)
            || judge(d, b, c, a)
            || judge(d, c, a, b)
            || judge(d, c, b, a);
    }
    
    private boolean judge(double a, double b, double c, double d) {
        return judge(a, b, c*d)
            || judge(a, b, c+d)
            || judge(a, b, c-d)
            || d != 0 && judge(a, b, c/d);
    }

    private boolean judge(double a, double b, double c) {
        return judge3(a, b, c)
            || judge3(a, c, b)
            || judge3(b, a, c)
            || judge3(b, c, a)
            || judge3(c, a, b)
            || judge3(c, b, a);
    }    

    private boolean judge3(double a, double b, double c) {
        return judge(a, b*c)
            || judge(a, b+c)
            || judge(a, b-c)
            || c != 0 && judge(a, b/c);
    }    

    private boolean judge(double a, double b) {
        return judge(a*b)
            || judge(a+b)
            || judge(a-b)
            || b != 0 && judge(a/b);
    }    

    private boolean judge(double a) {
        return Math.abs(a - 24) < 0.000001;
    }
}