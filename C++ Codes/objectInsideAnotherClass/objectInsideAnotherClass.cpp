// objectInsideAnotherClass.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
using namespace std;
class Marks
{
    private:
        int rno;
        float perc;
    public:
        Marks()
        {
            rno = 0;
            perc = 0.0;
        }
        void readMarks()
        {
            cout << "\nEnter the roll number: ";
            cin >> rno;
            cout << "Enter percentage: ";
            cin >> perc;
        }
        void printMarks()
        {
            cout << "\nRoll No: " << rno;
            cout << "\nPercentage: " << perc;
        }
};

class Student
{
private:
    Marks objM;
    string name;
public:
    void readStudent()
    {
        cout << "\nEnter name: ";
        cin >> name;
        objM.readMarks();
    }
    void printStudent()
    {
        cout << "\nStudent name: " << name;
        objM.printMarks();
    }
};

void main()
{
    Student s;
    s.readStudent();
    s.printStudent();
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
