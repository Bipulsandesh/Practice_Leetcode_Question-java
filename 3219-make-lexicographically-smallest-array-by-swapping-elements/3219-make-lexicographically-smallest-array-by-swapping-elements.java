class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        Map<Integer,Queue<Integer>> map=new HashMap<>();

        int arr[]=nums.clone();
        Arrays.sort(arr);
        Queue<Integer> q=new LinkedList<>();
        q.offer(arr[0]);
        map.put(arr[0],q);
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<=limit) q=map.get(arr[i-1]);
            else q=new LinkedList<>();
            q.offer(arr[i]);
            map.put(arr[i],q);
        }
        for(int i=0;i<n;i++){
            q=map.get(nums[i]);
            nums[i]=q.poll();
        }
        return nums;
    }
}