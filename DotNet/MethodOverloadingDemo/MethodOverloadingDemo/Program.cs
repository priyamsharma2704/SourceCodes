using System;

namespace MethodOverloadingDemo
{
	class MainClass
	{
		public void test()
		{
			Console.WriteLine("1st Method");
		}

		public void test(int i)
		{
			Console.WriteLine("2nd Method " );
		}
		public void test(String s)
		{
			Console.WriteLine("3rd method");
		}

		public void test(int i, String s)
		{
			Console.WriteLine("4th method");
		}
		public void test(String s, int i)
		{
			Console.WriteLine("5th Method");
		}



		public static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
			MainClass m = new MainClass();
			m.test();
			m.test(4);
			m.test("priyam");
			m.test(3,"sharma");
			m.test("asda",4);

		}
	}
}
