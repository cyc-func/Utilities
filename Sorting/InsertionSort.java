class InsertionSort
{
	public static void main(String args[])
	{
		int A[] = {5, 1, 3, 4, 2};
		InsertionSort(A);

		for(int i : A)
		{
			System.out.println(i);
		}
	}

	private static void InsertionSort(int A[])
	{
		for(int i = 1; i < A.length; i++)
		{
			int j = i - 1;
			int sentinel = A[i];
			
			while(j >= 0 && A[j] > sentinel)
			{
				A[j + 1] = A[j];
				j--;
			}

			A[j + 1] = sentinel;
		}
	}
}
