package sort;

public class Bubble_sort
{
	static int[] numbers =
	{ 17, 63, 43, 64, 58, 54, 97, 65, 7, 2, 65, 67, 95, 34, 5, 976, 465, 35,
			34, 64, 34, 643, 15, 23, 1, 46, 32, 35, 345, 23, 9, 4, 62, 234, 77 };

	public static void main(String[] args)
	{
		sort(numbers);

		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " , ");
		}
	}

	private static void sort(int[] numbers)
	{
		for (int i = 0; i < numbers.length - 1; i++)
		{
			boolean modifyed = false;

			for (int j = numbers.length - 1; j > i; j--)
			{
				if (numbers[j] < numbers[j - 1])
				{
					int temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;

					modifyed = true;
				}
			}

			if (!modifyed)
			{
				break;
			}
		}
	}
}
