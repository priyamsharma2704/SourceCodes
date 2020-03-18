function Node(val)
{
  this.val = val;
  this.next = null;
}

function LinkedList()
{
  this.count = 0;
  this.head = null;
  this.tail = null;


  this.addToStart = function(val)
  {
    if(this.head == null && this.tail == null)
    {
      var curr = new Node(val);
      this.head = curr;
      this.tail = curr;
    }
    else
    {
      var curr = new Node(val);
      curr.next = this.head;
      this.head = curr;
    }
    this.count++;
  }

  this.addToEnd = addToEnd;
  this.remove = remove;
}

function addToEnd(val)
{
  if(this.head == null && this.tail == null)
  {
    var curr = new Node(val);
    this.head = curr;
    this.tail = curr;
  }
  else
  {
    var curr = new Node(val);
    this.tail.next = curr;
    this.tail = curr;
  }
  this.count++;
}

function remove(val)
{
  var c = this.head;
  var p = null;
  while(c!= null)
  {
    if(p == null)
    {
      if(c.val == val)
      {
        l = c.next;
        c = l;
      }
      else
      {
        p = c;
        c = c.next;
      }
    }
    else
    {
      if(c.val == val)
      {
        p.next = c.next;
        c = c.next;
      }
      else
      {
        p = c;
        c = c.next;
      }
    }
  }
}


var l = new LinkedList();
l.addToStart(5);
l.addToStart(6);
l.addToStart(7);
l.addToEnd(3);
l.addToEnd(10);
l.remove(10);
var node = l.head;
while(node.next != null)
{
  console.log(node.val);
  node = node.next;
}

if(node.next == null)
console.log(node.val);