var a1 = [2,4,5,7,8,9];
var a2 = [4,6,7,8,9,13];
var a3 = [4, 5, 6, 8, 16, 21];

findCommonElements(a1, a2, a3);


function findCommonElements(a1, a2, a3)
{
    var res = [];
    var x = 0, y = 0, z = 0;

    while (x < a1.length && y < a2.length && z < a3.length)
    {
        if (a1[x] == a2[y] && a2[y] == a3[z] && a1[x] == a3[z])
        {
            res.push(a1[x]);
            x++; y++; z++;
        }
        else if (a1[x] < a2[y])
            x++;
        else if (a2[y] < a3[z])
            y++;
        else
            z++;
    }

    console.log(res);
}