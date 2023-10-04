package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListSorterTest {
private ArrayList<Integer> intList;
	@BeforeEach
	void setUp() throws Exception {
		intList = new ArrayList<>();
		intList.add(1);
		intList.add(-13);
		intList.add(20);
		
	}

	@Test
	void testMergeSort() {
		intList.add(0);
		intList.add(7);
		intList.add(100);
		intList.add(50);
		intList.add(75);
		intList.add(-50);
		intList.add(22);
		intList.add(30);
		intList.add(-3);
		ArrayListSorter.mergesort(intList);
		assertEquals(-50, intList.get(0));
		assertEquals(-3, intList.get(2));
		assertEquals(1, intList.get(4));
		assertEquals(1, intList.get(4));

	}
	@Test
	void testSmallListMerge() {
		ArrayListSorter.mergesort(intList);
		assertEquals(-13, intList.get(0));
		assertEquals(1, intList.get(1));
		assertEquals(20, intList.get(2));
	}
	@Test
	void testquickSort() {
		intList.add(0);
		intList.add(7);
		intList.add(100);
		intList.add(50);
		intList.add(75);
		intList.add(-50);
		intList.add(22);
		intList.add(30);
		intList.add(-3);
		ArrayListSorter.quicksort(intList);
		assertEquals(-50, intList.get(0));
		assertEquals(-3, intList.get(2));
		assertEquals(1, intList.get(4));
		assertEquals(1, intList.get(4));
	}
	@Test
	void testSmallListQuick() {
		ArrayListSorter.quicksort(intList);
		assertEquals(-13, intList.get(0));
		assertEquals(1, intList.get(1));
		assertEquals(20, intList.get(2));
	}
	@Test
	void testGenerateAscending() {
		ArrayList<Integer> ascendingList = ArrayListSorter.generateAscending(5);
		assertEquals(5, ascendingList.get(4));
		assertEquals(1, ascendingList.get(0));
		assertEquals(2, ascendingList.get(1));

	}
	@Test
	void testGenerateDescending() {
		ArrayList<Integer> descendingList = ArrayListSorter.generateDescending(5);
		assertEquals(1, descendingList.get(4));
		assertEquals(5, descendingList.get(0));
		assertEquals(4, descendingList.get(1));
	}
	@Test
	void testGeneratePermuted() {
		ArrayList<Integer> permutedList = ArrayListSorter.generatePermuted(5);
		assertTrue(permutedList.get(4) <= 5 && permutedList.get(4) >= 1);
		assertTrue(permutedList.get(4) <= 5 && permutedList.get(0) >= 1);
		assertTrue(permutedList.get(4) <= 5 && permutedList.get(1) >= 1);
	}
	@Test
	void testSingleElementGenerateAscending() {
		ArrayList<Integer> singleElement = ArrayListSorter.generateAscending(1);
		assertEquals(1, singleElement.get(0));

	}
	@Test
	void testSingleElementGeneratePermuted() {
		ArrayList<Integer> singleElement = ArrayListSorter.generatePermuted(1);
		assertEquals(1, singleElement.get(0));
	}
	@Test
	void testSingleElementGenerateDescending() {
		ArrayList<Integer> singleElement = ArrayListSorter.generateDescending(1);
		assertEquals(1, singleElement.get(0));
	}
}
