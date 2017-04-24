int solution(int N) {
    // write your code in C++14 (g++ 6.2.0)
    int max = 0;
    int r = 0;
    int size = 0;
    if(N <=15)
        size = 4;
    else
        size = 11;
    int bin[size];    
    int i = 0;
    //int size=0;
    int count = 0;
    
    while(N!=0)
    {
        r = N%2;
        N = N/2;
        bin[i] = r; 
        i++;
        
    }
    
    //for(int i = 0;i <size ; i++)
    //    cout<<bin[i];
        
    for(int i = 0;i <size-1 ; i++)
    {        
        count = 1;
        if(bin[i] == 0)
        {
            for(int j = i+1;j <size ; j++)
            {
                if(bin[i] == bin[j] )
                {
                    count++;
                    //cout<<"\ni:"<<i<<"\t"<<"j:"<<j<<"\t"<<"count:"<<count;
                    
                }   
                else 
                    break;
                            
            }
            if(count > max)
                max = count;
        }
    }
    return max;
}