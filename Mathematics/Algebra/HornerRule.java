class Main
{
	public static void main(String args[])
	{
		int coefficients[] = {2, 4, 0, 12, 16, 1};	// p(x) = A[0] + A[1]x + A[2]x^2 + ... + A[n-1]x^(n-1) when n = A.length
		System.out.println(HornerRule(coefficients, -19));
	}

	private static int HornerRule(int coefficients[], int x)
	{
		int eval = 0;
		
		for(int i = coefficients.length - 1; i > 0; i--)
		{
			eval = (eval + coefficients[i]) * x;
		}
		eval += coefficients[0];

		return eval;
	}
}
