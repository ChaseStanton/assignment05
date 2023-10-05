package assign05;

import java.util.ArrayList;


public class ArrayListSorterTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, stopTime, midPointTime;
    	midPointTime= 0;
    	stopTime = 0;

        int timesToLoop = 1000;
        int initialListSize = 1; // Initial total number of small arrays in the list
        int listLimit = 1001;

        System.out.println("List Size\tAverage Time");
        startTime = System.nanoTime();
        for (int listSize = initialListSize; listSize <= listLimit; listSize += 100) {

            for (int run = 0; run < timesToLoop; run++) {
                // Generate a list of small Integer[] arrays
                ArrayList<Integer> list = new ArrayList<>();

                
                    list = ArrayListSorter.generatePermuted(listSize); // Adjust the range as needed
                    
                
                
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
