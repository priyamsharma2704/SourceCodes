var arr = [1, 0, 0, 1, 0, 1, 1];

find(arr);
function find(arr)
{
    var c = 0;
    var map = {};
    var sum = 0;

    for (var i = 0; i < arr.length; i++)
    {
        if (arr[i] == 0)
            arr[i] = -1;
        
        sum += arr[i];

        if (sum == 0)
            c++;
        
        if (map[sum])
        {
            c += map[sum];
            map[sum] = map[sum] + 1;
        }
        else
            map[sum] = 1;
    }

    console.log(c);
}