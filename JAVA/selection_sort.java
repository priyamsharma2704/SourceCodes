import java.util.Scanner;
public class selection_sort {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int [] list = new int[5];
		System.out.println("Enter the array elements: ");
		for(int i = 0; i< list.length; i++)
		{
			list[i] = s.nextInt();
		}
		
		selection_sort(list,list.length);
		
		System.out.println("Array elements are after Selection Sort : ");
		for(int i = 0; i< list.length; i++)
		{
			System.out.print(list[i] + " ");			
		}
		
	}

	private static void selection_sort(int[] list, int length) {
		// TODO Auto-generated method stub
		int min = 0;
		int temp = 0;
		for(int i = 0; i < length -1; i++)
		{
			min = i;
			for(int j = i+1; j < length; j++)
			{
				if(list[j] < list[min])
				{
					min = j;
				}
				
			}
			temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}	
		
	}

}
