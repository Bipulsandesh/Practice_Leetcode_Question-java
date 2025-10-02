class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int m=numBottles, n=numExchange, s=m;
        while (m>=n) {
            m-=n++;
            s++;
            m++;
        }
        return s;
    }
}