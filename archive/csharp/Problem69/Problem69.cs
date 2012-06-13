using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Diagnostics;
using Utils;

namespace Problem69
{
    class Problem69
    {
        private const long limit = 1000000L;
        private IPrimeSieve ps = new PrimeSieve(limit);

        private long Phi(long n)
        {
            return RelativelyPrime(n).Count<long>();
        }

        private List<long> PrimeFactors(long of)
        {
            List<long> l = new List<long>();
            for (var i = 0L; i <= of; ++i)
            {
                if (ps.IsPrime(i) && of % i == 0)
                    l.Add(i);
            }
            return l;
        }

        private List<long> RelativelyPrime(long with)
        {
            HashSet<long> factors = new HashSet<long>();
            foreach (var x in PrimeFactors(with))
            {
                var k = x;
                while (k <= with)
                {
                    factors.Add(k);
                    k += x;
                }
            }
            var result = new List<long>();
            for (var i = 1L; i < with; ++i)
            {
                if (!factors.Contains(i))
                {
                    result.Add(i);
                }
            }
            
            return result;
        }

        static void Main(string[] args)
        {
            Problem69 p = new Problem69();
            p.Test();
            p.run();
        }

        private void run()
        {
            Stopwatch sw = new Stopwatch();
            sw.Start();
            var max = 0d;
            for (var n = 2L; n < 1000000L; ++n)
            {
                var x = (double)n / Phi(n);
                if (x > max)
                {
                    max = x;
                    Console.WriteLine("New Max {0} obtained for n={1}.  Took {2} ms", max, n, sw.ElapsedMilliseconds);
                }
            }

        }

        #region Test

        private static Boolean Same(List<long> lhs, List<long> rhs)
        {
            return lhs.Union<long>(rhs).Count<long>() == lhs.Intersect<long>(rhs).Count<long>();
        }

        private void Test()
        {
            Trace.Assert(Same(PrimeFactors(10), new List<long> { 2, 5 }), "Failed on PrimeFactors(10)");
            Trace.Assert(Same(PrimeFactors(13), new List<long> { 13 }), "Failed on PrimeFactors(10)");
            Trace.Assert(Same(PrimeFactors(169), new List<long> { 13 }), "Failed on PrimeFactors(10)"); 
            
            foreach (var kv in new Dictionary<long, long> { { 2, 1 }, { 3, 2 }, { 4, 2 }, { 5, 4 }, { 6, 2 }, { 7, 6 }, { 8, 4 }, 
                { 9, 6 }, { 10, 4 } })
            {
                Trace.Assert(kv.Value == Phi(kv.Key), String.Format("Failed on {0}", kv.Key));
            }
        }
        #endregion
    }
}
