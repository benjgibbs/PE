using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils
{
    public class PrimeSieve3 : IPrimeSieve
    {
        private SortedSet<long> primes;
        private long chunkSize;
        private long sievedTo;

        public PrimeSieve3(long chunkSize)
        {
            this.chunkSize = chunkSize;
            primes = new SortedSet<long>();
            primes.Add(2);
            sievedTo = 2;
            Sieve();
        }

        private void Sieve()
        {
            long upTo = (long)Math.Sqrt(sievedTo + chunkSize) + 1;
            bool[] sieve = new bool[chunkSize];
            var sieveLimit = sieve.LongLength + sievedTo;
            for (long p = 2; p < upTo; p++)
            {
                var sieveIdx = p-sievedTo;

                if(p <= sievedTo && primes.Contains(p) || p > sievedTo && !sieve[sieveIdx])
                {
                    //p is prime
                    var product = 2 * p;
                    while (product < sieveLimit)
                    {
                        if (product > sievedTo)
                        {
                            var productIdx = product - sievedTo;
                            sieve[productIdx] = true;
                        }
                        product += p;
                    }
                }
            }
            for(var i = 0L; i < sieve.LongLength; ++i)
            {
                if (!sieve[i])
                {
                    primes.Add(i + sievedTo);
                }
            }
            sievedTo = sieveLimit-1;
        }

        private static long FirstK(long i, long from)
        {
            var mod = from % i;
            return from - mod;
        }

        public bool IsPrime(long toCheck)
        {
            while (toCheck > sievedTo)
            {
                Sieve();
            }
            return primes.Contains(toCheck);
        }

        public long Size()
        {
            return primes.Count;
        }
    }
}
