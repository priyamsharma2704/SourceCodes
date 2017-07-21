using System;
using System.Text;
using System.Diagnostics;

namespace StringVsStringBuilder
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
			Stopwatch sw1 = new Stopwatch();

			String s = "";
			sw1.Start();
			for (int i = 0; i < 10000; i++)
			{
				s = s + i;
			}
			sw1.Stop();
			Console.WriteLine("Elapsed time for string = " + sw1.ElapsedMilliseconds);

			StringBuilder sb = new StringBuilder();
			Stopwatch sw2 = new Stopwatch();
			sw2.Start();
			for (int i = 0; i< 10000; i++)
			{
				sb.Append(i);
			}
			sw2.Stop();
			Console.WriteLine("Elapsed time for string builder = " + sw2.ElapsedMilliseconds);
		}
	}
}
