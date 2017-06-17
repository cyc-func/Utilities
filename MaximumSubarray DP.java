class Main
{
	public static void main(String args[])
	{
		int A[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		System.out.println(maximumSubarray(A));
	}

	private static int maximumSubarray(int A[])
	{
		int globalMaxima = 0;
		int localMaxima = 0;

		for(int i = 0; i < A.length; i++)
		{
			localMaxima += A[i];

			if(A[i] > localMaxima)
			{
				localMaxima = A[i];
			}

			if(localMaxima > globalMaxima)
			{
				globalMaxima = localMaxima;
			}
		}

		return globalMaxima;
	}
}
