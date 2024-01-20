package ac;

import java.util.*;

public class Main {
	public static boolean isIncrease(int n) {
		int[] arr=new int[String.valueOf(n).length()];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int) (n/Math.pow(10, arr.length-i-1))%10;
		}
		for(int x=0;x<arr.length;x++) {
			for(int y=x+1;y<arr.length;y++) {
				if(arr[x]>arr[y]) {
					return false;
				}
			}
		}
		return true;
	}
	public static int monotoneIncreasingDigits(int n) {
		if(n<=9) {
			return n;
		}
		if(n==10) {
			return 9;
		}
		int ans=0;
		for(int i=n;i>10;i--) {
			if(isIncrease(i)) {
				ans=i;
				break;
			}
		}
		return ans;
	}
	public static int mySqrt(int x) {
		int ans=-1;
		int l=0,r=x;
		while(l<=r) {
			int mid=(l+r)/2;
			if((long)mid*mid<=x) {
				ans=mid;
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		return ans;
	}
	public static int count=0;
	public static int[] x= {1,2,3,4,5,6,7,8,9};
	public static void backtrack(int t) {
		int a=x[0]+x[1]+x[3]+x[5];
		int b=x[0]+x[2]+x[4]+x[8];
		int c=x[5]+x[6]+x[7]+x[8];
		if(t==8) {
			if(a==b&&b==c&&a==c) {
				count++;
			}
		}
		for(int i=t;i<9;i++) {
			int temp=x[t];
			x[t]=x[i];
			x[i]=temp;
			backtrack(t+1);
			int tmp=x[t];
			x[t]=x[i];
			x[i]=tmp;
		}
	}
	public static int gcd(int m,int n) {
		while(n!=0) {
			int r=m%n;
			m=n;
			n=r;
		}
		return m;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//backtrack(0);
		//System.out.println(count/6);
//		int n=20190324;
//		int[] dp=new int[n+1];
//		dp[0]=0;dp[1]=1;dp[2]=1;dp[3]=1;
//		for(int i=4;i<=n;i++) {
//			dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%10000;
//		}
//		System.out.println(dp[n]%10000);
		
		int n=5;
		int[] x= {2,6,4,10,20};
		Arrays.sort(x);
		int d=0;
		for(int i=0;i<n;i++) {
			d=gcd(d,x[i]-x[0]);
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int i=x[0];i<=x[n-1];i+=d) {
			list.add(i);
		}
		System.out.println(list.size());
		long m=0;
		for(long i=1;i<1000000007;i++) {
			if((i*2021)%1000000007==999999999) {
				m=i;
				break;
			}
		}
		System.out.println(m);
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2000);
        calendar.set(Calendar.MONTH,Calendar.MAY);
        calendar.set(Calendar.DATE,4);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		sc.close();
	}
}