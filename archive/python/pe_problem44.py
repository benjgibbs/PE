

def pentagonal(n):
    return n*(3*n-1)/2

def isPentagonal(t):
#    3n^2-n-2t = 0
    a = (1+math.sqrt(1+4*3*2*t))/6
    return a == int(a)

print "Starting"

n = 1
found = False
while True:
    p = pentagonal(n)
    for m in range(1,n):
        q = pentagonal(m)
        if isPentagonal(p+q) and isPentagonal(abs(p-q)):
            print abs(q-p)
            found = True
    if found:
        break
    n+=1
