using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils
{
    public class PrimeSieve : Utils.IPrimeSieve
    {
        /*
         * To Try:
         * 1. Don't keep copying arrays of primes, just keep adding them.
         * 2. Don't store the array, just store the primes themselves.
         * 
         */
        private bool[] notPrimes;

        public PrimeSieve(long upTo)
        {
            bool[] p = new bool[upTo];
            p[0] = p[1] = true;
            PopulateSieveFrom(p);
            notPrimes = p;
        }

        private static void PopulateSieveFrom(bool[] sieve, long from = 2)
        {
            long upTo = (long)Math.Sqrt(sieve.LongLength) + 1;
            for (long i = 2; i < upTo; i++)
            {
                if (!sieve[i])
                {
                    var k = (i < from) ? FirstK(i,from): 2*i;
                    while (k < sieve.LongLength)
                    {
                        sieve[k] = true;
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
            long newLength = checked(notPrimes.LongLength*2);
            var newPrimes = new bool[newLength];
            Array.Copy(notPrimes, newPrimes, notPrimes.LongLength);
            PopulateSieveFrom(newPrimes, notPrimes.LongLength);
            notPrimes = newPrimes;
        }

        public bool IsPrime(long toCheck)
        {
            if (toCheck < Size())
            {
                return !notPrimes[toCheck];
            }
            GrowSieve();
            return IsPrime(toCheck);
        }

        public long Size()
        {
           return notPrimes.LongLength;
        }
    }
}
