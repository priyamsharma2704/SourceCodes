#include<iostream>
using namespace std;
void main()
{
	unsigned int num;
	int pos;
	int poss;
	unsigned int a;
	unsigned int b;
	cout<<"\nEnter the number = ";
	cin>>num;
	cout<<"Number entered is = "<<num;
	cout<<"\nEnter the bit position to check starting with 0 = ";
	cin>>pos;
	poss = 1<<pos;
	a = poss | num;
	b = poss & num;
	cout<<"\nSet bit = "<<a;
	cout<<"\nClear bit = "<<b;
	if(poss & num)
		cout<<"\nBit is set\n";
	else
		cout<<"\nBit is not set\n";

}