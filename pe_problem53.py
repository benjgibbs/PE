
import pe_utils

def ncr(n,r):
    return pe_utils.factorial(n)/(utils.factorial(r)*utils.factorial(n-r))


c = 0

for n in range(1,101):
    for r in range(1,n):
        if ncr(n,r) > 1000000:
            print n,r
            c+=1

print "Done"
print c
