import java.util.Scanner;
public class insertion_sort {
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int list [] = new int[5];
		System.out.println("Enter the array elements: ");
		for(int i = 0; i < list.length; i++)
		{
			list[i] = s.nextInt();
		}
		
		insertion_Sort(list,list.length);
		
		System.out.println("Array elements after Insertion Sort: ");
		for(int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
		
	}

	private static void insertion_Sort(int[] list, int length) {
		// TODO Auto-generated method stub
		int key = 0;
		int temp = 0;
		for(int i = 1; i < length ;i++)
		{
			key = list[i];
			while(i > 0 && key < list[i-1])
			{
				list[i] = list[i-1];
				i = i-1;
			}
			list[i] = key;
		}
		
	}

}
