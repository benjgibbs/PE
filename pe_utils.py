
def factorial(upto):
    return reduce(lambda x,y:x*y,range(1,upto+1))

def extractDigits(number) :
    if number < 10 : return [number]
    x = extractDigits(number/10)
    x.append(number%10)
    return x

def primeSieve(upto):
    primes = []
    i = 1
    while i < upto+1:
        primes.append(i > 2)
        i += 1

    m = 2
    while m < upto:
        v = m
        while v < upto - m:
            v += m
            primes[v] = False
        m += 1
        while m < upto and primes[m] == False :
            m += 1
    return primes

def isPandigital(x) :
    x.sort()
    return x == range(1,10)



# Sanity checks
assert isPandigital(extractDigits(123456789))
assert factorial(9) == 362880
assert isPandigital([1,2,3,4,5,6,7,8,9])
assert isPandigital([1,5,3,4,2,6,7,8,9])
assert isPandigital(range(1,10))
assert not isPandigital(range(1,2))
assert primeSieve(100) ==  [False, False, True, True, False, True, False, True, False, False, False, True, False, True, False, False, False, True, False, True, False, False, False, True, False, False, False, False, False, True, False, True, False, False, False, False, False, True, False, False, False, True, False, True, False, False, False, True, False, False, False, False, False, True, False, False, False, False, False, True, False, True, False, False, False, False, False, True, False, False, False, True, False, True, False, False, False, False, False, True, False, False, False, True, False, False, False, False, False, True, False, False, False, False, False, False, False, True, False, False]
