using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PropertiesDemo
{
    class Customer
    {
        int _Cid;
        bool _Status;
        string _Cname;
        double _Balance;
        Cities _City;
        string _State;
        string _Country;
        public Customer(int Cid, bool Status, string Cname, double Balance,Cities City)
        {
            _Cid = Cid;
            _Status = Status;
            _Cname = Cname;
            _Balance = Balance;
            _City = City;
            //_State = State;
            //_Country = Country;
        }

        public int CustId
        {
            get { return _Cid; }
            set { _Cid = value; }
        }

        public bool Status
        {
            get { return _Status; }
            set { _Status = value; }
        }

        public string Cname
        {
            get { return _Cname; }
            set
            {
                if(_Status == true)
                {
                    _Cname = value;
                }
            }
        }
        public double Balance
        {
            get { return _Balance; }
            set
            {
                if(_Status == true)
                {
                    _Balance = value;
                }
            }
        }
        public Cities City
        {
            get { return _City; }
            set
            {
                if(_Status == true)
                {
                    
                    _City = value;
                }
            }
        }
    }
}
