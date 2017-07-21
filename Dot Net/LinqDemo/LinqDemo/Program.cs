using System;
using System.Linq;

namespace LinqDemo
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
			int[] arr = new int[12]{ 12, 43, 57, 1, 7, 87, 12, 31, 61, 75, 32, 18 };
			var brr = from i in arr where i > 30 orderby i ascending select i;

			foreach (int x in brr)
			{
				Console.WriteLine(x);
			}
		}
	}
}
