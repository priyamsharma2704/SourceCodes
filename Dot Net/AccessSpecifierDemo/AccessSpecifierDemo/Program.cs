using System;

namespace AccessSpecifierDemo
{
	class MainClass
	{
		private void test1()
		{
			Console.WriteLine("Private Method");
		}

		internal void test2()
		{
			Console.WriteLine("Internal Method");
		}

		protected void test3()
		{
			Console.WriteLine("Protected method");
		}

		protected internal void test4()
		{
			Console.WriteLine("Protected internal method");
		}

		public void test5()
		{
			Console.WriteLine("Public method");
		}

		public static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
			MainClass m = new MainClass();
			m.test1();
			m.test2();
			m.test3();
			m.test4();
			m.test5();
		}
	}
}
