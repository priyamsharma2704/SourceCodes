package primeGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class primeGen {
	static Scanner fin;
	public static void main(String args []) throws FileNotFoundException{
		fin = new Scanner(new File("input.txt"));
		int start =  fin.nextInt();
		int end = fin.nextInt();
		System.out.println("start= "+start+" " + "end = "+end+"\n");
		generator(start, end);
		//generator(0, 10);
	}

	private static void generator(int start, int end) {
		// TODO Auto-generated method stub
		int i;
		List<Integer> primeNum = new ArrayList<Integer>();
		//System.out.println(start+" " + end+"\n");
	    if(start > end) {
	            int temp = start;
	            start = end;
	            end = temp;
	    }
	    int count = 0;
	    System.out.println(start+" " + end+"\n");
	    for (i = start; i<=end; i++){
	            if(isPrime(i)){
	                    //System.out.println(i);
	                    count++;
	                    primeNum.add(i);
	            }
	    }
	    System.out.println("count= "+count);
	    Iterator<Integer> myListIterator = primeNum.iterator(); 
	    while (myListIterator.hasNext()) {
	        int num = myListIterator.next();     
	        //System.out.print("\r");
	        System.out.println(num);
	        //Thread.sleep(2000);
	    }
		
	}

	private static boolean isPrime(int i) {
		// TODO Auto-generated method stub
		int j;
	    if( i == 2)
	            return true;
	    else if(i % 2 == 0)
	            return false;
	    else if(i == 1 )
	    	return false;

	    for (j = 3; j < Math.sqrt(i); j += 2)
	            if (i % j == 0)
	                    return false;
		return true;
	}

}
