using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils;

namespace Problem58
{
    public class Problem58
    {
        static IEnumerable<ulong> DiagonalVals()
        {
            var cur = 1U;
            var inc = 2U;
            var cycle = 1;
            while (true)
            {
                yield return cur;
                cur += inc;
                if (cycle == 4)
                {
                    inc += 2;
                    cycle = 1;
                }
                else
                {
                    cycle += 1;
                }
            }
        }

        static void Main(string[] args)
        {
            PrimeSieve ps = new PrimeSieve(100000000);
            var diagonalsTaken = 0;
            var primes = 0;
            var lastRatio = 1.0;
            foreach (var dv in DiagonalVals())
            {
                diagonalsTaken++;
                if (ps.IsPrime(dv))
                {
                    primes++;
                }

                var ratio = ((float)primes / (float)diagonalsTaken);

                if (diagonalsTaken % 4 == 0)
                {
                    if (ratio < lastRatio)
                    {
                        Console.WriteLine("New ratio {0} at {1}. [Primes: {2}]", ratio, (float)diagonalsTaken / 4.0, ps.Size());
                        lastRatio = ratio;
                    }
                    if (ratio < 0.1)
                    {
                        break;
                    }
                }
            }
            Console.WriteLine("Diagonals Taken: {0}, Primes: {1}", diagonalsTaken, primes);
            var loops = diagonalsTaken / 4;
            Console.WriteLine("Loops: {0}, Length Of Side {1}", loops, 1 + 2*loops);
        }
    }
}
