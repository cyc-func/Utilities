/**
 * For better results, randomize quicksort by first generating a
 * random integer k between p and q (inclusive) and then swapping
 * A[k] and A[q]
 */

class Main
{
	public static void main(String args[])
	{
		int A[] = {5, 1, 2, 4, 3};
		quickSort(A);
		
		for(int i : A)
		{
			System.out.println(i);
		}
	}

	private static void quickSort(int A[])
	{
		quickSort(A, 0, A.length - 1);
	}

	private static void quickSort(int A[], int p, int q)
	{
		if(p < q)
		{
			// pivot = A[q]
			int j = p - 1;

			for(int i = p; i <= q - 1; i++)
			{
				if(A[i] < A[q])
				{
					j++;	//swap A[i] and A[j]

					int temp = A[j];
					A[j] = A[i];
					A[i] = temp;
				}
			}

			j++;

			int temp = A[q];
			A[q] = A[j];
			A[j] = temp;

			quickSort(A, p, j - 1);
			quickSort(A, j + 1, q);
		}
	}
}
