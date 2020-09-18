def matrixElementSum(matrix):
    sum = 0;
    for c in zip(*matrix):
        print(c)
        for r in c:
            if r == 0:
                break
            sum = sum + r
    
    return sum

print(matrixElementSum(
    [[0,1,1,2], 
    [0,5,0,0], 
    [2,0,3,3]]))