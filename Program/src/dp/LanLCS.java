package dp;
import java.util.*;
public class LanLCS {
	public static List<String> mySubString(String s){
		List<String> list=new ArrayList<String>();
		int n=s.length();
		int beginIndex=0;
		for(int i=0;i<n;i++) {
			if(s.charAt(i)<=90&&i!=0) {
				list.add(s.substring(beginIndex, i));
				beginIndex=i;
			}
			if(i==n-1) {
				list.add(s.substring(beginIndex, i+1));
			}
		}
		return list;
	}
	public static int LCS(String s1,String s2) {
		List<String> list1=mySubString(s1);
		List<String> list2=mySubString(s2);
		int[][] dp=new int[list1.size()+1][list2.size()+1];
		for(int i=1;i<dp.length;i++) {
			dp[i][0]=0;
		}
		for(int i=1;i<dp[0].length;i++) {
			dp[0][i]=0;
		}
		for(int i=1;i<=list1.size();i++) {
			for(int j=1;j<=list2.size();j++) {
				if(list1.get(i-1).equals(list2.get(j-1))) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[list1.size()][list2.size()];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println(LCS(s1,s2));
		sc.close();
	}
}