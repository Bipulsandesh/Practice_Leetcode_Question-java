class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            double pr = (double) classes[i][0] / classes[i][1];
            double newpr = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newpr - pr;
            pq.offer(new double[] { delta, i });
        }
        while (extraStudents > 0) {
            double[] temp = pq.poll();
            double delta = temp[0];
            int idx = (int) temp[1];
            classes[idx][0]++;
            classes[idx][1]++;
            double pr = (double) classes[idx][0] / classes[idx][1];
            double newpr = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            delta = newpr - pr;
            pq.offer(new double[] { delta, idx });
            extraStudents--;

        }
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }
        return result / n;
    }
}