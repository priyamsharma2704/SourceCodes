/*
Output Format

For each pair of  and  values (i.e., for each query), print a single integer denoting the element located at index  of the array referenced by . There should be a total of  lines of output.

Sample Input

2 2
3 1 5 4
5 1 2 8 9 3
0 1
1 3
Sample Output

5
9
*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int size, q, value,which,index,n;
    vector<vector<int>>nvec;
    cin>>n>>q;
    for(int i =0; i < n;i++)
    {
        cin>>size;
        vector<int> ivec;
        for(int j =0; j < size;j++)
        {
            cin>>value;
            ivec.push_back(value);
        }
        nvec.push_back(ivec);
    }
    
    for(int i = 0; i < n; i++)
    {
        cin>>which>>index;
        cout<<nvec[which][index]<<endl;
    }
    return 0;
}
