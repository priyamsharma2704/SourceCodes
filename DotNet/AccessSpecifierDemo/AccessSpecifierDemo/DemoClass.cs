using System;
namespace AccessSpecifierDemo
{
	public class DemoClass:MainClass
	{
		static void MainNew()
		{
			DemoClass d = new DemoClass();
			d.test2();
			//here we can access all test except test1 cause it is private

		}
	}

	public class DemoClass2
	{
		static void Main3()
		{
			MainClass n = new MainClass();
			n.test2();
			n.test4();
			n.test5();
			//here I can accessonly test 2,4,5 because test 1 is private and test 3 is protected(can be accessed by its child class only)
		}	}

}
