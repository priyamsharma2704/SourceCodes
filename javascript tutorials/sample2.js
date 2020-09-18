var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

var k = 3;

findMaxOfEachSubArray(nums, k);


function findMaxOfEachSubArray(nums, k)
{
    var deq = [];

    //add 3 elems
    for (var i = 0; i < k; i++)
    {
        while (deq.length != 0 && nums[deq[deq.length - 1]] <= nums[i])
            deq.pop();
        
        deq.push(i);
    }
    //next window
    //check if the deq elem are outside the window 
    // if yes, then remove them

    for (var i = k; i < nums.length; i++)
    {
        console.log(nums[deq[0]]);
        
        while (deq.length != 0 && nums[0] < i - k)
            deq.shift();
        
        while (deq.length != 0 && nums[deq[deq.length - 1]] <= nums[i])
            deq.pop();
        
        deq.push(i);
        
    }
console.log(nums[deq[0]]);
}