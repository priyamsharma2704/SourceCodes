using System;

namespace Basics
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			Random rand = new Random();
			int n1 = rand.Next(1, 11);
			int n2 = rand.Next(1, 11);

			Console.WriteLine("what is " + n1 + " + " + n2 + " = ");
			int ans = Convert.ToInt16(Console.ReadLine());

			if (ans == (n1 + n2))
			{
				Console.WriteLine("Right Answer!!!");
			}
			else 
			{
				Console.WriteLine("Wrong Answer!!!");	
			}

			Console.ReadKey();
		}
	}
}
