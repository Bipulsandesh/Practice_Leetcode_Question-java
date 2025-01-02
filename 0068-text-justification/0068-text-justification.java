class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int localMaxCount = 0;
        int wordsCount = 0;
        int p1 = 0;
        int p2 = 0;
        List<String> justified = new ArrayList<>();
        for (int i=0;i< words.length;i++){
            int currentWordLength = words[i].length();
            if (wordsCount == 0){
                //pick first word
                localMaxCount = currentWordLength;
                wordsCount=1;
                p1 = i;
                p2 = i;   
            }else if (localMaxCount + currentWordLength + 1 <= maxWidth){
                //pick next word
                localMaxCount = localMaxCount + currentWordLength + 1;
                wordsCount++;
                p2 = i;
            }else{
                //pack and reset
                //count spaces
                int remainingSpace = maxWidth - localMaxCount; //6
                StringBuilder sb = new StringBuilder();
                if (wordsCount == 1){
                    sb.append(words[p2]);
                    for (int s = 0;s<remainingSpace ; s++){
                        sb.append(" ");
                    }
                }else{
                    int remainderSpace = (remainingSpace % (wordsCount-1)) ;
                    int spaceEven =  (remainingSpace/(wordsCount-1)) + 1;
                    for (int j=p1; j<p2; j++){
                        sb.append(words[j]);
                        for (int s = 0;s<spaceEven ; s++){
                            sb.append(" ");
                        }
                        if (remainderSpace != 0){
                            sb.append(" ");
                            remainderSpace--;
                        }
                    }
                    sb.append(words[p2]);
                }
                justified.add(sb.toString());
                //reset
                 //pick first word
                localMaxCount = currentWordLength;
                wordsCount = 1;
                p1 = i;
                p2 = i;
            }
        }
        if (wordsCount > 0){
             //count spaces
                int remainingSpace = maxWidth - localMaxCount; //6
                StringBuilder sb = new StringBuilder();
                if (wordsCount == 1){
                    sb.append(words[p2]);
                    for (int s = 0;s<remainingSpace ; s++){
                        sb.append(" ");
                    }
                }else{
                    for (int j=p1; j<=p2; j++){
                        sb.append(words[j]);
                        if (j!=p2)  sb.append(" ");
                    }
                    for (int s = 0;s<remainingSpace ; s++){
                        sb.append(" ");
                    }
                }
                justified.add(sb.toString());
        }
        
        return justified;


    }
}