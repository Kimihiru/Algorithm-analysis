package backtrack;
import java.util.*;
public class PermuteUnique {
	public static List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> ans=new ArrayList<List<Integer>>(); 
		List<Integer> output=new ArrayList<Integer>();
		Arrays.sort(nums);
		int n=nums.length;
		boolean[] vis=new boolean[n];
		backtrack(ans,output,0,nums,vis);
		return ans;
	}
	public static void backtrack(List<List<Integer>> ans,List<Integer> output,int t,int[] nums,boolean[] vis) {
		int n=nums.length;
		if(t==n) {
			ans.add(new ArrayList<Integer>(output));
		}
		else {
			for(int i=0;i<n;i++) {
				if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))  {
					continue;
				}
				output.add(nums[i]);
				vis[i]=true;
				backtrack(ans,output,t+1,nums,vis);
				vis[i]=false;
				output.remove(t);
			}
		}
	}
	public static void main(String[] args) {
		int[] nums= {1,2,1};
		List<List<Integer>> n=permuteUnique(nums);
		System.out.println(n);
		System.out.println(n.size());
	}
}