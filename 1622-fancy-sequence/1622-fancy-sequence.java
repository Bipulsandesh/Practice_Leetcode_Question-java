class Fancy {
    int mod = 1000000007;
    List<Long> list;
    long add=0;
    long mul=1;
    public Fancy() {
        list = new ArrayList<>();
    }
    
    public void append(int val) {
        long addval = ((val-add)%mod+mod)%mod;
        addval = (addval*power(mul,mod-2))%mod;
        list.add(addval);
    }
    
    public void addAll(int inc) {
        add = (add+inc)%mod;
    }
    
    public void multAll(int m) {
        mul = (mul*m)%mod;
        add = (add*m)%mod;
    }
    
    public int getIndex(int idx) {
        if(idx>=list.size())return -1;
        long val = list.get(idx);
        return (int)((val*mul+add)%mod);
    }
    private long power(long base, long exp){
        long result=1;
        while(exp>0){
            if((exp&1)==1){
                result= (result*base)%mod;
            }
            base = (base*base)%mod;
            exp>>=1;
        }
        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */