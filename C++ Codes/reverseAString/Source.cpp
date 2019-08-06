#include<iostream>
#include<stack>
using namespace std;
void main()
{
    char x[50] = "Hello World";

    int len = sizeof(x);
    //cout << len;
    stack<char> st;
    for (int i = 0; i < len; i++)
    {
        if (x[i] != ' ' && x[i] != '\0')
        {
            st.push(x[i]);
        }
        else if(x[i] == ' ' || x[i] == '\0' || i == len-1)
        {
            while (!st.empty())
            {
                cout << st.top();
                st.pop();
            }
            cout << ' ';
        }
    }


}