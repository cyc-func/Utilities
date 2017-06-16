class BinarySearch
{
	public static void main(String args[])
	{
		int A[] = {1, 2, 7, 9, 15, 18};
		System.out.println(BinarySearch(A, 9));
	}

	private static int BinarySearch(int A[], int elem)			// return -1 if not found. array needs to be sorted
	{
		int low = 0, high = A.length - 1;

		while(low <= high)
		{
			int mid = (low + high) / 2;

			if(A[mid] > elem)
			{
				high = mid - 1;
			}
			else if(A[mid] < elem)
			{
				low = mid + 1;
			}
			else
			{
				return mid;
			}
		}

		return -1;
	}
}
