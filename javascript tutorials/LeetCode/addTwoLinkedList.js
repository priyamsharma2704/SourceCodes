/**
 * Definition for singly-linked list.
  
 
/**
 * @param {ListNode} l1 = new ListNode()
 * @param {ListNode} l2
 * @return {ListNode}
 */

function ListNode(val) 
{
  this.val = val;
  this.next = null;
}

// var l123 = new ListNode(3);
// var l12 = new ListNode(4);
// l12.next = l123;
// var l1 = new ListNode(2);
// l1.next = l12;

// var l223 = new ListNode(4);
// var l22 = new ListNode(6);
// l22.next = l223;
// var l2 = new ListNode(5);
// l2.next = l22;

// var l1 = new ListNode(5);
// var l2 = new ListNode(5);

var l12 = new ListNode(8);
var l1 = new ListNode(1);
l1.next = l12;

var l2 = new ListNode(0);

console.log(l1);
addTwoNumbers(l1,l2);

function addTwoNumbers (l1, l2) 
{
    var res = new ListNode(0);
    var node = res;
    var x, y;
    var carry = 0;
    var sum = 0;
    while(l1 || l2)
        {
            x = l1 != null?l1.val:0;
            
            y = l2 != null? l2.val:0;
            
            sum = x + y + carry;
            carry = Math.floor(sum / 10);
            var curr = new ListNode(sum % 10);
            node.next = curr;
            node = node.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
        }
    if(carry > 0)
        {
            node.next = new ListNode(carry);
        }
    return res.next;
};