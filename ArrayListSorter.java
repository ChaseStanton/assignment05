package assign05;

import java.util.ArrayList;

public class ArrayListSorter {
    private static final int insertionSortThreshold = 10;

    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
        int size = list.size();
        if (size < insertionSortThreshold) {
            insertionSort(list);
        } else {
            ArrayList<T> leftSide = new ArrayList<>(list.subList(0, size / 2));
            ArrayList<T> rightSide = new ArrayList<>(list.subList(size / 2, size));
            mergesort(leftSide);
            mergesort(rightSide);

            merge(list, leftSide, rightSide);
        }
    }

    private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int before = i - 1;

            while (before >= 0 && list.get(before).compareTo(current) > 0) {
                list.set(before + 1, list.get(before));
                before--;
            }
            list.set(before + 1, current);
        }
    }

    private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, ArrayList<T> left,
            ArrayList<T> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0)
                list.set(k++, left.get(i++));
            else
                list.set(k++, right.get(j++));

        }
        while (i < left.size())
            list.set(k++, left.get(i++));
        while (j < right.size())
            list.set(k++, right.get(j++));

    }

    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {

    }

    public static ArrayList<Integer> generateAscending(int size) {
        return new ArrayList<Integer>();
    }

    public static ArrayList<Integer> generatePermuted(int size) {
        return new ArrayList<Integer>();

    }

    public static ArrayList<Integer> generateDescending(int size) {
        return new ArrayList<Integer>();

    }

}
