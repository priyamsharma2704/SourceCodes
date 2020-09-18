def makeArrayConsec(statues):
    statues.sort()
    c = 0
    leng = len(statues)
    for i in range(1, leng):
        diff = statues[i] - statues[i-1]
        
        if diff > 1:
            c = c + (diff - 1)

    return c

print(makeArrayConsec([6,2,3,8]))