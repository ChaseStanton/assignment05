package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListSorter {
    private static int insertionSortThreshold = 10;

    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
        ArrayList<T> temp = new ArrayList<T>(list);
        mergesort(list, temp, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list, ArrayList<T> temp, int left,
            int right) {
        if (left < right) {
            if (right - left < insertionSortThreshold) {
                insertionSort(list, left, right);
            } else {

                int mid = (left + right) / 2;
                mergesort(temp, list, left, mid);
                mergesort(temp, list, mid + 1, right);
                merge(list, temp, left, mid, right);
            }
        }

    }

    private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T current = list.get(i);
            int before = i - 1;

            while (before >= left && list.get(before).compareTo(current) > 0) {
                list.set(before + 1, list.get(before));
                before--;
            }
            list.set(before + 1, current);
        }
    }

    private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, ArrayList<T> temp, int left, int mid,
            int right) {
        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                list.set(k, temp.get(j++));
            } else if (j > right) {
                list.set(k, temp.get(i++));
            } else if (temp.get(i).compareTo(temp.get(j)) <= 0) {
                list.set(k, temp.get(i++));
            } else {
                list.set(k, temp.get(j++));
            }
        }
    }

    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
        if (list.get(0).compareTo(list.get(list.size() - 1)) < 0) {
            // int partitionIndex = partition(list, 0, list.size() - 1);

            // quicksort(list, 0, partitionIndex - 1);
            // quicksort(list, partitionIndex + 1, list.size() - 1);
        }
    }

    private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list, int low, int high) {

    }

    /**
     * This method chooses a pivot to use in the quicksort method
     * 
     * @param choice - if choice is 1, the pivot point is the first element, if
     *               choice is 2, the pivot
     *               point is at the middle, if choice is 3, the pivot point is
     *               random.
     *               
     * @return
     */
    private int choosePivot(int choice, int low, int high) {
        if (choice < 1 || choice > 3)
            throw new IllegalArgumentException("Choice must be a value of 1, 2, 3");
        if (choice == 1)
            return low;
        if (choice == 2)
            return high / 2;
        else {
            Random rand = new Random();
            return low + rand.nextInt(high - low + 1);
        }

    }

    public static ArrayList<Integer> generateAscending(int size) {
        ArrayList<Integer> ascendingList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            ascendingList.add(i);
        }

        return ascendingList;
    }

    public static ArrayList<Integer> generatePermuted(int size) {
        ArrayList<Integer> permutedList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            permutedList.add(i);
        }

        Collections.shuffle(permutedList);

        return permutedList;

    }

    public static ArrayList<Integer> generateDescending(int size) {
        ArrayList<Integer> descendingList = new ArrayList<>();

        for (int i = size; i >= 1; i--) {
            descendingList.add(i);
        }

        return descendingList;
    }

}
