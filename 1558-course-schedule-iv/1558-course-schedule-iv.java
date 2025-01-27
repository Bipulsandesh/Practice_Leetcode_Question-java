class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] outdegree = new int[numCourses];
        List<Integer>[] incoming = getIncoming(numCourses, prerequisites, outdegree);
        boolean[][] required = new boolean[numCourses][numCourses];
        processPrerequisites(incoming, outdegree, required);
        List<Boolean> answer = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            answer.add(required[query[1]][query[0]]);
        }
        return answer;
    }

    private void processPrerequisites(List<Integer>[] incoming, int[] outdegree, boolean[][] required) {
        Queue<Integer> nodesInQueue = getZeroOutdegree(outdegree);
        boolean[] visited = new boolean[incoming.length];
        int size = 0;
        int currentNode;
        while (!nodesInQueue.isEmpty()) {
            size = nodesInQueue.size();
            while (size > 0) {
                currentNode = nodesInQueue.poll();
                visited[currentNode] = true;
                if (incoming[currentNode] != null) {
                    for (int nextToVisit : incoming[currentNode]) {
                        outdegree[nextToVisit]--;
                        copyRequirements(currentNode, nextToVisit, required);
                        if (outdegree[nextToVisit] == 0 && !visited[nextToVisit]) {
                            nodesInQueue.add(nextToVisit);
                        }
                    }
                }
                size--;
            }
        }
    }

    private void copyRequirements(int requiredCourse, int openCourse, boolean[][] required) {
        for (int j = 0; j < required.length; j++) {
            required[openCourse][j] = required[openCourse][j] || required[requiredCourse][j];
        }
        required[openCourse][requiredCourse] = true;
    }

    private Queue<Integer> getZeroOutdegree(int[] outdegree) {
        Queue<Integer> zeroOutdegree = new LinkedList<>();
        for (int i = 0; i < outdegree.length; i++) {
            if (outdegree[i] == 0) {
                zeroOutdegree.add(i);
            }
        }
        return zeroOutdegree;
    }

    private List<Integer>[] getIncoming(int courses, int[][] prerequisites, int[] outdegree) {
        List<Integer>[] incoming = new List[courses];
        for (int[] req : prerequisites) {
            outdegree[req[1]]++;
            if (incoming[req[0]] == null) {
                incoming[req[0]] = new ArrayList<>();
            }
            incoming[req[0]].add(req[1]);
        }
        return incoming;
    }
}

      