
move([0, 23, 0, 5, 0, 1, 17, 0]);

function move(arr)
{
    //-- approach 1 --
    // var newArr = [];

    // for (var i = 0; i < arr.length; i++)
    // {
    //     if (arr[i] != 0)
    //     {
    //         newArr.push(arr[i]);
    //     }
    // }

    // var lenDiff = arr.length - newArr.length;

    // for (var i = 0; i < lenDiff; i++)
    // {
    //     newArr.push(0);
    // }

    // console.log(newArr);

    //-- approach 2--

    // for (var i = 0; i < arr.length/2; i++)
    // {
    //     if (arr[i] == 0 && arr[arr.length - i - 1] != 0)
    //     {
    //         var temp = arr[i];
    //         arr[i] = arr[arr.length - i - 1];
    //         arr[arr.length - i - 1] = temp;
    //     }
    // }

    var i = 0;
    var j = arr.length - i - 1;
    var half = parseInt(arr.length /2)

    while (i < half)
    {
        if (i == half - 1)
        {
            var temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

        if (arr[i] == 0 && arr[j] != 0)
        {
            var temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        else if ((arr[i] != 0 && arr[j] == 0))
        {
            i++;
            j--;
        }
        else if ((arr[i] != 0 && arr[j] != 0))
        {
            i++;
        }
        else if (arr[i] == 0 && arr[j] == 0)
        {
            j--;
        }
        else
            i++;
    }
    console.log(arr);
}