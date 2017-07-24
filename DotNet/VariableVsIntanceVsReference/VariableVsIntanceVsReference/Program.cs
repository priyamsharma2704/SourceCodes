using System;

namespace VariableVsIntanceVsReference
{
	class MainClass
	{
		int x = 100;
		public static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");

			//---Variable---
			MainClass m;
			//Console.WriteLine(m);//this is a variable ie an uninitialised copy of a class


			//---Instance---
			MainClass n = new MainClass();
			Console.WriteLine("--Instance example--");
			Console.WriteLine(n.x);

			//---Reference---
			MainClass a;
			MainClass b = new MainClass();
			a = b;
			a.x = 200;
			Console.WriteLine("--Reference example--");
			Console.WriteLine(a.x + " " + b.x);
		}
	}
}
