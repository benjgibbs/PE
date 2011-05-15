using System;
namespace Utils
{
    public interface IPrimeSieve
    {
        bool IsPrime(long toCheck);
        long Size();
    }
}
