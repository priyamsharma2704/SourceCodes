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

  this.findLca = findLca;
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

function findLca(node, n1, n2)
{
  if(node == null)
    return null;
  
  if(node.val == n1 || node.val == n2)
    return node;
  
  var left = this.findLca(node.left, n1, n2);
  var right = this.findLca(node.right, n1, n2);

  if(left != null && right != null)
    return node;
  
  return (left != null) ? left : right;
}


var b = new BST();
b.insert(20);
b.insert(10);
b.insert(30);
b.insert(5);
b.insert(11);
b.insert(26);
b.insert(41);

var root = b.getRootNode();

var n = b.findLca(root, 26, 41);
console.log(n);

