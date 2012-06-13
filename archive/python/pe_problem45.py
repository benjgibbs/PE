import math
import time

def triangles(upto):
    return map(lambda x: 0.5*x*(x+1), range(1,upto+1))

def pentagons(upto):
    return map(lambda x: 0.5*x*(3*x-1), range(1,upto+1))

def hexagons(upto):
    return map(lambda x: x*(2*x-1), range(1,upto+1))

#too slow!
def pe_problem45():
    max = 25000
    t = triangles(3*max)
    p = pentagons(2*max)
    h = hexagons(max)

    return filter(lambda x: x in t,filter(lambda y: y in p,h))

def isPentagonal(p):
    x = (1+math.sqrt(1+24*p))/6
    return int(x) == x

def hexagonal(h):
    return h*(2*h-1)

def pe_problem45_a():
    found = 0
    x = 1
    result = []
    while found < 3:
        if isPentagonal(hexagonal(x)):
            result += [hexagonal(x)]
            found += 1
        x += 1
    return result

print "start"
t1 = time.clock()
#x = pe_problem45()
x = pe_problem45_a()
t2 = time.clock()
print x
print "end: took " + str(t2 - t1)


