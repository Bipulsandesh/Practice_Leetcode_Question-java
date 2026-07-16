class Solution {
    public int findGcd(int a, int b)
    {
        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a= temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int max= nums[0], n= nums.length;
        int prefixGcd[]= new int[n];
        prefixGcd[0]= nums[0];

        for(int i=1; i<n; i++)
        {
            max= Math.max(max, nums[i]);
            int gcd= findGcd(nums[i], max);
            prefixGcd[i]= gcd;
        }

        Arrays.sort(prefixGcd);
        int left=0, right= n-1;
        long sum=0;
        while(left<right)
        {
            sum+= findGcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
}