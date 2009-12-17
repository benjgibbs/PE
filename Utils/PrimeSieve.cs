using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils
{
    public class PrimeSieve
    {
        /*
         * To Try:
         * 1. Don't keep copying arrays of primes, just keep adding them.
         * 2. Don't store the array, just store the primes themselves.
         * 
         */
        private bool[] primes;

        public PrimeSieve(long upTo)
        {
            primes = new bool[upTo];
            PopulateSieveFrom(primes);
        }

        private static void PopulateSieveFrom(bool[] sieve, long from = 2)
        {
            for (var i = from; i < sieve.LongLength; ++i)
            {
                sieve[i] = true;
            }

            for (long i = 2; i < Math.Sqrt(sieve.LongLength); i++)
            {
                if (sieve[i])
                {
                    var k = (i < from) ? FirstK(i,from): 2*i;
                    while (k < sieve.LongLength)
                    {
                        sieve[k] = false;
                        k += i;
                    }
                }
            }
        }

        private static long FirstK(long i, long from)
        {
            var mod = from % i;
            return from  - mod;
        }

        public void GrowSieve()
        {
            long newLength = checked(primes.LongLength*2);
            var newPrimes = new bool[newLength];
            Array.Copy(primes, newPrimes, primes.LongLength);
            PopulateSieveFrom(newPrimes, primes.LongLength);
            primes = newPrimes;
        }

        public bool IsPrime(ulong toCheck)
        {
            if(toCheck < (ulong)primes.LongLength)
                return primes[toCheck];
            GrowSieve();
            return IsPrime(toCheck);
        }

        public long Size()
        {
            return primes.LongLength;
        }
    }
}
