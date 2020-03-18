/*
Given an array of n unique integers where each element in the array is in range [1, n]. The array has all distinct elements and size of array is (n-2). Hence Two numbers from the range are missing from this array. Find the two missing numbers.

Examples :

Input  : arr[] = {1, 3, 5, 6}
Output : 2 4

Input : arr[] = {1, 2, 4}
Output : 3 5

Input : arr[] = {1, 2}
Output : 3 4
*/

findNums([1, 3, 5, 6] , 6);

function findNums(arr, n)
{
  var sumOfArray = 0;
  for(var i = 0 ; i < arr.length;i++)
  {
    sumOfArray += arr[i];
  }
  //sum of missing nums = sum of first n nums - sum of array elems
  var sumOfMissingNums = ((n * (n + 1))/2) - sumOfArray;
  var avgOfMissingNums = sumOfMissingNums/2;


  var sumOfLowerHalf = 0;
//sum of arr elems upto avg
  for(var i = 0 ; i < arr.length; i++)
  {
    if(arr[i] <= avgOfMissingNums)
      sumOfLowerHalf += arr[i];
  }

  //sum of first avg nums
  var sumOfAvg = (avgOfMissingNums * (avgOfMissingNums + 1)) / 2;

  var firstNum = sumOfAvg - sumOfLowerHalf;

  console.log(firstNum);
  console.log(sumOfMissingNums - firstNum);

}