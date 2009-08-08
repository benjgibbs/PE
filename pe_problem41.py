import pe_utils
import math

def all_perms(str):
      if len(str) <=1:
          yield str
      else:
          for perm in all_perms(str[1:]):
              for i in range(len(perm)+1):
                  yield perm[:i] + str[0:1] + perm[i:]

def isPrime(x):
    for a in range(2, int(math.sqrt(x))+1):
        if x%a == 0:
            return False
    return True

biggest = 1


print "Starting"
for a in all_perms("7654321"):
    t = int(a)
    if isPrime(t):
        if t > biggest:
            print t
            biggest = t
print "Done"
