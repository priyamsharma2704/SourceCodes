let graph = ['A', 'B', 'C', 'D', 'E', 'F'];

var map = {
    'A': ['B', 'D', 'E'],
    'B': ['A','C'],
    'C': ['B', 'E', 'F'],
    'D': ['A', 'E'],
    'E': ['A','D','F','C'],
    'F': ['E','C']
}

bfs(graph, 'A', map);

function bfs(graph, char, map)
{
    var queue = [];
    var visited = [];

    queue.push(char);

    while (queue.length != 0)
    {
        var curr = queue.shift();
        if (visited.indexOf(curr) == -1)
        {
            visited.push(curr);
            console.log(curr);

            var neighbours =  map[curr];

            for (var i = 0; i < neighbours.length; i++)
            {
                if (neighbours[i] != 0  && visited.indexOf(neighbours[i]) == -1)
                {
                    queue.push(neighbours[i]);
                }
            }
        }
    }
}
