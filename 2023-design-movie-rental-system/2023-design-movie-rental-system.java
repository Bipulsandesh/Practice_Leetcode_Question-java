class MovieRentingSystem {
    static class Rental {
        int shop, movie, price;
        Rental(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
    }

    private final Comparator<Rental> comparator = (a, b) -> {
        if (a.price != b.price) return Integer.compare(a.price, b.price);
        if (a.shop != b.shop) return Integer.compare(a.shop, b.shop);
        return Integer.compare(a.movie, b.movie);
    };

    private final Map<Integer, TreeSet<Rental>> available = new HashMap<>();
    private final TreeSet<Rental> rented = new TreeSet<>(comparator);
    private final Map<Long, Rental> lookup = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            Rental rental = new Rental(entry[0], entry[1], entry[2]);
            long key = ((long) entry[0] << 32) | entry[1];
            lookup.put(key, rental);
            available.computeIfAbsent(entry[1], k -> new TreeSet<>(comparator))
                   .add(rental);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Rental> set = available.get(movie);
        if (set == null) return result;
        
        Iterator<Rental> it = set.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            result.add(it.next().shop);
        }
        return result;
    }

    public void rent(int shop, int movie) {
        long key = ((long) shop << 32) | movie;
        Rental rental = lookup.get(key);
        if (rental == null) return;
        
        TreeSet<Rental> set = available.get(movie);
        if (set != null) set.remove(rental);
        rented.add(rental);
    }

    public void drop(int shop, int movie) {
        long key = ((long) shop << 32) | movie;
        Rental rental = lookup.get(key);
        if (rental == null) return;
        
        rented.remove(rental);
        available.computeIfAbsent(movie, k -> new TreeSet<>(comparator))
                .add(rental);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Rental> it = rented.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            Rental rental = it.next();
            result.add(Arrays.asList(rental.shop, rental.movie));
        }
        return result;
    }
}