function Node(val)
{
  this.val = val;
  this.left =  null;
  this.right = null;
}

function BST()
{
  this.root = null;

  this.getRootNode = function()
  {
    return this.root;
  }

  this.insert = function(val)
  {
    if(this.root == null)
      this.root = new Node(val);

    this.insertNode(val, this.root);
  }

  this.insertNode = function(val, node)
  {
    if(val < node.val)
    {
      if(node.left == null)
        node.left = new Node(val);
      this.insertNode(val, node.left);
    }
    else if(val > node.val)
    {
      if(node.right == null)
        node.right = new Node(val);
      this.insertNode(val, node.right);
    }
  }

  this.inOrder = function(node)
  {
    if(node != null)
    {
      this.inOrder(node.left);
      console.log(node.val);
      this.inOrder(node.right);
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
    if(node != null)
    {
      this.postOrder(node.left);
      this.postOrder(node.right);
      console.log(node.val);
    }
  }

}





var bst = new BST();
bst.insert(10);
bst.insert(8);
bst.insert(6);
bst.insert(20);
bst.insert(5);
bst.insert(1);
bst.insert(11);

var root = bst.getRootNode();
console.log(root);
(bst.inOrder(root));
console.log("\n");
(bst.preOrder(root));
console.log("\n");
(bst.postOrder(root));