palindromeRearranging("aaabbcc");

function palindromeRearranging(inputString) 
{
    var len = inputString.length;

    if(len == 1)
        return true;

    var charMap = {}
    for(var  i = 0 ; i < len; i++)
    {
        if(!charMap[inputString[i]])
            charMap[inputString[i]] = 1;
        else
            charMap[inputString[i]] = charMap[inputString[i]] + 1;
    }

    if(len % 2 == 0)
    {
        //even len
        for(var i = 0 ; i < len ; i++)
        {
            if(charMap[inputString[i]] % 2 != 0)
                return false;
        }
        return true;
    }
    else
    {
        //odd len
        var c = 0;
        for(var i = 0 ; i < len ; i++)
        {
            if(charMap[inputString[i]] % 2 != 0)
                c = c + 1;
        }

        if(c > 1)
            return false;
        else    
            return true;
    }

}