package backtrack;
import java.util.*;
public class Subsets {
	public static List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		List<Integer> output=new ArrayList<Integer>();
		Arrays.sort(nums);
		boolean[] vis=new boolean[nums.length];
		backtrack(ans,output,0,nums,vis);
		return ans;
	}
	public static void backtrack(List<List<Integer>> ans,List<Integer> output,int t,int[] nums,boolean[] vis) {
		int n=nums.length;
		ans.add(new ArrayList<Integer>(output));
		if(t>n) {
			return;
		}
		else {
			for(int i=t;i<n;i++) {
				if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))  {
					continue;
				}
				output.add(nums[i]);
				vis[i]=true;
				backtrack(ans,output,i+1,nums,vis);//i+1,之前写的是t+1一直排查不出来问题的原因
				vis[i]=false;
				output.remove(output.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		List<List<Integer>> b=subsetsWithDup(nums);
		System.out.println(b);
		System.out.println(b.size());
	}
}