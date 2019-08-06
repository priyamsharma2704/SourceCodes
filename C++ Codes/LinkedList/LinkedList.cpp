// LinkedList.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;
struct Node
{
    int data;
    Node* next;
};

class linkedList
{
private:
    Node* head, *tail;
public:
    linkedList()
    {
        head = NULL;
        tail = NULL;
    }
    void addNode(int n)
    {
        Node* temp = new Node;
        temp->data = n;
        temp->next = NULL;

        if (head == NULL)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            tail->next = temp;
            tail = temp;
        }
    }

    void addAtStart(int val)
    {
        Node* temp = new Node;
        temp->data = val;
        temp->next = head;
        head = temp;
    }

    void printList()
    {
        Node* currNode = head;

        while (currNode)
        {
            cout << "\n" << currNode->data;
            currNode = currNode->next;
        }
    }

    void addAtEnd(int val)
    {
        Node* temp = new Node;
        temp->data = val;
        temp->next = NULL;
        tail->next = temp;
        tail = temp;
    }

    void addAtPosition(int pos, int val)
    {
        Node* temp = new Node();
        Node* cur = new Node();
        Node* prev = new Node();

        cur = head;

        for (int i = 1; i < pos; i++)
        {
            prev = cur;
            cur = cur->next;
        }

        temp->data = val;
        prev->next = temp;
        temp->next = cur;
    }

    void deleteAtStart()
    {
        Node* temp = new Node();
        temp = head;
        head = head->next;
        delete temp;
    }

    void deleteAtEnd()
    {
        Node* cur = new Node();
        Node* prev = new Node();
        cur = head;
        while (cur->next != NULL)
        {
            prev = cur;
            cur = cur->next;
        }
        prev->next = NULL;
        delete cur;
        tail = prev;

    }

    void deleteAtPosition(int pos)
    {
        Node* prev = new Node();
        Node* cur = new Node();

        cur = head;
        for (int i = 1; i < pos; i++)
        {
            prev = cur;
            cur = cur->next;
        }
        prev->next = cur->next;
    }

};
int main()
{
    std::cout << "Hello World!\n";
    linkedList lst;
    lst.addNode(123);
    lst.addNode(23);
    lst.addNode(75);
    lst.addAtStart(01);
    lst.addAtEnd(999);
    lst.addAtPosition(3, 50);
    //lst.deleteAtStart();
    //lst.deleteAtEnd();
    lst.deleteAtPosition(3);
    lst.printList();
}
