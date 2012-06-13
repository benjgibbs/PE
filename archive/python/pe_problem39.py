
import math

createSquare = lambda: map(lambda x: x**2, range(1,int(1000/2)))

squares = createSquare()
numSquare = len(squares)
sums = {}

for i in range(numSquare):
    for j in range(i,numSquare):
        for k in range(j,numSquare):
            if squares[k] == squares[i] + squares[j]:
                s = i+j+k+3
                if s == 120:
                    print i+1,j+1,k+1
                if sums.has_key(s):
                    sums[s] += 1
                else:
                    sums[s] = 1                    

biggest = 0
for x,y in sums.iteritems():
    if y > biggest:
        biggest = y
        print x,y
