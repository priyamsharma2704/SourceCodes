var Node = function(val)
{
  this.val = val;
  this.right = null;
  this.left = null;
}


var BST = function()
{
  this.root = null;

  this.getRootNode = getRootNode;
  this.insert = insert;
  this.insertNode = insertNode;
  this.inOrder = inOrder;
  this.preOrder = preOrder;
  this.postOrder = postOrder;
}

function getRootNode()
{
  return this.root;
}

function insert(val)
{
  if(this.root == null)
    this.root = new Node(val);
  
  this.insertNode(val, this.root);
}

function insertNode(val, node)
{
  if(val < node.val)
  {
    if(node.left == null)
    {
      node.left = new Node(val);
    }
    insertNode(val, node.left);
  }
  else if(val > node.val)
  {
    if(node.right == null)
    {
      node.right = new Node(val);
    }
    insertNode(val, node.right);
  }
}

function inOrder(node)
{
  if(node != null)
  {
    this.inOrder(node.left);
    console.log(node.val);
    this.inOrder(node.right);
  }
}

function preOrder(node)
{
  if(node != null)
  {
    console.log(node.val);
    this.preOrder(node.left);
    this.preOrder(node.right);
  }
}

function postOrder(node)
{
  if(node != null)
  {
    this.postOrder(node.left);
    this.postOrder(node.right);
    console.log(node.val);
  }
}


var b = new BST();
b.insert(10);
b.insert(9);
b.insert(20);
var root = b.getRootNode();
//console.log(root);
b.inOrder(root);
console.log("\n");
b.preOrder(root);
console.log("\n");
b.postOrder(root);
