class Solution {
    public long pow(long a, long b, int mod) {
    long res = 1;
    while (b > 0) {
        if (b % 2 == 1) {  
            res = (res * a) % mod;
        }
        a = (a * a) % mod;  
        b = b / 2;          
    }
    return res;
}

    public long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }
    public int[] productQueries(int n, int[][] queries) 
    {
        int mod=(int)1e9+7;
        ArrayList<Integer>powers=new ArrayList<>();
        if(n%2==1)
        {
            powers.add(1);

            n--;
        }
        
        int pow=2;

        while(pow<=n)
        {
            pow*=2;
        }
        if(pow>n)
        {
            pow/=2;
        }

        while(n>0)
        {
            if(n>=pow)
            {
            powers.add(pow);
            n-=pow;
        }
            pow/=2;
        }
        Collections.sort(powers);
       long[] prepro = new long[powers.size()];
        prepro[0] = powers.get(0) % mod;
        for (int i = 1; i < powers.size(); i++) {
            prepro[i] = (prepro[i - 1] * powers.get(i)) % mod;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long ans = prepro[r];
            if (l > 0) {
                ans = (ans * modInverse(prepro[l - 1], mod)) % mod;
            }
            res[i] = (int)ans;
        }
        return res;
    }

        
    }