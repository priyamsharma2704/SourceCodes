def shapeArea(n):
    sum = 1
    for i in range(n):
        sum = sum + (1 * 4 * i)
    
    return sum

print(shapeArea(1))