/*
given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.
*/

// you can use includes, for example:
 #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(vector<int> &A) {
    // write your code in C++14 (g++ 6.2.0)
    int s = A.size();
    sort(A.begin(),A.end());
    //int max = A[s - 1];    
    //cout<<max;
    if(s == 0)
        return 0;
    for(int i = s - 1; i > 0; i--)
    {
        //cout<<A[i];    
        int max = A[i];
        if(max < A[i-1] + A[i-2])
            return 1;
        
            
    }
    return 0;
    
}