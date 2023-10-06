package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

	@Test
	void testEmptyListMergeSort() {
		ArrayListSorter.mergesort(intList);
		ArrayList<Integer> emptyList = new ArrayList<>();
		ArrayListSorter.mergesort(emptyList);
		assertTrue(emptyList.isEmpty());
	}

	@Test
	void testEmptyListQuickSort() {
		ArrayListSorter.quicksort(intList);
		ArrayList<Integer> emptyList = new ArrayList<>();
		ArrayListSorter.quicksort(emptyList);
		assertTrue(emptyList.isEmpty());
	}

	@Test
	void testNegativeSizeGenerateAscending() {
		assertThrows(IllegalArgumentException.class, () -> ArrayListSorter.generateAscending(-5));
	}

	@Test
	void testNegativeSizeGenerateDescending() {
		assertThrows(IllegalArgumentException.class, () -> ArrayListSorter.generateDescending(-5));
	}

	@Test
	void testLargeListMergeSort() {
		int size = 1000000;
		ArrayList<Integer> ascendingList = ArrayListSorter.generateAscending(size);
		Collections.shuffle(ascendingList);
		ArrayListSorter.mergesort(ascendingList);
		assertTrue(isSortedAscending(ascendingList));
	}

	@Test
	void testLargeListQuickSort() {
		int size = 1000000;
		ArrayList<Integer> ascendingList = ArrayListSorter.generateAscending(size);
		Collections.shuffle(ascendingList);
		ArrayListSorter.quicksort(ascendingList);
		assertTrue(isSortedAscending(ascendingList));
	}

	private boolean isSortedAscending(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) > list.get(i)) {
				return false;
			}
		}
		return true;
	}

	@Test
	void testListWithDuplicatesQuickSort() {
		ArrayList<Integer> duplicateList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
		ArrayListSorter.quicksort(duplicateList);
		assertEquals(1, duplicateList.get(0));
		assertEquals(1, duplicateList.get(1));
		assertEquals(2, duplicateList.get(2));
		assertEquals(3, duplicateList.get(3));
		assertEquals(3, duplicateList.get(4));
		assertEquals(4, duplicateList.get(5));
		assertEquals(5, duplicateList.get(6));
		assertEquals(5, duplicateList.get(7));
		assertEquals(5, duplicateList.get(8));
		assertEquals(6, duplicateList.get(9));
		assertEquals(9, duplicateList.get(10));
	}

	@Test
	void testListWithDuplicatesMergeSort() {
		ArrayList<Integer> duplicateList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
		ArrayListSorter.mergesort(duplicateList);
		assertEquals(1, duplicateList.get(0));
		assertEquals(1, duplicateList.get(1));
		assertEquals(2, duplicateList.get(2));
		assertEquals(3, duplicateList.get(3));
		assertEquals(3, duplicateList.get(4));
		assertEquals(4, duplicateList.get(5));
		assertEquals(5, duplicateList.get(6));
		assertEquals(5, duplicateList.get(7));
		assertEquals(5, duplicateList.get(8));
		assertEquals(6, duplicateList.get(9));
		assertEquals(9, duplicateList.get(10));
	}

}
