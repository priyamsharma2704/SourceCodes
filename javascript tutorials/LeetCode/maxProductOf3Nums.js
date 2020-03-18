var arr = [1, -4, 3, -6, 7, 0];
var max = findMaxProduct(arr);
console.log(max);

function findMaxProduct(arr)
{
  var max1 = -10000;
  var max2 = -10000;
  var max3 = -10000;

  var min1 = 10000;
  var min2 = 10000;

  for(var i = 0 ; i < arr.length; i++)
  {
    if(arr[i] > max1)
    {
      max3 = max2;
      max2 = max1;
      max1 = arr[i];
    }
    else if(arr[i] > max2)
    {
      max3 = max2;
      max2 = arr[i];
    }
    else if(arr[i] > max3)
      max3 = arr[i];
    
    if(arr[i] < min1)
    {
      min2 = min1;
      min1 = arr[i];
    }
    else if(arr[i] < min2)
      min2 = arr[i];
  }

  return Math.max((max1 * max2 * max3), (max1 * min1 * min2));
}