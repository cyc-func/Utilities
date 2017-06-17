class Main
{
	public static void main(String args[])
	{
		int A[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		System.out.println(maximumSubarray(A));
	}

	private static int max(int a, int b)
	{
		return a > b ? a : b;
	}

	private static int max(int a, int b, int c)
	{
		return max(a, max(b, c));
	}

	private static int maximumSubarray(int A[])
	{
		return maximumSubarray(A, 0, A.length - 1);
	}

	private static int maximumSubarray(int A[], int p, int q)
	{
		if(p == q)
		{
			return max(0, A[p]);
		}

		int mid = (p + q) / 2;

		int leftMaxMid = 0, rightMaxMid = 0;
		int currentLeftMid = 0, currentRightMid = 0;

		for(int i = mid; i >= p; i--)
		{
			currentLeftMid += A[i];

			if(currentLeftMid > leftMaxMid)
			{
				leftMaxMid = currentLeftMid;
			}
		}

		for(int i = mid + 1; i <= q; i++)
		{
			currentRightMid += A[i];

			if(currentRightMid > rightMaxMid)
			{
				rightMaxMid = currentRightMid;
			}
		}

		return max(0, max(leftMaxMid + rightMaxMid, maximumSubarray(A, p, mid), maximumSubarray(A, mid + 1, q)));
	}
}
