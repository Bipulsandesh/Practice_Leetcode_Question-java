class Solution {
    public int maxDiff(int num) {
        int min=0;
        int max=0;
        int mindig=1;
        int maxdig=9;
        int original=num;

        while( num>0){
            int dig= num%10;
            if(dig!=9)maxdig=dig;
            mindig=dig;
            num=num/10;
        }
        int i=1;
        num=original;

        if(mindig!=1){

            while(num>0){
                int dig= num%10;
                if(dig==maxdig){
                    max += 9*i;
                }
                else{
                    max += dig*i;
                }

                if(dig==mindig){
                    min += 1*i;
                }
                 else{
                    min += dig*i;
                }
                i*=10;
                num=num/10;
            }
        }

       else{
            while( num>0){
                int dig= num%10;
                if(dig!=1 && dig!=0)mindig=dig;
                num=num/10;
            }
            if(mindig==1)mindig=0;

            num=original;

            while( num>0){
                int dig= num%10;
                if(dig==maxdig){
                    max += 9*i;
                }
                else{
                    max += dig*i;
                }

                if(dig!=mindig){
                    min += dig*i;
                }
                i*=10;
                num=num/10;
            }
       }

        return max-min;
    }
}