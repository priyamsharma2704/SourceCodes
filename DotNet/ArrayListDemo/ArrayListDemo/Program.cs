using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArrayListDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList al = new ArrayList();
            Console.WriteLine(al.Capacity);
            al.Add(12);
            Console.WriteLine(al.Capacity);
            al.Add(2);
            Console.WriteLine(al.Capacity);
            al.Add(30);
            al.Add(40);
            al.Add(50);
            al.Add(60);
            foreach(object i in al)
            {
                Console.Write(i + " ");
            }

			//---To insert an item in middle
			al.Insert(3, 35);
			Console.WriteLine();
			foreach(object i in al)
            {
                Console.Write(i + " ");
            }

			//---To delete an item
			//al.Remove(40);
			al.RemoveAt(2);	//To delete an item at a particular index
			Console.WriteLine();
			foreach(object i in al)
            {
                Console.Write(i + " ");
            }
		}
    }
}
