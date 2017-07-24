using System;
using System.Collections;
namespace HashTableDemo
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			//Console.WriteLine("Hello World!");
			Hashtable hs = new Hashtable();
			hs.Add("Name", "Priyam Sharma");
			hs.Add("Age",26);
			hs.Add("Location","USA");
			hs.Add("Email","mt00100@gmail.com");
			hs.Add("Phone no.",9372394999);

			Console.WriteLine(hs["Name"]);
			Console.WriteLine(hs["Age"]);
			Console.WriteLine(hs["Email"]);
			Console.WriteLine(hs["Phone no."]);

			Console.WriteLine();

			foreach (object key in hs.Values)
			{
				//here we will not get the values in the proper order as it fetches the hashcode associated with the key-value pair.
				Console.WriteLine(key);
			}



		}
	}
}
