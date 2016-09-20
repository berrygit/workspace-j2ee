package sort;

public class Counting_sort
{
	static int[] numbers =
	{ 2, 4, 3, 5, 6, 7, 8, 9, 1, 2, 4, 2, 6, 3, 8, 0, 4, 0, 8, 2, 6, 3, 9, 3, 5 };

	public static void main(String[] args)
	{
		int[] output = new int[numbers.length];
		sort(numbers, output, 9);

		for (int i = 0; i < output.length; i++)
		{
			System.out.print(output[i] + " , ");
		}
	}

	private static void sort(int[] numbers, int[] output, int k)
	{
		int[] convert = new int[k + 1];

		for (int i = 0; i < convert.length; i++)
		{
			convert[i] = 0;
		}

		for (int i = 0; i < numbers.length; i++)
		{
			convert[numbers[i]]++;
		}

		for (int i = 1; i < convert.length; i++)
		{
			convert[i] = convert[i] + convert[i - 1];
		}

		for (int i = numbers.length - 1; i >= 0; i--)
		{
			output[convert[numbers[i]] - 1] = numbers[i];
			convert[numbers[i]]--;
		}
	}
}
