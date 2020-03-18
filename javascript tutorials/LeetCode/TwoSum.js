var r = twoSum([3,2,4], 6);
console.log(r);


function twoSum(nums, target) 
{
    // var tempArray = [];
    // for(i = 0 ; i < nums.length;i++)
    //     {
    //         if(nums[i] <= target)
    //             tempArray.push(nums[i]);
    //     }
    
    // var res = [];
    // for(var j = 0; j < tempArray.length; j++)
    //     {
    //         var otherNum = target - tempArray[j];

    //         if(otherNum == tempArray[j] && tempArray.length != 2)
    //           continue;

    //         if(tempArray.indexOf(otherNum)!= -1)
    //             {
    //                 res.push(j);
    //                 res.push(tempArray.indexOf(otherNum));
    //                 return res;
    //             }
    //     }
    // return res;

    const comp = {};
    for(let i=0; i<nums.length; i++)
    {
        if(comp[nums[i] ]>=0)
        {
            return [ comp[nums[i] ] , i]
        }
        comp[target-nums[i]] = i
    }
};

