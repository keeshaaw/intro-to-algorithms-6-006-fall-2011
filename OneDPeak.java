package lecture1;

public class OneDPeak {

	static int [] inputArray = {1, 3, 0, 4, 2, 3, 6, 9, 1, 0};
	
	static int [] findPeakV1(int [] a) {
		int [] result = new int[2];
		
		for(int i = 0; i < a.length; i++) {
			if(i == 0 && a[i + 1] <= a[i]) {
				result[0] = a[i];
				result[1] = i;
				return result;
			}
			
			if(i == a.length - 1 && a[i - 1] <= a[i]) {
				result[0] = a[i];
				result[1] = i;
				return result;
			}
			
			if(i != 0 && i < a.length - 1 && a[i] >= a[i - 1] && a[i] >= a[i + 1]) {
				result[0] = a[i];
				result[1] = i;
				return result;
			}
		}
		return result;
	}
	
	/*static int [] findPeakV2(int[] a) {
		if()
	}*/
	
	public static void main(String[] args) {
		int [] out = findPeakV1(inputArray);
		System.out.println("Value: " + out[0] + " Index: " + out[1]);
	}
	
}
