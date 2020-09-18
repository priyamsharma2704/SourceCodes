# Given a ticket number n, determine if it's lucky or not.

# Example

# For n = 1230, the output should be
# isLucky(n) = true;
# For n = 239017, the output should be
# isLucky(n) = false.


def isLucky(n):
    s = str(n)
    print(s)
    
  

    mid = len(s)//2
    print(mid)
    x= sum(map(int,s[:mid]))
    y = sum(map(int,s[mid:]))
    
    print(x, y)
    
    return x==y

isLucky(1230)