let graph = ['A', 'B', 'C', 'D', 'E', 'F'];

var map = {
    'A': ['B', 'D', 'E'],
    'B': ['A','C'],
    'C': ['B', 'E', 'F'],
    'D': ['A', 'E'],
    'E': ['A','D','F','C'],
    'F': ['E','C']
}

dfs(graph, 'A', map);

function dfs(graph, char)
{
    var stack = [];
    var visited = [];

    dfs2(char, visited);
}

function dfs2(char, visited)
{
    if (visited.indexOf(char) == -1)
    {
        visited.push(char);
        console.log(char);

        var neigh = map[char];

        for (var i = 0; i < neigh.length; i++)
        {
            if (visited.indexOf(neigh[i]))
                dfs2(neigh[i], visited);
        }
    }
}