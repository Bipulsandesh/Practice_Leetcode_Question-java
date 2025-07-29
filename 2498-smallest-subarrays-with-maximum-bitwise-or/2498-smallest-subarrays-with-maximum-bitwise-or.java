class Solution {
    static boolean checkBit(int n,int i){
        return ((n)&(1<<i))!=0;
    }
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int[] arr=new int[32];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<32;j++){
                if(checkBit(nums[i],j)){
                    arr[j]=i;
                }
            }
            int max=i;
            for(int j=0;j<32;j++){
                max=Math.max(max,arr[j]);
            }
            ans[i]=(max-i)+1;
        }
        return ans;
    }
}