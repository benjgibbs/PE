using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Problem59
{
    class Problem59
    {
        static void Main(string[] args)
        {
            string code = File.ReadAllText("cipher1.txt");
            int[] encoded = ToInt(code.Split(','));

            var bestCount = 0;

            for (int i = 'a'; i < 'z'; ++i)
            {
                for (int j = 'a'; j < 'z'; ++j)
                {
                    for (int k = 'a'; k < 'z'; ++k)
                    {
                        var attempt = Decode(encoded, new[] { i, j, k });
                        var count = NumAllowedChars(attempt);
                        if ( count > bestCount)
                        {
                            var key = String.Format("{0}{1}{2}", (char)i, (char)j, (char)k);
                            bestCount = count;
                            Console.WriteLine("With key \"{0}\" the message is: \"{1}\"\nSum: {2}", key, attempt,Sum(attempt));
                        }
                    }
                }
            }
        }

        private static int Sum(string attempt)
        {
            var result = 0;
            foreach (var c in attempt)
                result += (int)c;
            return result;
        }

        private static int[] ToInt(string[] p)
        {
            List<int> result = new List<int>(p.Length);
            foreach(var c in p)
                result.Add(int.Parse(c));

            return result.ToArray();
        }

        private static int NumAllowedChars(string attempt)
        {
            var result = 0;
            foreach (var c in attempt)
            {
                if (c == ' ' || c == '.' || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                    result++;
            }
            return result;
        }

        private static string Decode(int[] encoded, int[] key)
        {
            StringBuilder builder = new StringBuilder(encoded.Length);
            for (var i = 0; i < encoded.Length; i += key.Length)
            {
                for (var j = 0; j < key.Length; ++j)
                {
                    var idx = i + j;
                    if (idx >= encoded.Length)
                        break;
                    var asciiVal = (int)encoded[idx] ^ (int)key[j];
                    builder.Append((char)asciiVal);
                }
            }
            return builder.ToString();
        }
    }
}
