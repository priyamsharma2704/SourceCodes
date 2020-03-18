// LinkedListReverse.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;

struct node
{
    int data;
    node* next;
};

class linked_list
{
public:
    node* head, * tail;
    linked_list() 
    {
        head = NULL;
        tail = NULL;
    }

    void addNode(int val)
    {
        node* temp = new node();
        temp->data = val;
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

    void printList()
    {
        while (head)
        {
            cout <<endl<< head->data;
            head = head->next;
        }
    }
};

int main()
{
    linked_list *list = new linked_list();
    list->addNode(11);
    list->addNode(23);
    list->addNode(345);
    list->addNode(76);
    list->addNode(264);
    list->addNode(563);
    list->addNode(78564);
    list->printList();
}
