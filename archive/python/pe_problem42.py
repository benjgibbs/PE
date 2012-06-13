
def triangles(upto):
    return map(lambda x: 0.5*x*(x+1), range(1,upto+1))

assert triangles(10) == [1, 3, 6, 10, 15, 21, 28, 36, 45, 55]

def getWords():
    return open('./words.txt').read().replace("\"","").split(",")

def sumOfWord(x):
    return sum(map(lambda y:(ord(y) - ord('A') + 1), x)) 


def pe_problem42():
    
    f = getWords()
    t = triangles(3*26)
    triangleCount = 0
    for i in map(lambda x: sumOfWord(x), f):
        if t.count(i) > 0:
            triangleCount += 1
    print "Num triangles: " + str(triangleCount)

print "start"
pe_problem42()
