var Node = function(val)
{
  this.val = val;
  this.right = null;
  this.left = null;
}


var BTS = function()
{
  this.root = null;
  
  this.insert = function(val)
  {
    var node = new Node(val);
    if(this.root == null)
    {
      this.root = node;
    }
    else
    {
      insertNode(node, this.root);
    }
  }

  this.preOrder = function(node)
  {
    if(node != null)
    {
      console.log(node.val);
      this.preOrder(node.left);
      this.preOrder(node.right);
    }
  }

  this.postOrder = function(node)
  {
    if(node != null){
      this.postOrder(node.left);
      this.postOrder(node.right);
      console.log(node.val);
    }
  }

  this.inOrder = function(node)
  {
    if(node != null){
      this.inOrder(node.left);
      console.log(node.val);
      this.inOrder(node.right);
    }
  }

  this.getRootNode = function()
  {
    return this.root;
  }
}

function insertNode(node, root)
{
  if(node.val < root.val)
  {
    if(root.left == null)
      root.left = node;
    else
      insertNode(node, root.left);
  }
  else if(node.val > root.val)
  {
    if(root.right == null)
      root.right = node;
    else
      insertNode(node, root.right);
  }
}



var bts = new BTS();
bts.insert(5);
bts.insert(11);
bts.insert(1);
bts.insert(13);
bts.insert(3);
bts.insert(22);
bts.insert(8);
bts.insert(2);

var root = bts.getRootNode();
bts.inOrder(root);
console.log("\n");
bts.preOrder(root);
console.log("\n");
bts.postOrder(root);