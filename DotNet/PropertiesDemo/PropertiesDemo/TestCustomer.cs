using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PropertiesDemo
{
    class TestCustomer
    {
        static void Main()
        {
            Customer cust = new Customer(101, false, "Priyam Sharma", 5000.0,Cities.Delhi);
            Console.WriteLine(cust.CustId);
            cust.CustId = 201;
            Console.WriteLine(cust.CustId);
            Console.WriteLine();
            cust.Status = false;
            if (cust.Status == false)
            {
                Console.WriteLine("Status = In-Active");
            }
            else
            {
                Console.WriteLine("Status = Active");
            }
            
            Console.WriteLine("Customer name = "+cust.Cname);
            cust.Cname = "Shubham";
            Console.WriteLine("Customer modified name = " + cust.Cname);

            Console.WriteLine("Old Balance = " + cust.Balance);
            cust.Balance = 3000;
            Console.WriteLine("New Balance = " + cust.Balance);
            Console.WriteLine();
            cust.Status = true;
            if (cust.Status == false)
            {
                Console.WriteLine("Status = In-Active");
            }
            else
            {
                Console.WriteLine("Status = Active");
            }
            cust.Cname = "Shubham";
            cust.Balance = 3000;
            Console.WriteLine("Customer modified name = " + cust.Cname);
            Console.WriteLine("New Balance = " + cust.Balance);
            Console.WriteLine("City = " + cust.City);
            cust.City = Cities.Bhopal;
            Console.WriteLine("New City = " + cust.City);




        }
    }
    
}
