var mat = [
  [1,2,3],
  [4,5,6],
  [7,8,9]
];

console.log(rotate(mat));
function rotate (matrix) 
{
  for(var i = 0 ; i < matrix[0].length; i++)
  {
      for(var j = i ; j < matrix[0].length; j++)
          {
              var temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
  }
  
  for(var i = 0 ; i < matrix[0].length; i++)
      {
          for(var j = 0; j <matrix[0].length/2; j++)
          {
              var temp = matrix[i][j];          
              matrix[i][j] =  matrix[i][matrix[i].length-j-1];
              matrix[i][matrix[i].length-j-1] = temp;
          }
      }
    
    return matrix;
};