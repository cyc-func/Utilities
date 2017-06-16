class MergeSort
{
	public static void main(String args[]) throws IOException
	{
		int A[] = {5, 1, 3, 4, 2, 6};
		MergeSort(A);

		for(int i : A)
		{
			System.out.println(i);
		}
	}

	private static void MergeSort(int A[])
	{
		MergeSort(A, 0, A.length - 1);
	}

	private static void MergeSort(int A[], int p, int q)
	{
		if(p < q)
		{
			MergeSort(A, p, (p + q) / 2);
			MergeSort(A, ((p + q) / 2) + 1, q);
			Merge(A, p, q);
		}
	}

	private static void Merge(int A[], int p, int q)
	{
		int pqSorted[] = new int[q - p + 1];

		int pqIndx = 0;
		int mid = (p + q) / 2;
		int pi = p, qi = mid + 1;

		while(pi <= mid && qi <= q)
		{
			if(A[pi] < A[qi])
			{
				pqSorted[pqIndx++] = A[pi++];
			}
			else
			{
				pqSorted[pqIndx++] = A[qi++];
			}
		}

		while(pi <= mid)
		{
			pqSorted[pqIndx++] = A[pi++];
		}

		while(qi <= q)
		{
			pqSorted[pqIndx++] = A[qi++];
		}

		for(int i = 0; i < pqSorted.length; i++)
		{
			A[p + i] = pqSorted[i];
		}
	}
}
