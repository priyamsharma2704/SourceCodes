/*
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/

// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        
        Stack<Character> s = new Stack<>();
        for(char c : S.toCharArray())
        {
            switch(c)
            {
                case ')':
                    {
                        checkandpop(s,'(');
                        break;
                    }
                case ']':
                    {
                        checkandpop(s,'[');
                        break;
                    }
                case '}':
                    {
                        checkandpop(s,'{');
                        break;
                    }
                default: 
                {
                    s.push(c);
                    //System.out.println("after pushing" + c + " " + s.size() );
                }
            }
        }
        return (s.isEmpty() ? 1 :0);
    }
    public void checkandpop(Stack<Character> s, char c)
    {
        if(!s.isEmpty() && (char)s.peek() == c)
        {
            //System.out.println("before pop" + s.size());
            s.pop();
            //System.out.println("after pop" + s.size());
        }
    }
}