import pe_utils


def pe_problem52():
    print "Starting"
    for i in range(1,1000000):

        d = pe_utils.extractDigits(i)
        d.sort()
        ok = True

        for j in range(2,7):
            e = pe_utils.extractDigits(j*i)
            e.sort()
            if d != e:
                ok = False
                break
        if ok:
            print "Result: " + str(i)
            break

    print "Done"


pe_problem52()
