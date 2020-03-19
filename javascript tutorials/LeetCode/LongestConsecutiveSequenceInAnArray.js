
LongestConsecutiveSequenceInAnArray([1, 9, 3, 10, 4, 20, 2]);

function LongestConsecutiveSequenceInAnArray(arr)
{
    var s = new Set();
    var maxLen = 0;
    for (var i = 0; i < arr.length; i++)
    {
        s.add(arr[i]);
    }

    for (var i = 0; i < arr.length; i++)
    {
        if (!s.has(arr[i] - 1 ))
        {
            var curr = arr[i];
            while (s.has(curr))
                curr++;
        
            if (maxLen < curr - arr[i])
                maxLen = curr - arr[i];
        }
    }
    console.log(maxLen);

}