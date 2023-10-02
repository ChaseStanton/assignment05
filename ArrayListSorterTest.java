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
		intList.add(0);
		intList.add(7);
		intList.add(100);
		intList.add(50);
		intList.add(75);
		intList.add(-50);
		intList.add(22);
		intList.add(30);
		intList.add(-3);
	}

	@Test
	void testMergeSort() {
		ArrayListSorter.mergesort(intList);
		assertEquals(-50, intList.get(0));
		assertEquals(-3, intList.get(2));
		assertEquals(1, intList.get(4));
		assertEquals(1, intList.get(4));

	}

}
