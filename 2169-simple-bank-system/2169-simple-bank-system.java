class Bank {
    private long[] bal; // balances stored 0-indexed, accounts are 1-indexed

    // Helper: check if account is valid (1-based)
    private boolean valid(int acc) {
        return acc >= 1 && acc <= bal.length;
    }

    // Constructor
    public Bank(long[] balance) {
        // Defensive copy to avoid external mutation
        this.bal = new long[balance.length];
        System.arraycopy(balance, 0, this.bal, 0, balance.length);
    }

    // Transfer money between accounts
    public boolean transfer(int from, int to, long money) {
        if (!valid(from) || !valid(to)) return false;
        if (bal[from - 1] < money) return false;
        bal[from - 1] -= money;
        bal[to - 1] += money;
        return true;
    }

    // Deposit money into account
    public boolean deposit(int acc, long money) {
        if (!valid(acc)) return false;
        bal[acc - 1] += money;
        return true;
    }

    // Withdraw money from account
    public boolean withdraw(int acc, long money) {
        if (!valid(acc)) return false;
        if (bal[acc - 1] < money) return false;
        bal[acc - 1] -= money;
        return true;
    }
}