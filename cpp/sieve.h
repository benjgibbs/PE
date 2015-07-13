#ifndef SIEVE_CPP
#define SIEVE_CPP

#include <vector>

class Sieve {
  public:
    explicit Sieve(long upto);
    bool isPrime(long x) const;
  private:
    long size;
    std::vector<bool> sieve;
};

#endif
