class Solution {
    public int minPartitions(String n) {
        for(int i = 9; i >= 1; i--) {
            if(n.indexOf((char)('0' + i)) != -1)
                return i;
        }
        return 0;
    }
}