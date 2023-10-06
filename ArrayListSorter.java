package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * This class represents a sorter that sorts generic ArrayLists with merge sort or quick sort. This class also generates ArrayLists in 
 * random, ascending, and descending order
 * @author Chase Stanton and Reece Kalmar
 * @version 10/4/2023
 *
 */
public class ArrayListSorter {
    private static int insertionSortThreshold = 0;

    /**
     * This method sorts the ArrayList given in the parameter
     * @param <T> - the type of the ArrayList
     * @param list - the list of type T to be sorted
     */
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
        ArrayList<T> temp = new ArrayList<T>(list);
        mergesort(list, temp, 0, list.size() - 1);
    }
    /**
     * This method uses insertion sort if the list that needs to be sorted is smaller than the insertion sort threshold
     * and recursively calls merge sort if not
     * @param <T> - The type of the ArrayList
     * @param list - the list to be sorted
     * @param temp - a temporary ArrayList that is the same as the list
     * @param left - the leftmost index of the list
     * @param right - the rightmost index of the list
     */
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
    /**
     * This method sorts part of the list using an insertion sort.
     * @param <T> - The type of ArrayList
     * @param list - the list to be sorted
     * @param left - the leftmost index that needs to be sorted
     * @param right - the rightmost index that needs to be sorted
     */
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
    /**
     * This method compares the two lists and merges hem.
     * @param <T> - The type of ArrayList
     * @param list - the list to be sorted
     * @param temp - the temporary ArrayList
     * @param left - the leftmost index of the list
     * @param mid - the middle of the list
     * @param right - the rightmost index of the list
     */
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
    /**
     * This method calls the private driver method of quicksort 
     * @param <T> - The type of the ArrayList
     * @param list - The ArrayList to be sorted
     */
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
         quicksort(list, 0, list.size() - 1);
        }
    
    /**
     * This method uses partition to swap elements of the list.
     * @param <T> - The type of ArrayList
     * @param list - The list to be sorted
     * @param low - the lower index of the list
     * @param high - the higher index of the list
     */
    private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list, int low, int high) {
       // if (low < 0 || low > list.size() || high < 0 || high > list.size() || low > high){
          //  throw new IllegalArgumentException("Your low must be less than your high parameter and/or must be inside the range of your list");
      //  }
        if (low < high) {
            int partitionIndex = partitionMiddle(list, low, high);

            quicksort(list, low, partitionIndex - 1);
            quicksort(list, partitionIndex + 1, high);
        }
    }

    /**
     * This method chooses a pivot to use in the quicksort method
     * 
     * @param choice - if choice is 1, the pivot point is the first element, if
     *               choice is 2, the pivot
     *               point is at the middle, if choice is 3, the pivot point is
     *               random.
     * 
     * @return an int that is the pivot index to be used
     */
    private static int choosePivot(int choice, int low, int high) {
        if (choice < 1 || choice > 3)
            throw new IllegalArgumentException("Choice must be a value of 1, 2, 3 , 4");
        if (choice == 1)
            return low;
        if (choice == 2)
            return  (high - low) / 2;
        if (choice == 4){
            Random rand = new Random();
            return choosePivot(rand.nextInt(3) + 1, low, high);
        }
        else {
            Random rand = new Random();
            return low + rand.nextInt(high - low + 1);
        }

    }
    /**
     * T
     * @param <T>
     * @param list
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable<? super T>> int partitionRandom(ArrayList<T> list, int low, int high) {
        int pivotIndex = choosePivot(3, low, high);
        T pivot = list.get(pivotIndex);
        list.set(pivotIndex, list.get(high));
        int i = low;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }
        list.set(high, list.get(i));
        list.set(i, pivot);
        return i;
        

    }
    private static <T extends Comparable<? super T>> int partitionFirstElement(ArrayList<T> list, int low, int high) {
        int pivotIndex = choosePivot(1, low, high);
        T pivot = list.get(pivotIndex);
        list.set(pivotIndex, list.get(high));
        int i = low;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }
        list.set(high, list.get(i));
        list.set(i, pivot);
        return i;
    }
    private static <T extends Comparable<? super T>> int partitionMiddle(ArrayList<T> list, int low, int high) {
        int pivotIndex = choosePivot(2, low, high);
        T pivot = list.get(pivotIndex);
        list.set(pivotIndex, list.get(high));
        int i = low;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }
        list.set(high, list.get(i));
        list.set(i, pivot);
        return i;
    }

    public static ArrayList<Integer> generateAscending(int size) {
    	if(size <= 0)
    		throw new IllegalArgumentException("The size must be greater than 0");
        ArrayList<Integer> ascendingList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            ascendingList.add(i);
        }

        return ascendingList;
    }

    public static ArrayList<Integer> generatePermuted(int size) {
    	if(size <= 0)
    		throw new IllegalArgumentException("The size must be greater than 0");
        ArrayList<Integer> permutedList = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            permutedList.add(i);
        }

        Collections.shuffle(permutedList);

        return permutedList;

    }

    public static ArrayList<Integer> generateDescending(int size) {
    	if(size <= 0)
    		throw new IllegalArgumentException("The size must be greater than 0");
        ArrayList<Integer> descendingList = new ArrayList<>();

        for (int i = size; i >= 1; i--) {
            descendingList.add(i);
        }

        return descendingList;
    }

}
