class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> freq = new HashMap<>();
        int ans = 0;

        for(int i=0; i<answers.length; i++){
            freq.put( answers[i] , freq.getOrDefault(answers[i],0)+1 );
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int num = entry.getKey();
            int frq = entry.getValue();
            while(frq>0){
                ans+= (num+1);
                frq-= (num+1);
            }
        }
        return ans;
    }
}