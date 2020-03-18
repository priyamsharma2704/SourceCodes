find([1,2,3,3,3,5]);

function find(arr)
{
  var len = arr.length;
  var numMap = {};

  for(var i = 0 ; i < len; i++)
  {
    if(!numMap[arr[i]])
      numMap[arr[i]] = 1;
    else
    numMap[arr[i]] = numMap[arr[i]] + 1;
  }

  var max = 0;
  for(var i = 0 ; i < len; i++)
  {
    var currVal = numMap[arr[i]];
    if(currVal > max)
      max = arr[i];
  }

  console.log(max);
}