function Node(val)
{
  this.val = val;
  this.next = null;
}

function LinkedList()
{
  this.head = null;
  this.tail = null;

  this.addToStart = function(val)
  {
    if(this.head == null && this.tail == null)
    {
      this.assignFirstNode(val);
    }
    else
    {
      var curr = new Node(val);
      curr.next = this.head;
      this.head = curr;
    }
  }

  this.addToEnd = function(val)
  {
    if(this.head == null && this.tail == null)
    {
      this.assignFirstNode(val);
    }
    else
    {
      var curr = new Node(val);
      this.tail.next = curr;
      this.tail = curr;
    }
  }

  this.assignFirstNode = function(val)
  {
    var curr = new Node(val);
    this.head = curr;
    this.tail = curr;
  }

}

//----make a linked list and few elements to it.
var l = new LinkedList();
l.addToStart(3);
l.addToStart(2);
l.addToStart(1);
l.addToEnd(4);
l.addToEnd(5);

var node = l.head;
if(node == null)
  return; 

while(node.next != null)
{
  console.log(node.val);
  node = node.next;
}

if(node.next == null)
{
  console.log(node.val);
}






