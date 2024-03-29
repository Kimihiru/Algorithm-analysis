package bfs;
import java.util.*;
public class Solution {
	public static int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int depth=1;
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			for(int i=0;i<q.size();i++) {
				TreeNode cur=q.poll();
				if(cur.left==null&&cur.right==null) {
					return depth;
				}
				if(cur.left!=null) {
					q.offer(cur.left);
				}
				if(cur.right!=null) {
					q.offer(cur.right);
				}
			}
			depth++;
		}
		return depth;
	}
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root==null) {
			return false;
		}
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		Queue<Integer> q1=new LinkedList<Integer>();
		q.offer(root);
		q1.offer(root.val);
		while(!q.isEmpty()) {
			for(int i=0;i<q.size();i++) {
				TreeNode cur=q.poll();
				int temp=q1.poll();
				if(cur.left==null&&cur.right==null) {
					if(temp==targetSum) {
						return true;
					}
				}
				if(cur.left!=null) {
					q.offer(cur.left);
					q1.offer(cur.left.val+temp);
				}
				if(cur.right!=null) {
					q.offer(cur.right);
					q1.offer(cur.right.val+temp);
				}
			}
		}
		return false;
	}

}