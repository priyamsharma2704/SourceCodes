using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractClassDemo
{
    abstract class AbsParent
    {
        public void add(int x,int y)
        {
            Console.WriteLine(x + y);
        }
        public void sub(int x, int y)
        {
            Console.WriteLine(x - y);
        }
        abstract public void multiply(int x, int y);
        abstract public void divide(int x, int y);

        

    }
}
