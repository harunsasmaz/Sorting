package sorting;


public class BitonicSort {

	/*Caller of bitonicSort for sorting the entire array 
	      of length N in ASCENDING order */
	public void sort(int a[], int N, int up) 
	{ 
		bitonicSort(a, 0, N, up); 
	} 
	
	private void bitonicSort(int a[], int low, int count, int dir) 
	{ 
		if (count > 1) 
		{ 
			int k = count/2; 

			// sort in ascending order since dir here is 1 
			bitonicSort(a, low, k, 1); 

			// sort in descending order since dir here is 0 
			bitonicSort(a,low+k, k, 0); 

			// Will merge wole sequence in ascending order 
			// since dir=1. 
			bitonicMerge(a, low, count, dir); 
		} 
	} 

	private void compAndSwap(int a[], int i, int j, int dir) 
	{ 
		if ( (a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) 
		{ 
			int temp = a[i]; 
			a[i] = a[j]; 
			a[j] = temp; 
		} 
	} 


	private void bitonicMerge(int a[], int low, int count, int dir) 
	{ 
		if (count > 1) 
		{ 
			int k = count/2; 
			for (int i=low; i<low+k; i++) 
				compAndSwap(a,i, i+k, dir); 
			
			bitonicMerge(a,low, k, dir); 
			bitonicMerge(a,low+k, k, dir); 
		} 
	} 
}
