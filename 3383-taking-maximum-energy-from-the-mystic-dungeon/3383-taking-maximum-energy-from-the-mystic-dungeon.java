class Solution {
    public int maximumEnergy(int[] energy, int k) {
     int maxSum = Integer.MIN_VALUE;
     int n = energy.length;
     int i = n-1;
     while(i>=0){
        if(i+k<n){
            energy[i]+=energy[i+k];
        }
        maxSum = Math.max(energy[i],maxSum);
        i--;
     }   
     return maxSum;
    }
}