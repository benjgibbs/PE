#include "sieve.h"
#include <set>

#define BOOST_TEST_DYN_LINK
#define BOOST_TEST_MODULE Sieve test
#define BOOST_TEST_MAIN

#include <boost/test/unit_test.hpp>

BOOST_AUTO_TEST_CASE(check_is_prime)
{
  int sieveSz = 100;
  Sieve sieve(sieveSz);
  int primes[] = { 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,
                    53,59,61,67,71,73,79,83,89,97 };
  int numPrimes = sizeof(primes)/sizeof(*primes);
  std::set<int> primeSet(primes,primes+numPrimes); 
  for (int i = 0; i <= sieveSz; i++) {
    if (primeSet.find(i) == primeSet.end()) {
      BOOST_CHECK( !sieve.isPrime(i) );
    } else {
      BOOST_CHECK( sieve.isPrime(i) );
    }
  }
}

