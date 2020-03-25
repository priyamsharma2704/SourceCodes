function Node(val)
{
    this.val = val;
    this.left = null;
    this.right = null;
}

function Tree()
{
    this.root = null;

    this.getRootNode = function()
    {
        return this.root;
    }

    this.addNode = function (val)
    {
        if (this.root == null)
            this.root = new Node(val);
        else
            this.addNewNode(val, this.root);
    }

    this.addNewNode = function (val, node)
    {
        if (node.val > val)
        {
            if (node.left == null)
                node.left = new Node(val);
            else
                this.addNewNode(val, node.left)
        }
        else
        {
            if (node.right == null)
                node.right = new Node(val);
            else
                this.addNewNode(val, node.right);
        }
    }
    
    this.dfs = function (node)
    {
        var stack = [];
        var visible = [];

        stack.push(node)
        while (stack.length != 0)
        {
            var currNode = stack.pop();
            if (visible.indexOf(currNode.val) == -1)
            {
                visible.push(currNode.val);
                console.log(currNode.val);

                if (currNode.right)
                    stack.push(currNode.right);

                if (currNode.left)
                    stack.push(currNode.left);

            }
        }
    }

    this.bfs = function (node)
    {
        var queue = [];
        var visible = [];

        queue.push(node);

        while (queue.length != 0)
        {
            var currNode = queue.shift();
            if (visible.indexOf(currNode.val) == -1)
            {
                visible.push(currNode.val);
                console.log(currNode.val);

                if (currNode.left)
                    queue.push(currNode.left);
                if (currNode.right)
                    queue.push(currNode.right);
            }
        }
    }
}

                                                        
var t = new Tree();
t.addNode(20);
t.addNode(15);
t.addNode(30);
t.addNode(12);
t.addNode(10);
t.addNode(8);
t.addNode(25);
t.addNode(44);

var root = t.getRootNode();
t.dfs(root);

console.log("\n");

t.bfs(root);
//console.log(root);