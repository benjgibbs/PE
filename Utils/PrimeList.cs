using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Utils
{
    public class PrimeList
    {
        public static IEnumerable<ulong> Primes()
        {
            List<ulong> soFar = new List<ulong>();
            while (true)
            {
                switch (soFar.Count)
                {
                    case 0:
                        soFar.Add(2);
                        break;
                    case 1: //Special cae for the only even prime
                        soFar.Add(3);
                        break;
                    default:
                        FindNextPrime(soFar);
                        break;
                }
                yield return soFar.Last();
            }
        }

        private static void FindNextPrime(List<ulong> soFar)
        {
            var k = soFar.Last() + 2;
            bool foundNext = false;
            while (!foundNext)
            {
                if (HasFactor(soFar, k))
                {
                    k += 1;
                }
                else
                {
                    foundNext = true;
                    soFar.Add(k);
                }
            }
        }

        private static bool HasFactor(List<ulong> soFar, ulong k)
        {
            foreach (var x in soFar)
            {
                if (k % x == 0)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
