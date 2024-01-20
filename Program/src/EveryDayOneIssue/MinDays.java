//����+���仯����
package EveryDayOneIssue;
import java.util.*;
public class MinDays {
	public static Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	public static int minDays(int n) {
		if(n<=1) {
			return 1;
		}
		if(map.containsKey(n)) {//���仯����
			return map.get(n);
		}
		/*
		 * //����,n%3 �� n%2��ʾminDays(n-1)
		 * minDays(n/2) �� minDays(n/3)��ʾ����
		 * 1��ʾ��һ��,�ӻ�ȥ.
		 */
		map.put(n, Math.min(n%2+minDays(n/2)+1, n%3+minDays(n/3)+1));
		return map.get(n);
	}
	public static void main(String[] args) {
		int n=9;
		System.out.println(minDays(n));
	}
}
