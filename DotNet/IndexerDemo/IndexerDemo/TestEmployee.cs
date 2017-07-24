using System;
namespace IndexerDemo
{
	public class TestEmployee
	{
		public static void Main(string[] args)
		{
			Employee Emp = new Employee(123,"Priyam Sharma","Soft Dev",123456,"IT","Dayton");
			Console.WriteLine("Eno = "+ Emp[0]);
			Console.WriteLine("Ename = "+ Emp[1]);
			Console.WriteLine("Job = "+ Emp[2]);
			Console.WriteLine("Salary = "+ Emp[3]);
			Console.WriteLine("Dname = "+ Emp[4]);
			Console.WriteLine("Location = "+ Emp[5]);
		}
	}
}
