import java.util.Scanner;
public class binary_search {
	static Scanner s = new Scanner(System.in);		
	static int list [] = new int [5];
	static int search = 0;
	public static void main(String[] args)
	{
		
		System.out.println("Enter the array elements: ");
		for(int i = 0; i < list.length; i++)
		{
			list[i] = s.nextInt();
		}
				
		
		bubble_sort(list,list.length);
		
		
	}

	private static void bubble_sort(int[] list, int length) {
		// TODO Auto-generated method stub
		int temp = 0;
		for(int i = 0; i < length-1; i++)
		{
			for(int j = i+1; j < length; j++)
			{
				if(list[i] > list[j])
				{
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
					
			}
		}
		System.out.println("Array elemnts are after Bubble Sort: ");
		for(int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
		System.out.println("\nEnter the element to be searched: ");
		search = s.nextInt();
		binary_search(list,list.length,search);
		
	}

	private static void binary_search(int[] list, int length, int search) {
		// TODO Auto-generated method stub
		int first = 0;
		int end = length;
		int mid = 0;
		boolean found = false;
		while(!found && first != end)
		{
			mid = (first + end)/2;
			if(search == list[mid])
			{
				System.out.println("Element found at " + (mid+1) +" th position." );
				found = true;
			}
			else if(search < list[mid])
			{
				end = mid-1;
			}
			else
			{
				first = mid+1;
			}
		}
		if(found == false)
		{
			System.out.println("Element not found");
		}
			
		
	}

}
