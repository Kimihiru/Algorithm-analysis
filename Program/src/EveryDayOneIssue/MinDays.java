//分治+记忆化搜索
package EveryDayOneIssue;
import java.util.*;
public class MinDays {
	public static Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	public static int minDays(int n) {
		if(n<=1) {
			return 1;
		}
		if(map.containsKey(n)) {//记忆化搜索
			return map.get(n);
		}
		/*
		 * //分治,n%3 和 n%2表示minDays(n-1)
		 * minDays(n/2) 或 minDays(n/3)表示分治
		 * 1表示第一天,加回去.
		 */
		map.put(n, Math.min(n%2+minDays(n/2)+1, n%3+minDays(n/3)+1));
		return map.get(n);
	}
	public static void main(String[] args) {
		int n=9;
		System.out.println(minDays(n));
	}
}
