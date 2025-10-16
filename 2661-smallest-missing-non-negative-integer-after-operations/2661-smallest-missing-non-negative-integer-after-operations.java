class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for(int num: nums){
            freq[Math.floorMod(num, value)]++;
        }
        System.out.println(Arrays.toString(freq));
        for(int i = 0; i < nums.length; i++){
            int cur = Math.floorMod(i, value);
            if(freq[cur] == 0){
                return i;
            }
            freq[cur]--;
        }  
        return nums.length;
    }
}