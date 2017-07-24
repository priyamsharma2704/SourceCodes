using System;
namespace demo1
{
	public class ChildClass:MainClass
	{
		public ChildClass()
		{
			Console.WriteLine("Child class constructor");
		}

		static void Main()
		{
			ChildClass c = new ChildClass();
			c.test1();
			c.test2();
			Console.ReadLine();
		}


	}
}
