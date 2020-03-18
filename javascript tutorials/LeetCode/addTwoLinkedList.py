# Definition for singly-linked list.

#Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

l123 = ListNode(3)
l12 = ListNode(4)
l12.next = l123
l1 = ListNode(2)
l1.next = l12


l223 = ListNode(4)
l22 = ListNode(6)
l22.next = l223
l2 = ListNode(5)
l2.next = l22

class Solution(object):
    def addTwoNumbers( l1, l2):
        res = ListNode(0)
        node = res
        x = 0
        y = 0
        carry = 0
        while l1 or l2:
            x = 0
            if l1 != None:
                x = l1.val
                
            y = 0
            if l2 != None:
                y = l2.val

            sum = x + y + carry
            carry = (sum / 10)
            curr = ListNode(sum % 10)
            node.next = curr
            node = curr

            if l1 != None:
                l1 = l1.next

            if l2 != None:
                l2 = l2.next


        if carry > 0:
            node.next = ListNode(carry)

        return res.next
        

s = Solution
s.addTwoNumbers(l1, l2)