using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils;
using System.Diagnostics;

namespace Problem58
{
    public class Problem58
    {
        static IEnumerable<long> DiagonalVals()
        {
            var cur = 1U;
            var inc = 2U;
            var cycle = 0;
            while (true)
            {
                yield return cur;
                cur += inc;
                if (cycle == 3)
                {
                    inc += 2;
                    cycle = 0;
                }
                else
                {
                    cycle += 1;
                }
            }
        }

        static void Main(string[] args)
        {
            Stopwatch sw = new Stopwatch();
            sw.Start();

            PrimeSieve3 ps = new PrimeSieve3(1024*1024);
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

                if (diagonalsTaken == 1)
                {
                    continue;
                }

                if ((diagonalsTaken-1) % 4 == 0)
                {
                    var ratio = ((float)primes / (float)diagonalsTaken);
                    if (ratio < lastRatio)
                    {
                        lastRatio = ratio;
                    }
                    if (ratio < 0.1)
                    {
                        break;
                    }
                }
            }
            sw.Stop();

            Console.WriteLine("Diagonals Taken: {0}, Primes: {1}, Took: {2}", diagonalsTaken, primes, sw.ElapsedMilliseconds);
            var loops = diagonalsTaken / 4;
            Console.WriteLine("Loops: {0}, Length Of Side {1}", loops, 1 + 2*loops);
        }
    }
}
