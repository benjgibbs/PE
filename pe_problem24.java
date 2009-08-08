
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem24 {

	private final static int sz = 10;
	private final int[] test = new int[sz];

	public static void main(String[] args) {
		Problem24 p = new Problem24();
		p.print();
		long start = System.currentTimeMillis();
		p.find(1000000);
		long end = System.currentTimeMillis();
		p.print();
		System.out.println("Found result: in " + (end - start)
				+ " millis.");
	}

	public void print() {
		for (int t : test) {
			System.out.print(t);
		}
		System.out.println();
	}

	public Problem24() {
		for (int i = 0; i < sz; ++i)
			test[i] = i;
	}

	private void find(final int times) {
		int i = start();
		int cnt = 1;
		while (cnt < times) {
			int nextIdx = next(i);
			if (test[i] > test[nextIdx]) {
				List<Integer> reordered = new ArrayList<Integer>();

				for (int j = start(); j > nextIdx; --j)
					reordered.add(test[j]);

				Collections.sort(reordered);
				int tmp = test[nextIdx];

				int z = 0;
				while (reordered.get(z) < test[nextIdx] ) {
					++z;
				}

				test[nextIdx] = reordered.get(z);
				reordered.set(z, tmp);

				Collections.sort(reordered);
				for (int j : reordered) {
					test[i] = j;
					i = prev(i);
				}
				++cnt;
				i = start();
			} else {
				i = nextIdx;
			}
		}
	}

	private int next(int i) {
		return i - 1;
	}

	private int prev(int i) {
		return i + 1;
	}
	
	private int start() {
		return sz - 1;
	}
}

