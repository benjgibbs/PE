import pe_utils

def digitAt(number, at) :
    if at == 1  : return number % 10
    return digitAt(number/10,at-1)

    
products = []
max = 2000L

for i in range(1,max) :
    for j in range(1,500) :
        x = i * j
        t = []
        for k in [i, j, x] :
            t.extend(pe_utils.extractDigits(k))
        if pe_utils.isPandigital(t) :
            print "i: " + str(i) + ", j: " + str(j) + ", i*j: " + str(x)
            products.append(x)

print products
uniq = set(products)
print uniq
val = 0L
for x in uniq :
    val += x

print "Total: " + str(val)

for i in range(1,8) :
    assert 8-i == digitAt(1234567, i)
