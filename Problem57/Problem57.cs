using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Utils;

namespace Problem57
{
    
    class Problem57
    {
        private static bool Matches(Fraction f)
        {
            return f.NumeratorDigits() > f.DenominatorDigits();
        }
        
        static void Main(string[] args)
        {
            Console.WriteLine(FindThem().Count());        
        }

        static IEnumerable<Fraction> FindThem()
        {
            foreach(Fraction f in Sequence(new Fraction(3,2)).Take(1000))
            {
                if (Matches(f))
                {
                    yield return f;
                }
            }
        }

        static IEnumerable<Fraction> Sequence(Fraction f)
        {
            while (true)
            {
                Fraction result = new Fraction(1) + new Fraction(1, (new Fraction(1) + f));
                yield return result;
                f = result;
            }
        }
    }
}
