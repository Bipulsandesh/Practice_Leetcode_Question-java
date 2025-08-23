import java.util.*;

class Solution {
    private static final int INF = 1_000_000_000;

    static final class Box {
        int minr, maxr, minc, maxc, cnt;
        void reset() { minr = INF; maxr = -INF; minc = INF; maxc = -INF; cnt = 0; }
        void add(int r, int c) {
            if (r < minr) minr = r;
            if (r > maxr) maxr = r;
            if (c < minc) minc = c;
            if (c > maxc) maxc = c;
            cnt++;
        }
        int area() { return cnt == 0 ? INF : (maxr - minr + 1) * (maxc - minc + 1); }
    }

    public int minimumSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // collect ones into primitive arrays for speed
        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) k++;
        int[] rs = new int[k];
        int[] cs = new int[k];
        for (int i = 0, t = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) { rs[t] = i; cs[t] = j; t++; }

        Box b0 = new Box(), b1 = new Box(), b2 = new Box();
        int ans = INF;

        // 1) Three vertical slabs: c <= c1 | c1 < c <= c2 | c > c2
        for (int c1 = 0; c1 <= m - 3; c1++) {
            for (int c2 = c1 + 1; c2 <= m - 2; c2++) {
                b0.reset(); b1.reset(); b2.reset();
                for (int t = 0; t < k; t++) {
                    int r = rs[t], c = cs[t];
                    if (c <= c1) b0.add(r, c);
                    else if (c <= c2) b1.add(r, c);
                    else b2.add(r, c);
                }
                int a0 = b0.area(); if (a0 == INF) continue;
                int a1 = b1.area(); if (a1 == INF) continue;
                int a2 = b2.area(); if (a2 == INF) continue;
                ans = Math.min(ans, a0 + a1 + a2);
            }
        }

        // 2) Three horizontal slabs: r <= r1 | r1 < r <= r2 | r > r2
        for (int r1 = 0; r1 <= n - 3; r1++) {
            for (int r2 = r1 + 1; r2 <= n - 2; r2++) {
                b0.reset(); b1.reset(); b2.reset();
                for (int t = 0; t < k; t++) {
                    int r = rs[t], c = cs[t];
                    if (r <= r1) b0.add(r, c);
                    else if (r <= r2) b1.add(r, c);
                    else b2.add(r, c);
                }
                int a0 = b0.area(); if (a0 == INF) continue;
                int a1 = b1.area(); if (a1 == INF) continue;
                int a2 = b2.area(); if (a2 == INF) continue;
                ans = Math.min(ans, a0 + a1 + a2);
            }
        }

        // 3) Mixed: vertical cut at c; LEFT side split horizontally at rcut
        // groups: (c<=c & r<=rcut) | (c<=c & r>rcut) | (c>c)
        for (int c = 0; c <= m - 2; c++) {
            for (int rcut = 0; rcut <= n - 2; rcut++) {
                b0.reset(); b1.reset(); b2.reset();
                for (int t = 0; t < k; t++) {
                    int r = rs[t], cc = cs[t];
                    if (cc <= c) {
                        if (r <= rcut) b0.add(r, cc);
                        else b1.add(r, cc);
                    } else b2.add(r, cc);
                }
                int a0 = b0.area(); if (a0 == INF) continue;
                int a1 = b1.area(); if (a1 == INF) continue;
                int a2 = b2.area(); if (a2 == INF) continue;
                ans = Math.min(ans, a0 + a1 + a2);
            }
        }

        // 4) Mixed: vertical cut at c; RIGHT side split horizontally at rcut
        // groups: (c<=c) | (c>c & r<=rcut) | (c>c & r>rcut)
        for (int c = 0; c <= m - 2; c++) {
            for (int rcut = 0; rcut <= n - 2; rcut++) {
                b0.reset(); b1.reset(); b2.reset();
                for (int t = 0; t < k; t++) {
                    int r = rs[t], cc = cs[t];
                    if (cc <= c) b0.add(r, cc);
                    else {
                        if (r <= rcut) b1.add(r, cc);
                        else b2.add(r, cc);
                    }
                }
                int a0 = b0.area(); if (a0 == INF) continue;
                int a1 = b1.area(); if (a1 == INF) continue;
                int a2 = b2.area(); if (a2 == INF) continue;
                ans = Math.min(ans, a0 + a1 + a2);
            }
        }

        // 5) Mixed: horizontal cut at r; TOP side split vertically at ccut
        // groups: (r<=r & c<=ccut) | (r<=r & c>ccut) | (r>r)
        for (int r = 0; r <= n - 2; r++) {
            for (int ccut = 0; ccut <= m - 2; ccut++) {
                b0.reset(); b1.reset(); b2.reset();
                for (int t = 0; t < k; t++) {
                    int rr = rs[t], c = cs[t];
                    if (rr <= r) {
                        if (c <= ccut) b0.add(rr, c);
                        else b1.add(rr, c);
                    } else b2.add(rr, c);
                }
                int a0 = b0.area(); if (a0 == INF) continue;
                int a1 = b1.area(); if (a1 == INF) continue;
                int a2 = b2.area(); if (a2 == INF) continue;
                ans = Math.min(ans, a0 + a1 + a2);
            }
        }

        // 6) Mixed: horizontal cut at r; BOTTOM side split vertically at ccut
        // groups: (r<=r) | (r>r & c<=ccut) | (r>r & c>ccut)
        for (int r = 0; r <= n - 2; r++) {
            for (int ccut = 0; ccut <= m - 2; ccut++) {
                b0.reset(); b1.reset(); b2.reset();
                for (int t = 0; t < k; t++) {
                    int rr = rs[t], c = cs[t];
                    if (rr <= r) b0.add(rr, c);
                    else {
                        if (c <= ccut) b1.add(rr, c);
                        else b2.add(rr, c);
                    }
                }
                int a0 = b0.area(); if (a0 == INF) continue;
                int a1 = b1.area(); if (a1 == INF) continue;
                int a2 = b2.area(); if (a2 == INF) continue;
                ans = Math.min(ans, a0 + a1 + a2);
            }
        }

        return ans;
    }
}