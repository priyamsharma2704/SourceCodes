//output : A B C D E F
/*
            A
           / \
          B   C
         / \   \
        D   E ->F
*/

var tree = [
    { value: "A", left: 1, right: 2 }, // 0
    { value: "B", left: 3, right: 4 }, // 1
    { value: "C", left: null, right: 5 }, // 2
    { value: "D", left: null, right: null }, // 3
    { value: "E", left: null, right: 5 }, // 4
    {value:"F", left:null, right:null} // 5
];

bfs(tree);
function bfs(tree)
{
    var queue = [];
    var visited = [];

    queue.push(tree[0]);

    while (queue.length != 0)
    {
        var node = queue.shift();
        if (visited.indexOf(node.value) == -1)
        {
            console.log(node.value);
            visited.push(node.value);

            if (node.left)
                queue.push(tree[node.left]);
            
            if (node.right)
                queue.push(tree[node.right]);
        }
    }
}