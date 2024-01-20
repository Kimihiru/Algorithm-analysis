package dp;
import java.util.Scanner;
public class GraphPath {
	public static int gcd(int m,int n) {
		while(n!=0) {
			int r=m%n;
			m=n;
			n=r;
		}
		return m;
	}
	public static int length(int m,int n) {
		int a=gcd(m,n);
		return (m*n)/a;
	}
	public static boolean isHave(int m,int n) {
		return Math.abs(m-n)<=21? true:false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ans=new int[2022];
		ans[1]=0;
		for(int i=2;i<=2021;i++) {
			ans[i]=Integer.MAX_VALUE;
		}
		for(int i=1;i<=2020;i++) {
			for(int j=i+1;j<=2021;j++) {
				if(isHave(i,j)) {
					//¶¯Ì¬ËÑË÷×î¶ÌÂ·¾¶
					ans[j]=Math.min(ans[j], ans[i]+length(i,j));
				}
			}
		}
		System.out.println(ans[2021]);
		sc.close();
	}
}