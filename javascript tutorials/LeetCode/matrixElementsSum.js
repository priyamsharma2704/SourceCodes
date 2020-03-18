console.log(matrixElementsSum([[0,1,1,2], 
  [0,5,0,0], 
  [2,0,3,3]]));

  function matrixElementsSum(matrix) 
  {
      var m = {};
      var r = matrix.length;
      var c = matrix[0].length;
      var sum = 0;
      var a = [];
  
      for(var i = 0 ; i < r; i++)
      {
          for(var j = 0 ; j < c; j++)
          {
              if(matrix[i][j] == 0)
                  //m[j] = 0;
                  a.push(j);
              else if(a.indexOf(j) == -1)
              {
                  sum += matrix[i][j];
              }
          }
  
      }
  
      return sum;
  }
  