class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){

            if(i > 0 && nums[i-1] == nums[i])
                continue;

            for(int j =i+1;j<n-2;j++){

                if(j > i+1 && nums[j-1] == nums[j])
                    continue;
                int li = j+1;
                int ri = n-1;

                while(li<ri){
                    long sum = nums[i]+nums[j];
                    sum += nums[li]+nums[ri];

                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[li],nums[ri]));

                        li++;
                        ri--;

                        while(li < ri && nums[li-1] == nums[li])li++;

                        while(li<ri && nums[ri+1] == nums[ri]) ri--;
                    } else if(sum < target){
                        li++;
                    }else{
                        ri--;
                    }
                }
            }
        }
        return ans;
    }
}