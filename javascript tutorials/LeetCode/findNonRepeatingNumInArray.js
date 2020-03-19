
findNonRepeatingNum([1, 2, 1, 2, 2, 3, 3]);

function findNonRepeatingNum(arr)
{
    // var repeatCounterMap = {};
    // for (var i = 0; i < arr.length; i++)
    // {
    //     if (!repeatCounterMap[arr[i]])
    //     {
    //         repeatCounterMap[arr[i]] = 1;
    //     }
    //     else
    //     {
    //         repeatCounterMap[arr[i]] = repeatCounterMap[arr[i]] + 1;
    //     }
    // }

    // var found = false;
    // for (var i = 0; i < arr.length; i++)
    // {
    //     if (repeatCounterMap[arr[i]] == 1)
    //     {
    //         found = true;
    //         console.log(arr[i]);
    //     }
    // }

    // if (found == false)
    //     console.log("No repeating nums");

    var repeatCounterMap = {};
    for (var i = 0; i < arr.length; i++)
    {
        if (!repeatCounterMap[arr[i]])
        {
            repeatCounterMap[arr[i]] = 1;
        }
        else
        {
            //repeatCounterMap[arr[i]] = repeatCounterMap[arr[i]]  + 1;
            delete repeatCounterMap[arr[i]];
        }
    }

    console.log((repeatCounterMap));
}