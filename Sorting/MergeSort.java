class MergeSort
{
	public static void main(String[] args)
	{
		int[] A = {3,2,3,1,2,43,5};
		mergeSort(A);

		for(int i : A)
		{
			System.out.println(i);
		}
	}

	private static void mergeSort(int[] A)
	{
		mergeSort(0, A.length - 1, A);
	}

	private static void mergeSort(int l, int r, int[] A)
	{
		if(l == r)
		{
			return;
		}

		int m = (l + r)/2;
		mergeSort(l, m, A);
		mergeSort(m + 1, r, A);

		int[] sortedArray = new int[r - l + 1];

		int sortedIndex = 0;
		int lIndex = l;
		int rIndex = m + 1;
		while(lIndex <= m && rIndex <= r)
		{
			if(A[lIndex] < A[rIndex])
			{
				sortedArray[sortedIndex++] = A[lIndex++];
			}
			else
			{
				sortedArray[sortedIndex++] = A[rIndex++];
			}
		}

		while(lIndex <= m)
		{
			sortedArray[sortedIndex++] = A[lIndex++];
		}

		while(rIndex <= r)
		{
			sortedArray[sortedIndex++] = A[rIndex++];
		}

		for(int i = l; i <= r; i++)
		{
			A[i] = sortedArray[i - l];
		}
	}
}
