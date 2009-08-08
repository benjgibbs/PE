
decimal = "."

print "building string"

for i in range(1, 1000001):
    decimal += str(i)

product = 1

for j in range(7):
    x = decimal[10**j]
    print "multiplying by: " + str(10**j)
    product *= int(x)

print product
