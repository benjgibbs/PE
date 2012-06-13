using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils
{
    public class PrimeSieve2 : IPrimeSieve
    {
        private GrowableArray<bool> primes;

        public PrimeSieve2(long upTo)
        {
            primes = new GrowableArray<bool>(upTo);
            primes.Set(0, true);
            primes.Set(1, true);
            PopulateSieveFrom(primes);
        }

        private static void PopulateSieveFrom(GrowableArray<bool> sieve, long from = 2)
        {
            long upTo = (long)Math.Sqrt(sieve.LongLength) + 1;
            for (long i = 2; i < upTo; i++)
            {
                if (!sieve.Get(i))
                {
                    var k = (i < from) ? FirstK(i, from) : 2 * i;
                    while (k < sieve.LongLength)
                    {
                        sieve.Set(k,true);
                        k += i;
                    }
                }
            }
        }

        private static long FirstK(long i, long from)
        {
            var mod = from % i;
            return from - mod;
        }

        public void GrowSieve()
        {
            long from = primes.LongLength;
            primes.AddChunk();
            PopulateSieveFrom(primes, from);
        }

        public bool IsPrime(long toCheck)
        {
            while ((Size()-1) < toCheck)
            {
                GrowSieve();
            }
            return !primes.Get(toCheck);
        }

        public long Size()
        {
            return primes.LongLength;
        }
    }
}
