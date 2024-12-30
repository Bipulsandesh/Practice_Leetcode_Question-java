class Solution {
    public double myPow(double x, int n) {
        //recursion approach 
        long nn=n;
        if(nn==0)
        return 1;
        if(nn<0)//checking for the negative value ...very very important 
{
    x=1/x;
    nn=-nn;
}//divide and conqure approach 
double half= myPow(x,(int)(nn/2));
if(nn%2==0)
{
    return half*half;
}
else
{
    return half*half*x;
}

    }
}