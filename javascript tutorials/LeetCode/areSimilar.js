areSimilar([1, 2, 3], [2, 1, 3]);


    function areSimilar(a, b) 
    {
    
        if(a.toString() == b.toString())
        return true;
        var c = [];
        var d = [];
    
        for(var  i = 0 ; i < a.length; i++)
        {
            if(a[i]!= b[i])
            {
                c.push(a[i]);
                d.push(b[i]);
            }
        }
    
        d.reverse();
    
        if(c.length == 2 && c.toString() == d.toString())
        return true;
    
        return false;
    
    
    }