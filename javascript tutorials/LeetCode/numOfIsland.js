var grid = [
    [1, 1, 0, 0, 0],
    [0, 1, 0, 0, 1],
    [1, 0, 0, 1, 1],
    [0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1]
];
var r = grid.length;
var c = grid[0].length;


findNumOfIslands(grid);

function findNumOfIslands(grid)
{
    var count = 0;

    for (var i = 0; i < r; i++)
    {
        for (var j = 0; j < c; j++)
        {
            if (grid[i][j] == 1)
            {
                mark(grid, i, j);
                count++;
            }
        }
    }
    console.log(count);
}

function mark(grid, i, j)
{
    if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != 1)
        return;

    grid[i][j] = 'X';

    mark(grid, i - 1, j);
    mark(grid, i + 1, j);
    mark(grid, i, j - 1);
    mark(grid, i, j + 1);
}