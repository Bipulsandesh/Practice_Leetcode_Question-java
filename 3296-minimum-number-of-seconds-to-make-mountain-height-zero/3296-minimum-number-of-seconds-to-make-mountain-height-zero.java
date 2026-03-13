class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l=1,r=(long)(1e6+1)*(sum(mountainHeight+1));
        // System.out.println(r);
        long ans=-1;
        while(l<=r){
            long mid=(r-l)/2+l;
            if(isValid(mountainHeight,workerTimes,mid)){
                r=mid-1;
                ans=mid;
            }else l=mid+1;
        }
        return ans;
    }
    public boolean isValid(int moutainHeight,int[] workerTimes,long limit){
        long tot=0L;
        for(int i=0;i<workerTimes.length;i++){
            long t=workerTimes[i];
            long x=solve(t,t,-2*limit);
            tot+=x;
        }
        return tot>=moutainHeight;
    }
    public long sum(long n){
        return (n*(n+1))/2;
    }
    public long solve(long a,long b,long c){
        return (long)(-b+Math.sqrt(b*b-(4.0*a*c)))/(2*a);
    }
} 