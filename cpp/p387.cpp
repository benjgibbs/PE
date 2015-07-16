
#include <iostream>

using namespace std;

const long N = 10000;
long s[N+1];

long isHarshad(long n) {
  long sum = 0;
  long m = n;
  while(m > 0) {
    sum += m %10;
    m = m/10;
  }
  return n % sum == 0  ? sum :  0;
}

bool isTruncatable(long n) {
  while(n > 0) {
    if(!isHarshad(n)) return false;
    n = n / 10;
  }
  return true;
}

bool isStrongHarshad(long n) {
  long h = isHarshad(n);
  if(!h) return false;
  return s[h] == 0;
}

int main(int argc, char** argv) {
  s[0] = s[1] = 1;
  for (long i = 2; i <= N; i++) {
    if (s[i] != 0) continue;
    for(long j = 2*i; j <= N; j += i) {
      s[j] = i;
    }
  }
  cout << "Sieve built." << endl;
  long sum = 0; 
  for(long i = 10; i < N; i++) {
    long truncated = i/10; 
    if (s[i] == 0 && isStrongHarshad(truncated) && isTruncatable(truncated)) {
      cout << "Adding: " << i << endl;
      sum += i;
    }
  }
  cout << "Sum: " << sum << endl;
}
