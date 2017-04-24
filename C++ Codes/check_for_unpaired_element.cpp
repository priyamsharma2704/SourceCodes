/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.
*/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int count = 0;
        int a = 0; 
        for(int i = 0;i < A.length-1; i++)
        {
            //System.out.print(A[i]);
            count = 0;
            for(int j = i+1; j < A.length; j++)
            {
                if(A[i] == A[j])
                {
                    count++;                    
                    //System.out.println("A[i]:" + i + "\t" + "A[j]:" + j + "\t" + "count:" + count );
                }
            }
            if(count == 0)
            {
                //System.out.print(A[i]);
                a =  A[i];
            }
        }
        return a;
    }
}