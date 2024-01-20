package ac;

import java.util.*;

public class Prime {
	public static boolean isPrime(int x) {
		for(int i=2;i*i<=x;i++) {
			if(x%i==0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isContainsTwoOrFour(int x) {
		while(x!=0) {
			if(x%10==2||x%10==4) {
				return false;
			}
			x/=10;
		}
		return true;
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=2;i<100000;i++) {
			if(isPrime(i)) {
				list.add(i);
			}
		}
		System.out.println(list.get(2018));
		String str="WHERETHEREISAWILLTHEREISAWAY";
		char[] a=str.toCharArray();
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(String.valueOf(a[i]));
		}
		int ans=0;
		for(int i=1;i<=2019/3;i++) {
			if(isContainsTwoOrFour(i)) {
				for(int j=i+1;j<=2019/2;j++) {
					int k=2019-i-j;
					ans+=isContainsTwoOrFour(j)&&isContainsTwoOrFour(k)&&k>j? 1:0;
				}
			}
			
		}
		System.out.println();
		System.out.println(ans);
		int count=0;
		for(int i=1;i<=2019;i++) {
			for(int j=1;j<=2019;j++) {
				int k=2019-i-j;
				count+=k>j&&j>i&&isContainsTwoOrFour(i)&&isContainsTwoOrFour(j)&&isContainsTwoOrFour(k)? 1:0;
			}
			
		}
		System.out.println(count);
	}

}