var arr = [1,2,3,4,5,6];

console.log(rotateArray(arr, 2));

function rotateArray(arr, k)
{
  var len = arr.length;

  for(var i = 0 ; i < k; i++)
  {
    var temp = arr[0];
    for(var j = 0 ; j < len - 1; j++)
    {
      arr[j] = arr[j+1];
    }

    arr[j] = temp;
}
  return arr;
}

