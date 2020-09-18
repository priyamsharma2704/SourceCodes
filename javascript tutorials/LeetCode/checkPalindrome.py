


def checkPalin(str):
    leng = len(str)
    isPalin = True
    for i in range(leng):
        print(str[i])
        if str[i] != str[leng - 1 - i]:
            isPalin = False
        
    return isPalin



print(checkPalin("aabbaa"))