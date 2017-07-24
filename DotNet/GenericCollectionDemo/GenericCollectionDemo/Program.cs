using System;
using System.Collections.Generic;
namespace GenericCollectionDemo
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			//Console.WriteLine("Hello World!");
			List<int> l = new List<int>();
			l.Add(11);
			l.Add(21);
			l.Add(31);
			l.Add(41);

			for (int i = 0; i < l.Count; i++)
			{
				Console.Write(l[i] + " ");
			}
			Console.WriteLine();
			l.Insert(3, 35);
			foreach (int i in l)
			{
				Console.Write(i + " ");
			}
		}
	}
}
