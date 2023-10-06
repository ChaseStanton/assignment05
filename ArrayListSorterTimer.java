package assign05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ArrayListSorterTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, stopTime, midPointTime;
    	midPointTime= 0;
    	stopTime = 0;

        int timesToLoop = 1000;
        int initialListSize = 1; // Initial total number of small arrays in the list
        int listLimit = 10000;

        System.out.println("List Size\tAverage Time");
        startTime = System.nanoTime();
        
        ArrayList<Integer> permutedList = ArrayListSorter.generatePermuted(listLimit);
        
        for (int listSize = initialListSize; listSize <= listLimit; listSize += 500) {
            for (int run = 0; run < timesToLoop; run++) {
                // Create a sublist of the permuted list with the desired size
                ArrayList<Integer> list = new ArrayList<>(permutedList.subList(0, listSize));
                
                    
                
                
                midPointTime = System.nanoTime();

                // Use the findKthLargest method on the generated list
                ArrayListSorter.mergesort(list);
                
                for(long i = 0; i < timesToLoop; i++) { // empty block
        		}
                stopTime = System.nanoTime();

                // Compute the time and average it over the number of runs.
                double elapsedTime = (stopTime - midPointTime) / 1e6; // Convert to milliseconds
                double averageTime = ((midPointTime - startTime) - (stopTime - midPointTime)) / timesToLoop;

            }

            // Calculate and print the average execution time for the current list size.
            double averageTime = ((midPointTime - startTime) - (stopTime - midPointTime)) / timesToLoop;
            System.out.println(listSize + "\t" + averageTime);
        }
	}

}
