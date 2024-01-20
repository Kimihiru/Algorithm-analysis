package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NSum {
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> ans=new ArrayList<List<Integer>>(); 
		List<Integer> output=new ArrayList<Integer>();
		boolean[] vis=new boolean[nums.length];
		backtrack(ans,output,0,nums,vis,3);
		return ans;
	}
	public static void backtrack(List<List<Integer>> ans,List<Integer> output,int t,int[] nums,boolean[] vis,int length) {
		if(output.size()==length&&output.get(0)+output.get(1)+output.get(2)==0) {//列表读取值通过get方法获取下标读取
			Collections.sort(output);//排序去重
			if(!ans.contains(output)) {//去除已经添加的解
				ans.add(new ArrayList<Integer>(output));
			}
		}
		else {
			for(int i=0;i<nums.length;i++) {
				if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))  {
					continue;
				}
				output.add(nums[i]);
				vis[i]=true;
				backtrack(ans,output,t+1,nums,vis,3);
				vis[i]=false;
				output.remove(t);
			}
		}
	}
	public static void main(String[] args) {
		int[] nums= {-1,0,1,2,-1,-4};
		List<List<Integer>> ans=threeSum(nums);
		System.out.println(ans);
		System.out.println(ans.size());
	}
}