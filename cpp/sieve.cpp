#include "sieve.h"

Sieve::Sieve(long upto) 
  :  size(upto+1), sieve(size) {
  
  for (long i = 2; i < size; i++) {
    sieve[i] = true;
  }

  for (long i = 2; i < size; i++) {
    if (sieve[i]) {
      long j = 2 * i;
      while ( j < size) {
        sieve[j] = false;
        j += i;
      }
    }
  }
}

bool Sieve::isPrime(long x) const {
  return sieve.at(x);
}

