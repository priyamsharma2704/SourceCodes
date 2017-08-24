
import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        //System.out.println(Math.max(10,3));
        int[] a = {-4,15,-6,18,2,-20};
        //System.out.println(a.length);
        int c = a[0];
        int g = a[0];
        for(int i = 1; i <a.length -1; i++ ){
            c = Math.max(a[i],(c + a[i]));
            if(c > g)
                g = c;
        }
        System.out.println(g);
    }
}