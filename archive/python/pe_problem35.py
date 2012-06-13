import pe_utils

def magnitude(i) :
    result = 0
    while i > 0:
        result += 1
        i = i / 10
    return result

def rotateNext(i, mag) :
    x = i % 10
    i = i / 10
    i = i + pow(10,mag-1)*x
    return i
    
def getRotations(i) : 
    mag = magnitude(i)
    rotations = []
    for x in range(1, mag):
        i = rotateNext(i, mag)
        rotations += [i]
    return rotations

print "starting..."
max = 1000000
primes = primeSieve(max)
cPrimeCount = 0
print "sieve built"
for i in range(2, max):
    if primes[i] :
        rotationsArePrime = True
        for j in getRotations(i):
            if not primes[j]:
                rotationsArePrime = False
                break
        if rotationsArePrime:
            print "Circular: " + str(i)
            cPrimeCount += 1

print "Number of circular primes: " + str(cPrimeCount)
print "fin."
