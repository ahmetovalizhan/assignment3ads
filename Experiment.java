public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    // время сортировки
    public long measureSortTime(int[] arr, String type) {

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        return System.nanoTime() - start;
    }

    // время поиска
    public long measureSearchTime(int[] arr, int target) {

        long start = System.nanoTime();

        searcher.search(arr, target);

        return System.nanoTime() - start;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            int[] random = sorter.generateRandomArray(size);

            int[] sorted = random.clone();
            sorter.advancedSort(sorted); // сначала сортируем

            System.out.println("\nSize: " + size);

            System.out.println("Bubble random: " +
                    measureSortTime(random.clone(), "basic"));

            System.out.println("Merge random: " +
                    measureSortTime(random.clone(), "advanced"));

            System.out.println("Bubble sorted: " +
                    measureSortTime(sorted.clone(), "basic"));

            System.out.println("Merge sorted: " +
                    measureSortTime(sorted.clone(), "advanced"));

            System.out.println("Search: " +
                    measureSearchTime(sorted, sorted[size / 2]));
        }
    }
}