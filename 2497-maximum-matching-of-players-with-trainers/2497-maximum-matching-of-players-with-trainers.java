class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count=0;

        int i=0, j=0;
        while (i < players.length) {
            while (j < trainers.length && (trainers[j] < players[i])) j++;
            if (j == trainers.length) break;
            i++;
            j++;
            count++;
        }
        return count;
        
    }
}