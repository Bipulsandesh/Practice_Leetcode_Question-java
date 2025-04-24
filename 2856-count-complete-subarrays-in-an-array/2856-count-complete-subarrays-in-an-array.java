class Solution {
    public int countCompleteSubarrays(int[] nums) {
            Map<Integer,Integer> map=new HashMap<>();
    for (int i = 0; i <nums.length; i++)
    {
      if(!map.containsKey(nums[i]))
      {
        map.put(nums[i],0);
      }
    }
    int l=0,r=0,mapSize=map.size(),count=0,ans=0;
    while (r<nums.length)
    {
      map.put(nums[r],map.getOrDefault(nums[r],0)+1);
      if(map.get(nums[r])==1)
        count+=1;

      while(count==mapSize)
      {
        ans+=nums.length-r;
        map.put(nums[l],map.getOrDefault(nums[l],0)-1);
        if(map.get(nums[l])==0)
          count-=1;
        l++;
      }
      r++;
    }
    return ans;
    }
}