#include<iostream>
using namespace std;
/*
int the code below, when function "func" is called, it goes into if statement as condition inside it is true.
Then address of "a" is stored into pointer "p".
When it comes back to main after executing "func", "ptr" doesnt have anything. So it prints "NULL".
To solve this we need to pass th address of the ptr and in thr function definition, we need to use pointer to a pointer i.e. int**.

tO SEE THE DIFFERENCE, COMMENT PART1 AND TUN PART2 .

*/
//------PART1--------
/*
void func(int* p)
{
	int a=5;
	if(p == NULL)
		p = &a; 
}
void main()
{
	int *ptr = NULL;
	func(ptr);

	if(ptr == NULL)
		cout<<"NULL";
	else
	{
		cout<<"Not NULL";
		cout<<"\n"<<*ptr<<"\n";
		cout<<"\n"<<&ptr<<"\n";
	}
}
*/
//-----PART 2---------
void func(int** p)	//CHANGED
{
	int a=5;
	if(*p == NULL)	//CHANGED
		*p = &a;	//CHANGED
	cout<<"\nAddress of A = "<<*p;
}
void main()
{
	int *ptr = NULL;
	func(&ptr);		//CHANGED

	if(ptr == NULL)
		cout<<"\nNULL";
	else
	{
		cout<<"\nNot NULL";
		cout<<"\n"<<*ptr<<"\n";		//CONTENT or VALUE
		cout<<"\n"<<&ptr<<"\n";		//ADDRESS
	}
}