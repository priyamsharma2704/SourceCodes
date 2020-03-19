var mat = [[1,1, 1, 1], [0, 1, 1,1], [1, 1, 1, 1]];

find(mat);
function find(mat)
{
    var cache = mat;
    var result = 0;
    for (i = 0; i < mat.length; i++)    //rows
    {
        for (var j = 0; j < mat[0].length; j++)    //cols
        {
            if (i == 0 || j == 0)
            {
                continue;
            }
            else if (mat[i][j] != 0)
            {
                cache[i][j] = 1 + Math.min(cache[i-1][j-1],cache[i][j-1], cache[i-1][j])
            }

            if (cache[i][j] > result)
                result = cache[i][j];
        }
    }

    console.log(result);
}