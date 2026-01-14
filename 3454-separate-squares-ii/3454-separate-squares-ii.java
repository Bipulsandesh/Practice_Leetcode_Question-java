import java.util.*;

class SegmentTree {
    int n;
    int[] xs;
    int[] coveredCount;
    long[] coveredWidth;

    SegmentTree(int[] xs) {
        this.xs = xs;
        this.n = xs.length - 1;
        this.coveredCount = new int[4 * n];
        this.coveredWidth = new long[4 * n];
    }

    // Add val to range [l, r)
    public void add(int l, int r, int val) {
        add(0, 0, n - 1, l, r, val);
    }

    public long getCoveredWidth() {
        return coveredWidth[0];
    }

    private void add(int idx, int lo, int hi, int l, int r, int val) {
        if (r <= xs[lo] || xs[hi + 1] <= l) return;

        if (l <= xs[lo] && xs[hi + 1] <= r) {
            coveredCount[idx] += val;
        } else {
            int mid = (lo + hi) / 2;
            add(2 * idx + 1, lo, mid, l, r, val);
            add(2 * idx + 2, mid + 1, hi, l, r, val);
        }

        if (coveredCount[idx] > 0) {
            coveredWidth[idx] = (long) xs[hi + 1] - xs[lo];
        } else if (lo == hi) {
            coveredWidth[idx] = 0;
        } else {
            coveredWidth[idx] =
                    coveredWidth[2 * idx + 1] + coveredWidth[2 * idx + 2];
        }
    }
}

class Solution {
    static class Event implements Comparable<Event> {
        int y, delta, xl, xr;

        Event(int y, int delta, int xl, int xr) {
            this.y = y;
            this.delta = delta;
            this.xl = xl;
            this.xr = xr;
        }

        public int compareTo(Event o) {
            return Integer.compare(this.y, o.y);
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        TreeSet<Integer> xsSet = new TreeSet<>();

        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], l = sq[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
            xsSet.add(x);
            xsSet.add(x + l);
        }

        Collections.sort(events);

        int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
        double halfArea = getArea(events, xs) / 2.0;

        long area = 0;
        int prevY = 0;
        SegmentTree tree = new SegmentTree(xs);

        for (Event e : events) {
            long coveredWidth = tree.getCoveredWidth();
            long areaGain = coveredWidth * (long) (e.y - prevY);

            if (area + areaGain >= halfArea) {
                return prevY + (halfArea - area) / coveredWidth;
            }

            area += areaGain;
            tree.add(e.xl, e.xr, e.delta);
            prevY = e.y;
        }

        throw new RuntimeException("Should not reach here");
    }

    private long getArea(List<Event> events, int[] xs) {
        long totalArea = 0;
        int prevY = 0;
        SegmentTree tree = new SegmentTree(xs);

        for (Event e : events) {
            totalArea += tree.getCoveredWidth() * (long) (e.y - prevY);
            tree.add(e.xl, e.xr, e.delta);
            prevY = e.y;
        }
        return totalArea;
    }
}