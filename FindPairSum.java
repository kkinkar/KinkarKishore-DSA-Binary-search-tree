package com.greatlearning.SumOfBinarySearchTree;
import java.util.*;
public class FindPairSum {

		static class Node {
			int data;
			Node left, right;
		}

		static Node NewNode(int data) {
			Node temp = new Node();
			temp.data = data;
			temp.left = null;
			temp.right = null;
			return temp;
		}

		public Node insert(Node root, int key) {
			if (root == null)
				return NewNode(key);
			if (key < root.data)
				root.left = insert(root.left, key);
			else
				root.right = insert(root.right, key);
			return root;
		}

		public static boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
			if (root == null)
				return false;

			if (findPairUtil(root.left, sum, set))
				return true;

			if (set.contains(sum - root.data)) {
				System.out.println("Pair is found ("+ (sum - root.data) + ", "+ root.data + ")");
				return true;
			}
			else
				set.add(root.data);

			return findPairUtil(root.right, sum, set);
		}

		public void findPair(Node root, int sum) {
			HashSet<Integer> set = new HashSet<Integer>();
			if (!findPairUtil(root, sum, set))
				System.out.print("Pairs do not exit"+ "\n");
		}

		
		public static void main(String[] args) {
			
			Node root = null;
			FindPairSum obj = new FindPairSum();
			root = obj.insert(root, 40);
			root = obj.insert(root, 20);
			root = obj.insert(root, 60);
			root = obj.insert(root, 10);
			root = obj.insert(root, 30);
			root = obj.insert(root, 50);
			root = obj.insert(root, 70);

			int sum = 60;
			obj.findPair(root, sum);
		}
}
	

