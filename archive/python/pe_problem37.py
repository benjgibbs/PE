import pe_utils
import math

def truncateRight(x):
    return int(x / 10)

def truncateLeft(x):
    mag = 10 ** (math.ceil(math.log(x+1,10))-1)
    return int(x % mag)
    
assert 1234 == truncateRight(12345)
assert 2345 == truncateLeft(12345)

def allPrimesTrunc(x, primes, func, t):
    while x > 0:
        if not primes[x]:
            return False
        t += [x]
        x = func(x)
    return True

def pe_problem37():
    print "starting"
    max = 1000000
    primes = pe_utils.primeSieve(max)
    truncatablePrimes = []
    for i in range(9,max):
        if primes[i] :
            toRemove = []
            if allPrimesTrunc(i, primes, truncateRight, toRemove) and \
                    allPrimesTrunc(i, primes, truncateLeft,toRemove) :
                #for k in toRemove:
                    #while truncatablePrimes.count(k) > 0:
                    #    truncatablePrimes.remove(k)
                truncatablePrimes += [i]
            list
    print "done"
    print truncatablePrimes
    print reduce(lambda x,y:x+y, truncatablePrimes)

#primes = pe_utils.primeSieve(100000)
#print allPrimesTrunc(3797, primes, truncateRight)
#print allPrimesTrunc(3797, primes, truncateLeft)

pe_problem37()
