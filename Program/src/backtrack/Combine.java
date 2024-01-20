package backtrack;

import java.util.*;

public class Combine {
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> ans=new ArrayList<List<Integer>>(); 
		List<Integer> output=new ArrayList<Integer>();
		int nums[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			nums[i]=i;
		}
		backtrack(ans,output,nums,1,k);
		return ans;
	}
	public static void backtrack(List<List<Integer>> ans,List<Integer> output,int nums[],int t,int k) {
		if(output.size()==k) {
			ans.add(new ArrayList<Integer>(output));
		}
		else {
			for(int i=t;i<nums.length;i++) {
				output.add(nums[i]);
				backtrack(ans,output,nums,i+1,k);
				output.remove(output.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		int n=4;
		int k=2;
		List<List<Integer>> c=combine(n,k);
		System.out.println(c);
		System.out.println(c.size());
	}
}