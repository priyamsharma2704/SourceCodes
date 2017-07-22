using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractClassDemo
{
    

    class ChildClass:AbsParent
    {   
        //Here we have to implement the two abstract methods of parent abstract class as it is mandatory. 
        public override void multiply(int x, int y)
        {
            Console.WriteLine(x * y);
        }

        public override void divide(int x, int y)
        {
            Console.WriteLine(x / y);
        }

        static void Main()
        {
            ChildClass c = new ChildClass();
            c.add(3, 5);
            c.sub(7, 2);
            c.multiply(2, 5);
            c.divide(4, 2);
        }
        

    }
}
