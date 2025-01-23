class Solution {
    public String largestNumber(int[] nums) {
        
        String [] numStr=new String[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            numStr[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(numStr, (a, b)->(b+a).compareTo(a+b));

    if(numStr[0].equals("0")) {return "0";}

    StringBuilder largeNum=new StringBuilder();
    for(String str:numStr)
    {
        largeNum.append(str);
    }

    return largeNum.toString();
    }
}