class BubbleSort
{
	public static void main(String args[])
	{
		int A[] = {5, 1, 3, 4, 2, 6};
		BubbleSort(A);
		
		for(int i : A)
		{
			System.out.println(i);
		}
	}

	private static void BubbleSort(int A[])
	{
		for(int i = 1; i < A.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(A[j - 1] > A[j])
				{
					int temp = A[j - 1];
					A[j - 1] = A[j];
					A[j] = temp;
				}
			}
		}
	}
	
}
