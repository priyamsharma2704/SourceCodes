var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

var k = 3;

findMaxOfEachSubArray(nums, k);


function findMaxOfEachSubArray(nums, k)
{
    var deq = [];

    for (i = 0; i < k; i++)
    {
        while (deq.length != 0 && nums[deq[deq.length - 1]] <= nums[i])
            deq.shift();
        
        deq.push(i);
    }

    for (i = k; i < nums.length; i++)
    {
        console.log(nums[deq[0]]);

        while (deq.length != 0 && deq[0] < (i - k))
        {
            deq.shift();
        }

        while (deq.length != 0 && nums[deq[deq.length - 1]] <= nums[i])
            deq.shift();
        
        deq.push(i);
    }

    console.log(nums[deq[0]]);
}