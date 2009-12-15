using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Problem92
{
    class Problem92
    {
        static void Main(string[] args)
        {
            //var max = 10000000;
            var max = 10000000;
            var numGoingTo89 = 0;
            Console.WriteLine("Square & Sum 2: {0}", SquareAndSum(2));
            Console.WriteLine("Square & Sum 30: {0}", SquareAndSum(3));
            Console.WriteLine("Square & Sum 3001: {0}", SquareAndSum(3001));
            Console.WriteLine("44 GoesTo89? [false]: {0}", GoesTo89(44));
            Console.WriteLine("85 GoesTo89? [true]: {0}", GoesTo89(85));

            for (var i = 1; i < max; ++i)
            {
                if (GoesTo89(i))
                    numGoingTo89++;
            }
            Console.WriteLine("Num going to 89 is: {0}", numGoingTo89);
        }

        private static bool GoesTo89(int i)
        {
            while (true)
            {
                if (i == 1 || i == 89)
                    break;
                 i = SquareAndSum(i); 
            }
            return i == 89;
        }

        private static int SquareAndSum(int i)
        {
            var result = 0;

            while (i != 0)
            {
                var v = i % 10;
                result += v * v;
                i = i / 10;
            }

            return result;
        }
    }
}
