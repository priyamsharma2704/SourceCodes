allLongestStrings(["aba", 
"aa", 
"ad", 
"vcd", 
"aba"]);

function allLongestStrings(inputArray) 
{
  var max = 0;
  for(var  i = 0 ; i < inputArray.length; i++)
  {
      if(max < inputArray[i].length)
          max = inputArray[i].length;

  }

  var res = [];
  for(var i = 0 ; i < inputArray.length; i++)
  {
      if(inputArray[i].length == max)
          res.push(inputArray[i]);
  }

  return res;



}
