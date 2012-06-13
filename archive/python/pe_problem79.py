fh = open('./keylog.txt')
l =   fh.read().split('\n')
fh.close()
l.sort()
m = set(l)
m.remove('')

#It has at least 8 digits.
kob = {}
for x in m:
    if not kob.has_key(int(x[0])):
        kob[int(x[0])] = []

    kob[int(x[0])].append(int(x[1]))
    kob[int(x[0])].append(int(x[2]))

    if not kob.has_key(int(x[1])):
        kob[int(x[1])] = []
    kob[int(x[1])].append(int(x[2]))

for x in m:
    for y in x:
        if not  kob.has_key(int(y)):
            kob[int(y)] = [0]


y = map(lambda x: (len(set(kob[x])),x), kob)
y.sort()
y.reverse()

print reduce(lambda a,b: str(a)+str(b), map(lambda x: x[1],y))
