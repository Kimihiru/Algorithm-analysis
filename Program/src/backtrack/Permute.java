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
	 *  ������
	 * �ݹ����
	 * Collections.swap��ʹ��
	 * ����list�Ľ���
	 */
	/*
	 * class Collections
	@SuppressWarnings({"rawtypes", "unchecked"})
    public static void swap(List<?> list, int i, int j) {
        // ���ﲻʹ��ԭʼ���ͣ����ǿ��Բ���
        // ͨ�����������Ҫ���ò���
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