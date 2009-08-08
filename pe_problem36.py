def isPalindromic(x):
    for i in range(0, len(x)/2):
        if x[i] != x[-(i+1)]:
            return False
    return True


def baseN(num,b):
  return ((num == 0) and  "0" ) or \
      ( baseN(num // b, b).lstrip("0") + \
            "0123456789abcdefghijklmnopqrstuvwxyz"[num % b])

max = 1000000
sum = 0
for i in range(1, max):
    if isPalindromic(str(i)) and isPalindromic(baseN(i,2)):
        print str(i) + ":" + baseN(i,2)
        sum += i

print "Sum: " + str(sum)
        

assert isPalindromic(str(585))
assert isPalindromic(str(100010001))
assert isPalindromic(str(10000001))
assert not isPalindromic(str(10001001))
assert isPalindromic(str(10011001))
assert isPalindromic(baseN(585,2))
