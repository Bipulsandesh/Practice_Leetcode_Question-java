class Solution {
    public int mostBooked(int n, int[][] meetings) {
    PriorityQueue<Long> availRooms = new PriorityQueue<Long>();
    PriorityQueue<Long[]> assignQ = new PriorityQueue<Long[]>((a, b)-> Long.compare(a[1], b[1]));
    int roomMeetingCount[] = new int[n];
        
    for(int i=0; i<n; i++)
    availRooms.add((long)i);
    Arrays.sort(meetings, (a, b)-> a[0]-b[0]);
            
    long currTime = 0;
        
    for(int i=0; i<meetings.length; i++)
    {
      currTime = (long)Math.max(meetings[i][0], currTime);
        
      if(availRooms.isEmpty())
      {
        currTime = (long)Math.max(currTime, assignQ.peek()[1]);  
      }
        
      while(!assignQ.isEmpty() && currTime>=assignQ.peek()[1])
      {
        availRooms.add((long)assignQ.peek()[2]);
        assignQ.poll();  
      }
         long roomId = availRooms.poll(); 
         roomMeetingCount[(int)roomId] += 1;  
         assignQ.offer(new Long[]{currTime, currTime+(long)(meetings[i][1]-meetings[i][0]), roomId});
                   
    }
        
    int max = -1 ;
    int index = 0;     
    for(int p=0; p<n; p++) 
    {
      if(max<roomMeetingCount[p]) 
      {
          max=roomMeetingCount[p];
          index = p ;
      }
    }
        return index ; 
        
    }
}