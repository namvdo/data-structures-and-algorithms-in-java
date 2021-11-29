package textprocessing;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
	public static int findBruteForce(char[] str, char[] pattern) {
		int m = str.length;
		int n = pattern.length;
		for(int i = 0; i <= m - n; i++) {
			int k = 0;
			while (k < n && str[i + k] == pattern[k]) {
				k++;
			}
			if (k == n) {
				return i;
			}
		}
		return -1;
	}

	// this algorithm compare from the last character in the pattern instead of the first character and moving backwards.
	// if pattern character a mismatches with text character b, if b doesn't occur in anywhere of the pattern, then shift the pattern completely past b.
	// otherwise, shift the pattern to align b with the last occurrence of b in the pattern.
	// O(nm)
	public static int findBoyerMoore(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		if (m == 0) return 0;
		Map<Character, Integer> last = new HashMap<>();
		for (char c : text) {
			last.put(c, -1);
		}
		for (int i = 0; i < m; i++) {
			last.put(pattern[i], i);
		}
		int i = m - 1;
		int k = m - 1;
		while (i < n) {
			if (text[i] == pattern[k]) {
				if (k == 0) return i;
				k--;
				i--;
			} else {
				i += m - Math.min(k, 1 + last.get(text[i]));
				k = m - 1;
			}
		}
		return -1;
	}

	// O(n + m)
	public static int findKMP(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		if (m == 0) return 0;
		int[] fail = computeFailKMP(pattern);
		int j = 0;
		int k = 0;
		while (j < n) {
			if (text[j] == pattern[k]) {
				if (k == m - 1) return j - m + 1;
				j++;
				k++;
			} else if (k > 0) {
				k = fail[k - 1];
			} else {
				j++;
			}
		}
		return -1;
	}

	private static int[] computeFailKMP(char[] pattern) {
		int m = pattern.length;
		int[] fail = new int[m];
		int j = 1;
		int k = 0;
		while (j < m) {
			if (pattern[j] == pattern[k]) {
				fail[j] = k + 1;
				j++;
				k++;
			} else if (k > 0) {
				k = fail[k - 1];
			} else {
				j++;
			}
		}
		return fail;
	}
}
