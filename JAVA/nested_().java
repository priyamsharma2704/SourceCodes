/*
Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
*/

// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        //char ch [];
        Stack<Character> s = new Stack<>(); 
        //int size = S.length;
        for(char c : S.toCharArray())
        {
            switch(c)
            {
                case ')':
                {
                    check(s, '(',')');
                    break;                    
                }
                default:
                {
                    s.push(c);
                    //System.out.println(c);
                }               
            }
        } 
        return(s.isEmpty() ? 1: 0);
    }
    
    public void check(Stack<Character> s , char c1, char c2)
    {
        if(!s.isEmpty() && c1 == '(')
            s.pop();
        else 
            s.push(c2);
    }
}