
#include <iostream>

using namespace std;

const int N = 10000;
long s[N+1];

long isHarshad(long n) {
  int sum = 0;
  int m = n;
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
  for (int i = 2; i <= N; i++) {
    if (s[i] != 0) continue;
    for(int j = 2*i; j <= N; j += i) {
      s[j] = i;
    }
  }
  int sum = 0; 
  for(int i = 100; i < N; i++) {
    if (s[i] == 0 && isStrongHarshad(i/10) && isTruncatable(i/10)) {
      cout << "Adding: " << i << endl;
      sum += i;
    }
  }
  cout << "Sum: " << sum << endl;
}
