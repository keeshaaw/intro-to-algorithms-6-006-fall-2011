package lecture1;

public class OneDPeak {

	static int [] inputArray = {1, 2, 3, 5, 6, 7, 16, 9, 10, 323, 324, 895};
	
	//One D Peak: if a[i] >= a[i-1] and a[i] >= a[i+1] then a[i] is local peak.
	
	
	//Approach 1: Go to each of the element of a and look for it's neighbors
	static int findPeakV1(int [] a) {
		for(int i = 0; i < a.length; i++) {
			if(i == 0 && a[i + 1] <= a[i]) {
				return i;
			}
			else if(i == a.length - 1 && a[i - 1] <= a[i]) {
				return i;
			}
			else if(i != 0 && i < a.length - 1 && a[i] >= a[i - 1] && a[i] >= a[i + 1]) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Approach 2: This approach uses divide and conquer strategy similar to Binary Search.
	 * Algorithm:
	 * 		Step 1- Select the middle element of the array i.e. a[n/2]. (n is length of the input array)
	 * 		Step 2- if a[n/2 - 1] <= a[n/2] and a[n/2 + 1] <= a[n/2] then a[n/2] is your local one D peak.
	 * 				if a[n/2 - 1] > a[n/2] and a[n/2 + 1] <= a[n/2] go to the left and repeat the process.
	 * 				if a[n/2 - 1] <= a[n/2] and a[n/2 + 1] > a[n/2] go to the right and repeat the process.
	 * 				if a[n/2 - 1] > a[n/2] and a[n/2 + 1] > a[n/2] choose a random side and repeat the process.
	 */
	public static int findPeakV2(int [] a, int start, int end) {
		if(end - start == 1) {
			if(start == 0)
				return start;
			else
				return end;
		}
		
		int i = (start + end)/2;
		if(a[i] < a[i - 1]) {
			return findPeakV2(a , start, i);
		}
		if(a[i] < a[i + 1])
			return findPeakV2(a, i, end);
		else
			return i;
	}
	
	public static void main(String[] args) {
		int result = findPeakV1(inputArray);
		System.out.println("Peak Value: " + inputArray[result] + " Position: " + result);
		
		int res = findPeakV2(inputArray, 0, inputArray.length - 1);
		System.out.println("Peak Value: " + inputArray[res]+ " Position: " + res);
	}
}
