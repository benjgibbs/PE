
def fact(x) : 
    if x < 2 : return 1
    return x*fact(x-1) 

def createFactMap(maxFact):
    factMap = {0:1}
    for i in range(maxFact) :
        factMap[i] = fact(i)
    return factMap

def getDigits(i) :
    d = []
    while i > 0 :
        d += [i % 10]
        i = i // 10
    return d

def factSumOfDigits(i, facts):
    d = getDigits(i)
    factSum = 0
    for f in d:
        factSum += facts[f]
    return factSum

def findSum(factMap, upperBound):
    factSum = 0
    for i in range(3,upperBound):
        if factSumOfDigits(i, factMap) == i: 
            factSum += i
    return factSum

print "Fact sum is: " + str(findSum(createFactMap(10), 100000))
