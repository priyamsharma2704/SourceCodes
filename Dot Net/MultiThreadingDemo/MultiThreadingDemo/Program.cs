using System;
using System.Threading;
namespace MultiThreadingDemo
{
	class MainClass
	{
		static void test1()
		{
			for (int i = 0; i < 100; i++)
			{
				Console.WriteLine("Test 1 : " + i);
			}

		}
		static void test2()
		{
			for (int i = 0; i < 100; i++)
			{
				Console.WriteLine("Test 2 : " + i);
			}
		}
		static void test3()
		{
			for (int i = 0; i < 100; i++)
			{
				Console.WriteLine("Test 3 : " + i);
			}
		}
		public static void Main(string[] args)
		{
			//Console.WriteLine("Hello World!");
			Thread t1 = new Thread(test1);
			Thread t2 = new Thread(test2);
			Thread t3 = new Thread(test3);
			t1.Start();
			t2.Start();
			t3.Start();
			//test1();
			//test2();
			//test3();
		}
	}
}
