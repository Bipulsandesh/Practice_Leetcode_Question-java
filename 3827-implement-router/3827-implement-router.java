class Router {

    class Packet {
        public int source, dest, timestamp;
        Packet(int source, int dest, int timestamp) {
            this.source = source;
            this.dest = dest;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            Packet packet = (Packet) obj;
            return source == packet.source &&
                    dest == packet.dest &&
                    timestamp == packet.timestamp;
        }

        @Override public int hashCode() {
        //Don’t use memory address. Instead, compute a number based on the fields that define equality.
            return Objects.hash(source, dest, timestamp);
        }
    }

    HashSet<Packet> hset;                  
    Deque<Packet> dq;                               // FIFO queue
    HashMap<Integer, List<Integer>> destmap;        // dest → sorted timestamps
    int limit;
    public Router(int memoryLimit) {
        limit = memoryLimit;
        hset = new HashSet<>();
        dq = new ArrayDeque<>();
        destmap = new HashMap<>();
    }
    
    public boolean addPacket(int source, int dest, int timestamp) {
        Packet packet = new Packet(source, dest, timestamp);

        // checking for duplicate packet
        if(hset.contains(packet)) {
            return false;
        }

        // evict the oldest packet if limit is reached
        if(dq.size() == limit) {
            Packet p = dq.remove();
            hset.remove(p);

            List<Integer> timestamps = destmap.get(p.dest); // O(n)

            timestamps.remove(0);
            if (timestamps.isEmpty()) {
                destmap.remove(p.dest);
            }
        }

         // add new packet
        hset.add(packet);
        dq.offer(packet);

        destmap.computeIfAbsent(dest, k -> new ArrayList<>());
        destmap.get(dest).add(timestamp);

        return true;
    }


    public int[] forwardPacket() {

        // O(1)
        if (dq.isEmpty()) {
            return new int[0];
        }

        Packet p = dq.remove();
        hset.remove(p);

        List<Integer> timestamps = destmap.get(p.dest); 
        
        timestamps.remove(0); // O(n)
        if (timestamps.isEmpty()) {
            destmap.remove(p.dest);
        }

        return new int[]{p.source, p.dest, p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
         if (!destmap.containsKey(destination)) {
            return 0;
        }

        List<Integer> list = destmap.get(destination);
        int left = lowerBound(list, startTime);           // first ≥ startTime
        int right = upperBound(list, endTime);            // first > endTime
        return right - left;
    }


    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int target) {

        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

/**
 Example Explaination:

 Router Memory Table (size: 3)

| **Queue Order (FIFO)** | **Source** | **Destination** | **Timestamp** |
| ---------------------- | ---------- | --------------- | ------------- |
| 3                      | 3          | 5               | 95            |
| 4                      | 4          | 5               | 105            |
| 5                      | 5          | 2               | 110            |


Data Structures:
1. FIFO Queue Deque [p1, p2, p3, p4]
2. HashSet - to check for duplicate packets
3. Dest --> [list of timestamps] [MAP]

add packet
    [1,4,90]
    [2,5,90]
    [1,4,90] X 
    [3,5,95] 
    [4,5,105]
<--forward packet-->
add packet
    [5,2,110]
get count [5,100,110] = 1


 */