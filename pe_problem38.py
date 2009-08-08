def isPandigital(x):
    k = []
    for y in x:
        while y > 0:
            k.append(y % 10)
            y = y / 10
    k.sort()
    return k == range(1,10)

print "Starting"
for x in range(1,10000):
    for k in range(1,5):
        t = []
        for n in range(1,k):
            t.append(n*x)
        
        if isPandigital(t):
            print t

print "End"
