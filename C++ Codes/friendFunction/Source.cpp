#include<iostream>
#include <vector>

using namespace std;
class Number
{
private:
int x;
public:
    void getNum(int n)
    {
        x = n;
    }
    friend void func(Number num)    //can call a friend function without class name.
    {
        cout<<"\nFriend function = "<<num.x;
    }
};

void main()
{
    Number n1;
    n1.getNum(123456);
    func(n1);
    cin.get();
}