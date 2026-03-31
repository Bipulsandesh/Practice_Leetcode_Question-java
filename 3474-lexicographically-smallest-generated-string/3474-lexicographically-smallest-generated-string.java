class Solution {
    public String generateString(String s1, String s2) {
        int n = s1.length(), m = s2.length(), l = n + m - 1;
        char[] a = new char[l];

        for (int i = 0; i < l; i++) a[i] = '?';

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (a[i + j] == '?' || a[i + j] == s2.charAt(j)) {
                        a[i + j] = s2.charAt(j);
                    } else return "";
                }
            }
        }

        for (int i = 0; i < l; i++) {
            if (a[i] == '?') a[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'F') {
                if (f(a, i, s2)) {
                    boolean ok = false;

                    for (int j = m - 1; j >= 0 && !ok; j--) {
                        int x = i + j;
                        char o = a[x];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == o) continue;

                            a[x] = c;

                            if (!f(a, i, s2) && g(a, s1, s2)) {
                                ok = true;
                                break;
                            }

                            a[x] = o;
                        }
                    }

                    if (!ok) return "";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean b = f(a, i, s2);
            if (s1.charAt(i) == 'T' && !b) return "";
            if (s1.charAt(i) == 'F' && b) return "";
        }

        return new String(a);
    }

    boolean f(char[] a, int i, String s) {
        for (int j = 0; j < s.length(); j++) {
            if (a[i + j] != s.charAt(j)) return false;
        }
        return true;
    }

    boolean g(char[] a, String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'T') {
                if (!f(a, i, s2)) return false;
            }
        }
        return true;
    }
}