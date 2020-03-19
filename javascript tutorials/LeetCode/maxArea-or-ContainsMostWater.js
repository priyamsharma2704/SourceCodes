maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]);

function maxArea(arr)
{
    var i = 0;
    var j = arr.length - 1;

    var max_area = 0;
    while (i < j)
    {
        var area = Math.min(arr[i], arr[j]) * (j - i);

        if (arr[i] < arr[j])
            i++;
        else
            j--;
        
        if (area > max_area)
            max_area = area;
    }

    console.log(max_area);
}