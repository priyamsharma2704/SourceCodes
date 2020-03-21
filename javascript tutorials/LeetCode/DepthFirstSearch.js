
var tree2 = [
    { value: "A", left: 1, right: 2 },  //0
    { value: "B", left: 3, right: 4 },  //1
    { value: "C", left: null, right: 5 },  //2
    { value: "D", left: null, right: null },  //3
    { value: "E", left: null, right: 5 },  //4
    { value: "F", left: null, right: null },  //5
];

dfs(tree2);

function dfs(tree2)
{
    var stack = [];
    stack.push(tree2[0]);
    var visited = [];

    while (stack.length != 0)
    {
        var node = stack.pop();
        if (visited.indexOf(node.value) == -1)
        {
            visited.push(node.value)
            console.log(node.value);

            if (node.right)
            {
                stack.push(tree2[node.right]);
            }
            if (node.left)
            {
                stack.push(tree2[node.left]);
            }
        }
    }
}