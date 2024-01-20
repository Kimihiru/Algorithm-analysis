package backtrack;

import java.util.*;

public class Permute {
	public static List<List<Integer>> permute(int nums[]){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		List<Integer> output=new ArrayList<Integer>();
		int n=nums.length;
		for(int i=0;i<n;i++) {
			output.add(nums[i]);
		}
		backtrack(ans,output,0,n);
		return ans;
	}
	public static void backtrack(List<List<Integer>> ans,List<Integer> output,int t,int n) {
		if(t==n) {
			ans.add(new ArrayList<Integer>(output));
		}
		else {
			for(int i=t;i<n;i++) {
				Collections.swap(output, t, i);
				backtrack(ans,output,t+1,n);
				Collections.swap(output, t, i);
			}
		}
	}
	/*
	 *  排列树
	 * 递归回溯
	 * Collections.swap的使用
	 * 用于list的交换
	 */
	/*
	 * class Collections
	@SuppressWarnings({"rawtypes", "unchecked"})
    public static void swap(List<?> list, int i, int j) {
        // 这里不使用原始类型，而是可以捕获
        // 通配符，但它需要调用补充
        // private method
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }
    */
	public static void main(String[] args) {
		int nums[]= {1,1,1};
		List<List<Integer>> n=permute(nums);
		System.out.println(n);
		System.out.println(n.size());
	}
}