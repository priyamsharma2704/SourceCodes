using System;
using System.Collections.Generic;
namespace DictionaryDemo
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			//Console.WriteLine("Hello World!");
			Dictionary<string, object> d = new Dictionary<string,object>();
			d.Add("Name", "Priyam Sharma");
			d.Add("Age",26);
			d.Add("Location","USA");
			d.Add("Email","mt00100@gmail.com");
			d.Add("Phone no.",9372394999);

			foreach (string key in d.Keys)
			{
				Console.WriteLine(key + " : " + d[key]);
			}
		}
	}
}
