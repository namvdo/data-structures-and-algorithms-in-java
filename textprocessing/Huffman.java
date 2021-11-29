package textprocessing;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class Huffman {
	private static final int R = 256;

	static final class Node implements Comparable<Node> {
		char letter;
		int freq;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return this.freq - o.freq;
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return Objects.hash(letter, freq, left, right);
		}

		Node(char letter, int freq, Node left, Node right) {
			this.letter = letter;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}
	}

	public static Node huffman(char[] letters) {
		int[] freq = new int[R];
		for (int i = 0; i < letters.length; i++) {
			freq[letters[i]]++;
		}
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for (char letter : letters) {
			Node node = new Node(letter, freq[letter], null, null);
			queue.add(node);
		}

		while (queue.size() > 1) {
			Node left = queue.poll();
			Node right = queue.poll();
			assert left != null;
			assert right != null;
			Node parent = new Node('\0', left.freq + right.freq, left, right);
			queue.add(parent);
		}
		return queue.poll();
	}

	public static void printEncodingHuffman(String text) {
		char[] letters = text.toCharArray();
		Node root = huffman(letters);
		String[] st = new String[R];
		buildCode(st, root, "");
		for(int i = 0; i < letters.length; i++) {
			String code = st[letters[i]];
			for(int j = 0; j < code.length(); j++) {
				System.out.print(code.charAt(j));
			}
		}
	}

	private static void buildCode(String[] st, Node x, String s) {
		if (!x.isLeaf()) {
			buildCode(st, x.left, s + '0');
			buildCode(st, x.right, s + '1');
		} else {
			st[x.letter] = s;
		}
	}

	public static void main(String[] args) {
		printEncodingHuffman("ABRACADABRA!");
	}

}
