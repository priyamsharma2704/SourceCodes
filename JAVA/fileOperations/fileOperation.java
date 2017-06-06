
    final static Scanner cin = new Scanner(System.in);
    final static PrintStream cout = System.out;
    static Scanner fin;        // to be used on a file for input

    public static void main(String[] args) throws FileNotFoundException {
        // try to open the data file (will throw exception if failed)
        fin = new Scanner(new File("InputData.txt"));

        // comment out call to partA() when that part is complete
        partA();

        // uncomment call to partB() to test it, comment it back when done
//        partB();

        // uncomment call to partC() to test it
//        partC();

        fin.close();
    } // end main

    private static void partA() {
        int howMany;       // how many values to read (get this from the file)
        int sum = 0;       // summing variable (accumulator)
        int dataValue = 0; // input value

        // output identification
        cout.print("CPS 150 Lab 16 part A by __your name here__ \n\n");

        // read the number of values to be read from the data file
        howMany = fin.nextInt();
        // echo-print
        cout.print(howMany + " values would be read from the data file\n");

        // Input and sum integer data values. 
        for (int Lcv = 1; Lcv <= howMany; Lcv++) {
            // add statement to read dataValue from the file

            // echo-print
            cout.println("Value read = " + dataValue);

            // add statement to update sum
            
        } // end loop

        // display results
        cout.println("\n" + howMany + " values were read from data file");
        cout.println("Their Sum is " + sum);

        cout.print("\nLab 16 part A complete\n\n");
    } // end function

    private static void partB() {
        int howMany = 0;   // how many values were read from file (counter)
        int sum = 0;       // summing variable (accumulator)
        int dataValue = 0; // input value
        final int sentinel = -1;

        // output identification
        cout.print("CPS 150 Lab 16 part B by __your name here__ \n\n");

        // read first data value from the file
        dataValue = fin.nextInt();

        // Modify the condition so that it checks that the value just 
        // read is not the sentinel value
        while (dataValue != dataValue) {
            // echo-print
            cout.println("Value read = " + dataValue);

            // add statements to update the accumulator and the counter

            
            
            // add statement to read the next data value from the file
            
            
        } // end while

        // display results
        cout.println("\n" + howMany + " values were read from data file");
        cout.println("Their Sum is " + sum);

        cout.print("\nLab 16 part B complete\n\n");
    } // end function

    private static void partC() {
        int howMany = 0;   // how many values were read from file (counter)
        int sum = 0;       // summing variable (accumulator)
        int dataValue = 0; // input value

        // output identification
        cout.print("CPS 150 Lab 16 part C by __your name here__ \n\n");

        // add the expression that checks that the file has another int value
        // available 
        while (dataValue != dataValue) {
            // have a value available, 
            // so add a statement to read a dataValue from the file

            // echo-print
            cout.println("Value read = " + dataValue);

            // add statements to update the accumulator and the counter
            
            
        } // end while

        cout.println("\n" + howMany + " values were read from data file");
        cout.println("Their Sum is " + sum);

        cout.print("\nLab 16 part C complete\n\n");
    } // end function
