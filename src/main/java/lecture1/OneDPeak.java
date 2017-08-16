package lecture1;

public class OneDPeak {

	static int [] a = {1, 2, 3, 5, 6, 7, 8, 9, 10, 323, 324, 895};
	
	//One D Peak: if a[i] >= a[i-1] and a[i] >= a[i+1] then a[i] is local peak.
	
	
	//Approach 1: Go to each of the element of a and look for it's neighbors
	public static int findPeakV1(int [] in) {
		for(int i = 0; i < in.length; i++) {
			if(i == 0 && in[i] >= in[i + 1]) {
				return in[i];
			} else if(i == in.length - 1 && in[i - 1] <= in[i]) {
				return in[i];
			} else {
				if(i > 0 && i < in.length - 1 && in[i] >= in[i - 1] && in[i] >= in[i + 1]) {
					return in[i];
				}
			}
		}
		return 0;
	}
	
	/**
	 * Approach 2: This approach uses divide and conquer strategy similar to Binary Search.
	 * Algorithm:
	 * 		Step 1- Select the middle element of the array i.e. a[n/2]
	 * 		Step 2- if a[n/2 - 1] <= a[n/2] and a[n/2 + 1] <= a[n/2] then a[n/2] is your local one D peak.
	 * 				if a[n/2 - 1] > a[n/2] and a[n/2 + 1] <= a[n/2] go to the left and repeat the process.
	 * 				if a[n/2 - 1] <= a[n/2] and a[n/2 + 1] > a[n/2] go to the right and repeat the process.
	 * 				if a[n/2 - 1] > a[n/2] and a[n/2 + 1] > a[n/2] choose a random side and repeat the process.
	 */
	public static int findPeakV2(int [] in, int start, int end) {
		int middle = (start + end) / 2;
		int peak = 0;
		if(in[middle - 1] <= in[middle] && in[middle + 1] <= in[middle]) {
			peak = in[middle];
		} else if(in[middle - 1] > in[middle] && in[middle + 1] <= in[middle]) {
			findPeakV2(in, 0, middle - 1);
		} else if(in[middle - 1] <= in[middle] && in[middle + 1] > in[middle]) {
			findPeakV2(in, middle + 1, in.length);
		}
		return peak;
	}
	
	
	public static void main(String[] args) {
		System.out.println(findPeakV1(a));
		System.out.println(findPeakV2(a, 0, a.length));
	}
}
