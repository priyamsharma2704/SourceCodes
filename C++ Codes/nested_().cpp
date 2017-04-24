/*
Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
*/
// you can use includes, for example:
 #include <algorithm>
#include<stack>
#include <string>
// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;


int solution(string &S) {
    // write your code in C++14 (g++ 6.2.0)
    stack<char>s;
    char ch;
    if(S.length()%2 !=0)
        return 0;
    for(int i = 0 ; i < S.length();i++)
    {
        ch = S[i];
        //cout<<S[i];
        switch(ch)
        {
            case ')':
            {   
                //check(s, '(' , ')');
                if(s.size()!= 0 )
                {
                    //cout<<"about to pop\n";
                    s.pop();
                }
                //else
                    //s.push(c2);                
                break;
            }
            default:
            {
                s.push(ch);
                //cout<<"\n"<<i<<" "<<ch;
            }
        }
    }
    //cout<<"\nsize "<<s.size();
    return(s.size() == 0 ? 1:0);
    //return 0;   
}