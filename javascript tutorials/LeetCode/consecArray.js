console.log(makeArrayConsecutive2([4, 2, 7, 18]))

function makeArrayConsecutive2(statues) 
{
    var s = statues;

    s = s.sort((a, b) => a - b);
    //console.log(s);
    var c = 0;
    for(i = 1; i < s.length; i++)
    {
        var diff = s[i] - s[i-1];

        if(diff > 1)
            c += (diff -1);
    }
    return c;
}
