using System;

namespace IndexerDemo
{
	public class Employee
	{
		int Eno;
		double Salary;
		string Ename, Job, Dname, Location;

		public Employee(int Eno,string Ename,string Job, double Salary, string Dname,string Location)
		{
			this.Eno = Eno;
			this.Ename = Ename;
			this.Job = Job;
			this.Dname = Dname;
			this.Location = Location;
			this.Salary = Salary;
		}
		public object this[int index]
		{
			get
			{
				if (index == 0)
					return Eno;
				else if (index == 1)
					return Ename;
				else if (index == 2)
					return Job;
				else if (index == 3)
					return Salary;
				else if (index == 4)
					return Dname;
				else if (index == 5)
					return Location;
				else
					return null;
					
			}
		}
	}
}
