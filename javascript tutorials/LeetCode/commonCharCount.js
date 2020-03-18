commonCharacterCount("aabcc", "adcaa");

function commonCharacterCount(s1, s2) 
{
    var map1 = {};
    var map2 = {};

    for(i = 0 ; i < s1.length; i++)
    {
        if(!map1[s1[i]])
            map1[s1[i]] = 1
        else
            map1[s1[i]] = ++map1[s1[i]];
    }

    for(i = 0 ; i < s2.length; i++)
    {
        if(!map2[s2[i]])
            map2[s2[i]] = 1
        else
            map2[s2[i]] = ++map2[s2[i]];
    }

    var sum = 0;
    for(var k in map1)
    {
        var val1 = map1[k];
        if(map2[k])
        {
            var val2 = map2[k];
            sum += Math.min(val1,val2);    
        }
        else
            continue;
    }

    return sum;
}
