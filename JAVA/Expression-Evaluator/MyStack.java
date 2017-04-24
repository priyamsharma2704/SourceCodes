package calculation;

import java.util.*;



public class MyStack {

	/*Step 1: Define three data members for this class
	 
	 * Data member 1: is called "total_stacks" which is used
	 * to record how many MyStack objects have been created;
	 *  
	 * Data member 2: is called "id" represents the id number
	 * the current MyStack object. Each created MyStack object
	 * should have one unique id number, which is assigned at
	 * the time when the object is created. You can use the total_stacks
	 * as a reference. For example, the first created MyStack object has ID = 0;
	 * The second created MyStack Object has ID = 1, and so forth
	 * 
	 * Data member 3: is called "stack", which is the Java supported Stack.
	 * This is the main variable to store the expression.
	 * 
	 * For these three data members, you should determine whether it is a 
	 * "static" or "non-static" according to its role as mentioned above
	 * 
	 * Try to use the "Generate Setters and Getters" tool in the "Source" menu to 
	 * create the three pairs of setters and getters automatically*/

	
	
	
	//Do the step 1 here
	
	static int total_stacks=0;
	int id = 0;
	Stack<String> stack = new Stack<>();
	
	
	
	
	
	
	
	
	/*Step 2: Create two constructors of MyStack(). For both of the constructors, you
	 * need to make sure to assign the ID for the created object. Meanwhile, maintain
	 * the number of "total_stacks" globally, which means to increase it by one every time when a
	 * new object is created 
	 * 
	 * Constructor 1: this constructor has no input arguments. You need to update the
	 * related variables as mentioned above. Also print out a message, e.g. "A stack with 
	 * the id #5 is created" (do this at the end of the constructor) 
	 * 
	 * Constructor 2: this constructor has one input argument - "String exp". In addition to finishing the
	 * tasks as constructor 1 does, it also push the expression as string type into the 
	 * stack data member by simply calling addItem() member function. 
	 * */
	// same as constructor 1 b\,just call the function "addItem()"
	
	
	

	
	//Do the step 2 here
	public MyStack()
	{								//Constructor 1
		
		id=total_stacks;	
		total_stacks++;
		System.out.println("A stack with the id #"+id+ " is created"); // to keep the id of the stack created
	}
	
	public MyStack(String exp)
	{		//Constructor 2
		id=total_stacks;	
		total_stacks++;
		System.out.println("A stack with the id #"+id+ " is created"); // to keep the id of the stack created
		addItem(exp);
	}

	
	
	/*Step 3: complete the functions below*/
	
	/*remove the top item (String) from the stack data member*/
	public void removeItem()
	{
		//Implement here
		stack.pop();
	}

	
	/*Print out all the items of the stack by printing each one in a new line 
	 * For example, for an expression 5 * 18 + 21
	 * 			   [0] 5
	 * 			   [1] *
	 * 			   [2] 18
	 * 			   [3] +
	 * 			   [5] 21
	 * If you use the stack API directly, you probably can only access the items in the
	 * order from the top to the bottom. So to print them out in the order as the items
	 * are inserted, you need to use the Iterator class, which is returned from the stack.
	 * You need to look it up online on how to use Iterator class*/ 
	public void showItems()
	{
		//Implement here
		System.out.println("\n*******Stack elements are*******");
		
		Iterator<String> iter = stack.iterator();
		int i=0;
		while (iter.hasNext() &&  i<getSize()) 
		{
			System.out.print("["+ i + "] : " + iter.next() + "\n");
			i++;
		}
		System.out.println("");
	}
	
	
	/* Return the top character of the stack, you can't remove the top item but just read it*/
	public String getTopItem()
	{
		String s = stack.peek();
		return s;
	}
	
	//Return how many items are there in the stack
	public int getSize()
	{
		//Implement here here
		int sizeOfStack=stack.size();
      	return sizeOfStack;
	}
	
	
	
	/*Step 4: as described in the instruction. This is the most important function for this class
	 * The role is to process the input String, and store them into the stack as items*/
	public void addItem(String exp)
	{
		//Implement here
		exp = exp+"\n";
		char [] ch = exp.toCharArray();
		String sample = "0";
		String sample2 = "0";
		
    	for (int j = 0; j < ch.length; j++)
    	{
    		Boolean found = false;
    		if(Character.isLetter(ch[j]) )
    		continue;
    			
    		else if(ch[j]=='+' || ch[j]=='-' || ch[j] == '*' || ch[j]=='/')
    		{
   				sample = Character.toString(exp.charAt(j));
   				stack.push(sample);
    		}	
	    		
    		else if (ch[j]==' ' || ch[j]=='.' || (ch[j]>='0' && ch[j]<='9'))
	    	{
	    		int temp = j;
	    		sample = "0";
	    		while(ch[temp] == ' ' || ch[temp]=='.' || ch[temp]>='0' && ch[temp]<='9' )
	    		{
	    			if(ch[temp] == ' ')
	    			{
	    				temp++;
	    			}
	    			if(ch[temp] == '.')
	    				found = true;
	    					 
	    			if(ch[temp] == ' ' || ch[temp]=='.' || ch[temp]>='0' && ch[temp]<='9')
	    			{
	    				sample = sample+Character.toString(exp.charAt(temp));
	    				temp++;
	    			}
	    					
	    			if(ch[temp] == '.' && found == true)
	    			{
	    				int temp2 = temp;
	    				sample2 = "0";
	    				while((ch[temp2] == ' ' || ch[temp2]=='.' || ch[temp2]>='0' && ch[temp2]<='9') )
	    				{
	    					if(ch[temp2] == ' ')
	    					{
			    				temp2++;
			    			}
	    					
	    					else
	    					{
	    						sample2 = sample2+Character.toString(exp.charAt(temp2));
	    						temp2++;
	    					}
	    							
	    				}
	    				if(Double.parseDouble(sample2)>0)
	    		    	stack.push(sample2);
	    		    	temp=temp2;
	    			}
	    					
	    		}
	    		stack.push(sample);
	    		j=temp-1;
	    	}
	    }
	}
}
