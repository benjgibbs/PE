
tollerance = 10e-10

def cancelsIncorrectly(num,den):
    a = num % 10
    b = num / 10
    x = den % 10
    y = den / 10
    if a == b : return 0
    if (a != 0 and x != 0 and a == y):
        return abs(((num + 0.0) / den) -  ((b + 0.0) / x)) < tollerance
    if (b!=0 and y != 0 and  b == x):
        return abs(((num + 0.0) / den) - ((a + 0.0) / y)) < tollerance
    return 0


assert cancelsIncorrectly(49, 98)

numprod = 1.0
denprod = 1.0
print "Begin.."
for num in range(10, 50): 
    for den in range(10, 100):
        if cancelsIncorrectly( num, den):            
            numprod *= num
            denprod *= den
            print str(num) + "/" + str(den)


print str(numprod ) + "/" + str(denprod)
print "...End."
