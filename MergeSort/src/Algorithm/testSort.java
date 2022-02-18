package Algorithm;


public class testSort {
	
	//tests selection sort for ordered, unordered and arrays with always the same elements
	private static void test0() {
		String errorMsg0 = "Test0 - Fail - ordered array";
		String errorMsg1 = "Test0 - Fail - unordered array";
		String errorMsg2 = "Test0 - Fail - array with same elements";
		int[] orderedArray = helperMethods.createSortedArrayInts(50);
		int[] unorderedArray = helperMethods.createUnsortedArrayInts(50);
		helperMethods.printArray(unorderedArray);
		int[] sameElmtsArray = helperMethods.createSameElmtsArrayInts(50);
		MergeSort.sort(orderedArray);
		MergeSort.sort(unorderedArray);	
		helperMethods.printArray(unorderedArray);
		MergeSort.sort(sameElmtsArray);
		assert helperMethods.isSortedInts(orderedArray) : errorMsg0;
		assert helperMethods.isSortedInts(unorderedArray) : errorMsg1;
		assert helperMethods.isSortedInts(sameElmtsArray) : errorMsg2;
		System.out.println("Test0 - Success");
	}
	
	//speed test using doubling reason
	private static void test1() {
		int n = (int) Math.pow(2,20); //max number of elements
		System.out.println("Testing sort times for unsorted arrays of doubling size...");
		double lastTime = 1;
		for(int i = 1; i <= n; i*=2) {
			int[] arr0 = helperMethods.createUnsortedArrayInts(i);
			double time1 = System.nanoTime();
			MergeSort.sort(arr0);
			double time2 = System.nanoTime();
			double newTime = time2 - time1;
			double doubledReason = newTime/lastTime;
			lastTime = newTime;
			if(i > 1)
				System.out.println(i + "n   " + newTime/1000 + "ms   " + doubledReason + "r");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("TESTING Merge sort...        (~�^�)~ ");
		test0();
		test1();
		System.out.println("ALL TESTS PASSED!                /(^-^)/");
	}
	
}